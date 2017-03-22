package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.*;

import java.util.List;

public class CropThresholdTemperature {
	private Read_Crop_Details readCropDetails;
	private CropPage cropPage;
	private AndroidDriver driver;
	private LoginPage loginpage;
	private NewViewScreenPage newscreenpage;
	private ReadUserData readUserData;
	private HomePage homepage;
	private FrostPage frostPage;
	private Read_Frost_Data readFrostData;
	private WeatherPage weatherPage;
	private Read_FrostPageThresholdValues readfrost;
	private Read_CropPageThresholdValues readCrop;
	private Account_Page accountPage;
	private Alert_Page  alertpage;
	@Test
	public void verifyThresholdTemp() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		newscreenpage = new NewViewScreenPage(driver);
		alertpage=new  Alert_Page(driver);
		cropPage = new CropPage(driver);
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		new IrrigationPage(driver);
		homepage = new HomePage(driver);
		frostPage = new FrostPage(driver);
		readFrostData = new Read_Frost_Data();
		readFrostData.start();
		weatherPage = new WeatherPage(driver);
		readfrost = new Read_FrostPageThresholdValues();
		readfrost.start();
		readCropDetails = new Read_Crop_Details();
		readCropDetails.start();
		readCrop = new Read_CropPageThresholdValues();
		readCrop.start();
		accountPage=new Account_Page(driver);
		try {

		
			
			
			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();
			
			
			// Click on Account button
			if (homepage.getAccountbtn().isDisplayed()) {
				ATUReports.add("Account button is found and clicking on Account button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				homepage.getAccountbtn().click();
				Thread.sleep(3000);
			} else {
				ATUReports.add("Account button is not displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
	
		
			         // Verifying tutorial icon
						Thread.sleep(2000);
						Precondition.tutorialDisalogBox();
					
			//Click on preferences
			MobileElement preferences=accountPage.getpreferecnes();
			if (preferences.isDisplayed()) {
				ATUReports.add("Preferences is Displayed and Clicked on prefrences", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(1000);
				preferences.click();
				Thread.sleep(2000);

			} else {
				ATUReports.add("preferences tab is not Displayed ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			
			// Verify user selected units from preferences.
			Thread.sleep(3000);
			MobileElement list = frostPage.getpreferencesList();
			if (list.isDisplayed()) {
				ATUReports.add("Users preferences list is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
				// Verify temperature
				MobileElement temperature = frostPage.gettempList();
				String expectedTempTxt = temperature.getText();
				if (temperature != null && temperature.isDisplayed()) {
					ATUReports.add("Users preferences Temperature list is displayed", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			    // First tap on the screen and swipe it from bottom to top.(temperature)
				WebElement prefernceslistElement =homepage.getprefrencesFirstList();
				int xInitialprefernceslistElement = prefernceslistElement.getLocation().getX() + prefernceslistElement.getSize().getWidth()/2;
				int yInitialprefernceslistElement = prefernceslistElement.getLocation().getY() + prefernceslistElement.getSize().getHeight()/2;
				System.out.println("=startx "+xInitialprefernceslistElement+" "+ yInitialprefernceslistElement+"=end y  scroll down to  up the page");
				driver.swipe(xInitialprefernceslistElement, yInitialprefernceslistElement, xInitialprefernceslistElement, yInitialprefernceslistElement-500, 5000);
				ATUReports.add("Scroll down to up the preferences  list", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
				
					// Verify 'F'
					MobileElement fText = frostPage.getfrostFText();
					String expectedFtxt = fText.getText();
					System.out.println(expectedFtxt + "expectedFtxt");
					MobileElement cText = frostPage.gettempCText();
					String expectedCText = cText.getText();
					ATUReports.add(
							"Users preferences Temperature  Radio button is displayed and  radio button is selected by default",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Clicked on home button
					homepage.getHomebutton().click();
					Thread.sleep(2000);
							
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
					MobileElement viewName = newscreenpage.getView_txtfld();
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
					MobileElement nextAddButton = newscreenpage.getAddbtn();
					if (nextAddButton != null) {
						if (nextAddButton.isDisplayed()) {
							ATUReports.add("Mobilize Add button  is displayed & clicked on Add button,view is created in the current screen after click on Add button", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							nextAddButton.click();
							Thread.sleep(3000);			
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
					List <WebElement> cropTitle=driver.findElements(By.id("com.davis.mobilize:id/report_text"));
					for(int i=0;i<=cropTitle.size();i++){
						String cropTitleText =cropTitle.get(i).getText();
						//System.out.println(cropTitleText + "---accessabilityid---");							
						if (cropTitleText.contains("CROP")) {
							ATUReports.add("Mobilize " + cropTitleText + "  tab is displayed.", "CROP", cropTitleText,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							cropTitle.get(i).click();
							
							Thread.sleep(2000);
							ATUReports.add("Mobilize CROP tab is clicked", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							break;
						} else {
							ATUReports.add("Mobilize Report title " + cropTitleText + " tab is not displayed", "CROP",
									cropTitleText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
						}
						
					}
					

				
					// Verify the title text
					String crop_sensor_title = cropPage.getTitletxt().getText();
					if (crop_sensor_title.isEmpty()) {
						ATUReports.add("Verify the CROP SENSOR INPUT text  in the screen ", "CROP SENSOR INPUT",
								crop_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (crop_sensor_title.equals("Crop Sensor Input")) {
							ATUReports.add("Crop Sensor Input is noticed in the screen ", "Crop Sensor Input",
									crop_sensor_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Crop Sensor Input is not observed in the screen ", crop_sensor_title,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					Thread.sleep(3000);

					// Select any option from device drop down -
					//cropPage.getdDevicestxt().click();
					cropPage.getDevicedropdown().click();
					ATUReports.add("Clicked on the device drop down and selected the Davis GroWeather, FARS", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Select any option from sensor drop down
					//cropPage.getSensortxt().click();
					cropPage.getSensordropdown().click();
					ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					

					// Click on next button in the Crop Sensor Input
					if (cropPage.getNext_nxt_save_btn().isEnabled()) {
						cropPage.getNext_nxt_save_btn().click();
						ATUReports.add("Next button is enabled in the Crop Sensor Input and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);
					} else {
						ATUReports.add("Next button is not enabled Crop Sensor Input", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
					
					// Verifying tutorial icon
					Thread.sleep(2000);
					Precondition.tutorialDisalogBox();

					// -------CROP VARIETY FIELD------
				
					// Verify Crop title text.
					String crop_sensor_title1 = cropPage.getcropandVariety().getText();
					// System.out.println(title);
					if (crop_sensor_title1.isEmpty()) {
						ATUReports.add("Verify the CROP & VARIETY text  in the screen ", "CROP", crop_sensor_title1,
								LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (crop_sensor_title1.equals("Crop & Variety")) {
							ATUReports.add("Crop & Variety is noticed in the screen ", "Crop & Variety",
									crop_sensor_title1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("CROP is not observed in the screen ", crop_sensor_title1, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					// Click on Skip button in the Edit Crop -Crop screen.
					if (cropPage.getNext_nxt_save_btn().isEnabled()) {
						cropPage.getNext_nxt_save_btn().click();
						ATUReports.add("Skip button is enabled in the Crop and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled Crop Sensor Input", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					// ----GROWING START DATE FIELD------
				
					// Verify Growing degree start date title text.
					String growing_degree_title = cropPage.getgddTitle().getText();
					System.out.println(growing_degree_title);
					if (growing_degree_title.isEmpty()) {
						ATUReports.add("Verify the GROWING DEGREE START DATE (GDD) text  in the screen ",
								"GROWING DEGREE START DATE (GDD)", growing_degree_title, LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {// Growing Degree Start Date (GDD)
						if (growing_degree_title.contains("Growing Degree Start")) {
							ATUReports.add("Growing Degree Start is noticed in the screen ", "Growing Degree Start",
									growing_degree_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Growing Degree Start is not observed in the screen ", growing_degree_title,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

						if (growing_degree_title.contains("Date (GDD)")) {
							ATUReports.add("Date (GDD) is noticed in the screen ", "Date (GDD)", growing_degree_title,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Date (GDD) is not observed in the screen ", growing_degree_title,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					
				
					
					//get the value of the optional and click on it			
					Thread.sleep(4000);
					if(cropPage.getcropGddOptional().isDisplayed()){			
						ATUReports.add("Optional Slier is displayed and move the slider in gdd ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
						Thread.sleep(2000);
								WebElement optionalElement =cropPage.getcropGddOptional();
						int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
						int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
						System.out.println("xInitialOptional gdd "+xInitialOptional+ "yInitialOptional gdd"+yInitialOptional);
						
					
						 //Swiping list based on coordinates
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
			

					// verify the date is enabled or not and then Click on
					// the date tab
					cropPage.getDatebtn().click();

					// Click on done button
					cropPage.getNext_nxt_save_btn().click();

					// Click on Skip button in the Edit Crop -Crop screen.
					if (cropPage.getNext_nxt_save_btn().isEnabled()) {
						cropPage.getNext_nxt_save_btn().click();
						ATUReports.add("Next button is enabled in the Crop Sensor Input and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("Next button is not enabled Crop Sensor Input", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					// ---------GDD TARGET------------
					// Verify GDD Target values
					// Verify Crop title text.
					String crop_target = cropPage.getTitletxt().getText();
					// System.out.println(title);
					if (crop_target.isEmpty()) {
						ATUReports.add("Crop Target element is not available in the screen ", "CROP TARGET",
								crop_target, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (crop_target.contains("GDD Target")) {
							ATUReports.add("GDD Target is noticed in the screen ", "GDD Target", crop_target,
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("GDD Target is not observed in the screen ", crop_target, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					// Verify gdd target text box
					MobileElement temparatureBox = cropPage.gesetcroptarget();
					String textDefaultText = temparatureBox.getText();
					System.out.println(textDefaultText + "---textDefaultText---");
					if (temparatureBox != null && temparatureBox.isDisplayed()) {

						ATUReports.add("Mobilize temparature value text box is displayed, and its default value is - "
								+ textDefaultText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						// Entered minimum value
						cropPage.gesetcroptarget().click();
						cropPage.gesetcroptarget().clear();
						cropPage.gesetcroptarget().sendKeys(readCrop.crop_Gdd_Min);
						ATUReports.add("Entered minimum value", cropPage.gesetcroptarget().getText(), LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driver.hideKeyboard();

						// Verify next button is enabled
						nextButtonEnabled();

						// Verify out of range value
						cropPage.gesetcroptarget().click();
						cropPage.gesetcroptarget().clear();				
						cropPage.gesetcroptarget().sendKeys(readCrop.crop_Gdd_OutOfRange);
						ATUReports.add("Entered out of range  value", cropPage.gesetcroptarget().getText(),
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driver.hideKeyboard();

						// Verify Observe Next button is not Enabled.
						String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
						if (frostPage.getNext_nxt_save_btn().isEnabled()) {
							ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Next button is not enabled in the  " + frost_thresholdTitle1, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
						Thread.sleep(2000);

						// Verify maximum value

						cropPage.gesetcroptarget().click();
						cropPage.gesetcroptarget().clear();
						cropPage.gesetcroptarget().sendKeys(readCrop.crop_Gdd_Max);
						ATUReports.add("Entered out of range  value", cropPage.gesetcroptarget().getText(),
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driver.hideKeyboard();

						if (cropPage.getNext_nxt_save_btn().isEnabled()) {
							cropPage.getNext_nxt_save_btn().click();
							ATUReports.add(
									"Next  button is enabled and Clicked on Skip button in the crop target screen ",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							ATUReports.add("Next button is not enabled in the crop target screen", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

					} else {
						ATUReports.add("temparature value text box  is not observed in the screen ", textDefaultText,
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						driver.close();
					}
					
					

					// -------GDD CALICULATION TYPE---------

					// Verify Crop title text.
					String crop_calculation_type = cropPage.getTitletxt().getText();
					// System.out.println(title);
					if (crop_calculation_type.isEmpty()) {
						ATUReports.add("GDD Calculation Type element is not available in the screen ", LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (crop_calculation_type.contains("GDD Calculation Type")) {
							ATUReports.add("crop_calculation_type is noticed in the screen ", "GDD Calculation Type",
									crop_calculation_type, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
						else {
							ATUReports.add("GDD Calculation Type is not observed in the screen ", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					if (cropPage.getNext_nxt_save_btn().isEnabled()) {
						cropPage.getNext_nxt_save_btn().click();
						ATUReports.add("Next  button is enabled and Clicked on Skip button in the crop target screen ",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled in  crop target scree", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
					

					// --------LOWER THRESHOLD-------

					// Verify Crop title text.

					String lowerthreshold = cropPage.getTitletxt().getText();
					// System.out.println(title);
					if (lowerthreshold.isEmpty()) {
						ATUReports.add("LOWER THRESHOLD element is not available in the screen ", LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (lowerthreshold.contains("Lower Temperature Threshold")) {
							ATUReports.add("Lower Temperature Threshold is noticed in the screen ",
									"Lower Temperature Threshold", lowerthreshold, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

						else {
							ATUReports.add("LOWER THRESHOLD is not observed in the screen ", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					// Verify F units from temperature box

					// Verify temperature units from current page
					String actualTemperatureUnits = cropPage.getcropTempUnits().getText();
					System.out.println(actualTemperatureUnits + "---actualTemperatureUnits---");
					System.out.println(actualTemperatureUnits + "---actualTemperatureUnits");
					System.out.println(expectedFtxt + "----expectedTempTxt");

					if (actualTemperatureUnits.isEmpty()) {
						ATUReports.add("temperatureUnits element is not visible", null, LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (actualTemperatureUnits.contains(expectedFtxt)) {
							ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
									actualTemperatureUnits, expectedFtxt, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify Tap on Temperature value box.

							MobileElement temparatureBoxLower = cropPage.getthresholdtxtfld();
							String textDefaultTextTwo = temparatureBoxLower.getText();
							System.out.println(textDefaultTextTwo + "---textDefaultText1---");

							if (temparatureBoxLower != null && temparatureBoxLower.isDisplayed()) {

								ATUReports.add(
										"Mobilize temparature value text box is displayed, and its default value is - "
												+ textDefaultTextTwo,
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Verify minimum value
								cropPage.getthresholdtxtfld().click();
								Thread.sleep(1000);
								cropPage.getthresholdtxtfld().sendKeys(Keys.DELETE);
								cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
								Thread.sleep(2000);
								cropPage.getthresholdtxtfld().sendKeys(readCrop.low_TempF_Min);
								driver.hideKeyboard();
								ATUReports.add("Entered minimum value in the threshold field ",
										cropPage.getthresholdtxtfld().getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								Thread.sleep(2000);

								// Verify next button is enabled
								nextButtonEnabled();

								// Verify out of range value
								cropPage.getthresholdtxtfld().click();
								Thread.sleep(1000);
								cropPage.getthresholdtxtfld().sendKeys(Keys.DELETE);
								cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
								Thread.sleep(2000);
								cropPage.getthresholdtxtfld().sendKeys(readCrop.low_TempF_OutOfRange);

								driver.hideKeyboard();
								ATUReports.add("Entered out of range value in the threshold field ",
										cropPage.getthresholdtxtfld().getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);

								// Verify Observe Next button is Enabled.
								String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
								if (frostPage.getNext_nxt_save_btn().isEnabled()) {
									ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("Next button is not enabled in the  " + frost_thresholdTitle1,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
								Thread.sleep(2000);

								// Verify maximum value
								cropPage.getthresholdtxtfld().click();
								Thread.sleep(1000);
								cropPage.getthresholdtxtfld().sendKeys(Keys.DELETE);
								cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
								Thread.sleep(2000);
								cropPage.getthresholdtxtfld().sendKeys(readCrop.low_TempF_Max);
								driver.hideKeyboard();
								ATUReports.add("Entered out of range value in the threshold field ",
										cropPage.getthresholdtxtfld().getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);

								// clicked on next button
								if (cropPage.getNext_nxt_save_btn().isEnabled()) {
									cropPage.getNext_nxt_save_btn().click();
									ATUReports.add(
											"Next  button is enabled and Clicked on Skip button in the crop lower temp  screen ",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("Next button is not enabled in crop lower temp scree", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

							} else {
								ATUReports.add("temparature value text box  is not observed in the screen ",
										textDefaultTextTwo, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								driver.close();
							}

							// ------UPPER THRESHOLD---------

							// Verify Upper temperature threshold

							//Verify optional				
							Thread.sleep(4000);
							if(cropPage.getcropUpperOptional().isDisplayed()){			
								ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
								Thread.sleep(4000);
										WebElement optionalElement =cropPage.getcropUpperOptional();
								int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
								int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
								System.out.println("xInitial in upper optional"+xInitialOptional+ "yInitial in upper optional"+yInitialOptional);
								
								 //Swiping list based on coordinates
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

							// Verify Crop title text.
							String upperthreshold = cropPage.getTitletxt().getText();
							if (upperthreshold.isEmpty()) {
								ATUReports.add("UPPER THRESHOLD element is not available in the screen ", LogAs.WARNING,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (upperthreshold.contains("Upper Temperature Threshold")) {
									ATUReports.add("Upper Temperature Threshold is noticed in the screen ",
											"Upper Temperature Threshold", upperthreshold, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

								else {
									ATUReports.add("Upper Temperature Threshold is not observed in the screen ",
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}

							// Verify units
							MobileElement temparatureBoxUpper = cropPage.getupthreshold();
							String textDefaultTextThree = temparatureBoxUpper.getText();
							System.out.println(textDefaultTextThree + "---textDefaultText---");

							ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
									actualTemperatureUnits, expectedTempTxt, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							if (temparatureBoxUpper != null && temparatureBoxUpper.isDisplayed()) {

								ATUReports.add(
										"Mobilize temparature value text box is displayed, and its default value is - "
												+ textDefaultTextThree,
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Entered out of range value
								cropPage.getupthreshold().click();
								Thread.sleep(1000);
								cropPage.getupthreshold().sendKeys(Keys.DELETE);
								cropPage.getupthreshold().sendKeys(Keys.INSERT);
								Thread.sleep(2000);
								cropPage.getupthreshold().sendKeys(readCrop.upper_TempF_OutOfRange);
								driver.hideKeyboard();
								ATUReports.add("Entered out of range value in the threshold field ",
										cropPage.getupthreshold().getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(1000);

								// Verify Observe Next button is not Enabled.
								String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
								if (frostPage.getNext_nxt_save_btn().isEnabled()) {
									ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("Next button is not enabled in the  " + frost_thresholdTitle1,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
								Thread.sleep(2000);

								// Entered minimum value
								MobileElement minm = (MobileElement) driver
										.findElementById("com.davis.mobilize:id/upperThreshold");
								minm.click();
								Thread.sleep(1000);
								minm.clear();
								Thread.sleep(2000);
								minm.sendKeys(readCrop.upper_TempF_Min);
								driver.hideKeyboard();
								System.out.println("entered min value");
								ATUReports.add("Entered minimum value in the threshold field ",
										cropPage.getupthreshold().getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);

								// Verify next button is enabled
								nextButtonEnabled();

								// Entered maximum value
								cropPage.getupthreshold().click();
								Thread.sleep(1000);
								cropPage.getupthreshold().sendKeys(Keys.DELETE);
								cropPage.getupthreshold().sendKeys(Keys.INSERT);
								Thread.sleep(2000);
								cropPage.getupthreshold().sendKeys(readCrop.upper_Temp_MaxF);
								driver.hideKeyboard();
								System.out.println("entered max value");
								ATUReports.add("Entered maximum value in the threshold field ",
										cropPage.getupthreshold().getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);

								// clicked on next button
								if (cropPage.getNext_nxt_save_btn().isEnabled()) {
									cropPage.getNext_nxt_save_btn().click();
									ATUReports.add(
											"Next  button is enabled and Clicked on Skip button in the crop lower temp  screen ",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("Next button is not enabled in crop lower temp scree", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

							} else {
								ATUReports.add("temparature value text box  is not observed in the screen ",
										textDefaultTextThree, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								driver.close();
							}

							// ----------CUTT OFF METHOD-------------

							// Verify Crop title text.

							String cutoffmethod = cropPage.getTitletxt().getText();
							// System.out.println(title);
							if (cutoffmethod.isEmpty()) {
								ATUReports.add("CUTOFF METHOD element is not available in the screen ", LogAs.WARNING,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (cutoffmethod.contains("Cutoff Method")) {
									ATUReports.add("Cutoff Method is noticed in the screen ", "Cutoff Method",
											cutoffmethod, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

								else {
									ATUReports.add("Cutoff Method is not observed in the screen ", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}

							if (cropPage.getNext_nxt_save_btn().isEnabled()) {
								cropPage.getNext_nxt_save_btn().click();
								ATUReports.add(
										"Skip  button is enabled and Clicked on Skip button in the CUT OFF screen ",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								ATUReports.add("Next button is not enabled in the CUT OFF screen", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

							// -------------CHILL START
							// DATE----------------------

							// Verify Crop title text.
							String chillstartdate = cropPage.getTitletxt().getText();
							// System.out.println(title);
							if (chillstartdate.isEmpty()) {
								ATUReports.add("Chill Start Date element is not available in the screen ",
										LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (chillstartdate.contains("Chill Start Date")) {
									ATUReports.add(" CHILL START DATE is noticed in the screen ", "Chill Start Date",
											chillstartdate, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

								else {
									ATUReports.add("Chill Start Date is not observed in the screen ", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}

							// get the value of the optional and click on it		
							Thread.sleep(4000);
							if(cropPage.getcropChillstartDateOptional().isDisplayed()){			
								ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
								Thread.sleep(4000);
										WebElement optionalElement =cropPage.getcropChillstartDateOptional();
								int xInitialOptionalStrDate = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
								int yInitialOptionalStrDate = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
								System.out.println("xInitialOptionalStrDate"+xInitialOptionalStrDate+ "yInitial in upper optional"+yInitialOptionalStrDate);
								//driver.swipe(xInitialOptionalStrDate, yInitialOptionalStrDate, xInitialOptionalStrDate+80, yInitialOptionalStrDate, 5000);
								
								
								 //Swiping list based on coordinates
								if(xInitialOptionalStrDate<1200){  
									driver.swipe(xInitialOptionalStrDate, yInitialOptionalStrDate, xInitialOptionalStrDate+80, yInitialOptionalStrDate, 5000);
									//System.out.println("in 1st loop optional");
								}else{				
										if(xInitialOptionalStrDate>1200){
										driver.swipe(xInitialOptionalStrDate, yInitialOptionalStrDate, xInitialOptionalStrDate+120, yInitialOptionalStrDate, 5000);
											//System.out.println("in 2nd loop optional");
										}
									
								}  
							Thread.sleep(2000);
							}else{
								ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

							// verify the date is enabled or not
							// and then Click on
							// the date tab
							cropPage.getdateTab().click();

							Thread.sleep(2000);
							// Click on done button
							cropPage.getNext_nxt_save_btn().click();

							if (cropPage.getNext_nxt_save_btn().isEnabled()) {
								cropPage.getNext_nxt_save_btn().click();
								ATUReports.add(
										"Skip  button is enabled and Clicked on Skip button in the CHILL START DATE screen ",
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								ATUReports.add("Next button is not enabled in the CHILL START DATE screen ",
										LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

							cropPage.getNext_nxt_save_btn().click();

							/// ---------CHILLING TARGET-------------

							// Verify Crop title text.
							String chillingthreshold = cropPage.getTitletxt().getText();
							// System.out.println(title);
							if (chillingthreshold.isEmpty()) {
								ATUReports.add("CHILLING TARGET element is not available in the screen ", LogAs.WARNING,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (chillingthreshold.contains("Chilling Target")) {
									ATUReports.add("Chilling Target is noticed in the screen ", "Chilling Target",
											chillingthreshold, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

								else {
									ATUReports.add("CHILLING TARGET is not observed in the screen ", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}

							// Verify chilling target temp units
							MobileElement temparatureBoxtarget = cropPage.getchillingtargetTextBx();
							String textDefaultTextFour = temparatureBoxtarget.getText();
							System.out.println(textDefaultTextFour + "---textDefaultTextFour---");
							String targetUnits = cropPage.getchillingTargetUnits().getText();

							ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
									targetUnits, targetUnits, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							if (temparatureBoxtarget != null && temparatureBoxtarget.isDisplayed()) {

								ATUReports.add(
										"Mobilize temparature value text box is displayed, and its default value is Empty - "
												+ textDefaultTextFour,
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Enter minimum value
								cropPage.getchillingtargetTextBx().click();
								Thread.sleep(1000);
								cropPage.getchillingtargetTextBx().sendKeys(Keys.DELETE);
								cropPage.getchillingtargetTextBx().sendKeys(Keys.ENTER);
								Thread.sleep(1000);

								cropPage.getchillingtargetTextBx().sendKeys(readCrop.chilling_Target_Min);
								driver.hideKeyboard();
								ATUReports.add("Entered minimum value in the threshold field ", textDefaultTextFour,
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);

								// Verify next button is enabled
								nextButtonEnabled();

								// Enter out of range value
								cropPage.getchillingtargetTextBx().click();
								Thread.sleep(1000);
								cropPage.getchillingtargetTextBx().sendKeys(Keys.DELETE);
								cropPage.getchillingtargetTextBx().sendKeys(Keys.ENTER);
								Thread.sleep(1000);

								cropPage.getchillingtargetTextBx().sendKeys(readCrop.chilling_Target_OutOfRange);
								driver.hideKeyboard();
								ATUReports.add("Entered out of range value in the threshold field ",
										cropPage.getchillingtargetTextBx().getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);

								// Verify Observe Next button is Enabled.
								String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
								if (frostPage.getNext_nxt_save_btn().isEnabled()) {
									ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("Next button is not enabled in the  " + frost_thresholdTitle1,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
								Thread.sleep(2000);

								// Enter maximum value
								cropPage.getchillingtargetTextBx().click();
								Thread.sleep(1000);
								cropPage.getchillingtargetTextBx().sendKeys(Keys.DELETE);
								cropPage.getchillingtargetTextBx().sendKeys(Keys.ENTER);
								Thread.sleep(1000);

								cropPage.getchillingtargetTextBx().sendKeys(readCrop.chilling_Target_Max);

								driver.hideKeyboard();
								ATUReports.add("Entered maximum value in the threshold field ",
										cropPage.getchillingtargetTextBx().getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);

								// Clicked on next button
								if (cropPage.getNext_nxt_save_btn().isEnabled()) {
									cropPage.getNext_nxt_save_btn().click();
									ATUReports.add(
											"Skip  button is enabled and Clicked on Skip button in the CHILLING THRESHOLD screen ",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									ATUReports.add("Next button is not enabled in the CHILLING THRESHOLD screen  ",
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

								// Verify title
								String complete_crop_setup = cropPage.getTitletxt().getText();
								if (complete_crop_setup.isEmpty()) {
									ATUReports.add("Verify the Complete Crop Setup text  in the screen ",
											"Complete Crop Setup", complete_crop_setup, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (complete_crop_setup.contains("Complete Crop Setup")) {
										ATUReports.add(
												"Complete Crop Setup is noticed in the screen, sucessfully skipped rest of the screen in between the screens",
												"Complete Crop Setup", complete_crop_setup, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("Complete Crop Setup is not observed in the screen ",
												complete_crop_setup, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}
								Thread.sleep(2000);

								// Verify save button is displayed or not.

								MobileElement saveButton = weatherPage.getNext_nxt_save_btnn();
								String saveText = saveButton.getText();
								if (weatherPage.getNext_nxt_save_btnn() != null && saveButton.isDisplayed()) {
									if (saveText.equals("Save")) {

										ATUReports.add(
												saveText + " button is displayed  in CROP set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box",
												"Save", saveText, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
										// saveButton.click();
										Thread.sleep(2000);

									} else {
										ATUReports.add("Mobilize " + saveText + " button is not displayed. ",
												readFrostData.ButtonTextThree, saveText, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

								} else {
									driver.close();
									return;
								}

							} else {
								ATUReports.add("temparature value text box  is not observed in the screen ",
										textDefaultTextFour, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								driver.close();
							}

							// Comparing f vs c -------------------
} else {
							if (actualTemperatureUnits.contains(expectedCText)) {
								ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
										actualTemperatureUnits, expectedTempTxt, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								System.out.println(actualTemperatureUnits + "----actualTemperatureUnits-c-");

								// Verify Tap on Temperature value box.

								MobileElement temparatureBoxLower = cropPage.getthresholdtxtfld();
								String textDefaultTextTwo = temparatureBoxLower.getText();
								System.out.println(textDefaultTextTwo + "---textDefaultText1---");

								if (temparatureBoxLower != null && temparatureBoxLower.isDisplayed()) {

									ATUReports.add(
											"Mobilize temparature value text box is displayed, and its default value is - "
													+ textDefaultTextTwo,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Verify minimum value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(1000);
									cropPage.getthresholdtxtfld().sendKeys(Keys.DELETE);
									cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
									Thread.sleep(2000);

									cropPage.getthresholdtxtfld().sendKeys(readCrop.low_TempC_Min);
									driver.hideKeyboard();
									ATUReports.add("Entered minimum value in the threshold field ",
											cropPage.getthresholdtxtfld().getText(), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									Thread.sleep(2000);

									// Verify next button is enabled
									nextButtonEnabled();

									// Verify out of range value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(1000);
									cropPage.getthresholdtxtfld().sendKeys(Keys.DELETE);
									cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
									Thread.sleep(2000);

									cropPage.getthresholdtxtfld().sendKeys(readCrop.low_TempC_OutOfRange);
									driver.hideKeyboard();
									ATUReports.add("Entered out of range value in the threshold field ",
											cropPage.getthresholdtxtfld().getText(), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									// Verify Observe Next button is Enabled.
									String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
									if (frostPage.getNext_nxt_save_btn().isEnabled()) {
										ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("Next button is not enabled in the  " + frost_thresholdTitle1,
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
									Thread.sleep(2000);

									// Verify maximum value
									cropPage.getthresholdtxtfld().click();
									Thread.sleep(1000);
									cropPage.getthresholdtxtfld().sendKeys(Keys.DELETE);
									cropPage.getthresholdtxtfld().sendKeys(Keys.INSERT);
									Thread.sleep(2000);
									cropPage.getthresholdtxtfld().sendKeys(readCrop.low_TempC_Max);
									driver.hideKeyboard();
									ATUReports.add("Entered out of range value in the threshold field ",
											cropPage.getthresholdtxtfld().getText(), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									// clicked on next button
									if (cropPage.getNext_nxt_save_btn().isEnabled()) {
										cropPage.getNext_nxt_save_btn().click();
										ATUReports.add(
												"Next  button is enabled and Clicked on Skip button in the crop lower temp  screen ",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("Next button is not enabled in crop lower temp scree",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

								} else {
									ATUReports.add("temparature value text box  is not observed in the screen ",
											textDefaultTextTwo, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								}

								// ------UPPER THRESHOLD---------

								//Verify optional				
								Thread.sleep(4000);
								if(cropPage.getcropUpperOptional().isDisplayed()){			
									ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
									Thread.sleep(4000);
											WebElement optionalElement =cropPage.getcropUpperOptional();
									int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
									int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
									System.out.println("xInitial in upper optional"+xInitialOptional+ "yInitial in upper optional"+yInitialOptional);
									//driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
									
									 //Swiping list based on coordinates
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

								// Verify Crop title text.
								String upperthreshold = cropPage.getTitletxt().getText();
								// System.out.println(title);
								if (upperthreshold.isEmpty()) {
									ATUReports.add("UPPER THRESHOLD element is not available in the screen ",
											LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (upperthreshold.contains("Upper Temperature Threshold")) {
										ATUReports.add("Upper Temperature Threshold is noticed in the screen ",
												"Upper Temperature Threshold", upperthreshold, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

									else {
										ATUReports.add("Upper Temperature Threshold is not observed in the screen ",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}

								// Verify units
								MobileElement temparatureBoxUpper = cropPage.getupthreshold();
								String textDefaultTextThree = temparatureBoxUpper.getText();
								System.out.println(textDefaultTextThree + "---textDefaultText---");

								ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
										actualTemperatureUnits, expectedTempTxt, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								if (temparatureBoxUpper != null && temparatureBoxUpper.isDisplayed()) {

									ATUReports.add(
											"Mobilize temparature value text box is displayed, and its default value is - "
													+ textDefaultTextThree,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Entered maximum value
									cropPage.getupthreshold().click();
									Thread.sleep(2000);
									cropPage.getupthreshold().sendKeys(Keys.DELETE);
									cropPage.getupthreshold().sendKeys(Keys.INSERT);
									Thread.sleep(2000);
									cropPage.getupthreshold().sendKeys(readCrop.upper_TempC_Max);
									driver.hideKeyboard();
									ATUReports.add("Entered maximum value in the threshold field ",
											cropPage.getupthreshold().getText(), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									// Verify next button is enabled
									nextButtonEnabled();
									Thread.sleep(1000);

									// Entered out of range value

									cropPage.getupthreshold().click();
									Thread.sleep(1000);
									cropPage.getupthreshold().sendKeys(Keys.DELETE);
									cropPage.getupthreshold().sendKeys(Keys.INSERT);
									Thread.sleep(2000);
									cropPage.getupthreshold().sendKeys(readCrop.upper_TempC_OutOfRange);
									driver.hideKeyboard();
									ATUReports.add("Entered out of range value in the threshold field ",
											cropPage.getupthreshold().getText(), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(1000);

									// Verify Observe Next button is not
									// Enabled.
									String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
									if (frostPage.getNext_nxt_save_btn().isEnabled()) {
										ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("Next button is not enabled in the  " + frost_thresholdTitle1,
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
									Thread.sleep(2000);

									// Entered minimum value
									cropPage.getupthreshold().click();
									Thread.sleep(1000);
									cropPage.getupthreshold().sendKeys(Keys.DELETE);
									cropPage.getupthreshold().sendKeys(Keys.INSERT);
									Thread.sleep(1000);
									cropPage.getupthreshold().sendKeys(readCrop.upper_TempC_Min);
									driver.hideKeyboard();
									ATUReports.add("Entered minimum value in the threshold field ",
											cropPage.getupthreshold().getText(), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									// clicked on next button
									if (cropPage.getNext_nxt_save_btn().isEnabled()) {
										cropPage.getNext_nxt_save_btn().click();
										ATUReports.add(
												"Next  button is enabled and Clicked on Skip button in the crop lower temp  screen ",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("Next button is not enabled in crop lower temp scree",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

								} else {
									ATUReports.add("temparature value text box  is not observed in the screen ",
											textDefaultTextThree, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								}

								// ----------CUTT OFF METHOD-------------

								// Verify Crop title text.

								String cutoffmethod = cropPage.getTitletxt().getText();
								// System.out.println(title);
								if (cutoffmethod.isEmpty()) {
									ATUReports.add("CUTOFF METHOD element is not available in the screen ",
											LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (cutoffmethod.contains("Cutoff Method")) {
										ATUReports.add("Cutoff Method is noticed in the screen ", "Cutoff Method",
												cutoffmethod, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

									else {
										ATUReports.add("Cutoff Method is not observed in the screen ", LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}

								if (cropPage.getNext_nxt_save_btn().isEnabled()) {
									cropPage.getNext_nxt_save_btn().click();
									ATUReports.add(
											"Skip  button is enabled and Clicked on Skip button in the CUT OFF screen ",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									ATUReports.add("Next button is not enabled in the CUT OFF screen", LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

								// -------------CHILL START
								// DATE----------------------

								// Verify Crop title text.
								String chillstartdate = cropPage.getTitletxt().getText();
								if (chillstartdate.isEmpty()) {
									ATUReports.add("Chill Start Date element is not available in the screen ",
											LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (chillstartdate.contains("Chill Start Date")) {
										ATUReports.add(" CHILL START DATE is noticed in the screen ",
												"Chill Start Date", chillstartdate, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

									else {
										ATUReports.add("Chill Start Date is not observed in the screen ", LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}


								// get the value of the optional and click on it
			
								Thread.sleep(4000);
								if(cropPage.getcropChillstartDateOptional().isDisplayed()){			
									ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
									Thread.sleep(4000);
											WebElement optionalElement =cropPage.getcropChillstartDateOptional();
									int xInitialOptionalStrDate = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
									int yInitialOptionalStrDate = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
									System.out.println("xInitialOptionalStrDate"+xInitialOptionalStrDate+ "yInitial in upper optional"+yInitialOptionalStrDate);
									//driver.swipe(xInitialOptionalStrDate, yInitialOptionalStrDate, xInitialOptionalStrDate+80, yInitialOptionalStrDate, 5000);
									
									
									//Swiping list based on coordinates
									if(xInitialOptionalStrDate<1200){  
										driver.swipe(xInitialOptionalStrDate, yInitialOptionalStrDate, xInitialOptionalStrDate+80, yInitialOptionalStrDate, 5000);
										//System.out.println("in 1st loop optional");
									}else{				
											if(xInitialOptionalStrDate>1200){
											driver.swipe(xInitialOptionalStrDate, yInitialOptionalStrDate, xInitialOptionalStrDate+120, yInitialOptionalStrDate, 5000);
												//System.out.println("in 2nd loop optional");
											}
										
									}  
								Thread.sleep(2000);
								}else{
									ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

								// verify the date is enabled or not
								// and then Click on
								// the date tab
								cropPage.getdateTab().click();

								Thread.sleep(2000);
								// Click on done button
								cropPage.getNext_nxt_save_btn().click();

								if (cropPage.getNext_nxt_save_btn().isEnabled()) {
									cropPage.getNext_nxt_save_btn().click();
									ATUReports.add(
											"Skip  button is enabled and Clicked on Skip button in the CHILL START DATE screen ",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									ATUReports.add("Next button is not enabled in the CHILL START DATE screen ",
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

								cropPage.getNext_nxt_save_btn().click();

								/// ---------CHILLING TARGET-------------

								// Verify Crop title text.
								String chillingthreshold = cropPage.getTitletxt().getText();
								// System.out.println(title);
								if (chillingthreshold.isEmpty()) {
									ATUReports.add("CHILLING TARGET element is not available in the screen ",
											LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (chillingthreshold.contains("Chilling Target")) {
										ATUReports.add("Chilling Target is noticed in the screen ", "Chilling Target",
												chillingthreshold, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

									else {
										ATUReports.add("CHILLING TARGET is not observed in the screen ", LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}

								// Verify chilling target temp units
								MobileElement temparatureBoxtarget = cropPage.getchillingtargetTextBx();
								String textDefaultTextFour = temparatureBoxtarget.getText();
								System.out.println(textDefaultTextFour + "---textDefaultTextFour---");
								String targetUnits = cropPage.getchillingTargetUnits().getText();

								ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
										targetUnits, targetUnits, LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								if (temparatureBoxtarget != null && temparatureBoxtarget.isDisplayed()) {

									ATUReports.add(
											"Mobilize temparature value text box is displayed, and its default value is Empty - "
													+ textDefaultTextFour,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									
									
									// Enter maximum value
									cropPage.getchillingtargetTextBx().click();
									Thread.sleep(2000);
									cropPage.getchillingtargetTextBx().sendKeys(Keys.DELETE);
									cropPage.getchillingtargetTextBx().sendKeys(Keys.INSERT);
									Thread.sleep(3000);
									
									cropPage.getchillingtargetTextBx().sendKeys(readCrop.chilling_Target_Max);
									driver.hideKeyboard();
									ATUReports.add("Entered maximum value in the threshold field ",
											cropPage.getchillingtargetTextBx().getText(), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);
				

									// Verify next button is enabled
									nextButtonEnabled();

									// Enter out of range value
									cropPage.getchillingtargetTextBx().click();
									Thread.sleep(1000);
									cropPage.getchillingtargetTextBx().sendKeys(Keys.DELETE);
									cropPage.getchillingtargetTextBx().sendKeys(Keys.INSERT);
									Thread.sleep(2000);
									cropPage.getchillingtargetTextBx().sendKeys(readCrop.chilling_Target_OutOfRange);
									driver.hideKeyboard();
									ATUReports.add("Entered out of range value in the threshold field ",
											cropPage.getchillingtargetTextBx().getText(), LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									// Verify Observe Next button is Enabled.
									String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
									if (frostPage.getNext_nxt_save_btn().isEnabled()) {
										ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("Next button is not enabled in the  " + frost_thresholdTitle1,
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
									Thread.sleep(2000);

								
									
									// Enter minimum value
									cropPage.getchillingtargetTextBx().click();
									Thread.sleep(2000);
									cropPage.getchillingtargetTextBx().sendKeys(Keys.DELETE);
									cropPage.getchillingtargetTextBx().sendKeys(Keys.INSERT);
									Thread.sleep(4000);
									cropPage.getchillingtargetTextBx().sendKeys(readCrop.chilling_Target_Min);
									driver.hideKeyboard();
									ATUReports.add("Entered minimum value in the threshold field ", textDefaultTextFour,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									Thread.sleep(2000);

									// Clicked on next button
									if (cropPage.getNext_nxt_save_btn().isEnabled()) {
										cropPage.getNext_nxt_save_btn().click();
										ATUReports.add(
												"Skip  button is enabled and Clicked on Skip button in the CHILLING THRESHOLD screen ",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										ATUReports.add("Next button is not enabled in the CHILLING THRESHOLD screen  ",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

									// Verify title

									String complete_crop_setup = cropPage.getTitletxt().getText();
									if (complete_crop_setup.isEmpty()) {
										ATUReports.add("Verify the Complete Crop Setup text  in the screen ",
												"Complete Crop Setup", complete_crop_setup, LogAs.WARNING,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										if (complete_crop_setup.contains("Complete Crop Setup")) {
											ATUReports.add(
													"Complete Crop Setup is noticed in the screen, sucessfully skipped rest of the screen in between the screens",
													"Complete Crop Setup", complete_crop_setup, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("Complete Crop Setup is not observed in the screen ",
													complete_crop_setup, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
									Thread.sleep(2000);

									// Verify save button is displayed or not.

									MobileElement saveButton = weatherPage.getNext_nxt_save_btnn();
									String saveText = saveButton.getText();
									if (weatherPage.getNext_nxt_save_btnn() != null && saveButton.isDisplayed()) {
										if (saveText.equals("Save")) {

											ATUReports.add(
													saveText + " button is displayed  in CROP set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box",
													"Save", saveText, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											// saveButton.click();
											Thread.sleep(2000);

										} else {
											ATUReports.add("Mobilize " + saveText + " button is not displayed. ",
													readFrostData.ButtonTextThree, saveText, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}

									} else {
										driver.close();
										return;
									}

								} else {
									ATUReports.add("temparature value text box  is not observed in the screen ",
											textDefaultTextFour, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									driver.close();
								}
							}

						}
					}

					//
				} else {
					ATUReports.add("Users preferences Temperature list is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("Users preferences list is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driver.close();
			}
			
		} catch (InterruptedException i) {
			i.printStackTrace();
		}

	}

	// Verify clicked on next button

	public void clickonNextButton() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}
	}

	// This method is used to verify next button
	public void nextButtonEnabled() throws InterruptedException {
		String frost_thresholdTitle = frostPage.getTitletxt().getText();
		if (frostPage.getNext_nxt_save_btn().isEnabled()) {
			ATUReports.add("Next button is enabled in the " + frost_thresholdTitle, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} else {
			ATUReports.add("Next button is not enabled in the " + frost_thresholdTitle, LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		Thread.sleep(2000);
	}

	// Verify to clicked on next button
	public void clikcedOnNext() throws InterruptedException {
		String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
		if (frostPage.getNext_nxt_save_btn().isEnabled()) {
			frostPage.getNext_nxt_save_btn().click();
			ATUReports.add("Next button is not enabled in the " + frost_thresholdTitle1, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} else {
			ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1, LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		Thread.sleep(2000);
	}

}












































































//**** This code is for future purpose*******

/*	//click on particular view 
Thread.sleep(2000);
for (int j = 1; j <= 4; j++) {
	System.out.println(j+"--j---");
	driver.findElement(By.xpath("//android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout["+j+"]/android.widget.RelativeLayout")).click();
	Thread.sleep(2000);
	if (newscreenpage.getshareIcon() != null && newscreenpage.getshareIcon().isEnabled()) {
		Thread.sleep(3000);
		ATUReports.add(
				"verified the share icon in the : " + j
						+ " view displayed in the Home screen,Share icon is enabled in the screen ",
				LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
		// Verify tap on crop title-we are using generic code for titles bcs titles paths are changing from one to another.
		Thread.sleep(1000);
		List <WebElement> cropTitle=driver.findElements(By.id("com.davis.mobilize:id/report_text"));
		for(int i=0;i<=cropTitle.size();i++){
			String cropTitleText =cropTitle.get(i).getText();
			System.out.println(cropTitleText + "---accessabilityid---");							
			if (cropTitleText.contains("CROP")) {
				ATUReports.add("Mobilize " + cropTitleText + "  tab is displayed.", "CROP", cropTitleText,
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				cropTitle.get(i).click();
				
				Thread.sleep(2000);
				ATUReports.add("Mobilize CROP tab is clicked", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				break;
			} else {
				ATUReports.add("Mobilize Report title " + cropTitleText + " tab is not displayed", "CROP",
						cropTitleText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				/// scroll up the current page
				driver.scrollTo("Edit View");
				Thread.sleep(3000);
			}
			
		}
		
		
		

		// break;
	} else {
		System.out.println("I am  inside else");

		// Click on home page back button
		driver.navigate().back();
		Thread.sleep(3000);
		ATUReports.add("Navigate back", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	if (j == 4) {
		// scroll up the current page
				
		 // scroll up the current page	 homepage				
		WebElement listElement =homepage.getviewsList();
		int xInitialList = listElement.getLocation().getX() + listElement.getSize().getWidth()/2;
		int yInitialList = listElement.getLocation().getY() + listElement.getSize().getHeight()/2;
		//int yInitialList = listElement.getLocation().getY();
		System.out.println("=startx "+xInitialList+" "+ yInitialList+"=end y  scroll down to  up the page");
		driver.swipe(xInitialList, yInitialList, xInitialList, yInitialList-730, 5000);//727
		
	j =1;
	Thread.sleep(2000);
	ATUReports.add("Scroll up the view list", LogAs.PASSED,
			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

	}

}
*/








/*
 * //Verify temperature units from current page
 * 
 * 
 * //String actualTemperatureUnits=cropPage.getcropTempUnits().getText();
 * System.out.println(actualTemperatureUnits+"---actualTemperatureUnits---");
 * System.out.println(actualTemperatureUnits+"---actualTemperatureUnits");
 * System.out.println(expectedFtxt+"----expectedTempTxt");
 * 
 * if (actualTemperatureUnits.isEmpty()) { ATUReports.add(
 * "temperatureUnits element is not visible", null, LogAs.WARNING, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * } else { if (actualTemperatureUnits.contains(expectedFtxt)) { ATUReports.add(
 * "TemperatureUnits text is noticed in the screen  same as expected "
 * ,actualTemperatureUnits, expectedTempTxt, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * 
 * // Verify Tap on Temperature value box.
 * 
 * MobileElement temparatureBoxLower= cropPage.getthresholdtxtfld(); String
 * textDefaultTextTwo=temparatureBoxLower.getText();
 * System.out.println(textDefaultTextTwo+"---textDefaultText1---");
 * 
 * if (temparatureBoxLower!= null&&temparatureBoxLower.isDisplayed()) {
 * 
 * ATUReports.add(
 * "Mobilize temparature value text box is displayed, and its default value is - "
 * +textDefaultTextTwo, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * //Verify minimum value cropPage.getthresholdtxtfld().click();
 * Thread.sleep(1000); cropPage.getthresholdtxtfld().clear();
 * Thread.sleep(2000); cropPage.getthresholdtxtfld().sendKeys("4");
 * driver.hideKeyboard(); ATUReports.add(
 * "Entered minimum value in the threshold field "
 * ,cropPage.getthresholdtxtfld().getText(),LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * Thread.sleep(2000);
 * 
 * 
 * //Verify next button is enabled nextButtonEnabled();
 * 
 * 
 * //Verify out of range value cropPage.getthresholdtxtfld().click();
 * Thread.sleep(1000); cropPage.getthresholdtxtfld().clear();
 * Thread.sleep(2000); cropPage.getthresholdtxtfld().sendKeys("16");
 * cropPage.getthresholdtxtfld().sendKeys("15");
 * 
 * driver.hideKeyboard(); ATUReports.add(
 * "Entered out of range value in the threshold field "
 * ,cropPage.getthresholdtxtfld().getText(), LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); Thread.sleep(2000);
 * 
 * 
 * 
 * // Verify Observe Next button is Enabled. String frost_thresholdTitle1 =
 * frostPage.getTitletxt().getText(); if
 * (frostPage.getNext_nxt_save_btn().isEnabled()) { ATUReports.add(
 * "Next button is enabled in the "+frost_thresholdTitle1, LogAs.FAILED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } else { ATUReports.add(
 * "Next button is not enabled in the  "+frost_thresholdTitle1, LogAs.PASSED,
 * new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } Thread.sleep(2000);
 * 
 * //Verify maximum value cropPage.getthresholdtxtfld().click();
 * Thread.sleep(1000); cropPage.getthresholdtxtfld().clear();
 * Thread.sleep(2000); cropPage.getthresholdtxtfld().sendKeys("15");
 * driver.hideKeyboard(); ATUReports.add(
 * "Entered out of range value in the threshold field "
 * ,cropPage.getthresholdtxtfld().getText(), LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); Thread.sleep(2000);
 * 
 * //clicked on next button if (cropPage.getNext_nxt_save_btn().isEnabled()) {
 * cropPage.getNext_nxt_save_btn().click(); ATUReports.add(
 * "Next  button is enabled and Clicked on Skip button in the crop lower temp  screen "
 * , LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } else {
 * ATUReports.add("Next button is not enabled in crop lower temp scree",
 * LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
 * 
 * 
 * 
 * }else{ ATUReports.add(
 * "temparature value text box  is not observed in the screen "
 * ,textDefaultTextTwo, LogAs.FAILED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); driver.close(); }
 * 
 * 
 * //------UPPER THRESHOLD---------
 * 
 * //Verify Upper temperature threshold //("startX", 920); put("startY", 505);
 * put("endX", 1034); put("endY", 504); put("duration", 1.81859375); }});
 * 
 * //Move the optional slider driver.swipe(920, 505, 1034, 505, (int)
 * 1.81859375); ATUReports.add("moved the optional into enable mode",
 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * 
 * // Verify Crop title text. String upperthreshold =
 * cropPage.getTitletxt().getText(); // System.out.println(title); if
 * (upperthreshold.isEmpty()) { ATUReports.add(
 * "UPPER THRESHOLD element is not available in the screen ", LogAs.WARNING, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * } else { if (upperthreshold.contains("Upper Temperature Threshold")) {
 * ATUReports.add("Upper Temperature Threshold is noticed in the screen ",
 * "Upper Temperature Threshold", upperthreshold, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
 * 
 * else { ATUReports.add(
 * "Upper Temperature Threshold is not observed in the screen ", LogAs.FAILED,
 * new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } }
 * 
 * //Verify units MobileElement temparatureBoxUpper= cropPage.getupthreshold();
 * String textDefaultTextThree=temparatureBoxUpper.getText();
 * System.out.println(textDefaultTextThree+"---textDefaultText---");
 * 
 * 
 * ATUReports.add(
 * "TemperatureUnits text is noticed in the screen  same as expected "
 * ,actualTemperatureUnits, expectedTempTxt, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * if (temparatureBoxUpper!= null&&temparatureBoxUpper.isDisplayed()) {
 * 
 * ATUReports.add(
 * "Mobilize temparature value text box is displayed, and its default value is - "
 * +textDefaultTextThree, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * 
 * //Entered maximum value cropPage.getupthreshold().click();
 * Thread.sleep(2000); cropPage.getupthreshold().clear(); Thread.sleep(3000);
 * cropPage.getupthreshold().sendKeys("37");
 * cropPage.getupthreshold().sendKeys("38");
 * cropPage.getupthreshold().sendKeys("26"); driver.hideKeyboard();
 * ATUReports.add("Entered maximum value in the threshold field "
 * ,cropPage.getupthreshold().getText(), LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); Thread.sleep(2000);
 * 
 * 
 * //Verify next button is enabled nextButtonEnabled();
 * 
 * 
 * //Entered out of range value cropPage.getupthreshold().click();
 * Thread.sleep(1000); cropPage.getupthreshold().clear(); Thread.sleep(2000);
 * cropPage.getupthreshold().sendKeys("38"); driver.hideKeyboard();
 * ATUReports.add("Entered out of range value in the threshold field "
 * ,cropPage.getupthreshold().getText(), LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); Thread.sleep(2000);
 * 
 * 
 * 
 * // Verify Observe Next button is not Enabled. String frost_thresholdTitle1 =
 * frostPage.getTitletxt().getText(); if
 * (frostPage.getNext_nxt_save_btn().isEnabled()) { ATUReports.add(
 * "Next button is enabled in the "+frost_thresholdTitle1, LogAs.FAILED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } else { ATUReports.add(
 * "Next button is not enabled in the  "+frost_thresholdTitle1, LogAs.PASSED,
 * new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } Thread.sleep(2000);
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * //Entered minimum value cropPage.getupthreshold().click();
 * Thread.sleep(1000); cropPage.getupthreshold().clear(); Thread.sleep(1000);
 * cropPage.getupthreshold().sendKeys("26"); driver.hideKeyboard();
 * ATUReports.add("Entered minimum value in the threshold field "
 * ,cropPage.getupthreshold().getText(), LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); Thread.sleep(2000);
 * 
 * 
 * 
 * 
 * //clicked on next button if (cropPage.getNext_nxt_save_btn().isEnabled()) {
 * cropPage.getNext_nxt_save_btn().click(); ATUReports.add(
 * "Next  button is enabled and Clicked on Skip button in the crop lower temp  screen "
 * , LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } else {
 * ATUReports.add("Next button is not enabled in crop lower temp scree",
 * LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
 * 
 * 
 * }else{ ATUReports.add(
 * "temparature value text box  is not observed in the screen "
 * ,textDefaultTextThree,LogAs.FAILED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); driver.close(); }
 * 
 * //----------CUTT OFF METHOD-------------
 * 
 * // Verify Crop title text.
 * 
 * String cutoffmethod = cropPage.getTitletxt().getText(); //
 * System.out.println(title); if (cutoffmethod.isEmpty()) { ATUReports.add(
 * "CUTOFF METHOD element is not available in the screen ", LogAs.WARNING, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * } else { if (cutoffmethod.contains("Cutoff Method")) { ATUReports.add(
 * "Cutoff Method is noticed in the screen ", "Cutoff Method", cutoffmethod,
 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
 * 
 * else { ATUReports.add("Cutoff Method is not observed in the screen ",
 * LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } }
 * 
 * 
 * if (cropPage.getNext_nxt_save_btn().isEnabled()) {
 * cropPage.getNext_nxt_save_btn().click(); ATUReports.add(
 * "Skip  button is enabled and Clicked on Skip button in the CUT OFF screen ",
 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * 
 * } else { ATUReports.add("Next button is not enabled in the CUT OFF screen",
 * LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
 * 
 * //-------------CHILL START DATE----------------------
 * 
 * // Verify Crop title text. String chillstartdate =
 * cropPage.getTitletxt().getText(); // System.out.println(title); if
 * (chillstartdate.isEmpty()) { ATUReports.add(
 * "Chill Start Date element is not available in the screen ", LogAs.WARNING,
 * new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * } else { if (chillstartdate.contains("Chill Start Date")) { ATUReports.add(
 * " CHILL START DATE is noticed in the screen ", "Chill Start Date",
 * chillstartdate, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * }
 * 
 * else { ATUReports.add("Chill Start Date is not observed in the screen ",
 * LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } }
 * 
 * 
 * 
 * 
 * //Move tha optional slider driver.swipe(920, 504, 1029, 504, (int)
 * 1.3799609375); ATUReports.add("moved the optional into enable mode",
 * LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * 
 * // verify the date is enabled or not // and then Click on // the date tab
 * cropPage.getdateTab().click();
 * 
 * Thread.sleep(2000); // Click on done button
 * cropPage.getNext_nxt_save_btn().click();
 * 
 * if (cropPage.getNext_nxt_save_btn().isEnabled()) {
 * cropPage.getNext_nxt_save_btn().click(); ATUReports.add(
 * "Skip  button is enabled and Clicked on Skip button in the CHILL START DATE screen "
 * , LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * } else { ATUReports.add(
 * "Next button is not enabled in the CHILL START DATE screen ", LogAs.FAILED,
 * new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
 * 
 * 
 * cropPage.getNext_nxt_save_btn().click();
 * 
 * 
 * ///---------CHILLING TARGET-------------
 * 
 * // Verify Crop title text. String chillingthreshold =
 * cropPage.getTitletxt().getText(); // System.out.println(title); if
 * (chillingthreshold.isEmpty()) { ATUReports.add(
 * "CHILLING TARGET element is not available in the screen ", LogAs.WARNING, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * } else { if (chillingthreshold.contains("Chilling Target")) { ATUReports.add(
 * "Chilling Target is noticed in the screen ", "Chilling Target",
 * chillingthreshold, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
 * 
 * else { ATUReports.add( "CHILLING TARGET is not observed in the screen ",
 * LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } }
 * 
 * //Verify chilling target temp units MobileElement temparatureBoxtarget=
 * cropPage.getchillingtargetTextBx(); String
 * textDefaultTextFour=temparatureBoxtarget.getText();
 * System.out.println(textDefaultTextFour+"---textDefaultTextFour---"); String
 * targetUnits= cropPage.getchillingTargetUnits().getText();
 * 
 * ATUReports.add(
 * "TemperatureUnits text is noticed in the screen  same as expected "
 * ,targetUnits,targetUnits, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * if (temparatureBoxtarget!= null&&temparatureBoxtarget.isDisplayed()) {
 * 
 * ATUReports.add(
 * "Mobilize temparature value text box is displayed, and its default value is Empty - "
 * +textDefaultTextFour, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * 
 * //Enter minimum value cropPage.getchillingtargetTextBx().click();
 * Thread.sleep(1000); cropPage.getchillingtargetTextBx().clear();
 * Thread.sleep(1000); cropPage.getchillingtargetTextBx().sendKeys("1");
 * cropPage.getchillingtargetTextBx().sendKeys("30002");
 * cropPage.getchillingtargetTextBx().sendKeys("3000"); driver.hideKeyboard();
 * ATUReports.add("Entered minimum value in the threshold field "
 * ,textDefaultTextFour, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); Thread.sleep(2000);
 * 
 * 
 * //Verify next button is enabled nextButtonEnabled();
 * 
 * 
 * //Enter out of range value cropPage.getchillingtargetTextBx().click();
 * Thread.sleep(1000); cropPage.getchillingtargetTextBx().clear();
 * Thread.sleep(1000); cropPage.getchillingtargetTextBx().sendKeys("30002");
 * driver.hideKeyboard(); ATUReports.add(
 * "Entered out of range value in the threshold field "
 * ,cropPage.getchillingtargetTextBx().getText(), LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); Thread.sleep(2000);
 * 
 * // Verify Observe Next button is Enabled. String frost_thresholdTitle1 =
 * frostPage.getTitletxt().getText(); if
 * (frostPage.getNext_nxt_save_btn().isEnabled()) { ATUReports.add(
 * "Next button is enabled in the "+frost_thresholdTitle1, LogAs.FAILED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } else { ATUReports.add(
 * "Next button is not enabled in the  "+frost_thresholdTitle1, LogAs.PASSED,
 * new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } Thread.sleep(2000);
 * 
 * 
 * //Enter maximum value cropPage.getchillingtargetTextBx().click();
 * Thread.sleep(1000); cropPage.getchillingtargetTextBx().clear();
 * Thread.sleep(1000); cropPage.getchillingtargetTextBx().sendKeys("3000");
 * driver.hideKeyboard(); ATUReports.add(
 * "Entered maximum value in the threshold field "
 * ,cropPage.getchillingtargetTextBx().getText(), LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); Thread.sleep(2000);
 * 
 * //Clicked on next button if (cropPage.getNext_nxt_save_btn().isEnabled()) {
 * cropPage.getNext_nxt_save_btn().click(); ATUReports.add(
 * "Skip  button is enabled and Clicked on Skip button in the CHILLING THRESHOLD screen "
 * , LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * } else { ATUReports.add(
 * "Next button is not enabled in the CHILLING THRESHOLD screen  ",
 * LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
 * 
 * 
 * 
 * 
 * 
 * // Verify title
 * 
 * String complete_crop_setup = cropPage.getTitletxt().getText(); if
 * (complete_crop_setup.isEmpty()) { ATUReports.add(
 * "Verify the Complete Crop Setup text  in the screen ", "Complete Crop Setup",
 * complete_crop_setup, LogAs.WARNING, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 * 
 * } else { if (complete_crop_setup.contains("Complete Crop Setup")) {
 * ATUReports.add(
 * "Complete Crop Setup is noticed in the screen, sucessfully skipped rest of the screen in between the screens"
 * , "Complete Crop Setup", complete_crop_setup, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } else { ATUReports.add(
 * "Complete Crop Setup is not observed in the screen ", complete_crop_setup,
 * LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } }
 * Thread.sleep(2000);
 * 
 * 
 * 
 * // Verify save button is displayed or not.
 * 
 * MobileElement saveButton = weatherPage.getNext_nxt_save_btnn(); String
 * saveText = saveButton.getText(); if (weatherPage.getNext_nxt_save_btnn()!=
 * null && saveButton.isDisplayed()) { if (saveText.equals("Save")) {
 * 
 * ATUReports.add( saveText +
 * " button is displayed  in CROP set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box"
 * , "Save", saveText, LogAs.PASSED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); //saveButton.click();
 * Thread.sleep(2000);
 * 
 * } else { ATUReports.add("Mobilize " + saveText + " button is not displayed. "
 * , readFrostData.ButtonTextThree, saveText, LogAs.FAILED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); }
 * 
 * } else { driver.close(); return; }
 * 
 * 
 * }else{ ATUReports.add(
 * "temparature value text box  is not observed in the screen "
 * ,textDefaultTextFour,LogAs.FAILED, new
 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); driver.close(); } }
 */