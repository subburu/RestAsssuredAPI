package com.framework;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GetRequest {

	@Test
	public void test_01()
	{
		
		RestAssured.baseURI ="https://reqres.in/";
		/*RestAssured.given().param("page","2")
		.when()
		.get()
		.then()
		.assertThat()
		.log()
		.all()
		.statusCode(200);*/
		
	Response response =RestAssured.given().param
			("page","2").when().get();
	System.out.println(response.getBody().asString());
	System.out.println("get status code "+ response.getStatusCode());
	System.out.println(response.getContentType());
	System.out.println("Time"+response.getTime());
	System.out.println("Cookies"+response.getCookies());
	System.out.println("Cookies"+response.prettyPrint());
	
		
		
		
		
		
	}
	
}
