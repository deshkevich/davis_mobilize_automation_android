package functional_testcases;

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

public class Search {

	private AndroidDriver driver;
	private HomePage homepage;
	private LoginPage loginpage;
	private ReadUserData readUserData;

	@SuppressWarnings("deprecation")
	@Test
	public void Verify_the_search_keyword_dismissed() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();

		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");

		Log.startTestCase("Search test Case start");
		System.out.println("*********** Search test Case start ********");

		try {

			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();

			// Verify Tap on search box
			MobileElement searchBox = homepage.getSearchtxtfield();

			if (searchBox != null) {
				if (searchBox.isDisplayed()) {
					searchBox.click();
					Thread.sleep(3000);

					// Enter keyword to search view.
					homepage.getSearchTextBox().sendKeys(readUserData.search);
					System.out.println(readUserData.search + "---readUserData.search--");
					ATUReports.add("Tab on search box and Wine as given as search keyword", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(7000);
					driver.hideKeyboard();

				/*	// Verify the list of views displayed related to search
					// keyword or not
					MobileElement pageText = (MobileElement) driver
							.findElement(By.id("com.davis.mobilize:id/view_name"));
					String pageTextActual = pageText.getText();
					if (pageTextActual.equalsIgnoreCase(readUserData.search)) {

						ATUReports.add("Entered text is displayed from the search result", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Entered text is not displayed from the search result", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}*/

				} else {
					ATUReports.add("search box is not displayed in current page", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					driver.close();
					return;
				}
			}

			// Now tap on (x) cross button
			if (homepage.getSearchtxtfield().isDisplayed() || homepage.getSearchtxtfield().isEnabled()) {
				homepage.getSearchtxtfield().click();
				Thread.sleep(3000);
				ATUReports.add("Cleared the search result by tapping on X button in the search field", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Clear button is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		Log.startTestCase("Search test Case Ended");
		System.out.println("*********** Search test Case Ended ********");
	}

	// This method used to click on next button
	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}

}
