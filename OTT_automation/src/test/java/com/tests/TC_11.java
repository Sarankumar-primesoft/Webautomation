package com.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import com.pom.Addprofile;

import base.BaseClass;

public class TC_11 extends BaseClass{

	@Test
	public void TC11_AddProfileTc() throws InterruptedException {

		addprofile= new Addprofile(driver);
		
		logger = LogManager.getLogger(Addprofile.class);
		logger.info("AddProfile page test");

		JSClick(driver,loginPage.profilenav,"Profile navigation");

		clickelementwithname(addprofile.manageprofile,"Manage profile");

		clickelementwithname(addprofile.addprofile,"Add profile");

		sendkeys(addprofile.profilename,addprofile.profilename() ); 

		clickelementwithname(addprofile.createbtn,"create btn");

		visibleofele(driver, addprofile.createdalert, "Created alert");
		
		assertEquals(Gettext(addprofile.createdalert), addprofile.cratedmsg(), "Created alert");

		invisibilityofelement(driver,addprofile.createdalert,"Invisibility of created alert" );

		JSClick(driver,loginPage.profilenav,"Profile navigation");		

		clickelementwithname(addprofile.manageprofile,"manage profile");
		clickelementwithname(addprofile.createdprofile,"Created profile");
		clickelementwithname(addprofile.delbtn,"delete btn");
		clickelementwithname(addprofile.confirmdel,"Confirm del");
		
	}
}
