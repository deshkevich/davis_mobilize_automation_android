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
import utility.Read_Frost_Data;

public class UpdateAccountWithValidDetails {

	private AndroidDriver driver;
	private LoginPage loginpage;
	private NewViewScreenPage newscreenpage;
	private ReadUserData readUserData;
	private IrrigationPage irrigationPage;
	private HomePage homepage;
	private FrostPage frostPage;
	private Read_Frost_Data readFrostData;
	private WeatherPage weatherPage;
	private Account_Page accountPage;

	@Test
	public void updateValidDetails() {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		new NewViewScreenPage(driver);
		new Alert_Page(driver);
		loginpage = new LoginPage(driver);
		newscreenpage = new NewViewScreenPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		irrigationPage = new IrrigationPage(driver);
		homepage = new HomePage(driver);
		frostPage = new FrostPage(driver);
		readFrostData = new Read_Frost_Data();
		weatherPage = new WeatherPage(driver);
		accountPage = new Account_Page(driver);

		try {
			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();
			
		
			// Verify to Tap on Account tab
			if (homepage.getAccountbtn() != null) {
				ATUReports.add("Account button is found and clicking on Account button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				homepage.getAccountbtn().click();
				Thread.sleep(2000);

			} else {
				ATUReports.add("Account button is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}		
			Thread.sleep(3000);
			
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

				} else {
					ATUReports.add("Edit icon element is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("User not navigated to Settings screen, Settings icon is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

		
			Thread.sleep(2000);
			// Verify to change profile picture
			MobileElement changePicture = accountPage.getprofilePicture();
			if (changePicture.isDisplayed()) {
				ATUReports.add("Profile picture is displayed ,Clicked on profile picture ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				changePicture.click();

			} else {
				ATUReports.add("Profile picture is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// Click on Choose from library
			MobileElement chooseFromLibrary = accountPage.getchooseFromLibrary();
			String text = chooseFromLibrary.getText();
			if (chooseFromLibrary.isDisplayed()) {
				ATUReports.add(text + " is displayed " + text, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			} else {
				ATUReports.add(text + " is displayed  " + text, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			accountPage.gettcancelButtonInChangePhoto().click();
			Thread.sleep(3000);
			

			// get the value of first name
			MobileElement changeName = accountPage.geteditFirstName();
			String actualFirstName = changeName.getText();

			// get the value of email id
			MobileElement changeEmail = accountPage.geteditEmail();
			String actualEmail = changeEmail.getText();

			// Verify to tab on change first name
			changeName.click();
			Thread.sleep(2000);
			changeName.clear();
			Thread.sleep(2000);
			changeName.sendKeys(readUserData.Firstname);
			Thread.sleep(2000);

			String expectedName = changeName.getText();

			ATUReports.add("First name is changed -"+expectedName, actualFirstName,expectedName, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Verify to tab on change email id
			changeEmail.click();
			Thread.sleep(2000);
			changeEmail.clear();
			Thread.sleep(2000);
			changeEmail.sendKeys(readUserData.emailid);
			Thread.sleep(2000);
			driver.hideKeyboard();

			String expectedEmail = changeEmail.getText();

			ATUReports.add("Changed Email name is - "+expectedEmail, actualEmail,expectedEmail, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			Thread.sleep(2000);

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

		} catch (InterruptedException i) {
			i.printStackTrace();
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




























//driver.findElement(By.className("android.widget.ImageButton")).click();
//System.out.println("image button is clicked");
/*// Verify to select a particular image from list
Thread.sleep(2000);

MobileElement imageOne = (MobileElement) driver
		.findElement(By.xpath("//android.widget.RelativeLayout[@clickable='True']"));
imageOne.click();
Thread.sleep(2000);

MobileElement imageTWo = (MobileElement) driver
		.findElement(By.xpath("//android.view.View[@clickable='True']"));
imageTWo.click();
Thread.sleep(5000);
ATUReports.add("Select image from the list and clicked on image,Profile image is updated succsfully.",
		LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
