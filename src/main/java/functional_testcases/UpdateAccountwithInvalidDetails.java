package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utility.ReadUserData;
import utility.Read_Frost_Data;

public class UpdateAccountwithInvalidDetails {

	private AndroidDriver driver;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private HomePage homepage;
	private Account_Page accountPage;
	private Alert_Page alertpage;
	
	@Test
	public void UpdateAccountWithInvaliDetails() throws InterruptedException{
		
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		new NewViewScreenPage(driver);
		new Alert_Page(driver);
		loginpage = new LoginPage(driver);
		new NewViewScreenPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		new IrrigationPage(driver);
		homepage = new HomePage(driver);
		new FrostPage(driver);
		new Read_Frost_Data();
		new WeatherPage(driver);
		accountPage = new Account_Page(driver);
		alertpage=new Alert_Page(driver);
		try {

           //Enter user name into user name text box
			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();
			
			
			// Verify to Tap on Account tab
			// Click on Account button
			if (homepage.getAccountbtn() != null) {
				ATUReports.add("Account button is found and clicking on Account button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				homepage.getAccountbtn().click();
				Thread.sleep(2000);

			} else {
				ATUReports.add("Account button is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			
			// Verifying tutorial icon
			Thread.sleep(2000);
			Precondition.tutorialDisalogBox();

			// Verify to tab on edit Icon
			if (accountPage.getsettings() != null) {
				ATUReports.add("Navigated to Settings screen, Settings icon is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				if (accountPage.geteditIcon() != null && accountPage.geteditIcon().isDisplayed()) {
					ATUReports.add("Edit icon element is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					accountPage.geteditIcon().click();
					Thread.sleep(2000);
				} else {
					ATUReports.add("Edit icon element is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			} else {
				ATUReports.add("User not navigated to Settings screen, Settings icon is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);
			

			// get the value of email id
			MobileElement changeEmail = accountPage.geteditEmail();
			String actualEmail = changeEmail.getText();
			
			        // Verify to tab on change email id
						changeEmail.click();
						Thread.sleep(2000);
						driver.findElement(By.id("com.davis.mobilize:id/email_cross_icon")).click();
						Thread.sleep(2000);
				
									
						//Enter valid email id in text box 
						changeEmail.sendKeys(readUserData.invalidEmail);
						Thread.sleep(2000);
						driver.hideKeyboard();

						String expectedEmail = changeEmail.getText();
						if(expectedEmail.contains(readUserData.invalidEmail)){
							ATUReports.add("Entered invalid email id is same as expected"+expectedEmail, actualEmail,expectedEmail, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{

						ATUReports.add("Entered invalid email id is not same as expected "+expectedEmail, actualEmail,expectedEmail, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						Thread.sleep(2000);
						}
						
						
						// Verify Tab on Save button
						MobileElement saveButton = accountPage.getsave();
						String saveText = saveButton.getText();
						if (saveButton.isDisplayed()) {
							saveButton.click();
							ATUReports.add(saveText + " Button is Displayed and Clicked on Save button.", saveText, "Save",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {

							ATUReports.add(saveText + " Button is not Displayed ", saveText, "Save", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
						Thread.sleep(2000);
						
						
						//Verify alert message displayed or not
						MobileElement alertText=accountPage.getalertText();
						String ActualText=alertText.getText();
						
						if (alertText.isDisplayed()) {
							ATUReports.add(ActualText+"- Alert is displayed ",ActualText,"Unable to update profile", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							ATUReports.add("Clicked on ok Button in the Alert,Email id is not updated with invalid email address", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							if(homepage.getalertDelete()!=null){
							homepage.getalertDelete().click();
							Thread.sleep(2000);
							}else{
								ATUReports.add("NO Alert ok buuton is not  dispalyed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

						} else {
							ATUReports.add("NO Alert is dispalyed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}
						
						
						/*//Verify to enter empty mail
						//Enter valid email id in text box 
						changeEmail.sendKeys(" ");
						Thread.sleep(2000);
						//driver.hideKeyboard();
						
						if(expectedEmail.contains(" ")){
							ATUReports.add("Entered empty email id is same as expected"+expectedEmail, actualEmail,expectedEmail, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{

						ATUReports.add("Entered empty email id not same as expected "+expectedEmail, actualEmail,expectedEmail, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						Thread.sleep(2000);
						}
						Thread.sleep(2000);*/
						

		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void clickonNextButton() throws InterruptedException
	{
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		}else{
			driver.quit();
		}
	}
}



























/*	//Click on edtit icon
accountPage.geteditIcon().click();


//Verify to tab on change email id
changeEmail.click();
Thread.sleep(2000);
changeEmail.clear();
Thread.sleep(2000);
*/


/*	
//Enter valid email id in text box 
changeEmail.sendKeys(readUserData.emailid);
Thread.sleep(2000);
driver.hideKeyboard();

String expectedEmail = changeEmail.getText();

ATUReports.add("Changed Email name is - "+expectedEmail, actualEmail,expectedEmail, LogAs.PASSED,
		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

Thread.sleep(2000);*/











/*//Verify email id update successfully or not


String expectedEmaiUpdated = changeEmail.getText();

if(expectedEmaiUpdated.contains(readUserData.emailid)){
	
	ATUReports.add(expectedEmaiUpdated + "  is  same as expected email updated succesfully", expectedEmaiUpdated, readUserData.emailid,
			LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
}else{
ATUReports.add(expectedEmaiUpdated + "  is not same as expected email ", expectedEmaiUpdated, readUserData.emailid,
		LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
}*/
