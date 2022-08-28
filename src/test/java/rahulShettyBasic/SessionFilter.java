package rahulShettyBasic;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
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

import org.hamcrest.text.IsEqualIgnoringCase;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionFilter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 SessionFilter session = new SessionFilter();
		
		 RestAssured.baseURI = "https://userapi.adda247.com";
		  
		  // Content of file can conver into byte> byte can be converted to string
		  
		 
	}

}
