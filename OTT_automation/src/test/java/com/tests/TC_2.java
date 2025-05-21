package com.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import com.pom.Loginpage;
import com.pom.Profilepage;

import base.BaseClass;


public class TC_2 extends BaseClass{

	@Test 
	public void TC2_profile() throws InterruptedException
	{
//		ExtentReport.createTest("Profile");
		profilepage = new Profilepage(driver); 
		logger = LogManager.getLogger(Profilepage.class);

		logger.info("Profile page test");
		
		clickelementwithname(loginPage.profilenav,"Profile navigation");
		
		clickelement(profilepage.myprofile);

		visibleofele(driver,profilepage.profilename,"Profile name");
		assertEquals(profilepage.profilename.getText(),profilepage.actualprofilename(),"profilename");
		
		assertEquals(profilepage.profileemail.getAttribute("value"),profilepage.actualemail(),"profileemail");
		
		assertEquals(profilepage.profilemobile.getAttribute("value"),profilepage.actualmobile(),"profilemobile");
		
		visibleofele(driver,profilepage.profiledob,"Profile dob");
		assertEquals(profilepage.profiledob.getAttribute("value"),profilepage.actualdob(),"profiledob");
		
		visibleofele(driver,profilepage.profilegender,"Profile gender");
		assertEquals(profilepage.profilegender.getAttribute("value"),profilepage.actualgender(),"profilegender");
	}
}
