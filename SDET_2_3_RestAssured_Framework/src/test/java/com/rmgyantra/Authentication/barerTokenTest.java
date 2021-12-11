package com.rmgyantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class barerTokenTest {
	
	@Test
	public void barerToken()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.log()
		.all();
	}

}
