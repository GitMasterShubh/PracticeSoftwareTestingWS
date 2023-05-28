package com.shubhamklogic.practice.restAssured;

import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.json.simple.JSONObject;
 import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

// Other Pvt MockAPI = https://63f231f1f28929a9df55ca73.mockapi.io/api/v1/users:
// Sample Cred saved in prop file

public class Session3_RestAussured_GetPostMethods {

	@Test(priority = 0)
	public void BasicTestGET() throws InterruptedException {
		
		RestAssured
			.given()
				.get("https://reqres.in/api/users?page=2")
			.then()
				.statusCode(200)
				.log().all()
				.body(("data[5].first_name"), equalToIgnoringCase("rachel"));
				
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority = 1)
	public void BasicTestPOST() throws InterruptedException {
	
		JSONObject req = new JSONObject();
		req.put("name", "Shubh");
		req.put("job", "SDET");
		
		RestAssured.baseURI = "https://reqres.in";
		
		RestAssured
			.given()
//				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(req.toJSONString())
				.log().all()
			.when()
				.post("/users")
			.then()
				.statusCode(201)
				.log().all();
	}
}
