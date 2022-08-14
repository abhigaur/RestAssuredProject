package dataDrivenpack;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PostAPIWithMultipleDataSet {

	@Test(dataProvider = "signUpData1")
	public void signUPwithDataDriven(Object email, Object name, Object password) {

		// Define URL
		RestAssured.baseURI = "https://userapi.adda247.com";

		RequestSpecification httpRequest = RestAssured.given();

		// Setting Body

		JSONObject requestPara = new JSONObject();

		requestPara.put("email", email);

		requestPara.put("name", name);

		requestPara.put("providerName", "email");

		requestPara.put("sec", password);

		httpRequest.body(requestPara.toJSONString());

		// Setting Header

		httpRequest.header("Content-Type", "application/json");

		httpRequest.header("x-auth-token", "fpoa43edty5");

		// Final Call to Hit Api

		Response response = httpRequest.request(Method.POST, "/register?src=aweb");

		// Getting Response

		String body = response.getBody().asString();

		System.out.println("Body is " + body);

		// Validation

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}

	// Hard coded value

	/*
	 * @DataProvider(name = "signUpData") public Object dataReader() { String[][]
	 * dataSet = { { "gpreen01@gmail.com", "nameOne", "123456" }, {
	 * "gpreen02@gmail.com", "nametwo", "123456" }, { "gpreen03@gmail.com",
	 * "nameThree", "123456" } };
	 * 
	 * return dataSet;
	 * 
	 * }
	 */
	

	@DataProvider(name = "signUpData1")
	public Object[][] dataReader100() {
		int rowCount = ExcelUtil.getRowCount("SignUpTest");

		int columnCount = ExcelUtil.getColCount("SignUpTest");

		Object[][] dataSet = new Object[rowCount][columnCount];

		for (int i = 1; i <=rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				dataSet[i-1][j] = ExcelUtil.getCellValue("SignUpTest", i, j);
				//System.out.println(dataSet[i-1][j]);
			}
		}

		return (dataSet);

	}

	/*
	 * @DataProvider(name = "signUpData1") public Object dataReader1() { int
	 * rowCount = ExcelUtil.getRowCount("SignUpTest");
	 * 
	 * int columnCount = ExcelUtil.getColCount("SignUpTest");
	 * 
	 * Object[][] dataSet = new Object[rowCount][columnCount];
	 * 
	 * for (int i = 0; i <= rowCount; i++) { for (int j = 0; j <= columnCount; j++)
	 * { dataSet[i][j] = ExcelUtil.getCellValue("SignUpTest", i, j); } }
	 * 
	 * return dataSet;
	 * 
	 * }
	 */

	/*
	 * public ArrayList<Object> readExcelSet() { ArrayList<Object> sheett =
	 * ExcelUtil.readCompleteExcelArray("SignUpTest"); return sheett; }
	 * 
	 * public Object[][] dataReader11() { int rowCount =
	 * ExcelUtil.getRowCount("SignUpTest");
	 * 
	 * int columnCount = ExcelUtil.getColCount("SignUpTest");
	 * 
	 * Object[][] dataSet = new Object[rowCount][columnCount];
	 * 
	 * ArrayList<Object> sheett = ExcelUtil.readCompleteExcelArray("SignUpTest");
	 * for (int i = 0; i < rowCount; i++) { for (int j = 0; j < columnCount; j++) {
	 * dataSet[i][j] = sheett; } }
	 * 
	 * return (dataSet);
	 * 
	 }
	 */

	

	public static void main(String[] args) {

		/*PostAPIWithMultipleDataSet p = new PostAPIWithMultipleDataSet();
		
		Object[][] value = p.dataReader100();
		
		int size = value.length;
		
		
		for (int i = 1; i <=size; i++) {
			for (int j = 0; j < columnCount; j++) {
				dataSet[i-1][j] = ExcelUtil.getCellValue("SignUpTest", i, j);
				//System.out.println(dataSet[i-1][j]);
			}
		

	}
*/
}}
