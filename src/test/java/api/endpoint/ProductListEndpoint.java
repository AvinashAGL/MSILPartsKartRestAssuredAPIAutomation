package api.endpoint;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.util.ResourceBundle;

import io.restassured.response.Response;

public class ProductListEndpoint {//Method for getting URL's from properties file
	static ResourceBundle getUrl() {
		ResourceBundle bundle=ResourceBundle.getBundle("routes");   //Load the properties file
		return bundle;
		
	}
	
	

	public static Response getProductList() throws FileNotFoundException {
		
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"pageNo\":1,\n" +
	                "    \"pageSize\":10\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}
	
	public static Response getProductListwith2Valid_catCd() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\"\n" +
	                "    ],\n" +
	                "    \"pageNo\":1,\n" +
	                "    \"pageSize\":10\n" +
	                "}";
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}
	public static Response getProductListwith3Valid_catCd() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"pageNo\":1,\n" +
	                "    \"pageSize\":10\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}

	public static Response getProductListwithValid_categories_categoryL1() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"categories\": [\n" +
	                "        {\n" +
	                "            \"categoryL1\": \"P_SNB\",\n" +
	                "            \"categoryL2\": \"\",\n" +
	                "            \"categoryL3\": \"\"\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}
	public static Response getProductListwithValid_categories_categoryL1categoryL2() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"categories\": [\n" +
	                "        {\n" +
	                "            \"categoryL1\": \"P_SNB\",\n" +
	                "            \"categoryL2\": \"W_BRS\",\n" +
	                "            \"categoryL3\": \"\"\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}

	public static Response getProductListwithValid_categories_categoryL1categoryL2categoryL3() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"categories\": [\n" +
	                "        {\n" +
	                "            \"categoryL1\": \"P_SNB\",\n" +
	                "            \"categoryL2\": \"W_BRS\",\n" +
	                "            \"categoryL3\": \"SAFAA\"\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}

	public static Response getProductListwithValid_1Model() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"P\",\n" +
	                "            \"variantCd\": \"\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2008\",\n" +
	                "                \"toYear\": \"2013\"\n" +
	                "            }\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}

