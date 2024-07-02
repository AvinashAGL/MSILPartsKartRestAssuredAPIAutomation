package api.test;

import org.testng.annotations.Test;


import org.testng.Assert;

import api.endpoint.ModelTreeEndpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class ModelTreeTest {
	
	@Test()
	public void VerifyCategoryTreeStatusCodeWithValidData() {
		Response response = ModelTreeEndpoint.getModelTree();
		response.then().log().body();

		Assert.assertEquals(response.getStatusCode(), 200);
	}	

	@Test()
	public void VerifyCategoryTreeResponseTimeWithValid() {
		Response response = ModelTreeEndpoint.getModelTree();
		response.then().log().body();

		System.out.println(response.getTime());
		Assert.assertTrue(response.getTime() < 3000);	
		}
	
	@Test()
	public void VerifyCategoryTreeErrorWithValid() {
		Response response = ModelTreeEndpoint.getModelTree();
		response.then().log().body();

		boolean errStatus=response.jsonPath().getBoolean("error");
		String errMsg=response.jsonPath().getString("errors");
		
		Assert.assertEquals(false, errStatus);
		Assert.assertEquals(errMsg, null);
	
	}	



}
