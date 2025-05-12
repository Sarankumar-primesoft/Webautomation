package com.tests;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pom.Searchpage;
import com.pom.TransactionsPage;

import base.BaseClass;

public class TC_8 extends BaseClass{
		
	@Test
	public void TC8_Transactionpage() {

		transactionspage= new TransactionsPage(driver);
		
		logger = LogManager.getLogger(TransactionsPage.class);
		logger.info("Transaction page test");
		
		JSClick(driver,loginPage.profilenav,"Profile navigation");
		
		clickelementwithname(transactionspage.transactions, "transactions Page");
		
		isdisplay(transactionspage.transactionsheader);
		try {
			String transnotfoundmsg = Gettext(transactionspage.transnotfound);
			assertEquals(transnotfoundmsg,transactionspage.expectednotfoundmsg(),"Trasactions Not found msg");
		} catch (Exception e) {
			int size = transactionspage.transcount.size();
			int i;
			for (i=0;i<size;i++) {
				List<WebElement> transdetails = transactionspage.transdetails;
				for (WebElement tdetails: transdetails) {
					isdisplay(tdetails);
				}
			for (int j=0;j<transactionspage.billdownload.size();j++) {
				if(i==j) {
						clickelementwithname(transactionspage.billdownload.get(j),"bill download");
					}
				}
			}
		}
		
	}
}
