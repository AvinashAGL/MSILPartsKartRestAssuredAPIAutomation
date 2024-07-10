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

import api.endpoint.ProductDetailEndpoint;
import io.restassured.response.Response;

public class ProductDetailTest {
	
	@Test(groups = {"Response Code"})
	public void VerifyProductDetailStatusCodeWithValidData() {
		Response response = ProductDetailEndpoint.productDetailwithValidPartNo();
		response.then().log().body();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(groups = {"Response Time"})
	public void VerifyProductDetailResponseTime() {
		Response response = ProductDetailEndpoint.productDetailwithValidPartNo();
		response.then().log().body();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		long time=  response.timeIn(TimeUnit.MILLISECONDS);
		AssertJUnit.assertTrue(time<3000);
		System.out.println(time);
		
	}
	@Test()
	public void VerifyProductDetailErrorWithValidData() {
		Response response = ProductDetailEndpoint.productDetailwithValidPartNo();
		response.then().log().body();
		boolean sts= response.jsonPath().getBoolean("error");
		String msg=response.jsonPath().getString("errors");
		
		AssertJUnit.assertEquals(sts, false);
		AssertJUnit.assertEquals(msg, null);
	}
	
	@Test()
	public void VerifyProductDetailStatusCodeWithInvalidData() {
		Response response = ProductDetailEndpoint.productDetailwithInvalidPartNo();
		response.then().log().body();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}	

}
