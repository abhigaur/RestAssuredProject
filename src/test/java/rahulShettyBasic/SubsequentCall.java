package rahulShettyBasic;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class SubsequentCall {

// using jwt tocken and validate other call	

	String token;

	
	  @Test(priority = 1) 
	  public void addaLogin() throws IOException {
	  
	  RestAssured.baseURI = "https://userapi.adda247.com";
	  
	  // Content of file can conver into byte> byte can be converted to string
	  
	  
	String response = given().log().all().queryParam("src", "aweb").header("x-auth-token",
	  "fpoa43edty5").header("user-agent",
	  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36"
	  ) .header("content-type", "application/json") .body(new
	  String(Files.readAllBytes(Paths.get(
	  "C:\\Users\\adda247\\eclipse-workspace\\RestAssuredProject\\src\\test\\java\\files\\jsonFile.json"
	  ))))
	  .when().post("login").then().log().all().extract().response().asString();
	  
	  JsonPath path= new JsonPath(response);
	  
	   token = path.get("jwtToken");
	  
	  System.out.println("Token is "+ token);
	  
	  
	 }
	 

		
		  @Test(priority = 2)
		  
		  public void getTestSeries() { RestAssured.baseURI =
		  "https://store.adda247.com";
		  
		  String response = given().queryParam("src","aweb").header("x-auth-token",
		  "fpoa43edty5"). header(
		  "user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36"
		  ) .header("content-type","application/json").header("x-jwt-token",token).when().get("/api/v1/test-series").then().log()
		  .all().extract().response().asString();
		  
		  System.out.println(response);
		  
		  }
		 
}
