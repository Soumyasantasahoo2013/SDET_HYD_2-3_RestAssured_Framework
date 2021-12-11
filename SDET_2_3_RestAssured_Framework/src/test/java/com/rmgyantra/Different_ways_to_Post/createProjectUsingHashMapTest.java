package com.rmgyantra.Different_ways_to_Post;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class createProjectUsingHashMapTest {
	
	@Test
	public void createUsingHashMap()
	{
		HashMap hp=new HashMap();
		hp.put("createdBy", "Chakrabarthi");
		hp.put("projectName","Trefe");
		hp.put("status", "On Going");
		hp.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log()
		.all();
	}

}
