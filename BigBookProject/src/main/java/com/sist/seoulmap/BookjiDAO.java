package com.sist.seoulmap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.*;
import com.sist.dao.*;
import java.io.FileWriter;
import java.util.*;
@Repository
public class BookjiDAO {
	@Autowired
	private MongoTemplate mt;
	public void BookInsert(BookMaxVO vo)
	{
		mt.insert(vo,"seoul_gu_map_max");
	}

	// { $or: [ { “title”: “article01” }, { “writer”: “Alpha” } ] }
			// 지역별 데이터 
			public List<BookjiVO> locationBookData(String loc,String c_name)
			{
				int total = 0;
				int i=0;
				// WHERE c_gu='' AND c_name=''  {c_gu:'마포'},{c_name:''}
				List<BookjiVO> list=new ArrayList<BookjiVO>();
				BasicQuery query=new BasicQuery("{$and:[{gu:'"+loc+"'},{age:'"+c_name+"'},{dea:'대출권수'}]}");
				
				query.with(new Sort(Sort.DEFAULT_DIRECTION.ASC,"year"));// 년도별로 ORDERBY
				
				list=mt.find(query, BookjiVO.class,"seoul_gu_year_count");
				return list;
			}	
			
			public BookjiVO DetailBookData(String bookname)
			{
				BookjiVO vo=new BookjiVO();
				
				 BasicQuery query=new BasicQuery("{bookname:'"+bookname+"'}");
				 vo=mt.findOne(query, BookjiVO.class,"seoul_gu_map");
				
				return vo;
			}
				/*
				
				 db.getCollection('seoul_gu_map').group(
			    {
			     key:{ 'gu' : '강남구','year' : 2010, 'age' : '0', 'dea':'대출권수'},
			     cond:{},
			     reduce: function(curr, result){
			       result.loan_count += curr.loan_count
			     },
			        initial : {loan_count : 0}
			    }
			)
			
				 */
			
			
			public List<BookjiVO> locationOneData(String loc,String c_name)
			{
				int total = 0;
				int i=0;
				// WHERE c_gu='' AND c_name=''  {c_gu:'마포'},{c_name:''}
				List<BookjiVO> list=new ArrayList<BookjiVO>();
				BasicQuery query=new BasicQuery("{$and:[{gu:'"+loc+"'},{age:'"+c_name+"'},{dea:'대출권수'},{no:'1'}]}");
				
				query.with(new Sort(Sort.DEFAULT_DIRECTION.ASC,"year"));// 년도별로 ORDERBY
				
				list=mt.find(query, BookjiVO.class,"seoul_gu_map");
				return list;
			}	
			
			public List<String> bookLocation() {
				List<String> list = new ArrayList<String>();

				// SELECT DISTINCT c_gu FROM crime
				// 중복이 없는 데이터를 가지고 오는 방식 즉, 중복이 없는 GU를가지고 온다
				Query query = new Query();
				list = mt.getCollection("seoul_gu_year_count").distinct("gu"); // Collection == 테이블명
																	// , distinct("필드명")
				return list;
			}

			public int bookLocTotal(String gu) // 모든 구마다 통계를 더한다
			{
				int total = 0;

				// WHERE을 쓰기 위해 BasicQuery를 가지고 온다
				// robo3t에서 쿼리 : db.getCollection('crime').find({c_gu:'성북'}) == 성북만 가지고
				// 온다.
				BasicQuery query = new BasicQuery("{gu:'" + gu + "'}"); // 문자를 이용할때
																			// 무적권 ''를
																			// 넣어줘야한다
				List<BookjiVO> list = mt.find(query, BookjiVO.class, "seoul_gu_year_count");
				for (BookjiVO vo : list) {
					total += vo.getLoan_count();
				}

				return total;
			}
	
}
