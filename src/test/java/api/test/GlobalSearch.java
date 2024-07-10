package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.lang.reflect.Array;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.GlobalSearchEndpoint;
import io.restassured.response.Response;

public class GlobalSearch {
	
	@Test(groups = {"Response Code"})
	public void validateGlobalSearch_ResponseCode_withvalidQuerry() {
		Response response=GlobalSearchEndpoint.validateGlobalSeachResponse();
		System.out.println(response.then().log().all());
		AssertJUnit.assertEquals(response.statusCode(), 200);
	}
	
	@Test(groups = {"Response Time"})
	public void validateGlobalSearch_ResponseTime_withvalidQuerry() {
		Response response=GlobalSearchEndpoint.validateGlobalSeachResponse();
		System.out.println(response.then().log().all());
		System.out.println("Response Time : "+response.time());
		AssertJUnit.assertTrue(response.time()<3000);
	}
	
	@Test()
	public void validateGlobalSearch_withvalidPartNo() {
		Response response=GlobalSearchEndpoint.validateGlobalSeachwithvaliPartno();
		System.out.println(response.then().log().all());
		String partNo=response.jsonPath().getString("data.parts[0].PART_NUM");
		AssertJUnit.assertEquals(partNo, "16531M79F00");
		
	}
	
	@Test()
	public void validateGlobalSearch_withvalidPartName() {
		Response response=GlobalSearchEndpoint.validateGlobalSeachwithvalidPartName();
		System.out.println(response.then().log().all());
		String partNo=response.jsonPath().getString("data.parts[0].PART_NUM");
		List<Array> list=response.jsonPath().getList("data.parts");
		
		System.out.println(list.size());
		AssertJUnit.assertTrue(list.size()>0);
	}
	
	@Test()
	public void validateGlobalSearch_withPartialPartName() {
		Response response=GlobalSearchEndpoint.validateGlobalSeachwithvalidPartialPartNo();
		System.out.println(response.then().log().all());
		List<Array> list=response.jsonPath().getList("data.parts");
		
		System.out.println(list.size());
		AssertJUnit.assertTrue(list.size()>0);
		System.out.println();
		for( int i=0;i<list.size();i++) {
			AssertJUnit.assertTrue(response.jsonPath().getString("data.parts["+i+"].PART_NUM").contains("54402M79"));
		}
	}
	
	
	@Test()
	public void validateGlobalSearch_errorStatus_withvalidQuerry() {
		Response response=GlobalSearchEndpoint.validateGlobalSeachResponse();
		System.out.println(response.then().log().all());
		AssertJUnit.assertEquals(response.jsonPath().getBoolean("error"), false);
		
	
	}
	
	@Test()
	public void validateGlobalSearch_errorStatusAndErrorMsg_withInvalid_catgCdQuerry() {
		Response response=GlobalSearchEndpoint.validateGlobalSeachResponseInvalidcatgCd();
		System.out.println(response.then().log().all());
		AssertJUnit.assertEquals(response.jsonPath().getBoolean("error"), true);
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMsg=response.jsonPath().getString("errors[0].errorMessage");	
		AssertJUnit.assertEquals(errCode, "CATEGORY.CODE.ERROR");
		AssertJUnit.assertEquals(errMsg, "catgCd can only be AA, AG or M ");
	}
	
	@Test()
	public void validateGlobalSearch_errorStatusAndErrorMsg_withInvalid_searchStringQuerry() {
		Response response=GlobalSearchEndpoint.validateGlobalSeachResponseInvalidSearchString();
		System.out.println(response.then().log().all());
		AssertJUnit.assertEquals(response.jsonPath().getBoolean("error"), true);
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMsg=response.jsonPath().getString("errors[0].errorMessage");	
		AssertJUnit.assertEquals(errCode, "FAILED.TO.GET.DATA");
		AssertJUnit.assertTrue(errMsg.contains("Parts not present for the provided input"));
	}
	
	@Test()
	public void validateGlobalSearch_errorStatusAndErrorMsg_withInvalid_Querry() {
		Response response=GlobalSearchEndpoint.validateGlobalSeachResponseInvalidSearchString();
		System.out.println(response.then().log().all());
		AssertJUnit.assertEquals(response.jsonPath().getString("data"), null);
	
	}
	
}
