package com.restassured;

import org.testng.annotations.Test;

import com.files.Payload;

import io.restassured.path.json.JsonPath;

public class SumofCourses {

	@Test
	public void sumvalidation()
	{
       int sum=0;		
		JsonPath js = new JsonPath(Payload.CoursePrice());
		int count = js.getInt("courses.size()");

		 for (int i=0;i<count;i++)
		 {
			int price=js.get("courses["+i+"].price");
			int copies=js.get("courses["+i+"].copies");
			int amount=price*copies;
			System.out.println(amount);
			sum=sum+amount;
			
		 }

	}
}
