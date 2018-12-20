package com.sist.book;

import static org.mockito.Matchers.intThat;

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
						vo.setNo(Integer.parseInt(split[j]));
						vo.setRanking(Integer.parseInt(split[j+1]));
						vo.setBookname(split[j+2]);
						vo.setAuthors(split[j+3]);
						vo.setPublisher(split[j+4]);
						vo.setPublication_year(Integer.parseInt(split[j+5]));
						vo.setLoan_count(split[j+6]);
						vo.setBookImageURL(split[j+7]);
						
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

