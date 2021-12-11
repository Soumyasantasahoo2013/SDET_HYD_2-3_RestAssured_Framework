package com.rmgyantra.End_to_End_Scenario;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.rmgyantra.ProjectLibrary.pojoLibrary;
import com.rmgyantra.genericUtilities.DataBaseUtility;
import com.rmgyantra.genericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndScenarioTest extends DataBaseUtility {
	
	@Test
	public void endToEndScenario() throws Throwable
	
	{
		JavaUtility jUtil=new JavaUtility();
		
		pojoLibrary pl=new pojoLibrary("SSS", "TechM"+jUtil.generateRandomNumber(), "Created", 7);
		
		Response rsps = given()
		.contentType(ContentType.JSON)
		.body(pl)
		.when()
		.post("http://localhost:8084/addProject");
		
	    String projectid = rsps.jsonPath().get("projectId");
	    System.out.println(projectid);
	    
	    Response rsps1 = given()
	    .pathParam("ProId", projectid)
	    .when()
	    .get("http://localhost:8084/projects/{ProId}");
	    
	    String projectName=rsps1.jsonPath().get("projectName");
	    System.out.println(projectName);
	    
	    //JDBC code for verifying in Database
	    DataBaseUtility dUtil=new DataBaseUtility();
	    dUtil.connectToDatabase();
	    
	    result=dUtil.executingQuery("select * from project");
	    while(result.next())
	    {
	    	if(result.getString(4).equals(projectName))
	    	{
	    		System.out.println(projectName+" is matching");
	    	}
	    }
	    dUtil.closeConnection();
	    
	}

}
