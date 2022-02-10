package com.settleking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.settleking.pageObjects.LoginPage;

public class TC_loginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		logger.info("Entered EmailId");
		lp.setPassword(password);
		logger.info("Entered the password");
		lp.ClickSubmit();
		if(driver.getTitle().equals("SettleKing"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
			
	}

}
