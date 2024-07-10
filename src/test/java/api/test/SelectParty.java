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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.SelectPartyEndpoint;
import io.restassured.response.Response;

public class SelectParty {

	private static final Logger logger=LogManager.getLogger(SelectParty.class);

	@Test(groups = {"Response Code"})
	public void validateSelectParty_Statuscode() {
		
		logger.info("Select Party Execution started......");

		Response response = SelectPartyEndpoint.validateSelectPartyStatusCode();
		System.out.println(response.then().log().all());
		int stsCode = response.getStatusCode();
		AssertJUnit.assertEquals(stsCode, 200);
		
		logger.info("Select Party Execution ended......");

	}

	
	@Test(groups = {"Response Time"})
	public void validateSelectParty_ResponseTime() {

		Response response = SelectPartyEndpoint.validateSelectPartyStatusCode();
		System.out.println(response.then().log().all());
		long time = response.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Time in milliseconds : " + time);
		AssertJUnit.assertTrue(time < 3000);
	}
	
	@Test()
	public void validateSelectParty_ErrorCodeErrorMessageWithvalidData() {
		
		logger.info("Select Party Execution started......");

		Response response = SelectPartyEndpoint.validateSelectPartyStatusCode2();
		System.out.println(response.then().log().all());
		
		int stsCode = response.getStatusCode();
		
		String msg= response.jsonPath().getString("error_msg");
		int errCode= response.jsonPath().getInt("error_cd");
		
		AssertJUnit.assertEquals(msg, null);
		AssertJUnit.assertEquals(errCode, 0);
		
		logger.info("Select Party Execution ended......");

	}
	
	@Test()
	public void validateSelectParty_ErrorCodeErrorMessageWithInvalidData() {
		
		logger.info("Select Party Execution started......");

		Response response = SelectPartyEndpoint.validateSelectPartyStatusCode_invalidData();
		System.out.println(response.then().log().all());
		
		int stsCode = response.getStatusCode();
		
		String msg= response.jsonPath().getString("error_msg");
		int errCode= response.jsonPath().getInt("error_cd");
		
		AssertJUnit.assertEquals(msg, "selectParty API is not working (E184)");
		AssertJUnit.assertEquals(errCode, 1);
		
		logger.info("Select Party Execution ended......");

	}


}
