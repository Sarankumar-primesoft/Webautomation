package com.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ExtentReport.ExtentReport;
import com.pom.Loginpage;

import base.BaseClass;

public class TC_1 extends BaseClass{

	@BeforeTest
	public void setUp() {
		loginPage = new Loginpage(driver);
	}
	@Test
	public void TC1_login() throws Exception  
	{
		
		logger = LogManager.getLogger(Loginpage.class);
		logger.info("Starting Login Test");
		ExtentReport.createTest("Login");
		loginPage.login_case();
		
	}

	
}
