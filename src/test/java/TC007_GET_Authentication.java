import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_Authentication {
	@Test
	void AuthroziationTest(){
		RestAssured.baseURI="http://restapi.demoqa..com/authentication/checkForAuthentication";
		//Basic authentication
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		RestAssured.authentication=authscheme;
		RequestSpecification httpreq= RestAssured.given();
		Response response = httpreq.request(Method.GET,"/");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
	}

}
