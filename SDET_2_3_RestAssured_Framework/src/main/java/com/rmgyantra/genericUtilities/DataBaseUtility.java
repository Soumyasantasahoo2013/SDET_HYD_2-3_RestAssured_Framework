package com.rmgyantra.genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	public Connection con=null;
	public ResultSet result;
	
	/**
	 * This method to Connect to Database
	 */
	
	public void connectToDatabase()
	{
		try {
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method to close the connection
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException
	{
		con.close();
	}
	
	
	/**
	 * This method to execute query and return the result
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executingQuery(String query) throws Throwable
	{
		result = con.createStatement().executeQuery(query);
		return result;
	}

}
