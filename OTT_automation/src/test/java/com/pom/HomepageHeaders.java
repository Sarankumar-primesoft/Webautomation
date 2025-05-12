package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomepageHeaders extends BaseClass {

	@FindBy(xpath = "//div[@class='header-logo']/a/img")
	public WebElement headerlogo; 

	@FindBy(xpath = "//a[text()='Home']")
	public WebElement home; 
	
	@FindBy(xpath = "//a[text()='TV Shows']")
	public WebElement tvshows; 
	
	@FindBy(xpath = "//div[@class='offcanvas-body']//a[text()='Movies']")
	public WebElement movies; 
	
	@FindBy(xpath = "//a[text()='Watch Free']")
	public WebElement watchfree; 
	
	@FindBy(xpath = "//a[text()='Live TV']")
	public WebElement livetv; 
	
	@FindBy(xpath = "//a[text()='Kids']")
	public WebElement kids; 
	
	public HomepageHeaders(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String currentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String homecurrentUrl() {
		return prop.getProperty("homeUrl");
	}
	public String tvshowcurrentUrl() {
		return prop.getProperty("tvshowUrl");
	}
	public String moviescurrentUrl() {
		return prop.getProperty("moviesUrl");
	}
	public String watchfreecurrentUrl() {
		return prop.getProperty("watchfreeUrl");
	}
	public String livetvcurrentUrl() {
		return prop.getProperty("livetvUrl");
	}
	public String kidscurrentUrl() {
		return prop.getProperty("kidsUrl");
	}
}
