package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.StateMasterEndpoint;
import io.restassured.response.Response;

public class StateMasterTest {
	
	
	@Test(groups = {"Response Code"})
	public static void validateStateMasterResponseCode() {
		
		Response response=StateMasterEndpoint.stateMasterResponseCode();
		System.out.println(response.then().log().all());
		int stsCode=response.getStatusCode();
		AssertJUnit.assertEquals(stsCode, 200);
		
	}

	@Test(groups = {"Response Time"})
	public static void validateStateMasterResponseTime() {
		
		Response response=StateMasterEndpoint.stateMasterResponseTime();
		System.out.println(response.then().log().all());
		int stsCode=response.getStatusCode();
		AssertJUnit.assertEquals(stsCode, 200);
		
	}
	
	@Test()
	public static void validateStateMasterValidateErrorCodeErrorMessage() {
		
		Response response=StateMasterEndpoint.stateMasterResponseErrorCodeMessage();
		System.out.println(response.then().log().all());
		int stsCode=response.getStatusCode();
		AssertJUnit.assertEquals(stsCode, 200);
		int errCode= response.jsonPath().getInt("error_cd");
		String msg= response.jsonPath().getString("error_msg");		
		System.out.println(errCode);
		System.out.println(msg);
		AssertJUnit.assertEquals(errCode, 0);
		AssertJUnit.assertEquals(msg, null);
	}
	
	@Test()
	public static void validateStateMasterValidateResultisNotNull() {
		
		Response response=StateMasterEndpoint.stateMasterResponseErrorCodeMessage();
		System.out.println(response.then().log().all());
		int stsCode=response.getStatusCode();
		AssertJUnit.assertEquals(stsCode, 200);
		int stateSize= response.jsonPath().getList("result").size();
		System.out.println(stateSize);
		AssertJUnit.assertEquals(stateSize, 37);
	}
}
