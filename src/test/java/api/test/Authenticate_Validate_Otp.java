package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.ValidateOTP_endpoint;
import io.restassured.response.Response;

public class Authenticate_Validate_Otp {
	
	
	@Test()
	public void validateOTP_ResponseCode_withvalidMobNo_ValidOTP() {
		Response response = ValidateOTP_endpoint.validateOTP_validMob_validOTP();
		int stsCode = response.getStatusCode();
		System.out.println(stsCode);
		System.out.println(response.then().log().all());
		Assert.assertEquals(stsCode, 200);

	}

	@Test()
	public void validateOTP_PartyDetails_withvalidMobNo_ValidOTP() {
		Response response = ValidateOTP_endpoint.validateOTP_validMob_validOTP();
//		int stsCode = response.getStatusCode();
		System.out.println(response.then().log().all());

		String mob=response.jsonPath().getString("result.mobile");
		int pg=response.jsonPath().getInt("result.PG");
		String sub_account_id=response.jsonPath().getString("result.sub_account_id");
		String device_type=response.jsonPath().getString("result.device_type");
		
		String active=response.jsonPath().getString("result.dms_user_data[0].ACTIVE_YN");
		String approval_sts=response.jsonPath().getString("result.dms_user_data[0].APPROVAL_STATUS");
		String Balance=response.jsonPath().getString("result.dms_user_data[0].BALANCE");
		
		String City_Code=response.jsonPath().getString("result.dms_user_data[0].CITY_CD");
		String City_name=response.jsonPath().getString("result.dms_user_data[0].CITY_NAME");
		String CONTACT_PERSON=response.jsonPath().getString("result.dms_user_data[0].CONTACT_PERSON");
		String COUNTRY_CD=response.jsonPath().getString("result.dms_user_data[0].COUNTRY_CD");
		String COUNTRY_NAME=response.jsonPath().getString("result.dms_user_data[0].COUNTRY_NAME");
		String CREATED_DATE=response.jsonPath().getString("result.dms_user_data[0].CREATED_DATE");
		
		
		Assert.assertEquals(mob, "9911477739");
		Assert.assertEquals(pg, 0);
		Assert.assertEquals(sub_account_id, "KA0102");
		Assert.assertEquals(device_type, "Android");
		Assert.assertEquals(active, "Y");
		Assert.assertEquals(approval_sts, "A");
		Assert.assertEquals(Balance, "");
		Assert.assertEquals(City_Code, "047");
		Assert.assertEquals(City_name, "BANGALORE");
		Assert.assertEquals(CONTACT_PERSON, "SARAVANA");
		Assert.assertEquals(COUNTRY_CD, "IND");
		Assert.assertEquals(COUNTRY_NAME, "INDIA");
		Assert.assertEquals(CREATED_DATE, "2014-08-07T00:00:00");

		
	}

	@Test()
	public void validateOTP_errorCode_errorMsg_result_withvalidMobNo_InvalidOTP() {
		Response response = ValidateOTP_endpoint.validateOTP_validMob_invalidOTP();
		int stsCode = response.getStatusCode();
		
		int errCode=response.jsonPath().getInt("error_cd");
		String errMSG=response.jsonPath().getString("error_msg");
		String result=response.jsonPath().getString("result");
		
		System.out.println(response.then().log().all());
		Assert.assertEquals(errCode, 1);
		Assert.assertEquals(errMSG, "Invalid OTP (E81)");
		Assert.assertEquals(result, null);

	}
	
	@Test()
	public void validateOTP_Mob_ErrorCode_ErrorMsg() {
		Response response = ValidateOTP_endpoint.validateOTP_validMob_validOTP();
		System.out.println(response.then().log().all());
		int errCode = response.jsonPath().getInt("error_cd");
		String errMessage = response.jsonPath().getString("error_msg");
		System.out.println(errCode);
		System.out.println(errMessage);
		Assert.assertEquals(errCode, 0);
		Assert.assertEquals(errMessage, null);

	}


	@Test()
	public void validateOTP_MSPIN_ResponseCode() {
		Response response = ValidateOTP_endpoint.validateOTP_validMSPIN_validOTP();
		int stsCode = response.getStatusCode();
		System.out.println(stsCode);
		System.out.println(response.then().log().all());
		Assert.assertEquals(stsCode, 200);

	}

	@Test()
	public void validateOTP_MSPIN_ErrorCode_ErrorMsg() {
		Response response = ValidateOTP_endpoint.validateOTP_validMSPIN_validOTP();
		int stsCode = response.getStatusCode();
		System.out.println(stsCode);
		System.out.println(response.then().log().all());
		int errCode = response.jsonPath().getInt("error_cd");
		String errMessage = response.jsonPath().getString("error_msg");
		System.out.println(errCode);
		System.out.println(errMessage);
		Assert.assertEquals(errCode, 0);
		Assert.assertEquals(errMessage, null);

	}

}
