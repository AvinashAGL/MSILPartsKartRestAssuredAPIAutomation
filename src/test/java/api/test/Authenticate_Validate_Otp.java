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

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.ValidateOTP_endpoint;
import io.restassured.response.Response;

public class Authenticate_Validate_Otp {
	
	
	@Test(groups = {"Response Code"})
	public void validateOTP_ResponseCode_withvalidMobNo_ValidOTP() {
		Response response = ValidateOTP_endpoint.validateOTP_validMob_validOTP_StatusCode();
		int stsCode = response.getStatusCode();
		System.out.println(stsCode);
		System.out.println(response.then().log().all());
		AssertJUnit.assertEquals(stsCode, 200);

	}
	@Test(groups = {"Response Time"})
	public void validateOTP_ResponseTime() {
		Response response = ValidateOTP_endpoint.validateOTP_validMob_validOTP_StatusCode();
		int stsCode = response.getStatusCode();
		System.out.println(stsCode);
		System.out.println(response.then().log().all());
		AssertJUnit.assertEquals(stsCode, 200);
		long time=  response.timeIn(TimeUnit.MILLISECONDS);
		AssertJUnit.assertTrue(time<3000);
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
		
		
		AssertJUnit.assertEquals(mob, "9911477739");
		AssertJUnit.assertEquals(pg, 0);
		AssertJUnit.assertEquals(sub_account_id, "KA0102");
		AssertJUnit.assertEquals(device_type, "Android");
		AssertJUnit.assertEquals(active, "Y");
		AssertJUnit.assertEquals(approval_sts, "A");
		AssertJUnit.assertEquals(Balance, "");
		AssertJUnit.assertEquals(City_Code, "047");
		AssertJUnit.assertEquals(City_name, "BANGALORE");
		AssertJUnit.assertEquals(CONTACT_PERSON, "SARAVANA");
		AssertJUnit.assertEquals(COUNTRY_CD, "IND");
		AssertJUnit.assertEquals(COUNTRY_NAME, "INDIA");
		AssertJUnit.assertEquals(CREATED_DATE, "2014-08-07T00:00:00");

		
	}

	@Test()
	public void validateOTP_errorCode_errorMsg_result_withvalidMobNo_InvalidOTP() {
		Response response = ValidateOTP_endpoint.validateOTP_validMob_invalidOTP();
		int stsCode = response.getStatusCode();
		
		int errCode=response.jsonPath().getInt("error_cd");
		String errMSG=response.jsonPath().getString("error_msg");
		String result=response.jsonPath().getString("result");
		
		System.out.println(response.then().log().all());
		AssertJUnit.assertEquals(errCode, 1);
		AssertJUnit.assertEquals(errMSG, "Invalid OTP (E81)");
		AssertJUnit.assertEquals(result, null);

	}
	
	@Test()
	public void validateOTP_Mob_ErrorCode_ErrorMsg() {
		Response response = ValidateOTP_endpoint.validateOTP_validMob_validOTP();
		System.out.println(response.then().log().all());
		int errCode = response.jsonPath().getInt("error_cd");
		String errMessage = response.jsonPath().getString("error_msg");
		System.out.println(errCode);
		System.out.println(errMessage);
		AssertJUnit.assertEquals(errCode, 0);
		AssertJUnit.assertEquals(errMessage, null);

	}
/**************************** MSPIN **********************************/

	@Test()
	public void validateOTP_MSPIN_ResponseCode() {
		Response response = ValidateOTP_endpoint.validateOTP_MSPIN_ResponseCode();
		int stsCode = response.getStatusCode();
		System.out.println(stsCode);
		System.out.println(response.then().log().all());
		AssertJUnit.assertEquals(stsCode, 200);

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
		AssertJUnit.assertEquals(errCode, 0);
		AssertJUnit.assertEquals(errMessage, null);

	}
	
	@Test()
	public void validateOTP_MSPIN_ErrorCode_ErrorMsg_with_ValidMSPIN_InvalidOTP() {
		Response response = ValidateOTP_endpoint.validateOTP_validMSPIN_InvalidOTP();
		int stsCode = response.getStatusCode();
		System.out.println(stsCode);
		System.out.println(response.then().log().all());
		int errCode = response.jsonPath().getInt("error_cd");
		String errMessage = response.jsonPath().getString("error_msg");
		System.out.println(errCode);
		System.out.println(errMessage);
		AssertJUnit.assertEquals(errCode, 1);
		AssertJUnit.assertEquals(errMessage, "Invalid OTP (E89)");

	}
	
	@Test()
	public void validateOTP_MSPIN_ErrorCode_ErrorMsg_with_InvalidMSPIN_validOTP() {
		Response response = ValidateOTP_endpoint.validateOTP_InvalidMSPIN_validOTP();
		int stsCode = response.getStatusCode();
		System.out.println(stsCode);
		System.out.println(response.then().log().all());
		int errCode = response.jsonPath().getInt("error_cd");
		String errMessage = response.jsonPath().getString("error_msg");
		System.out.println(errCode);
		System.out.println(errMessage);
		AssertJUnit.assertEquals(errCode, 1);
		AssertJUnit.assertEquals(errMessage, "Something went wrong, please try again later (E90)");

	}

}
