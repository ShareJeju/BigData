package com.sist.seoulmap;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;

@Component
public class RManager {
	public void bookGraph2() //연관분석 시각화 부분
	{
		try {/*
			 rc.voidEval("data<-readLines(\"/home/sist/data/bookdetaile.txt\")");
				rc.voidEval("png(\"/home/sist/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BigBookProject/book.png\")");*/
			RConnection rc=new RConnection();
			rc.voidEval("Sys.setenv(JAVA_HOME='/usr/lib/jvm/java-8-openjdk-amd64')");
			rc.voidEval("library(rJava)");
			rc.voidEval("library(KoNLP)");
			   rc.voidEval("library(arules)");
			 /*  rc.voidEval("install.packages(\"igraph\")");*/
			   rc.voidEval("library(igraph)");
			   rc.voidEval("data<-readLines(\"/home/sist/data/bookdetaile.txt\")");
				rc.voidEval("png(\"/home/sist/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BigBookProject/book.png\")");
				rc.voidEval("lword <- Map(extractNoun, data)");
			   rc.voidEval("lword <- unique(lword)");
			   rc.voidEval("lword <- sapply(lword, unique)");
			   rc.voidEval("filter1 <- function(x){nchar(x) <= 4 && nchar(x) >= 2 && is.hangul(x)}");
			   rc.voidEval("filter2 <- function(x){Filter(filter1, x)}");
			   rc.voidEval("lword <- sapply(lword, filter2)");
			   rc.voidEval("wordtran <- as(lword, \"transactions\")");
			   rc.voidEval("tranrules <- apriori(wordtran, parameter=list(supp=0.09, conf=0.8))");
			   rc.voidEval("rules <- labels(tranrules, ruleSep=\" \")");
			   rc.voidEval("class(rules)");
			   rc.voidEval("rules <- sapply(rules, strsplit, \" \", USE.NAMES=F)");
			   rc.voidEval("class(rules)");
			   rc.voidEval("rulemat <- do.call(\"rbind\", rules)");
			   rc.voidEval("class(rulemat)");
			   rc.voidEval("ruleg <- graph.edgelist(rulemat[c(1:54),], directed=F)");
			   rc.voidEval("plot.igraph(ruleg, vertex.label=V(ruleg)$name,vertex.label.cex=1.0,vertex.label.color='black',vertex.size=20,vertex.color='green',vertex.frame.color='blue')");
			   rc.voidEval("dev.off()");
			   rc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
