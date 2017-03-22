package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.Read_Irrigation_Details;

import java.util.List;

public class Irrigation_UI_Navigation_Flow {
	private FrostPage frostPage;
	private AndroidDriver driver;
	private LoginPage loginpage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private IrrigationPage irrigationPage;
	private JavascriptExecutor js;
	private Read_Irrigation_Details read_irrigation;
	private Account_Page accountPage;

	@Test
	public void Irrigation_verify_UI_navigation() {

		try {
			driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
			loginpage = new LoginPage(driver);
			homepage = new HomePage(driver);
			newviewscreenpage = new NewViewScreenPage(driver);
			irrigationPage = new IrrigationPage(driver);
			js = (JavascriptExecutor) driver;
			new FrostPage(driver);
			read_irrigation = new Read_Irrigation_Details();
			read_irrigation.start();
			accountPage = new Account_Page(driver);
			Thread.sleep(2000);
			frostPage = new FrostPage(driver);
			Thread.sleep(6000);

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

			// get the value of the optional and click on it
			Thread.sleep(5000);
			if (irrigationPage.gettogglebtnOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider in Variety", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement = irrigationPage.gettogglebtnOptional();
				int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth() / 2;
				int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight() / 2;
				System.out.println("xInitialOptional " + xInitialOptional + "yInitialOptional" + yInitialOptional);
				//driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional + 80, yInitialOptional, 5000);
				
				
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
			} else {
				ATUReports.add("optional Slier is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

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

			// Verify Irrigation Body text.
			String soil_body = irrigationPage.getsoilSensorCaption().getText();
			// System.out.println(title);
			if (soil_body.isEmpty()) {
				ATUReports.add("Soil Moisture Senso body element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (soil_body.equals("Select the appropriate device and sensor inputs for monitoring soil moisture.")) {
					ATUReports.add("Soil Moisture Senso body text is noticed in the screen ",
							"Select the appropriate device and sensor input for monitoring soil moisture.", soil_body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				else {
					ATUReports.add("Soil Moisture Sensor is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			/// verify the optional text
			verify_Optionaltxt();

			// Select any option from device drop down -
			//MobileElement devicedropdown = irrigationPage.getDevicestxt();
			//devicedropdown.click();
			Thread.sleep(2000);

			MobileElement devicDropdownText = irrigationPage.getdeviceDropDown();
			devicDropdownText.click();
			Thread.sleep(2000);
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Select any option from sensor drop down
			//MobileElement sensorDropdown = irrigationPage.getSensortxt();
			//sensorDropdown.click();
			Thread.sleep(600);

			MobileElement sensorDropdownText = irrigationPage.getsensorDropDown();
			sensorDropdownText.click();
			Thread.sleep(600);

			ATUReports.add("Clicked on the Sensor drop down and selected the Sentek Drill & Drop TriSCAN 60 cm",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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

			/* *//*************************************************************************************************************
					 * SATURATION THRESHOLD
					 *************************************************************************************************************//*	
																																*/
			// get the value of the optional and click on it
			Thread.sleep(4000);
			if (irrigationPage.getsaturationOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider in Variety", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement2 = irrigationPage.getsaturationOptional();
				int xInitialOptional2 = optionalElement2.getLocation().getX()
						+ optionalElement2.getSize().getWidth() / 2;
				int yInitialOptional2 = optionalElement2.getLocation().getY()
						+ optionalElement2.getSize().getHeight() / 2;
				System.out.println("xInitialOptional " + xInitialOptional2 + "yInitialOptional" + yInitialOptional2);
				//driver.swipe(xInitialOptional2, yInitialOptional2, xInitialOptional2 + 80, yInitialOptional2, 5000);
				
				//Swiping list based on coordinates
				if(xInitialOptional2<1200){  
					driver.swipe(xInitialOptional2, yInitialOptional2, xInitialOptional2+80, yInitialOptional2, 5000);
					//System.out.println("in 1st loop optional");
				}else{				
						if(xInitialOptional2>1200){
						driver.swipe(xInitialOptional2, yInitialOptional2, xInitialOptional2+120, yInitialOptional2, 5000);
							//System.out.println("in 2nd loop optional");
						}
				}
				Thread.sleep(2000);
			} else {
				ATUReports.add("optional Slier is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// verify the header text
			verify_Header();

			// Verify title text.
			String saturation_threshold_head = irrigationPage.getsatutarionTitle().getText();
			if (saturation_threshold_head.isEmpty()) {
				ATUReports.add("Verify the SATURATION THRESHOLD text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (saturation_threshold_head.equals("Saturation Threshold")) {
					ATUReports.add("Saturation Threshold is noticed in the screen", "Saturation Threshold",
							saturation_threshold_head, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("SATURATION THRESHOLD is not noticed in the screen", "SATURATION THRESHOLD",
							saturation_threshold_head, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Verify Irrigation Body text.
			String saturation_body = irrigationPage.getsaturationCaption().getText();
			// System.out.println(title);
			if (saturation_body.isEmpty()) {
				ATUReports.add("Saturation Threshold body element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (saturation_body.contains("Saturation threshold sets the topline of field moisture capacity.")) {
					ATUReports.add("Saturation Threshold body text is noticed in the screen ",
							"Saturation threshold sets the topline of field moisture capacity.", saturation_body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				else {
					ATUReports.add("SATURATION THRESHOLD is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// verify the optional text
			verify_Optionaltxt();

			// Verify Saturation text.
			String saturation_txt = irrigationPage.getthresholdText().getText();
			if (saturation_txt.isEmpty()) {
				ATUReports.add("SATURATION element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (saturation_txt.contains("Saturation:")) {
					ATUReports.add("SATURATION text is noticed in the screen ", "Saturation:", saturation_txt,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("SATURATION text is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Enter some value in the Saturation
			Thread.sleep(2000);
			String saturation = read_irrigation.saturation_threshold;
			irrigationPage.getsaturationTextBox().sendKeys(Keys.DELETE);
			irrigationPage.getsaturationTextBox().sendKeys(Keys.INSERT);
			Thread.sleep(2000);
			irrigationPage.getsaturationTextBox().sendKeys(saturation);
			ATUReports.add("Saturation value given in the text box", read_irrigation.saturation_threshold, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(3000);
			// driver.hideKeyboard();

			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				// irrigationPage.getskipbtn().click();
				ATUReports.add("Next  button is enabled in the  SATURATION THRESHOLD screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Next  button is enabled in the  SATURATION THRESHOLD screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(2000);

			/*	*//***************************************************************************************************************
					 * WILTING THRESHOLD
					 ************************************************************************************************************//*
																																*/

			// verify the header text
			verify_Header();

			// get the value of the optional and click on it
			Thread.sleep(4000);
			if (irrigationPage.getwiltingOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider in Variety", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement3 = irrigationPage.getwiltingOptional();
				int xInitialOptional3 = optionalElement3.getLocation().getX()
						+ optionalElement3.getSize().getWidth() / 2;
				int yInitialOptional3 = optionalElement3.getLocation().getY()
						+ optionalElement3.getSize().getHeight() / 2;
				System.out.println("xInitialOptional " + xInitialOptional3 + "yInitialOptional" + yInitialOptional3);
				//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3 + 80, yInitialOptional3, 5000);
				
				
				//Swiping list based on coordinates
				if(xInitialOptional3<1200){  
					driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+80, yInitialOptional3, 5000);
					//System.out.println("in 1st loop optional");
				}else{				
						if(xInitialOptional3>1200){
						driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+120, yInitialOptional3, 5000);
							//System.out.println("in 2nd loop optional");
						}
				}
				Thread.sleep(2000);
			} else {
				ATUReports.add("optional Slier is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify Chill start date title text.
			String wilting_thresold_body = irrigationPage.getwiltingTitle().getText();
			if (wilting_thresold_body.isEmpty()) {
				ATUReports.add("Verify the Wilting Threshold text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (wilting_thresold_body.equals("Wilting Threshold")) {
					ATUReports.add("Wilting Threshold is noticed in the screen", "Wilting Threshold",
							wilting_thresold_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Wilting Threshold is not noticed in the screen", "WILTING THRESHOLD",
							wilting_thresold_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Verify Irrigation Body text.
			String wilting_body = irrigationPage.getwiltingCaption().getText();
			// System.out.println(title);
			if (wilting_body.isEmpty()) {
				ATUReports.add("WILTING THRESHOLD body element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (wilting_body.contains(
						"Wilting threshold sets the lower limit, indicating the onset of plant stress due to underwatering.")) {
					ATUReports.add("WILTING THRESHOLD body text is noticed in the screen ",
							"Wilting threshold sets the lower limit, indicating the onset of plant stress due to underwatering.",
							wilting_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("WILTING THRESHOLD is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify Saturation text.
			String saturation_txt_wilting = irrigationPage.getwiltingThresholdText().getText();
			if (saturation_txt_wilting.isEmpty()) {
				ATUReports.add("Wilting: element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (saturation_txt_wilting.equals("Wilting:")) {
					ATUReports.add("Wilting: text is noticed in the screen ", "Saturation:", saturation_txt_wilting,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Wilting: text is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Enter some value in the Saturation
			// irrigationPage.getwiltingTextBox().clear();
			Thread.sleep(2000);
			irrigationPage.getwiltingTextBox().sendKeys(Keys.DELETE);
			irrigationPage.getwiltingTextBox().sendKeys(Keys.INSERT);
			Thread.sleep(2000);
			irrigationPage.getwiltingTextBox().sendKeys(read_irrigation.wilting_threshold);
			ATUReports.add("Saturation value given in the text box", read_irrigation.wilting_threshold, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);

			// verify the optional text
			verify_Optionaltxt();

			// Verify Drag the slider to change the temperature
			thresholdSlider();
			Thread.sleep(4000);

			// Verifying plus icon
			plusIconButton();
			ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			Thread.sleep(2000);

			// Verifying minus icon
			minusIconButton();
			ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);

			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				// irrigationPage.getskipbtn().click();
				ATUReports.add("Next  button is enabled in the  WILTING THRESHOLD screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next  button is enabled in the  WILTING THRESHOLD screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(3000);

			/**//***************************************************************************************************************
				 * EARLY WARNING THRESHOLD
				 ************************************************************************************************************//*
																																*/
			// verify the header text
			verify_Header();

			// get the value of the optional and click on it
			Thread.sleep(4000);
			if (irrigationPage.getearlyFrostWraningOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider in Variety", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement4 = irrigationPage.getearlyFrostWraningOptional();
				int xInitialOptional4 = optionalElement4.getLocation().getX()
						+ optionalElement4.getSize().getWidth() / 2;
				int yInitialOptional4 = optionalElement4.getLocation().getY()
						+ optionalElement4.getSize().getHeight() / 2;
				System.out.println("xInitialOptional " + xInitialOptional4 + "yInitialOptional" + xInitialOptional4);
				//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3 + 80, yInitialOptional3, 5000);
				
				
				//Swiping list based on coordinates
				if(xInitialOptional4<1200){  
					driver.swipe(xInitialOptional4, yInitialOptional4, xInitialOptional4+80, yInitialOptional4, 5000);
					//System.out.println("in 1st loop optional");
				}else{				
						if(xInitialOptional4>1200){
						driver.swipe(xInitialOptional4, yInitialOptional4, xInitialOptional4+120, yInitialOptional4, 5000);
							//System.out.println("in 2nd loop optional");
						}
				}
				Thread.sleep(2000);
			} else {
				ATUReports.add("optional Slier is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify title text.
			String early_thresold_title = irrigationPage.getearlyWarngTitle().getText();
			if (early_thresold_title.isEmpty()) {
				ATUReports.add("Verify the EARLY WARNING THRESHOLD text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (early_thresold_title.equals("Early Warning Threshold")) {
					ATUReports.add("Early Warning Threshold is noticed in the screen", "Early Warning Threshold",
							early_thresold_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("Early Warning Threshold is not noticed in the screen", "Early Warning Threshold",
							early_thresold_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Verify Irrigation Body text.
			String early_waring_body = irrigationPage.getearlyWarngCaption().getText();
			// System.out.println(title);
			if (early_waring_body.isEmpty()) {
				ATUReports.add("EARLY WARNING THRESHOLD body element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (early_waring_body.contains(
						"Early warning threshold is set to alert prior to when actual wilting threshold conditions are met.")) {
					ATUReports.add("EARLY WARNING THRESHOLD body text is noticed in the screen ",
							"Early warning threshold is set to alert prior to when actual wilting threshold conditions are met.",
							early_waring_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				else {
					ATUReports.add("EARLY WARNING THRESHOLD caption text is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// verify the optional text
			verify_Optionaltxt();

			// Enter some value in the Saturation
			// irrigationPage.getearlyWarngTextBox().clear();
			Thread.sleep(2000);
			irrigationPage.getearlyWarngTextBox().sendKeys(Keys.DELETE);
			irrigationPage.getearlyWarngTextBox().sendKeys(Keys.INSERT);
			Thread.sleep(2000);
			irrigationPage.getearlyWarngTextBox().sendKeys(read_irrigation.early_waring_threshold);
			ATUReports.add("Saturation value given in the text box", read_irrigation.early_waring_threshold,
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);

			// Verify Drag the slider to change the temperature
			thresholdSlider();
			Thread.sleep(4000);

			// Verifying plus icon
			plusIconButton();
			ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			Thread.sleep(2000);

			// Verifying minus icon
			minusIconButton();
			ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);

			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				ATUReports.add("Next  button is enabled in the  WILTING THRESHOLD screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add(
						"Next  button is enabled in the  EARLY WARING THRESHOLD screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(2000);

			/**//***************************************************************************************************************
				 * LOW EC THRESHOLD
				 ************************************************************************************************************//*
																																*/
			// verify the header text
			verify_Header();

			// get the value of the optional and click on it
			Thread.sleep(4000);
			if (irrigationPage.getlowSalinityOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider in Variety", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement5 = irrigationPage.getlowSalinityOptional();
				int xInitialOptional5 = optionalElement5.getLocation().getX()
						+ optionalElement5.getSize().getWidth() / 2;
				int yInitialOptional5 = optionalElement5.getLocation().getY()
						+ optionalElement5.getSize().getHeight() / 2;
				System.out.println("xInitialOptional " + xInitialOptional5 + "yInitialOptional" + yInitialOptional5);
				//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3 + 80, yInitialOptional3, 5000);
				
				if(xInitialOptional5<1200){  
					driver.swipe(xInitialOptional5, yInitialOptional5, xInitialOptional5+80, yInitialOptional5, 5000);
					//System.out.println("in 1st loop optional");
				}else{				
						if(xInitialOptional5>1200){
						driver.swipe(xInitialOptional5, yInitialOptional5, xInitialOptional5+120, yInitialOptional5, 5000);
							//System.out.println("in 2nd loop optional");
						}
				}
				Thread.sleep(2000);
			} else {
				ATUReports.add("optional Slier is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify C title text.
			String low_ec_thresold_title = irrigationPage.getlowSanityTitle().getText();
			if (low_ec_thresold_title.isEmpty()) {
				ATUReports.add("Verify the LOW EC THRESHOLD text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (low_ec_thresold_title.equals("Low Salinity Threshold")) {
					ATUReports.add("Low Salinity Threshold is noticed in the screen", "Low Salinity Threshold",
							low_ec_thresold_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("LOW EC THRESHOLD is not noticed in the screen", "LOW EC THRESHOLD",
							low_ec_thresold_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Verify Irrigation Body text.
			String low_ec_thresold_body = irrigationPage.getlowSanityCaption().getText();
			// System.out.println(title);
			if (low_ec_thresold_body.isEmpty()) {
				ATUReports.add("LOW EC THRESHOLD body element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (low_ec_thresold_body.contains("Alert triggered if salinity is at or below threshold.")) {
					ATUReports.add("LOW EC THRESHOLD body text is noticed in the screen ",
							"Alert triggered if salinity is at or below threshold.", low_ec_thresold_body, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("LOW EC THRESHOLD caption text is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// verify the optional text
			verify_Optionaltxt();

			// Enter some value in the Saturation
			// irrigationPage.getlowSanityTextbox().clear();
			Thread.sleep(2000);
			irrigationPage.getlowSanityTextbox().sendKeys(Keys.DELETE);
			irrigationPage.getlowSanityTextbox().sendKeys(Keys.INSERT);
			Thread.sleep(2000);
			irrigationPage.getlowSanityTextbox().sendKeys(read_irrigation.low_ec_threshold);
			ATUReports.add("Saturation value given in the text box", read_irrigation.low_ec_threshold, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);

			// Verify Drag the slider to change the temperature
			thresholdSlider();
			Thread.sleep(4000);

			// Verifying plus icon
			plusIconButton();
			ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			Thread.sleep(2000);

			// Verifying minus icon
			minusIconButton();
			ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);

			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				ATUReports.add("Next  button is enabled in the  LOW EC THRESHOLD screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next  button is enabled in the  LOW EC THRESHOLD screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(4000);

			/**//***************************************************************************************************************
				 * High Salinity Threshold
				 ************************************************************************************************************//*
																																
																																*
																																*/
			// verify the header text
			verify_Header();

			// get the value of the optional and click on it
			Thread.sleep(4000);
			if (irrigationPage.gethighSalinityOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider in Variety", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement6 = irrigationPage.gethighSalinityOptional();
				int xInitialOptional6 = optionalElement6.getLocation().getX()
						+ optionalElement6.getSize().getWidth() / 2;
				int yInitialOptional6 = optionalElement6.getLocation().getY()
						+ optionalElement6.getSize().getHeight() / 2;
				System.out.println("xInitialOptional " + xInitialOptional6 + "yInitialOptional" + yInitialOptional6);
				//driver.swipe(xInitialOptional6, yInitialOptional6, xInitialOptional6 + 80, yInitialOptional3, 5000);
				
				if(xInitialOptional6<1200){  
					driver.swipe(xInitialOptional6, yInitialOptional6, xInitialOptional6+80, yInitialOptional6, 5000);
					//System.out.println("in 1st loop optional");
				}else{				
						if(xInitialOptional6>1200){
						driver.swipe(xInitialOptional6, yInitialOptional6, xInitialOptional6+120, yInitialOptional6, 5000);
							//System.out.println("in 2nd loop optional");
						}
				}
				
				Thread.sleep(2000);
			} else {
				ATUReports.add("optional Slier is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify title text.
			String high_thresold_title = irrigationPage.gethighSanityTitle().getText();
			if (high_thresold_title.isEmpty()) {
				ATUReports.add("Verify the High Salinity Threshold text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (high_thresold_title.contains("High Salinity Threshold")) {
					ATUReports.add("High Salinity Threshold is noticed in the screen", "High Salinity Threshold",
							low_ec_thresold_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("High Salinity Threshold is not noticed in the screen", "High Salinity Threshold",
							low_ec_thresold_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Verify Irrigation Body text.
			String high_thresold_body = irrigationPage.gethighSalinityCaption().getText();
			// System.out.println(title);
			if (high_thresold_body.isEmpty()) {
				ATUReports.add("High Salinity Threshold body element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (high_thresold_body.contains("Alert triggered if salinity is at or above threshold.")) {
					ATUReports.add("High Salinity Threshold body text is noticed in the screen ",
							"Alert triggered if salinity is at or above threshold.", low_ec_thresold_body, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("High Salinity Threshold caption text is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// verify the optional text
			verify_Optionaltxt();

			// Enter some value in the Saturation
			Thread.sleep(2000);
			irrigationPage.gethighSalinityThresholdTxtBx().sendKeys(Keys.DELETE);
			irrigationPage.gethighSalinityThresholdTxtBx().sendKeys(Keys.INSERT);
			Thread.sleep(2000);
			irrigationPage.gethighSalinityThresholdTxtBx().sendKeys(read_irrigation.high_ec_threshold);
			ATUReports.add("Saturation value given in the text box", read_irrigation.high_ec_threshold, LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);

			// Verify Drag the slider to change the temperature
			thresholdSlider();
			Thread.sleep(4000);

			// Verifying plus icon
			plusIconButton();
			ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			Thread.sleep(2000);

			//Verifying mius icon
			minusIconButton();
			ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				ATUReports.add("Next  button is enabled in the  High EC THRESHOLD screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next  button is enabled in the  HIGH EC THRESHOLD screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(2000);

			/**//***************************************************************************************************************
				 * Pressure Sensor/Switch
				 ************************************************************************************************************//*
																																*/
			// verify the header text
			verify_Header();

			// com.davis.mobilize:id/tb_pressure_sensor

			// get the value of the optional and click on it
			Thread.sleep(4000);
			if (irrigationPage.getpresureSensorOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider in Variety", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement3 = irrigationPage.getpresureSensorOptional();
				int xInitialOptional3 = optionalElement3.getLocation().getX()
						+ optionalElement3.getSize().getWidth() / 2;
				int yInitialOptional3 = optionalElement3.getLocation().getY()
						+ optionalElement3.getSize().getHeight() / 2;
				System.out.println("xInitialOptional " + xInitialOptional3 + "yInitialOptional" + yInitialOptional3);
				//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3 + 80, yInitialOptional3, 5000);
				
				if(xInitialOptional3<1200){  
					driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+80, yInitialOptional3, 5000);
					//System.out.println("in 1st loop optional");
				}else{				
						if(xInitialOptional3>1200){
						driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+120, yInitialOptional3, 5000);
							//System.out.println("in 2nd loop optional");
						}
				}
				
				Thread.sleep(2000);
			} else {
				ATUReports.add("optional Slier is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify title text.
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

			// Verify Irrigation Body text.
			String high_ec_thresold_body = irrigationPage.getpresureSensorCaption().getText();
			// System.out.println(title);
			if (high_ec_thresold_body.isEmpty()) {
				ATUReports.add("Pressure Sensor/Switch body element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (high_ec_thresold_body
						.contains("Select the appropriate device and sensor input for monitoring irrigation status.")) {
					ATUReports.add("Pressure Sensor/Switch body text is noticed in the screen ",
							"Select the appropriate device and sensor input for monitoring irrigation status.",
							high_ec_thresold_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Pressure Sensor/Switch caption text is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// verify the optional text
			verify_Optionaltxt();

			// Verify drop downs
			// Select any option from device drop down -
			irrigationPage.getpresureSensoraDeviceDropdown().click();
			Thread.sleep(2000);
			irrigationPage.getdeviceDropDown().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
			Thread.sleep(1000);

			// Select any option from sensor drop down
			//irrigationPage.getpresureSensorSensorDropdown().click();
			Thread.sleep(2000);
			irrigationPage.getsensorDropDown().click();
			ATUReports.add("Clicked on the Sensor drop down and selected the S Omega PX309-015G5V", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);

			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				ATUReports.add("Next  button is enabled in the  HIGH EC THRESHOLD screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Next  button is enabled in the  PRESSURE SENSOR screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			Thread.sleep(2000);

			/**//***************************************************************************************************************
				 * FLOW METER SENSOR
				 ************************************************************************************************************//*
																																*/

			// verify the back button
			verify_Back_button();
			
			// get the value of the optional and click on it
			Thread.sleep(4000);
			if (irrigationPage.getflowMeterOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider in Variety", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement3 = irrigationPage.getflowMeterOptional();
				int xInitialOptional3 = optionalElement3.getLocation().getX()
						+ optionalElement3.getSize().getWidth() / 2;
				int yInitialOptional3 = optionalElement3.getLocation().getY()
						+ optionalElement3.getSize().getHeight() / 2;
				System.out.println("xInitialOptional " + xInitialOptional3 + "yInitialOptional" + yInitialOptional3);
				//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3 + 80, yInitialOptional3, 5000);
				

				if(xInitialOptional3<1200){  
					driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+80, yInitialOptional3, 5000);
					//System.out.println("in 1st loop optional");
				}else{				
						if(xInitialOptional3>1200){
						driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+120, yInitialOptional3, 5000);
							//System.out.println("in 2nd loop optional");
						}
				}
				
				Thread.sleep(2000);
			} else {
				ATUReports.add("optional Slier is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

			// Verify Irrigation Body text.
			String flow_meter_sensor_body = irrigationPage.getflowBodyText().getText();
		
			if (flow_meter_sensor_body.isEmpty()) {
				ATUReports.add("FLOW METER SENSOR body element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (flow_meter_sensor_body.contains(
						"Select the appropriate device and sensor input for monitoring irrigation flow status.")) {
					ATUReports.add("FLOW METER SENSOR body text is noticed in the screen ",
							"Select the appropriate device and sensor input for monitoring irrigation flow status.",
							flow_meter_sensor_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("FLOW METER SENSOR caption text is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Select any option from device drop down -
			irrigationPage.getflowMeterDeviceDropdown().click();
			Thread.sleep(2000);
			irrigationPage.getdeviceDropDown().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Select any option from sensor drop down
			irrigationPage.getflowMeterSensordropdown().click();
			Thread.sleep(2000);
			irrigationPage.getsensorDropDown().click();
			ATUReports.add("Clicked on the Sensor drop down and selected the Seametrics AG2000 -300 -XXX -PxX GPM G",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);

			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();

				ATUReports.add("Next  button is enabled in the   FLOW METER SENSOR screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("SKIP  button is enabled in the  FLOW METER SENSOR screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(2000);

			/**//***************************************************************************************************************
				 * ET READING
				 ************************************************************************************************************//*
																																*/
			// verify the header text
			verify_Header();

			// get the value of the optional and click on it
			Thread.sleep(4000);
			if (irrigationPage.getetOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider in Variety", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement3 = irrigationPage.getetOptional();
				int xInitialOptional3 = optionalElement3.getLocation().getX()
						+ optionalElement3.getSize().getWidth() / 2;
				int yInitialOptional3 = optionalElement3.getLocation().getY()
						+ optionalElement3.getSize().getHeight() / 2;
				System.out.println("xInitialOptional " + xInitialOptional3 + "yInitialOptional" + yInitialOptional3);
				//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3 + 80, yInitialOptional3, 5000);
				
				if(xInitialOptional3<1200){  
					driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+80, yInitialOptional3, 5000);
					//System.out.println("in 1st loop optional");
				}else{				
						if(xInitialOptional3>1200){
						driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+120, yInitialOptional3, 5000);
							//System.out.println("in 2nd loop optional");
						}
				}
				Thread.sleep(2000);
			} else {
				ATUReports.add("optional Slier is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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

			// Verify Irrigation Body text.
			String et_reading_body = irrigationPage.getetReadingCaption().getText();
			// System.out.println(title);
			if (et_reading_body.isEmpty()) {
				ATUReports.add("ET READING body element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (et_reading_body.contains(
						"elect the appropriate weather station or sensor input for monitoring ET (Solar Radiation sensor required).")) {
					ATUReports.add("ET READING body text is noticed in the screen ",
							"elect the appropriate weather station or sensor input for monitoring ET (Solar Radiation sensor required).",
							et_reading_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("ET READING caption text is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// verify the optional text
			verify_Optionaltxt();

			// Select any option from device drop down -
			// get the value of the optional and click on it
			irrigationPage.getetDeviceDropDown().click();
			Thread.sleep(2000);
			irrigationPage.getdeviceDropDown().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Select any option from sensor drop down
			//irrigationPage.getetSensorDropDown().click();
			Thread.sleep(2000);
			irrigationPage.getsensorDropDown().click();
			ATUReports.add("Clicked on the Sensor drop down and selected the Davis GroWeather, FARS", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();

				ATUReports.add("Next  button is enabled in the ET READING screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next  button is enabled in the  ET READING screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(2000);

			/*
				*//***************************************************************************************************************
					 * COMPLETE IRRIGATION SETUP
					 ************************************************************************************************************//*
																																*/
			// verify the header text
			verify_Header();

			// Verify title text.
			String complete_irrigation_title = irrigationPage.getTitletxt().getText();
			if (complete_irrigation_title.isEmpty()) {
				ATUReports.add("Verify the COMPLETE IRRIGATION SETUP text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (complete_irrigation_title.equals("Complete Irrigation Setup")) {
					ATUReports.add("Complete Irrigation Setup is noticed in the screen", "Complete Irrigation Setup",
							complete_irrigation_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("COMPLETE IRRIGATION SETUP is not noticed in the screen",
							"Complete Irrigation Setup", complete_irrigation_title, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Verify Irrigation Body text.
			String complete_irrigation_body = irrigationPage.getBodytxt().getText();
			// System.out.println(title);
			if (complete_irrigation_body.isEmpty()) {
				ATUReports.add("COMPLETE IRRIGATION SETUP body element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (complete_irrigation_body.contains(
						"Save the setup to view the irrigation report. Go back to edit any irrigation setup setting.")) {
					ATUReports.add("COMPLETE IRRIGATION SETUP body text is noticed in the screen ",
							"Save the setup to view the irrigation report. Go back to edit any irrigation setup setting.",
							complete_irrigation_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("COMPLETE IRRIGATION SETUP caption text is not observed in the screen ",
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				ATUReports.add(
						"Save  button is enabled in the  COMPLETE IRRIGATION SETUP screen and Clicked on Save button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
			
			} else {
				ATUReports.add(
						"Save  button is enabled in the  COMPLETE IRRIGATION SETUP screen and Clicked on Save button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(3000);
			
			   // Verifying tutorial icon
			   Thread.sleep(2000);
			  Precondition.tutorialDisalogBox();
						
						
			   //Verify arrow buttons in report page								
				if(frostPage.getirrigationDownArrow()!=null){
					ATUReports.add("Arrow button is displayed",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					if(frostPage.getirrigationDownArrow().isDisplayed()){
						ATUReports.add("Clicked on Down arrow button in view report",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
						frostPage.getirrigationDownArrow().click();
						Thread.sleep(4000);
						if(frostPage.getirrigatinViewReportInformation().isDisplayed()){
							ATUReports.add("After clicked on down arrow button it is expanded and displayed view report information",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("View report information is not displayed ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}
						
					}else{
						ATUReports.add("Down arrow button is not displayed ",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}else{
					ATUReports.add("Down arrow button is not displayed in vew report",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				

			// Click on Manage Account
			homepage.getAccountbtn().click();
			ATUReports.add("Clicked on account Tab", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(4000);
			
			
			// Verifying tutorial icon
			Thread.sleep(2000);
			Precondition.tutorialDisalogBox();

			// Click on Settings button
			accountPage.getsettings().click();
			Thread.sleep(3000);
			System.out.println("Clicked on settings");
			ATUReports.add("Click Settings/Gear button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Click on log out button
			accountPage.getsettingsLogoutBtn().click();
			System.out.println("Clicked on logout");
			Thread.sleep(4000);
			ATUReports.add("Click Logout button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Click on Ok Button
			accountPage.getlogoutAlertOk().click();
			System.out.println("Clicked on ok");
			Thread.sleep(2000);
			ATUReports.add("Click ok button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} catch (Exception e) {
			e.printStackTrace();
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

	private void verify_Optionaltxt() {
		// Verify the Optional button text
		String Optional;
		try {
			Optional = irrigationPage.getOptionaltxt().getText();

			if (Optional.isEmpty()) {
				ATUReports.add("Optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional.contains("optional")) {
					ATUReports.add("optional text is noticed in the screen ", "Optional", Optional, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Optional text is not observed in the screen ", Optional, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void thresholdSlider() throws InterruptedException {

		// move the slider
		Thread.sleep(4000);
		WebElement lastElement = frostPage.getTempSlier();
		Thread.sleep(2000);
		int xInitial = lastElement.getLocation().getX() + lastElement.getSize().getWidth() / 2;
		int yInitial = lastElement.getLocation().getY() + lastElement.getSize().getHeight() / 2;
		System.out.println("xInitial " + xInitial + "yInitial" + yInitial);
		driver.swipe(xInitial, yInitial, xInitial + 200, yInitial, 5000);
		ATUReports.add("Slider is displayed and moved the slider from left to right", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	public void plusIconButton() throws InterruptedException {
		// move the slider
		Thread.sleep(4000);
		WebElement lastElement = frostPage.getplusIcon();

		if (lastElement.isDisplayed()) {
			lastElement.click();
			ATUReports.add("Plus icon is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} else {

			ATUReports.add("Plus icon is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			driver.close();
		}
	}

	public void minusIconButton() throws InterruptedException {
		// move the slider
		Thread.sleep(4000);
		WebElement lastElement = frostPage.getminusIcon();
		if (lastElement.isDisplayed()) {
			lastElement.click();
			ATUReports.add("Minus icon is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} else {

			ATUReports.add("Minus icon is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			driver.close();
		}
	}

}
