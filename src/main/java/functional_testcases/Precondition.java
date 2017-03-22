package functional_testcases;

import Pages.Alert_Page;
import Pages.HomePage;
import Pages.LoginPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import utility.Log;
import utility.ReadUserData;

public class Precondition {
	private static AndroidDriver driver;
	private static LoginPage loginpage;
	private static HomePage homepage;
	private static ReadUserData readUserData;
	private static Alert_Page alertpage;

	@Test
	public void precondition() throws InterruptedException {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		loginpage = new LoginPage(driver);
		new ReadUserData();
		homepage = new HomePage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		alertpage = new Alert_Page(driver);
		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");

		Log.startTestCase("Precondtion test Case start");
		System.out.println("*********** Precondtion test Case start ********");

		try {

			// re launch the app
			Thread.sleep(20000);
			driver.resetApp();
			//Thread.sleep(10000);

			// enter name in the username text box
			MobileElement username = loginpage.getUserNametxtbx();
			if (username.isDisplayed()) {
				ATUReports.add("Mobilize user name is entered into user name textbox", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				username.sendKeys(readUserData.sUserName);
				driver.hideKeyboard();
			} else {
				driver.quit();
				return;
			}

			// Click on Next button
			clickonNextButton();
			Thread.sleep(2000);

			// enter password in the Password in the text box

			MobileElement password = loginpage.getpasswordtxtbx();
			if (password.isDisplayed()) {
				loginpage.getpasswordtxtbx().click();
				Thread.sleep(200);
				ATUReports.add("Mobilize user password is entered into user password textbox", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				password.sendKeys(readUserData.sPassword);
				driver.hideKeyboard();
				Thread.sleep(3000);

			} else {
				driver.quit();
				return;

			}

			// Click on Next button
			clickonNextButton();
			Thread.sleep(20000);

			// Close pop up Alert_Page alert page
			ATUReports.add("Mobilize create view tutorial is displayed", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			alertpage.getcloseIcon().click();
			Thread.sleep(200);
			
			
			
			//verifying tutorials
			tutorialDisalogBox();
					
			//verifying tutorial two 
			tutorialNotificationFlag();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This method used to click on next button
	public static void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}
	
	//This method is used to verify tutorial pop up text and buttons and close icons
	public static void tutorialDisalogBox() throws InterruptedException{
		
		if(homepage.getdialogBox()!=null){
			if(homepage.getdialogBox().isDisplayed()){
				String tutorialText=homepage.gettutorialMessage().getText();
				String tutorialButton=homepage.gettutorialNext1().getText();
				ATUReports.add("Mobilize tutorial dialog box "+tutorialText+ "is displayed in home page with  "+tutorialButton+" button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				Thread.sleep(2000);
				homepage.gettutorialCoseIcon().click();
				Thread.sleep(2000);
			}else{
				ATUReports.add("Mobilize tutorial dialog box is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			}else{
				ATUReports.add("Mobilize Notification tutorial dialog box in home page is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
	}
	
	//This method is used to verify tutorial pop up text and buttons and close icons
	public static void tutorialNotificationFlag() throws InterruptedException{
		if(homepage.getdialogBox()!=null){
			if(homepage.getdialogBox().isDisplayed()){
				String tutorialText=homepage.gettutorialMessage().getText();
				String tutorialButton=homepage.gettutorialNext1().getText();
				ATUReports.add("Mobilize tutorial dialog box "+tutorialText+ "is displayed with  in home page "+tutorialButton+" button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				Thread.sleep(2000);
				homepage.gettutorialCoseIcon().click();
				Thread.sleep(2000);
			}else{
				ATUReports.add("Mobilize tutorial dialog box is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
	 }else{
		 ATUReports.add("Mobilize tutorial dialog box is not displayed with notification flag alert in home page", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
	 }
	}
	
	
	

}
