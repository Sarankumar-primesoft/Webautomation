package com.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import com.pom.ActivatetvPage;
import com.pom.Searchpage;

import base.BaseClass;

public class TC_9 extends BaseClass{
		
	@Test
	public void TC9_Activatetv() {

		activatetv= new ActivatetvPage(driver);
		
		logger = LogManager.getLogger(ActivatetvPage.class);
		logger.info("Activate tv page test");
		
		JSClick(driver,loginPage.profilenav,"Profile navigation");
		
		clickelementwithname(activatetv.Activatetvnavi, "Activate tv navigation");
		
		isdisplay(activatetv.activatetvheader);
		
		clickelementwithname(activatetv.activatebtn, "Activate btn");

		isdisplay(activatetv.entercodealert);

		activatetv.entercode();
		
		clickelementwithname(activatetv.activatebtn, "Activate btn");
		isdisplay(activatetv.invalidcodealert);
	}
}
