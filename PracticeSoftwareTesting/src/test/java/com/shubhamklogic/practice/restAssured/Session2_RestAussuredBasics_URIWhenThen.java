package com.shubhamklogic.practice.restAssured;

import org.testng.annotations.Test;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

// Other MockAPI = https://63f231f1f28929a9df55ca73.mockapi.io/api/v1/:

public class Session2_RestAussuredBasics_URIWhenThen {

	@Test(priority = 0)
	public void BasicTest_SettingBaseURI() throws InterruptedException {
		
		// Setting Base URI -
		RestAssured.baseURI = "https://63f231f1f28929a9df55ca73.mockapi.io/api/v1";
		Response res=null;
		
//		res = RestAssured.get("/users");
//		SeleniumHelperUtil.log("\nPretty String 1: res.asPrettyString()==>\n"+res.asPrettyString());
		
		res = null;
		res = RestAssured.get("/comments");
		SeleniumHelperUtil.log("asPrettyString() ==> \n"+res.asPrettyString());
	}
	
	@Test (priority = 1)
	public void BasicTest_WithoutSettingBaseURI() {
		
		// Without Setting Base URI -
		Response res = RestAssured.get("https://63f231f1f28929a9df55ca73.mockapi.io/api/v1/users");
		
		SeleniumHelperUtil.log("\nPretty String 2: res.statusLine()==>\n"+res.statusLine());
	}

	@Test
	public void BasicTest_GivenThenUse()
	{
		RestAssured
			.given()
				.get("https://reqres.in/api/users?page=2")
			.then()
				.statusCode(200)
				.body("data[1].email", equalTo("lindsay.ferguson@reqres.in"))
				.log().all(true);
	}
}