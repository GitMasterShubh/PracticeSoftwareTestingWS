package com.shubhamklogic.practice.restAssured;

import org.testng.annotations.Test;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Other Pvt MockAPI = https://63f231f1f28929a9df55ca73.mockapi.io/api/v1/users:
// Sample Cred saved in prop file
/**
		 API BaseURI
		 https://63f231f1f28929a9df55ca73.mockapi.io/api/v1/:endpoint
		 
 		 API endpoints

         GET /users
 
         GET /users/:id
 
         POST /users
 
         PUT /users/:id
 
         DELETE /users/:id
 
         Sample Result : GET :: /users
 
         [
			 {
			  "createdAt": "2023-02-18T16:41:18.830Z",
			  "name": "Doyle Walsh",
			  "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/26.jpg",
			  "id": "1"
			 },
			 {
			  "createdAt": "2023-02-19T03:10:01.885Z",
			  "name": "Kristopher Kuphal",
			  "avatar": "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/636.jpg",
			  "id": "2"
			 }
		   ] 
 */

public class Session4_RestAussured_PutPatchDeleteMethods {
	
	//Set Base URI for all subsequent calls..
	{
		RestAssured.baseURI = "https://63f231f1f28929a9df55ca73.mockapi.io/api/v1";
	}

	@Test(priority = 0)
	public void BasicTestGET() throws InterruptedException {
		
		RestAssured
			.given()
				.get("/users")
			.then()
				.statusCode(200)
				.log().all();
	}

	@Test(priority = 1)
	public void BasicTestPOST() throws InterruptedException {
		
		Response res = RestAssured
						.given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
						.when()
							.post("/users")
						.thenReturn();
							
		SeleniumHelperUtil.log("\n\nRes==="+res.getStatusLine());
		
	}

	
	@Test(priority = 2)
	public void BasicTestPUT() throws InterruptedException {
		
		Response res = RestAssured
						.given()
							.body("[]")
						.when()
							.put("/users/2")
						.thenReturn();
		
		
		SeleniumHelperUtil.log(res.statusLine());
	}

	@Test(priority = 3)
	public void BasicTestPATCH() throws InterruptedException {
		System.out.println("PATCH to be complete...");
	}

	@Test(priority = 4)
	public void BasicTestDELETE() throws InterruptedException {
		
		System.out.println("DELETE to be complete...");
		
	}
}
