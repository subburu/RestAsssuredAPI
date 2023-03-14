package com.framework;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostRequest {
	
	@Test
	public void post()
	{
		RestAssured.baseURI ="https://reqres.in/";
		
	RestAssured.given().body("") .post() .then() .log() .all() .assertThat()
		  .statusCode(201);
		 
		
		String json="Test";
		RestAssured.given().body(json)
		.post()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(201);
		
		
	}

}
