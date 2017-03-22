
package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.Log;
import utility.Read_Frost_Data;

import java.net.MalformedURLException;
import java.util.List;

public class FrostPage_All_Screens_Pagination_SetUp{

	private AndroidDriver driver;
	private Read_Frost_Data readFrostData;
	private FrostPage frostPage;
	private WeatherPage weatherPage;
	private Account_Page accountPage;
	private HomePage homepage ;
	@SuppressWarnings("unused")
	@Test
	public void createView() throws MalformedURLException, InterruptedException {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		new NewViewScreenPage(driver);
		readFrostData = new Read_Frost_Data();
		frostPage = new FrostPage(driver);
		weatherPage = new WeatherPage(driver);
		accountPage=new Account_Page(driver);
		Thread.sleep(2000);
		homepage = new HomePage(driver);
		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");

		Log.startTestCase("FrostPage_All_Screens_UI_SetUp test Case start");
		System.out.println("*********** FrostPage_All_Screens_UI_SetUp test Case start ********");

		// Get the values from frost data file
		readFrostData.start();
		try {
			
			
			Thread.sleep(5000);
	        // Calling precondition
			Create_view addClass = new Create_view();
			addClass.createView();
			Thread.sleep(3000);

				
			  // Verify tap on crop title-we are using generic code for titles bcs titles paths are changing from one to another.
						Thread.sleep(1000);
						List <WebElement> weatherTitle=driver.findElements(By.id("com.davis.mobilize:id/report_text"));		
						System.out.println(weatherTitle.size()+"----size----");	
						for(int i=0;i<=weatherTitle.size();i++){
							String weatherTitleText =weatherTitle.get(i).getText();
							System.out.println(weatherTitleText + "---accessabilityid---");							
							if (weatherTitleText.contains("FROST")) {
								ATUReports.add("Mobilize " + weatherTitleText + "  tab is displayed.", "FROST", weatherTitleText,
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								weatherTitle.get(i).click();
								
								Thread.sleep(2000);
								ATUReports.add("Mobilize FROST tab is clicked", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								break;
							} else {
								ATUReports.add("Mobilize Report title " + weatherTitleText + " tab is not displayed", "FROST",
										weatherTitleText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));							
							}
							
						}
						

			// Verify Observe application navigated to Sensor Input screen and

			String frost_sensor_title = frostPage.getTitletxt().getText();
			if (frost_sensor_title.isEmpty()) {
				ATUReports.add("Verify the SENSOR INPUT text  in the screen ", readFrostData.titleTextTwo,
						frost_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (frost_sensor_title.equals(readFrostData.titleTextTwo)) {
					ATUReports.add("SENSOR INPUT is displayed in the screen ", readFrostData.titleTextTwo,
							frost_sensor_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("SENSOR INPUT is not  displayed in the screen ", frost_sensor_title, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify Now select Device and Sensors from drop down list.
			//Select any option from device drop down - 
			//frostpage.getDevicestxt().click();
			frostPage.getDevicedropdown().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			//Select any option from sensor drop down
			//frostpage.getSensortxt().click();
			frostPage.getSensordropdown().click();
			ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Verify sensor input screen pagination dots
			MobileElement paginationDots = weatherPage.getPageindicator();
			if (paginationDots != null) {

				if (paginationDots.isDisplayed()) {
					ATUReports.add("Pagination dots is Displayed in " + readFrostData.titleTextTwo + " page",
							readFrostData.titleTextTwo, frost_sensor_title, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Pagination dots is not Displayed in " + readFrostData.titleTextTwo + " page",
							frost_sensor_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			} else {
				driver.close();
			}

			MobileElement skipButton = frostPage.getNext_nxt_save_btn();
			skipButton.click();
			Thread.sleep(2000);

			// Verify Threshold page heading text
			String frost_thresholdTitle = frostPage.getTitletxt().getText();
			if (frost_thresholdTitle.isEmpty()) {
				ATUReports.add("Verify the Frost threshold text  in the screen ", readFrostData.titleTextThree,
						frost_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (frost_thresholdTitle.equals(readFrostData.titleTextThree)) {
					ATUReports.add("Frost threshold is displayed in the screen ", readFrostData.titleTextThree,
							frost_thresholdTitle, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Frost threshold is not  displayed in the screen ", readFrostData.titleTextThree,
							frost_thresholdTitle, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify Threshold page pagination dots.
			MobileElement paginationDotsTwo = weatherPage.getPageindicator();
			if (paginationDotsTwo != null) {

				if (paginationDotsTwo.isDisplayed()) {
					ATUReports.add("Pagination dots is Displayed in " + readFrostData.titleTextThree + " page",
							readFrostData.titleTextThree, frost_thresholdTitle, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Pagination dots is not Displayed in " + readFrostData.titleTextThree + " page",
							frost_thresholdTitle, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				driver.close();
			}

		
			skipButton.click();
			Thread.sleep(2000);
			
			// Verifying tutorial icon
				Thread.sleep(2000);
			Precondition.tutorialDisalogBox(); 
			

			// Verify frost warning page heading text
			String frost_Warning = frostPage.getTitletxt().getText();
			if (frost_Warning.isEmpty()) {
				ATUReports.add("Verify the Frost warning text  in the screen ", readFrostData.titleTextFour,
						frost_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (frost_Warning.equals(readFrostData.titleTextFour)) {
					ATUReports.add("Frost warning is displayed in the screen ", readFrostData.titleTextFour,
							frost_Warning, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Frost warning is not  displayed in the screen ", readFrostData.titleTextFour,
							frost_Warning, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify frost warning page pagination dots.
			MobileElement paginationDotsThree = weatherPage.getPageindicator();
			if (paginationDotsThree != null) {

				if (paginationDotsThree.isDisplayed()) {
					ATUReports.add("Pagination dots is Displayed in " + readFrostData.titleTextFour + " page",
							readFrostData.titleTextFour, frost_Warning, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Pagination dots is not Displayed in " + readFrostData.titleTextFour + " page",
							frost_Warning, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
			} else {
				driver.close();
			}

		
		skipButton.click();
	 Thread.sleep(3000);
			
		
		
			// Verify Save the frost setup
			MobileElement saveButton =frostPage.getNext_nxt_save_btn();
			if (saveButton != null) {
				String saveText = saveButton.getText();
				if (saveButton.isDisplayed()) {
					if (saveText.equals(readFrostData.ButtonTextThree))

						ATUReports.add("Clicked on  " + saveText + " button in frost set up page",
								readFrostData.ButtonTextThree, saveText, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					saveButton.click();
					Thread.sleep(4000);

				} else {
					ATUReports.add("Mobilize " + saveText + " button is not displayed.", readFrostData.ButtonTextThree,
							saveText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				driver.close();
				return;
			}
			
			// Verifying tutorial icon
			Thread.sleep(2000);
		    Precondition.tutorialDisalogBox();
		    
			
			//Click on Manage Account    				
			homepage.getAccountbtn().click();
			ATUReports.add("Clicked on account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(4000);
			
			
			// Verifying tutorial icon
			Thread.sleep(2000);
		    Precondition.tutorialDisalogBox();
			
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
			

			Log.startTestCase("****FrostPage_All_Screens_UI_SetUp test Case Ended***");
			System.out.println("***********FrostPage_All_Screens_UI_SetUp test Case Ended ********");
			
			
			

		} catch (Exception e) {

		}
	}

}
