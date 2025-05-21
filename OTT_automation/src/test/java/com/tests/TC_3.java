package com.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import com.pom.Subscriptionpage;

import base.BaseClass;

public class TC_3 extends BaseClass {
	
	@Test
	public void TC3_subscription_page() throws InterruptedException{
		subpage = new Subscriptionpage(driver);
		
		logger = LogManager.getLogger(Subscriptionpage.class);

		logger.info("Starting Subscription page Test");
		
		visibleofele(driver,subpage.subscribe_btn,"Subscribe btn");
		
		clickelement(subpage.subscribe_btn);
		assertEquals(driver.getCurrentUrl(), prop.getProperty("subsite-url"),"Site url validation" );

		assertEquals(subpage.premium_month.getText(),subpage.getpremiunmonth(),"Month Prenium" );
		
		assertEquals(subpage.premium_year.getText(),subpage.getpremiumyear(),"Year Prenium" );
		
		clickelementwithname(subpage.buynow_btn,"Buy now btn");
		visibleofele(driver, subpage.choose_planAlert,"Choose plan alert");
		assertEquals(subpage.choose_planAlert.getText(), subpage.getalertmsg(), "Choose Plan alert ");   
		clickelementwithname(subpage.month_planbtn,"Month plan btn");	
	
		invisibilityofelement(driver,subpage.choose_planAlert, "Choose plan alert");
	
		scrollByVisibilityOfElement(driver, subpage.buynow_btn);
		scrollToBottom(driver);
				
		clickelementwithname(subpage.buynow_btn,"Buy now btn");
		
		switchframe(subpage.frame);
			
		visibleofele(driver, subpage.payments_window,"Payments window");
		clickelement(subpage.close_payment);
		clickelement(subpage.close_confirm);		
	}
}
