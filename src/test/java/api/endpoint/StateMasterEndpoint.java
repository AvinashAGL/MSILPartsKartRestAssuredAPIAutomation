package api.endpoint;

import java.util.ResourceBundle;

import api.utilities.AES_Decrypt;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StateMasterEndpoint {

	// Method for getting URL's from properties file
	static ResourceBundle getData() {
		
		ResourceBundle bundle = ResourceBundle.getBundle("routes"); // Load the properties file
		return bundle;

	}

	public static Response stateMasterResponseCode() {

//		RestAssured.baseURI="https://marutigenuineparts.in";
		Response response = given()
							.when()
							.get("https://marutigenuineparts.in/api/v2/state_master");
		System.out.println(response.statusCode());

		  return response;

	}
	
	public static Response stateMasterResponseTime() {

		Response response = given()
							.when()
							.get("https://marutigenuineparts.in/api/v2/state_master");
		System.out.println(response.statusCode());
		
		  return response;

	}

	public static Response stateMasterResponseErrorCodeMessage() {

		Response response = given()
							.when()
							.get("https://marutigenuineparts.in/api/v2/state_master");
		System.out.println(response.statusCode());
		
		 String responseString=response.prettyPrint();
		 String cleanResponse = (responseString.toString()).replaceAll("\"", "");
		  Response decryptResponse=AES_Decrypt.decrypt(cleanResponse);

		  return decryptResponse;

	}
}
