package com.sist.book;

import java.io.FileReader;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.BookDAO;
import com.sist.dao.BookVO;

@Component
public class BlogMain {
	@Autowired
	private BookDAO dao;
	
	public static void main(String[] args) {

		String[] path={"application-context.xml","application-mongo.xml"};  
		ApplicationContext app = new ClassPathXmlApplicationContext(path);
		BlogMain mc = app.getBean("blogMain",BlogMain.class);
		try
		{
			StringBuffer sb=new StringBuffer();
			// sb.append() ==> 문자열 결합 (데이터가 많은 경우) +
			FileReader fr=new FileReader("/home/sist/data/book.txt");
			
			int i=0;
			// fr.read() : 한글자 ==> 데이터값이 ASC
			// A=>65 ==> (char)65
			while((i=fr.read())!=-1)
			{
				String s=String.valueOf((char)i);
				sb.append(s);
			}
			fr.close();
			System.out.println(sb.toString());
			String data=sb.toString();
			String[] book=data.split("\n");
			System.out.println(book.length);
			for(String bd:book) //  한줄씩 읽기 시작
			{
				try
				{
					String[] split = bd.split("\\|");
					System.out.println(split.length);
					BookVO vo = new BookVO();
					for(int j=0; j<split.length;j++)
					{
						vo.setItemId(split[j]);
						vo.setTitle(split[j+1]);
						vo.setDescription(split[j+2]);
						vo.setPubDate(split[j+3]);
						vo.setCoverSmallUrl(split[j+4]);
						vo.setCoverLargeUrl(split[j+5]);
						vo.setCategoryId(split[j+6]);
						vo.setCategoryName(split[j+7]);
						vo.setPublisher(split[j+8]);
						vo.setRank(split[j+9]);
						vo.setCustomerReviewRank(split[j+10]);
						vo.setReviewCount(split[j+11]);
						vo.setAuthor(split[j+12]);
						vo.setLink(split[j+13]);
						
						System.out.println(split[j]);
						mc.dao.BookInsert(vo);	
					}
					}catch(Exception ex){ex.printStackTrace();}
				}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

