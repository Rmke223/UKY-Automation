package StepDefinitions;



import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DBconnection {

	private MongoClient mongoclient;
	private MongoDatabase database;
	private Document randomDocument;
	
	@Given("^I connect to the \"(.*)\" DB$")
	public void i_connect_to_the_db(String collectionName) {
		mongoclient = MongoClients.create("mongodb+srv://admin:admin@ukymongo.hlqooes.mongodb.net/?retryWrites=true&w=majority");
        database = mongoclient.getDatabase("sample_restaurants");
        MongoCollection<Document> collection = database.getCollection(collectionName);
        long count = collection.countDocuments();
        int randomIndex = (int) (Math.random() * count);
        List<Bson> pipeline = Arrays.asList(
            Aggregates.skip(randomIndex),
            Aggregates.limit(1)
        );
        randomDocument = collection.aggregate(pipeline).first();
        System.out.println(collection.aggregate(pipeline).first());
	}
	
	@Then("^I check that an object was pulled from the db$")
	public void I_check_that_an_object_was_pulled_from_the_db() {
		if(randomDocument != null) {
			System.out.println("Document found");
		}
		else {
			System.out.println("Document not found");
		}
		mongoclient.close();
	}
}
