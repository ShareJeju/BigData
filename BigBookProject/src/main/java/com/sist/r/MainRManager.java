package com.sist.r;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;
@Component
public class MainRManager {
	public void newsGraph()
	{
		try{
			RConnection rc=new RConnection();
			System.out.println("rc연결");
			rc.voidEval("library(rJava)");
			rc.voidEval("Sys.setenv(JAVA_HOME=\"/usr/lib/jvm/java-8-openjdk-amd64\")");
			rc.voidEval("options(java.parameters = c(\"-Xmx16384m\",\"-Dfile.encoding=UTF-8\"))");
			rc.voidEval("library(KoNLP)");
			rc.voidEval("library(RMongo)");
			rc.voidEval("library(wordcloud)");
			rc.voidEval("png(\"/home/sist/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BigBookProject/wordcloud.png\")");
			rc.voidEval("mongo<-mongoDbConnect(\"mydb\",\"211.238.142.57\",27017)");
			System.out.println("1");
			rc.voidEval("data<-dbGetQuery(mongo,\"booknews\",\"{}\")");
			System.out.println("2");
			rc.voidEval("data2<-sapply(data$description, extractNoun,USE.NAMES = F)");
			System.out.println("3");
			rc.voidEval("data3<-unlist(data2)");
			rc.voidEval("data4<-Filter(function(x){nchar(x)>=2},data3)");
			rc.voidEval("data5<-table(data4)");
			rc.voidEval("data6<-head(sort(data5,decreasing = T),100)");
			rc.voidEval("wordcloud(names(data6),freq = data6,scale=c(5,1),rot.per = 0.25,random.order = F,random.color = T,colors=rainbow(15))");
			rc.voidEval("dev.off()");
			rc.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
