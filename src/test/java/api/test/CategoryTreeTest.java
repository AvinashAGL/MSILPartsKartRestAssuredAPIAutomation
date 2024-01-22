package api.test;

import org.testng.annotations.Test;

import java.io.File;

import org.testng.Assert;

import api.base.config;
import api.endpoint.microserviceEndpoints2;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CategoryTreeTest extends config {

	@Test()
	public void VerifyStatusCodewithValid() {
		logger.info("*****************Calling CategoryTree API with valid data ******************");
		Response response = microserviceEndpoints2.getCategoryTree();
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().body();
		logger.info("*****************Verified CategoryTree API Response ******************");
	}

	@Test()
	public void VerifyResponseTimewithValidData() {
		logger.info("*****************Calling CategoryTree API with valid data ******************");
		Response response = microserviceEndpoints2.getCategoryTree();
		System.out.println(response.getTime());
		Assert.assertTrue(response.getTime() < 2000);
		logger.info("*****************Verified CategoryTree API Response ******************");
	}

	@Test()
	public void VerifyContentTypewithValid() {
		logger.info("*****************Calling CategoryTree API content-type with valid data ******************");
		Response response = microserviceEndpoints2.getCategoryTree();
		Assert.assertEquals(response.contentType(), "application/json");
//		response.then().log().all();
		logger.info("*****************Verified CategoryTree API content type ******************");
	}

	@Test()
	public void VerifyCategoryTreeStatusCodeWithInvalidQueryParameter() {
		logger.info("************Calling CategoryTree API with invalid Querry Parameter ***********");
		Response response = microserviceEndpoints2.getCategoryTreeInvalidQuery();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 404);
	}

	@Test()
	public void VerifyCategoryTree_Data_WithInvalidQueryParameter() {
		logger.info("************Calling CategoryTree API with invalid Querry Parameter ***********");
		Response response = microserviceEndpoints2.getCategoryTreeInvalidQuery();
		response.then().log().all();
		String data = response.jsonPath().getString("data");
		System.out.println(data);
		Assert.assertEquals(data, null);
	}

	// ------------Calling API with invalid querry parameter
	@Test()
	public void VerifyResponseCodeWithInvalidQueryParameter() {

		logger.info(
				"*****************Calling CategoryTree API with invalid Querry Parameter to verfy the Error Code & Error Message ******************");
		Response response = microserviceEndpoints2.getCategoryTreeInvalidQuery();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 404);

	}

	@Test()
	public void VerifyErrorCodeAndErrorMessageWithInvalidQueryParameter() {

		logger.info(
				"*****************Calling CategoryTree API with invalid Querry Parameter to verfy the Error Code & Error Message ******************");
		Response response = microserviceEndpoints2.getCategoryTreeInvalidQuery();
		response.then().log().all();

		String errCode = response.jsonPath().get("errors[0].errorCode").toString();
		String errMsg = response.jsonPath().getString("errors[0].errorMessage").toString();

		Assert.assertEquals(errCode, "FAILED.TO.GET.DATA");
		Assert.assertEquals(errMsg, "Data not found for given Input");
	}

	@Test()
	public void VerifyDataWithInvalidQueryParameter() {

		logger.info(
				"*****************Calling CategoryTree API with invalid Querry Parameter to verfy the Error Code & Error Message ******************");
		Response response = microserviceEndpoints2.getCategoryTreeInvalidQuery();
		response.then().log().all();
		String data = response.jsonPath().getString("data");
		System.out.println(data);
		Assert.assertEquals(data, null);
	}

	// ------------Calling API with without querry parameter
	@Test()
	public void VerifyCategoryTreeStatusCodeWithoutQueryParameter() {
		logger.info("*****************Calling CategoryTree API withour Querry Parameter ******************");
		Response response = microserviceEndpoints2.getCategoryTreeWithoutQuery();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 400);
	}

	@Test()
	public void VerifyCategoryTreeWithoutQueryParameter() {
		logger.info("*****************Calling CategoryTree API withour Querry Parameter ******************");
		Response response = microserviceEndpoints2.getCategoryTreeWithoutQuery();
		response.then().log().all();
		String errCode = response.jsonPath().get("errors[0].errorCode").toString();
		String errMsg = response.jsonPath().getString("errors[0].errorMessage").toString();

		Assert.assertEquals(errCode, "All required values must be provided.");
		Assert.assertEquals(errMsg,
				"Required request parameter 'mastApplicability' for method parameter type String is not present");
	}

	@Test()
	public void VerifyCategoryTreeDataWithoutQueryParameter() {
		logger.info("*****************Calling CategoryTree API withour Querry Parameter ******************");
		Response response = microserviceEndpoints2.getCategoryTreeWithoutQuery();
		response.then().log().all();
		String data = response.jsonPath().getString("data");
		System.out.println(data);
		Assert.assertEquals(data, null);
	}

	@Test()
	public void VerifyCategoryTreeHeaders() {
		logger.info("*****************Calling CategoryTree API to validate API headers ******************");
		Response response = microserviceEndpoints2.getCategoryTree();
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		Assert.assertEquals(response.getHeader("Connection"), "keep-alive");
		Assert.assertEquals(response.getHeader("X-XSS-Protection"), "1; mode=block");
		Assert.assertEquals(response.getHeader("Content-Security-Policy"), "default-src 'self' blob:; img-src 'self' blob:; script-src 'unsafe-eval' 'unsafe-inline' 'self' https://cf.msilcrm.co.in/* https://*.msilcrm.co.in/ https://crm-dev-static-website.s3.ap-south-1.amazonaws.com/uniagentDialerFunc.js;  font-src 'self' blob:; style-src 'self' 'unsafe-inline'; frame-src *; connect-src 'self' https://cf.msilcrm.co.in/ https://*.msilcrm.co.in/ https://*.cloudfront.net https://*.amazonaws.com https://www.preprod.marutisuzukisubscribe.com https://*.amazoncognito.com https://*.cf.marutisuzukisubscribe.com https://*.msilcrm.co.in https://msilcrm.co.in; blob:");
		Assert.assertEquals(response.getHeader("x-amzn-Remapped-Connection"), "keep-alive");
		Assert.assertEquals(response.getHeader("Strict-Transport-Security"), "max-age=63072000; includeSubdomains; preload");
		Assert.assertEquals(response.getHeader("X-Frame-Options"), "DENY");
		Assert.assertEquals(response.getHeader("Referrer-Policy"), "same-origin");
		Assert.assertEquals(response.getHeader("Server"), "Unspecified");
		Assert.assertEquals(response.getHeader("Vary"), "Origin");
		Assert.assertEquals(response.getHeader("X-Cache"), "Miss from cloudfront");
		Assert.assertEquals(response.getHeader("X-Amz-Cf-Pop"), "DEL54-P6");
	}

	@Test()
	public void VerifyCateforyTreeSchema() {
		logger.info("*****************Calling CategoryTree API with valid data ******************");
		Response response = microserviceEndpoints2.getCategoryTree();
//		response.then().log().body();
		File file=new File("/Users/avinashmaurya/eclipse-workspace/MSILPartsKartRestAssuredAPIAutomation/src/test/resources/Schema/SchemaCategoryTree.json");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
		logger.info("*****************Verified CategoryTree API Response ******************");
	}
}
