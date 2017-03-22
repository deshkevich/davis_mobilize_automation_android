package functional_testcases;

import Pages.FrostPage;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.Log;
import utility.Read_Frost_Data;

import java.util.List;

public class Frost_UI_Navigation_Flow {

	private AndroidDriver driver;
	private FrostPage frostPage;
	private NewViewScreenPage newviewscreenpage;
	private Read_Frost_Data readFrostData;
	@SuppressWarnings("unused")
	@Test
	public void addingCrop() {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		new HomePage(driver);
		newviewscreenpage = new NewViewScreenPage(driver);
		new LoginPage(driver);
		frostPage = new FrostPage(driver);
		readFrostData=new Read_Frost_Data();
		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");

		Log.startTestCase("Frost navigation test Case start");
		System.out.println("**********Frost navigation test Case start ********");
		
		
		//Get the values from frost data file
		readFrostData.start();

		try {

			//Calling precondition
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
			// Next is disabled.
			String frost_sensor_title = frostPage.getTitletxt().getText();
			if (frost_sensor_title.isEmpty()) {
				ATUReports.add("Verify the SENSOR INPUT text  in the screen ",readFrostData.titleTextTwo, frost_sensor_title,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (frost_sensor_title.equals(readFrostData.titleTextTwo)) {
					ATUReports.add("SENSOR INPUT is noticed in the screen ",readFrostData.titleTextTwo, frost_sensor_title,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("SENSOR INPUT is not observed in the screen ", frost_sensor_title, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			//Select any option from device drop down - 
			//frostpage.getDevicestxt().click();
			frostPage.getDevicedropdown().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			//Select any option from sensor drop down
			//frostpage.getSensortxt().click();
			frostPage.getSensordropdown().click();
			ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Verify Observe Next button is Enabled.
			if (frostPage.getNext_nxt_save_btn().isEnabled()) {
				//frostPage.getNext_nxt_save_btn().click();
				ATUReports.add("Next button is enabled in the frost Sensor Input and clicked on the Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next button is not enabled in the frost Sensor Input", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// Verify Now tap on Next
			MobileElement frostNext = frostPage.getNext_nxt_save_btn();
			String frostNextText = frostPage.getNext_nxt_save_btn().getText();
			if (frostNext != null) {
				if (frostNext.isDisplayed()) {

					if (frostNextText.equals(readFrostData.ButtonText)) {
						ATUReports.add("Mobilize " + frostNextText + "  tab is displayed.",readFrostData.ButtonText, frostNextText,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						frostNext.click();
						Thread.sleep(2000);

					} else {
						ATUReports.add("Mobilize Report title " + frostNextText + " tab is not displayed",readFrostData.ButtonText,
								frostNextText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

			} else {
				driver.close();
				return;
			}

			
		
						
						
			// Verify Now Tap on cancel
			MobileElement frostCancel = frostPage.getCancelbtn();
			String frostCancelText = frostPage.getCancelbtn().getText();
			if (frostNext != null) {
				if (frostNext.isDisplayed()) {
					ATUReports.add("Mobilize " + frostCancelText + "  tab is displayed.",readFrostData.ButtonTextTwo, frostNextText,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					frostCancel.click();
					Thread.sleep(2000);

				} else {
					ATUReports.add("Mobilize Report title " + frostCancelText + " tab is not displayed",readFrostData.ButtonTextTwo,
							frostCancelText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				driver.close();
				return;
			}
			
			
			
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		

	}
	
	

}

