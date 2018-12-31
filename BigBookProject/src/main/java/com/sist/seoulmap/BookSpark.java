package com.sist.seoulmap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.springframework.stereotype.Component;

import scala.Tuple2;

import java.io.File;
import java.io.Serializable;
/*
 *   27 : PL/SQL (Produce,Trigger) => Mybatis (동적 쿼리)
 *   28 : Spring => Transaction,WebSocket
 *   2 : Spring security
 *   3 : Spring 정리 
 */
import java.util.*;

@Component
public class BookSpark implements Serializable { // 스파크는 부르는 위치와 실제로 생성되는 위치에서
													// Serializable을 생성해야된다
	public void book()
	{
		  try
		   {
			   SparkConf conf=new SparkConf().setAppName("bookFeel").setMaster("local[2]");
			   JavaSparkContext sc=new JavaSparkContext(conf);//
			   String[] feel = {"사랑","로맨스","매력","즐거움","스릴",
						"소름","긴장","공포","유머","웃음","개그",
						"행복","전율","경이","우울","절망","신비",
						"여운","희망","긴박","감동","감성","휴머니즘",
						"자극","재미","액션","반전","비극","미스테리",
						"판타지","꿈","설레임","흥미","풍경","일상",
						"순수","힐링","눈물","그리움","호러","충격","잔혹",
						"드라마","멜로","애정",
						"로맨스","모험","느와르","다큐멘터리",
						"코미디","범죄","SF","애니메이션"
				};
			   JavaRDD<String> files=sc.textFile("/home/sist/data/bookdetaile.txt");
			   // 파일 읽기,스트림을 이용 (실시간)
			   
			   // 단어분리=필요한 단어만 추출 
			   final Pattern[] p=new Pattern[feel.length];
			   for(int i=0;i<p.length;i++)
			   {
				   p[i]=Pattern.compile(feel[i]);// 단어 패턴 => contains()
				   /*
				    *   맛있는 맛있게 맛있고....
				    *   (맛있)|(맛없)[가-힣]+
				    *   (()()()()())
				    */
			   }
			final Matcher[] m=new Matcher[feel.length];
			//inner class=>익명의 클래스
			//상속이 없이 재정의할 경우에 사용 즉, 상속없이 재정의 할 수 있다.  POJO
			/*
			       Class A==> Thread ==> 멤버클래스
			       {
			        	class B
			        	{
			        	
			        	}
			       }
			 	
			 	   Class A
			 	   {
			 	       B b=new B()
			 	       {
			 	            public void display(){}  //맵리듀스 = 생성자에서 재정의 할 수 있다
			 	       }
			 	   }
			 	   Class B
			 	   {
			 	      public void display(){}
			 	   }
			 		
			 */
			JavaRDD<String> words=files.flatMap(new FlatMapFunction<String, String>() {

				@Override
				public Iterator<String> call(String s) throws Exception {
					List<String> list=new ArrayList<String>();//한줄한줄 단어를 모아준다
					for(int i=0; i<m.length; i++) //위에 feel에있는 단어가 포함되 있으면
					{
						m[i]=p[i].matcher(s);//찾은 단어를 m[i]번재가 가지고있다. p[i]에는 패턴이 들어가있다.
						if(m[i].find())
						{
							list.add(m[i].group()); //찾은 문자열을 가지고 들어오고 싶으면 .group()      //전체 괄호 값을 가져올땐 group()이거나 group(0)  부분은 1이상의 번호를 준다.   
							//만약 정규식(맛(있|없)[가-힣]+)이 들어가면 
						}
					}
					return list.iterator();
				}					
				
			/*
			 	@Override
				
					List<String> list=new ArrayList<String>();//한줄한줄 단어를 모아준다
					for(int i=0; i<m.length; i++) //위에 feel에있는 단어가 포함되 있으면
					{
						m[i]=p[i].matcher(s);//찾은 단어를 m[i]번재가 가지고있다. p[i]에는 패턴이 들어가있다.
						if(m[i].find())
						{
							list.add(m[i].group()); //찾은 문자열을 가지고 들어오고 싶으면 .group()      //전체 괄호 값을 가져올땐 group()이거나 group(0)  부분은 1이상의 번호를 준다.   
							//만약 정규식(맛(있|없)[가-힣]+)이 들어가면 
						}
					}
					return list;
				}					
			 */
			
			});
			//추출한 단어를 1씩 부여 ==>Mapper
			JavaPairRDD<String , Integer> counts=words.mapToPair(new PairFunction<String, String, Integer>() {

	@Override
	public Tuple2<String, Integer> call(String s) throws Exception {
		// TODO Auto-generated method stub
		return new Tuple2<String, Integer>(s, 1);
	}});

	// 같은 단어끼리 묶어서 누적!시킨다
	JavaPairRDD<String, Integer> reduce=counts.reduceByKey(new Function2<Integer,Integer,Integer>(){

	@Override public Integer call(Integer sum,Integer i)throws Exception{
	// TODO Auto-generated method stub
	return sum+i;}});
	// 파읽로 저장하거나 하둡에 저장한다
	File dir=new File("/home/sist/data/output");

	if(dir.exists()) // 존재한다면
	{
		File[] fs = dir.listFiles(); // 존재 한다면 안쪽에 있는 파일을 다 가져온다
		for (File f : fs) {
			f.delete();
		}
		dir.delete();
	}

	reduce.saveAsTextFile("/home/sist/data/output");//
	sc.close();// 이게 있어야 값이 바뀐다~
	}catch(
	Exception e)
	{
		e.printStackTrace();
	}
}}
