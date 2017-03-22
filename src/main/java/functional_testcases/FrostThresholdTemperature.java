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
import utility.ReadUserData;
import utility.Read_FrostPageThresholdValues;
import utility.Read_Frost_Data;

import java.util.List;

public class FrostThresholdTemperature {

	private AndroidDriver driver;
	private LoginPage loginpage;
	private NewViewScreenPage newscreenpage;
	private ReadUserData readUserData;
	private HomePage homepage;
	private FrostPage frostPage;
	private Read_Frost_Data readFrostData;
	private WeatherPage weatherPage;
	private Read_FrostPageThresholdValues readfrost;
	private Account_Page accountPage;
	private Alert_Page	alertpage;
	
	@Test
	public void verifyFrostThresholdTemperature() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		newscreenpage = new NewViewScreenPage(driver);
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
		accountPage=new Account_Page(driver);
		new FrostPage(driver);
		alertpage=new Alert_Page(driver);
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
						
						
						
			            // Click on preferences
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
					Thread.sleep(2000);


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
					
					//Tab on next				
					MobileElement nextAddButton = newscreenpage.getAddbtn();
					nextAddButton.click();
					Thread.sleep(2000);
					
					
					// Verifying tutorial icon
					Thread.sleep(2000);
					Precondition.tutorialDisalogBox();
					
					
					
