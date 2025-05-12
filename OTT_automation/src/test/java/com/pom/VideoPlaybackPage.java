package com.pom;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.EventLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ExtentReport.ExtentManager;
import com.ExtentReport.ExtentReport;
import com.ExtentReport.Extentlogger;

import base.BaseClass;

public class VideoPlaybackPage extends BaseClass{

	@FindBy(xpath = "//a[text()='Watch Free']")
	WebElement watchfreeheader; 

	@FindBy(xpath = "//h2[text()='Serials']")
	WebElement Serials;

	@FindBy(xpath = "//h2[contains(.,'Web Series')]")
	WebElement WebSeries;
	
	@FindBy(xpath = "(//div[@class='swiper-wrapper']/div//img)")
	List<WebElement> watchfreecontent;

	@FindBy(xpath = "//img[@alt='Abhishekam']")
	WebElement serialsshow1;

	@FindBy(xpath = "//div[@class='circle-icon']/a")
	WebElement watchnowbtn;

	@FindBy(xpath = "//button[@aria-label='Play']")
	WebElement playbtn;

	@FindBy(xpath = "//button[@aria-label='Pause']")
	WebElement pausebtn;

	@FindBy(xpath = "//div[@class='plyr__progress']/input")
	WebElement seekbar;

	@FindBy(xpath = "//button[@data-plyr='fast-forward']")
	WebElement forward;

	@FindBy(xpath = "//button[@data-plyr='rewind']")
	WebElement rewind ;

	@FindBy(xpath = "//button[@data-plyr='fullscreen']")
	WebElement fullscreen;

	@FindBy(xpath = "//button[@data-plyr='mute']")
	WebElement mutebtn;

	@FindBy(xpath = "//span[text()='Settings']/..")
	WebElement settingbtn;

	@FindBy(xpath = "//span[text()='Speed']/..")
	WebElement speed;

	@FindBy(xpath = "//span[text()='Speed']/..")
	WebElement speedbeckbtn;

	@FindBy(xpath = "//button[@data-plyr='speed']")
	List<WebElement> speedvalues;
	
	@FindBy(xpath = "//div[@id='ad-timer']")
	WebElement adtimer;
	

	public void videoplaytest() throws InterruptedException
	{
		clickelement(watchfreeheader);	
		visibleofele(driver, Serials,"Serials");
		randomwatchfreeselect(driver);
		clickelement(watchnowbtn);
		Thread.sleep(5000);
	}
	
	public void randomwatchfreeselect(WebDriver driver)
	{
//		scrollByVisibilityOfElement(driver, WebSeries);
		String randomname = clickRandomElement(watchfreecontent);
		WebElement randomselectedele = driver.findElement(By.xpath("//img[@alt=\""+randomname+"\"]"));
		System.out.println("Random selected element: "+randomselectedele);
		JSClick(driver, randomselectedele,"Random select element");
		return;
	}

	public void isvideoplaying() throws InterruptedException
	{
		countads(driver);
		pausebtn();
		Thread.sleep(2000);
		playbtn();
		if(invisibilityofelement(driver, playbtn,"Play button")) 
			System.out.println("Video is playing successfully");
		else 
			System.out.println("Faild to play, Video is still paused.");
	}


	public void isvideopaused()
	{
		pausebtn();
		if(invisibilityofelement(driver, pausebtn,"Pause button")) 
			System.out.println("Video is Paused successfully");
		else 
			System.out.println("Failed to pause,Video is still Playing.");
		playbtn();
	}
	
	public boolean forwardedtimecalc (int actual,int expected)
	{
		if(expected==actual) 
		{	Extentlogger.fail("Forward failed. Time before forward: " + expected + " secs, Time after forward: " + actual + " secs");
        return false;
		}else {
			int res = actual-expected;
	        Extentlogger.pass("Forward successful: " + res + " Seconds");
	        return true;
		}
	}
	
