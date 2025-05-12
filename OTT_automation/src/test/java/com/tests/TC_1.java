package com.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import com.pom.Loginpage;

import base.BaseClass;

public class TC_1 extends BaseClass{

	@Test
	public void TC1_login() throws Exception  
	{
		loginPage = new Loginpage(driver);
		logger = LogManager.getLogger(Loginpage.class);
		logger.info("Starting Login Test");
		loginPage.login_case();
		
	}

	
}
