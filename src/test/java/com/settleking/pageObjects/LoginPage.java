package com.settleking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		ldriver =rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(css="input[placeholder='Email']")
	WebElement email;
	
	@FindBy(css="input[placeholder='Password']")
	WebElement password;
	
	@FindBy(css="button[type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//span[@class='logged-user ng-tns-c85-1']")
	WebElement emailname;
	@FindBy(xpath="//a[@id='logout_view']")
	WebElement logout;


	public void setEmail(String emailId){
		
		email.sendKeys(emailId);
		//email.clear();
	}
   public void setPassword(String pwsd){
		
		password.sendKeys(pwsd);
		//password.clear();
	}
   public void ClickSubmit(){
		
		submit.click();
	}
   public void ClickEmailName(){
		
		emailname.click();
	}
   public void ClickLogout(){
		
		logout.click();
	}
   public void errorMessage(){
		 String loginstatus = new WebDriverWait(ldriver, 30).until(ExpectedConditions.elementToBeClickable(By.id("toast-container"))).getText();
		 if (loginstatus.contains("Email address already in use.")) {
		        System.out.println("Login Failed: " + loginstatus);
		        System.out.println("Already have an account");
		        submit.click();
		        
		    } else {
		        System.out.println("Login Success:" + loginstatus);
		    }
	  	}
}
