package com.sist.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	// READ
	@RequestMapping("board/list.do")
	public String board_list(String page, Model model)
	{
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		List<BoardVO> list = dao.board_list(curpage);
		int totalpage = dao.boardTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		return "board/list";
	}
	
	// CREATE
	@RequestMapping("board/insert.do")
	public String board_insert(Model model)
	{
		return "board/insert";
	}
	
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo)
	{
		dao.boardInsert(vo);
		return "redirect:../../book/board/list.do";
	}
	
	@RequestMapping("board/detail.do")
	public String board_detail(int no, Model model)
	{
		BoardVO vo = dao.boardDetail(no);
		model.addAttribute("vo", vo);
				
		return "board/detail";
	}
	
	@RequestMapping("board/update.do")
	public String board_update(int no, Model model)
	{
		BoardVO vo = dao.boardUpdate(no);
		model.addAttribute("vo",vo);
		return "board/update";
	}
	
	@RequestMapping("board/update_ok.do")
	public String board_update_ok(BoardVO vo, Model model)
	{
		boolean bCheck = dao.boardUpdateOk(vo);
		model.addAttribute("bCheck", bCheck);
		model.addAttribute("no", vo.getNo());		
		return "update_ok"; // tiles가 아니라 viewResolver를 쓰기위해
	}
	
	@RequestMapping("board/delete.do")
	public String board_delete(int no, Model model)
	{
		model.addAttribute("no",no);
		return "board/delete";
	}
	@RequestMapping("board/delete_ok.do")
	public String board_delete_ok(int no, String pwd, Model model)
	{
		boolean bCheck=dao.boardDeleteOk(no, pwd);
		model.addAttribute("bCheck", bCheck);
		return "delete_ok";
	}
	
	
}
