package sampleapplication;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;

public class Mongo {
	static MongoClient mc = new MongoClient("192.168.23.133", 27017);
	static DB db = mc.getDB("test");
	static DBCollection col = db.getCollection("students");
	static DBCursor dc = col.find();
	
	public static void main(String[] args){
		String[] coords = new String[2];
		coords[0] = "-1.0237";
		coords[1] = "32.13572";
		
		BasicDBObject[] grades = new BasicDBObject[2];
		grades[0] = new BasicDBObject("date", "ISODate('2017-03-02T00:00:00Z')").append("grade", "A").append
				("score", "7");
		grades[1] = new BasicDBObject("date", "ISODate('2017-01-02T00:00:00Z')").append("grade", "B").append
				("score", "5");
		
		BasicDBObject dbobj = new BasicDBObject("_id", "ObjectId('596673ea149066c1eb4e5e76')").append
				("address", new BasicDBObject("building", "1337").append("coord", coords).append("street", "Good St.").append
				("zipcode", 10467)).append("borough", "Bronx").append("cuisine", "Fish").append("grades", grades).append
				("name", "The Good Fish Place").append("restaurant_id", "30541130");
		BasicDBObject other = new BasicDBObject("_id", "ObjectId('596673ea149066c1eb4e5e76')").append
				("address", new BasicDBObject("building", "1337").append("coord", coords).append("street", "Good St.").append
				("zipcode", 10467)).append("borough", "Not Bronx").append("cuisine", "Fish").append("grades", grades).append
				("name", "The Good Fish Place").append("restaurant_id", "30541130");
		
		BasicDBObject d = new BasicDBObject();
		d.append("_id", "ObjectId('596673ea149066c1eb4e5e76')");
		
		String[] times = new String[2];
		times[0] = "6-8am";
		times[1] = "7-10pm";
		String[] courses = new String[5];
		courses[0] = "Math";
		courses[1] = "Science";
		courses[2] = "Social Studies";
		courses[3] = "English";
		courses[4] = "Spanish";
		BasicDBObject student1 = new BasicDBObject("phones", new BasicDBObject("home", "5021234567").append
				("cell", "5027654321").append("hours", times)).append("houses", new BasicDBObject
				("address", "111 Best St.").append("zipcode", "40215").append("color", "biege")).append
				("courses", courses).append("name", "Nodroj").append("gpa", "3.5");
		BasicDBObject otherStudent = new BasicDBObject("phones", new BasicDBObject("home", "5021234567").append
				("cell", "5027654321").append("hours", times)).append("houses", new BasicDBObject
				("address", "121 Best St.").append("zipcode", "40215").append("color", "red")).append
				("courses", courses).append("name", "Nj").append("gpa", "3.8");
		
		BasicDBObject e = new BasicDBObject();
		e.append("_id", new ObjectId("596d21725d478544f05ead45"));
		
		Mongo m = new Mongo();
		//m.Create(dbobj);
		//m.Read();						this stuff is for
		//m.Update(dbobj, other);			restaurants
		//m.Delete(d);
		
		//m.Create(student1);
		//m.Read();								this stuff is
		//m.Update(student1, otherStudent);			student
		//m.Delete(e);
	}
	//Inserts a new restaurant
	public void Create(DBObject dbobj){
		col.insert(dbobj);
		System.out.println("Created new document");
	}
	//Reads all restaurant names
	public void Read() {
		int i = 1;
		
        while (dc.hasNext()) { 
           System.out.println(dc.next()); 
           i++;
        }
		System.out.println("Read all documents");
	}
	//Updates the specified field
	public void Update(BasicDBObject bdbobj, BasicDBObject other) {
		col.update(bdbobj, other);
		System.out.println("Updated document");
	}
	//Deletes the first field
	public void Delete(BasicDBObject d) {
		col.remove(d);
		System.out.println("Removed document");
	}
}


