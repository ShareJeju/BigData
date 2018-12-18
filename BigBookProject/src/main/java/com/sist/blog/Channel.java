package com.sist.blog;
import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;
@XmlRootElement
public class Channel {
	private List<Item> item = new ArrayList<Item>();

	public List<Item> getItem() {
		return item;
	}
	
	@XmlElement
	public void setItem(List<Item> item) {
		this.item = item;
	}
	
}
