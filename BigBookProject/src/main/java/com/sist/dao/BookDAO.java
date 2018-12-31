package com.sist.dao;
import org.apache.velocity.runtime.directive.Parse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.*;
import com.sist.dao.*;
import com.sist.seoulmap.BookjiVO;

import java.io.FileWriter;
import java.util.*;
@Repository
public class BookDAO {
	@Autowired
	private MongoTemplate mt;
	//주형 몽고
	public void BookInsert(BookVO vo)
	{
		mt.insert(vo,"bb_jhbook");
	}
	//이녕 몽고
	public void BookInsertiy(BookiyVO vo)
	{
		mt.insert(vo,"bb_iy");
	}
	//정일 몽고
	public void BookInsertji(BookjiVO vo){
		mt.insert(vo,"seoul_gu_map_max");
	}
	//윤지 몽고
	public void BookInsertyj(BookyjVO vo){
		mt.insert(vo,"bb_yoonji");
	}
	//이슬 몽고
	public void BookInsertis(BookisVO vo)
	{
		mt.insert(vo,"bb_iseul");
	}
	
	//이슬 그래프
	public List<Integer> graphSumis(String type)
	{
		List<Integer> iList=new ArrayList<Integer>();
		List<BookisVO> list=new ArrayList<BookisVO>();
		//String[] genre = { "종교", "역사", "언어", "문학", "예술", "기술과학" };
		String[] subject = { "철학", "종교", "사회과학", "자연과학", "기술과학", "예술", "언어", "문학", "역사"};
		for(int i=0;i<subject.length;i++)
		{
		  int sum=0;
		  BasicQuery query=new BasicQuery("{$and:[{year:'"+type+"'},{subject:'"+subject[i]+"'}]}");
		  list=mt.find(query,BookisVO.class,"iseulresult");
		
		  for(BookisVO vo:list)
		  {
			  iList.add(vo.getLoan_count());
		  }
		  
		}
		return iList;
	}
	
	public List<BookisVO> BookSubjectData()
	{
		//WHERE c_gu='' AND c_name='' {c+gu:'마포'}
		List<BookisVO> list=new ArrayList<BookisVO>();
/*		Query query= new Query();
		list=mt.find(query, BookVO.class,"bb_iseulk_f");*/
			BasicQuery query=new BasicQuery("{$and:[{ranking:'1'}]}");
		query.with(new Sort(Sort.DEFAULT_DIRECTION.ASC,"year"));
		list=mt.find(query, BookisVO.class, "bb_iseul");
		
		return list;
	}
	
	//윤지 그래프
	public List<String> bookLocationyj()
	{
		List<String> list=new ArrayList<String>();
		Query query = new Query();
		list=mt.getCollection("bb_yoonji").distinct("location");
		return list;
	}

	/*public int bookLocTotal(String location)
	{
		int total=0;
		BasicQuery query=new BasicQuery("{location:'"+location+"'}");
		List<BookVO> list=mt.find(query, BookVO.class,"bb_yoonji");
		for(BookVO vo:list)
		{
			total+=Integer.parseInt(vo.getLoan_count());
		}
		return total;
	}
	
	public List<BookVO> locationBookData(String location,String genre)
	{
		List<BookVO> list = new ArrayList<BookVO>();
		
		// WHERE c_gu='' AND c_name=''
		BasicQuery query=new BasicQuery("{$and:[{location:'"+location+"'},{genre:'"+genre+"'}]}");
		query.with(new Sort(Sort.DEFAULT_DIRECTION.ASC,"location")); // 년도별로 ASC해서 가져옴
		list=mt.find(query, BookVO.class,"bb_changeyoonji");
		
		return list;
	}*/
	
