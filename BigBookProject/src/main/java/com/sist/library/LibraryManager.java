package com.sist.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class LibraryManager {
	public static void main(String[] args)
	{
		LibraryManager lm = new LibraryManager();
		lm.bookData();
		lm.xmlParseData();
	}
	public void bookData(){
     try {
         String apiURL = "http://openapi.seoul.go.kr:8088/6a7251756473696c37366e4c444377/xml/octastatapi387/1/26";           
         URL url = new URL(apiURL);
         HttpURLConnection con = (HttpURLConnection)url.openConnection();
         con.setRequestMethod("GET");
         int responseCode = con.getResponseCode();
         BufferedReader br;
         if(responseCode==200) { // 정상 호출
             br = new BufferedReader(new InputStreamReader(con.getInputStream()));
         } else {  // 에러 발생
             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
         }
         String inputLine;
         StringBuffer response = new StringBuffer();
         while ((inputLine = br.readLine()) != null) {
             response.append(inputLine);
         }
         br.close();
           FileWriter fw=new FileWriter("/home/sist/data/library.xml");
           fw.write(response.toString());
           fw.close();
        // System.out.println(response.toString());
         xmlParseData();
        // System.out.println("save end1..");
     } catch (Exception e) {
         e.printStackTrace();
     }
}
	/*
	<GIGAN>2017</GIGAN>
	<JACHIGU>합계</JACHIGU>
	<GYE>512</GYE>
	<GUNGNIPDOSEOGWAN>3</GUNGNIPDOSEOGWAN>
	<GONGGONGDOSEOGWAN>160</GONGGONGDOSEOGWAN>
	<DAEHAKDOSEOGWAN>88</DAEHAKDOSEOGWAN>
	<JEONMUNDOSEOGWAN>261</JEONMUNDOSEOGWAN>
	*/ 
	public void xmlParseData()
	{
		try {
			JAXBContext jc = JAXBContext.newInstance(Octastatapi387.class); //Rss.class=> @XmlRootElement의 클래스
			Unmarshaller un = jc.createUnmarshaller(); // 파싱
			Octastatapi387 octastatapi387 = (Octastatapi387)un.unmarshal(new File("/home/sist/data/library.xml"));
			List<Row> list=octastatapi387.getRow();
			String data = "";
			for(Row i:list)
			{
				data+=i.getGigan()+","+i.getJachigu()+","+i.getGye()+","+i.getGungnipdoseogwan()+","+i.getGonggongdoseogwan()+","+i.getDaehakdoseogwan()+","+i.getJeonmundoseogwan()+"\n";
				
				//System.out.println(i.getGigan()+","+i.getJachigu()+","+i.getGye()+","+i.getGungnipdoseogwan()+","+i.getGonggongdoseogwan()+","+i.getDaehakdoseogwan()+","+i.getJeonmundoseogwan());
			}
			data=data.substring(0, data.lastIndexOf("\n"));
			//data=data.replaceAll("[^가-힣 ]", "");
			FileWriter fw = new FileWriter("/home/sist/data/library.txt");
			fw.write(data);
			fw.close();
			
		} catch (Exception ex) {ex.printStackTrace();}
	}
}
