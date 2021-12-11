package com.rmgyantra.CRUD_Operation_With_BDD;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class deleteProjectTest {
	
	@Test
	public void delete()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_1604")
		.then()
		.assertThat()
		.statusCode(204)
		.and()
		.contentType(ContentType.JSON)
		.log()
		.all();
	}

}
