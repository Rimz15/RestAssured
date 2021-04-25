package dadaDrivenTesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest {
	
	
	
	@Test(dataProvider="empDataProvider")
	public void PostNewEmployess(String eName,String eAge, String eSalary){
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpreq=RestAssured.given();
		JSONObject json = new JSONObject();
		json.put("name", eName);
		json.put("salary", eAge);
		json.put("age", eSalary);
		httpreq.header("Content-Type", "application/json");
		httpreq.body(json.toJSONString());
		Response response = httpreq.request(Method.POST,"/create");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(responseBody.contains(eName),true);
		
	}
	
	@DataProvider(name="empDataProvider")
	String[][] getEmpData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/dadaDrivenTesting/example.xlsx";
		int rownum=xlUtils.getRowCount(path, "Sheet1");
		int colcount=xlUtils.getCellCount(path, "Sheet1", 1);
		String empData[][]=new String [rownum][colcount];
		for(int i=1;i<=rownum;i++){
			for(int j=0;j<=colcount;j++){
				empData[i-1][j]=xlUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		//String empData[][]={{"abc178","28","30000"},{"abc178","26","50000"}};
		return empData;
	}

}
