package sampleapplication;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo {
	static MongoClient mc = new MongoClient("localhost");
	static MongoDatabase md = mc.getDatabase("test");
	static MongoCollection col = md.getCollection("restaurants");
	
	public static void Main(String[] args){
		
	}
}
