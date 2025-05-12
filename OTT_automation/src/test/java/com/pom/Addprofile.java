package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Addprofile extends BaseClass{

	public Addprofile(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//a[@id='nav-dropdown']")
	public  WebElement profilenav;
	
	@FindBy(xpath = "(//a[@id='nav-dropdown']/../div/a)[2]")
	public WebElement manageprofile;

	@FindBy(xpath = "//div[text()='+']/..")
	public WebElement addprofile;
	
	@FindBy(xpath = "//label[text()=contains(text(),'Profile Name')]/following::input")
	public WebElement profilename;
	
	@FindBy(xpath = "//button[text()='Create']")
	public WebElement createbtn; 
	
	@FindBy(xpath = "//div[@role='alert']")
	public WebElement createdalert; 
	
	@FindBy(xpath = "//p[contains(text(),'testingprofile')]/..//button")
	public WebElement createdprofile; 
	
	@FindBy(xpath = "//p[contains(text(),'sarankumar')]/..//button")
	public WebElement mainprofile; 
	
	@FindBy(xpath = "//p[contains(text(),'testingprofile')]/..//button")
	public WebElement delprofile; 
	
	@FindBy(xpath = "//p[contains(text(),'Delete Profile')]/..")
	public WebElement delbtn; 
	
	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	public WebElement confirmdel; 
	
	@FindBy(xpath = "//div[@role='alert']")
	public WebElement delalert; 
	
	@FindBy(xpath = "//p[contains(text(),'testingprofile')]/..//img")
	public WebElement switchtocreatedprofile; 
	
	@FindBy(xpath = "//p[contains(text(),'Main')]/..//img")
	public WebElement admindel; 
	
	@FindBy(xpath = "(//p[contains(text(),'Switch Profile')])[2]")
	public WebElement switchprofile; 
	
	@FindBy(xpath = "//button[contains(text(),'Done')]")
	public WebElement donebtn; 
	
	@FindBy(xpath = "(//div[@class='profile-card '])[1]")
	public WebElement switchtodef; 
	
	@FindBy(xpath = "//button[contains(text(),'Edit Profiles')]")
	public WebElement editprofiles; 

	
	public String profilename()
	{
		return prop.getProperty("profilename");
	}
	
	public String cratedmsg()
	{
		return prop.getProperty("cratedmsg");
	}
	public String createdprodel()
	{
		return prop.getProperty("createdprodel");
	}
	public String admindelalert()
	{
		return prop.getProperty("admindel");
	}
	
	
}
