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
			FileReader fr=new FileReader("/home/sist/data/jhbook.txt");
			
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
					String[] split = bd.split("\\|\\|\\|");
					System.out.println(split.length);
					BookVO vo = new BookVO();
					for(int j=0; j<split.length;j++)
					{
						vo.setNo(split[j].trim());
						vo.setRanking(split[j+1].trim());
						vo.setBookname(split[j+2].trim());
						vo.setAuthors(split[j+3].trim());
						vo.setPublisher(split[j+4].trim());
						vo.setPublication_year(split[j+5].trim());
						vo.setLoan_count(split[j+6].trim());
						vo.setBookImageURL(split[j+7].trim());
						vo.setGender(split[j+8].trim());
						vo.setAge(split[j+9].trim());
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

