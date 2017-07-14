<<<<<<< HEAD
package sampleapplication;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo {
	static MongoClient mc = new MongoClient("localhost");
	static MongoDatabase db = mc.getDatabase("test");
	static MongoCollection col = db.getCollection("restaurants");
	
	public static void main(String[] args) {
		System.out.println("Collection: " + col);
		
	}
	
	public void Insert() {
		
	}
}
=======
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
	
>>>>>>> master
