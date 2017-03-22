package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.Log;
import utility.ReadUserData;
import utility.Read_Change_Password;

public class Verify_Change_Password {
	private AndroidDriver driver;
	private HomePage homepage;
	private Account_Page accountpage;
	private Settings_page settingspage;
	private Read_Change_Password readchangepassword;
	public String currentpassword, newpassword, confirmpassword, wrgcurpwd, wrngnewpwd, wrocnfpwd;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private Account_Page accountPage;
	private Alert_Page	alertpage;
	//private HomePage homepage;

	// To verify the Change password functionality - we need to change/update
	// the user name and in the excel sheet under change password tab in the
	// second and third rows respectively
	// Assuming the password set is " 4ct65zps "

	@Test
	public void verify_change_password_scenario() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		accountpage = new Account_Page(driver);
		settingspage = new Settings_page(driver);
		readchangepassword = new Read_Change_Password();
		loginpage = new LoginPage(driver);
		new Account_Page(driver);
		readUserData=new ReadUserData();
		readUserData.start();
		accountPage=new Account_Page(driver);
		Thread.sleep(2000);
		
		// Get the values from the change password file
		readchangepassword.start();
		alertpage=new  Alert_Page(driver);
		Log.startTestCase("*****Change password test Case start*****");
		System.out.println("*********** Change password test Case start ********");

		try {

			Thread.sleep(3000);
			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();

			// Verify the Account is displayed in the Home screen
			if (homepage.getAccountbtn().isDisplayed()) {
				ATUReports.add("Account tab button is displayed in the screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Account tab is not displayed in the screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			
		
			// Tap on Account tab(i.e Second tab on bottom bar).
			MobileElement accountButton = homepage.getAccountbtn();
			if (accountButton.isDisplayed()) {
				homepage.getAccountbtn().click();
				Thread.sleep(7000);
				ATUReports.add("Clicked on Account tab in the Home screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			
			// Verifying tutorial icon
			Thread.sleep(2000);
			Precondition.tutorialDisalogBox();

			// Verify Tap on Settings
			MobileElement settings = accountpage.getsettings();
			if (settings.isDisplayed()) {
				ATUReports.add("Settings pop up is dispalyed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				settings.click();
				Thread.sleep(9000);
				ATUReports.add("Clicked on Settings Tab", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				// Tab on Change
				// passwordsettingspage.getChange_Password().click();
				MobileElement changePassword = settingspage.getChange_Password();
				if (changePassword.isDisplayed()) {
					changePassword.click();
					Thread.sleep(5000);
					ATUReports.add("Navigated to Change password screen", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Change password screen is not Displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				currentpassword = readchangepassword.currentpassword;
				confirmpassword = readchangepassword.confimpassword;
				newpassword = readchangepassword.newpassword;
				wrgcurpwd = readchangepassword.wrongcurpassword;
				wrngnewpwd = readchangepassword.wrongnewpassword;
				wrocnfpwd = readchangepassword.wrongconfirmpassword;

				System.out.println("Current Password from method" + currentpassword);
				System.out.println("New Password from method" + newpassword);
				System.out.println("newpassword from method" + newpassword);

				System.out.println("wrgcurpwd" + wrgcurpwd);
				System.out.println("wrocnfpwd" + wrngnewpwd);
				System.out.println("wrocnfpwd" + wrocnfpwd);
				
				

				// Calling the generic method - of change password for Wrong
				// password scenario
				//changepassword(wrgcurpwd, wrngnewpwd, wrocnfpwd);
				// Enter Current password
				accountpage.getcurrent_passwordplaceholder().sendKeys(wrgcurpwd);
				ATUReports.add("Entered the current password", wrgcurpwd, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
	             //Clicked on next button
				settingspage.getChangepwdNxtBtn().click();
				ATUReports.add("Clicked on next button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				Thread.sleep(5000);
				
			   /// Verify the alert message for Incorrect password scenario.
				
				WebElement alert=driver.findElement(By.id("android:id/message"));
				String alertText=alert.getText();
				Thread.sleep(2000);
				ATUReports.add("Alert is present in the screen when entered invalid password", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driver.findElement(By.id("android:id/button1")).click();
				
				accountpage.getCancel().click();
				Thread.sleep(1000);
				
			
				 //Click on Settings button
				accountPage.getsettings().click();
				Thread.sleep(3000);
				System.out.println("Clicked on settings");
				ATUReports.add("Click Settings/Gear button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
	           //Click on log out button
				accountPage.getsettingsLogoutBtn().click();
				System.out.println("Clicked on logout");
				Thread.sleep(4000);
				ATUReports.add("Click Logout button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				
	            //Click on Ok Button
				accountPage.getlogoutAlertOk().click();
				System.out.println("Clicked on ok");
				Thread.sleep(2000);
				ATUReports.add("Click ok button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				//Calling the generic method - of change password for Correct
				//password scenario
			 // changepassword(currentpassword,newpassword,confirmpassword);
				
				
				
				

				
		

			} else {
				ATUReports.add("Settings is not present in the  screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

		} catch (Exception e) {
			// e.printStackTrace();
		}
		Log.startTestCase("****Change password test Case Ended***8");
		System.out.println("*********** Change password test Case Ended ********");

	}

	public void changepassword(String cpassword, String npassword, String confirmpwd) {

		try {

			System.out.println("in the Method current :" + cpassword);
			System.out.println("in the Method  new :" + npassword);
			System.out.println("in the Method  confirm :" + confirmpwd);

			// Enter Current password
			accountpage.getcurrent_passwordplaceholder().sendKeys(cpassword);
			ATUReports.add("Entered the current password", cpassword, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
			
             //Clicked on next button
			settingspage.getChangepwdNxtBtn().click();
			ATUReports.add("Clicked on next button", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
			// Enter new password
			accountpage.getNew_Password().sendKeys(npassword);
			ATUReports.add("Entered the New password", npassword, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			driver.hideKeyboard();

			// Enter the confirm password
			accountpage.getConfirm_Password().sendKeys(confirmpwd);
			ATUReports.add("Entered the New password", confirmpwd, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			driver.hideKeyboard();

			// Click on Save button.
			settingspage.getChangepwdNxtBtn().click();
			//accountpage.getsave().click();
			ATUReports.add("Clicked on next button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			
			
			ATUReports.add("Password changed successfully alert is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}

	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next != null) {
			if (next.isDisplayed()) {
				next.click();
			} else {
				driver.quit();
			}
		}

	}
}
