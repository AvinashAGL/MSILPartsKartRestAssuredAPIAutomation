/**
 * 
 */
package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.LoginWithMobNoEndpint;
import io.restassured.response.Response;

/**
 * @author avinashmaurya
 *
 */
public class Authentication_Login {
	
	@Test()
	public void validateLoginWith_MobNO_ResponseCodeWithValidMobNo() {
		Response response=LoginWithMobNoEndpint.loginWithMobNoRespondeCode();
		int stsCode= response.statusCode();
		Assert.assertTrue(stsCode==200);
	}
	
	@Test()
	public void validateLoginWithNo_errorCode_errorMsg_WithValidMobNo() {
		Response response=LoginWithMobNoEndpint.loginWithMobNoRespondeCode();
		int error_cd=response.jsonPath().getInt("error_cd");
		String error_msg=response.jsonPath().getString("error_msg");
		System.out.println(error_cd);
		System.out.println(error_msg);
		Assert.assertEquals(0, error_cd);
		Assert.assertEquals(error_msg, null);
		
	}
	@Test()
	public void validateLoginWithNo_errorCode_With_InvalidMobNo() {
		Response response=LoginWithMobNoEndpint.loginWithInvalidMobNoRespondeCode();
		int error_cd=response.jsonPath().getInt("error_cd");
		String error_msg=response.jsonPath().getString("error_msg");
		System.out.println(error_cd);
		System.out.println(error_msg);
		Assert.assertEquals(1, error_cd);
		Assert.assertEquals(error_msg, "Invalid Mobile Number!(E71)");
		
	}
	
	@Test()
	public void validateLoginWith_MSPIN_ResponseCodeWithValidMobNo() {
		Response response=LoginWithMobNoEndpint.loginWith_MSPIN_RespondeCode();
		int stsCode= response.statusCode();
		Assert.assertTrue(stsCode==200);
	}
	
	@Test()
	public void validateLoginWithNo_errorCode_errorMsg_WithValidMSPIN() {
		Response response=LoginWithMobNoEndpint.loginWith_MSPIN_RespondeCode();
		int error_cd=response.jsonPath().getInt("error_cd");
		String error_msg=response.jsonPath().getString("error_msg");
		System.out.println(error_cd);
		System.out.println(error_msg);
		Assert.assertEquals(0, error_cd);
		Assert.assertEquals(error_msg, null);
		
	}
	
	@Test()
	public void validateLoginWithNo_errorCode_With_InvalidMSPIN() {
		Response response=LoginWithMobNoEndpint.loginWithInvalidMSPIN();
		int error_cd=response.jsonPath().getInt("error_cd");
		String error_msg=response.jsonPath().getString("error_msg");
		System.out.println(error_cd);
		System.out.println(error_msg);
		Assert.assertEquals(1, error_cd);
		Assert.assertEquals(error_msg, "Employee mspin not valid or Employee not authorize!(E71)");
		
	}

}
