package com.pom;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class ActivatetvPage extends BaseClass{

	public ActivatetvPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@id='nav-dropdown']")
	public  WebElement profilenav;
		
	@FindBy(xpath = "(//a[contains(., \"Activate TV\")])[3]")
	public WebElement  Activatetvnavi; 
	
	@FindBy(xpath = "//h6[contains(.,'Activate ETV')]")
	public WebElement  activatetvheader; 
	
	@FindBy(xpath = "//p[contains(.,'Please enter code')]")
	public WebElement  entercodealert; 
	
	@FindBy(xpath = "//p[contains(.,'new code')]")
	public WebElement  invalidcodealert; 
	
	@FindBy(xpath = "//p[contains(text(),'Enjoy ETV')]//following::ul['otp-input-two']//input")
	public List<WebElement>  codeinput; 
	
	@FindBy(xpath = "//button[.='Activate']")
	public WebElement  activatebtn; 


	public String activatecode() {
		return prop.getProperty("activatecode");
	}
	public void entercode()
	{
		String activatecode = activatecode();
		char[] code = activatecode.toCharArray();
		
		for (int i = 0; i < code.length; i++) {
	        codeinput.get(i).sendKeys(String.valueOf(code[i]));
	    }

	}


}
