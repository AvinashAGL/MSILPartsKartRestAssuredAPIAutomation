package api.endpoint;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.response.Response;

public class ModelTreeEndpoint {
	

	// Method for getting URL's from properties file
	static ResourceBundle getData() {
		ResourceBundle bundle = ResourceBundle.getBundle("routes"); // Load the properties file
		return bundle;

	}
	
	public static Response getModelTree() {
		Response response = given()
//				.baseUri(getData().getString("base_Url"))
				.header("User-Agent", getData().getString("user_agent"))
				.header("x-api-key", getData().getString("x_api_key"))
				.when()
				.get(getData().getString("model_Tree"));
		return response;

	}

}
