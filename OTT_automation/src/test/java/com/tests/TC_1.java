package com.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ExtentReport.ExtentReport;
import com.ExtentReport.Extentlogger;
import com.pom.Loginpage;

import base.BaseClass;

public class TC_1 extends BaseClass{

	@Test
	public void TC1_login() throws Exception  
	{
		loginPage = new Loginpage(driver);
		logger = LogManager.getLogger(Loginpage.class);
		logger.info("Starting Login Test");
		ExtentReport.createTest("Login");

		Extentlogger.info("Starting login test");
		clickelement(loginPage.login_btn);
		clickelement(loginPage.email_btn);
		sendkeys(loginPage.username, prop.getProperty("username"));
		sendkeys(loginPage.password, prop.getProperty("password"));
		clickelement(loginPage.next_btn);
		Thread.sleep(5000);
		String Loginstatus= loginPage.login_alert.getText();
		System.out.println(Loginstatus);
		if (Loginstatus.equalsIgnoreCase(prop.getProperty("loginsuccessmsg"))) {
			System.out.println("Validating login alert");
			Extentlogger.pass("Logged in Sucessfully",true);
		}
		else {
			Extentlogger.fail("Login Failed", true);
		}
		Thread.sleep(5000);
		System.out.println(loginPage.profile_img.getAttribute("src"));
		visibleofele(driver, loginPage.profile_img,"Profile img");
		clickelementwithname(loginPage.profileselect,"Profileselect");
	
	}
}
