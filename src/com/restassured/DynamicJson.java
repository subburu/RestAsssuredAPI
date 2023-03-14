package com.restassured;

import org.testng.annotations.Test;

import com.files.Payload;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class DynamicJson {
	
	
	
	@Test
	public void addBook()
	{
		
		RestAssured.baseURI="http://216.10.245.166";
	    String response=given().header("Content-type ","application/json").
		body(Payload.addBook()).
		when()
		.post("/Library/Addbook.php").then().assertThat().statusCode(200)
		.extract().response().asString();
		
		
		
		
		
		
		
		
		
		
			
		
	}

}