	public List<Integer> graphSum(String type)
	{
		List<Integer> iList=new ArrayList<Integer>();
		List<changeBookVO> list=new ArrayList<changeBookVO>();
		//String[] genre = { "종교", "역사", "언어", "문학", "예술", "기술과학" };
		String[] location = { "서울", "대전", "대구", "부산", "광주" };
		for(int i=0;i<location.length;i++)
		{
		  int sum=0;
		  BasicQuery query=new BasicQuery("{$and:[{genre:'"+type+"'},{location:'"+location[i]+"'}]}");
		  list=mt.find(query,changeBookVO.class,"bb_changeyoonji");
		
		  for(changeBookVO vo:list)
		  {
			  iList.add(vo.getLoan_count());
		  }
		  
		}
		return iList;
	}
	
	public List<BookyjVO> tablebook()
	{
		List<BookyjVO> list= new ArrayList<BookyjVO>();
		Query query = new Query();
		list=mt.find(query, BookyjVO.class,"bb_yoonji");
		return list;
	}
	//정일 그래프
	public List<BookjiVO> locationCrimeData(String loc,String c_name)
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
	
	//인영 그래프
	public List<ResultVO> BookResultData(String year)
	{
		List<ResultVO> result = new ArrayList<ResultVO>();
		BasicQuery query=new BasicQuery("{year:'"+year+"'}");
		query.with(new Sort(Sort.DEFAULT_DIRECTION.ASC,"month"));
		result=mt.find(query,ResultVO.class,"bb_results");
		return result;	
	}
	//인영 리스트 출력
	public List<BookiyVO> BookListData(String year)
	{
		List<BookiyVO> list = new ArrayList<BookiyVO>();
		BasicQuery query = new BasicQuery("{year:'"+year+"'}");
		query.with(new Sort(Sort.DEFAULT_DIRECTION.ASC,"month"));
		list=mt.find(query, BookiyVO.class, "bb_iy");
		return list;
	}
	@Autowired
	//몽고연결
	public List<String> bookage(){
		List<String> list=new ArrayList<String>();
		Query query=new Query();
		//중복없는 데이터를 가지고 올 때
		list=mt.getCollection("bb_jhbook").distinct("age");
		return list;
	}
	//상위 10개 뿌리기
	/*@Autowired
	public List<BookVO> bookRankData(){
		BookVO vo=new BookVO();
		List<BookVO> list=new ArrayList<BookVO>();
		Query query=new Query();
		//list=mt.find(query, BookVO.class, "bb_jhbook");
		
			list=mt.find(query, BookVO.class, "bb_jhbook");
		
		return list;
	}*/
	public int bookTotal(String age){
		int total=0;
		BasicQuery query=new BasicQuery("{age:'"+age+"'}");
		List<BookVO> list=mt.find(query, BookVO.class, "bb_jhbook");
		for(BookVO vo:list){
			if(vo.getGender().equals("남성")){
			total+=Integer.parseInt(vo.getLoan_count().replaceAll(",",""));
			}
			
		}
		return total;
	}
	public int bookTotal2(String age){
		int total=0;
		BasicQuery query=new BasicQuery("{age:'"+age+"'}");
		List<BookVO> list=mt.find(query, BookVO.class, "bb_jhbook");
		for(BookVO vo:list){
			if(vo.getGender().equals("여성")){
			total+=Integer.parseInt(vo.getLoan_count().replaceAll(",",""));
			}
			
		}
		return total;
	}
	public List<BookVO> mbookRankData(){
		List<BookVO> list=new ArrayList<BookVO>();
		BasicQuery query=new BasicQuery("{$and:[{no:'1'},{gender:'남성'}]}");
		query.with(new Sort(Sort.DEFAULT_DIRECTION.ASC,"age"));
		list=mt.find(query, BookVO.class,"bb_jhbook");
		return list;
	}
	
	public List<BookVO> wbookRankData(){
		List<BookVO> wolist=new ArrayList<BookVO>();
		BasicQuery query=new BasicQuery("{$and:[{no:'1'},{gender:'여성'}]}");
		query.with(new Sort(Sort.DEFAULT_DIRECTION.ASC,"age")); //sort ==> order by
		wolist=mt.find(query, BookVO.class,"bb_jhbook");
		return wolist;
	}
	
}
