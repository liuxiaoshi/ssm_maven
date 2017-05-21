package com.lxs.ssm.test;

import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongodbTest {

	
	@Test
	public void  testConcetion01(){
		// 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient( "192.168.1.108" , 27017 );
      
        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("lxs01");
        mongoDatabase.createCollection("qqq");
        System.out.println("Connect to database successfully");
	}
}
