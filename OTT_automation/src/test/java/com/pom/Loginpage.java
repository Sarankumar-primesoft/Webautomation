package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ExtentReport.ExtentReport;
import com.ExtentReport.Extentlogger;

import base.BaseClass;

public class Loginpage extends BaseClass{
	@FindBy(xpath = "//a[text()='Home']")
	public WebElement  home; 
	
	@FindBy(xpath="//li[text()='Login']")
	public WebElement login_btn;

	@FindBy(xpath="//button[text()='Email']")
	public WebElement email_btn;

	@FindBy(xpath="//input[@name='user_id']")
	public WebElement username;

	@FindBy(xpath="//input[@name='password']")
	public WebElement password;

	@FindBy(xpath="//button[.='Next']")
	public WebElement next_btn;
	
	@FindBy(xpath="//div[@role='alert']/div[2]")
	public WebElement login_alert;

	@FindBy(xpath="(//div[@class='profile-img-class']/img)[2]")
	public WebElement profile_img;
	
	@FindBy(xpath="(//div[@class='profile-card '])[1]")
	public WebElement profileselect;
	
	@FindBy(xpath="//a[@id='nav-dropdown']")
	public  WebElement profilenav;
	
	@FindBy(xpath="//a[@id='nav-dropdown']")
	public  WebElement profilenav1;
	

	@FindBy(xpath="//div[contains(text(),'Logout')]")
	public WebElement logout;
	
	@FindBy(xpath="(//div[contains(text(),'Logout')]/..)[2]")
	public WebElement logoutall;
	

	@FindBy(xpath = "//a[contains(.,'logout all')]")
	WebElement confirmlogoutall;
	
	@FindBy(xpath="//a[text()='logout']")
	public WebElement confirmlogout;

	@FindBy(xpath="//div[@role='alert']/div[2]")
	public WebElement logout_alert;

	public Loginpage(WebDriver driver)
	{
		if (driver == null) {
            System.out.println("ERROR: WebDriver is NULL!");
        }
		
		PageFactory.initElements(driver, this);
		
        System.out.println("WebElements Initialized in Loginpage objects");

	}

	public void login_case() throws InterruptedException
	{
		ExtentReport.createTest("Login");
		Extentlogger.info("Starting login test");
		clickelement(login_btn);
		clickelement(email_btn);
		sendkeys(username, prop.getProperty("username"));
		sendkeys(password, prop.getProperty("password"));
		clickelement(next_btn);
		Thread.sleep(5000);
		String Loginstatus= login_alert.getText();
		System.out.println(Loginstatus);
		if (Loginstatus.equalsIgnoreCase(prop.getProperty("loginsuccessmsg"))) {
			System.out.println("Validating login alert");
			Extentlogger.pass("Logged in Sucessfully",true);
		}
		else {
			Extentlogger.fail("Login Failed", true);
		}
		Thread.sleep(5000);
		System.out.println(profile_img.getAttribute("src"));
		visibleofele(driver, profile_img,"Profile img");
		clickelementwithname(profileselect,"Profileselect");
	}
	public void logout() throws Exception 	
	{
		ExtentReport.createTest("Logout");
		Extentlogger.info("Going to Loguout.");
		if( JSClick(driver, profilenav,"Profile navigation"))
			Extentlogger.info("Navigated to profile.");
	
		if(JSClick(driver, logout,"Log out"))
			Extentlogger.info("Logout button clicked.");
		if(JSClick(driver, confirmlogout,"Confirm logout"))
			Extentlogger.info("Confirm logout.");
		Thread.sleep(5000);
		String logoutalert = logout_alert.getText();
		
		assertEquals(logoutalert,prop.getProperty("logoutalert"),"Logout Alert");
		invisibilityofelement(driver,logout_alert,"logout alert");
		}

	public void home() {
		clickelementwithname(home,"Homebtn");
	}
}
