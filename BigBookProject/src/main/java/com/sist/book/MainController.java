package com.sist.book;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.BookDAO;
import com.sist.dao.BookVO;
import com.sist.dao.BookisVO;
import com.sist.dao.BookiyVO;
import com.sist.dao.BookyjVO;
import com.sist.dao.ResultVO;
import com.sist.news.*;
import com.sist.r.MainRManager;

@Controller
public class MainController {
	@Autowired
	private BookNewsManager mgr;
	
	@Autowired
	private BookDAO dao;
	@Autowired
	private BookNewsDAO nDao;
	@Autowired
	private MainRManager mrm;
	//차트연습
		public void chartData(Model model)
		   {
			  List<String> list=dao.bookage();
			  String temp="[";
			  String temp2="[";
			  for(String age2:list){
				  int total=dao.bookTotal(age2);  
				  temp+=total+",";
				  temp2+="'"+age2+"',";
				 
			  }
			  temp=temp.substring(0, temp.lastIndexOf(","));
			  
			  temp+="]";
			  
			  temp2=temp2.substring(0, temp2.lastIndexOf(","));
			  
			  temp2+="]";
			  
			  System.out.println("temp : "+temp);
			  System.out.println("temp2 : "+temp2);
		
			  model.addAttribute("category",temp2);
			  model.addAttribute("total",temp);
			
			  
		   }
		public void chartData2(Model model)
		   {
			  List<String> list=dao.bookage();
			  String temp="[";
			  String temp2="[";
			  for(String age2:list){
				  int total=dao.bookTotal2(age2);  
				  temp+=total+",";
				  temp2+="'"+age2+"',";
				 
			  }
			  temp=temp.substring(0, temp.lastIndexOf(","));
			  
			  temp+="]";
			  
			  temp2=temp2.substring(0, temp2.lastIndexOf(","));
			  
			  temp2+="]";
			  
			  System.out.println("wtemp : "+temp);
			  System.out.println("wtemp2 : "+temp2);
		
			  model.addAttribute("wcategory",temp2);
			  model.addAttribute("wtotal",temp);
			
			  
		   }
		
	@RequestMapping("main.do")
	public String main_page(String page,String title,Model model)
	
	{
		
		
		
		
		
		List<BookVO> mbdList=new ArrayList<BookVO>();
			List<BookVO> list=dao.mbookRankData();
			for(BookVO vo:list){
				mbdList.add(vo);
			
		}
			
			 if(title==null)
				   title="도서";
			   nDao.newsInsert(title);
			   
			   if(page==null)
			   {
				   page="1";
				  
			   }
			   int curpage=Integer.parseInt(page);
			   int totalpage=5; //데이터 50개
			   List<BookNewsVO> nlist=nDao.newsListData(curpage);
		List<BookVO> wbdList=new ArrayList<BookVO>();
		List<BookVO> wolist=dao.wbookRankData();
		for(BookVO vo2:wolist){
			wbdList.add(vo2);
		}
		
		model.addAttribute("wbdList",wbdList);
		model.addAttribute("mbdList",mbdList);
		model.addAttribute("totalpage",totalpage);
		   model.addAttribute("nlist",nlist);
		   model.addAttribute("curpage",curpage);
		   model.addAttribute("title",title);
		chartData(model);
		chartData2(model);
		return "main";
	}
	
	@RequestMapping("main_news.do")
	public String main_news(Model model)
	{
		 mgr.xmlSave("도서 베스트셀러");
		   List<BookNewsVO> nlist=mgr.newsAllData();
		   model.addAttribute("nlist",nlist);
		   mrm.newsGraph();
		   return "news";
	}

	
@RequestMapping("charts/charts.do")
	public String main_charts()
	{
		return "charts/charts";
	}
	
