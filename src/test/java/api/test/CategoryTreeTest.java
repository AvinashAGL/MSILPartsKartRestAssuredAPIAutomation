package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import api.endpoint.microserviceEndpoints;
import api.endpoint.microserviceEndpoints2;
import io.restassured.response.Response;

public class CategoryTreeTest {
	
	public Logger logger;
	
	@BeforeClass
	public void setup(){
		
		logger=LogManager.getLogger(this.getClass());
		logger.debug("Debugging........");
		
	}
	
	@Test()
	public void Verify() {
		logger.info("*****************Calling CategoryTree API******************");
		Response response=microserviceEndpoints2.getCategoryTree();
		response.then().log().all();
		logger.info("*****************Called CategoryTree API******************");

		
		
	}
	@Test()
	public void VerifyStatusCode() {
		logger.info("*****************Calling CategoryTree API with valid data ******************");
		Response response=microserviceEndpoints2.getCategoryTree();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*****************Verified CategoryTree API Response ******************");
	}
	@Test()
	public void VerifyCategoryTreeWithInvalidQueryParameter() {
		logger.info("************Calling CategoryTree API with invalid Querry Parameter ***********");
		Response response=microserviceEndpoints2.getCategoryTreeInvalidQuery();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 404);
		
	}
	
	@Test()
	public void VerifyErrorCodeAndErrorMessageWithInvalidQueryParameter() {
		
		logger.info("*****************Calling CategoryTree API with invalid Querry Parameter to verfy the Error Code & Error Message ******************");
		Response response=microserviceEndpoints2.getCategoryTreeInvalidQuery();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 404);
		
	}

	@Test()
	public void VerifyCategoryTreeWithoutQueryParameter() {
		logger.info("*****************Calling CategoryTree API withour Querry Parameter ******************");
		Response response=microserviceEndpoints2.getCategoryTreeWithoutQuery();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 400);
		
	}


}
