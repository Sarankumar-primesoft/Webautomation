package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Subscriptionpage extends BaseClass{
	

	@FindBy(xpath="//div[@class='offcanvas-body']//a[text()='Subscribe'][@role='button']")	
	public WebElement subscribe_btn;
	
	@FindBy(xpath="//span[@class='planName']")	
	public WebElement sub_status;
	
	@FindBy(xpath="//span[text()='Month']/../../../following::div//span[@class='amount-right']")	
	public WebElement premium_month ;
	
	@FindBy(xpath="//span[text()='Year']/../../../following::div//span[@class='amount-right']")	
	public WebElement premium_year;
	
	
	@FindBy(xpath="//button[@id='buy-now']")	
	public WebElement buynow_btn;
	
	
	@FindBy(xpath="//div[@role='alert']/div/following::div")	
	public WebElement choose_planAlert;
	
	@FindBy(xpath="//span[text()='Month']/../../div/label/label//span")	
	public WebElement month_planbtn;
	
	@FindBy(xpath="//span[text()='Year']/../../div/label/label//span")	
	public WebElement year_planbtn;
	
	@FindBy(xpath="//input[@id='coupon-code']")	
	public WebElement coupon_code;
	
	@FindBy(xpath="//button[@id='apply-coupon']")	
	public WebElement apply_btn;
	
	@FindBy(xpath="//div[@role='alert']/div[2]")	
	public WebElement coupon_alert ;
	
	@FindBy(xpath="//div[@role='alert']/div[2]")	
	public WebElement invalid_alert ;
	
	@FindBy(xpath="//*[@class='clear-icon']")	
	public WebElement clear_btn;
	
	@FindBy(xpath="//button[text()='Buy now']")	
	public WebElement buy_btn;

	@FindBy(xpath="//iframe[@class='razorpay-checkout-frame']")	
	public WebElement frame;
	
	@FindBy(xpath="//span[text()='Payment Options']")	
	public WebElement payments_window;
	
	@FindBy(xpath="//button[@title='Close Checkout']")	
	public WebElement close_payment;
	
	@FindBy(xpath="//button[contains(text(),'Yes, exit')]")	
	public WebElement close_confirm;

	public Subscriptionpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getsubstatus()
	{
		return prop.getProperty("sub-status");
	}
	
	public String getsubsiteurl()
	{
		return prop.getProperty("subsite-url");
	}
	public String getpremiunmonth()
	{
		return prop.getProperty("premium-month");
	}
	public String getpremiumyear()
	{
		return prop.getProperty("premium-year");
	}
	public String getalertmsg()
	{
		return prop.getProperty("alert-msg");
	}
	public String getcouponcode()
	{
		return prop.getProperty("coupon-code");
	}
	public String getcouponalert()
	{
		return prop.getProperty("coupon-alert");
	}
	public String getinvalidalert()
	{
		return prop.getProperty("invalid-alert");
	}
	public String getcontactusurl()
	{
		return prop.getProperty("contactus_url");
	}
	
	
	
	
	
}