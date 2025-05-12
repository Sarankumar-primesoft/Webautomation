package com.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import com.pom.HomepageHeaders;
import com.pom.Profilepage;

import base.BaseClass;

public class TC_4 extends BaseClass {

	@Test
	public void TC4_HomepageHeaders()
	{
		homepageheaders=new HomepageHeaders(driver);
		
		logger = LogManager.getLogger(HomepageHeaders.class);
		logger.info("Homepage Headers test");
		
		assertTrue(homepageheaders.headerlogo.isDisplayed(),"Header logo","Header logo should be visible");
		
		clickelement(homepageheaders.home);
		assertEquals(homepageheaders.currentUrl(), homepageheaders.homecurrentUrl(), "Homepage url");
		
		clickelement(homepageheaders.tvshows);
		assertEquals(homepageheaders.currentUrl(), homepageheaders.tvshowcurrentUrl(), "TV shows url");
		
		clickelement(homepageheaders.movies);
		assertEquals(homepageheaders.currentUrl(), homepageheaders.moviescurrentUrl(), "Movies url");
		
		clickelement(homepageheaders.watchfree);
		assertEquals(homepageheaders.currentUrl(), homepageheaders.watchfreecurrentUrl(), "Watchfree url");
		
		clickelement(homepageheaders.livetv);
		assertEquals(homepageheaders.currentUrl(), homepageheaders.livetvcurrentUrl(), "Livetv url");
		
		clickelement(homepageheaders.kids);
		assertEquals(homepageheaders.currentUrl(), homepageheaders.kidscurrentUrl(), "kids url");
		
		
	}
}
