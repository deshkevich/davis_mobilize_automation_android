package functional_testcases;

import Pages.Alert_Page;
import Pages.LoginPage;
import Pages.SignUpPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import utility.ReadNewUserDetails;
import utility.ReadUserData;

public class Forgot_Password {

	private SignUpPage signuppage ; 
	private AndroidDriver driver ;
	private LoginPage loginpage ;
	private Alert_Page alertpage ;
	private ReadUserData readUserData;
	private ReadNewUserDetails readnewuserdetails ;
@Test
	public void forgot_username(){


		try {
			driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
			signuppage = new SignUpPage(driver);
			loginpage = new LoginPage(driver);
			alertpage = new Alert_Page(driver);
			readUserData=new ReadUserData();
			readUserData.start();
			readnewuserdetails = new ReadNewUserDetails();
			readnewuserdetails.start();
			
			//Click on loginpage text.
			ATUReports.add("Clicked on Login text", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			//Enter any value	username.sendKeys(readUserData.sUserName);
			loginpage.getUserNametxtbx().sendKeys(readUserData.sUserName);

			String username = loginpage.getUserNametxtbx().getText();
			if(username.isEmpty()){
				ATUReports.add("Verify the Mobilize logo text", "xcube", username,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (username.equals(readUserData.sUserName)) {
					ATUReports.add("Mobilize logo is displayed", "xcube", username,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Verify the Mobilize logo text", "xcube", username,LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}	

			//Click on Next button
			loginpage.getNextButton().click();
			
			// enter password in the Password in the  text box
			loginpage.getpasswordtxtbx().sendKeys(readnewuserdetails.Invalid_password);
			ATUReports.add("password entered in the text box",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
			//Click on Next button
			loginpage.getNextButton().click();
			Thread.sleep(3000);
			
			//hide The keyboard
			//driver.hideKeyboard();
			
			//Verify the error message
			String error =  alertpage.getloginpageInvalidPwdAlert().getText();
			if(error.isEmpty()){
				ATUReports.add("Next button is not displayed in the screen ", "Error", error,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (error.equals("Error")) {
					ATUReports.add("Next button is displayed in the screen ", "Error", error,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					ATUReports.add("Next button is not displayed in the screen ", error,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			
			//Verify the error caption message
			String errormessage = alertpage.getemailAlert().getText();
			if(errormessage.isEmpty()){
				ATUReports.add("Next button is not displayed in the screen ", "Wrong password", errormessage,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}else{
				if (errormessage.equals("Wrong password")) {
					ATUReports.add("Next button is displayed in the screen ", "Wrong password", errormessage,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					ATUReports.add("Next button is not displayed in the screen ", errormessage,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			
			//Click on ok Button
			alertpage.getacceptAlertt().click();
			ATUReports.add("Clicked on Ok Button in the alert box",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
