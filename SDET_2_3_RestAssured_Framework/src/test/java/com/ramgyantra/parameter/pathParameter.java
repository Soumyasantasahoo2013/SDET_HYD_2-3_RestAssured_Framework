package com.ramgyantra.parameter;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class pathParameter {
	
	@Test
	public void pathParameterTest()
	{
		given()
		.contentType(ContentType.JSON)
		.pathParam("ProId", "TY_PROJ_1605")
		.when().get("http://localhost:8084/projects/{ProId}")
		.then()
		.log()
		.all();
	}

}
