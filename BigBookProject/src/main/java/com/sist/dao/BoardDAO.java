package com.sist.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private MongoTemplate mt;
	
	public List<BoardVO> board_list(int page)
	{
		List<BoardVO> list = new ArrayList<BoardVO>();
		Query query= new Query();
		
		int rowSize=10;
		int skip=(rowSize*page)-rowSize;
		query.skip(skip).limit(rowSize);
		query.with(new Sort(Sort.Direction.DESC,"no"));
		list = mt.find(query, BoardVO.class,"bb_board");
		// 게시물 여러개
		return list;
	}
	
	// 총페이지 계산
	public int boardTotalPage()
	{
		Query query = new Query();
		// board table에서 총 갯수 가져오기
		int count=(int)mt.count(query, "bb_board");
		
		return (int)Math.ceil(count/10.0);
	}
	
	public void boardInsert(BoardVO vo)
	{
		Query query= new Query();
		query.with(new Sort(Sort.Direction.DESC,"no"));
		BoardVO fvo = mt.findOne(query, BoardVO.class,"bb_board");
		// 게시물 하나
		String regdate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		if(fvo!=null)
		{
			vo.setNo(fvo.getNo()+1);
		}
		else
		{
			vo.setNo(1);
		}
		vo.setRegdate(regdate);
		vo.setHit(0);
		mt.insert(vo,"bb_board");
	}
	
	public BoardVO boardDetail(int no)
	{
		BoardVO vo = new BoardVO();
		BasicQuery query = new BasicQuery("{no:"+no+"}");
		vo = mt.findOne(query, BoardVO.class,"bb_board");
		// 조회수
		Update update = new Update();
		update.set("hit", vo.getHit()+1);
		mt.updateFirst(query, update, "bb_board");
		
		vo = mt.findOne(query, BoardVO.class,"bb_board");
		return vo;
	}
	
	public BoardVO boardUpdate(int no)
	{
		BoardVO vo = new BoardVO();
		BasicQuery query = new BasicQuery("{no:"+no+"}");
		vo = mt.findOne(query, BoardVO.class,"bb_board");
				
		return vo;
	}
	
	public boolean boardUpdateOk(BoardVO vo)
	{
		boolean bCheck=false;
		BasicQuery query = new BasicQuery("{no:"+vo.getNo()+"}");
		BoardVO fvo = mt.findOne(query, BoardVO.class, "bb_board");
		// fvo : 이미 db에 저장된 데이터  , vo : 사용자의 새로운 입력데이터
		if(fvo.getPwd().equals(vo.getPwd()))
		{
			bCheck=true;
			Update update = new Update();
			update.set("name", vo.getName());
			update.set("subject", vo.getSubject());
			update.set("content", vo.getContent());
			mt.updateFirst(query, update, "bb_board");
		}
		return bCheck;
	}
	
	public boolean boardDeleteOk(int no, String pwd)
	{
		boolean bCheck=false;
		BasicQuery query = new BasicQuery("{no:"+no+"}");
		BoardVO fvo = mt.findOne(query, BoardVO.class,"bb_board");
		if(fvo.getPwd().equals(pwd))
		{
			bCheck=true;
			mt.remove(query, "bb_board");
		}
		return bCheck;
	}
}
