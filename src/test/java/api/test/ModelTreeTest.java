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

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import api.endpoint.ModelTreeEndpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class ModelTreeTest {
	
	@Test(groups = {"Response Code"})
	public void VerifyCategoryTreeStatusCodeWithValidData() {
		Response response = ModelTreeEndpoint.getModelTree();
		response.then().log().body();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}	
	@Test(groups = {"Response Time"})
	public void VerifyCategoryTreeResponseTime() {
		Response response = ModelTreeEndpoint.getModelTree();
		response.then().log().body();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		long time=  response.timeIn(TimeUnit.MILLISECONDS);
		AssertJUnit.assertTrue(time<3000);
	}	

	@Test()
	public void VerifyCategoryTreeResponseTimeWithValid() {
		Response response = ModelTreeEndpoint.getModelTree();
		response.then().log().body();

		System.out.println(response.getTime());
		AssertJUnit.assertTrue(response.getTime() < 3000);	
		}
	
	@Test()
	public void VerifyCategoryTreeErrorWithValid() {
		Response response = ModelTreeEndpoint.getModelTree();
		response.then().log().body();

		boolean errStatus=response.jsonPath().getBoolean("error");
		String errMsg=response.jsonPath().getString("errors");
		
		AssertJUnit.assertEquals(errStatus, false);
		AssertJUnit.assertEquals(errMsg, null);
	
	}	



}
