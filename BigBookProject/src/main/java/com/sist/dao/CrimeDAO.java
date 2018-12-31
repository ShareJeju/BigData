package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
//메모리 할당
@Repository
public class CrimeDAO {
	//Spring에서 생성한 클래스의 주소값을 대입
	@Autowired
	private MongoTemplate mt;
	public List<String> crimeLocation(){
		List<String> list=new ArrayList<String>();
		Query query=new Query();
		//중복없는 데이터를 가지고 올때 코딩
		list=mt.getCollection("crime").distinct("c_gu");
		return list;
	}
	public int crimeLocTotal(String c_gu){
		int total=0;
		BasicQuery query=new BasicQuery("{c_gu:'"+c_gu+"'}");
		List<CrimeVO> list=mt.find(query, CrimeVO.class, "crime");
		for(CrimeVO vo:list){
			total+=vo.getC_count();
		}
		
		return total;
	}
	/*public List<String> videoCategoryData()
	{
		List<String> list=new ArrayList<String>();
		list=mt.getCollection("bvideo").distinct("sortname");
		// SELECT DISTINCT sortname FROM bvideo
		return list;
	}*/
/*	public List<BVideoVO> videoData(String cate)
	{
		List<BVideoVO> list=new ArrayList<BVideoVO>();
		BasicQuery query=new BasicQuery("{sortname:'"+cate+"'}");
		list=mt.find(query,BVideoVO.class,"bvideo");
		for(BVideoVO vo:list)
		{
			System.out.println(vo.getTitle());
		}
		return list;
	}*/
	//지역별 데이터 가지고오기 (Mongodb)
	public List<CrimeVO> locationCrimeData(String loc,String c_name){
		List<CrimeVO> list=new ArrayList<CrimeVO>();
		// WHERE c_gu=' ' AND c_name=' '
		BasicQuery query=new BasicQuery("{$and:[{c_gu:'"+loc+"'},{c_name:'"+c_name+"'},{c_type:'검거'}]}"); //쓰는방식 공부
		query.with(new Sort(Sort.DEFAULT_DIRECTION.ASC,"c_year"));
		list=mt.find(query, CrimeVO.class,"crime");
		return list;
	}
}
