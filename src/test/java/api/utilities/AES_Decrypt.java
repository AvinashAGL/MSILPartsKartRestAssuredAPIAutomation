package api.utilities;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;

//import java.io.FileNotFoundException;
//import java.util.ResourceBundle;

import io.restassured.response.Response;

public class AES_Decrypt {
	
	static ResourceBundle getUrl() {
		ResourceBundle bundle=ResourceBundle.getBundle("routes");   //Load the properties file
		return bundle;
	}
	
	public static Response decrypt(String Key) {
		
		String requestBody = "{\n" +
                "    \"bodyparams\": \"" + Key + "\"\n" +
//                "    \"bodyparams\": \"O/KHRhPQtA1wEku8FeMzcOTvBbKEpfLbkk/Py2LPTi4HG2JSz7ZcfEgUNWvnCdYg\"\n" +

                "}";
		Response decryptResponse=given()
			.contentType(ContentType.JSON)
			.body(requestBody)
			.when()
//			.post(getUrl().getString("decryptProd"));
			.post("https://marutigenuineparts.in/api/v2/decrypt");
//		System.out.println(decryptResponse.then().log().all());
		return decryptResponse;
		
	}

}

