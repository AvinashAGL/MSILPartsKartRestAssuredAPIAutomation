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
		
		logger.info(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
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
	public void VerifyResponseCodeWithoutpartNumAndregNumParam() {
		logger.info("*****************Calling PartCompatibility API with valid data ******************");
		Response response = PartCompatibilityEndpoint.getCompatibleCarwithoutpartNum_regNum();
		logger.info("Validating PartCompatibility API Response code with valid data");
		
		logger.info(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
	}

	
}
