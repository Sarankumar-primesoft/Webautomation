package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Profilepage extends BaseClass{
	
	@FindBy(xpath="//a[@role='button']//a[@href='/profile?tab=info']")	
	public WebElement myprofile;
	
	@FindBy(xpath="//div[@class='top-profile-right']/h6")
	public WebElement profilename;
	
	@FindBy(xpath="//label[text()='Email']/..//div[@class='showPassword']/input")	
	public WebElement profileemail;
	
	@FindBy(xpath="//label[text()='Phone Number']/..//div[@class='showPassword']/input")
	public WebElement profilemobile;
	
	@FindBy(xpath = "//label[text()='DOB']/..//div[@class='showPassword']/input")
	public WebElement profiledob;
	
	@FindBy(xpath ="//label[text()='Gender']/..//div[@class='showPassword']/input" )
	public  WebElement profilegender;

	@FindBy(xpath = "//span[@class='planName']") 
	public WebElement substatus;
	
	@FindBy(xpath = "//div[@class='offcanvas-body']//a[text()='Subscribe'][@role='button']")
	public WebElement subscribebtn;
		
//	profile edit locators
	@FindBy(xpath = "//a[contains(text(),'Edit Profile')]")
	public static 	WebElement editbtn;
			
	@FindBy(xpath="//button[text()='Submit']")
	public static WebElement submitbtn;
	
	@FindBy(xpath = "//input[@name='birthdate']")
	public static WebElement editdob;
	
	@FindBy(xpath = " //select[@name='gender']")
	public static WebElement editgender;
	
	@FindBy(xpath = "//div[@role='alert']/div[2]")
	public static WebElement successmsg;

	public Profilepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//profile page action methods
		
	public String actualprofilename()
	{
		return prop.getProperty("ac-profile-Name");
}

	public String actualemail()
	{
		return prop.getProperty("ac-profile-email");
	}
	public String actualmobile()
	{
		return prop.getProperty("ac-profile-ph");
	}
	public String actualdob()
	{
		return prop.getProperty("ac-profile-dob");
	}

	public String actualgender() {
			return prop.getProperty("ac-profile-gender");
	}
	public String actualsubstatus() {
		return prop.getProperty("sub-status");
	}

}
