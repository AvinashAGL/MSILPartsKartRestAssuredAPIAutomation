package api.endpoint;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

public class enquiryHistoeyEndpoint {
	
	public static ResourceBundle getUrl() {
		ResourceBundle bundle=ResourceBundle.getBundle("routes");   //Load the properties file
		return bundle;
		
	}

	public static Response validateResponseCode() {
		
		 String requestBody = "{\n" +
	                "    \"p_party_cd\": \"WUP0109475\",\n" +
	                "    \"p_parent\": \"BEEKD\",\n" +
	                "    \"p_dealer_map_cd\": \"11495\",\n" +
	                "    \"p_loc\": \"LUO\",\n" +
	                "    \"p_start_date\": \"2024-06-01\",\n" +
	                "    \"p_end_Date\": \"2024-07-05\",\n" +
	                "    \"p_flag\": \"E\",\n" +
	                "    \"p_mspin\": \"\",\n" +
	                "    \"p_enq_status\": \"\"\n" +
	                "}";
		
	Response response=	given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(requestBody)
		.when()
		.post(getUrl().getString("EnquiryHistory"));
		return response;
	}
	
	public static Response validateErrorwithInvalidPartyCode() {
		
		 String requestBody = "{\n" +
	                "    \"p_party_cd\": \"ASWE1212\",\n" +
	                "    \"p_parent\": \"BEEKD\",\n" +
	                "    \"p_dealer_map_cd\": \"11495\",\n" +
	                "    \"p_loc\": \"LUO\",\n" +
	                "    \"p_start_date\": \"2024-06-01\",\n" +
	                "    \"p_end_Date\": \"2024-07-05\",\n" +
	                "    \"p_flag\": \"E\",\n" +
	                "    \"p_mspin\": \"\",\n" +
	                "    \"p_enq_status\": \"\"\n" +
	                "}";
		
	Response response=	given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(requestBody)
		.when()
		.post(getUrl().getString("EnquiryHistory"));
		return response;
		
	}
	
	public static Response validateErrorwithInvalidParentCode() {
		
		 String requestBody = "{\n" +
	                "    \"p_party_cd\": \"WUP0109475\",\n" +
	                "    \"p_parent\": \"ASAAA\",\n" +
	                "    \"p_dealer_map_cd\": \"11495\",\n" +
	                "    \"p_loc\": \"LUO\",\n" +
	                "    \"p_start_date\": \"2024-06-01\",\n" +
	                "    \"p_end_Date\": \"2024-07-05\",\n" +
	                "    \"p_flag\": \"E\",\n" +
	                "    \"p_mspin\": \"\",\n" +
	                "    \"p_enq_status\": \"\"\n" +
	                "}";
		
	Response response=	given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(requestBody)
		.when()
		.post(getUrl().getString("EnquiryHistory"));
		return response;
		
	}
	
	public static Response validateErrorwithInvalidDealerCode() {
		
		 String requestBody = "{\n" +
	                "    \"p_party_cd\": \"WUP0109475\",\n" +
	                "    \"p_parent\": \"BEEKD\",\n" +
	                "    \"p_dealer_map_cd\": \"12121\",\n" +
	                "    \"p_loc\": \"LUO\",\n" +
	                "    \"p_start_date\": \"2024-06-01\",\n" +
	                "    \"p_end_Date\": \"2024-07-05\",\n" +
	                "    \"p_flag\": \"E\",\n" +
	                "    \"p_mspin\": \"\",\n" +
	                "    \"p_enq_status\": \"\"\n" +
	                "}";
		
	Response response=	given()
		.header("x-api-key",getUrl().getString("x_api_key"))
		.header("User-Agent",getUrl().getString("user_agent"))
		.header("Content-Type",getUrl().getString("content_Type"))
		.body(requestBody)
		.when()
		.post(getUrl().getString("EnquiryHistory"));
		return response;
		
	}
	
	
}
