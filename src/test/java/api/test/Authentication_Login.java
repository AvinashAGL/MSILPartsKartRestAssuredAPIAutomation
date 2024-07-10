/**
 * 
 */
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

import api.endpoint.LoginWithMobNoEndpint;
import io.restassured.response.Response;

/**
 * @author avinashmaurya
 *
 */
public class Authentication_Login {
	
	@Test(groups = {"Response Code"})
	public void validateLoginWith_MobNO_ResponseCodeWithValidMobNo() {
		Response response=LoginWithMobNoEndpint.loginWith_MSPIN_RespondeCode2();
		int stsCode= response.statusCode();
		AssertJUnit.assertTrue(stsCode==200);
	}
	@Test(groups = {"Response Time"})
	public void validateLogin_ResponseTime() {
		Response response=LoginWithMobNoEndpint.loginWith_MSPIN_RespondeCode2();
		int stsCode= response.statusCode();
		AssertJUnit.assertTrue(stsCode==200);
		long time = response.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Time in milliseconds : " + time);
		AssertJUnit.assertTrue(time < 3000);
	}
	
	@Test()
	public void validateLoginWithNo_errorCode_errorMsg_WithValidMobNo() {
		Response response=LoginWithMobNoEndpint.loginWithMobNo_withValidData_RespondeCode();
		int error_cd=response.jsonPath().getInt("error_cd");
		String error_msg=response.jsonPath().getString("error_msg");
		System.out.println(error_cd);
		System.out.println(error_msg);
		AssertJUnit.assertEquals(0, error_cd);
		AssertJUnit.assertEquals(error_msg, null);
		
	}
	@Test()
	public void validateLoginWithNo_errorCode_With_InvalidMobNo() {
		Response response=LoginWithMobNoEndpint.loginWithInvalidMobNoRespondeCode();
		int error_cd=response.jsonPath().getInt("error_cd");
		String error_msg=response.jsonPath().getString("error_msg");
		System.out.println(error_cd);
		System.out.println(error_msg);
		AssertJUnit.assertEquals(1, error_cd);
		AssertJUnit.assertEquals(error_msg, "Invalid Mobile Number!(E71)");
		
	}
	
	@Test()
	public void validateLoginWith_MSPIN_ResponseCodeWithValidMobNo() {
		Response response=LoginWithMobNoEndpint.loginWith_MSPIN_RespondeCode2();
		int stsCode= response.statusCode();
		AssertJUnit.assertTrue(stsCode==200);
	}

	@Test()
	public void validateLoginWithNo_errorCode_errorMsg_WithValidMSPIN() {
		Response response=LoginWithMobNoEndpint.loginWith_MSPIN_RespondeCode2();
		int error_cd=response.jsonPath().getInt("error_cd");
		String error_msg=response.jsonPath().getString("error_msg");
		System.out.println(error_cd);
		System.out.println(error_msg);
		AssertJUnit.assertEquals(0, error_cd);
		AssertJUnit.assertEquals(error_msg, null);
		
	}
	
	@Test()
	public void validateLoginWithNo_errorCode_With_InvalidMSPIN() {
		Response response=LoginWithMobNoEndpint.loginWith_MSPIN_RespondeCode();
		int error_cd=response.jsonPath().getInt("error_cd");
		String error_msg=response.jsonPath().getString("error_msg");
		System.out.println(error_cd);
		System.out.println(error_msg);
		AssertJUnit.assertEquals(1, error_cd);
		AssertJUnit.assertEquals(error_msg, "Employee mspin not valid or Employee not authorize!(E71)");
		
	}

}
