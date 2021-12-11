package com.rmgyantra.CRUD_Operation_With_BDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class updateProjectTest {
	
	@Test
	public void updateProject()
	{
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Chakrabarthi");
		jObj.put("projectName","Tech-Mahindra");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1604")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}
