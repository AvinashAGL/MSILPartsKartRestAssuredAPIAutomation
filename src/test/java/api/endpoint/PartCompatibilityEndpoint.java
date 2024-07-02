package api.endpoint;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.response.Response;

public class PartCompatibilityEndpoint {
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
				.queryParam("partNum", "74120M53M00")
				.queryParam("regNum", "WB02AH7086")
				.when()
				.get(getUrl().getString("partcompatibility"));
				return response;
				
			}
			public static Response getCompatibleCarwithinvalidpartNum() {
				Response response=
				given()
				.header("User-Agent",getUrl().getString("user_agent"))
				.header("x-api-key",getUrl().getString("x_api_key"))
				.queryParam("partNum", "74120M53M00SAS")
				.queryParam("regNum", "WB02AH7086")
				.when()
				.get(getUrl().getString("partcompatibility"));
				return response;
				
			}

			public static Response getCompatibleCarwithinvalidregNum() {
				Response response=
				given()
				.header("User-Agent",getUrl().getString("user_agent"))
				.header("x-api-key",getUrl().getString("x_api_key"))
				.queryParam("partNum", "74120M53M00")
				.queryParam("regNum", "WB02AH0086")
				.when()
				.get(getUrl().getString("partcompatibility"));
				return response;
				
			}

			
			public static Response getCompatibleCarwithoutpartNum() {
				Response response=
				given()
				.header("User-Agent",getUrl().getString("user_agent"))
				.header("x-api-key",getUrl().getString("x_api_key"))
				.queryParam("regNum", "HR26EQ5606")
				.when()
				.get(getUrl().getString("partcompatibility"));
				return response;
				
			}
			
			public static Response getCompatibleCarwithoutregNum() {
				Response response=
				given()
				.header("User-Agent",getUrl().getString("user_agent"))
				.header("x-api-key",getUrl().getString("x_api_key"))
				.queryParam("partNum", "16510M68K10")
				.when()
				.get(getUrl().getString("partcompatibility"));
				return response;
				
			}
			public static Response getCompatibleCarwithoutpartNum_regNum() {
				Response response=
				given()
				.header("User-Agent",getUrl().getString("user_agent"))
				.header("x-api-key",getUrl().getString("x_api_key"))
				.when()
				.get(getUrl().getString("partcompatibility"));
				return response;
				
			}
			

}
