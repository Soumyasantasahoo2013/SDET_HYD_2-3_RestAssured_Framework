package com.rmgyantra.Different_ways_to_Post;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class createProjectUsingJSONFileTest {
	
	@Test
	public void createTest()
	{
		File file = new File("./Data.json");
		
		given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
