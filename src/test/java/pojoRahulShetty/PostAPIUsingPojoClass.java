package pojoRahulShetty;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostAPIUsingPojoClass {
	
	
	Pojo p= new Pojo();
	
	
	
	@Test
	
	public void testPostAPI()
	{
		
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		
		p.setWebsite("http://google.com");
		
		
		
		List<String> list= new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		
		p.setTypes(list);
		
		
		Location lo= new  Location();
		lo.setLat(-38.383494);
		lo.setLng(33.427362);
		
		
		
		p.setLocation(lo);
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	String response = given().log().all().
		queryParam("key", "qaclick123").
		header("content-type", "application/json").
		body(p).
		when().log().all().
		post("/maps/api/place/add/json").then().extract().response().asString();
	
	System.out.println("response is "+response);
	
	
	}

}
