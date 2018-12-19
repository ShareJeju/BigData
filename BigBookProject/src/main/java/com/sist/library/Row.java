package com.sist.library;

import javax.xml.bind.annotation.XmlElement;

/*
<GIGAN>2017</GIGAN>
<JACHIGU>합계</JACHIGU>
<GYE>512</GYE>
<GUNGNIPDOSEOGWAN>3</GUNGNIPDOSEOGWAN>
<GONGGONGDOSEOGWAN>160</GONGGONGDOSEOGWAN>
<DAEHAKDOSEOGWAN>88</DAEHAKDOSEOGWAN>
<JEONMUNDOSEOGWAN>261</JEONMUNDOSEOGWAN>
*/
public class Row {
	private String gigan;
	private String jachigu;
	private int gye;
	private int gungnipdoseogwan;
	private int gonggongdoseogwan;
	private int daehakdoseogwan;
	private int jeonmundoseogwan;
	public String getGigan() {
		return gigan;
	}
	@XmlElement(name="GIGAN")
	public void setGigan(String gigan) {
		this.gigan = gigan;
	}
	public String getJachigu() {
		return jachigu;
	}
	@XmlElement(name="JACHIGU")
	public void setJachigu(String jachigu) {
		this.jachigu = jachigu;
	}
	public int getGye() {
		return gye;
	}
	@XmlElement(name="GYE")
	public void setGye(int gye) {
		this.gye = gye;
	}
	public int getGungnipdoseogwan() {
		return gungnipdoseogwan;
	}
	@XmlElement(name="GUNGNIPDOSEOGWAN")
	public void setGungnipdoseogwan(int gungnipdoseogwan) {
		this.gungnipdoseogwan = gungnipdoseogwan;
	}
	public int getGonggongdoseogwan() {
		return gonggongdoseogwan;
	}
	@XmlElement(name="GONGGONGDOSEOGWAN")
	public void setGonggongdoseogwan(int gonggongdoseogwan) {
		this.gonggongdoseogwan = gonggongdoseogwan;
	}
	public int getDaehakdoseogwan() {
		return daehakdoseogwan;
	}
	@XmlElement(name="DAEHAKDOSEOGWAN")
	public void setDaehakdoseogwan(int daehakdoseogwan) {
		this.daehakdoseogwan = daehakdoseogwan;
	}
	public int getJeonmundoseogwan() {
		return jeonmundoseogwan;
	}
	@XmlElement(name="JEONMUNDOSEOGWAN")
	public void setJeonmundoseogwan(int jeonmundoseogwan) {
		this.jeonmundoseogwan = jeonmundoseogwan;
	}
	
	
}
