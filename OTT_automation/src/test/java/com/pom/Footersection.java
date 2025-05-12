package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Footersection extends BaseClass{

	public Footersection(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[.='About Us']")
	public WebElement  Aboutus;
	
	@FindBy(xpath = "(//span[contains(.,'About Us')])[2]")
	public WebElement  Aboutusheader;
	
	@FindBy(xpath = "//a[.='Contact Us']")
	public WebElement  contactus;
	
	@FindBy(xpath = "//h4[contains(.,'Contact Us')]")
	public WebElement  contactusheader;
		
	@FindBy(xpath = "//a[.='Redeem']")
	public WebElement Redeem ;
	
	@FindBy(xpath = "//h3[contains(.,'Redeem')]")
	public WebElement Redeemheader ;
	
	@FindBy(xpath = "//a[contains(.,'Privacy Policy')]")
	public WebElement privacy ;
	
	@FindBy(xpath = "//h4[contains(.,'Privacy Policy')]")
	public WebElement privacyheader;
	
	@FindBy(xpath = "//a[contains(.,'Terms')]")
	public WebElement Terms ;
	
	@FindBy(xpath = "//span[contains(.,'Terms')]")
	public WebElement Termsheader ;
	
	@FindBy(xpath = "//a[contains(.,'FAQ')]")
	public WebElement FAQ ;
	
	@FindBy(xpath = "//h1[contains(.,'Frequently')]")
	public WebElement FAQheader ;
	
	@FindBy(xpath = "//a[contains(.,'Feedback')]")
	public WebElement Feedback ;
	
	@FindBy(xpath = "//h4[contains(.,'Feedback ')]")
	public WebElement Feedbackheader ;
	
	@FindBy(xpath = "//a[.='Subscription']")
	public WebElement Subscription ;
	
	@FindBy(xpath = "//a[.='Subscription']")
	public WebElement Subscriptionheader ;
	
	public void backandwait() {

		driver.navigate().back();
		implicitWait(10);
//		.until(ExpectedConditions.visibilityOfElementLocated(By.id("yourElementId")));
	}
	
	
}
