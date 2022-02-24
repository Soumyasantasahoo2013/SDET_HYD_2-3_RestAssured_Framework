package com.rmgyantra.genericUtilities;

import java.util.Random;

public class JavaUtility {
	
	public int generateRandomNumber()
	{
		Random r=new Random();
		int randomNumber = r.nextInt(2000);
		return randomNumber;
	}

}
