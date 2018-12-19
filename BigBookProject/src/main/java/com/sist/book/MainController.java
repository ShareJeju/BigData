package com.sist.book;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.news.*;

@Controller
public class MainController {
	@Autowired
	private BookNewsManager mgr;
	
	@RequestMapping("main.do")
	public String main_page(Model model)
	{
		  /* mgr.xmlSave("도서 베스트셀러");
		   List<BookNewsVO> nlist=mgr.newsAllData();
		   model.addAttribute("nlist", nlist);*/
		return "main";
	}
	
	@RequestMapping("main_news.do")
	public String main_news(Model model)
	{
		 mgr.xmlSave("도서 베스트셀러");
		   List<BookNewsVO> nlist=mgr.newsAllData();
		   model.addAttribute("nlist",nlist);
		   return "news";
	}
	
@RequestMapping("charts.do")
	public String main_charts()
	{
		return "charts/charts";
	}
	
	@RequestMapping("tables.do")
	public String main_tables()
	{
		return "tables/tables";
	}
}
