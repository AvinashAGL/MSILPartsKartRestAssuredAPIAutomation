package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.base.config;
import api.endpoint.CompatibleCarEndpoint;
import io.restassured.response.Response;

public class CompatibleCar extends config {

	@Test()
	public void VerifyCompatibleCarStatusCodewithValidData() {
		logger.info("*****************Calling CompatibleCar API with valid data ******************");
		Response response = CompatibleCarEndpoint.getCompatibleCar();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*****************Verified CategoryTree API Response ******************");
	}

	@Test()
	public void VerifyCompatibleCarwithValidData() {
		logger.info("*****************Calling CompatibleCar API with valid data ******************");
		Response response = CompatibleCarEndpoint.getCompatibleCar();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*****************Verified CategoryTree API Response ******************");
	}

	@Test()
	public void VerifyCompatibleCarErrorwithValidData() {
		logger.info("*****************Calling CompatibleCar API with valid data ******************");
		Response response = CompatibleCarEndpoint.getCompatibleCar();
		String error = response.jsonPath().getString("error");
		String errors = response.jsonPath().getString("errors");
		Assert.assertEquals(error, "false");
		Assert.assertEquals(errors, null);
		logger.info("*****************Verified CategoryTree API Response ******************");
	}

	@Test()
	public void VerifyCompatibleCarDatawithValidData() {
		logger.info("*****************Calling CompatibleCar API with valid data ******************");
		Response response = CompatibleCarEndpoint.getCompatibleCar();
		boolean sts= response.jsonPath().getList("data.MODELS").isEmpty();
		Assert.assertEquals(sts, false);
		logger.info("*****************Verified CategoryTree API Response is not null******************");
	}
	
	
	@Test()
	public void VerifyCompatibleCarDataWithInvalidData() {
		logger.info("*****************Calling CompatibleCar API with valid data ******************");
		Response response = CompatibleCarEndpoint.getCompatibleCarwithInvalidPartno();
		String data= response.jsonPath().getString("data");
		Assert.assertEquals(data, null);
		logger.info("*****************Verified CategoryTree API Response ******************");
	}
	@Test()
	public void VerifyCompatibleCarErrorwithInvalidData() {
		logger.info("*****************Calling CompatibleCar API with valid data ******************");
		Response response = CompatibleCarEndpoint.getCompatibleCarwithInvalidPartno();
		String error = response.jsonPath().getString("error");
		boolean errors = response.jsonPath().getString("errors").isEmpty();
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMsg=response.jsonPath().getString("errors[0].errorMessage");
		
		Assert.assertEquals(error, "true");
		Assert.assertEquals(errors, false);
		
		Assert.assertEquals(errCode, "COMPATIBLE.CARS.NOT.FOUND");
		Assert.assertEquals(errMsg, "Compatible cars not found for given part number");

		logger.info("*****************Verified CategoryTree API Response ******************");
	}

	@Test()
	public void VerifyCompatibleCarStatusCodewithblankPartNo() {
		logger.info("*****************Calling CompatibleCar API with valid data ******************");
		Response response = CompatibleCarEndpoint.getCompatibleCarWithBlankPartNo();
		int stsCode=response.getStatusCode();
		Assert.assertEquals(stsCode, 400);
		logger.info("*****************Verified CategoryTree API Response is not null******************");
	}
	
	@Test()
	public void VerifyErrorwithBlankPartNo() {
		logger.info("*****************Calling CompatibleCar API with valid data ******************");
		Response response = CompatibleCarEndpoint.getCompatibleCarWithBlankPartNo();
		String error = response.jsonPath().getString("error");
		boolean errors = response.jsonPath().getString("errors").isEmpty();
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMsg=response.jsonPath().getString("errors[0].errorMessage");
		
		Assert.assertEquals(error, "true");
		Assert.assertEquals(errors, false);
		
		Assert.assertEquals(errCode, "PART.NUMBER.IS.MANDATORY");
		Assert.assertEquals(errMsg, "partNum is mandatory");

		logger.info("*****************Verified CategoryTree API Response ******************");
	}

	@Test()
	public void VerifyDataWithBlankPartNo() {
		logger.info("*****************Calling CompatibleCar API with valid data ******************");
		Response response = CompatibleCarEndpoint.getCompatibleCarWithBlankPartNo();
		String data= response.jsonPath().getString("data");
		Assert.assertEquals(data, null);

		logger.info("*****************Verified CategoryTree API Response ******************");
	}
	
	@Test()
	public void VerifyCompatibleCarHeaders() {
		logger.info("*****************Calling CompatibleCar API with valid data ******************");
		Response response = CompatibleCarEndpoint.getCompatibleCar();
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
		
		logger.info("*****************Verified CategoryTree API Response ******************");
	}

}
