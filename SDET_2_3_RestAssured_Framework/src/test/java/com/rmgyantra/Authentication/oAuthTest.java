package com.rmgyantra.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class oAuthTest {
	
	@Test
	public void oAuth()
	{
		Response rsps = given()
		.formParam("client_id", "soumya")
		.formParam("client_secret", "e71e200e363f63eea67014ca49ceb6a5")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://example.com")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(rsps.prettyPrint());
		String token=rsps.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", "2527")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then()
		.log()
		.all();
		
	}

}
