package api.endpoint;

import java.util.ResourceBundle;

import api.utilities.AES_Decrypt;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class SelectPartyEndpoint {
	
	//Method for getting URL's from properties file
		static ResourceBundle getData() {
			ResourceBundle bundle=ResourceBundle.getBundle("routes");   //Load the properties file
			return bundle;
			
		}
		
		public static Response validateSelectPartyStatusCode() {
			  String requestBody = "{\n" +
		                "    \"mspin\": \"979497\",\n" +
		                "    \"party_code\": \"WUP010188791\",\n" +
		                "    \"device_type\": \"Android\"\n" +
		                "}";

			  Response response1=given()
					  .header("Content-Type","application/json")
						.body(requestBody)
						.when()
						.post("https://marutigenuineparts.in/api/v2/selectParty");
			  
			  String responseString=response1.asString();
		       String cleanResponse = (responseString.toString()).replaceAll("\"", "");
			  
			  Response decryptResponse=AES_Decrypt.decrypt(cleanResponse);
			  
			  return decryptResponse;
		}
}
