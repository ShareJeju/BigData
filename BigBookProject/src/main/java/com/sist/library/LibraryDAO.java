package com.sist.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryDAO {
	@Autowired
	private MongoTemplate mt;
	
	/*public void library()*/
}
