package api.endpoint;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class microserviceEndpoints2 {

	// Method for getting URL's from properties file
	static ResourceBundle getUrl() {
		ResourceBundle bundle = ResourceBundle.getBundle("routes"); // Load the properties file
		return bundle;

	}

	public static Response getCategoryTree() {
		Response response = given().header("User-Agent", getUrl().getString("user_agent"))
				.header("x-api-key", getUrl().getString("x_api_key")).queryParam("mastApplicability", "S").when()
				.get(getUrl().getString("category_Tree"));
		return response;

	}

	public static Response getCategoryTreeInvalidQuery() {

		Response response =

				given().header("User-Agent", getUrl().getString("user_agent"))
						.header("x-api-key", getUrl().getString("x_api_key")).queryParam("mastApplicability", "B")
						.when().get(getUrl().getString("category_Tree"));
		return response;

	}

	public static Response getCategoryTreeWithoutQuery() {

		Response response =

				given().header("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
						.header("x-api-key", "BRDgjGmQf3aSM95OXXNyD5YSeZAsW1ac9N89zo1J").when()
						.get(getUrl().getString("category_Tree"));
		return response;

	}

}