					// Verify tap on crop title-we are using generic code for titles bcs titles paths are changing from one to another.
					Thread.sleep(1000);
					List <WebElement> cropTitle=driver.findElements(By.id("com.davis.mobilize:id/report_text"));
					for(int i=0;i<=cropTitle.size();i++){
						String cropTitleText =cropTitle.get(i).getText();
						System.out.println(cropTitleText + "---accessabilityid---");							
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
					

					// Verify Observe application navigated to Sensor Input
					// screen and
					// Next is disabled.
					String frost_sensor_title = frostPage.getTitletxt().getText();
					if (frost_sensor_title.isEmpty()) {
						ATUReports.add("Verify the SENSOR INPUT text  in the screen ", "Frost Sensor Input",
								frost_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						if (frost_sensor_title.equals("Frost Sensor Input")) {
							ATUReports.add("SENSOR INPUT is noticed in the screen ", "Frost Sensor Input",
									frost_sensor_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("SENSOR INPUT is not observed in the screen ", frost_sensor_title,
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
						frostPage.getNext_nxt_save_btn().click();
						ATUReports.add(
								"Next button is enabled in the frost Sensor Input and clicked on the Next button",
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled in the frost Sensor Input", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					Thread.sleep(2000);

					// Verify Threshold page heading text
					String frost_thresholdTitle = frostPage.getTitletxt().getText();
					if (frost_thresholdTitle.isEmpty()) {
						ATUReports.add("Verify the Frost threshold text  in the screen ", "Frost Threshold",
								frost_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (frost_thresholdTitle.equals("Frost Threshold")) {
							ATUReports.add("Frost threshold is displayed in the screen ", "Frost Threshold",
									frost_thresholdTitle, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							ATUReports.add("Frost threshold is not  displayed in the screen ",
									readFrostData.titleTextThree, frost_thresholdTitle, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					

					// Verify temperature units from current page
					String actualTemperatureUnits = frostPage.getfrostTempUnitsF().getText();
					System.out.println(actualTemperatureUnits + "---actualTemperatureUnits");
					System.out.println(expectedFtxt + "----expectedTempTxt");
					if (actualTemperatureUnits.isEmpty()) {
						ATUReports.add("temperatureUnits element is not visible", null, LogAs.WARNING,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						if (actualTemperatureUnits.contains(expectedFtxt)) {
							ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
									actualTemperatureUnits, expectedTempTxt, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify Tap on Temperature value box.

							MobileElement temparatureBox = weatherPage.getTemperatureBox();
							String textDefaultText = temparatureBox.getText();
							System.out.println(textDefaultText + "---textDefaultText---");

							if (temparatureBox != null && temparatureBox.isDisplayed()) {

								ATUReports.add(
										"Mobilize temperature value text box is displayed, and its default value is - "
												+ textDefaultText,
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Verify to enter min(value) range in text box
								temparatureBox.click();
								System.out.println("Clear the field");
								  weatherPage.getTemperatureBox().sendKeys(Keys.DELETE);
								     weatherPage.getTemperatureBox().sendKeys(Keys.INSERT);
								Thread.sleep(2000);
								weatherPage.getTemperatureBox().sendKeys(readfrost.frost_F_MinimumValue);
								System.out
										.println(readfrost.frost_F_MinimumValue + "----readfrost.frost_F_MinimumValue");
								System.out.println("enter 0 value");

								System.out.println(temparatureBox.getText() + "---textminimum value---");
								ATUReports.add("Entered minimum value", temparatureBox.getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								driver.hideKeyboard();

								// Verify Observe Next button is Enabled.
								nextButtonEnabled();

								// Verify to enter out of range values in text
								// box
								// it contains zero by default
								Thread.sleep(1000);							
								 weatherPage.getTemperatureBox().sendKeys(Keys.DELETE);
							     weatherPage.getTemperatureBox().sendKeys(Keys.INSERT);
							     Thread.sleep(2000);
								weatherPage.getTemperatureBox().sendKeys(readfrost.frost_F_OutOfRangeValue);
								Thread.sleep(1000);
								System.out.println(
										readfrost.frost_F_OutOfRangeValue + "---readfrost.frost_F_OutOfRangeValue");
								System.out.println(temparatureBox.getText() + "---text ot of value---");
								ATUReports.add("Entered Out of range value ", temparatureBox.getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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

								// Verify to enter max(value) range in textbox
								// it contains zero by default
								weatherPage.getTemperatureBox().sendKeys(Keys.DELETE);
							     weatherPage.getTemperatureBox().sendKeys(Keys.INSERT);
							     Thread.sleep(2000);
								weatherPage.getTemperatureBox().sendKeys(readfrost.frost_F_MaximumValue);
								System.out.println(temparatureBox.getText() + "---text maxm  value---");
								ATUReports.add("Entered maximum value", temparatureBox.getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(1000);

								// Verify Observe Next button is Enabled.
								// clikcedOnNext();

								if (frostPage.getNext_nxt_save_btn().isEnabled()) {
									frostPage.getNext_nxt_save_btn().click();
									ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("Next button is not enabled in the  " + frost_thresholdTitle1,
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
								Thread.sleep(2000);

							} else {
								ATUReports.add("temperature value text box  is not observed in the screen ",
										actualTemperatureUnits, expectedTempTxt, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								driver.close();
							}

							
							// Verifying tutorial icon
							Thread.sleep(2000);
							Precondition.tutorialDisalogBox();
							
							
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

							// Verify frost warning page heading text
							String frost_Warning = frostPage.getTitletxt().getText();
							System.out.println(frost_Warning + "frost warning page body-----");
							if (frost_Warning.isEmpty()) {
								ATUReports.add("Verify the Frost warning text  in the screen ", "Early Frost Warning",
										frost_sensor_title, LogAs.WARNING,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (frost_Warning.equals("Early Frost Warning")) {
									ATUReports.add("Frost warning is displayed in the screen ", "Early Frost Warning",
											frost_Warning, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("Frost warning is not  displayed in the screen ",
											"Early Frost Warning", frost_Warning, LogAs.FAILED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}
							Thread.sleep(4000);

							// Verify text box
							String actualDefaultText = frostPage.getearlyFrostTemptxtbx().getText();
							if (frostPage.getearlyFrostTemptxtbx().isDisplayed()) {

								ATUReports.add(
										"Mobilize temperature value text box is displayed, and its default value is - "
												+ actualDefaultText,
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								// Verify minm value
								// Verify to enter min(value) range in text box
								frostPage.getearlyFrostTemptxtbx().click();
								frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.DELETE);
								frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.INSERT);
								Thread.sleep(2000);
								System.out.println("Clear the field");
							

								frostPage.getearlyFrostTemptxtbx().sendKeys(readfrost.frost_F_MinimumValue);

								System.out.println("enter 0 value");

								System.out.println(
										frostPage.getearlyFrostTemptxtbx().getText() + "---textminimum value---");
								ATUReports.add("Entered minimum value", frostPage.getearlyFrostTemptxtbx().getText(),
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								driver.hideKeyboard();

								// Verify Observe Next button is Enabled.
								nextButtonEnabled();

								// Verify to enter out of range values in text
								// box
								// it contains zero by default
								Thread.sleep(1000);
								frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.DELETE);
								frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.INSERT);
								Thread.sleep(2000);
								frostPage.getearlyFrostTemptxtbx().sendKeys(readfrost.frost_F_OutOfRangeValue);
								System.out.println(
										readfrost.frost_F_OutOfRangeValue + "---readfrost.frost_F_OutOfRangeValue");
								System.out.println(
										frostPage.getearlyFrostTemptxtbx().getText() + "---text ot of value---");
								ATUReports.add("Entered Out of range value ",
										frostPage.getearlyFrostTemptxtbx().getText(), LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								

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

								// Verify to enter max(value) range in textbox
								// it contains zero by default			
								frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.DELETE);
								frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.INSERT);
								Thread.sleep(2000);
								frostPage.getearlyFrostTemptxtbx().sendKeys(readfrost.frost_F_MaximumValue);
								System.out.println(
										frostPage.getearlyFrostTemptxtbx().getText() + "---text maxm  value---");
								ATUReports.add("Entered maximum value", frostPage.getearlyFrostTemptxtbx().getText(),
										LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(1000);

								// Verify Observe Next button is Enabled.
								if (frostPage.getNext_nxt_save_btn().isEnabled()) {
									frostPage.getNext_nxt_save_btn().click();
									ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								} else {
									ATUReports.add("Next button is not enabled in the " + frost_thresholdTitle1,
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
								Thread.sleep(2000);

								// Verify the COMPLETE FROST SETUP
								String COMPLETE_FROST_SETUP_title = frostPage.getTitletxt().getText();
								if (COMPLETE_FROST_SETUP_title.isEmpty()) {
									ATUReports.add("Verify the COMPLETE FROST SETUP text  in the screen ",
											"Complete Frost Setup", COMPLETE_FROST_SETUP_title, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (COMPLETE_FROST_SETUP_title.equals("Complete Frost Setup")) {
										ATUReports.add("COMPLETE FROST SETUP is displayed in the screen ",
												"Complete Frost Setup", COMPLETE_FROST_SETUP_title, LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} else {
										ATUReports.add("COMPLETE FROST SETUP is not noticed in the screen",
												readFrostData.titleTextFive, COMPLETE_FROST_SETUP_title, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}

								// Verify save button is displayed or not.
								MobileElement saveButton = weatherPage.getNext_nxt_save_btnn();
								String saveText = saveButton.getText();
								if (weatherPage.getNext_nxt_save_btnn() != null && saveButton.isDisplayed()) {
									if (saveText.equals("Save")) {

										ATUReports.add(
												saveText + " button is displayed  in frost set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box",
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
								ATUReports.add("TemperatureUnits text box is not observed in the EARLY FROST screen ",
										LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						} else {

							// Verify if page contains temperature " c "units
							// from current page
							String actualTemperatureUnits2 = frostPage.getfrostTempUnitsF().getText();
							System.out.println(actualTemperatureUnits2 + "---actualTemperatureUnits");
							System.out.println(expectedCText + "----expectedTempTxt");

							if (actualTemperatureUnits.isEmpty()) {
								ATUReports.add("temperatureUnits element is not visible", null, LogAs.WARNING,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								if (actualTemperatureUnits.contains(expectedCText)) {
									ATUReports.add("TemperatureUnits text is noticed in the screen  same as expected ",
											actualTemperatureUnits, expectedTempTxt, LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									// Verify Tap on Temperature value box.
									MobileElement temparatureBox = weatherPage.getTemperatureBox();
									String textDefaultText = temparatureBox.getText();
									System.out.println(textDefaultText + "---textDefaultText---");

									if (temparatureBox != null && temparatureBox.isDisplayed()) {

										ATUReports.add(
												"Mobilize temperature value text box is displayed, and its default value is - "
														+ textDefaultText,
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// Verify to enter min(value) range in
										// text box
										temparatureBox.click();
										// Thread.sleep(1000);
										System.out.println("Clear the field");
										weatherPage.getTemperatureBox().sendKeys(Keys.DELETE);
										weatherPage.getTemperatureBox().sendKeys(Keys.INSERT);		
										Thread.sleep(1000);
										weatherPage.getTemperatureBox().sendKeys(readfrost.Frost_C_Minm);
										System.out.println(readfrost.Frost_C_Minm + "----readfrost.Frost_C_Minm");
										System.out.println("enter -1 value");

										System.out.println(temparatureBox.getText() + "---textminimum value---");
										ATUReports.add("Entered minimum value", temparatureBox.getText(), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										driver.hideKeyboard();

										// Verify Observe Next button is
										// Enabled.
										nextButtonEnabled();

										// Verify to enter out of range values
										// in text box
										// it contains zero by default
										Thread.sleep(2000);
										weatherPage.getTemperatureBox().sendKeys(Keys.DELETE);
										weatherPage.getTemperatureBox().sendKeys(Keys.INSERT);
										Thread.sleep(1000);
										weatherPage.getTemperatureBox().sendKeys(readfrost.Frost_C_OutOf_Range);
										Thread.sleep(1000);
										System.out.println(
												readfrost.Frost_C_OutOf_Range + "---readfrost.Frost_C_OutOf_Range");
										System.out.println(temparatureBox.getText() + "---text ot of value---");
										ATUReports.add("Entered Out of range value ", temparatureBox.getText(),
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// Verify Observe Next button is not
										// Enabled.
										String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
										if (frostPage.getNext_nxt_save_btn().isEnabled()) {
											ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add(
													"Next button is not enabled in the  " + frost_thresholdTitle1,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										Thread.sleep(2000);

										// Verify to enter max(value) range in
										// textbox
										// it contains zero by default
										Thread.sleep(1000);
										weatherPage.getTemperatureBox().sendKeys(Keys.DELETE);
										weatherPage.getTemperatureBox().sendKeys(Keys.INSERT);
										Thread.sleep(1000);
										weatherPage.getTemperatureBox().sendKeys(readfrost.Frost_C_Maxm);

										System.out.println(temparatureBox.getText() + "---text maxm  value---");
										ATUReports.add("Entered maximum value", temparatureBox.getText(), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										Thread.sleep(1000);

										// Verify Observe Next button is 
										// Enabled.

										if (frostPage.getNext_nxt_save_btn().isEnabled()) {
											frostPage.getNext_nxt_save_btn().click();
											ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add(
													"Next button is not enabled in the  " + frost_thresholdTitle1,
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										Thread.sleep(2000);

									} else {
										ATUReports.add("temparature value text box  is not observed in the screen ",
												actualTemperatureUnits, expectedTempTxt, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										driver.close();
									}

									
									// Verifying tutorial icon
									Thread.sleep(2000);
									Precondition.tutorialDisalogBox();
									
									// Verify "Early frost page"

									// get the value of the optional and click
									// on it				
									Thread.sleep(4000);
									if(frostPage.getoptionalSliderSwipe().isDisplayed()){			
										ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
										Thread.sleep(2000);
												WebElement optionalElement =frostPage.getoptionalSliderSwipe();
										int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
										int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
										System.out.println("xInitialOptional  "+xInitialOptional+ "yInitialOptional "+yInitialOptional);
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
									
						

									// Verify frost warning page heading text
									String frost_Warning = frostPage.getTitletxt().getText();
									System.out.println(frost_Warning + "frost warning page body-----");
									if (frost_Warning.isEmpty()) {
										ATUReports.add("Verify the Frost warning text  in the screen ",
												"Early Frost Warning", frost_sensor_title, LogAs.WARNING,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									} else {
										if (frost_Warning.equals("Early Frost Warning")) {
											ATUReports.add("Frost warning is displayed in the screen ",
													"Early Frost Warning", frost_Warning, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("Frost warning is not  displayed in the screen ",
													"Early Frost Warning", frost_Warning, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
									}
									Thread.sleep(4000);

									// Verify text box
									String actualDefaultText = frostPage.getearlyFrostTemptxtbx().getText();
									if (frostPage.getearlyFrostTemptxtbx().isDisplayed()) {

										ATUReports.add(
												"Mobilize temperature value text box is displayed, and its default value is - "
														+ actualDefaultText,
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// Verify minm value
										// Verify to enter min(value) range in
										// text box
										frostPage.getearlyFrostTemptxtbx().click();
										Thread.sleep(1000);
										frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.DELETE);
										frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.INSERT);
										Thread.sleep(2000);
										System.out.println("Clear the field");
										frostPage.getearlyFrostTemptxtbx().sendKeys(readfrost.early_C_frost_Minm);
										System.out.println("enter -1 value");
										System.out.println(frostPage.getearlyFrostTemptxtbx().getText()
												+ "---textminimum value---");
										ATUReports.add("Entered minimum value",
												frostPage.getearlyFrostTemptxtbx().getText(), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										driver.hideKeyboard();

										// Verify Observe Next button is
										// Enabled.
										nextButtonEnabled();

										// Verify to enter out of range values
										// in text box
										// it contains zero by default

										Thread.sleep(2000);
										frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.DELETE);
										frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.INSERT);
										Thread.sleep(2000);
										frostPage.getearlyFrostTemptxtbx().sendKeys(readfrost.early_C_Frost_OutOfRage);
										System.out.println(readfrost.early_C_Frost_OutOfRage
												+ "---readfrost.early_C_Frost_OutOfRage");
										System.out.println(frostPage.getearlyFrostTemptxtbx().getText()
												+ "---text ot of value---");
										ATUReports.add("Entered Out of range value ",
												frostPage.getearlyFrostTemptxtbx().getText(), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// Verify Observe Next button is
										// Enabled.
										String frost_thresholdTitle1 = frostPage.getTitletxt().getText();
										if (frostPage.getNext_nxt_save_btn().isEnabled()) {
											ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add(
													"Next button is not enabled in the  " + frost_thresholdTitle1,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										Thread.sleep(2000);

										// Verify to enter max(value) range in
										// textbox
										// it contains zero by default
										Thread.sleep(1000);
										frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.DELETE);
										frostPage.getearlyFrostTemptxtbx().sendKeys(Keys.INSERT);
										Thread.sleep(2000);
										Thread.sleep(1000);
										frostPage.getearlyFrostTemptxtbx().sendKeys(readfrost.early_C_Frost_Maxm);
										System.out.println(frostPage.getearlyFrostTemptxtbx().getText()
												+ "---text maxm  value---");
										ATUReports.add("Entered maximum value",
												frostPage.getearlyFrostTemptxtbx().getText(), LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										Thread.sleep(1000);

										// Verify Observe Next button is
										// Enabled.
										// clikcedOnNext();
										
										if (frostPage.getNext_nxt_save_btn().isEnabled()) {
											frostPage.getNext_nxt_save_btn().click();
											ATUReports.add("Next button is enabled in the " + frost_thresholdTitle1,
													LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("Next button is not enabled in the " + frost_thresholdTitle1,
													LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										Thread.sleep(2000);

										//Verify the COMPLETE FROST SETUP

										String COMPLETE_FROST_SETUP_title = frostPage.getTitletxt().getText();
										if (COMPLETE_FROST_SETUP_title.isEmpty()) {
											ATUReports.add("Verify the COMPLETE FROST SETUP text  in the screen ",
													"Complete Frost Setup", COMPLETE_FROST_SETUP_title, LogAs.WARNING,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										} else {
											if (COMPLETE_FROST_SETUP_title.equals("Complete Frost Setup")) {
												ATUReports.add("COMPLETE FROST SETUP is displayed in the screen ",
														"Complete Frost Setup", COMPLETE_FROST_SETUP_title,
														LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} else {
												ATUReports.add("COMPLETE FROST SETUP is not noticed in the screen",
														readFrostData.titleTextFive, COMPLETE_FROST_SETUP_title,
														LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
										}

										// Verify save button is displayed or
										// not.

										MobileElement saveButton = weatherPage.getNext_nxt_save_btnn();
										String saveText = saveButton.getText();
										if (weatherPage.getNext_nxt_save_btnn() != null && saveButton.isDisplayed()) {
											if (saveText.equals("Save")) {

												ATUReports.add(
														saveText + " button is displayed  in frost set up page, User able to Entered the frost minimum,maximum and out of range values from beginning in text box",
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
										
										
										//

									} else {
										ATUReports.add(
												"TemperatureUnits text box is not observed in the EARLY FROST screen ",
												LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}

								} else {
									ATUReports.add("TemperatureUnits text box is not observed in the screen ",
											LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								}

							}

						}

					}

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
			// frostPage.getNext_nxt_save_btn().click();
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
























































//-------This code is for future reference---------

/*	
//click on particular view from view list
  for (int j = 1; j <= 4; j++) {
	System.out.println(j + "--j---");
	driver.findElement(By.xpath("//android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout["+j+"]/android.widget.RelativeLayout")).click();
	Thread.sleep(3000);
	System.out.println("in loop view");
	
	Thread.sleep(1000);
	//	Click on particular view from list box
     WebElement ViewsListOne=driver.findElement(By.id("com.davis.mobilize:id/shareIcon"));		
	if(ViewsListOne!=null&&ViewsListOne.isDisplayed()){
		Thread.sleep(1000);
		
		// Verify tap on crop title-we are using generic code for titles bcs titles paths are changing from one to another.
		Thread.sleep(1000);
		List <WebElement> cropTitle=driver.findElements(By.id("com.davis.mobilize:id/report_text"));
		for(int i=0;i<=cropTitle.size();i++){
			String cropTitleText =cropTitle.get(i).getText();
			System.out.println(cropTitleText + "---accessabilityid---");							
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
				
				/// scroll up the current page
				driver.scrollTo("Edit View");
				Thread.sleep(3000);
			}
			
		}
		

	
						
	// Verify tap on Frost.
	MobileElement frostTitle = newscreenpage.getfrostElement();
	String frostTitleText =frostTitle.getText();
   System.out.println(frostTitleText+"--frostTitleText--");

	if (newscreenpage.getfrostElement()!= null&&newscreenpage.getfrostElement().isDisplayed()) {
		Thread.sleep(2000);
		 System.out.println((newscreenpage.getfrostElement().getText()+"--frostTitleText--"));
		if (newscreenpage.getfrostElement().getText().equals("FROST")) {
			ATUReports.add("Mobilize " +newscreenpage.getfrostElement().getText() + "  tab is displayed.", "FROST",
					newscreenpage.getfrostElement().getText(), LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			newscreenpage.getfrostElement().click();
			Thread.sleep(2000);
			ATUReports.add("Mobilize frost tab is clicked", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			break;
		} else {
			ATUReports.add("Mobilize Report title " + newscreenpage.getfrostTitle().getText() + " tab is not displayed",
					newscreenpage.getfrostTitle().getText(), LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			driver.navigate().back();
			Thread.sleep(2000);
		}


		// break;
	} else {
		Thread.sleep(2000);
		System.out.println("I am  inside else");

		// Click on home page back button
		driver.navigate().back();
		Thread.sleep(3000);
	}

	if (j == 4) {
		// scroll up the current page			
		WebElement listElement =homepage.getviewsList();
		int xInitialList = listElement.getLocation().getX() + listElement.getSize().getWidth()/2;
		int yInitialList = listElement.getLocation().getY() + listElement.getSize().getHeight()/2;
		System.out.println("=startx "+xInitialList+" "+ yInitialList+"=end y  scroll down to  up the page");
		driver.swipe(xInitialList, yInitialList, xInitialList, yInitialList-987, 5000);//727						
	j =1;
	Thread.sleep(2000);
	ATUReports.add("Scroll up the view list", LogAs.PASSED,
			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

	}

}*/








//This code is for future purpose
// get the value of the optional and click on it
/*WebElement optionalSlider=frostpage.getoptionalSliderl();
int wide  = optionalSlider.getSize().width;
int hgt = optionalSlider.getSize().height;

int startx = (int) (wide * (0.8));
int endx = (int)(wide *(0.2));
int starty =  hgt /2 ;
int endy = hgt/2;

//To move from Fav to all contacts, we need to swipe from right to left
driver.swipe(startx, starty, endx, endy, 1000);*/



/*driver.swipe(920, 506, 1034, 506, (int) 1.3799609375);			
ATUReports.add("moved the optional into enable mode", LogAs.PASSED,
		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
