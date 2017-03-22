package functional_testcases;

import Pages.Account_Page;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Account {
	private AndroidDriver driver;
	private Pages.HomePage homepage;
	private utility.ReadUserData readUserData;
	private Pages.LoginPage loginpage;
	private Account_Page accountPage;
	@SuppressWarnings("deprecation")
	@Test
	public void account() throws InterruptedException {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		new Pages.FrostPage(driver);
		homepage = new Pages.HomePage(driver);
		accountPage = new Account_Page(driver);
		Thread.sleep(9000);
		readUserData = new utility.ReadUserData();
		readUserData.start();
		loginpage = new Pages.LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click on login text in the home screen.
		try {

			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();

			// Click on Accounts button

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
			Precondition.tutorialDisalogBox();
			String viewsText = accountPage.getviews().getText();

			// Click on view
			// verify the views is displayed
			if (accountPage.getviews() != null) {
				ATUReports.add("Views Button is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				if (viewsText.contains("VIEWS")) {
					ATUReports.add(
							viewsText + " Button is noticed in the screen and Clicked on-" + viewsText + " button",
							"VIEWS", viewsText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					accountPage.getviews().click();
					Thread.sleep(3000);
				} else {
					ATUReports.add("VIEWS Button is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Click on sharing
			MobileElement sharing = accountPage.getsharing();
			String subListTextOne = sharing.getText();
			if (subListTextOne.contains("Sharing")) {
				ATUReports.add(subListTextOne + " Text is displayed same as expected and clicked on sharing ",
						"Sharing", subListTextOne, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				sharing.click();
				Thread.sleep(3000);
				System.out.println("Clicked on Sharing");
				Thread.sleep(1000);
			} else {
				ATUReports.add(subListTextOne + " Text is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Click on Following
			// verify the following is displayed
			MobileElement following = accountPage.getfollowing();
			String subListText = following.getText();
			// System.out.println(subListText + "---subListText---");
			if (subListText.contains("Following")) {
				ATUReports.add(subListText + " Text is displayed same as expected", "Following", subListText,
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				following.click();
				Thread.sleep(3000);
				System.out.println("Clicked on following ");

				Thread.sleep(1000);

			} else {
				ATUReports.add(subListText + " Text is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			// Click Preferences-PREFERENCES
			MobileElement preferences = accountPage.getpreferecnes();
			String preferenceText = preferences.getText();
			if (preferenceText.contains("PREFERENCES")) {
				ATUReports.add(" Preferences is Displayed and Clicked on prefrences", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
				preferences.click();
				Thread.sleep(2000);

			} else {
				ATUReports.add("preferences tab is not Displayed ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Click on Settings button
			accountPage.getsettings().click();
			Thread.sleep(2000);
			System.out.println("Clicked on settings");

			// Click on log out button
			accountPage.getsettingsLogoutBtn().click();
			System.out.println("Clicked on logout");
			Thread.sleep(2000);

			// Click on Ok Button
			accountPage.getlogoutAlertOk().click();
			System.out.println("Clicked on ok");
			Thread.sleep(2000);

		} catch (Exception e) {

		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// This code is for futur purplose

	/*
	 * //Verify the Sign up text and assert String Sign_up =
	 * loginpage.getsignUptext().getText(); if(Sign_up.isEmpty()){
	 * ATUReports.add("Verify the SignUp text", "Sign up",
	 * Sign_up,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 * 
	 * }else{ if (Sign_up.equals("Sign up")) { ATUReports.add(
	 * "Verify the SignUp text", "Sign up", Sign_up,LogAs.PASSED, new
	 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }else{ ATUReports.add(
	 * "Verify the SignUp text", "Sign up", Sign_up,LogAs.FAILED, new
	 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } }
	 */

	// Read the data from the Excel sheet.

	// String sUserName = readUserData.sUserName;
	// String sPassword = readUserData.sPassword;

	/*
	 * MobileElement devicesTab = accountpage.getdevicesTabAccountPage();
	 * devicesTab.click(); Thread.sleep(3000);
	 * 
	 * // Click on view MobileElement viewTab = accountpage.getviewTab(); String
	 * tabTextOne = viewTab.getText(); if (viewTab.isDisplayed()) {
	 * 
	 * ATUReports.add("View tab is Displayed and Clicked on view tab",
	 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 * viewTab.click(); } else { ATUReports.add("View tab is not Displayed",
	 * LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
	 * 
	 * // Click on preferences MobileElement preferences =
	 * accountpage.getpreferences(); String tabTextTwo = preferences.getText();
	 * if (preferences.isDisplayed()) {
	 * 
	 * ATUReports.add("preferences tab is Displayed and Clicked on sharing tab",
	 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 * preferences.click(); } else { ATUReports.add(
	 * "preferences tab is not Displayed", LogAs.FAILED, new
	 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
	 * 
	 * // Click on Devices MobileElement Devices = accountpage.getdevicesTab();
	 * String tabTextThree = Devices.getText(); if (Devices.isDisplayed()) {
	 * 
	 * ATUReports.add("Devices tab is Displayed and Clicked on following tab",
	 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 * Devices.click(); } else { ATUReports.add("Devices tab is not Displayed",
	 * LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
	 * 
	 * // Verify Settings clicked on settings MobileElement settings =
	 * accountpage.getsettings(); String tabTextFour = Devices.getText(); if
	 * (settings.isDisplayed()) {
	 * 
	 * ATUReports.add("settings tab is Displayed and Clicked on settings tab",
	 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 * settings.click(); } else { ATUReports.add("settings tab is not Displayed"
	 * , LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
	 * Thread.sleep(1000);
	 * 
	 * //Clicked on log out MobileElement logout = accountpage.getlogout();
	 * String tabTextFive = Devices.getText(); if (logout.isDisplayed()) {
	 * 
	 * ATUReports.add("logout  button Displayed and Clicked on logout  button",
	 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 * logout.click(); } else { ATUReports.add("logout  button is not Displayed"
	 * , LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
	 * 
	 * // Click on ok
	 * 
	 * MobileElement logoutOk = accountpage.getlogoutOk(); String tabTextSix =
	 * Devices.getText(); if (logoutOk.isDisplayed()) {
	 * 
	 * ATUReports.add(
	 * "logout ok button is Displayed and Clicked on logout ok button",
	 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 * logoutOk.click(); } else { ATUReports.add(
	 * "logout ok button is not Displayed", LogAs.FAILED, new
	 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
	 * 
	 * }
	 */
	/*
	 * public static RemoteWebDriver wd=null;
	 * 
	 * public static void main(String[] args) throws MalformedURLException {
	 * 
	 * 
	 * wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * 
	 * //Click on login text in the home screen.
	 * wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"))
	 * .click();
	 * 
	 * //Enter user name wd.findElement(By.xpath(
	 * "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATextField[1]"
	 * )).click(); wd.getKeyboard().sendKeys("xcube");
	 * 
	 * //Click on next button wd.findElement(By.xpath(
	 * "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]"
	 * )).click();
	 * 
	 * //Click on password text field. wd.findElement(By.xpath(
	 * "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIASecureTextField[1]"
	 * )).click(); wd.getKeyboard().sendKeys("4ct65zps");
	 * 
	 * //Click on next button wd.findElement(By.xpath(
	 * "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]"
	 * )).click();
	 * 
	 * 
	 * // Click on Accounts button wd.findElement(By.xpath("")).click();
	 * 
	 * //Click on view wd.findElement(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"
	 * )).click();
	 * 
	 * //Click on sharing wd.findElement(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"
	 * )).click();
	 * 
	 * //Click on Following wd.findElement(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]"
	 * )).click();
	 * 
	 * //Click on sharing wd.findElement(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"
	 * )).click();
	 * 
	 * wd.findElement(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]/android.widget.TextView[2]"
	 * )).click(); //Click Preferences
	 * 
	 * wd.findElement(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"
	 * )).click(); //Click on Devices wd.findElement(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[3]"
	 * )).click();
	 * 
	 * //Click on view wd.findElement(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"
	 * )).click();
	 * 
	 * 
	 * //Click on Settings button wd.findElement(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[4]"
	 * )).click();
	 * 
	 * //Click on log out button wd.findElement(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[2]/android.widget.TextView[3]"
	 * )).click(); //Click on Ok Button wd.findElement(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.Button[1]"
	 * )).click();
	 * 
	 * wd.close(); }
	 */
}