	public int convertToSeconds(String timeStr) {
		String[] parts = timeStr.split(" of ")[0].split(":"); // Extract "00:10" part and split
		int minutes = Integer.parseInt(parts[0]);
		int seconds = Integer.parseInt(parts[1]);
		return (minutes * 60) + seconds; // Convert to total seconds
	}
	
	public void moveforwardfor2min()
	{
		int i = 0;
		while(i<=12)
		{
			forward();
			i++;
		}
		System.out.println("Video moved forwarded to 2 mins");
	}
	
	public boolean rewindedtimecalc (int actual,int expected)
	{
		if(actual >= expected) 
		{
			Extentlogger.fail("Rewind failed. Expected time before rewind: " + expected + " sec, but got: " + actual + " secs");
	        return false;
		}else {
			int res = actual - expected;
	        Extentlogger.pass("Rewind successful: " + res + " Seconds");
	        return true;

		}
	}
	
	public void validatefullscreen() {
		fullscreen();
		if(fullscreen.getAttribute("aria-pressed").equalsIgnoreCase("true")) 
			System.out.println("Switched to Full screen mode");
		else
			System.out.println("Full screen mode not enabled.");
		fullscreen();
		if(fullscreen.getAttribute("aria-pressed").equalsIgnoreCase("false")) 
			System.out.println("Exited from Full screen mode");
		else
			System.out.println("Exit from Full screen mode is failed.");
	}
	
	public void validatemute() {
		visibleofele(driver, mutebtn,"Mute btn");
		mutebtn();
		if(mutebtn.getAttribute("aria-pressed").equalsIgnoreCase("true")) 
			System.out.println("Video muted");
		else
			System.out.println("Video not Muted.");
		mutebtn();
		if(mutebtn.getAttribute("aria-pressed").equalsIgnoreCase("false")) 
			System.out.println("Unmuted successfully");
		else
			System.out.println("Failed to unmute.");
	}
	
	public int betweentimecal(String before,String after) {
		int beforetiming = convertToSeconds(before);
		int aftertiming = convertToSeconds(after);
		int res=aftertiming-beforetiming;
		return res;
	}

	
	public void speedcontrolsvalidate(int durationplayed, String selectedspeed)
	{
		
		double speedValue = Double.parseDouble(selectedspeed);
		int expectedPlayedDuration =(int) Math.round(10 * speedValue);
		if (Math.abs(durationplayed - expectedPlayedDuration) <= 2) {
			   System.out.println("✅ Playback duration validation PASSED!");
			   Extentlogger.pass("✅ Playback duration validation PASSED!");
        } else {
            System.out.println("❌ Playback duration validation FAILED!");
            Extentlogger.fail("❌ Playback duration validation FAILED!");
		}
	}

	public String randomspeedcontrol(List<WebElement> speedvalues)
	{
		if (!speedvalues.isEmpty()) {
			Random random = new Random();
			int randomIndex = random.nextInt(speedvalues.size());
			WebElement selectedSpeed = speedvalues.get(randomIndex);
			selectedSpeed.click();
			String selectedSpeedValue = selectedSpeed.getAttribute("value");
			return selectedSpeedValue;
		}
		return "No speed options found";
	}
	
	public void speedcontrols() throws InterruptedException
	{
		settingbtn();
		speedbtn();
		String selectedspeed = randomspeedcontrol(speedvalues);
		System.out.println("Selected Speed: "+selectedspeed);
		Extentlogger.info("Selected Speed: "+selectedspeed);
		String beforeseekbartiming = seekbartiming();
		playbtn();
		Thread.sleep(10000);
		pausebtn();
		String afterseekbartiming = seekbartiming();
		System.out.println("Seekbar timing before Speed controls:"+beforeseekbartiming);
		Extentlogger.info("Seekbar timing before Speed controls:"+beforeseekbartiming);
		System.out.println("Seekbar timing After Speed controls:"+afterseekbartiming);
		Extentlogger.info("Seekbar timing After Speed controls:"+afterseekbartiming);
		int durationplayed = betweentimecal(beforeseekbartiming, afterseekbartiming);
		System.out.println("Duration played: "+durationplayed+" seconds Video Played in the "+selectedspeed+"x speed");
		Extentlogger.info("Duration played: "+durationplayed+" seconds Video Played in the "+selectedspeed+"x speed");
		speedcontrolsvalidate(durationplayed, selectedspeed);
	}

