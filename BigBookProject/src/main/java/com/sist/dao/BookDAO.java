package com.sist.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.*;
import com.sist.dao.*;
import java.io.FileWriter;
import java.util.*;
@Repository
public class BookDAO {
	@Autowired
	private MongoTemplate mt;
	public void BookInsert(BookVO vo)
	{
		mt.insert(vo,"bb_book");
	}
}
