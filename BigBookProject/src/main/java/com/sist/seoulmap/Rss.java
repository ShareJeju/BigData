package com.sist.seoulmap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/*
   JAXB( JAVA APP XML BIND)
   
   
 클래스로 인식^^
 <Rss> ==> Rss{channel}
    <channel>
       <item> ==> 100개       
    </channel>
 </Rss>
 
 */
@XmlRootElement
public class Rss {
	private Channel channel = new Channel();

	public Channel getChannel() {
		return channel;
	}
	
	@XmlElement
	public void setChannel(Channel channel) {
		this.channel = channel;
	}

}
