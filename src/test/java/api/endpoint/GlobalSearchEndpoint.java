package api.endpoint;

import java.util.ResourceBundle;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class GlobalSearchEndpoint {

	static ResourceBundle getData() {
		ResourceBundle bundle = ResourceBundle.getBundle("routes"); // Load the properties file
		return bundle;
	}
	
	public static Response validateGlobalSeachwithvaliPartno() {
		Response response=
				given()
				.header("x-api-key",getData().getString("x_api_key"))
				.header("User-Agent",getData().getString("user_agent"))
				.header("Content-Type",getData().getString("content_Type"))
				.queryParam("catgCd", "M,AA,AG")
				.queryParam("searchString", "16531M79F00")
				.when()
				.get(getData().getString("globalSearch"));
				return response;
			}
	public static Response validateGlobalSeachwithvalidPartName() {
		Response response=
				given()
				.header("x-api-key",getData().getString("x_api_key"))
				.header("User-Agent",getData().getString("user_agent"))
				.header("Content-Type",getData().getString("content_Type"))
				.queryParam("catgCd", "M,AA,AG")
				.queryParam("searchString", "oil filter")
				.when()
				.get(getData().getString("globalSearch"));
				return response;
			}
	public static Response validateGlobalSeachwithvalidPartialPartNo() {
		Response response=
				given()
				.header("x-api-key",getData().getString("x_api_key"))
				.header("User-Agent",getData().getString("user_agent"))
				.header("Content-Type",getData().getString("content_Type"))
				.queryParam("catgCd", "M,AA,AG")
				.queryParam("searchString", "54402M79")
				.when()
				.get(getData().getString("globalSearch"));
				return response;
			}
	
	public static Response validateGlobalSeachResponse() {
		Response response=
				given()
				.header("x-api-key",getData().getString("x_api_key"))
				.header("User-Agent",getData().getString("user_agent"))
				.header("Content-Type",getData().getString("content_Type"))
				.queryParam("catgCd", "M,AA,AG")
				.queryParam("searchString", "OIl filter")
				.when()
				.get(getData().getString("globalSearch"));
				return response;
			}
	
	public static Response validateGlobalSeachResponseInvalidcatgCd() {
		
		Response response=
				given()
				.header("x-api-key",getData().getString("x_api_key"))
				.header("User-Agent",getData().getString("user_agent"))
				.header("Content-Type",getData().getString("content_Type"))
				.queryParam("catgCd", "ZZ")
				.queryParam("searchString", "OIl filter")
				.when()
				.get(getData().getString("globalSearch"));
				return response;
			}
public static Response validateGlobalSeachResponseInvalidSearchString() {
		
		Response response=
				given()
				.header("x-api-key",getData().getString("x_api_key"))
				.header("User-Agent",getData().getString("user_agent"))
				.header("Content-Type",getData().getString("content_Type"))
				.queryParam("catgCd", "M,AA,AG")
				.queryParam("searchString", "AB12r")
				.when()
				.get(getData().getString("globalSearch"));
				return response;
			}
		
	
}
