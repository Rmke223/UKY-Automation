package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoAPI {

	@Test
	public void DemoUKYAPI() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Response Type = " + response.getHeader("content-type"));
		System.out.println("Server Response Time = " + response.getTime());
		System.out.println("Response Status = " + response.getStatusLine());
		System.out.println("Response Body = " + response.getBody().asString());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
}
