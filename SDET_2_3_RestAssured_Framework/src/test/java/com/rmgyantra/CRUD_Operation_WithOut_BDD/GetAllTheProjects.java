package com.rmgyantra.CRUD_Operation_WithOut_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllTheProjects {
	
	@Test
	public void getAllProjectsTest()
	{
		Response rsps = RestAssured.get("http://localhost:8084/projects");
		//System.out.println(rsps.asString());
     	//System.out.println(rsps.prettyPrint());
        //System.out.println(rsps.getContentType());
        //System.out.println(rsps.getStatusCode());
		
		ValidatableResponse vResponse = rsps.then();
		vResponse.assertThat().statusCode(200);
		vResponse.assertThat().contentType("application/json");
		vResponse.log().all();
	}

}