	@RequestMapping("tables/tables.do")
	public String main_tables()
	{
		return "tables/tables";
	}
	//주형 그래프
	@RequestMapping("charts/chartsjh.do")
	public String main_content(Model model){
		List<BookVO> mbdList=new ArrayList<BookVO>();
		List<BookVO> list=dao.mbookRankData();
		for(BookVO vo:list){
			mbdList.add(vo);
		
	}
	List<BookVO> wbdList=new ArrayList<BookVO>();
	List<BookVO> wolist=dao.wbookRankData();
	for(BookVO vo2:wolist){
		wbdList.add(vo2);
	}
	
	model.addAttribute("wbdList",wbdList);
	model.addAttribute("mbdList",mbdList);
		chartData(model);
		chartData2(model);
		return "charts/chartsjh";
	}
	//인영 그래프
	@RequestMapping("charts/chartsiy.do")
	public String charts(Model model)
	{
	   // 그래프
	 	String[] yearList = {"2018","2017","2016"};
		String[] str = {"[","[","[","[","[","[","[","[","[","[","[","["};
		for(int i=0;i<yearList.length;i++)
		{
			List<ResultVO> lists = dao.BookResultData(yearList[i]);
			for(ResultVO vo:lists)
			{
				str[i]+=vo.getLoan_count()+",";
			}
			str[i]=str[i].substring(0, str[i].lastIndexOf(","))+"]";
			model.addAttribute("data"+i,str[i]);
		}
		
		// 출력 데이터
		List<BookiyVO> bList = new ArrayList<BookiyVO>();
		for(int i=0;i<yearList.length;i++)
		{
			List<BookiyVO> list = dao.BookListData(yearList[i]);
			for(BookiyVO vo:list)
			{
				bList.add(vo);
			}				
		}
		model.addAttribute("bList",bList);
		
		return "charts/chartsiy";
	}
	//윤지 그래프
	@RequestMapping("charts/chartsyj.do")
	public String main_yjcharts(Model model) {
		String[] genre = { "종교", "역사", "언어", "문학", "예술", "기술과학" };
		
	   List<Integer> s1=dao.graphSum(genre[0]);
	   List<Integer> s2=dao.graphSum(genre[1]);
	   List<Integer> s3=dao.graphSum(genre[2]);
	   List<Integer> s4=dao.graphSum(genre[3]);
	   List<Integer> s5=dao.graphSum(genre[4]);
	   List<Integer> s6=dao.graphSum(genre[5]);
		   
	   String[] ss={"[","[","[","[","[","["};
	   for(int a=0;a<s1.size();a++)
	   {
		   ss[0]+=s1.get(a)+",";
		   ss[1]+=s2.get(a)+",";
		   ss[2]+=s3.get(a)+",";
		   ss[3]+=s4.get(a)+",";
		   ss[4]+=s5.get(a)+",";
		   ss[5]+=s6.get(a)+",";
	   }
	   for(int a=0;a<6;a++)
	   {
		   ss[a]=ss[a].substring(0, ss[a].lastIndexOf(","));
		   ss[a]+="]";
	   }
	   
	   for(int a=0;a<5;a++)
	   {
		   model.addAttribute("data"+a, ss[a]);
	   }
	   
	   
	   List<BookyjVO> cList=dao.tablebook();
	   model.addAttribute("cList", cList);
	   
		return "charts/chartsyj";
	}
	//이슬 그래프
	@RequestMapping("charts/chartsis")
	public String main_kisgraph(Model model)
	{
		
			/*String[] location = { "서울", "대전", "대구", "부산", "광주" };*/
			String[] year = { "2016", "2017", "2018"};
			
			   List<Integer> s1=dao.graphSumis(year[0]);
			   List<Integer> s2=dao.graphSumis(year[1]);
			   List<Integer> s3=dao.graphSumis(year[2]);
		
			   String[] ss={"[","[","["};
			   for(int a=0;a<s1.size();a++)
			   {
				   ss[0]+=s1.get(a)+",";
				   ss[1]+=s2.get(a)+",";
				   ss[2]+=s3.get(a)+",";
				
			   }
			   for(int a=0;a<3;a++)
			   {
				   ss[a]=ss[a].substring(0, ss[a].lastIndexOf(","));
				   ss[a]+="]";
			   }
			   
			   for(int a=0;a<3;a++)
			   {
				   model.addAttribute("data"+a, ss[a]);
			   }

			   
			 
				   List<BookisVO> blist=dao.BookSubjectData();

			   model.addAttribute("blist", blist);
			
			
		   
		
		return "charts/chartsis";
	}
		
}
