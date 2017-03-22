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
import utility.ReadUserData;
import utility.Read_Frost_Data;
import utility.Read_Frost_Details;

import java.io.IOException;
import java.util.List;

//import org.openqa.selenium.interactions.internal.TouchAction;
//import io.appium.java_client.ios.IOSDriver;

public class Verify_Edit_FrostReport {
	private HomePage homepage ;
	private AndroidDriver driver;
	private Read_Frost_Details read_frost_details;
	private WeatherPage weatherPage;
	private NewViewScreenPage newviewscreenpage;
	private FrostPage frostPage;
	private Read_Frost_Data readFrostData;
	private Account_Page accountPage;
	private LoginPage loginpage;
	private ReadUserData readUserData;	
	@Test
	public void verifyEditFrostReport() throws InterruptedException, IOException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		new HomePage(driver);
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		newviewscreenpage = new NewViewScreenPage(driver);
		new FrostPage(driver);
		read_frost_details = new Read_Frost_Details();
		read_frost_details.start();
		weatherPage = new WeatherPage(driver);
		new LoginPage(driver);
		new LoginPage(driver);
		frostPage = new FrostPage(driver);
		readFrostData = new Read_Frost_Data();
		accountPage=new Account_Page(driver);
		Thread.sleep(2000);
		// Get the values from frost data file
		readFrostData.start();
		readUserData=new ReadUserData();
		readUserData.start();
		//read_frost_details.start();
		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");

		Log.startTestCase("Frost set up test Case start");
		System.out.println("**********Frost set up test Case start ********");

