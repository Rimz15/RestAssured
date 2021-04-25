import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_REQUEST {
	@Test
	public void validateHeaders(){
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification httpreq=RestAssured.given();
		Response response=httpreq.request(Method.GET);
		String Requestbody = response.getBody().asString();
		System.out.println(Requestbody);
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		//capture details of headers from response
		String contentType=response.header("Content-Type");
		System.out.println("Type is" + contentType);
		String encoding=response.header("Content-Encoding");
		System.out.println(encoding);
	}

}
