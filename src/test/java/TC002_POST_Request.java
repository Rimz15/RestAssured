import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	@Test
	void RegistrationSuccessful(){
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RequestSpecification httpReq = RestAssured.given();
		//Request Payload
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "JohnXYZ");
		requestParams.put("LastName", "JohnXY");
		requestParams.put("UserName", "JohnX");
		requestParams.put("Password", "Joh");
		requestParams.put("Email", "JohnX.12@gmail.com");
		
		httpReq.header("Content-Type","application/json");
		httpReq.body(requestParams.toJSONString());
		Response response = httpReq.request(Method.POST,"/register");
		String responseBody = response.getBody().asString();
		String successcode=response.jsonPath().get("SuccessCode");
		int status = response.getStatusCode();
		String statusLine = response.getStatusLine();
	}

}
