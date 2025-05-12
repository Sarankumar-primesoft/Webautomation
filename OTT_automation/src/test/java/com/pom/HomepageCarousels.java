package com.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ExtentReport.Extentlogger;

import base.BaseClass;

public class HomepageCarousels extends BaseClass {

	public int count=0;
	public HomepageCarousels(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()='Before TV']")
	public WebElement  beforetv; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Before TV')]/../../../child::div[2]/a[text()='More']/span")
	public WebElement  beforetvmore; 
	
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()='Recently Added']")
	public WebElement  recentlyadded; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Recently Added')]/../../../child::div[2]/a[text()='More']")
	public WebElement  recentlyaddedmore; 	
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()='Trending Now']")
	public WebElement  trendingnow; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Trending Now')]/../../../child::div[2]/a[text()='More']")
	public WebElement  trendingnowmore; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Weekly Series')]")
	public WebElement  Weeklyseries; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Weekly Series')]//ancestor::div[@class='first-slider']//child::div[@class='swiper-wrapper']/div/div/div/div/img")
	public List<WebElement> weeklyseriesthumbnails; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Win Originals')]")
	public WebElement  winoriginals; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Win Originals')]/../../../child::div[2]/a[text()='More']")
	public WebElement  winoriginalsmore; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()='Upcoming Attraction']")
	public WebElement  upcomingattrac; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Upcoming')]//ancestor::div[@class='first-slider']//child::div[@class='swiper-wrapper']/div/div/div/div/img")
	public WebElement  upcomingthumbnails; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Ugadi')]")
	public WebElement  ugadiheader; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Ugadi')]/../../../child::div[2]/a[text()='More']")
	public WebElement  ugadimore; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Thrilling')]")
	public WebElement  Thrilling; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Thrilling')]/../../../child::div[2]/a[text()='More']")
	public WebElement  Thrillingmore; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Bal Bharat')]")
	public WebElement  EtvBalbharat; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Bal Bharat')]//ancestor::div[@class='first-slider']//child::div[@class='swiper-wrapper']/div/div/div/div/img")
	public List<WebElement>  EtvBalbharatthumbnails; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'All Time Classic')]")
	public WebElement  AlltimeClassic; 
	
	@FindBy(xpath = "(//h2[text()=contains(text(),'Classic')]/../../../child::div[2]/a[text()='More'])[2]")
	public WebElement  AlltimeClassicmroe;
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Block Buster')]")
	public WebElement  Blockbuster; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Block Buster')]/../../../child::div[2]/a[text()='More']")
	public WebElement  Blockbustermore; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Evergreen')]")
	public WebElement  Evergreenhits; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Evergreen')]/../../../child::div[2]/a[text()='More']")
	public WebElement  Evergreenhitsmore; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'TV Shows')]")
	public WebElement  tvshowscurousal; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'TV Shows')]/../../../child::div[2]/a[text()='More']")
	public WebElement  tvshowscurousalmore; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Latest News')] ")
	public WebElement  latestnews; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Latest News')]//ancestor::div[@class='first-slider']//child::div[@class='swiper-wrapper']/div/div/div/div/img")
	public List<WebElement>  latestnewsthumbnails; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Live TV')]")
	public WebElement  livetvcurosal; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Live TV')]//ancestor::div[@class='first-slider']//child::div[@class='swiper-wrapper']/div/div/div/div/img")
	public List<WebElement>  livetvthumbnails; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Recommended')]")
	public WebElement  recommended; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Recommended')]/../../../child::div[2]/a[text()='More']")
	public WebElement  recommendedmore; 
	 
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Comedy')]")
	public WebElement  comedy; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Comedy')]/../../../child::div[2]/a[text()='More']")
	public WebElement  comedymore; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Romance')]")
	public WebElement  romance; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Romance')]/../../../child::div[2]/a[text()='More']")
	public WebElement  romancemore; 
	
	@FindBy(xpath = "(//div[@class='heading-font-size']/h2[text()=contains(text(),'Classic')])[2]")
	public WebElement  classic; 
	
	@FindBy(xpath = "(//h2[text()=contains(text(),'Classic')]/../../../child::div[2]/a[text()='More'])[1]")
	public WebElement  classicmore; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Folklore')]")
	public WebElement  folklore; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Folklore')]/../../../child::div[2]/a[text()='More']")
	public WebElement  folkloremore; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Action')]")
	public WebElement  action; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Action')]/../../../child::div[2]/a[text()='More']")
	public WebElement  actionmore; 
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Family')]")
	public WebElement  family; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Family')]/../../../child::div[2]/a[text()='More']")
	public WebElement  familymore; 
	
	
	@FindBy(xpath = "//div[@class='heading-font-size']/h2[text()=contains(text(),'Action')]")
	public WebElement ActionThriller; 
	
	@FindBy(xpath = "//h2[text()=contains(text(),'Action')]/../../../child::div[2]/a[text()='More']")
	public WebElement ActionThrillermore; 
	
	
	
	public void morebtnclick(WebElement morebtnele,String expectedurl,String whichele) throws InterruptedException {	
		JSClick(driver, morebtnele,whichele+" More btn");
		String morecurrentUrl = driver.getCurrentUrl();
		assertEquals(morecurrentUrl,expectedurl,whichele);
		navigateback();
		count++;
	}
	
	public void thumbnails(List<WebElement> elements)
	{
	    List<WebElement> thumbnails = elements;
	    if (thumbnails.size()>=0) {
			Extentlogger.info("Thumbnails are visible");
		}
	    for (WebElement eles : thumbnails) {
	        System.out.println("img src:  " + eles.getAttribute("src"));
	    }
	}
	
	public String beforetvmoreurl() {
		return prop.getProperty("beforetvmoreUrl");
	}
	public String recentlyaddedmoreurl() {
		return prop.getProperty("recentlyaddedmoreUrl");
	}
	public String trendingnowmoreUrl() {
		return prop.getProperty("trendingnowmoreUrl");
	}
	public String winoriginalsmoreUrl() {
		return prop.getProperty("winoriginalsmoreUrl");
	}
	public String UgadimoreUrl() {
		return prop.getProperty("UgadimoreUrl");
	}
	public String ThrillingmoreUrl() {
		return prop.getProperty("ThrillingmoreUrl");
	}
	public String AlltimeClassicsmoreUrl() {
		return prop.getProperty("AlltimeClassicsmoreUrl");
	}
	public String blockbustuermoreUrl() {
		return prop.getProperty("blockbustuermoreUrl");
	}
	public String tvshowscurousalmoreUrl() {
		return prop.getProperty("tvshowscurousalmoreUrl");
	}
	public String recommendedmoreUrl() {
		return prop.getProperty("recommendedmoreUrl");
	}
	public String evergreenhitsmoreUrl() {
		return prop.getProperty("evergreenhitsmoreUrl");
	}
	public String comedymoreUrl() {
		return prop.getProperty("comedymoreUrl");
	}
	public String romancemoreUrl() {
		return prop.getProperty("romancemoreUrl");
	}
	public String classicmoreUrl() {
		return prop.getProperty("classicmoreUrl");
	}
	public String folkloremoreUrl() {
		return prop.getProperty("folkloremoreUrl");
	}
	public String actionsmoreUrl() {
		return prop.getProperty("actionsmoreUrl");
	}
	public String familymoreUrl() {
		return prop.getProperty("familymoreUrl");
	}
	public String actionthrillerUrl() {
		return prop.getProperty("actionthrillerUrl");
	}
	
	
}
