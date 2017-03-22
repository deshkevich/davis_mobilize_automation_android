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
import utility.Read_FrostPageThresholdValues;
import utility.Read_Frost_Data;

public class PreferencesList {

	private AndroidDriver driver;
	private LoginPage loginpage;
	@SuppressWarnings("unused")
	private NewViewScreenPage newscreenpage;
	private ReadUserData readUserData;
	private HomePage homepage;

	private FrostPage frostPage;
	private Read_Frost_Data readFrostData;
	private WeatherPage weatherPage;
	private Read_FrostPageThresholdValues readfrost;
	private Account_Page accountPage;
	@SuppressWarnings({ "unused", "unused" })
	private Alert_Page alertpage;

	@Test
	public void preferences() {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		newscreenpage = new NewViewScreenPage(driver);
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		new IrrigationPage(driver);
		homepage = new HomePage(driver);
		frostPage = new FrostPage(driver);
		readFrostData = new Read_Frost_Data();
		readFrostData.start();
		weatherPage = new WeatherPage(driver);
		readfrost = new Read_FrostPageThresholdValues();
		readfrost.start();
		accountPage = new Account_Page(driver);
		new FrostPage(driver);
		alertpage = new Alert_Page(driver);
		try {

			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();

			// Click on Account button
			if (homepage.getAccountbtn().isDisplayed()) {
				ATUReports.add("Account button is found and clicking on Account button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				homepage.getAccountbtn().click();
				Thread.sleep(3000);

			} else {
				ATUReports.add("Account button is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			// Verifying tutorial icon
			Thread.sleep(2000);
			Precondition.tutorialDisalogBox();

			// Click on preferences
			MobileElement preferences = accountPage.getpreferecnes();
			if (preferences.isDisplayed()) {
				ATUReports.add("Preferences is Displayed and Clicked on prefrences", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(1000);
				preferences.click();
				Thread.sleep(2000);
			} else {
				ATUReports.add("preferences tab is not Displayed ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify user selected units from preferences.
			Thread.sleep(3000);
			MobileElement list = frostPage.getpreferencesList();
			if (list.isDisplayed()) {
				ATUReports.add("Users preferences list is displayed", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				/*if(frostPage.getTimeLablePrefrences().isDisplayed()){
					ATUReports.add(frostPage.getTimeLablePrefrences().getText()+" in users preferences list ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					frostPage.gettimeFirstRadioButtons().isDisplayed();
				}
				*/
				
				
			} else {
				ATUReports.add("Users preferences list is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driver.close();
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
