import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {

	@Test
	void getWeatherDetails(){
		//specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		//Response object
		Response response=httprequest.request(Method.GET,"/Hyderabad");
		//print response in console window
		String responsebody=response.getBody().asString();
		System.out.println(responsebody);
	
	//status code validation
	int statscode=response.getStatusCode();
	System.out.println(statscode);
	Assert.assertEquals(statscode, 200);
	//status line verification
	String statusline=response.getStatusLine();
	System.out.println(statusline);
	Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}

	}


