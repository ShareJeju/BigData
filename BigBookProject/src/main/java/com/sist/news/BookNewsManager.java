package com.sist.news;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.*;
import java.net.*;
import java.text.*;

@Component //매니저면 component로 메모리 할당
public class BookNewsManager {
	public static void main(String[] arg)
	{
		BookNewsManager m=new BookNewsManager();
		m.xmlSave("도서 베스트셀러");
		m.newsAllData();
		/*Date date=new Date("Mon, 17 Dec 2018 15:32:00 +0900");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(date));*/
	}
	public void xmlSave(String title)
	{
		try
		{
			String strUrl="http://newssearch.naver.com/search.naver?where=rss"
					+"&query="+URLEncoder.encode(title,"UTF-8");
			URL url=new URL(strUrl);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection(); //서버연결
			StringBuffer sb=new StringBuffer();
			if(conn!=null)
			{
				BufferedReader br=new BufferedReader(
						new InputStreamReader(conn.getInputStream())); 
				while(true)
				{
					String str=br.readLine();
					if(str==null)
						break;
					sb.append(str);
				}
				br.close();
			}
			FileWriter fw=new FileWriter("/home/sist/booknews.xml");
			fw.write(sb.toString());
			fw.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	//XML 파일 파싱: jaxb,jaxp (dom,sax)
	public List<BookNewsVO> newsAllData()
	{
		List<BookNewsVO> list=new ArrayList<BookNewsVO>();
		try
		{
			//1.파서기 생성
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			//객체 생성
			DocumentBuilder db=dbf.newDocumentBuilder(); //메모리에 데이터를 저장 
			
			//파서 ==>트리 형태로 저장 
			Document doc=db.parse(new File("/home/sist/booknews.xml")); 
			//저장된 위치 (document) 안에서 필요한 태그 값 가져오기
			//최상위 태그 (계층 구조)
			/*
			 * <rss>
			 * 	<channel>
			 * 		<item>
			 * 		</item> 
			 * 	</channel>
			 * 	</rss>
			 */
			Element root=doc.getDocumentElement();
			//root=>rss
			System.out.println(root.getTagName());
			
			//root ==> 변경
			Element channel=(Element)root.getElementsByTagName("channel").item(0);
			System.out.println(channel.getTagName());
			
			//channel ==> item 태그 전체를 모아서 데이터 수집
			NodeList node=channel.getElementsByTagName("item");
			System.out.println("item-count:"+node.getLength());
			

			 int j=1;
			   // item => 데이터 수집 
			   for(int i=0;i<node.getLength();i++)
			    {
				   node=channel.getElementsByTagName("title");
				   String title=node.item(j+1).getFirstChild().getNodeValue();
				   
				   node=channel.getElementsByTagName("link");
				   String link=node.item(j+1).getFirstChild().getNodeValue();
				   
				   node=channel.getElementsByTagName("description");
				   String description=node.item(j).getFirstChild().getNodeValue();
				   
				   node=channel.getElementsByTagName("pubDate");
				   String pubDate=node.item(i).getFirstChild().getNodeValue();
				   
				   node=channel.getElementsByTagName("author");
				   String author=node.item(i).getFirstChild().getNodeValue();
				   /*
				    *   <title>네이버 뉴스검색 :: '범죄'</title>
				    *   <media:thumbnail url="https://imgnews.pstatic.net/image/thumb140/011/2018/12/18/3467252.jpg"/>
				    */
				   node=channel.getElementsByTagName("media:thumbnail");
				   Element elem=(Element)node.item(i);
				   String poster=elem.getAttribute("url"); //포스터는 속성값으로 읽기
				   System.out.println(title);
				   System.out.println(link);
				   System.out.println(description);
				   System.out.println(pubDate);
				   System.out.println(author);
				   System.out.println(poster);
				   System.out.println("======================================");
				   BookNewsVO vo=new BookNewsVO();
				   vo.setAuth(author);
				   vo.setDescription(description);
				   vo.setLink(link);
				   vo.setPoster(poster);
				   vo.setPubDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(pubDate)));
				   vo.setTitle(title);
				   list.add(vo);
				  j++;
			    }
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   return list;
	   }
}