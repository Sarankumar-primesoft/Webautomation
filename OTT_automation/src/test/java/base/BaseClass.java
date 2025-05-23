package base;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.ExtentReport.ExtentReport;
import com.ExtentReport.Extentlogger;
import com.pom.ActivatetvPage;
import com.pom.Addprofile;
import com.pom.Footersection;
import com.pom.HomepageCarousels;
import com.pom.HomepageHeaders;
import com.pom.Loginpage;
import com.pom.Profilepage;
import com.pom.Searchpage;
import com.pom.Subscriptionpage;
import com.pom.TransactionsPage;
import com.pom.WatchLaterPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop ;
	public static SoftAssert Softassert;
	
	public static Loginpage loginPage;
	public static Profilepage profilepage;
	public static Subscriptionpage subpage;
	public static HomepageHeaders homepageheaders;
	public static Searchpage searchpage;
	public static WatchLaterPage watchlater;
	public static HomepageCarousels homepagecarousels;
	public static TransactionsPage transactionspage;
	public static ActivatetvPage activatetv;
	public static Footersection footersec;
	public static Addprofile addprofile;
	public static WebDriver driver;
	static String BrowserName;
	static String BrowserVersion;
	public static Capabilities capabilities;
	public static JavascriptExecutor js;
	public static Logger logger = null;
		
	public BaseClass() {
		
		PageFactory.initElements(driver, this);
	}

	public static void loadProperties()
	{
		prop = new Properties();
		logger = LogManager.getLogger(BaseClass.class);
		logger.info("Starting Webautomation Test");
		try {
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/Configuration/config.properties"); 
			prop.load(ip);
		} catch (Exception e) {
			throw new RuntimeException("Error loading config.properties", e);
		}
	}
	
	@BeforeSuite
	public void setup() throws IOException
	{
		ExtentReport.invokereport();
		ExtentReport.createTest("Setup Execution");
		
		Softassert = new SoftAssert();
	
		loadProperties();
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();

		String browserName=prop.getProperty("browser");

		if (browserName == null) {
			throw new RuntimeException("Browser property not set in config file!");
		}

		switch (browserName.toLowerCase()) {
	    case "chrome":
	        driver = new ChromeDriver();
			js=(JavascriptExecutor)driver;
	        break;
	    case "firefox":
	        driver = new FirefoxDriver();
	        break;
	    case "microsoftedge":
	        driver = new EdgeDriver();
	        break;
	    default:
	        throw new RuntimeException("Invalid browser name in config file: " + browserName);
	}

		// Initialize capabilities after driver creation
		capabilities = ((RemoteWebDriver) driver).getCapabilities();
		BrowserName = capabilities.getBrowserName();
		BrowserVersion = capabilities.getBrowserVersion();

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", Map.of(
		    "download.default_directory", "C:\\Downloads",
		    "profile.default_content_settings.popups", 0,
		    "profile.content_settings.exceptions.automatic_downloads.*.setting", 1
		));
		options.addArguments("--headless=new"); // or just "--headless" for older versions
		options.addArguments("--window-size=1920,1080"); // IMPORTANT!
		options.addArguments("--disable-gpu"); // Optional but recommended
		
		System.out.println("driver : "+ driver );		

		implicitWait(10);
		pageLoadTimeOut(driver, 40);

		driver.manage().window().maximize();
		launchUrl(driver,prop.getProperty("testurl"));
		if (driver.getTitle().equalsIgnoreCase(prop.getProperty("homepage-title"))) 
		{	
			System.out.println(driver.getTitle());
		}

	}

	@BeforeMethod
	public void home(Method method)
	{
		if (method.getName().equals("TC1_login") || method.getName().equals("TC9_Activatetv")|| method.getName().equals("TC10_Footersection")
				|| method.getName().equals("TC12_videoplaynavi")|| method.getName().equals("TC13_validateplay")
				|| method.getName().equals("TC14_validatepause") || method.getName().equals("TC15_validateforward") 
				|| method.getName().equals("TC16_validaterewind") || method.getName().equals("TC17_validatefullscreen") 
				|| method.getName().equals("TC18_ValidateMute") || method.getName().equals("TC19_validatespeedcontrols") ) 
		{
            System.out.println("Skipping @BeforeMethod for: " + method.getName());
            return;
        }
		System.out.println("Running @BeforeMethod for: " + method.getName());
		driver.get("https://www.etvwin.com/home");
	}
	
	@AfterSuite
	public void tearDown() throws Exception {
		if (driver != null) {
//			loginPage.logout();
			Browserinfo();
			if (loginPage  != null) {
			    driver.quit();
			}
			System.out.println("WebDriver closed.");
			ExtentReport.flushreport();  
		}
	}
	
	public void scrollUntilElementAppears(WebElement ele,String whichele) throws InterruptedException {
	    int maxAttempts = 20; // Limit attempts to avoid infinite loops
	    int attempts = 1;
	    
	    while (attempts < maxAttempts) {
	        try {
	            if (ele.isDisplayed()) {
	            	Extentlogger.info("Element is Visibile, Scrolled to "+whichele);
	            	logger.info("Element is Visibile, Scrolled to "+whichele);
	                return; // Element found, stop scrolling
	            }
	        } catch (Exception ignored) {}

//	        js.executeScript("window.scrollBy(0, 500);"); // Scroll down in small steps
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
//	        Thread.sleep(500); // Wait briefly for the new content to load
	        
	        genericScrollDown();
	        
	        attempts++;
	    }
	    throw new RuntimeException("Element not found after scrolling");
	}
	
	public void genericScrollDown() throws InterruptedException {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    int scrollPauseTime = 500; // ms
	    int scrollStep = 500;      // pixels
	    int maxScrolls = homepagecarousels.count;       // max number of scroll attempts

	    for (int i = 0; i < maxScrolls; i++) {
	        js.executeScript("window.scrollBy(0, arguments[0]);", scrollStep);
	        Thread.sleep(scrollPauseTime);
	    }

	    Extentlogger.info("Scrolled down the page generically for " + maxScrolls + " steps.");
	    logger.info("Scrolled down the page generically for " + maxScrolls + " steps.");
	}

	public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

	public static void navigateback() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().back();
	}
	
	public void assertEquals(String actual, String expected, String ele) {
	    SoftAssert softAssert = new SoftAssert();
	    boolean result = actual.equals(expected);

//	    String elementName = getElementName(ele); // Fetch element name dynamically
	    String logMessage = "Assertion Validation on Element " + ele + ": Expected='" + expected + "', Actual='" + actual + "'";

	    if (result) {
	        Extentlogger.pass(logMessage);
	        logger.info(logMessage);
	    } else {
	        Extentlogger.fail(logMessage);
	        logger.error(logMessage);
	    }
	    softAssert.assertEquals(actual, expected, "Mismatch Found!");
	   	}
	
	public void assertTrue(boolean condition, String ele, String message) {
	    SoftAssert softAssert = new SoftAssert();
	    
	    String logMessage = "Assertion Validation on Element " + ele + ": " + message;
	    
	    if (condition) {
	        Extentlogger.pass(logMessage);
	        logger.info(logMessage);
	    } else {
	        Extentlogger.fail(logMessage);
	        logger.error(logMessage);
	    }
	    
	    softAssert.assertTrue(condition, "Condition Failed: " + message);
	}

	public  void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Extentlogger.info("Scrolled to "+getElementName(ele));
		logger.info("Scrolled to "+getElementName(ele));

	}
	

	public  void clickelement(WebElement element) {
		if (element == null) {
			throw new IllegalStateException("WebElement is null. Ensure PageFactory.initElements() was called.");
		}
		try {
			Waitforclickable(element,10);
			String text = Gettext(element);
			element.click();
			if (!text.isEmpty()) {
				Extentlogger.pass(text + " is Clicked", false);
				logger.info(text + " is Clicked", false);
			}
		} catch (WebDriverException e) {
			System.err.println("Failed to click element: " + e.getMessage());
			Extentlogger.fail(getElementName(element)+ " is not Clicked", false);
			logger.error(getElementName(element)+ " is not Clicked", false);
		}
	}

	public void clickelementwithname(WebElement element,String elename) {
		try {
			 Waitforclickable(element,10);

	            String text = element.getText().isEmpty() ? elename : element.getText();
	            element.click();
	            System.out.println(text + " is Clicked");
	            Extentlogger.pass(text + " is Clicked",true);
	            logger.info(text + " is Clicked",true);
	            
		} catch (Exception e) {
			System.err.println("Failed to click element: "+elename+" " + e.getMessage());
			Extentlogger.fail("Failed to click element: "+elename+" " + e.getMessage(),true);
			logger.error("Failed to click element: "+elename+" " + e.getMessage(),true);
		}
	}

	
	public static void Waitforclickable(WebElement element, int seconds) {
		if (element == null) {
			throw new IllegalArgumentException("Element is null, cannot wait for clickability.");
		}
		new WebDriverWait(driver, Duration.ofSeconds(seconds))
		.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static String Gettext(WebElement element) {
		return element.getText();
	}

	public static Boolean isdisplay(WebElement element) {
		if(!Gettext(element).isEmpty()) {
			Extentlogger.info(Gettext(element)+" is Display: "+element.isDisplayed());
			logger.info(Gettext(element)+" is Display: "+element.isDisplayed());
			return element.isDisplayed();
		}else {
			Extentlogger.info(Gettext(element)+" is not Displayed: "+element.isDisplayed());
			logger.info(Gettext(element)+" is not Displayed: "+element.isDisplayed());
			return element.isDisplayed();
		}
	}	


	public static void sendkeys(WebElement element,String value) 
	{
		element.sendKeys(value,Keys.ENTER);
		String placeholder = Getattribute(element, "placeholder");
		if (placeholder != null && !placeholder.isEmpty()) {
			Extentlogger.pass(value + " is entered in " + placeholder + " successfully", false);
			logger.info(value + " is entered in " + placeholder + " successfully", false);
		}
		else 
		{
			Extentlogger.pass(value + " is entered successfully", false);
			logger.info(value + " is entered successfully", false);
		}
	}
	public static void entersendkeys(WebElement element) 
	{
		element.sendKeys(Keys.ENTER);
	}
	
	private static String Getattribute(WebElement element,String attributename) {
		return element.getAttribute(attributename);
	}

	public static boolean JSClick(WebDriver driver, WebElement ele, String locatorName ) {
		boolean flag = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			flag = true;

		}

		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				System.out.println("Click Action is performed on "+locatorName);
				Extentlogger.info("Click Action is performed on "+locatorName.toString());	
				logger.info("Click Action is performed on "+locatorName.toString());	
			} else if (!flag) {
				System.out.println("Click Action is not performed on "+locatorName);
			}
		}
		return flag;
	}
	public static boolean launchUrl(WebDriver driver,String url) {
		try {
			driver.get(url);
//			System.out.println("Successfully launched \"" + url + "\"");				
			Extentlogger.info("Successfully launched \"" + url + "\"");	
			logger.info("Successfully launched \"" + url + "\"");	
			return true;
		} catch (Exception e) {
//			System.out.println("Failed to launch \"" + url + "\"");
			Extentlogger.info("Failed to launch \"" + url + "\"");
			logger.info("Failed to launch \"" + url + "\"");
			return false;
		}
	}

	public static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public  void visibleofele(WebDriver driver, WebElement element, String elename ) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		Extentlogger.info("Element is Visibile: "+elename);
		logger.info("Element is Visibile: "+elename);
	}

	public static Boolean invisibilityofelement(WebDriver driver, WebElement element,String name ) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		Extentlogger.info(name+" Element is now invisibile");
		logger.info(name+" Element is now invisibile");
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
		Extentlogger.info("Page load timeout.");
		logger.info("Page load timeout.");

	}

	public static String clickRandomElement(List<WebElement> elements) {
		if (elements == null || elements.isEmpty()) {
			System.out.println("No elements found to click.");
			Extentlogger.info("No elements found to click.");
			logger.info("No elements found to click.");
			return null;
		}
		Random random = new Random();
		System.out.println(elements.size()); 
		int randomIndex = random.nextInt(elements.size()); // Selects a random index
		WebElement randomElement = elements.get(randomIndex);
		System.out.println(randomElement);
		System.out.println("random index"+randomIndex);
		System.out.println(randomElement.getAttribute("alt"));
		return randomElement.getAttribute("alt");
	}

	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
	    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new java.util.Date());	
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String directory = System.getProperty("user.dir") + "/Screenshots/";
	    new File(directory).mkdirs(); // Ensure the directory exists
	    String destination = directory + screenshotName + dateName + ".png";
	    File finalDestination = new File(destination);
	    FileUtils.copyFile(source, finalDestination);
	    return destination; 
	}
	
	public String getElementName(WebElement element) {
	    try {
	        for (Field field : this.getClass().getDeclaredFields()) {
	            field.setAccessible(true);
	            if (field.get(this) == element) {
	                return field.getName();
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "UnknownElement";
	}
	
	public void switchframe(WebElement element) {
		driver.switchTo().frame(element);
		}
	
	public static void Browserinfo() {
		ExtentReport.extent.setSystemInfo("URL",prop.getProperty("testurl"));
		ExtentReport.extent.setSystemInfo("Username",prop.getProperty("username"));
		ExtentReport.extent.setSystemInfo("Password",prop.getProperty("password"));
		
		ExtentReport.extent.setSystemInfo("Browser Name",BrowserName);
		ExtentReport.extent.setSystemInfo("Browser Version",BrowserVersion);
	}


}

