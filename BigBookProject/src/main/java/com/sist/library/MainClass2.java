package com.sist.library;

import java.io.FileReader;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class MainClass2 {
	@Autowired
	//private CrimeDAO dao;
	
	public static void main(String[] args) {
			//컨테이너에 등록된 클래스를 알려준다 (관리요청)
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");//메모리할당이 끝남 ==> DI
		
		MainClass2 mc = app.getBean("mainClass",MainClass2.class);
		
		try {
			StringBuffer sb=new StringBuffer();
			//sb.append() ==> 문자열 결합 (데이터가 많은 경우) +
			
			//한글이 포함돼서 2byte씩 읽어오는 파일리더 사용
			FileReader fr=new FileReader("/home/sist/data/abcd2.txt");
			/*
			 * 	FileReader  => 문자 스트림
			 *  FileInputStream => 바이트 스트림 (1byte)
			 */
			int i=0;
			// fr.read() : 한글자 == 데이터 값이 ASC
			while((i=fr.read())!=-1)
			{
				String s=String.valueOf((char)i);
				sb.append(s);
			}
			fr.close();
			//			System.out.println(sb.toString());
			String data=sb.toString();
			String[] bvideo=data.split("\n");
			// Insert into SCOTT.CRIMERATE (C_YEAR,C_GU,C_NAME,C_TYPE,C_COUNT) values (2016,'도봉','폭력','검거',1309);
			for(String ss:bvideo) //  한줄씩 읽기 시작
			{
				String in=ss.substring(ss.lastIndexOf("(")+1, ss.lastIndexOf(")"));
				in=in.replace("'", "");
				//System.out.println(in);
				StringTokenizer st=new StringTokenizer(in, ",");
				/*CrimeVO vo=new CrimeVO();
				vo.setC_year(Integer.parseInt(st.nextToken()));
				vo.setC_gu(st.nextToken());
				vo.setC_name(st.nextToken());
				vo.setC_type(st.nextToken());
				vo.setC_count(Integer.parseInt(st.nextToken()));
				mc.dao.crimeInsert(vo);*/
				
				//NO,SORTNO,SORTNAME,TITLE,REGDATE,YOUTUBEKEY,LENGTH,HIT
				/*BVideoVO vo=new BVideoVO();
				vo.setNo(Integer.parseInt(st.nextToken().trim())); //숫자는 트림으로 공백 자르는게 좋다
				vo.setSortno(Integer.parseInt(st.nextToken().trim()));
				vo.setSortname(st.nextToken());
				vo.setTitle(st.nextToken());
				vo.setRegdate(st.nextToken());
				vo.setKey(st.nextToken());
				vo.setLength(st.nextToken());
				vo.setHit(Integer.parseInt(st.nextToken().trim()));
				mc.dao.bvideoInsert(vo);*/
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}

