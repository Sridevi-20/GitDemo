package com.settleking.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.settleking.pageObjects.LoginPage;
import com.settleking.utilities.XLUtils;


public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pswd) throws InterruptedException
	{ 
		
		LoginPage loginpage = new LoginPage(driver);
		String atualUrl2 =driver.getCurrentUrl();
		String ecpectedUrl2="https://dev.settleking.com/auth/login";
		if(atualUrl2.equals(ecpectedUrl2)){
			logger.info("User is on the Login Page");
			Thread.sleep(2000);
		}
		
		loginpage.setEmail(user);
        logger.info("user name provided");
        loginpage.setPassword(pswd);
        logger.info("password provided");
	    loginpage.ClickSubmit();
	    logger.info("clicked submit");
	    Thread.sleep(2000);
        String expectedUrl = "https://dev.settleking.com/feed";
	    String actualUrl = driver.getCurrentUrl();
	     if(actualUrl.equals(expectedUrl)){ 
			logger.info("Login passed");
			Thread.sleep(5000);
			loginpage.ClickEmailName();
			loginpage.ClickLogout();
	    	
	     }else{
		    logger.info("Login failed");
		    Thread.sleep(3000);
		    logger.info("Invalid Credentials");
		    loginpage.errorMessage();
	     }           
	     
	}					
				
		@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{ 
		String path=System.getProperty("user.dir")+"/src/test/java/com/settleking/testData/TestData.xlsx";
		
		int rownum =XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				}
					
		}
		return logindata;
	}
}	