package com.shubhamklogic.practice.restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * 
 * @author ssrivastava
 * To Successfully Test this Test cases,
 * 1) ( Optional step, if already installed :) Install Json Server -  Tutorial : https://www.youtube.com/watch?v=V7sLq7u28BA&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=8
 * 2) ( Required step :) Open New Terminal and Run below command to load json file for Localhost APIs - 
 *	
 *	--> npx json-server --watch /Users/ssrivastava/shubh-workspace/PracticeTech/SoftwareTestingRepo/PracticeSoftwareTestingWS/PracticeSoftwareTesting/src/main/resources/JsonServerFile/db.json --port 3000
 * 
 * 3) To see responses of API calls, Open any browser and hit - 
 *  --> Syntax: localhost:3000/<API>
 *  --> Example: localhost:3000/users
 *  --> Example: localhost:3000/profiles
 *  --> Example: localhost:3000/<WhatEverAPIsWrittenInDBjsonFile>
 * 
 */

public class Session6_RestAussured_CRUD_LocalhostAPI {
	
	@Test
	public void getUsers(){
		
		RestAssured.baseURI = "http://localhost:3000";
		
		Response res = RestAssured
						.given()
							.header( "Authorization", "sampleSESSION_ID" )
							.header( "_csrfToken", "sampleCSRFToken" )
							.header( "Content-Type","application/json" )
							.header( "Accept","application/json" )
							.expect()
								.statusCode( 200 )
							.log().all()
						.when()
							.get("/users");
	}
	
	public void getUser(){
		
		RestAssured.baseURI = "";
		
	}
}