	public void waitForAdsToFinish(WebDriver driver) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	        // Wait for the ad timer element to appear
	        WebElement adtimer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ad-timer']")));
	        
	        int totalAds = extractTotalAds(adtimer.getText());

	        System.out.println("🔹 Total Ads in Video: " + totalAds);
	        Extentlogger.info("Total Ads in Video: " + totalAds);
	        
	        int totalWaitTime = 0;

	        // Loop through each ad
	        for (int i = 1; i <= totalAds; i++) {
	            System.out.println("▶ Watching Ad " + i + " of " + totalAds);
	            
	            int adDuration;

	            // Keep checking for valid ad duration
	            do {
	                // Re-fetch the ad timer element to ensure it's updated
	                adtimer = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView"));
	                String adDurationText = adtimer.getText(); // Get latest ad text
	                adDuration = extractTimeInSeconds(adDurationText);

	                if (adDuration > 0) {
	                    System.out.println("⏳ Ad " + i + " Duration: " + adDuration + " seconds");
	                    break;
	                }

	                Thread.sleep(1000); // Small wait to re-check

	            } while (adDuration == 0);

	            // Wait dynamically until the ad finishes
	            Thread.sleep(adDuration * 1000);
	            totalWaitTime += adDuration;

	            // Wait for the next ad to load before looping again
	            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='ad-timer']"), "Ad " + (i + 1) + " of " + totalAds));
	        }

	        Extentlogger.info("✅ All ads finished. Total Ad Time Waited: " + totalWaitTime + " seconds");

	    } catch (Exception e) {
	        System.out.println("⚠️ No more ads detected");
	    }
	}

	// Extracts the total number of ads from the ad text
	public static int extractTotalAds(String adText) {
	    Pattern adPattern = Pattern.compile("Ad \\d+ of (\\d+)");
	    Matcher adMatcher = adPattern.matcher(adText);

	    if (adMatcher.find()) {
	        return Integer.parseInt(adMatcher.group(1));
	    }
	    return 1; // Default to 1 if no match is found
	}

	// Extracts ad duration from "Ends in 0:18" (returns seconds)
	public static int extractTimeInSeconds(String adText) {
	    Pattern timePattern = Pattern.compile("Ends in (\\d+):(\\d+)");
	    Matcher timeMatcher = timePattern.matcher(adText);

	    if (timeMatcher.find()) {
	        int minutes = Integer.parseInt(timeMatcher.group(1));
	        int seconds = Integer.parseInt(timeMatcher.group(2));
	        return (minutes * 60) + seconds;
	    }
	    return 0; // Default to 0 if no match is found
	}



	
	
	public void playbtn()
	{
		JSClick(driver, playbtn,"Play button");
	}
	public void pausebtn()
	{
		JSClick(driver,pausebtn,"Pause button");
	}

	public String seekbartiming() 
	{
		return seekbar.getAttribute("aria-valuetext");
	}
	public void forward()
	{
		clickelement(forward);
	}
	public void rewind()
	{
		clickelement(rewind);
	}
	public void fullscreen()
	{
		clickelement(fullscreen);
	}
	public void mutebtn()
	{
		clickelement(mutebtn);
	}
	public void speedbtn()
	{
		clickelement(speed);
	}
	public void speedbackbtn()
	{
		clickelement(speedbeckbtn);
	}
	public void settingbtn()
	{
		clickelement(settingbtn);
	}
	public void countads(WebDriver driver)
	{
//		waitForAdsToFinish(driver, adtimer,skipbtn);
		waitForAdsToFinish(driver);
	}
}

