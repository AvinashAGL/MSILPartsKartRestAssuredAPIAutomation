package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.enquiryHistoeyEndpoint;
import io.restassured.response.Response;

public class EnquiryHistoryTest {

	@Test(groups = {"Response Code"})
	public void validateEnquiryHistoryResponseCode() {

		Response response=enquiryHistoeyEndpoint.validateResponseCode();
		System.out.println(response.then().log().all());
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(groups = {"Response Time"})
	public void validateEnquiryHistoryResponseTime() {

		Response response=enquiryHistoeyEndpoint.validateResponseCode();
		System.out.println(response.then().log().all());
		Assert.assertTrue(response.time()<3000);
	}
/*******************  Negetive  *****************************/	
	@Test()
	public void validateEnquiryHistoryErrorwithInvalidPartyCode() {

		Response response=enquiryHistoeyEndpoint.validateErrorwithInvalidPartyCode();
		System.out.println(response.then().log().all());
		
		Assert.assertEquals(response.jsonPath().getBoolean("error"), true);
		Assert.assertEquals(response.jsonPath().getString("errors[0].errorCode"), "FAILED.TO.GET.DATA");
		Assert.assertEquals(response.jsonPath().getString("errors[0].errorMessage"), "Data not found for the given Input");

		
	}
	
	@Test()
	public void validateEnquiryHistoryErrorwithInvalidParentCode() {

		Response response=enquiryHistoeyEndpoint.validateErrorwithInvalidParentCode();
		System.out.println(response.then().log().all());
		
		Assert.assertEquals(response.jsonPath().getBoolean("error"), true);
		Assert.assertEquals(response.jsonPath().getString("errors[0].errorCode"), "FAILED.TO.GET.DATA");
		Assert.assertEquals(response.jsonPath().getString("errors[0].errorMessage"), "Data not found for the given Input");

		
	}
	
	@Test()
	public void validateEnquiryHistoryErrorwithInvalidDealerMapCode() {

		Response response=enquiryHistoeyEndpoint.validateErrorwithInvalidDealerCode();
		System.out.println(response.then().log().all());
		
		Assert.assertEquals(response.jsonPath().getBoolean("error"), true);
		Assert.assertEquals(response.jsonPath().getString("errors[0].errorCode"), "FAILED.TO.GET.DATA");
		Assert.assertEquals(response.jsonPath().getString("errors[0].errorMessage"), "Data not found for the given Input");

		
	}

}
