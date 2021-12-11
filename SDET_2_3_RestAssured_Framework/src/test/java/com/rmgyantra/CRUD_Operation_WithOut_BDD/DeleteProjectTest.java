package com.rmgyantra.CRUD_Operation_WithOut_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest {
	
	@Test
	public void deleteProjectTest()
	{
		Response rsps = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1603");
	    ValidatableResponse vResponse = rsps.then();
	    vResponse.assertThat().statusCode(204);
	}

}
