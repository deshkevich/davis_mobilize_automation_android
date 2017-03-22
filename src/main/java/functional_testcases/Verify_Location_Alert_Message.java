package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import utility.ReadUserData;
import utility.ReadViewName;

public class Verify_Location_Alert_Message {

	private AndroidDriver driver;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private ReadViewName readviewname;
	private Alert_Page alertpage;
	private ReadUserData readUserData;
	private LoginPage loginpage;
	private Account_Page accountPage;

	@Test
	public void Verify_Location_Alert_Message_firstTime() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		newviewscreenpage = new NewViewScreenPage(driver);
		readviewname = new ReadViewName();
		alertpage = new Alert_Page(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		loginpage = new LoginPage(driver);
		accountPage = new Account_Page(driver);
		Thread.sleep(2000);
		try {

			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();

			// Get the Home button and verify is Displayed
			if (homepage.getHomebutton().isDisplayed()) {
				ATUReports.add("Home button is displayed in the home screen ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Home button is not displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			// Get the Add view button verify is Displayed
			if (homepage.getAddbtn().isDisplayed()) {
				ATUReports.add("Add view button is displayed in the home screen ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Add view button is not displayed in the home screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			MobileElement addButton = homepage.getAddbtn();
			// Verify Tap on + tab at bottom bar
			if (addButton != null) {
				if (addButton.isDisplayed()) {
					ATUReports.add("Mobilize Add symbol is displayed ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					addButton.click();
					Thread.sleep(2000);

				} else {

					ATUReports.add("Mobilize Add symbol is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					driver.close();
					return;
				}

			} else {
				ATUReports.add("Add symbol is not displayed in the screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			// Enter View name
			MobileElement viewName = newviewscreenpage.getView_txtfld();
			if (viewName != null) {
				if (viewName.isDisplayed()) {
					ATUReports.add("Mobilize Name is entered in view name text box ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					viewName.sendKeys(readUserData.search);
					Thread.sleep(2000);

				} else {
					ATUReports.add("Mobilize Enter View name text box is  not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					driver.close();
					return;
				}
			} else {
				ATUReports.add("View name text box is not displayed in the screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			// Verify Tap on Add button
			MobileElement nextAddButton = newviewscreenpage.getAddbtn();
			if (nextAddButton != null) {
				if (nextAddButton.isDisplayed()) {
					ATUReports.add("Mobilize Add button  is displayed ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					nextAddButton.click();
					Thread.sleep(2000);
				} else {

					ATUReports.add("Mobilize Add button element is  not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			} else {

				ATUReports.add("Add button is not displayed in the screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driver.close();
				return;

			}
			
			// Verifying tutorial icon
			Thread.sleep(2000);
			Precondition.tutorialDisalogBox();

			
			// Click on Location symbol of GPS information.
			String gps = newviewscreenpage.getgpsText().getText();
			if (gps.isEmpty()) {
				ATUReports.add("Verify the Add GPS informationr text is displayed in the screen", gps, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (gps.contains("Add GPS information")) {
					// Click on Add GPS information location symbol.

					ATUReports.add(
							"Verify the Add GPS information text is displayed in the screen cLicked on location symbol",
							gps, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Verify the Add GPS information text is displayed in the screen", gps, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Clicked on gps informationss
			if(newviewscreenpage.getgpsText()!=null){
				if(newviewscreenpage.getgpsText().isDisplayed()){
					newviewscreenpage.getgpsText().click();
					Thread.sleep(5000);
					ATUReports.add("The gps  message is   dispalyed and click on gps", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("The gps  message is  not dispalyed", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				
				
			}else{
				ATUReports.add("The gps  message is  not dispalyed", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			

			

			// Verify the alert message
			Thread.sleep(2000);
			if(alertpage.getwithLocationUseLocationAlert()!=null){
				if(alertpage.getwithLocationUseLocationAlert().isDisplayed()){
					
				
				String  allowText=alertpage.getwithLctnAltMesge().getText();
				System.out.println(allowText+"--1 text--");
				ATUReports.add("The Allow with  location alert message is dispalyed with text- ",allowText, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				alertpage.getwithLocationAllowBtn().click();
				Thread.sleep(2000);
				}else{
					ATUReports.add("The Allow with location alert message is not dispalyed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}else{
				Thread.sleep(2000);
				if(alertpage.getwithoutLocation()!=null){
					if(alertpage.getwithoutLocation().isDisplayed()){
						Thread.sleep(2000);
					String withoutLocationText=alertpage.getwithoutLocation().getText();
					System.out.println(withoutLocationText+"--2 text--");
					ATUReports.add("The  without  location alert message is dispalyed with text- ",withoutLocationText, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					alertpage.getyesButton().click();
					Thread.sleep(2000);
					}else{
						ATUReports.add("The  without location alert message is not dispalyed", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
				}
					
				}
				
					
					
			}
			
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}

}
