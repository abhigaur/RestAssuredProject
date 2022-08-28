package pojoRahulShetty;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

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

public class ReqSpecBuilder {

	Pojo p = new Pojo();

	@Test

	public void testPostAPI() {

		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");

		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");

		p.setWebsite("http://google.com");

		List<String> list = new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");

		p.setTypes(list);

		Location lo = new Location();
		lo.setLat(-38.383494);
		lo.setLng(33.427362);

		p.setLocation(lo);

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();

		RequestSpecification res = given().spec(req).body(p);
		
		
		ResponseSpecification responses = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();

		String response = res.when().post("/maps/api/place/add/json").then().spec(responses).extract().response()
				.asString();

		System.out.println("response is " + response);
		
		
		

	}

}
