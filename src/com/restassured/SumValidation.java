
package com.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.files.Payload;

import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumOfCourses()
	
	{
		JsonPath js = new JsonPath(Payload.CoursePrice());

	    int count = js.get("courses.size()");
	
		int sum=0;
		int totalsum=0;
		for (int i=0;i<count;i++)
		{
			int price=js.get("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			sum=price*copies;
			totalsum=totalsum+sum;
		}
	  
		System.out.println("sum of all courses with copies"+" "+totalsum);
		
		int purchase=js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(totalsum, purchase);
		
		
		
		
		
	}
}
