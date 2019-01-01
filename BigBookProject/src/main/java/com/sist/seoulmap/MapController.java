package com.sist.seoulmap;


import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.seoulmap.*;

import com.univocity.parsers.annotations.Replace;


@Controller
public class MapController implements Serializable{  // 메모리 입출력을 위한 Serializable
	@Autowired
	private BookjiDAO bDao;
	@Autowired
	private BookDetaileManager bm;
	@Autowired
	private BookSpark bs;
	@Autowired
	private RManager r;
   
	
	@RequestMapping("location/map.do")
	public String location_loc(String gu, Model model) {
		commonData(model);
		
		
		String[] guList_1 = {"전체","강서구", "양천구", "구로구", "마포구", "영등포구", "금천구", "은평구", "서대문구", "동작구", "관악구", "종로구", "중구",
				"용산구", "서초구", "강북구", "성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구", "강동구" };
		if (gu == null)
			gu = "13";
		String[] guList = new String[26];
		for (int i = 1; i <= 25; i++) {
			if (gu.equals(Integer.toString(i))) {
				guList[i] = "../image/map/gu_" + i + "_on.png";
			} else {
				guList[i] = "../image/map/gu_" + i + "_off.png";
			}
		}
		model.addAttribute("guList", guList);
		//commonData(model);

		String[] c_name={ "0","6","8","20","30","40","50","60"}; //0,6,8,20,30,40,50,60
	   String[] str={"[","[","[","[","[","[","[","["};	
	   System.out.println("c_name[length] :"+c_name.length+"\n"+"str[length] : "+str.length);	   
		for (int i = 0; i < c_name.length; i++) {
			List<BookjiVO> list = bDao.locationBookData(guList_1[Integer.parseInt(gu)], c_name[i]);
			
			for (BookjiVO vo : list) {
				str[i] += vo.getLoan_count() + ",";
			}

			str[i] = str[i].substring(0, str[i].lastIndexOf(",")) + "]";

			System.out.println("str["+i+" "+ c_name[i] + " " + guList_1[Integer.parseInt(gu)] + "] : " + str[i]);
			model.addAttribute("data"+i, str[i]); // data0 ,data1, data2
													// ~~~.... data4 length만큼!!
			System.out.println("===================================================");
		}
	   
	   //상세목록 (목록 5개를 한번에 모아서 출력)
	   List<BookjiVO> cList=new ArrayList<BookjiVO>();
	   for(int i=0;i<c_name.length;i++)
	   {
		   List<BookjiVO> list=bDao.locationOneData(guList_1[Integer.parseInt(gu)], c_name[i]);
		   for(BookjiVO vo:list)
		   {
			   cList.add(vo);
		   }
		   
	   }
	   model.addAttribute("cList", cList);
	   
	   return "location/map";
   }
	
	//공통사용(상단 데이터 그래프(화면이 바뀔때마다 실행해줘야 그래프가 보인당))
		public void commonData(Model model)
		{
			List<String> list=bDao.bookLocation(); //crimeDAO
			String temp="[";		
			String temp2="[";
			for(String loc:list)
			{
				int total=bDao.bookLocTotal(loc);
				temp+=total+",";
				temp2+="'"+loc+"',"; 
				
			}
			temp=temp.substring(0, temp.lastIndexOf(","));
			temp+="]";
			temp2=temp2.substring(0, temp2.lastIndexOf(",")); //맨 마지막에 '',가 나오기떄문에 ,이상부터 지운다.
			temp2+="]"; //그리리고 ]를 붙인다
			/*System.out.println(temp);
			System.out.println(temp2);*/
			
			model.addAttribute("category", temp2);
			model.addAttribute("total", temp);		
		}
	
	@RequestMapping("detailebook/detailebook.do")
	public String detailebook_detailebook(String bookname,Model model)
	{	
		bm.bookReplyData(bookname); //xml파일저장   //MovieManager.java
		bm.xmlParseData(); //xml을 가지고 txt파일로 저장    //MovieManager.java
		bs.book(); //저장된 txt파일을 분석		     //MovieSpark.java
		r.bookGraph2();
		BookjiVO bvo=bDao.DetailBookData(bookname);
		try {
			File dir=new File("/home/sist/data/output");
			File[] files = dir.listFiles();
			int count=0;
			for(File file:files)
			{
				String name=file.getName();
				if(name.startsWith("part-"))
				{
					count++;
				}
			}
			
			String data="";
			for(int i=0; i<count; i++)
			{
				FileReader fr=new FileReader("/home/sist/data/output/part-0000"+i);
				int k=0;
				while((k=fr.read())!=-1)
				{
					data+=String.valueOf((char)k);
				}
				fr.close();
			}
			System.out.println(data);
			
			String[] feel=data.split("\n");
			List<BookFeelVO> list=new ArrayList<BookFeelVO>();
			for(String s:feel)
			{
				s=s.substring(s.indexOf("(")+1, s.lastIndexOf(")"));
				// (드라마,2)에서 ()를 없앤다
				StringTokenizer st=new StringTokenizer(s, ",");
				BookFeelVO vo=new BookFeelVO();
				vo.setFeel(st.nextToken());
				vo.setCount(Integer.parseInt(st.nextToken()));
				list.add(vo);
			}
			model.addAttribute("list", list);
			model.addAttribute("bvo", bvo);
			model.addAttribute("bookname", bookname);
		} catch (Exception e) {}
		
		return "detailebook/detailebook";//분석한 결과를 jsp에 뿌려서 시각화 해준다.
	}
}



  
		
		   
		   
