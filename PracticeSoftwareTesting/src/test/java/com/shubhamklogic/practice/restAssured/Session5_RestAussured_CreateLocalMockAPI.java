package com.shubhamklogic.practice.restAssured;

import org.testng.annotations.Test;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


/**
 * @author ssrivastava
 * 
 * Purpose: This test class works with Local 'Json-Server' (Node.js Package) to Create and Mock API
 * Details: Please check below file for more details about its installation and getting started steps
 * 		File : /PracticeSoftwareTesting/src/main/resources/ObjectRepository/getting_started_with_JOSN_server.txt
 * 
 * 
	>> API Resources-
		  http://localhost:3000/users
		  http://localhost:3000/subjects
		  http://localhost:3000/profile
	
	>> Server Home URL-
	  	  http://localhost:3000
 */


public class Session5_RestAussured_CreateLocalMockAPI {
	
	{
		RestAssured.baseURI = "http://localhost:3000";
	}
	
	
	/**
	 *  In this Test method - <br>
	 *  >> Working with GET <br>
	 *  >> + Logging all <br>
	 *  >> + Without saving details in 'Response' Object. <br>
	 */
	
	@Test(priority = 0)
	public void BasicTestGET_1() {
		
		RestAssured
			.given()
				.get("/users")
			.then()
				.log().all();
		
	}
	
	
	/**
	 *  In this Test method - <br>
	 *  >> Working with GET <br>
	 *  >> + Logging all
	 *  >> + Extracting 'Response' object.
	 *  
	 */
	
	@SuppressWarnings("rawtypes")
	@Test(priority = 0)
	public void BasicTestGET_2() {
		
		Response res = RestAssured
						.given()
							.get("/users/1")
						.then()
							.statusCode(200)
							.log().all()			// log
							.extract().response();	// extract resp.
						
		ResponseBody resBody = res.getBody();
		SeleniumHelperUtil.log( "resBody.prettyPrint() :: "+resBody.prettyPrint() );
		
	}
	
	
	/**
	 *  In this Test method - <br>
	 *  >> Working with GET <br>
	 *  >> + Passing Query Params. in GET req. <br>
	 *  >>   Logging all <br>
	 *  >>   Extracting 'Response' object.
	 *  
	 */
	
	@SuppressWarnings("rawtypes")
	@Test(priority = 0)
	public void BasicTestGET_3() {
		
		Response res = RestAssured
						.given()
							.get("/users?firstName=Shubham")
						.then()
							.log().all()			// First Log
							.extract().response();	// Then, Extract Res.
				
		SeleniumHelperUtil.log( "res.asPrettyString() :: " + res.asPrettyString());
	}

	/**
	 *  In this Test method - <br>
	 *  >> Working with GET <br>
	 *  >> + Passing Path Params. in GET req. <br>
	 *  >>   Logging all <br>
	 *  >>   Extracting 'Response' object.
	 *  
	 */
	
	@SuppressWarnings("rawtypes")
	@Test(priority = 0)
	public void BasicTestGET_4() {
		
		Response res = RestAssured
						.given()
							.pathParam("paramUserID", "2")
						.when()
							.get("/users/{paramUserID}")
						.then()
							.log().all()			// First Log
							.extract().response();	// Then only, Extract Res.
				
		SeleniumHelperUtil.log( "res.asPrettyString() :: " + res.asPrettyString());
	}
}
