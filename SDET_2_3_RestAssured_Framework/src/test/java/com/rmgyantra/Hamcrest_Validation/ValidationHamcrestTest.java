package com.rmgyantra.Hamcrest_Validation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ValidationHamcrestTest {
	
	@Test
	public void ham()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS)
		.assertThat().body("[0].projectName", Matchers.equalTo("Microsoft"))
		.log()
		.all();
	}

}
