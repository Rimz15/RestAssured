import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_REQUETST {
	@Test
	void getValuefromAllNodes(){
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification httpreq=RestAssured.given();
		Response response = httpreq.request(Method.GET);
		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("class"));//it will give u the value for the given key
	}

}