	public static Response getProductListwithValid_1Model1var() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"P\",\n" +
	                "            \"variantCd\": \"AT\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2008\",\n" +
	                "                \"toYear\": \"2013\"\n" +
	                "            }\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}
	public static Response getProductListwithValid_1Model2var() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"P\",\n" +
	                "            \"variantCd\": \"AT\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2008\",\n" +
	                "                \"toYear\": \"2013\"\n" +
	                "            }\n" +
	                "        },\n" +
	                "        {\n" +
	                "            \"modelCd\": \"P\",\n" +
	                "            \"variantCd\": \"LXI\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2008\",\n" +
	                "                \"toYear\": \"2013\"\n" +
	                "            }\n" +
	                "        }\n" +
	             
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}

	public static Response getProductListwithValid_2model() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"P\",\n" +
	                "            \"variantCd\": \"\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2008\",\n" +
	                "                \"toYear\": \"2013\"\n" +
	                "            }\n" +
	                "        },\n" +
	                "        {\n" +
	                "            \"modelCd\": \"CL\",\n" +
	                "            \"variantCd\": \"\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2013\",\n" +
	                "                \"toYear\": \"9999\"\n" +
	                "            }\n" +
	                "        }\n" +
	             
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}

	public static Response getProductListwithValid_2model1var() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"P\",\n" +
	                "            \"variantCd\": \"AT\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2008\",\n" +
	                "                \"toYear\": \"2013\"\n" +
	                "            }\n" +
	                "        },\n" +
	                "        {\n" +
	                "            \"modelCd\": \"CL\",\n" +
	                "            \"variantCd\": \"\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2013\",\n" +
	                "                \"toYear\": \"9999\"\n" +
	                "            }\n" +
	                "        }\n" +
	             
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}

	public static Response getProductListwithValid_2model2var() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"P\",\n" +
	                "            \"variantCd\": \"AT\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2008\",\n" +
	                "                \"toYear\": \"2013\"\n" +
	                "            }\n" +
	                "        },\n" +
	                "        {\n" +
	                "            \"modelCd\": \"CL\",\n" +
	                "            \"variantCd\": \"AL\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2013\",\n" +
	                "                \"toYear\": \"9999\"\n" +
	                "            }\n" +
	                "        }\n" +
	             
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}
	
	
	public static Response getProductListwithvalidRegNo() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"regNo\":\"KA51MK5026\",\n" +
	                "    \"pageNo\":1,\n" +
	                "    \"pageSize\":10\n" +
	                "}";
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}

	public static Response getProductListwithvalidVinNo() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"vin\":\"MA3EADE1S00578241\",\n" +
	                "    \"pageNo\":1,\n" +
	                "    \"pageSize\":10\n" +
	                "}";
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}
	
	public static Response getProductListwithvalidPartNo() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"partNumbers\":\"35121M66L00\",\n" +
	                "    \"pageNo\":1,\n" +
	                "    \"pageSize\":10\n" +
	                "}";
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}
	
	public static Response getProductListwithvalidCategoryL1AndModel() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"categories\": [\n" +
	                "        {\n" +
	                "            \"categoryL1\": \"P_SNB\",\n" +
	                "            \"categoryL2\": \"\",\n" +
	                "            \"categoryL3\": \"\"\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"AA\",\n" +
	                "            \"variantCd\": \"C6\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2012\",\n" +
	                "                \"toYear\": \"9999\"\n" +
	                "            }\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}
	public static Response getProductListwithvalidCategoryL1L2AndModel() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"categories\": [\n" +
	                "        {\n" +
	                "            \"categoryL1\": \"P_SNB\",\n" +
	                "            \"categoryL2\": \"W_BRS\",\n" +
	                "            \"categoryL3\": \"\"\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"AA\",\n" +
	                "            \"variantCd\": \"C6\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2012\",\n" +
	                "                \"toYear\": \"9999\"\n" +
	                "            }\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}
	
	public static Response getProductListPagination() throws FileNotFoundException {
		
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"pageNo\":5,\n" +
	                "    \"pageSize\":20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}
	
	public static Response getProductListSortHighTIOLow() throws FileNotFoundException {
		
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"pageNo\":1,\n" +
	                "    \"pageSize\":50,\n" +
	                "    \"sortField\":\"price\",\n" +
	                "    \"sortOrder\":\"desc\"\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}

	public static Response getProductListSortLowToHigh() throws FileNotFoundException {
		
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"pageNo\":1,\n" +
	                "    \"pageSize\":50,\n" +
	                "    \"sortField\":\"price\",\n" +
	                "    \"sortOrder\":\"asc\"\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}

	public static Response getProductListSortNew() throws FileNotFoundException {
		
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"pageNo\":1,\n" +
	                "    \"pageSize\":50,\n" +
	                "    \"sortField\":\"effective_from_date\",\n" +
	                "    \"sortOrder\":\"desc\"\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}

	public static Response getProductListSortName() throws FileNotFoundException {
		
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"pageNo\":1,\n" +
	                "    \"pageSize\":500,\n" +
	                "    \"sortField\":\"title\",\n" +
	                "    \"sortOrder\":\"asc\"\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}
	
	/*			Negetive Cases			*/

	public static Response getProductListInvalidcatCD() throws FileNotFoundException {
		
		 String jsonPayload = "{\n" +
	               "    \"catgCd\": [\n" +
	               "        \"S\"\n" +
	               "    ],\n" +
	               "    \"pageNo\":1,\n" +
	               "    \"pageSize\":10\n" +
	               "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}
	public static Response getProductListwith1Valid_catCd1Invalid_catCd() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"A\"\n" +
	                "    ],\n" +
	                "    \"pageNo\":1,\n" +
	                "    \"pageSize\":10\n" +
	                "}";
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}

	public static Response getProductListwithInvalid_CategoriesL1() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"categories\": [\n" +
	                "        {\n" +
	                "            \"categoryL1\": \"A_ASS\",\n" +
	                "            \"categoryL2\": \"\",\n" +
	                "            \"categoryL3\": \"\"\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}
	
	public static Response getProductListwithInvalid_CategoriesL2() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"categories\": [\n" +
	                "        {\n" +
	                "            \"categoryL1\": \"P_SNB\",\n" +
	                "            \"categoryL2\": \"Afklj\",\n" +
	                "            \"categoryL3\": \"\"\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
		
	}

	public static Response getProductListwithInvalid_CategoriesL3() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"categories\": [\n" +
	                "        {\n" +
	                "            \"categoryL1\": \"P_SNB\",\n" +
	                "            \"categoryL2\": \"W_BRS\",\n" +
	                "            \"categoryL3\": \"fddf\"\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\",\n" +
	                "        \"AA\",\n" +
	                "        \"AG\"\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}

	public static Response getProductListwithInvalid_modelCd() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"P\",\n" +
	                "            \"variantCd\": \"\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2008\",\n" +
	                "                \"toYear\": \"2013\"\n" +
	                "            }\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}
	
	public static Response getProductListwithInvalid_variantCd() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"AA\",\n" +
	                "            \"variantCd\": \"D\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2008\",\n" +
	                "                \"toYear\": \"2013\"\n" +
	                "            }\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}
	
	public static Response getProductListwithInvalid_FromYear() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"AA\",\n" +
	                "            \"variantCd\": \"C6\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"200\",\n" +
	                "                \"toYear\": \"2013\"\n" +
	                "            }\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}

	public static Response getProductListwithInvalid_ToYear() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"AA\",\n" +
	                "            \"variantCd\": \"C6\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2012\",\n" +
	                "                \"toYear\": \"2121\"\n" +
	                "            }\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}

	public static Response getProductListwithout_modelCd() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"\",\n" +
	                "            \"variantCd\": \"\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2008\",\n" +
	                "                \"toYear\": \"2013\"\n" +
	                "            }\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}

	public static Response getProductListwithout_fromYear() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"AA\",\n" +
	                "            \"variantCd\": \"\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"\",\n" +
	                "                \"toYear\": \"9999\"\n" +
	                "            }\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}

	public static Response getProductListwithout_toYear() throws FileNotFoundException {
		 String jsonPayload = "{\n" +
	                "    \"catgCd\": [\n" +
	                "        \"M\"\n" +
	                "    ],\n" +
	                "    \"modelVariants\": [\n" +
	                "        {\n" +
	                "            \"modelCd\": \"AA\",\n" +
	                "            \"variantCd\": \"\",\n" +
	                "            \"yearRange\": {\n" +
	                "                \"fromYear\": \"2012\",\n" +
	                "                \"toYear\": \"\"\n" +
	                "            }\n" +
	                "        }\n" +
	                "    ],\n" +
	                "    \"pageNo\": 1,\n" +
	                "    \"pageSize\": 20\n" +
	                "}";
		
		Response response=
		given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(jsonPayload)
		.when()
		.post(getUrl().getString("SearchProductList"));
		return response;
	}

	
	
	
}
