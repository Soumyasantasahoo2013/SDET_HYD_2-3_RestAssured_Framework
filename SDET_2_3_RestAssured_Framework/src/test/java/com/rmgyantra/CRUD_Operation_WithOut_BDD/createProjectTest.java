package com.rmgyantra.CRUD_Operation_WithOut_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class createProjectTest {
	
	@Test
	public void create()
	{
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Chakrabarthi");
		jObj.put("projectName","TYSS-56");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 10);
		
		RequestSpecification reqSpe = RestAssured.given();
		reqSpe.contentType(ContentType.JSON);
		reqSpe.body(jObj);
		
		Response rsps = reqSpe.post("http://localhost:8084/addProject");
		ValidatableResponse vResponse = rsps.then();
		vResponse.assertThat().statusCode(201);
		vResponse.log().all();
	}

}
