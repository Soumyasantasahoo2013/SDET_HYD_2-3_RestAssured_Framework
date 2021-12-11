package com.rmgyantra.Different_ways_to_Post;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class createProjectUsingJSONObjectTest {
	
	@Test
	public void create()
	{
		Random r = new Random();
		int randomNumber = r.nextInt(2000);
		
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Chakrabarthi");
		jObj.put("projectName","TYSS-5689"+randomNumber+"");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
