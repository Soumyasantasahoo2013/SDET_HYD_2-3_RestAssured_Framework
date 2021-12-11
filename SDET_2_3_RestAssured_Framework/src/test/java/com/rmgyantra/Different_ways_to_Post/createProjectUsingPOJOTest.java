package com.rmgyantra.Different_ways_to_Post;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.ProjectLibrary.pojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.util.Random;

public class createProjectUsingPOJOTest {
	
	@Test(dataProvider = "provideData")
	public void createProject(String createdBy,String projectName,String status, int teamSize)
	{
		Random r = new Random();
		int randomNumber = r.nextInt(2000);
		
		pojoLibrary pl=new pojoLibrary(createdBy, projectName+randomNumber,status, teamSize);
		
		given()
		.contentType(ContentType.JSON)
		.body(pl)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}
	
	@DataProvider
    public Object[][] provideData()
    {
		Object[][] objectArr=new Object[2][4];

		
		objectArr[0][0]="JogaRao";
		objectArr[0][1]="SDET";
		objectArr[0][2]="Completed";
		objectArr[0][3]=15;
		
		objectArr[1][0]="JogaRao2121";
		objectArr[1][1]="SDET-3";
		objectArr[1][2]="Completed";
		objectArr[1][3]=15;
		
		return objectArr;
    }
}
