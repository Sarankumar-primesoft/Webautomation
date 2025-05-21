package com.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import com.pom.Searchpage;
import com.pom.WatchLaterPage;

import base.BaseClass;

public class TC_6 extends BaseClass
{
	@Test
	public void TC6_Watchlater() {
		
		/* adding movie to watchlater */
		watchlater= new WatchLaterPage(driver);
		
		logger = LogManager.getLogger(WatchLaterPage.class);
		logger.info("Watchlate page test");
		
		clickelementwithname(watchlater.firsttumbnail,"First thumbnail");
		
		String thumbnailsrc = watchlater.firsttumbnail.getAttribute("src");
		System.out.println(thumbnailsrc);
		
		clickelementwithname(watchlater.addtowishlist,"Add to wishlist");
		
		visibleofele(driver, watchlater.addedalert,"Added alert");
		
		String addedalertText =Gettext(watchlater.addedalert);
		System.out.println(addedalertText);
		assertEquals(addedalertText, watchlater.expectedaddedtomylistalert(),"Added alert Assertion");

		clickelementwithname(watchlater.watchbtn,"watch btn");
		
//		visibleofele(driver, watchlater.bannerimg,"Banner img");
		String bannerimgtitle= driver.getTitle();
 
		/* My list page navigation */
		
//		driver.navigate().refresh();
//		Waitforclickable(watchlater.profile_navigate1,10);
		invisibilityofelement(driver, watchlater.addedalert,"Added to Watch now alert");
		clickelementwithname(watchlater.profile_navigate1,"Profilenavigate");

		clickelementwithname(watchlater.mylist,"My list");
		
		visibleofele(driver, watchlater.mylistbannerimg,"My list bannerimg");
		clickelementwithname(watchlater.mylistbannerimg,"My list bannerimg");

//		visibleofele(driver, watchlater.bannerimg,"Bannerimg");

		String addedbannertitle= driver.getTitle();
		
		System.out.println("bannerimg title: "+bannerimgtitle);
		System.out.println("mylistbannerimg title: "+addedbannertitle);

//		assertEquals(bannerimgtitle, addedbannertitle, "My list updated with the respective content");
		
		/* My list deletion*/
		driver.navigate().back();
		watchlater.mylistdeletion();
	}

}
