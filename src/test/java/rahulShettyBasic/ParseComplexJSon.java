package rahulShettyBasic;

import files.PayloadPostAPI;
import io.restassured.path.json.JsonPath;

public class ParseComplexJSon {

	public static void main(String[] args) {
		
		

		/*
		 * 

			1. Print No of courses returned by API

			2.Print Purchase Amount

			3. Print Title of the first course

			4. Print All course titles and their respective Prices

			5. Print no of copies sold by RPA Course

			6. Verify if Sum of all Course prices matches with Purchase Amount

		 */
		
		
		
		JsonPath jp= new JsonPath(PayloadPostAPI.complexJson());
		
		//System.out.println(jp.getString("dashboard.purchaseAmount"));
		
	//	1. Print No of courses returned by API
		
		
		int sizeCourse = jp.get("courses.size()");
		
		System.out.println("Total courses size is "+sizeCourse);
		
		
		// .Print Purchase Amount
		
		
		int totalAmount = jp.get("dashboard.purchaseAmount");
		
		System.out.println("Total amount is"+totalAmount);
		
		
		//3. Print Title of the first course
		
		String firstCoursesTitle = jp.get("courses[0].title");
		
		System.out.println("First course time is "+firstCoursesTitle);
		
		//	4. Print All course titles and their respective Prices
		
		
		for(int i=0;i<sizeCourse;i++)
		{
			
			String titleCourse = jp.get("courses["+i+"].title");

			int priceIdiviaula=jp.get("courses["+i+"].price");
			
			System.out.println("Title of course is"+titleCourse);

			System.out.println("Title of course is"+priceIdiviaula);
		}
		
		
		//	5. Print no of copies sold by RPA Course
		
		
		for(int i=0;i<sizeCourse;i++)
		{
			
			if(jp.get("courses["+i+"].title").equals("RPA"))
			{
				int numbserCopies=jp.get("courses["+i+"].copies");
				System.out.println("Number of copies of RAP is"+numbserCopies);
				break;
			}
			
		}
		
	}
}
