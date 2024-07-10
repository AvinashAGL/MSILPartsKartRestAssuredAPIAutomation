package api.endpoint;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.utilities.AES_Decrypt;

public class LoginWithMobNoEndpint {

	static ResourceBundle getData() {
		ResourceBundle bundle=ResourceBundle.getBundle("routes");   //Load the properties file
		return bundle;
	}
	
	public static Response loginWithMobNo_withValidData_RespondeCode() {
		
		 String requestBody = "{\n" +
	                "  \"device_type\": \"Android\",\n" +
	                "  \"mobile\": \"9911477739\"\n" +
	                "}";
		 Response response1 = given()
				 	.header("Content-Type","application/json")
				 	.header("device_id","otp")
	                .body(requestBody)
	                .when()
	                .post("https://marutigenuineparts.in/api/v2/login");
		 
		 String responseString=response1.asString();
	        String cleanResponse = (responseString.toString()).replaceAll("\"", "");
	        System.out.println("Clear Res" +cleanResponse);
	        Response decryptResponse=  AES_Decrypt.decrypt(cleanResponse);
	        
		return decryptResponse;
	}
	
	public static Response loginWithMobNo_withValidData_RespondeCode2() {
		
		 String requestBody = "{\n" +
	                "  \"device_type\": \"Android\",\n" +
	                "  \"mobile\": \"9911477739\"\n" +
	                "}";
		 Response response1 = given()
				 	.header("Content-Type","application/json")
				 	.header("device_id","otp")
	                .body(requestBody)
	                .when()
	                .post("https://marutigenuineparts.in/api/v2/login");
		 
		
		return response1;
	}

	public static Response loginWithInvalidMobNoRespondeCode() {
		
		 String requestBody = "{\n" +
	                "  \"device_type\": \"Android\",\n" +
	                "  \"mobile\": \"9898981234\"\n" +
	                "}";
		 Response response1 = given()
				 	.header("Content-Type","application/json")
				 	.header("device_id","otp")
	                .body(requestBody)
	                .when()
	                .post("https://marutigenuineparts.in/api/v2/login");
		 
		 String responseString=response1.asString();
	        String cleanResponse = (responseString.toString()).replaceAll("\"", "");
	        System.out.println("Clear Res" +cleanResponse);
	        Response decryptResponse=  AES_Decrypt.decrypt(cleanResponse);
	        
		return decryptResponse;
	}
	
	public static Response loginWith_MSPIN_RespondeCode() {
		
		 String requestBody = "{\n" +
	                "  \"device_type\": \"Android\",\n" +
	                "  \"mspin\": \"979497\"\n" +
	                "}";
		 Response response1 = given()
				 	.header("Content-Type","application/json")
				 	.header("device_id","otp")
	                .body(requestBody)
	                .when()
	                .post("https://marutigenuineparts.in/api/v2/login");
		 
		 String responseString=response1.asString();
	        String cleanResponse = (responseString.toString()).replaceAll("\"", "");
	        System.out.println("Clear Res" +cleanResponse);
	        Response decryptResponse=  AES_Decrypt.decrypt(cleanResponse);
	        
		return decryptResponse;
	}
	
	public static Response loginWith_MSPIN_RespondeCode2() {
		
		 String requestBody = "{\n" +
	                "  \"device_type\": \"Android\",\n" +
	                "  \"mspin\": \"979497\"\n" +
	                "}";
		 Response response1 = given()
				 	.header("Content-Type","application/json")
				 	.header("device_id","otp")
	                .body(requestBody)
	                .when()
	                .post("https://marutigenuineparts.in/api/v2/login");
		 
	        
		return response1;
	}
	
	public static Response loginWithInvalidMSPIN() {
		
		 String requestBody = "{\n" +
	                "  \"device_type\": \"Android\",\n" +
	                "  \"mspin\": \"121211\"\n" +
	                "}";
		 Response response1 = given()
				 	.header("Content-Type","application/json")
				 	.header("device_id","otp")
	                .body(requestBody)
	                .when()
	                .post("https://marutigenuineparts.in/api/v2/login");
		 
		 String responseString=response1.asString();
	        String cleanResponse = (responseString.toString()).replaceAll("\"", "");
	        System.out.println(cleanResponse);
	        Response decryptResponse=  AES_Decrypt.decrypt(cleanResponse);
	        
		return decryptResponse;
	}

}
