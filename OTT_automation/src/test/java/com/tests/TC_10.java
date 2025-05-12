package com.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import com.pom.ActivatetvPage;
import com.pom.Footersection;
import com.pom.Searchpage;

import base.BaseClass;

public class TC_10 extends BaseClass{
		
	@Test
	public void TC10_Footersection() {

		footersec= new Footersection(driver);
	
		logger = LogManager.getLogger(Footersection.class);
		logger.info("Footer section page test");
		
		clickelementwithname(footersec.Aboutus,"About us");
		isdisplay(footersec.Aboutusheader);
		footersec.backandwait();

		clickelementwithname(footersec.contactus,"Contact Us");
		isdisplay(footersec.contactusheader);
		footersec.backandwait();
		
		clickelementwithname(footersec.Redeem,"Redeem");
		isdisplay(footersec.Redeemheader);		
		footersec.backandwait();
		
		clickelementwithname(footersec.privacy,"Privacy");
		isdisplay(footersec.privacyheader);
		footersec.backandwait();
	
		clickelementwithname(footersec.Terms,"Terms and conditions");
		isdisplay(footersec.Termsheader);
		footersec.backandwait();
		
		clickelementwithname(footersec.FAQ,"FAQ");
		isdisplay(footersec.FAQheader);
		footersec.backandwait();
		
		clickelementwithname(footersec.Feedback,"Feedback");
		isdisplay(footersec.Feedbackheader);
		footersec.backandwait();
		
		clickelementwithname(footersec.Subscription,"Subscription");
		isdisplay(footersec.Subscriptionheader);
		footersec.backandwait();
		
		
	}
}
