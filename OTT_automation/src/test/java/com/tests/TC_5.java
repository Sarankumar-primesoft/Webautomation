package com.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import com.pom.HomepageHeaders;
import com.pom.Searchpage;

import base.BaseClass;

public class TC_5 extends BaseClass{

	@Test
	public void TC5_Searchpage()
	{
		searchpage= new Searchpage(driver);
		
		logger = LogManager.getLogger(Searchpage.class);
		logger.info("Search page test");
		
		JSClick(driver, searchpage.searchicon, "Search icon");
		sendkeys(searchpage.searchbar, searchpage.invalidsearch());
		entersendkeys(searchpage.searchbar);
//		assertTrue(isdisplay(searchpage.nodatamsg), "Alert Msg","No data msg validation");
		
		assertTrue(isdisplay(searchpage.clearicon),"clear icon","Clear icon visible validation");
		
		clickelement(searchpage.clearicon);
		
		sendkeys(searchpage.searchbar,searchpage.validsearch());
		
		assertTrue(isdisplay(searchpage.results),"Results","Results visibility validation");
		
		searchpage.resultsvalidate();
		
		clickelement(searchpage.clearicon);
		
		clickelement(searchpage.cancelbtn);
	}
		
}
