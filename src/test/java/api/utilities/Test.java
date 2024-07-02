package api.utilities;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class Test {
	
	
@org.testng.annotations.Test()
	public void validateLoginWithNoResponseCodeWithValidMobNo() {
		
		 String requestBody = "{\n" +
	                "  \"device_type\": \"Android\",\n" +
	                "  \"mobile\": \"9911477739\"\n" +
	                "}";
		 Response response1 = given()
				 	.header("Content-Type","application/json")
				 	.header("device_id","otp")
	                .body(requestBody)
	                .when()
//	                .post(getData().getString("logInParty"));
	                .post("https://marutigenuineparts.in/api/v2/login");
		 
		 String responseString=response1.asString();
		 System.out.println(responseString);
	}

}
