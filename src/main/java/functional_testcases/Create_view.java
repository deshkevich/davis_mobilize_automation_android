package functional_testcases;

import Pages.Alert_Page;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
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
import utility.ReadViewName;

import java.net.MalformedURLException;

public class Create_view {

	private AndroidDriver driver;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private LoginPage loginpage;
	private ReadUserData readUserData;	
     private Alert_Page alertpage;
     
	@Test
	public void createView() throws MalformedURLException, InterruptedException {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		newviewscreenpage = new NewViewScreenPage(driver);
		new ReadViewName();
		loginpage = new LoginPage(driver);
		readUserData=new ReadUserData();
		readUserData.start();
		alertpage =new Alert_Page(driver);
		Thread.sleep(1000);
		
		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");

		Log.startTestCase("create view  test Case start");
		System.out.println("*********** create view Case start ********");

		try {
			
			    Thread.sleep(2000);
			    // Calling precondition
				Precondition addClass = new Precondition();
				addClass.precondition();
				
				
				

			// Verify the Add button is displayed in the Home screen
			MobileElement addButton = homepage.getAddbtn();

			// Verify Tap on + tab at bottom bar
			if (addButton != null) {
				if (addButton.isDisplayed()) {
					ATUReports.add("Mobilize Add symbol is displayed ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					addButton.click();
					Thread.sleep(3000);
					

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
					Thread.sleep(3000);
					
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
					ATUReports.add("Mobilize Add button  is displayed & clicked on Add button,view is created in the current screen after click on Add button", LogAs.PASSED,
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
			  
			
			//Verifying tutorial icon
			Precondition.tutorialDisalogBox();		
			

		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
		}
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



































/* if(newviewscreenpage.getMap().isDisplayed()){
ATUReports.add("Add GPS information element is displayed ", LogAs.PASSED,
		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
newviewscreenpage.getMap().click();
Thread.sleep(2000);
MobileElement backButton = newviewscreenpage.getCanceltxt();
backButton.click();			
Thread.sleep(4000);


}else{
ATUReports.add("Add GPS information element is  not displayed", LogAs.FAILED,
		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));			
}*/

 
