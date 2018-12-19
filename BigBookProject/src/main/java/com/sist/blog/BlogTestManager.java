package com.sist.blog;
//네이버 검색 API 예제 - blog 검색
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class BlogTestManager {

	public void bookData(){
     try {
         String apiURL = "http://book.interpark.com/api/bestSeller.api?key=B2AD9A39F5E89BD65F6B6D2BD1770773FC14D9C13954B632A69C10A81F495526&&categoryId=100"; 
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
           FileWriter fw=new FileWriter("/home/sist/data/book.xml");
           fw.write(response.toString());
           fw.close();
         System.out.println(response.toString());
         //xmlParseData();
         System.out.println("save end..");
     } catch (Exception e) {
         e.printStackTrace();
     }
}
 
	public void xmlParseData()
	{
		try {
			JAXBContext jc = JAXBContext.newInstance(Channel.class); //Rss.class=> @XmlRootElement의 클래스
			Unmarshaller un = jc.createUnmarshaller(); // 파싱
			Channel channel = (Channel)un.unmarshal(new File("/home/sist/data/book.xml"));
			List<Item> list=channel.getItem();
			
			String data = "";
			for(Item i:list)
			{
				data+=i.getItemId()+"|"+i.getTitle()+"|"+i.getDescription()+"|"
						+i.getPubDate()+"|"+i.getCoverSmallUrl()+"|"+i.getCoverLargeUrl()+"|"
						+i.getCategoryId()+"|"+i.getCategoryName()+"|"+i.getPublisher()+"|"
						+i.getRank()+"|"+i.getCustomerReviewRank()+"|"+i.getReviewCount()+"|"
						+i.getAuthor()+"|"+i.getLink()+"\n";
			}
			//data=data.substring(0, data.lastIndexOf("-end-\n"));
			//data=data.replaceAll("[^가-힣 ]", "");
			FileWriter fw = new FileWriter("/home/sist/data/book.txt",true);
			fw.write(data);
			fw.close();
			
		} catch (Exception ex) {ex.printStackTrace();}
	}
		
	
	public static void main(String[] args)
	{
		BlogTestManager bt = new BlogTestManager();
		bt.bookData();
		bt.xmlParseData();
	}
}
