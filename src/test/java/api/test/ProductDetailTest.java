package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.ProductDetailEndpoint;
import io.restassured.response.Response;

public class ProductDetailTest {
	
	@Test()
	public void VerifyCategoryTreeStatusCodeWithValidData() {
		Response response = ProductDetailEndpoint.productDetailwithValidPartNo();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test()
	public void VerifyCategoryTreeErrorWithValidData() {
		Response response = ProductDetailEndpoint.productDetailwithValidPartNo();
		response.then().log().body();
		boolean sts= response.jsonPath().getBoolean("error");
		String msg=response.jsonPath().getString("errors");
		
		Assert.assertEquals(sts, false);
		Assert.assertEquals(msg, null);
	}
	
	@Test()
	public void VerifyCategoryTreeStatusCodeWithInvalidData() {
		Response response = ProductDetailEndpoint.productDetailwithInvalidPartNo();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}	

}
