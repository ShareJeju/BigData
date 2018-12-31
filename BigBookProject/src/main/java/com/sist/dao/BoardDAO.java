package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class BoardDAO {
	//MongoDB 메모리할당
	@Autowired
	private MongoTemplate mt;
	//게시판 리스트 목록
	public List<BoardVO> boardListData(int page){
	List<BoardVO> list=new ArrayList<BoardVO>();
	//MongoDB Query문장 사용
	Query query=new Query();
	int rowSize=10;
	int skip=(rowSize*page)-rowSize;
	query.skip(skip).limit(rowSize);
	query.with(new Sort(Sort.Direction.DESC,"no")); //oracle에서 ORDER BY 문장
	list=mt.find(query, BoardVO.class,"board");
	return list;
	}
	//게시판 총페이지
	public int boardTotalPage(){
		Query query=new Query();
		//테이블에서 총 갯수 얻기
		int count=(int)mt.count(query, "borad");
		int total=(int)(Math.ceil(count/10.0)); //올림 
		return total;
	}
}
