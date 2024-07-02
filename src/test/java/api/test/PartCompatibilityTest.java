package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.base.config;
import api.endpoint.PartCompatibilityEndpoint;
import io.restassured.response.Response;

public class PartCompatibilityTest extends config {
	
	@Test()
	public void VerifyResponseCodeWithValidData() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCar();
		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test()
	public void VerifyErrorSatusWithValidData() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCar();
		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		Assert.assertEquals(response.jsonPath().getString("error"), "false");
	}

	@Test()
	public void VerifyErrorsSatusWithValidData() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCar();
		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		Assert.assertEquals(response.jsonPath().getString("errors"), null);
	}

	@Test()
	public void VerifyCompatibleflagWith_ValidpartNum_ValidregNo() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCar();
		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		Assert.assertEquals(response.jsonPath().getString("data.compatibleFlag"), "YES");
	}
	@Test()
	public void VerifyCompatibleflagWith_InvalidpartNum_ValidregNo() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithinvalidpartNum();
		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		Assert.assertEquals(response.jsonPath().getString("data.compatibleFlag"), "NO");
	}

	@Test()
	public void VerifyCompatibleflagWith_ValidpartNum_InvalidregNo() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithinvalidregNum();
		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		Assert.assertEquals(response.jsonPath().getString("data.compatibleFlag"), "NO");
	}

	
	
	@Test()
	public void VerifyResponseCodeWithoutpartNumParam() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum();
		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
	}

	@Test()
	public void VerifyErrorWithoutpartNumParam() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum();
		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		String sts=response.jsonPath().getString("error");
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMsg=response.jsonPath().getString("errors[0].errorMessage");
		
		Assert.assertEquals(sts, "true");
		Assert.assertEquals(errCode, "PART.NUM.AND.REG.NUM.OR.VIN.IS.MANDATORY");
		Assert.assertEquals(errMsg, "part num and reg num or vin num is mandatory");
	}

	
	@Test()
	public void VerifyResponseCodeWithoutregNumParam() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum();
		logger.info("Validating PartCompatibility API Response code with valid data");
		
		logger.info(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
	}


	@Test()
	public void VerifyErrorWithoutregNumParam() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum();
		logger.info("Validating PartCompatibility API Response code with valid data");
		
		logger.info(response.getStatusCode());

		String sts=response.jsonPath().getString("error");
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMsg=response.jsonPath().getString("errors[0].errorMessage");
		
		Assert.assertEquals(sts, "true");
		Assert.assertEquals(errCode, "PART.NUM.AND.REG.NUM.OR.VIN.IS.MANDATORY");
		Assert.assertEquals(errMsg, "part num and reg num or vin num is mandatory");
	}

	@Test()
	public void VerifyResponseCodeWithoutpartNumAndregNumParam() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum_regNum();
		logger.info("Validating PartCompatibility API Response code with valid data");
		
		logger.info(response.getStatusCode());
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 400);
	}

	@Test()
	public void VerifyErrorWithoutpartNumAndregNumParam() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum_regNum();
		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());
		String sts=response.jsonPath().getString("error");
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMsg=response.jsonPath().getString("errors[0].errorMessage");
		
		Assert.assertEquals(sts, "true");
		Assert.assertEquals(errCode, "PART.NUM.AND.REG.NUM.OR.VIN.IS.MANDATORY");
		Assert.assertEquals(errMsg, "part num and reg num or vin num is mandatory");	
		
	}

	@Test()
	public void VerifyResponseHeaders() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCar();
		logger.info("Validating PartCompatibility API Response code with valid data");
		response.then().log().body();
		logger.info(response.getStatusCode());

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
		Assert.assertEquals(response.getHeader("X-Amz-Cf-Pop"), "DEL54-P7");
	
	}

	
}
