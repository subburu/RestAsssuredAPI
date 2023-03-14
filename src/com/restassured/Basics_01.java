package com.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import com.files.Payload;

public class Basics_01 {
	
	public static void main (String args[])
	{
		/*
		 * Validate if Add place API is working as expected Given : All input details
		 * When : Submit the API Then : Validate the response
		 */
		
		/*
		 * Add place Update place get place
		 */System.out.println(" Add Place");
		RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=	given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
			System.out.println(response);
			
			JsonPath js=new JsonPath(response); // for parsion Json
	    	String placeId=	js.get("place_id");
			System.out.println(placeId);
			// Update Place
			System.out.println(" update Place");
			String  newaddress="Summer Walk,India";
			given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
			.body("{\r\n"
					+ "\"place_id\":\""+placeId+"\",\r\n"
					+ "\"address\":\""+newaddress+",\r\n"
					+ "\"key\":\"qaclick123\"\r\n"
					+ "}\r\n"
					+ "").when().put("maps/api/place/update/json")
			.then().statusCode(200).assertThat().body("msg",equalTo("Address successfully updated"));
			
			/// Get place 
			
			System.out.println(" Get Place");
			String getplacResponse=given().log().all().queryParam("key", "qaclick123").
			queryParam("place_Id", placeId).when().get("maps/api/place/get/json")
			.then().assertThat().log().all().statusCode(200).extract().
			response().asString();
			
			JsonPath js1=new JsonPath(getplacResponse);
			String actualAddress=js1.getString("address");
			System.out.println(actualAddress);
			Assert.assertEquals(actualAddress, newaddress);
			
			
		
		
		
		
	}

}
