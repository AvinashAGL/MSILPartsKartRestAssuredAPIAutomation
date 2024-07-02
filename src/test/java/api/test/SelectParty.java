package api.test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.SelectPartyEndpoint;
import io.restassured.response.Response;

public class SelectParty {
	
	
	@Test()
	public void validateSelectParty_Statuscode() {
		
		Response response=SelectPartyEndpoint.validateSelectPartyStatusCode();
		System.out.println(response.then().log().all());
		int stsCode= response.getStatusCode();
		Assert.assertEquals(stsCode, 200);
	}
	
	@Test()
	public void validateSelectParty_ResponseTime() {
		
		Response response=SelectPartyEndpoint.validateSelectPartyStatusCode();
		System.out.println(response.then().log().all());
		long time=  response.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Time in milliseconds : "+time);
		Assert.assertTrue(time<3000);
	}

}
