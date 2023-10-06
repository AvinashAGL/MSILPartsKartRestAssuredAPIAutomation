package api.endpoint;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class microserviceEndpoints {

	public static Response getCategoryTree() {
		
		
		Response response=
		 
		given()
		.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
		.header("x-api-key","BRDgjGmQf3aSM95OXXNyD5YSeZAsW1ac9N89zo1J")
		.queryParam("mastApplicability", "S")
		.when()
		.get("https://cf.msilcrm.co.in/crm-common/api/common/msil/partmaster/search-category-tree");
		return response;
		
	}
public static Response getCategoryTreeInvalidQuery() {
		
		
		Response response=
		 
		given()
		.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
		.header("x-api-key","BRDgjGmQf3aSM95OXXNyD5YSeZAsW1ac9N89zo1J")
		.queryParam("mastApplicability", "B")
		.when()
		.get("https://cf.msilcrm.co.in/crm-common/api/common/msil/partmaster/search-category-tree");
		return response;
		
	}
public static Response getCategoryTreeWithoutQuery() {
	
	
	Response response=
	 
	given()
	.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
	.header("x-api-key","BRDgjGmQf3aSM95OXXNyD5YSeZAsW1ac9N89zo1J")
	.when()
	.get("https://cf.msilcrm.co.in/crm-common/api/common/msil/partmaster/search-category-tree");
	return response;
	
}

}
