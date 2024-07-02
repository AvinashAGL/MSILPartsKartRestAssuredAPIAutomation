package api.test;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.ProductListEndpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class SearchProductListTest {
	@Test()
	public void verifySerchProductListStatusCodeWithValidData() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductList();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test()
	public void verifySerchProductListStatusCodeWith2Valid_catCd_Data() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwith2Valid_catCd();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test()
	public void verifySerchProductListStatusCodeWith3Valid_catCd_Data() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwith3Valid_catCd();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test()
	public void verifySerchProductListStatusCodeWithValid_categories_categoryL1() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithValid_categories_categoryL1();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithValid_categories_categoryL1categoryL2() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithValid_categories_categoryL1categoryL2();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithValid_categories_categoryL1categoryL2categoryL2() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithValid_categories_categoryL1categoryL2categoryL3();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test()
	public void verifySerchProductListStatusCodeWithValid_1Model() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithValid_1Model();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithValid_1Model1variant() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithValid_1Model1var();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test()
	public void verifySerchProductListStatusCodeWithValid_1Model2variant() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithValid_1Model2var();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test()
	public void verifySerchProductListStatusCodeWithValid_2Model() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithValid_2model();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}


	@Test()
	public void verifySerchProductListStatusCodeWithValid_2Model1Variant() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithValid_2model1var();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithValid_2Model2Variant() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithValid_2model2var();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithValidRegistrationNo() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithvalidRegNo();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithValidVinNo() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithvalidVinNo();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithValid_PartNumber() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithvalidPartNo();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithValid_CategotyL1andMOdelVariant() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithvalidCategoryL1AndModel();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithValid_CategotyL1L2andMOdelVariant() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithvalidCategoryL1L2AndModel();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	
	
	
	@Test()
	public void verifySerchProductListErrorWithValidData() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductList();
//		response.then().log().body();
		String error = response.jsonPath().getString("error");
		String errors = response.jsonPath().getString("errors");
		Assert.assertEquals(error, "false");
		Assert.assertEquals(errors, null);
	}

	@Test()
	public void verifySerchProductListPartresponsrCount() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductList();
