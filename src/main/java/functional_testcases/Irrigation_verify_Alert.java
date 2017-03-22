package functional_testcases;

import Pages.HomePage;
import Pages.IrrigationPage;
import Pages.LoginPage;
import Pages.NewViewScreenPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Irrigation_verify_Alert {
	private AndroidDriver driver;
	private LoginPage loginpage;
	private NewViewScreenPage newviewscreenpage;
	private IrrigationPage irrigationPage;

	@Test
	public void verify_alert_skipping_optional() {

		try {
			driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
			loginpage = new LoginPage(driver);
			new HomePage(driver);
			newviewscreenpage = new NewViewScreenPage(driver);
			irrigationPage = new IrrigationPage(driver);

			// Calling precondition
			Create_view addClass = new Create_view();
			addClass.createView();
			Thread.sleep(10000);

			// Verify tap on crop title-we are using generic code for titles bcs titles paths are changing from one to another.
			Thread.sleep(1000);
			List <WebElement> irrigationTitle=driver.findElements(By.id("com.davis.mobilize:id/report_text"));				
			for(int i=0;i<=irrigationTitle.size();i++){
				String irrigationTitleText =irrigationTitle.get(i).getText();
				System.out.println(irrigationTitleText + "---accessabilityid---");							
				if (irrigationTitleText.contains("IRRIGATION")) {
					ATUReports.add("Mobilize " + irrigationTitleText + "  tab is displayed.", "IRRIGATION", irrigationTitleText,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					irrigationTitle.get(i).click();
					
					Thread.sleep(2000);
					ATUReports.add("Mobilize IRRIGATION tab is clicked", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					break;
				} else {
					ATUReports.add("Mobilize Report title " + irrigationTitleText + " tab is not displayed", "IRRIGATION",
							irrigationTitleText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				}
				
			}					
			Thread.sleep(3000);

			
			
			// Verifying tutorial icon
			Thread.sleep(2000);
			Precondition.tutorialDisalogBox();
			
	
			// verify the header text
			verify_Header();

			// verify the back button
			verify_Back_button();

			// Verify Irrigation title text.
			String soil = irrigationPage.getsoilSensorTitle().getText();
			// System.out.println(title);
			if (soil.isEmpty()) {
				ATUReports.add("Soil Moisture Senso element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (soil.contains("Soil Moisture Sensor")) {
					ATUReports.add("SOIL MOISTURE SENSORS is noticed in the screen ", "SOIL MOISTURE SENSORS", soil,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				else {
					ATUReports.add("Soil Moisture Senso is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			Thread.sleep(2000);

			// Click on skip button
			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				ATUReports.add(
						"Next  button is enabled in the  SOIl MOISTURE SENSORS screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add(
						"Next  button is enabled in the  SOIl MOISTURE SENSORS screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			/***************************************************************************************************************
			 * PRESSURE SENSOR
			 ************************************************************************************************************/

			// verify the header text
			verify_Header();

			// verify the back button
			String back_btn;
			try {
				back_btn = ((IrrigationPage) irrigationPage).getcancelButton().getText();

				if (back_btn.isEmpty()) {
					
					ATUReports.add("Back is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
					} else {
						ATUReports.add("Back button element is  visible", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Verify Chill start date title text.
			String high_ec_thresold_title = irrigationPage.getpresureSensorTitle().getText();
			if (high_ec_thresold_title.isEmpty()) {
				ATUReports.add("Verify the Pressure Sensor/Switch text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (high_ec_thresold_title.equals("Pressure Sensor/Switch")) {
					ATUReports.add("Pressure Sensor/Switch is noticed in the screen", "Pressure Sensor/Switch",
							high_ec_thresold_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("Pressure Sensor/Switch is not noticed in the screen", "Pressure Sensor/Switch",
							high_ec_thresold_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Click on skip button

			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				// irrigationPage.getskipbtn().click();

				ATUReports.add("Next  button is enabled in the  HIGH EC THRESHOLD screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Next  button is enabled in the  PRESSURE SENSOR screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			Thread.sleep(2000);

			/***************************************************************************************************************
			 * FLOW METER SENSOR
			 ************************************************************************************************************/

			// verify the header text
			verify_Header();

			// verify the back button
			String back_btn3;
			try {
				back_btn3 = ((IrrigationPage) irrigationPage).getcancelButton().getText();

				if (back_btn3.isEmpty()) {
					
					ATUReports.add("Back is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
					} else {
						ATUReports.add("Back button element is  visible", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Verify Flow Meter Sensor title text.
			String flowMeter_title = irrigationPage.getflowTitle().getText();
			if (flowMeter_title.isEmpty()) {
				ATUReports.add("Verify the  Flow Meter Sensor text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (flowMeter_title.contains("Flow Meter Sensor")) {
					ATUReports.add(" Flow Meter Sensor is noticed in the screen", " Flow Meter Sensor", flowMeter_title,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add(" Flow Meter Sensor is not noticed in the screen", " Flow Meter Sensor",
							flowMeter_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Click on skip button
			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();

				ATUReports.add("Next  button is enabled in the   FLOW METER SENSOR screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("SKIP  button is enabled in the  FLOW METER SENSOR screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(2000);

			/***************************************************************************************************************
			 * ET READING
			 *************************************************************************************************************/

			// verify the header text
			verify_Header();

			// verify the back button
			String back_btn2;
			try {
				back_btn2 = ((IrrigationPage) irrigationPage).getcancelButton().getText();

				if (back_btn2.isEmpty()) {
					
					ATUReports.add("Back is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
					} else {
						ATUReports.add("Back button element is  visible", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Verify ET Reading title text.
			String et_reading_title = irrigationPage.getetReadingTitle().getText();
			if (et_reading_title.isEmpty()) {
				ATUReports.add("Verify the ET READING text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (et_reading_title.equals("ET Reading")) {
					ATUReports.add("ET READING is noticed in the screen", "ET Reading", et_reading_title, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("ET Reading is not noticed in the screen", "ET Reading", et_reading_title,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Click on skip button
			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();

				ATUReports.add("Next  button is enabled in the ET READING screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next  button is enabled in the  ET READING screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(2000);

			// Click on save button

			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				Thread.sleep(15000);
				ATUReports.add("save button is enabled in the screen and Clicked on Next button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next  button is not enabled in the  screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			if (irrigationPage.getpopUpText().isDisplayed()) {

				String error_title = irrigationPage.getpopUpText().getText();

				//String popText= irrigationPage.getpopUpText().getText();
				if (error_title.contains("Cancel Adding Irrigation?")) {
					ATUReports.add("Cancel Adding Irrigation Alert is displayed in the screen and the same is asserted",
							error_title, "Cancel Adding Irrigation? At least one sensor input is required to track irrigation, by skipping all sensors no Irrigation report will be added.", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("Cancel Adding Irrigation Alert is displayed wrong in the screen ", error_title,
							"Cancel Adding Irrigation? At least one sensor input is required to track irrigation, by skipping all sensors no irrigation will be added.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				Thread.sleep(2000);
				
				// Verify go back button
				MobileElement goBackButton = irrigationPage.getgoBack();
				String goBackText = goBackButton.getText();
				System.out.println(goBackText+"goBackText");
				if (goBackText.contains("Go Back")) {
					ATUReports.add(
							"Go back  button is Displayed in the irrigation 'Cancel adding irrigation dialog box' and clicked on Go Back button",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					goBackButton.click();
					Thread.sleep(2000);
				} else {
					ATUReports.add(
							"Go back  button is not Displayed in the irrigation 'Cancel adding irrigation dialog box'",
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				Thread.sleep(2000);

				
				// Verify Irrigation title text.
				String soilText = irrigationPage.getsoilSensorTitle().getText();
				// System.out.println(title);
				if (soilText.isEmpty()) {
					ATUReports.add("Soil Moisture Senso element is not available in the screen ", LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (soil.contains("Soil Moisture Sensor")) {
						ATUReports.add("User navigated to 'Soil Moisture Sensor' screen ", "Soil Moisture Sensor",
								soilText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					else {
						ATUReports.add("User not navigated to Soil Moisture Sensor screen ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				Thread.sleep(2000);
				
				
				
				

			} else {
				ATUReports.add("Cancel Adding Irrigation Alert is not displayed in the screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getText() {
		// TODO Auto-generated method stub

	}

	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}

	private void verify_Back_button() {

		// Verify the Cancel button text
		String back_btn;
		try {
			back_btn = ((IrrigationPage) irrigationPage).getcancelButton().getText();

			if (back_btn.isEmpty()) {
				
				ATUReports.add("Back is not observed in the screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
				} else {
					ATUReports.add("Back button element is  visible", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void verify_Header() {
		String editirrigation;
		try {
			editirrigation = irrigationPage.getEditirrigationtxt().getText();

			if (editirrigation.isEmpty()) {
				ATUReports.add("Edit Irrigation element is not avaialble in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else if (editirrigation.equals("Edit Irrigation")) {
				ATUReports.add("Edit Irrigation is noticed in the screen ", "Edit Irrigation", editirrigation,
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Edit Irrigation is noticed in the screen ", editirrigation, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}