package com.sist.news;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
@Repository
public class BookNewsDAO {
	@Autowired
	private BookNewsManager bnm;
	@Autowired
	private MongoTemplate mt;
	public void newsInsert(String title)
	{
		
			mt.getCollection("booknews").drop();//테이블 지우기
			bnm.xmlSave(title);
			List<BookNewsVO> list=bnm.newsAllData();
			for(BookNewsVO vo:list)
			{
				mt.insert(vo,"booknews");
			}
		}
	
	public List<BookNewsVO> newsListData(int page)
	{
		
		List<BookNewsVO> list=new ArrayList<BookNewsVO>();
		Query query=new Query();
		int rowSize=10;
		int skip=(page*rowSize)-rowSize; //페이지 버리기
		/*
		 * 0~9 1page 
		 * 10~19 2page
		 * 20~29 3page
		 * 
		 */
		query.skip(skip).limit(rowSize);
		list=mt.find(query, BookNewsVO.class,"booknews");
		return list;
	}

}
