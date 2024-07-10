package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import api.endpoint.CategoryTreeEndpoint;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class CategoryTreeTest {
	

	@Test(groups = {"Response Code"})
	public void VerifyStatusCodewithValid() {
//		logger.info("*****************Calling CategoryTree API with valid data ******************");
		Response response = CategoryTreeEndpoint.getCategoryTree();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		response.then().log().body();
//		logger.info("*****************Verified CategoryTree API Response ******************");
	}
	@Test(groups = {"Response Time"})
	public void VerifyCategoryTree_ResponseTime() {
//		logger.info("*****************Calling CategoryTree API with valid data ******************");
		Response response = CategoryTreeEndpoint.getCategoryTree();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		response.then().log().body();
		long time = response.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Time in milliseconds : " + time);
		AssertJUnit.assertTrue(time < 3000);
//		logger.info("*****************Verified CategoryTree API Response ******************");
	}

	@Test()
	public void VerifyResponseTimewithValidData() {
//		logger.info("*****************Calling CategoryTree API with valid data ******************");
		Response response = CategoryTreeEndpoint.getCategoryTree();
		System.out.println(response.getTime());
		AssertJUnit.assertTrue(response.getTime() < 2000);
//		logger.info("*****************Verified CategoryTree API Response ******************");
	}

	@Test()
	public void VerifyContentTypewithValid() {
//		logger.info("*****************Calling CategoryTree API content-type with valid data ******************");
		Response response = CategoryTreeEndpoint.getCategoryTree();
		AssertJUnit.assertEquals(response.contentType(), "application/json");
//		response.then().log().all();
//		logger.info("*****************Verified CategoryTree API content type ******************");
	}

	@Test()
	public void VerifyCategoryTreeStatusCodeWithInvalidQueryParameter() {
//		logger.info("************Calling CategoryTree API with invalid Querry Parameter ***********");
		Response response = CategoryTreeEndpoint.getCategoryTreeInvalidQuery();
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 404);
	}

	@Test()
	public void VerifyCategoryTree_Data_WithInvalidQueryParameter() {
//		logger.info("************Calling CategoryTree API with invalid Querry Parameter ***********");
		Response response = CategoryTreeEndpoint.getCategoryTreeInvalidQuery();
		response.then().log().all();
		String data = response.jsonPath().getString("data");
		System.out.println(data);
		AssertJUnit.assertEquals(data, null);
	}

	// ------------Calling API with invalid querry parameter
	@Test()
	public void VerifyResponseCodeWithInvalidQueryParameter() {

//		logger.info("*****************Calling CategoryTree API with invalid Querry Parameter to verfy the Error Code & Error Message ******************");
		Response response = CategoryTreeEndpoint.getCategoryTreeInvalidQuery();
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 404);

	}

	@Test()
	public void VerifyErrorCodeAndErrorMessageWithInvalidQueryParameter() {

//		logger.info("*****************Calling CategoryTree API with invalid Querry Parameter to verfy the Error Code & Error Message ******************");
		Response response = CategoryTreeEndpoint.getCategoryTreeInvalidQuery();
		response.then().log().all();

		String errCode = response.jsonPath().get("errors[0].errorCode").toString();
		String errMsg = response.jsonPath().getString("errors[0].errorMessage").toString();

		AssertJUnit.assertEquals(errCode, "FAILED.TO.GET.DATA");
		AssertJUnit.assertEquals(errMsg, "Data not found for given Input");
	}

	@Test()
	public void VerifyDataWithInvalidQueryParameter() {

//		logger.info("*****************Calling CategoryTree API with invalid Querry Parameter to verfy the Error Code & Error Message ******************");
		Response response = CategoryTreeEndpoint.getCategoryTreeInvalidQuery();
		response.then().log().all();
		String data = response.jsonPath().getString("data");
		System.out.println(data);
		AssertJUnit.assertEquals(data, null);
	}

	// ------------Calling API with without querry parameter
	@Test()
	public void VerifyCategoryTreeStatusCodeWithoutQueryParameter() {
//		logger.info("*****************Calling CategoryTree API withour Querry Parameter ******************");
		Response response = CategoryTreeEndpoint.getCategoryTreeWithoutQuery();
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 400);
	}

	@Test()
	public void VerifyCategoryTreeWithoutQueryParameter() {
//		logger.info("*****************Calling CategoryTree API withour Querry Parameter ******************");
		Response response = CategoryTreeEndpoint.getCategoryTreeWithoutQuery();
		response.then().log().all();
		String errCode = response.jsonPath().get("errors[0].errorCode").toString();
		String errMsg = response.jsonPath().getString("errors[0].errorMessage").toString();

		AssertJUnit.assertEquals(errCode, "All required values must be provided.");
		AssertJUnit.assertEquals(errMsg,
				"Required request parameter 'mastApplicability' for method parameter type String is not present");
	}

	@Test()
	public void VerifyCategoryTreeDataWithoutQueryParameter() {
//		logger.info("*****************Calling CategoryTree API withour Querry Parameter ******************");
		Response response = CategoryTreeEndpoint.getCategoryTreeWithoutQuery();
		response.then().log().all();
		String data = response.jsonPath().getString("data");
		System.out.println(data);
		AssertJUnit.assertEquals(data, null);
	}

	@Test()
	public void VerifyCategoryTreeHeaders() {
//		logger.info("*****************Calling CategoryTree API to validate API headers ******************");
		Response response = CategoryTreeEndpoint.getCategoryTree();
		AssertJUnit.assertEquals(response.getHeader("Content-Type"), "application/json");
		AssertJUnit.assertEquals(response.getHeader("Connection"), "keep-alive");
		AssertJUnit.assertEquals(response.getHeader("X-XSS-Protection"), "1; mode=block");
		AssertJUnit.assertEquals(response.getHeader("Content-Security-Policy"), "default-src 'self' blob:; img-src 'self' blob:; script-src 'unsafe-eval' 'unsafe-inline' 'self' https://cf.msilcrm.co.in/* https://*.msilcrm.co.in/ https://crm-dev-static-website.s3.ap-south-1.amazonaws.com/uniagentDialerFunc.js;  font-src 'self' blob:; style-src 'self' 'unsafe-inline'; frame-src *; connect-src 'self' https://cf.msilcrm.co.in/ https://*.msilcrm.co.in/ https://*.cloudfront.net https://*.amazonaws.com https://www.preprod.marutisuzukisubscribe.com https://*.amazoncognito.com https://*.cf.marutisuzukisubscribe.com https://*.msilcrm.co.in https://msilcrm.co.in; blob:");
		AssertJUnit.assertEquals(response.getHeader("x-amzn-Remapped-Connection"), "keep-alive");
		AssertJUnit.assertEquals(response.getHeader("Strict-Transport-Security"), "max-age=63072000; includeSubdomains; preload");
		AssertJUnit.assertEquals(response.getHeader("X-Frame-Options"), "DENY");
		AssertJUnit.assertEquals(response.getHeader("Referrer-Policy"), "same-origin");
		AssertJUnit.assertEquals(response.getHeader("Server"), "Unspecified");
		AssertJUnit.assertEquals(response.getHeader("Vary"), "Origin");
		AssertJUnit.assertEquals(response.getHeader("X-Cache"), "Miss from cloudfront");
		AssertJUnit.assertEquals(response.getHeader("X-Amz-Cf-Pop"), "DEL54-P7");
	}

	@Test()
	public void VerifyCateforyTreeSchema() {
//		logger.info("*****************Calling CategoryTree API with valid data ******************");
		Response response = CategoryTreeEndpoint.getCategoryTree();
//		response.then().log().body();
		File file=new File("/Users/avinashmaurya/eclipse-workspace/MSILPartsKartRestAssuredAPIAutomation/src/test/resources/Schema/SchemaCategoryTree.json");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
//		logger.info("*****************Verified CategoryTree API Response ******************");
	}
}
