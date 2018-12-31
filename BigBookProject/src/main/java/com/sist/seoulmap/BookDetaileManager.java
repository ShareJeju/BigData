package com.sist.seoulmap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.sist.seoulmap.Item;
import com.sist.seoulmap.Rss;;

@Component
public class BookDetaileManager {
	public void bookReplyData(String bookname)
	{
		// TODO Auto-generated method stub
				String clientId = "sKAa7xmcoqDPVlcntwJK";//애플리케이션 클라이언트 아이디값";
		        String clientSecret = "eiu1i0oFlR";//애플리케이션 클라이언트 시크릿값";
		        try {
		            String text = URLEncoder.encode(bookname, "UTF-8");
		            //String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
		            String apiURL = "https://openapi.naver.com/v1/search/blog.xml?display=100&query="+ text; // xml 결과
		            URL url = new URL(apiURL);
		            HttpURLConnection con = (HttpURLConnection)url.openConnection();
		            con.setRequestMethod("GET");
		            con.setRequestProperty("X-Naver-Client-Id", clientId);
		            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
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
		              FileWriter fw=new FileWriter("/home/sist/data/bookdetaile.xml");//블로그에서 가져온 데이터를 xml파일로 저장! 
		              fw.write(response.toString());
		              fw.close();
		            System.out.println(response.toString());
		            //xmlParseData();
		        } catch (Exception e) {
		            System.out.println(e);
		        }
	}
	/*  
	   순서(프로그램 돌아가는 순서)
	   사용자가 요청한다.
	   데이터를 수집한다. (네ㅐ이버엔드매니저)
	   하둡에 올려준다.
	   하둡에서 맵리듀스를 이용한다
	   맵리듀스에서 받은 결과값을 받아서 시각화 한다. (매일 받아서 어떻게 변화하나 지켜보고 예측)  
	 
	 */
	
	//XML 수집
	// XML에서 필요한 데이터 추출(언마셜
	// 자바 클래스 XML태그
	// XML 태그 ==> 자바 클래스 (언마샬)
	// 자바 클래스 ==> XML클래스 (마샬)
	public void xmlParseData()
	{
		try {
			JAXBContext jc=JAXBContext.newInstance(Rss.class); //@XmlRootElement 올린 클래스가 와야한다.
			Unmarshaller un=jc.createUnmarshaller();
			Rss rss=(Rss) un.unmarshal(new File("/home/sist/data/bookdetaile.xml"));
			List<Item> list=rss.getChannel().getItem();
			String data="";
			for(Item i:list)
			{
				data+=i.getDescription()+"\n";
			}
			data=data.substring(0, data.lastIndexOf("\n")); //엔터기능을 가진 \n을 썼으니까 지운다. 
			FileWriter fw=new FileWriter("/home/sist/data/bookdetaile.txt"); //텍스트로 다시 저장
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
