package com.settleking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LivePokerSettlementPage {
	WebDriver ldriver;
	 
	public LivePokerSettlementPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-add-friend']")
	 WebElement addfriends;
	@FindBy(xpath="//div[@class='cdk-overlay-container']//li")
	WebElement namelists;
	
	public void AddFriends(){
		addfriends.click();
	}
	
	public void NameLists(){
		System.out.println("List size:"+namelists.getSize());
		
			
	}
	
	

}
