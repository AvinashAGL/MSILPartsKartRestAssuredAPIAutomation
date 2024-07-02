package api.endpoint;

import java.util.ResourceBundle;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class ProductDetailEndpoint {
	
	// Method for getting URL's from properties file
		public static ResourceBundle getData() {
			ResourceBundle bundle = ResourceBundle.getBundle("routes"); // Load the properties file
			return bundle;

		}
		
		
		public static Response productDetailwithValidPartNo() {
			
			Response response= given()
				.header("x-api-Key",getData().getString("x_api_key"))
				.header("user-Agent", getData().getString("user_agent"))
				.queryParam("partNum", "09409M07L01")
				.when()
				.get(getData().getString("productDetail"));
			
			return response;
		}
		
public static Response productDetailwithInvalidPartNo() {
			
			Response response= given()
				.header("x-api-Key",getData().getString("x_api_key"))
				.header("user-Agent", getData().getString("user_agent"))
				.queryParam("partNum", "09409M07XCD")
				.when()
				.get(getData().getString("productDetail"));
			
			return response;
		}

}
