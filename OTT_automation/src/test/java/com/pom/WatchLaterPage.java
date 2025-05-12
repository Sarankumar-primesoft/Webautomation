package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class WatchLaterPage extends BaseClass{

	public WatchLaterPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Home']")
	public WebElement  home; 

	@FindBy(xpath = "//div[@class='logo-slider-inner']/div/img[@id='0']")
	public WebElement  firsttumbnail; 

	@FindBy(xpath = "//div[@class='plus-buto']")
	public WebElement  addtowishlist; 

	@FindBy(xpath = "//div[@role='alert']/div[2]")
	public WebElement  addedalert; 

	@FindBy(xpath = "//div[@class='play-buton']/a")
	public WebElement  watchbtn; 

	@FindBy(xpath = "//div[@class='imgabove-layer']/img")
	public WebElement  bannerimg; 

	@FindBy(xpath = "//a[@id='nav-dropdown']")
	public WebElement  profile_navigate1; 

	@FindBy(xpath = "//a[@id='nav-dropdown']/../div/a[5]")
	public WebElement  mylist; 

	@FindBy(xpath = "//div[@class='thumbnailMovieCard relateddet']/img")
	public WebElement  mylistbannerimg; 

	@FindBy(xpath = "//h2[text()='Watch Later']")
	public WebElement  watchlaterherader; 

	@FindBy(xpath = "//div[text=contains(text(),'thumbnailMovieCard')]/img[@alt='0']")
	public WebElement  watchlaterfirsttm; 

	@FindBy(xpath = "//div[@class='noData']//div[@class='row']/div")
	public List<WebElement>  watchlaterlist; 

	@FindBy(xpath ="//a[normalize-space()='Delete']")
	public WebElement  deletebtn; 

	@FindBy(xpath ="//label[normalize-space()='Select All']/span")
	public WebElement  delselall; 

	@FindBy(xpath ="//button[contains(text(),'Delete')]")
	public WebElement  afterseldeletebtn; 

	@FindBy(xpath ="//div[@class='modal-body']/p")
	public WebElement  confirmmsg; 

	@FindBy(xpath ="//button[normalize-space()='Yes']")
	public WebElement  deleteyes; 

	@FindBy(xpath ="//div[@class='thumbnailMovieCard relateddet']")
	public WebElement deletefirstTumb; 

	@FindBy(xpath ="//div[@class='radios-left']//span[@class='checkmarks']")
	public WebElement deletefirstumbsel; 

	public String expectedaddedtomylistalert() {
		return prop.getProperty("addedtomylist");
	}
	public String bannerimgtitle() {
		return driver.getTitle();
	}

	public void mylistdeletion()
	{
		visibleofele(driver,watchlaterherader,"Watchlater header");
		if (watchlater.watchlaterherader.isDisplayed()) {
			assertTrue(watchlaterfirsttm.isDisplayed(),"Watchlater first item","Asserting on watchlater first item");
			if ((watchlaterlist.size()) > 1) {
				clickelementwithname(deletebtn, "deletebtn");
				clickelementwithname(delselall, "delselall");
				clickelementwithname(afterseldeletebtn, "afterseldeletebtn");
				visibleofele(driver, confirmmsg, "Confirm msg");
				clickelementwithname(deleteyes,"deleteyes");
			} else {
				visibleofele(driver, deletefirstTumb, "deletefirsTumb");
				clickelementwithname(deletebtn, "deletebtn");
				clickelementwithname(deletefirstumbsel, "deletefirstumbsel");
				clickelementwithname(afterseldeletebtn, "afterseldeletebtn");
				visibleofele(driver, confirmmsg, "Confirm msg");
				clickelementwithname(deleteyes,"deleteyes");
			}
		} else
			System.out.println("Watchlater is empty");
	}

}
