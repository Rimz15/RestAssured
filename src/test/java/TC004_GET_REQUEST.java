import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_REQUEST {
	
	@Test
	void getAllHeaders(){
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification httpreq=RestAssured.given();
		Response response = httpreq.request(Method.GET);
		Headers headers=response.headers();
		for(Header header:headers){
			System.out.println(header.getName()+" "+header.getValue());
		}
		
		
	}

}
