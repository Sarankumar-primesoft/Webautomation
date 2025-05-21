package com.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import com.pom.HomepageCarousels;
import com.pom.Searchpage;
import com.pom.WatchLaterPage;

import base.BaseClass;

public class TC_7 extends BaseClass{

	@Test
	public void TC7_homepagecarousels() throws InterruptedException
	{
		homepagecarousels= new HomepageCarousels(driver);

		logger = LogManager.getLogger(HomepageCarousels.class);
		logger.info("Homepage carousels test");
		
		scrollUntilElementAppears(homepagecarousels.beforetv,"Before tv");
//		homepagecarousels.morebtnclick(homepagecarousels.beforetvmore,homepagecarousels.beforetvmoreurl(),"Before Tv");
		scrollToBottom(driver);
		
		scrollUntilElementAppears(homepagecarousels.recentlyadded,"Recently added");
		visibleofele(driver, homepagecarousels.recentlyadded, "recently added header");
		homepagecarousels.morebtnclick(homepagecarousels.recentlyaddedmore,homepagecarousels.recentlyaddedmoreurl(),"Recently added");
		
		scrollUntilElementAppears(homepagecarousels.trendingnow,"Trending now");
		homepagecarousels.morebtnclick(homepagecarousels.trendingnowmore,homepagecarousels.trendingnowmoreUrl(),"Trending now");
	
		scrollUntilElementAppears(homepagecarousels.Weeklyseries,"Weekly Series");
		homepagecarousels.thumbnails(homepagecarousels.weeklyseriesthumbnails);
		
		scrollUntilElementAppears(homepagecarousels.winoriginals,"win originals");
		homepagecarousels.morebtnclick(homepagecarousels.winoriginalsmore,homepagecarousels.winoriginalsmoreUrl(),"win originals");

		scrollUntilElementAppears(homepagecarousels.upcomingattrac,"Upcoming attractions");
		homepagecarousels.thumbnails(homepagecarousels.weeklyseriesthumbnails);
		
		scrollUntilElementAppears(homepagecarousels.ugadiheader,"Ugadi Utsavam");
//		homepagecarousels.morebtnclick(homepagecarousels.ugadimore,homepagecarousels.UgadimoreUrl(),"Ugadi Utsavam");
				
		scrollUntilElementAppears(homepagecarousels.Thrilling,"Thrilling Summer");
		homepagecarousels.morebtnclick(homepagecarousels.Thrillingmore,homepagecarousels.ThrillingmoreUrl(),"Thrilling Summer");
		
		scrollUntilElementAppears(homepagecarousels.EtvBalbharat,"ETV Bal Bharat Kids");
		homepagecarousels.thumbnails(homepagecarousels.EtvBalbharatthumbnails);
		
		scrollUntilElementAppears(homepagecarousels.AlltimeClassic,"All Time Classics");
		homepagecarousels.morebtnclick(homepagecarousels.AlltimeClassicmroe,homepagecarousels.AlltimeClassicsmoreUrl(),"All Time Classics");
		
		scrollUntilElementAppears(homepagecarousels.Blockbuster,"Block Buster Hits");
		homepagecarousels.morebtnclick(homepagecarousels.Blockbustermore,homepagecarousels.blockbustuermoreUrl(),"Block Buster Hits");
				
		scrollUntilElementAppears(homepagecarousels.Evergreenhits,"Evergreen Hits");
		homepagecarousels.morebtnclick(homepagecarousels.Evergreenhitsmore,homepagecarousels.evergreenhitsmoreUrl(),"Evergreen Hits");
		
		scrollUntilElementAppears(homepagecarousels.tvshowscurousal,"TV Shows");
		homepagecarousels.morebtnclick(homepagecarousels.tvshowscurousalmore,homepagecarousels.tvshowscurousalmoreUrl(),"TV Shows");
		
		scrollUntilElementAppears(homepagecarousels.latestnews,"Latest News");
		homepagecarousels.thumbnails(homepagecarousels.latestnewsthumbnails);
		
		scrollUntilElementAppears(homepagecarousels.livetvcurosal,"Live tv");
		homepagecarousels.thumbnails(homepagecarousels.livetvthumbnails);
		
		scrollUntilElementAppears(homepagecarousels.recommended,"Recommended");
		homepagecarousels.morebtnclick(homepagecarousels.recommendedmore,homepagecarousels.recommendedmoreUrl(),"Recommended");
		
		scrollUntilElementAppears(homepagecarousels.comedy,"Comedy");
		homepagecarousels.morebtnclick(homepagecarousels.comedymore,homepagecarousels.comedymoreUrl(),"Comedy");
		
		scrollUntilElementAppears(homepagecarousels.romance,"Romance");
		homepagecarousels.morebtnclick(homepagecarousels.romancemore,homepagecarousels.romancemoreUrl(),"Comedy");
		
		scrollUntilElementAppears(homepagecarousels.classic,"Classic");
		homepagecarousels.morebtnclick(homepagecarousels.classicmore,homepagecarousels.classicmoreUrl(),"Classic");
		
		scrollUntilElementAppears(homepagecarousels.folklore,"Folklore");
		homepagecarousels.morebtnclick(homepagecarousels.folkloremore,homepagecarousels.folkloremoreUrl(),"Folklore");
		
		scrollUntilElementAppears(homepagecarousels.family,"Family");
		homepagecarousels.morebtnclick(homepagecarousels.familymore,homepagecarousels.familymoreUrl(),"Family");
		
		scrollUntilElementAppears(homepagecarousels.ActionThriller,"Action/Thriller");
		homepagecarousels.morebtnclick(homepagecarousels.ActionThrillermore,homepagecarousels.actionthrillerUrl(),"Action / Thriller");
		
		
	}
}
