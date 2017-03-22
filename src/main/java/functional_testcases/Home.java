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

public class Home {
	private static AndroidDriver driver;
	private static LoginPage loginpage;
	private HomePage homepage;
	private static ReadUserData readUserData;
	private static Alert_Page	alertpage;
	@Test
	public void verify_Homescreen_UI() throws InterruptedException {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		loginpage = new LoginPage(driver);
		new ReadUserData();
		homepage = new HomePage(driver);
		readUserData =new ReadUserData();
		readUserData.start();
		alertpage=new Alert_Page(driver);
		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");

		Log.startTestCase("Home test Case start");
		System.out.println("*********** Home test Case start ********");

		
		
		try {
			
			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();
			
		   //Verify search functionality
			Thread.sleep(2000);
			searchMethod();
		
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	
	//This method is used to verify loading page and continue remaining execution

		public void searchMethod() throws InterruptedException{
			MobileElement searchBox = homepage.getSearchtxtfield();	
			if (searchBox != null) {
				if (searchBox.isDisplayed()) {
					ATUReports.add("Mobilize search box is displayed at app header.", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Mobilize search box is not displayed at app header.", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}else{
				ATUReports.add("Mobilize search box  element is not  displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify 3 tabs at bottom bar i.e Home tab, Account tab and Add new
			// view tab are Displayed
			// Get the Home button and verify is Displayed
			if (homepage.getHomebutton() != null) {
			if (homepage.getHomebutton().isDisplayed()) {
				ATUReports.add("Home button is displayed in the home screen ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Home button is not displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			}else{
				ATUReports.add("Home button element is not  displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			// Get the Account button and verify is Displayed
			if (homepage.getAccountbtn() != null) {
			if (homepage.getAccountbtn().isDisplayed()) {
				ATUReports.add("Account button is displayed in the home screen ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Account button is not displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			}else{
				ATUReports.add("Account button element is not  displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			// Get the Add view button verify is Displayed
			if (homepage.getAddbtn() != null) {
			if (homepage.getAddbtn().isDisplayed() ) {
				ATUReports.add("Add view button is displayed in the home screen ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Add view button is not displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			}else{
				ATUReports.add("Add view button element is not  displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			Log.startTestCase("Home test Case Ended");
			System.out.println("*********** Home test Case Ended ********");
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
		
		

}