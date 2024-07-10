package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.base.config;
import api.endpoint.PartCompatibilityEndpoint;
import io.restassured.response.Response;

public class PartCompatibilityTest extends config {
	
	@Test(groups = {"Response Code"})
	public void VerifyResponseCodeWithValidData() {
		Response response = PartCompatibilityEndpoint.getCompatibleCar();
		response.then().log().body();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	@Test(groups = {"Response Time"})
	public void VerifyPartCompatibilityResponseTime() {
//		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCar();
//		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		long time=  response.timeIn(TimeUnit.MILLISECONDS);
		AssertJUnit.assertTrue(time<3000);
		logger.info(time);
	}
	@Test()
	public void VerifyErrorSatusWithValidData() {
//		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCar();
//		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		AssertJUnit.assertEquals(response.jsonPath().getString("error"), "false");
	}

	@Test()
	public void VerifyErrorsSatusWithValidData() {
//		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCar();
//		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
//		logger.info(response.getStatusCode());
		AssertJUnit.assertEquals(response.jsonPath().getString("errors"), null);
	}

	@Test()
	public void VerifyCompatibleflagWith_ValidpartNum_ValidregNo() {
//		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCar();
//		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		AssertJUnit.assertEquals(response.jsonPath().getString("data.compatibleFlag"), "YES");
	}
	@Test()
	public void VerifyCompatibleflagWith_InvalidpartNum_ValidregNo() {
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithinvalidpartNum();
		response.then().log().body();
		AssertJUnit.assertEquals(response.jsonPath().getString("data.compatibleFlag"), "NO");
	}

	@Test()
	public void VerifyCompatibleflagWith_ValidpartNum_InvalidregNo() {
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithinvalidregNum();
		response.then().log().body();
		AssertJUnit.assertEquals(response.jsonPath().getString("data.compatibleFlag"), "NO");
	}

	
	
	@Test()
	public void VerifyResponseCodeWithoutpartNumParam() {
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum();
		response.then().log().body();
		AssertJUnit.assertEquals(response.getStatusCode(), 400);
	}

	@Test()
	public void VerifyErrorWithoutpartNumParam() {
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum();
		response.then().log().body();
		String sts=response.jsonPath().getString("error");
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMsg=response.jsonPath().getString("errors[0].errorMessage");
		
		AssertJUnit.assertEquals(sts, "true");
		AssertJUnit.assertEquals(errCode, "PART.NUM.AND.REG.NUM.OR.VIN.IS.MANDATORY");
		AssertJUnit.assertEquals(errMsg, "part num and reg num or vin num is mandatory");
	}

	
	@Test()
	public void VerifyResponseCodeWithoutregNumParam() {
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 400);
	}


	@Test()
	public void VerifyErrorWithoutregNumParam() {
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum();
		

		String sts=response.jsonPath().getString("error");
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMsg=response.jsonPath().getString("errors[0].errorMessage");
		
		AssertJUnit.assertEquals(sts, "true");
		AssertJUnit.assertEquals(errCode, "PART.NUM.AND.REG.NUM.OR.VIN.IS.MANDATORY");
		AssertJUnit.assertEquals(errMsg, "part num and reg num or vin num is mandatory");
	}

	@Test()
	public void VerifyResponseCodeWithoutpartNumAndregNumParam() {
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum_regNum();
		
		response.then().log().body();
		AssertJUnit.assertEquals(response.getStatusCode(), 400);
	}

	@Test()
	public void VerifyErrorWithoutpartNumAndregNumParam() {
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum_regNum();
		response.then().log().body();
		String sts=response.jsonPath().getString("error");
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMsg=response.jsonPath().getString("errors[0].errorMessage");
		
		AssertJUnit.assertEquals(sts, "true");
		AssertJUnit.assertEquals(errCode, "PART.NUM.AND.REG.NUM.OR.VIN.IS.MANDATORY");
		AssertJUnit.assertEquals(errMsg, "part num and reg num or vin num is mandatory");	
		
	}

	@Test()
	public void VerifyResponseHeaders() {
		Response response = PartCompatibilityEndpoint.getCompatibleCar();
		response.then().log().body();

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

	
}
