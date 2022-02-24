package com.rmgyantra.End_to_End_Scenario;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

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
import com.rmgyantra.genericUtilities.BaseAPIClass;
import com.rmgyantra.genericUtilities.DataBaseUtility;
import com.rmgyantra.genericUtilities.EndPoints;
import com.rmgyantra.genericUtilities.JSONUtility;
import com.rmgyantra.genericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndScenarioTest extends BaseAPIClass implements EndPoints{
	
	@Test
	public void endToEndScenario() throws Throwable
	
	{
		JavaUtility jUtil=new JavaUtility();
		
		pojoLibrary pl=new pojoLibrary("SSS", "TechM"+jUtil.generateRandomNumber(), "Created", 7);
		
		baseURI="http://localhost";
		port=8084;
		
		Response rsps = given()
		.contentType(ContentType.JSON)
		.body(pl)
		.when()
		.post(EndPoints.createProj);
		
	    JSONUtility jsUtil=new JSONUtility();
	    String projectid = jsUtil.jsonPathFinder("projectId", rsps);
	    
	    Response rsps1 = given()
	    .pathParam("ProId", projectid)
	    .when()
	    .get("http://localhost:8084/projects/{ProId}");
	    
        String projectName = jsUtil.jsonPathFinder("projectName", rsps1);
	    
	    //JDBC code for verifying in Database
	    ResultSet result=dUtil.executingQuery("select * from project");
	    while(result.next())
	    {
	    	if(result.getString(4).equals(projectName))
	    	{
	    		System.out.println(projectName+" is matching");
	    	}
	    }
	}

}
