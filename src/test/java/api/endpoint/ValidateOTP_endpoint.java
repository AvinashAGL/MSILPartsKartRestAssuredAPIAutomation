package api.endpoint;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.utilities.AES_Decrypt;
import io.restassured.response.Response;

public class ValidateOTP_endpoint {
	
	//Method for getting URL's from properties file
	static ResourceBundle getData() {
		ResourceBundle bundle=ResourceBundle.getBundle("routes");   //Load the properties file
		return bundle;
		
	}
	
	
	public static Response validateOTP_validMob_validOTP() {
		
		 String requestBody = "{\n" +
                "    \"mobile\": \"9911477739\",\n" +
                "    \"otp\": \"1234\"\n" +
                "}";
		
		Response response1=
				given()
				.header("Content-Type","application/json")
				.body(requestBody)
				.when()
				.post("https://marutigenuineparts.in/api/v2/validateOTP");
		
		String responseString=response1.asString();
       String cleanResponse = (responseString.toString()).replaceAll("\"", "");
//       System.out.println(cleanResponse);
       Response decryptResponse=  AES_Decrypt.decrypt(cleanResponse);
		
		return decryptResponse;
		
	}
	
	public static Response validateOTP_validMob_invalidOTP() {
		
		 String requestBody = "{\n" +
               "    \"mobile\": \"9911477739\",\n" +
               "    \"otp\": \"1233\"\n" +
               "}";
		
		Response response1=
				given()
				.header("Content-Type","application/json")
				.body(requestBody)
				.when()
				.post("https://marutigenuineparts.in/api/v2/validateOTP");
		
		String responseString=response1.asString();
      String cleanResponse = (responseString.toString()).replaceAll("\"", "");
//      System.out.println(cleanResponse);
      Response decryptResponse=  AES_Decrypt.decrypt(cleanResponse);
		
		return decryptResponse;
		
	}
	
	public static Response validateOTP_validMSPIN_validOTP() {
		
		 String requestBody = "{\n" +
                 "    \"mspin\": \"979497\",\n" +
                 "    \"otp\": \"1234\"\n" +
                 "}";
		
		Response response1=
				given()
				.header("Content-Type","application/json")
				.body(requestBody)
				.when()
				.post("https://marutigenuineparts.in/api/v2/validateOTP");
		
		String responseString=response1.asString();
        String cleanResponse = (responseString.toString()).replaceAll("\"", "");
//        System.out.println(cleanResponse);
        Response decryptResponse=  AES_Decrypt.decrypt(cleanResponse);
		
		return decryptResponse;
		
	}

}
