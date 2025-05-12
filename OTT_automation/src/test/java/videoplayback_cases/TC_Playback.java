package videoplayback_cases;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ExtentReport.Extentlogger;
import com.pom.Searchpage;
import com.pom.VideoPlaybackPage;
import base.BaseClass;

public class TC_Playback extends BaseClass {

	VideoPlaybackPage videoplaybackpage;
	
	
	@BeforeClass
	  public void setupTest() throws InterruptedException {
	        videoplaybackpage= new VideoPlaybackPage();  // Initialize profile page
	        
	    	logger = LogManager.getLogger(VideoPlaybackPage.class);
			logger.info("VideoPlayback page test");
	}
	
	@Test(priority = -1)
	public void TC12_videoplaynavi() throws Exception {
		videoplaybackpage.videoplaytest();
		}
	
	@Test(priority = 0)
	public void TC13_validateplay() throws Exception {
		videoplaybackpage.isvideoplaying();
	}
	
	@Test(priority = 1)
	public void TC14_validatepause() {
		videoplaybackpage.isvideopaused();
	}	
	@Test(priority = 2)
	public void TC15_validateforward() throws InterruptedException
	{

		String seekbartimingbeforeforward = videoplaybackpage.seekbartiming();
		System.out.println("Seekbar timing before forward: "+seekbartimingbeforeforward);
		Extentlogger.info("Seekbar timing before forward: "+seekbartimingbeforeforward);
		int initialseconds = videoplaybackpage.convertToSeconds(seekbartimingbeforeforward);
			
		videoplaybackpage.pausebtn();
		videoplaybackpage.forward();
		Thread.sleep(500);
		String seekbartimingafterforward = videoplaybackpage.seekbartiming();
		System.out.println("Seekbar timing after forward: "+seekbartimingafterforward);
		Extentlogger.info("Seekbar timing after forward: "+seekbartimingafterforward);
		int secondsafterforword= videoplaybackpage.convertToSeconds(seekbartimingafterforward );		

		boolean isForwardSuccessfull = videoplaybackpage.forwardedtimecalc(secondsafterforword,initialseconds);
		if (!isForwardSuccessfull) {
	        Assert.fail("Forward did not function correctly!"); 
	    }

	}
	
	@Test(priority = 3)
	public void TC16_validaterewind() throws InterruptedException
	{
		videoplaybackpage.moveforwardfor2min();	
		System.out.println("Seekbar timing before rewind: "+videoplaybackpage.seekbartiming());
		Extentlogger.info("Seekbar timing before rewind: "+videoplaybackpage.seekbartiming());
		int initialseconds = videoplaybackpage.convertToSeconds(videoplaybackpage.seekbartiming());
		
		videoplaybackpage.rewind();
		
		System.out.println("Seekbar timing after rewind: "+videoplaybackpage.seekbartiming());
		Extentlogger.info("Seekbar timing after rewind: "+videoplaybackpage.seekbartiming());
		int secondsafterrewind= videoplaybackpage.convertToSeconds(videoplaybackpage.seekbartiming());		
		
		boolean isRewindSuccessful = videoplaybackpage.rewindedtimecalc(secondsafterrewind,initialseconds);
		if (!isRewindSuccessful) {
	        Assert.fail("Rewind did not function correctly!"); 
	    }

	}
	@Test(priority = 4)
	public void TC17_validatefullscreen() throws InterruptedException
	{
		videoplaybackpage.validatefullscreen();
	}
	@Test(priority = 5)
	public void TC18_ValidateMute() 
	{
		videoplaybackpage.validatemute();
	}
	@Test(priority = 6)
	public void TC19_validatespeedcontrols() throws InterruptedException 
	{
		videoplaybackpage.speedcontrols();
	}
	
}
