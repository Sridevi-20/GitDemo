package com.settleking.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver ldriver;
	 
	public HomePage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//span[text()='Create Settlement']")
	WebElement createsettlement;
	
	@FindBy(xpath="//span[normalize-space()='Live Poker (In person)']")
	WebElement livepoker;
	
	@FindBy(xpath="//input[@placeholder='Enter Game Name. For ex: Thursday night poker game - 11/03/2021']")
	WebElement entergamename;
	
	@FindBy(xpath="//button[normalize-space()='Next']")
	WebElement nextbutton;
	
	
	

	
	public void CreateSettlement()
	{
		createsettlement.click();
		
	}
	
	public void LivePoker(){
		livepoker.click();
	}
	
	public void EnterGameName(){
		entergamename.sendKeys("Friday Poker Game");
	}
	public void NextButton(){
		nextbutton.click();
	}
	
	
	
}
