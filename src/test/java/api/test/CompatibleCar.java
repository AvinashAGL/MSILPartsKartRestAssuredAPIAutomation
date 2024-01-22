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
	public void VerifyErrorwithValidData() {
		logger.info("*****************Calling CompatibleCar API with valid data ******************");
		Response response = CompatibleCarEndpoint.getCompatibleCar();
		String error = response.jsonPath().getString("error");
		String errors = response.jsonPath().getString("errors");
		Assert.assertEquals(error, "false");
		Assert.assertEquals(errors, null);
		logger.info("*****************Verified CategoryTree API Response ******************");
	}

}
