package com.rmgyantra.genericUtilities;

import io.restassured.response.Response;

public class JSONUtility {
	
	public String jsonPathFinder(String jsonPath, Response rsps)
	{
	   String text = rsps.jsonPath().get(jsonPath);
	   return text;
	}

}
