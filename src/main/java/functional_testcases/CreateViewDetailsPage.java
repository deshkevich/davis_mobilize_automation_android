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
import utility.ReadViewName;
import utility.Read_Frost_Data;

import java.net.MalformedURLException;
import java.util.List;

public class CreateViewDetailsPage {

	private static AndroidDriver driver;
	private static NewViewScreenPage newviewscreenpage;
	private FrostPage frostPage;
	@SuppressWarnings("unused")
	private Read_Frost_Data  readFrostData;
	@SuppressWarnings("unused")
	@Test
	public void createViewDeatails() throws MalformedURLException, InterruptedException {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		new HomePage(driver);
		newviewscreenpage = new NewViewScreenPage(driver);
		new ReadViewName();
		new LoginPage(driver);
		frostPage = new FrostPage(driver);
		readFrostData=new Read_Frost_Data();
		readFrostData.start();
		
		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");

		Log.startTestCase("Create view  Details test Case start");
		System.out.println("**********Create view  Details test Case start ********");

		try {
					
			// Calling precondition
			Create_view addClass = new Create_view();
			addClass.createView();
			
			
			

			// // Verify Back button is displayed at top left corner.and Now tap
			// on Back.
			MobileElement backButton = newviewscreenpage.getcancelButton();
			if (backButton != null) {
				if (backButton.isDisplayed()) {
					String backButtonText = backButton.getText();
					
						ATUReports.add("Mobilize back button is displayed at top bar.", 
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Mobilize back button is not displayed at top bar.", 
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				} else {
					driver.close();
					return;
				}

			

			// Verify View Name is Displayed or not
			MobileElement viewNameText = newviewscreenpage.getViewNameTitle();
			String nameText = viewNameText.getText();
			//System.out.println(nameText+"--nameText--");
			if (viewNameText != null) {
				if (viewNameText.isDisplayed()) {				
						ATUReports.add("Mobilize View name entered text is displayed at top bar.user navigated to view details screen", nameText,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Mobilize View name entered text is not displayed at top bar.",nameText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				} else {
					driver.close();
					return;
				}

			

			// Verify Share icon at top bar.or not

			MobileElement shareIcon = newviewscreenpage.getshareIcon();
			if (shareIcon != null) {
				if (shareIcon.isDisplayed()) {

					ATUReports.add("Mobilize  Share icon is displayed at top bar.", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Mobilize Share icon is not displayed at top bar.", "Mobilize", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				driver.close();
				return;
			}

		
			// /Verify + button for Frost with description.
			MobileElement AddIcon = newviewscreenpage.getcreateButton();
			if (AddIcon != null) {
				if (AddIcon.isDisplayed()) {

					ATUReports.add("Mobilize Frost Add icon is displayed ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Mobilize Frost Add icon is not displayed ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				driver.close();
				return;
			}

			

			// Verify Frost sub title is displyaed or not
			MobileElement frostSubTitle = newviewscreenpage.getfrosSubtTitle();
			String frostSubTitleText = newviewscreenpage.getfrosSubtTitle().getText();
			if (frostSubTitle != null) {
				if (frostSubTitle.isDisplayed()) {

					if (frostSubTitleText.equals("Keep alert of frost conditions")) {
						ATUReports.add("Mobilize Report sub title " + frostSubTitleText + " is displayed.",
								"Keep alert of frost conditions", frostSubTitleText, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("Mobilize Report sub title " + frostSubTitleText + " is not displayed",
								"Keep alert of frost conditions", frostSubTitleText, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

			} else {
				driver.close();
				Thread.sleep(2000);
			}
			

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
							//if (frost_sensor_title.equals(readFrostData.titleTextTwo)) {
						if (frost_sensor_title.equals("Frost Sensor Input")) {
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
						MobileElement frostNext = frostPage.getNext_nxt_save_btn();
						if (frostPage.getNext_nxt_save_btn().isEnabled()) {
							frostPage.getNext_nxt_save_btn().click();
							ATUReports.add("Next button is enabled in the frost Sensor Input and clicked on the Next button",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Next button is not enabled in the frost Sensor Input", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
						Thread.sleep(2000);
						
						// Verify Now Tap on cancel

						MobileElement frostCancel = frostPage.getCancelbtn();
						String frostCancelText = frostPage.getCancelbtn().getText();
						if (frostNext != null) {
							if (frostNext.isDisplayed()) {
								ATUReports.add("Mobilize " + frostCancelText + "  tab is displayed.",readFrostData.ButtonTextTwo, frostCancelText,
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

			Log.startTestCase("Create view details test Case Ended");
			System.out.println("*********** Create view details test Case Ended ********");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}










































/*	// /Verify + button for Weather with description.

	// Verify add icon is displayed or not
	MobileElement weatherAddIcon = newviewscreenpage.getweatherAddButton();
	if (weatherAddIcon != null) {
		if (weatherAddIcon.isDisplayed()) {

			ATUReports.add("Mobilize weather Add icon is displayed ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} else {
			ATUReports.add("Mobilize weather Add icon is not displayed ", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	} else {
		driver.close();
		return;
	}

	// Verify the report title displayed or not
	MobileElement weatherTitle = newviewscreenpage.getweatherTitle();
	String weatherTitleText = newviewscreenpage.getweatherTitle().getText();
	if (weatherTitle != null) {
		if (weatherTitle.isDisplayed()) {

			if (weatherTitleText.equals("WEATHER")) {
				ATUReports.add("Mobilize Report title " + weatherTitleText + " is displayed.", "WEATHER",
						weatherTitleText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Mobilize Report title " + weatherTitleText + " is not displayed", "WEATHER",
						weatherTitleText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}

	} else {
		driver.close();
		return;
	}

	// Verify weather sub title is displyaed or not
	MobileElement weatherSubTitle = newviewscreenpage.getweatherSubTitle();
	String weatherSubTitleText = newviewscreenpage.getweatherSubTitle().getText();
	if (weatherSubTitle != null) {
		if (weatherSubTitle.isDisplayed()) {

			if (weatherSubTitleText.equals("Track weather with alerts")) {
				ATUReports.add("Mobilize Report sub title " + weatherSubTitleText + " is displayed.",
						"Track weather with alerts", weatherSubTitleText, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Mobilize Report sub title " + weatherSubTitleText + " is not displayed",
						"Track weather with alerts", weatherSubTitleText, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
	} else {
		driver.close();
		return;
	}*/

	

	/*// Verify + button for Crop with description.
	MobileElement cropAddIcon = newviewscreenpage.getcropAddButton();
	if (cropAddIcon != null) {
		if (cropAddIcon.isDisplayed()) {

			ATUReports.add("Mobilize crop Add icon is displayed ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} else {
			ATUReports.add("Mobilize crop Add icon is not displayed ", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	} else {
		driver.close();
		return;
	}

	// Verify the report title displayed or not
	MobileElement cropTitle = newviewscreenpage.getcropTitle();
	String cropTitleText = newviewscreenpage.getcropTitle().getText();
	if (cropTitle != null) {
		if (cropTitle.isDisplayed()) {

			if (cropTitleText.equals("CROP")) {
				ATUReports.add("Mobilize Report title " + cropTitleText + " is displayed.", "CROP",
						cropTitleText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Mobilize Report title " + cropTitleText + " is not displayed", "CROP",
						cropTitleText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}

	} else {
		driver.close();
		return;
	}

	// Verify crop sub title is displyaed or not
	MobileElement cropSubTitle = newviewscreenpage.getcropSubTitle();
	String cropSubTitleText = newviewscreenpage.getcropSubTitle().getText();
	if (cropSubTitle != null) {
		if (cropSubTitle.isDisplayed()) {

			if (cropSubTitleText.equals("Monitor growth cycle")) {
				ATUReports.add("Mobilize Report sub title " + cropSubTitleText + " is displayed.",
						"Monitor growth cycle", cropSubTitleText, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Mobilize Report sub title " + cropSubTitleText + " is not displayed",
						"Monitor growth cycle", cropSubTitleText, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
	} else {
		driver.close();
		return;
	}*/

/*	// Verify Data details
	MobileElement dataDetails = newviewscreenpage.getdataDetails();
	String dataDetailsText = newviewscreenpage.getdataDetails().getText();
	if (dataDetails != null) {
		if (dataDetails.isDisplayed()) {

			if (dataDetailsText.equals("Data Details:")) {
				ATUReports.add("Mobilize Report sub title " + dataDetailsText + " is displayed.",
						"Data Details:", dataDetailsText, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Mobilize Report sub title " + dataDetailsText + " is not displayed",
						"Data Details:", dataDetailsText, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
	} else {
		driver.close();
		return;
	}

	// Verify Edit View button.

	MobileElement editViewButton = newviewscreenpage.geteditButton();
	String editViewButtonText = newviewscreenpage.geteditButton().getText();
	if (editViewButton != null) {
		if (dataDetails.isDisplayed()) {

			if (editViewButtonText.equals("Edit View")) {
				ATUReports.add("Mobilize Report sub title " + editViewButtonText + " is displayed.",
						"Edit View", editViewButtonText, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Mobilize Report sub title " + editViewButtonText + " is not displayed",
						"Edit View", editViewButtonText, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
	} else {
		driver.close();
		return;*/
	//}





//code-1

/*// Verify Location map.is Displayed or not

newviewscreenpage.getMap().click();
Thread.sleep(2000);

MobileElement locationMap = newviewscreenpage.getloactinMap();
if (locationMap!= null) {
	if (locationMap.isDisplayed()) {

		ATUReports.add("Mobilize Location map is displayed ", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

	} else {
		ATUReports.add("Mobilize Location map is not displayed ", LogAs.FAILED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

} else {
	driver.close();
	//return;
}*/

/*MobileElement backButtonTwo = newviewscreenpage.getCanceltxt();
backButtonTwo.click();
Thread.sleep(2000);*/


/*4. Now tap on Frost.
Observe application navigated to Sensor Input screen and Next is disabled.
5. Now select Device and Sensors from dropdown list.
Observe Next button is Enabled.
6. Now tap on Next
7. Now Tap on Back
*/
// *//Verify + button for Irrigation with description.is displayed
// or not
/*	// Verify + button for Irrigation with description.
MobileElement AddIcon = newviewscreenpage.getcreateButton();
if (AddIcon != null) {
	if (AddIcon.isDisplayed()) {

		ATUReports.add("Mobilize Irrigation Add icon is displayed ", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	} else {
		ATUReports.add("Mobilize Irrigation Add icon is not displayed ", LogAs.FAILED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

} else {
	driver.close();
	return;
}

// Verify the report title displayed or not
MobileElement title = newviewscreenpage.getreportText();
String titleText = newviewscreenpage.getreportText().getText();
if (title != null) {
	if (title.isDisplayed()) {

		if (titleText.equals("IRRIGATION")) {
			ATUReports.add("Mobilize Report title " + titleText + " is displayed.",titleText,
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} else {
			ATUReports.add("Mobilize Report title " + titleText + " is not displayed",titleText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

} else {
	driver.close();
	return;
}

// Verify sub title is displyaed or not
MobileElement subTitle = newviewscreenpage.getreportSubText();
String subTitleText = newviewscreenpage.getreportSubText().getText();
if (subTitle != null) {
	if (subTitle.isDisplayed()) {

		if (subTitleText.equals("Monitor water use")) {
			ATUReports.add("Mobilize Report sub title " + subTitleText + " is displayed.",
					"Monitor water use", subTitleText, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} else {
			ATUReports.add("Mobilize Report sub title " + subTitleText + " is not displayed",
					"Monitor water use", subTitleText, LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

} else {
	driver.close();
	return;
}
*/


//code-2