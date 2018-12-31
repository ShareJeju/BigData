package com.sist.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.sist.dao.*;
@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("board/list.do")
	public String board_list(String page,Model model){
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<BoardVO> list=dao.boardListData(curpage);
		int totalpage=dao.boardTotalPage();
		
		//JSP로 전송
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		return "board/list";
	}
	
	/*@RequestMapping("board/insert.do")
	public String board_insert(){
		return "board/insert";
	}*/
	
}
