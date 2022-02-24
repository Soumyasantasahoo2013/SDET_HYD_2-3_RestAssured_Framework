package com.rmgyantra.genericUtilities;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {
	
	public DataBaseUtility dUtil=new DataBaseUtility();
	
	@BeforeSuite
	public void createConnection()
	{
		dUtil.connectToDatabase();
	}
	
	@AfterSuite
	public void closeConn() throws SQLException
	{
		dUtil.closeConnection();
	}

}