		try {

			
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
						  
						// Verifying tutorial icon
						Thread.sleep(2000);
						Precondition.tutorialDisalogBox();			
			

			// Verify tap on crop title-we are using generic code for titles bcs titles paths are changing from one to another.
			Thread.sleep(1000);
			List <WebElement> cropTitle=driver.findElements(By.id("com.davis.mobilize:id/report_text"));	//This is mandatory to take id here			
			for(int i=0;i<=cropTitle.size();i++){
				String cropTitleText =cropTitle.get(i).getText();
				//System.out.println(cropTitleText + "---accessabilityid---");							
				if (cropTitleText.contains("FROST")) {
					ATUReports.add("Mobilize " + cropTitleText + "  tab is displayed.", "FROST", cropTitleText,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					cropTitle.get(i).click();
					
					Thread.sleep(2000);
					ATUReports.add("Mobilize FROST tab is clicked", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					break;
				} else {
					ATUReports.add("Mobilize Report title " + cropTitleText + " tab is not displayed", "FROST",
							cropTitleText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
				}
				
			}
			

		
			// Verify Observe application navigated to Sensor Input screen and
			// Next is disabled.
			String frost_sensor_title = frostPage.getTitletxt().getText();
			if (frost_sensor_title.isEmpty()) {
				ATUReports.add("Verify the Frost Sensor Input text  in the screen ", readFrostData.titleTextTwo,
						frost_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (frost_sensor_title.equals(readFrostData.titleTextTwo)) {
					ATUReports.add("Frost Sensor Input is noticed in the screen ", readFrostData.titleTextTwo,
							frost_sensor_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Frost Sensor Input is not observed in the screen ", frost_sensor_title, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the Edit Frost text
			String editfrost = frostPage.getEditfrost().getText();
			if (editfrost.isEmpty()) {
				ATUReports.add("Verify the Edit Frost in the screen ", "Edit Frost", editfrost, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (editfrost.equals("Edit Frost")) {
					ATUReports.add("Edit Frost is noticed in the screen ", "Edit Frost", editfrost, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify the title text
					String title = frostPage.getTitletxt().getText();
					// System.out.println(title);
					if (title.isEmpty()) {
						ATUReports.add("Verify the Sensor Input text  in the screen ", "Frost Sensor Input", title,
								LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (title.equals("Frost Sensor Input")) {
							ATUReports.add("Sensor Input text is noticed in the screen ", "Frost Sensor Input", title,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Sensor Input text is not observed in the screen ", title, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
                 Thread.sleep(3000);
                 
                 
					// Verify the body text
					String body = frostPage.getBodytxt().getText();
					System.out.println(body+"---body--");
					if (body.isEmpty()) {
						ATUReports.add("Verify the Sensor Input caption text  in the screen ",
								"Select the appropriate device and sensor inputs for monitoring frost data.",
								body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (body.equals(
								"Select the appropriate device and sensor inputs for monitoring frost data.")) {
							ATUReports.add("Sensor Input caption text is dispalyed in the screen ",
									"Select the appropriate device and sensor inputs for monitoring frost data.",
									body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Sensor Input caption text is not dispalyed in the screen ", body,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					
					// Verify the persistence of the device value in the screen
					if (frostPage.getDevicestxt().getText().equalsIgnoreCase("Device")) {
						ATUReports.add("Device is dispalyed in the screen upon navigated back to the screen",
								frostPage.getDevicestxt().getText(),"Device", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("Device  is not dispalyed in the screen upon navigated back to the screen",
								frostPage.getDevicestxt().getText(),"Device", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
					
					
					// Verify Now select Device and Sensors from dropdown list.
					// Select any option from device drop down -

					//frostPage.getDevicestxt().click();
					Thread.sleep(3000);
					frostPage.getDevicedropdown().click();
					Thread.sleep(3000);
					ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));			
					if (frostPage.getSensortxt().getText().equalsIgnoreCase("Sensor")) {
						ATUReports.add("SENSOR is dispalyed in the screen upon navigated back to the screen",
								frostPage.getSensortxt().getText(),"Sensor", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("SENSOR is not dispalyed in the screen upon navigated back to the screen",
								frostPage.getSensortxt().getText(),"Sensor", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
					
					// Select any option from sensor drop down
					//frostPage.getSensortxt().click();
					Thread.sleep(3000);
					frostPage.getSensordropdown().click();
					Thread.sleep(3000);
					ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
					

					// Verify Observe Next button is Enabled. and Now tap on
					// Next
					if (frostPage.getNext_nxt_save_btn().isEnabled()) {
						frostPage.getNext_nxt_save_btn().click();
						Thread.sleep(9000);
						ATUReports.add(
								"Next button is enabled in the frost Sensor Input and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled in the frost Sensor Input", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					Thread.sleep(8000);

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
							ATUReports.add("Frost threshold is not  displayed in the screen ",
									readFrostData.titleTextThree, frost_thresholdTitle, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					// Verify the body text
					String FrostThreshold_body = frostPage.getBodytxt().getText();
					//System.out.println(body);
					if (FrostThreshold_body.isEmpty()) {
						ATUReports.add("Verify the Frost threshold caption text  in the screen ",
								"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.",
								FrostThreshold_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (FrostThreshold_body.equals(
								"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.")) {
							ATUReports.add("Frost threshold caption text is dispalyed in the screen ",
									"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.",
									FrostThreshold_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Frost threshold caption text is not dispalyed in the screen ",
									FrostThreshold_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					Thread.sleep(2000);

					// Verify Tap on Temperature value box.

					MobileElement temparatureBox = weatherPage.getTemperatureBox();

					if (temparatureBox != null) {
						if (temparatureBox.isDisplayed()) {
							ATUReports.add("Mobilize temparature value box is displayed.", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							temparatureBox.click();
							driver.hideKeyboard();
							Thread.sleep(2000);
							ATUReports.add("Temperature value given in the text box", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Mobilize temparature value box is not displayed.", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

					} else {
						driver.close();
						return;
					}
					
					
			
					
					
					// Verify Drag the slider to change the temperature
					//move the slider
					//AddFrost slider=new AddFrost();
					thresholdSlider();
					Thread.sleep(4000);
					
				
					//Verifying plus icon
					plusIconButton();
					ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					Thread.sleep(2000);
					
					//Verifying minus icon
					minusIconButton();
					ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
					String actualTextBoxText=temparatureBox.getText();

					
					// Click on the next button in the Frost Threshold screen.
					if (weatherPage.getNext_nxt_save_btnn().isEnabled()) {
						weatherPage.getNext_nxt_save_btnn().click();
						ATUReports.add("Next button is enabled in the Frost Threshold and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled Frost Threshold", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					Thread.sleep(4000);
					
					
					// Verifying tutorial icon
					Thread.sleep(2000);
					Precondition.tutorialDisalogBox();
					

					// Verify frost warning page heading text
					String frost_Warning = frostPage.getTitletxt().getText();
					System.out.println(frost_Warning+"frost warning page body-----");
					if (frost_Warning.isEmpty()) {
						ATUReports.add("Verify the Frost warning text  in the screen ", readFrostData.titleTextFour,
								frost_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (frost_Warning.equals(readFrostData.titleTextFour)) {
							ATUReports.add("Frost warning is displayed in the screen ", readFrostData.titleTextFour,
									frost_Warning, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Frost warning is not  displayed in the screen ",
									readFrostData.titleTextFour, frost_Warning, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					Thread.sleep(4000);
					
					String actualTextBoxText2=driver.findElementById("com.davis.mobilize:id/et_early_temp").getText();
					
					// Verify the body text
					String Early_Frost_Warning_body = frostPage.getBodytxt().getText();
					if (Early_Frost_Warning_body.isEmpty()) {
						ATUReports.add("Verify the EARLY FROST WARNING caption text  in the screen ",
								"Early warning threshold is set to alert for cases where frost may soon follow.",
								Early_Frost_Warning_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (Early_Frost_Warning_body.equalsIgnoreCase(
								"Early warning threshold is set to alert for cases where frost may soon follow.")) {
							ATUReports.add("EARLY FROST WARNING caption text is dispalyed in the screen ",
									"Early warning threshold is set to alert for cases where frost may soon follow.",
									Early_Frost_Warning_body, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("EARLY FROST WARNING caption text is not dispalyed in the screen ",
									Early_Frost_Warning_body, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					// Verify frost warning page pagination dots.
					MobileElement paginationDotsThree = weatherPage.getPageindicator();
					if (paginationDotsThree != null) {

						if (paginationDotsThree.isDisplayed()) {
							ATUReports.add("Pagination dots is Displayed in " + readFrostData.titleTextFour + " page",
						frost_Warning, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add(
									"Pagination dots is not Displayed in " + readFrostData.titleTextFour + " page",
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}
					} else {
						driver.close();
					}

					
					//get the value of the optional and click on it
					
					Thread.sleep(4000);
					if(frostPage.getoptionalSliderSwipe().isDisplayed()){			
						ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
						Thread.sleep(2000);
								WebElement optionalElement =frostPage.getoptionalSliderSwipe();
						int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
						int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
						System.out.println("xInitialOptional  "+xInitialOptional+ "yInitialOptional "+yInitialOptional);
						//driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
						if(xInitialOptional<1200){  
							driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
							//System.out.println("in 1st loop optional");
						}else{				
								if(xInitialOptional>1200){
								driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+120, yInitialOptional, 5000);
									//System.out.println("in 2nd loop optional");
								}
						}
					Thread.sleep(2000);
					}else{
						ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
					
					if (frostPage.getNext_nxt_save_btn().isEnabled()) {
						ATUReports.add("moved the slider ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Slider is not visible and unable to move the slider ", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

					
					
					// Verify Drag the slider to change the temperature
					//move the slider
					thresholdSlider();
					Thread.sleep(4000);
					
				
					//Verifying plus icon
					plusIconButton();
					ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					Thread.sleep(2000);
					
					//Verifying minus icon
					minusIconButton();
					ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
					
					
					// Click on next button
					frostPage.getNext_nxt_save_btn().click();
					Thread.sleep(4000);

					// Verify the COMPLETE FROST SETUP
					if (driver.getPageSource().contains(readFrostData.titleTextFive)) {
						ATUReports.add("Complete Frost Setup is dispalyed in the screen", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Navigated to a wrong screen", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
					Thread.sleep(4000);
					
					String COMPLETE_FROST_SETUP_title = frostPage.getTitletxt().getText();
					if (COMPLETE_FROST_SETUP_title.isEmpty()) {
						ATUReports.add("Verify the Complete Frost Setup text  in the screen ", "COMPLETE FROST SETUP",
								COMPLETE_FROST_SETUP_title, LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (COMPLETE_FROST_SETUP_title.equals(readFrostData.titleTextFive)) {
							ATUReports.add("Complete Frost Setup is displayed in the screen ",
									readFrostData.titleTextFive, COMPLETE_FROST_SETUP_title, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Complete Frost Setup is not noticed in the screen",
									readFrostData.titleTextFive, COMPLETE_FROST_SETUP_title, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					// Verify the body text
					String complete_Frost_setup_body = frostPage.getBodytxt().getText();
		                System.out.println(complete_Frost_setup_body+"--compete body--");
					if (complete_Frost_setup_body.isEmpty()) {
						ATUReports.add("Verify the Complete Frost Setup caption text  in the screen ",
								"Save the setup to view the frost report.Go back to edit any frost setup settings.",
								complete_Frost_setup_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (complete_Frost_setup_body.equals(
								"Save the setup to view the frost report. Go back to edit any frost setup setting.")) {
							ATUReports.add("Complete Frost Setup caption text is dispalyed in the screen ",
									"Save the setup to view the frost report. Go back to edit any frost setup setting.",
									complete_Frost_setup_body, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Complete Frost Setup caption text is not dispalyed in the screen ",
									complete_Frost_setup_body, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					Thread.sleep(4000);
					
					// Click on back button and verify the screen name
					frostPage.getCancelbtn().click();
					Thread.sleep(3000);
					
					if (driver.getPageSource().contains(readFrostData.titleTextFour)) {
						ATUReports.add(
								"EARLY FROST WARNING is dispalyed in the screen upon navigated back to the screen",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Navigated to a wrong screen", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					

					// Click on back button and verify the screen name
					frostPage.getCancelbtn().click();
					Thread.sleep(3000);
					
					if (driver.getPageSource().contains(readFrostData.titleTextThree)) {
						ATUReports.add("FROST THRESHOLD is dispalyed in the screen upon navigated back to the screen",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Navigated to a wrong screen", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					// Verify the persistence  of the temperature value in the
					// screen
					System.out.println(actualTextBoxText+"----actualTextBoxText---");
					if (driver.getPageSource().contains(actualTextBoxText)) {
						ATUReports.add(
								"FROST THRESHOLD temarature is dispalyed in the screen upon navigated back to the screen",
								read_frost_details.frost_threshold_temp, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add(
								"FROST THRESHOLD temarature is not dispalyed in the screen upon navigated back to the screen",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					

					// Click on back button and verify the screen name
					frostPage.getCancelbtn().click();
					Thread.sleep(3000);
					
					if (driver.getPageSource().contains(readFrostData.titleTextTwo)) {
						ATUReports.add("SENSOR INPUT is dispalyed in the screen upon navigated back to the screen",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Navigated to a wrong screen", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					//Click on next button in the Sensor input screen
					frostPage.getNext_nxt_save_btn().click();

					//Click on next button in the FROST THRESHOLD SCREEN
					frostPage.getNext_nxt_save_btn().click();

					//Click on skip button in the EARLY FROST WARNING
					frostPage.getNext_nxt_save_btn().click();

					
					
					//Click on save button in the Complete Frost Setup
					frostPage.getNext_nxt_save_btn().click();
					ATUReports.add("Clciked on save button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(4000);
					
					// Verifying tutorial icon
					Thread.sleep(2000);
					Precondition.tutorialDisalogBox();

					
					//Click on Manage Account    				
					homepage.getAccountbtn().click();
					ATUReports.add("Clicked on account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
					
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
					
					
				
				} else {
					ATUReports.add("Edit Frost is not observed in the screen", editfrost, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			Log.startTestCase("****Frost set Up test Case Ended***");
			System.out.println("***********Frost set Uptest Case Ended ********");
				
		
		
		} catch (Exception e) {

		}
	}
	
	
public void thresholdSlider() throws InterruptedException{
		
		//move the slider
		Thread.sleep(4000);
		WebElement lastElement =frostPage.getTempSlier();
		Thread.sleep(2000);
		int xInitial = lastElement.getLocation().getX() + lastElement.getSize().getWidth()/2;
		int yInitial = lastElement.getLocation().getY() + lastElement.getSize().getHeight()/2;
		System.out.println("xInitial "+xInitial+ "yInitial"+yInitial);
		driver.swipe(xInitial, yInitial, xInitial+200, yInitial, 5000);					
		ATUReports.add("Slider is displayed and moved the slider from left to right",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
	
	public void plusIconButton() throws InterruptedException{		
	        //move the slider
			Thread.sleep(4000);
			WebElement lastElement =frostPage.getplusIcon();
			
			if(lastElement.isDisplayed()){
			lastElement.click();
			ATUReports.add("Plus icon is displayed",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		
		ATUReports.add("Plus icon is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		driver.close();
	}
	}
	
	public void minusIconButton() throws InterruptedException{		
        //move the slider
		Thread.sleep(4000);
		WebElement lastElement =frostPage.getminusIcon();
		if(lastElement.isDisplayed()){
			lastElement.click();
			ATUReports.add("Minus icon is displayed",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		
		ATUReports.add("Minus icon is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		driver.close();
	}
	}	
	
	
}






































//for future reference

/*// Verify slider in frost early warning page
//move the slider
Thread.sleep(4000);
WebElement lastElementEarlyFrostSlider=weatherPage.getearlyFrostThresholdSlider();
Thread.sleep(1000);
int xInitialEarlyFrost= lastElementEarlyFrostSlider.getLocation().getX() + lastElementEarlyFrostSlider.getSize().getWidth()/2;
int yInitialEarlyFrost = lastElementEarlyFrostSlider.getLocation().getY() + lastElementEarlyFrostSlider.getSize().getHeight()/2;
System.out.println("xInitial in  frost threshold temp"+xInitialEarlyFrost+ "yInitialEarlyFrost in frost threshold temp"+yInitialEarlyFrost);
driver.swipe(xInitialEarlyFrost, yInitialEarlyFrost, xInitialEarlyFrost+300, yInitialEarlyFrost, 5000);					
ATUReports.add("Slider is displayed and moved the slider from left to right",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
/*	//move the slider
Thread.sleep(4000);
WebElement lastElement =weatherPage.getfrostThresholdSlider();
Thread.sleep(1000);
int xInitial = lastElement.getLocation().getX() + lastElement.getSize().getWidth()/2;
int yInitial = lastElement.getLocation().getY() + lastElement.getSize().getHeight()/2;
System.out.println("xInitial in  frost threshold temp"+xInitial+ "yInitial in frost threshold temp"+yInitial);
driver.swipe(xInitial, yInitial, xInitial+350, yInitial, 5000);					
ATUReports.add("Slider is displayed and moved the slider from left to right",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/



/*// Click on Manage Account
((new WebDriverWait(driver, 10)).until(
		ExpectedConditions.elementToBeClickable(By.id("com.davis.mobilize:id/settingButton"))))
				.click();
// TestAppiumDriver.getAppiumDriver().manage().timeouts().implicitlyWait(10,
// TimeUnit.SECONDS);
ATUReports.add("Click Manage button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

// Click on Gear/Settings icon
((new WebDriverWait(driver, 10))
		.until(ExpectedConditions.elementToBeClickable(By.id("com.davis.mobilize:id/shareIcon"))))
				.click();
Thread.sleep(5000);
ATUReports.add("Click Settings/Gear button", LogAs.PASSED,
		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

// Click on Logout
((new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By
		.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[1]/android.support.v7.widget.LinearLayoutCompat[3]/android.widget.CheckedTextView[1]"))))
				.click();
Thread.sleep(3000);
((new WebDriverWait(driver, 10))
		.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1"))))
				.click();
ATUReports.add("Click Logout button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
