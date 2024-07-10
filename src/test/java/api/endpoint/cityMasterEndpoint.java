package api.endpoint;

import java.util.ResourceBundle;

import api.utilities.AES_Decrypt;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class cityMasterEndpoint {
	
	//Method for getting URL's from properties file
			static ResourceBundle getData() {
				ResourceBundle bundle=ResourceBundle.getBundle("routes");   //Load the properties file
				return bundle;
				
			}
			
	public static Response validateCityMaster_ResponseCode() {
		
		  String requestBody = "{\"state_code\":\"MP\"}";
		
		Response response=  given()
					.header("Content-Type","application/json")
					.body(requestBody)
					.when()
					.get("https://marutigenuineparts.in/api/v2/city_master");
		
		 String responseString=response.asString();
	       String cleanResponse = (responseString.toString()).replaceAll("\"", "");
		  
		  Response decryptResponse=AES_Decrypt.decrypt(cleanResponse);
		  
		  return decryptResponse;
	}
	
	public static Response validateCityMaster_ResponseCode2() {
		
		  String requestBody = "{\"state_code\":\"MP\"}";
		
		Response response=  given()
					.header("Content-Type","application/json")
					.body(requestBody)
					.when()
					.get("https://marutigenuineparts.in/api/v2/city_master");
		
		  return response;
	}

}
