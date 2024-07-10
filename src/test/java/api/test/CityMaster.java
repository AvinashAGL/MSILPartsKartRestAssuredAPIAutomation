package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import api.endpoint.cityMasterEndpoint;
import io.restassured.response.Response;

public class CityMaster {

	@Test(groups = {"Response Code"})
	public void validateCityMasterResponseCode() {
		Response response=cityMasterEndpoint.validateCityMaster_ResponseCode2();
		response.then().log().all();
		int stsCode=response.getStatusCode();
		AssertJUnit.assertEquals(stsCode, 200);
	}
	
	@Test(groups = {"Response Time"})
	public void validateCityMaster_ResponseTime() {
		Response response=cityMasterEndpoint.validateCityMaster_ResponseCode2();
		response.then().log().all();
		int stsCode=response.getStatusCode();
		AssertJUnit.assertEquals(stsCode, 200);
		long time = response.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Time in milliseconds : " + time);
		AssertJUnit.assertTrue(time < 3000);
	}
	
	@Test()
	public void validateCityMasterErrorCodeErrorMessage() {
		Response response=cityMasterEndpoint.validateCityMaster_ResponseCode();
		response.then().log().all();
		int stsCode=response.getStatusCode();
		AssertJUnit.assertEquals(stsCode, 200);
		
		int errCode=response.jsonPath().getInt("error_cd");
		String errMSG=response.jsonPath().getString("error_msg");
		
		System.out.println(response.then().log().all());
		AssertJUnit.assertEquals(errCode, 0);
		AssertJUnit.assertEquals(errMSG, null);
	}

}
