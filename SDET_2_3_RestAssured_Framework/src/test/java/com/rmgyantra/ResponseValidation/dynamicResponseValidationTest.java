package com.rmgyantra.ResponseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class dynamicResponseValidationTest {
	
	@Test
	public void dynamicResponse()
	{
		String expData="Microsoft";
		Response rsps = when().get("http://localhost:8084/projects");
		
		rsps.then().assertThat().statusCode(200);
		
		List<String> listData = rsps.jsonPath().get("projectName");
		for(String actData:listData)
		{
			if(actData.equals(expData))
			{
				System.out.println(actData+" is present");
				break;
			}
		}
		
	}

}
