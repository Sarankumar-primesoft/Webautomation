package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Searchpage extends BaseClass{
	
	public Searchpage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//form[@class='search-bar']/div/div)[2]")
	public WebElement  searchicon; 
	
	@FindBy(xpath = "//input[@id='searchQuery']")
	public WebElement  searchbar; 
	
	@FindBy(xpath = "//h4[text()='No Data Found']")
	public WebElement  nodatamsg; 
	
	@FindBy(xpath = "//div[@class='clear-icon']")
	public WebElement  clearicon; 
	
	@FindBy(xpath = "//p[text()='Cancel']")
	public WebElement  cancelbtn; 
	
	@FindBy(xpath = "(//h2[text=contains(text(),'results for')])[2]")
	public WebElement  results; 
	
	@FindBy(xpath = "//div[@class='thumbnailMovieCard']/img")
	public WebElement  resultcard; 
		


	public String invalidsearch()
	{
		return prop.getProperty("invalidsearch") ;
		
	}
	public String validsearch()
	{
		return prop.getProperty("validsearch");
		
	}
	public String nodatamsgtext()
	{
		return prop.getProperty("nodatamsg");
		
	}
	public void resultsvalidate()
	{
		String src = resultcard.getAttribute("src");
		if (src.contains(validsearch())) {
			System.out.println("Results matched");
		}else 
			System.out.println("Results not matched");
	}
		

}
