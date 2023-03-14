package com.restassured;

import com.files.Payload;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String args[]) {
		JsonPath js = new JsonPath(Payload.CoursePrice());

		int count = js.getInt("courses.size()");
		System.out.println("1.Print No of courses returned by API ?" +" "+count);

		int totalAmount = js.get("dashboard.purchaseAmount" );
		System.out.println("2.Print Purchase Amount ?" +" "+totalAmount);

		String titlefirstcourse = js.get("courses[0].title");
		System.out.println("3.Print the title of the first courses? "+" "+titlefirstcourse);
		
		
		
		// Get all the courses 
		 for (int i=0;i<count;i++)
		 {
			
		  String course=js.get("courses["+i+"].title");
		  int price=js.get("courses["+i+"].price");
		  System.out.println(course+" == "+price);
			
			
		 }
		// number of copies of RPA 
		 System.out.println("Number of copies of RPA");
		 
		 for (int i=0;i<count;i++)
		 {
			 String courseTitles=js.get("courses["+i+"].title");
			 if (courseTitles.equalsIgnoreCase("RPA"))
			 {
				 int copies=js.get("courses["+i+"].copies");
				 System.out.println("5.Print  of copies sold by RPA course "+copies+" "+"RPA copies");
				 break;
				 
			 }
		 }
		 int totalsum=0;
		 int sum=0;
		 for (int i=0;i<count;i++)
		 {
			  int price=js.get("courses["+i+"].price");
			  int copies=js.get("courses["+i+"].copies");
			  sum=price*copies;
			  totalsum=totalsum+sum;

			
		 }
		 
		 System.out.println("Sum of all copies ="+ totalsum);
		 
		
		 
		 
	}

}