//		response.then().log().body();
		List<Array> list=response.jsonPath().getList("data.PRODUCT_LIST");
		int size=list.size();
		System.out.println(size);
		Assert.assertEquals(10, size,"Expected size is 10 & Actual size is: "+size);
	}

	
	@Test()
	public void verifySerchProductListPaginationWithValidData() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListPagination();
		response.then().log().body();
		int totalPages= response.jsonPath().getInt("data.TOTAL_PAGES");
		int currentPageNo= response.jsonPath().getInt("data.CURRENT_PAGE_NO");
		
		Assert.assertTrue(totalPages>=1340);
		Assert.assertTrue(currentPageNo==5);

	}
	
	@Test()
	public void verifySerchProductList_Sorting_HighToLow() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListSortHighTIOLow();
		response.then().log().body();
		
		List<Array> list=response.jsonPath().getList("data.PRODUCT_LIST");
		int size=list.size();
		System.out.println(size);
		Float high=response.jsonPath().getFloat("data.PRODUCT_LIST[0].PART_MRP");

		for(int i=0;i<size-1;i++) {
			System.out.println(high);
			Float low=response.jsonPath().getFloat("data.PRODUCT_LIST["+(i+1)+"].PART_MRP");
			Assert.assertTrue(high>=low);
			
			high=low;
		}
	}


	@Test()
	public void verifySerchProductList_Sorting_LowToHigh() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListSortLowToHigh();
		response.then().log().body();
		List<Array> list=response.jsonPath().getList("data.PRODUCT_LIST");
		int size=list.size();
		System.out.println(size);
		Float low=response.jsonPath().getFloat("data.PRODUCT_LIST[0].PART_MRP");

		for(int i=0;i<size-1;i++) {
			System.out.println(low);
			Float high=response.jsonPath().getFloat("data.PRODUCT_LIST["+(i+1)+"].PART_MRP");
			Assert.assertTrue(high>=low);
			
			low=high;
		}
	}

	@Test()
	public void verifySerchProductList_Sorting_New() throws FileNotFoundException, ParseException {
		Response response=ProductListEndpoint.postProductListSortNew();
		response.then().log().body();
		List<Array> list=response.jsonPath().getList("data.PRODUCT_LIST");
		int size=list.size();
		System.out.println(size);
		String date=response.jsonPath().getString("data.PRODUCT_LIST[0].SALES_EFF_DATE");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	    Date date1=dateFormat.parse(date); 

	    for(int i=0;i<size-1;i++) {
			System.out.println(date1);
			String d2=response.jsonPath().getString("data.PRODUCT_LIST["+(i+1)+"].SALES_EFF_DATE");
			Date date2=dateFormat.parse(d2);
			Assert.assertTrue(date1.compareTo(date2)>=0);
			date1=date2;
		}
	}

	@Test()
	public void verifySerchProductList_Sorting_Name() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListSortName();
		response.then().log().body();
		
		List<Array> list=response.jsonPath().getList("data.PRODUCT_LIST");
		int size=list.size();
		System.out.println(size);
		String name1=response.jsonPath().getString("data.PRODUCT_LIST[0].PART_NAME");

		for(int i=0;i<size-1;i++) {
			System.out.println(name1);
			String name2=response.jsonPath().getString("data.PRODUCT_LIST["+(i+1)+"].PART_NAME");
			if (name1.equals(name2)) {
				Assert.assertTrue(true);
			}
			else {
				Boolean sts=name2.compareTo(name1)>0;
				System.out.println(sts);
				assertTrue(sts);
			}
			name1=name2;
		}
	}
	
	
	
	/*			Negetive Test cases					*/
	
	@Test()
	public void verifySerchProductListStatusCodeWithInvalidCatCD() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListInvalidcatCD();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 400);
	}
	
	@Test()
	public void verifySerchProductList_error_errorCode_errorMessage_WithInvalidCatCD() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListInvalidcatCD();
		response.then().log().body();
		boolean errStatus=response.jsonPath().getBoolean("error");
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMessage=response.jsonPath().getString("errors[0].errorMessage");

		Assert.assertEquals(errStatus, true);
		Assert.assertEquals(errCode, "INVALID.INPUT");
		Assert.assertEquals(errMessage, "Invalid CatgCd, Valid values are AA,M,AG");
	}
	
	@Test()
	public void verifySerchProductList_data_WithoutCatCD() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListInvalidcatCD();
		response.then().log().body();
		String data=response.jsonPath().getString("data");

		Assert.assertEquals(data, null);
	}

	
	@Test()
	public void verifySerchProductListStatusCodeWith_1ValidAnd1InvalidCatCD() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwith1Valid_catCd1Invalid_catCd();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 400);
	}

	@Test()
	public void verifySerchProductList_error_errorCode_errorMessage_With_1ValidAnd1InvalidCatCD() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwith1Valid_catCd1Invalid_catCd();
		response.then().log().body();
		boolean errStatus=response.jsonPath().getBoolean("error");
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMessage=response.jsonPath().getString("errors[0].errorMessage");

		Assert.assertEquals(errStatus, true);
		Assert.assertEquals(errCode, "INVALID.INPUT");
		Assert.assertEquals(errMessage, "Invalid CatgCd, Valid values are AA,M,AG");
		Assert.assertEquals(response.getStatusCode(), 400);
	}
	
	@Test()
	public void verifySerchProductListDataWith_1ValidAnd1InvalidCatCD() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwith1Valid_catCd1Invalid_catCd();
		response.then().log().body();
		
		String data=response.jsonPath().getString("data");
		Assert.assertEquals(data, null);

	}


	@Test()
	public void verifySerchProductListStatusCodeWith_InvalidCategoriesL1() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithInvalid_CategoriesL1();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductList_error_errorCode_errorMessage_With_InvalidCategoriesL1() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithInvalid_CategoriesL1();
		response.then().log().body();
		boolean errStatus=response.jsonPath().getBoolean("error");
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMessage=response.jsonPath().getString("errors[0].errorMessage");

		Assert.assertEquals(errStatus, true);
		Assert.assertEquals(errCode, "FAILED.TO.GET.DATA");
		Assert.assertEquals(errMessage, "Data not found for the given Input");
	}

	@Test()
	public void verifySerchProductList_Data_With_InvalidCategoriesL1() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithInvalid_CategoriesL1();
		response.then().log().body();
		String data=response.jsonPath().getString("data");
		Assert.assertEquals(data, null);
	}
	
	@Test()
	public void verifySerchProductListHeaders() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductList();
		response.then().log().body();

		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		Assert.assertEquals(response.getHeader("Connection"), "keep-alive");
		Assert.assertEquals(response.getHeader("X-XSS-Protection"), "1; mode=block");
		Assert.assertEquals(response.getHeader("Content-Security-Policy"), "default-src 'self' blob:; img-src 'self' blob:; script-src 'unsafe-eval' 'unsafe-inline' 'self' https://cf.msilcrm.co.in/* https://*.msilcrm.co.in/ https://crm-dev-static-website.s3.ap-south-1.amazonaws.com/uniagentDialerFunc.js;  font-src 'self' blob:; style-src 'self' 'unsafe-inline'; frame-src *; connect-src 'self' https://cf.msilcrm.co.in/ https://*.msilcrm.co.in/ https://*.cloudfront.net https://*.amazonaws.com https://www.preprod.marutisuzukisubscribe.com https://*.amazoncognito.com https://*.cf.marutisuzukisubscribe.com https://*.msilcrm.co.in https://msilcrm.co.in; blob:");
		Assert.assertEquals(response.getHeader("x-amzn-Remapped-Connection"), "keep-alive");
		Assert.assertEquals(response.getHeader("Strict-Transport-Security"), "max-age=63072000; includeSubdomains; preload");
		Assert.assertEquals(response.getHeader("X-Frame-Options"), "DENY");
		Assert.assertEquals(response.getHeader("Referrer-Policy"), "same-origin");
		Assert.assertEquals(response.getHeader("Server"), "Unspecified");
		Assert.assertEquals(response.getHeader("Vary"), "Origin");
		Assert.assertEquals(response.getHeader("X-Cache"), "Miss from cloudfront");
		Assert.assertEquals(response.getHeader("X-Amz-Cf-Pop"), "DEL54-P7");
		
	}
	
	
