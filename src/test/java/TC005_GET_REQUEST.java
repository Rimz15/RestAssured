import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_REQUEST {

	@Test
	void vaidateJsonBody(){
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpreq = RestAssured.given();
		Response response=httpreq.request(Method.GET);
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(responseBody.contains("Delhi"), true);
	}
}
