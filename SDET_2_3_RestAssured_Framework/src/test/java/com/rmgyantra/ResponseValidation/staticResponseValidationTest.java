package com.rmgyantra.ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class staticResponseValidationTest {
	
	@Test
	public void staticResponse()
	{
		String expData="Microsoft";
		Response rsps = when().get("http://localhost:8084/projects");
		
		rsps.then().assertThat().statusCode(200);
		
		String actData = rsps.jsonPath().get("[0].projectName");
		System.out.println(actData);
		Assert.assertEquals(actData, expData);
	}

}
