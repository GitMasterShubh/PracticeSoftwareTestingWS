package com.shubhamklogic.practice.restAssured;

import org.testng.annotations.Test;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Session1_RestAussuredBasics {

	@Test
	public void BasicTest(){
		
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		
		// Log Response As Pretty String-
		SeleniumHelperUtil.log( "res.asPrettyString() :: " + res.asPrettyString() );
		
		// Log Response as String-
		SeleniumHelperUtil.log("res.asString() :: "+res.asString());
		
		// Log Response content Type
		SeleniumHelperUtil.log("res.contentType() :: "+res.contentType());
		
		// Log Response Status Line
		SeleniumHelperUtil.log("res.getStatusLine() :: "+res.getStatusLine());
		
		// Log Response cookies().toString()
		SeleniumHelperUtil.log("res.cookies().toString() :: "+res.cookies().toString());

		// Log Response body().toString()
		SeleniumHelperUtil.log( "res.body().toString() :: "+res.body().toString() );
	}
}