//---
	@Test()
	public void verifySerchProductListStatusCodeWith_InvalidCategoriesL2() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithInvalid_CategoriesL2();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test()
	public void verifySerchProductListStatusCodeWith_InvalidCategoriesL3() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithInvalid_CategoriesL3();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWith_InvalidModelCd() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithInvalid_modelCd();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test()
	public void verifySerchProductListStatusCodeWith_InvalidVariantCd() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithInvalid_variantCd();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWith_InvalidYearRange_FromYear() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithInvalid_FromYear();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWith_InvalidYearRange_ToYear() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithInvalid_ToYear();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithout_ModelCd() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithout_modelCd();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 400);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithout_Fromyear() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithout_fromYear();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 400);
	}

	@Test()
	public void verifySerchProductListStatusCodeWithout_toYear() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListwithout_toYear();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 400);
	}

	@Test()
	public void verifySerchProductListMessageOnLastPageWithValidRegistrationNo() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductListMessagewithvalidRegNo();
		response.then().log().body();
		String errCode=response.jsonPath().getString("errors[0].errorCode");
		String errMessage=response.jsonPath().getString("errors[0].errorMessage");
		
		Assert.assertEquals(errCode, "END.OF.LIST");
		Assert.assertEquals(errMessage, "You've reached the end of search results");
	}
	
	
	
	
//-----------------------------------
	@Test()
	public void verifySerchProductListSchema() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductList();
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("/Users/avinashmaurya/eclipse-workspace/MSILPartsKartRestAssuredAPIAutomation/src/test/resources/Schema/SchemaCategoryTree.json"));

	}
	
//	---------------------------
	@Test()
	public void verifySerchProductLisEndpoint() throws FileNotFoundException {
		Response response=ProductListEndpoint.postProductList();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
//		 String actualUrl = response.;
//	        System.out.println("Actual URL: " + actualUrl);
	}

}
