package com.sist.library;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;
@XmlRootElement
public class Octastatapi387 {
	private List<Row> row = new ArrayList<Row>();

	public List<Row> getRow() {
		return row;
	}
	@XmlElement
	public void setRow(List<Row> row) {
		this.row = row;
	}	
}

