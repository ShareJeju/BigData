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

import org.mortbay.util.UrlEncoded;

public class BlogManager {

	public void bookData(){
     try {
         //String text = URLEncoder.encode("아몬드", "UTF-8");
    	  //String apiURL = "http://book.interpark.com/api/search.api?key=B2AD9A39F5E89BD65F6B6D2BD1770773FC14D9C13954B632A69C10A81F495526&"
    	  //+"query="+text+"&queryType=title";
         String apiURL = "http://data4library.kr/api/loanItemSrch?authKey=c51b8ad336a31f3030c5550b57fdd7b7797f1c0a2b34bc04bfe3ef7d4f7f062c&startDt=2018-01-01&endDt=2018-12-20&addCode=0&kdc=1"; 
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
			JAXBContext jc = JAXBContext.newInstance(Response.class); //Rss.class=> @XmlRootElement의 클래스
			Unmarshaller un = jc.createUnmarshaller(); // 파싱
			Response res = (Response)un.unmarshal(new File("/home/sist/data/book.xml"));
			List<Doc> list=res.getDocs().getDoc();
			
			String data = "";
			for(Doc i:list)
			{
				data+=i.getNo()+"|"+i.getRanking()+"|"+i.getBookname()+"|"+
					  i.getAuthors()+"|"+i.getPublisher()+"|"+i.getPublication_year()+"|"+
						i.getLoan_count()+"|"+i.getBookImageURL()+"\n";
			}
			//data=data.substring(0, data.lastIndexOf("-end-\n"));
			//data=data.replaceAll("[^가-힣 ]", "");
			FileWriter fw = new FileWriter("/home/sist/data/book.txt");
			fw.write(data);
			fw.close();
			
		} catch (Exception ex) {ex.printStackTrace();}
	}
		
	
	public static void main(String[] args)
	{
		BlogManager bt = new BlogManager();
		bt.bookData();
		bt.xmlParseData();
	}
}
