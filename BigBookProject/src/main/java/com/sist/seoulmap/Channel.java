package com.sist.seoulmap;
import java.util.*;

import javax.xml.bind.annotation.XmlElement;


public class Channel {
	private List<Item> item=new ArrayList<Item>();

	public List<Item> getItem() {
		return item;
	}

	//text로 가져오거나 attr로 가져온다.
	@XmlElement
	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
}
