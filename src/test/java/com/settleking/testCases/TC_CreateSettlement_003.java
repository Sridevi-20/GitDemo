package com.settleking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.settleking.pageObjects.HomePage;
import com.settleking.pageObjects.LivePokerSettlementPage;
import com.settleking.pageObjects.LoginPage;

public class TC_CreateSettlement_003 extends BaseClass {
	
	@Test
	public void CreateSettlement() throws InterruptedException{
		
		LoginPage lp =new LoginPage(driver);
		lp.setEmail(email);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.ClickSubmit();
		logger.info("clicked submit");
		HomePage hp = new HomePage(driver);
		hp.CreateSettlement();
		logger.info("clicked Create Settlement link");
		hp.LivePoker();
		logger.info("clicked Live poker link");
		Thread.sleep(2000);
		hp.EnterGameName();
		logger.info("Entered game name");
		hp.NextButton();
		Thread.sleep(2000);
		String expectedUrl = "https://dev.settleking.com/add-game";
	    String actualUrl = driver.getCurrentUrl();
	     if(actualUrl.equals(expectedUrl)){ 
			Assert.assertTrue(true);
	    	
	     }else{
		    Assert.assertTrue(false);
	     }   
	    LivePokerSettlementPage lps = new LivePokerSettlementPage(driver);
	    lps.AddFriends();
	    logger.info("clicked on Add Friends button");
	    Thread.sleep(2000);
	    lps.NameLists();
	
		
			
	

		
		
		
	}

}
