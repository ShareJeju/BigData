package com.sist.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main.do")
	public String main_page()
	{
		return "main";
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
