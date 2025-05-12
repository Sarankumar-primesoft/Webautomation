package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class TransactionsPage extends BaseClass{

	public TransactionsPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@id='nav-dropdown']/../div/a[6]")
	public WebElement transactions;

	@FindBy(xpath = "//h6[text()=contains(text(),'My Transactions')]")
	public WebElement transactionsheader;
	
	@FindBy(xpath = "//table[@data-testid='table']//td[text()='Transaction not found']")
	public WebElement transnotfound;
	
	@FindBy(xpath = "//tbody[@data-testid='tbody']/tr")
	public List<WebElement> transcount;

	@FindBy(xpath = "//tbody[@data-testid='tbody']/tr/td")
	public List<WebElement> transdetails;

	@FindBy(xpath = "(//img[@class='downloadicon'])")
	public List<WebElement> billdownload;

	public String expectednotfoundmsg()
	{
		return prop.getProperty("transnotfoundmsg");
		
	}
}
