package api.endpoint;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import io.restassured.response.Response;

public class CompatibleCarEndpoint {
	
	//Method for getting URL's from properties file
		static ResourceBundle getUrl() {
			ResourceBundle bundle=ResourceBundle.getBundle("routes");   //Load the properties file
			return bundle;
			
		}

		public static Response getCompatibleCar() {
			Response response=
			given()
			.header("User-Agent",getUrl().getString("user_agent"))
			.header("x-api-key",getUrl().getString("x_api_key"))
			.queryParam("partNum", "14110M72R10")
			.when()
			.get(getUrl().getString("compatibleCar"));
			response.then().log().all();
			return response;
			
		}
		
		public static Response getCompatibleCar1() {
			Response response=
			given()
			.header("User-Agent",getUrl().getString("user_agent"))
			.header("x-api-key",getUrl().getString("x_api_key"))
			.queryParam("partNum", "14110M72R10")
			.when()
			.get(getUrl().getString("compatibleCar"));
			return response;
			
		}

}
