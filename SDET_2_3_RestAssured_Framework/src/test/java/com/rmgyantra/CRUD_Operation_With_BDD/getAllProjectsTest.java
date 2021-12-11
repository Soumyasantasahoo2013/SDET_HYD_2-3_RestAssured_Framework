package com.rmgyantra.CRUD_Operation_With_BDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class getAllProjectsTest {
	
	@Test
	public void getProjects()
	{
		//Selenium Script
		//RestAssured
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.log()
		.all();
		
		//JDBC
	}

}
