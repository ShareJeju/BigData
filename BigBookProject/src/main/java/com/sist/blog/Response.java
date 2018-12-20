package com.sist.blog;
import java.util.*;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Response {
	private Docs docs = new Docs();

	public Docs getDocs() {
		return docs;
	}
	@XmlElement
	public void setDocs(Docs docs) {
		this.docs = docs;
	}

		
}
