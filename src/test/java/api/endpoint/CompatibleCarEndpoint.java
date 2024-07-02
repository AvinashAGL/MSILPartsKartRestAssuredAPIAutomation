package api.endpoint;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CompatibleCarEndpoint {
	
	//Method for getting URL's from properties file
		static ResourceBundle getUrl() {
			ResourceBundle bundle=ResourceBundle.getBundle("routes");   //Load the properties file
			return bundle;
			
		}

		public static Response getCompatibleCar() {
//			RestAssured.baseURI="https:/cf.msilcrm.co.in/crm-common/api/common/msil/partmaster/compatible-cars";
			Response response=
			given()
			.header("User-Agent",getUrl().getString("user_agent"))
			.header("x-api-key",getUrl().getString("x_api_key"))
			.queryParam("partNum", "35300M66T00")
			.when()
			.get(getUrl().getString("compatibleCar"));
			response.then().log().all();
			return response;
			
		}
		
		public static Response getCompatibleCarwithInvalidPartno() {
			Response response=
			given()
			.header("User-Agent",getUrl().getString("user_agent"))
			.header("x-api-key",getUrl().getString("x_api_key"))
			.queryParam("partNum", "35300M66T00fgfgfg")
			.when()
			.get(getUrl().getString("compatibleCar"));
			response.then().log().all();
			return response;
			
		}
		public static Response getCompatibleCarWithBlankPartNo() {
			Response response=
			given()
			.header("User-Agent",getUrl().getString("user_agent"))
			.header("x-api-key",getUrl().getString("x_api_key"))
			.queryParam("partNum", "")
			.when()
			.get(getUrl().getString("compatibleCar"));
			response.then().log().all();
			return response;
			
		}

}
