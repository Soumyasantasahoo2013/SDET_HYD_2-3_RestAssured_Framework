package com.rmgyantra.genericUtilities;

import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility {
	
	@Test
	public int generateRandomNumber()
	{
		Random r=new Random();
		int randomNumber = r.nextInt(2000);
		return randomNumber;
	}

}
