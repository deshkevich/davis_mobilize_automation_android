package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.ReadUserData;
import utility.Read_Irrigation_Details;

public class Verify_Edit_Irrigation_Settings {
	private AndroidDriver driver;
	private NewViewScreenPage newviewscreen;
	private LoginPage loginpage;
	private NewViewScreenPage newscreenpage;
	private ReadUserData readUserData;
	private IrrigationPage irrigationPage;
	private HomePage homepage;
	private Read_Irrigation_Details read_irrigation;
	private Account_Page accountPage;
	private FrostPage frostPage;
	private Alert_Page	alertpage;
	@Test
	public void editIrrigationSettings() throws InterruptedException {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		newviewscreen = new NewViewScreenPage(driver);
		new Alert_Page(driver);
		loginpage = new LoginPage(driver);
		newscreenpage = new NewViewScreenPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		irrigationPage = new IrrigationPage(driver);
		homepage = new HomePage(driver);
		read_irrigation = new Read_Irrigation_Details();
		read_irrigation.start();
		accountPage=new Account_Page(driver);
		Thread.sleep(2000);
		frostPage = new FrostPage(driver);
		alertpage=new Alert_Page(driver);
		try {
			
			
			Thread.sleep(5000);
			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();


			//click on particular view 
			Thread.sleep(5000);
			for (int j = 1; j <= 4; j++) {
				System.out.println(j+"--j---");
				WebElement warning =driver.findElement(By.xpath("//android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout["+j+"]/android.widget.RelativeLayout[1]/android.widget.TextView[2]"));				
				if (warning!=null) {
					int textOne=Integer.parseInt(warning.getText());
				  System.out.println(textOne+"--textOne--");
					if(textOne==0){
						WebElement view =driver.findElement(By.xpath("//android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout["+j+"]/android.widget.RelativeLayout[1]/android.widget.TextView[3]"));	
				        Thread.sleep(4000);	
						view.click();	
					}else{					
						if(homepage.getdialogBox()!=null){
							if(homepage.getdialogBox().isDisplayed()){
								String tutorialText=homepage.gettutorialMessage().getText();
								String tutorialButton=homepage.gettutorialNext1().getText();
								ATUReports.add("Mobilize tutorial dialog box "+tutorialText+ "is displayed with  "+tutorialButton+" button", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));								
								Thread.sleep(2000);
								homepage.gettutorialCoseIcon().click();
								Thread.sleep(2000);
								
								
								//click on view using touch action
								WebElement view =driver.findElement(By.xpath("//android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout["+j+"]/android.widget.RelativeLayout[1]/android.widget.TextView[3]"));	
								Thread.sleep(4000);					
								TouchAction action = new TouchAction(driver);
								action.longPress(view).release().perform();
								Thread.sleep(4000);
								
								
							}else{
								ATUReports.add("Mobilize tutorial dialog box is not displayed", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
							
							}else{
								
								//click on view using touch action
								WebElement view =driver.findElement(By.xpath("//android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout["+j+"]/android.widget.RelativeLayout[1]/android.widget.TextView[3]"));	
								Thread.sleep(4000);					
								TouchAction action = new TouchAction(driver);
								action.longPress(view).release().perform();
								Thread.sleep(4000);	
								
							}
						
					}				
				}	else{
					ATUReports.add("Mobilize Notification warning flags are not displayed in current screen ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				
				
				//close tutorial screen
				Thread.sleep(7000);			
				if(homepage.getdialogBox()!=null){
					if(homepage.getdialogBox().isDisplayed()){
						String tutorialText=homepage.gettutorialMessage().getText();
						String tutorialButton=homepage.gettutorialNext1().getText();
						ATUReports.add("Mobilize tutorial dialog box "+tutorialText+ "is displayed with  "+tutorialButton+" button", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);
						homepage.gettutorialCoseIcon().click();
						Thread.sleep(2000);
						driver.navigate().back();
						Thread.sleep(2000);
						j=1;	
						
					}else{
						ATUReports.add("Mobilize tutorial dialog box is not  displayed", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
			
				}else{
				if (newviewscreen.getshareIcon() != null && newviewscreen.getshareIcon().isEnabled()) {
					Thread.sleep(1000);
					ATUReports.add(
							"verified the share icon in the : " + j
									+ " view displayed in the Home screen,Share icon is enabled in the screen ",
							LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					if (newviewscreen.getirrigtainSettingsTitle() != null
							&& newviewscreen.getirrigtainSettingsTitle().isDisplayed()) {
						if (newviewscreen.getirrigtainSettingsTitle() != null
								&& newviewscreen.getirrigationSettingsIcon().isEnabled()) {
							ATUReports.add(
									newviewscreen.getirrigtainSettingsTitle().getText()
											+ " Settings Title is is dispalyed",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							break;
						} else {
							ATUReports.add(
									newviewscreen.getirrigtainSettingsTitle().getText()
											+ " Settings Title is not dispalyed",
									LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							//return;
						}
						

					} else {
						System.out.println("I am share icon inside else");
						// Click on home page back button
						driver.navigate().back();
						Thread.sleep(2000);
						ATUReports.add("Navigate back", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}


				} else {

					System.out.println("I am outside share ßicon else");
				
					// Click on home page back button
					driver.navigate().back();
					Thread.sleep(2000);
					ATUReports.add("Navigate back", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				}
				if (j == 4) {
					Thread.sleep(2000);
					  // scroll up the current page	 homepage		for all devices:		
					WebElement listElement =homepage.getviewsList();
					int xInitialList = listElement.getLocation().getX() + listElement.getSize().getWidth()/2;
					int yInitialList = listElement.getLocation().getY() + listElement.getSize().getHeight()/2;
					System.out.println("=startx "+xInitialList+" "+ yInitialList+"=end y  scroll down to  up the page");
					Thread.sleep(2000);
								
					
					//Swiping list based on coordinates
					if(yInitialList<=750){//550
						driver.swipe(xInitialList, yInitialList, xInitialList, yInitialList-430, 5000);
						System.out.println("in 1st loop");
					}else{				
							if(yInitialList>=900){
								driver.swipe(xInitialList, yInitialList, xInitialList, yInitialList-730, 5000);
								System.out.println("in 2nd loop");
							}
						
					}
					
					j =1;
					Thread.sleep(2000);
					ATUReports.add("Scroll up the view list", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			}
			

			String titleText = homepage.gettitleText().getText();
			MobileElement settings = newscreenpage.getirrigationSettingsIcon();
			if (settings.isEnabled()) {
				ATUReports.add("Irrigation Settings Icon is enabled Clicked on Settings Icon ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				settings.click();
			} else {
				ATUReports.add("Irrigation Settings Icon  is Disabled", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			
			
			// // verify the Edit settings button. and Click on edit settings.
			MobileElement editsettings = newscreenpage.getfrostEditSettingsButton();
			if (editsettings != null) {
				if (editsettings.isDisplayed()) {
					ATUReports.add("Irrigation EditSettings Button is dispalyed and Clicked on edit settings.",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					editsettings.click();
					Thread.sleep(2000);
				} else {
					ATUReports.add("Irrigation EditSettings Button is not dispalyed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}
			Thread.sleep(2000); 
			
			// Verifying tutorial icon
			Thread.sleep(2000);
			Precondition.tutorialDisalogBox();	
			
			
			// Verify user navigated to edit frost page.	
			String editFrostTitle = homepage.gettitleText().getText();
			System.out.println(editFrostTitle+"--editFrostTitle");
			if (editFrostTitle != null) {
				if (editFrostTitle.contains("Edit Irrigation")) {
					ATUReports.add("User is navigated to 'Edit Irrigation' page. able to Edit Irrigation settings",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("User is not navigated to 'Edit Irrigation' page.", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}
			Thread.sleep(1000); 
			
			// get the value of the optional and click on it					
			Thread.sleep(5000);
			if(irrigationPage.gettogglebtnOptional().isDisplayed()){			
				ATUReports.add("Optional Slier is displayed and move the slider in Variety",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
				Thread.sleep(4000);
				WebElement optionalElement =irrigationPage.gettogglebtnOptional();
				int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
				int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
				System.out.println("xInitialOptional "+xInitialOptional+ "yInitialOptional"+yInitialOptional);
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
			// Verify  title text.
			
			// get the value of the optional and click on it					
						Thread.sleep(4000);
						if(irrigationPage.getsaturationOptional().isDisplayed()){			
							ATUReports.add("Optional Slier is displayed and move the slider in Variety",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
							Thread.sleep(4000);
							WebElement optionalElement2=irrigationPage.getsaturationOptional();
							int xInitialOptional = optionalElement2.getLocation().getX() + optionalElement2.getSize().getWidth()/2;
							int yInitialOptional = optionalElement2.getLocation().getY() + optionalElement2.getSize().getHeight()/2;
							System.out.println("xInitialOptional "+xInitialOptional+ "yInitialOptional"+yInitialOptional);
							//driver.swipe(xInitialOptional2, yInitialOptional2, xInitialOptional2+80, yInitialOptional2, 5000);
							
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
				}

				else {
					ATUReports.add("SATURATION text is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Enter some value in the Saturation
			// irrigationPage.getsaturationTextBox().clear();
			Thread.sleep(2000);
			String saturation = read_irrigation.saturation_threshold;
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


			// get the value of the optional and click on it					
			Thread.sleep(4000);
			if(irrigationPage.getwiltingOptional().isDisplayed()){			
				ATUReports.add("Optional Slier is displayed and move the slider in Variety",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
				Thread.sleep(4000);
				WebElement optionalElement3=irrigationPage.getwiltingOptional();
				int xInitialOptional= optionalElement3.getLocation().getX() + optionalElement3.getSize().getWidth()/2;
				int yInitialOptional= optionalElement3.getLocation().getY() + optionalElement3.getSize().getHeight()/2;
				System.out.println("xInitialOptional "+xInitialOptional+ "yInitialOptional"+yInitialOptional);
				//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+80, yInitialOptional3, 5000);
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
				}

				else {
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
				}

				else {
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
			//move the slider
			//AddFrost slider=new AddFrost();
			thresholdSlider();
			Thread.sleep(4000);
			
		
			//Clicked 
			plusIconButton();
			ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			Thread.sleep(2000);
			
			//clicked on minus icon
			minusIconButton();
			ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
			
			// get the value of the optional and click on it					
			Thread.sleep(4000);
			if(irrigationPage.getearlyFrostWraningOptional().isDisplayed()){			
				ATUReports.add("Optional Slier is displayed and move the slider in Variety",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
				Thread.sleep(4000);
				WebElement optionalElement3=irrigationPage.getearlyFrostWraningOptional();
				int xInitialOptional= optionalElement3.getLocation().getX() + optionalElement3.getSize().getWidth()/2;
				int yInitialOptional= optionalElement3.getLocation().getY() + optionalElement3.getSize().getHeight()/2;
				System.out.println("xInitialOptional "+xInitialOptional+ "yInitialOptional"+yInitialOptional);
				//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+80, yInitialOptional3, 5000);
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
			          // get the value of the optional and click on it					
						Thread.sleep(4000);
						if(irrigationPage.getlowSalinityOptional().isDisplayed()){			
							ATUReports.add("Optional Slier is displayed and move the slider in Variety",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
							Thread.sleep(4000);
							WebElement optionalElement3=irrigationPage.getlowSalinityOptional();
							int xInitialOptional= optionalElement3.getLocation().getX() + optionalElement3.getSize().getWidth()/2;
							int yInitialOptional= optionalElement3.getLocation().getY() + optionalElement3.getSize().getHeight()/2;
							System.out.println("xInitialOptional "+xInitialOptional+ "yInitialOptional"+yInitialOptional);
							//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+80, yInitialOptional3, 5000);
							
							
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
			
		
			//Verifying plus icon
			plusIconButton();
			ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			Thread.sleep(2000);
			
			//Verifying minus icon
			minusIconButton();
			ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			

			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				// irrigationPage.getskipbtn().click();

				ATUReports.add("Next  button is enabled in the  LOW EC THRESHOLD screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Next  button is enabled in the  LOW EC THRESHOLD screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(2000);
			/**//***************************************************************************************************************
				 * High Salinity Threshold
				 ************************************************************************************************************//*
																																*/
			// get the value of the optional and click on it					
			Thread.sleep(4000);
			if(irrigationPage.gethighSalinityOptional().isDisplayed()){			
				ATUReports.add("Optional Slier is displayed and move the slider in Variety",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
				Thread.sleep(4000);
				WebElement optionalElement3=irrigationPage.gethighSalinityOptional();
				int xInitialOptional3= optionalElement3.getLocation().getX() + optionalElement3.getSize().getWidth()/2;
				int yInitialOptional3= optionalElement3.getLocation().getY() + optionalElement3.getSize().getHeight()/2;
				System.out.println("xInitialOptional "+xInitialOptional3+ "yInitialOptional"+yInitialOptional3);
				//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+80, yInitialOptional3, 5000);
				
				
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
			}else{
				ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
			// irrigationPage.getlowSanityTextbox().clear();
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
			
		
			//Verifying plus icon
			plusIconButton();
			ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			Thread.sleep(2000);
			
			//Verifying minus icon
			minusIconButton();
			ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			

			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				// irrigationPage.getskipbtn().click();

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
			     // get the value of the optional and click on it					
						Thread.sleep(4000);
						if(irrigationPage.getpresureSensorOptional().isDisplayed()){			
							ATUReports.add("Optional Slier is displayed and move the slider in Variety",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
							Thread.sleep(4000);
							WebElement optionalElement3=irrigationPage.getpresureSensorOptional();
							int xInitialOptional3= optionalElement3.getLocation().getX() + optionalElement3.getSize().getWidth()/2;
							int yInitialOptional3= optionalElement3.getLocation().getY() + optionalElement3.getSize().getHeight()/2;
							System.out.println("xInitialOptional "+xInitialOptional3+ "yInitialOptional"+yInitialOptional3);
							//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+80, yInitialOptional3, 5000);
							
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
						}else{
							ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
			//irrigationPage.getpresureSensoraDeviceDropdown().click();
			Thread.sleep(2000);
			irrigationPage.getdeviceDropDown().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			//driver.hideKeyboard();
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
				// irrigationPage.getskipbtn().click();

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

			
																																
			// get the value of the optional and click on it					
			Thread.sleep(4000);
			if(irrigationPage.getflowMeterOptional().isDisplayed()){			
				ATUReports.add("Optional Slier is displayed and move the slider in Variety",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
				Thread.sleep(4000);
				WebElement optionalElement3=irrigationPage.getflowMeterOptional();
				int xInitialOptional3= optionalElement3.getLocation().getX() + optionalElement3.getSize().getWidth()/2;
				int yInitialOptional3= optionalElement3.getLocation().getY() + optionalElement3.getSize().getHeight()/2;
				System.out.println("xInitialOptional "+xInitialOptional3+ "yInitialOptional"+yInitialOptional3);
				//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+80, yInitialOptional3, 5000);
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
			}else{
				ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
			// System.out.println(title);
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
			//irrigationPage.getflowMeterDeviceDropdown().click();
			Thread.sleep(2000);
			if(irrigationPage.getdeviceDropDown()!=null){
			irrigationPage.getdeviceDropDown().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Select any option from sensor drop down
			//irrigationPage.getflowMeterSensordropdown().click();
			Thread.sleep(2000);
			irrigationPage.getsensorDropDown().click();
			ATUReports.add("Clicked on the Sensor drop down and selected the Seametrics AG2000 -300 -XXX -PxX GPM G",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			}
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
			        // get the value of the optional and click on it					
						Thread.sleep(4000);
						if(irrigationPage.getetOptional().isDisplayed()){			
							ATUReports.add("Optional Slier is displayed and move the slider in Variety",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
							Thread.sleep(4000);
							WebElement optionalElement3=irrigationPage.getetOptional();
							int xInitialOptional3= optionalElement3.getLocation().getX() + optionalElement3.getSize().getWidth()/2;
							int yInitialOptional3= optionalElement3.getLocation().getY() + optionalElement3.getSize().getHeight()/2;
							System.out.println("xInitialOptional "+xInitialOptional3+ "yInitialOptional"+yInitialOptional3);
							//driver.swipe(xInitialOptional3, yInitialOptional3, xInitialOptional3+80, yInitialOptional3, 5000);
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
						}else{
							ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
						"Select the appropriate weather station or sensor input for monitoring ET (Solar Radiation sensor required).")) {
					ATUReports.add("ET READING body text is noticed in the screen ",
							"Select the appropriate weather station or sensor input for monitoring ET (Solar Radiation sensor required).",
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
		//	irrigationPage.getetDeviceDropDown().click();
			Thread.sleep(2000);
			irrigationPage.getdeviceDropDown().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			
			// Select any option from sensor drop down
			//irrigationPage.getetSensorDropDown().click();
			Thread.sleep(2000);
			irrigationPage.getsensorDropDown().click();
			ATUReports.add("Clicked on the Sensor drop down and selected the Davis GroWeather, FARS", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			
			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				ATUReports.add("Next  button is enabled in the ET READING screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next  button is enabled in the  ET READING screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(2000);

		
			/**//***************************************************************************************************************
			  * COMPLETE IRRIGATION SETUP
			 ************************************************************************************************************//*
																															*/
			// verify the back button
			String back_btn8;
			
				back_btn8 = ((IrrigationPage) irrigationPage).getcancelButton().getText();
				if (back_btn8.isEmpty()) {
					ATUReports.add("Back is not observed in the screen ", LogAs.FAILED,
							
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));		
					} else {	
						ATUReports.add("Back button element is visible", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				
			

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

				Thread.sleep(3000);
			} else {
				ATUReports.add(
						"Save  button is enabled in the  COMPLETE IRRIGATION SETUP screen and Clicked on Save button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			Thread.sleep(3000);
			
			// Verifying tutorial icon
						Thread.sleep(2000);
						Precondition.tutorialDisalogBox();
			
			
			//Click on Manage Account    				
			homepage.getAccountbtn().click();
			ATUReports.add("Clicked on account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(3000);
			
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
	
	  //This method is used to navigate login page
    public void userLoginDetailsPage() throws InterruptedException{
	  // enter name in the username text box
				MobileElement username = loginpage.getUserNametxtbx();
				if (username.isDisplayed()) {
					username.sendKeys(readUserData.sUserName);
					driver.hideKeyboard();
				} else {
					driver.quit();
					return;
				}

				// Click on Next button
				clickonNextButton();
				Thread.sleep(2000);

				// enter password in the Password in the text box

				MobileElement password = loginpage.getpasswordtxtbx();
				if (password.isDisplayed()) {
					loginpage.getpasswordtxtbx().click();
					Thread.sleep(200);
					password.sendKeys(readUserData.sPassword);
					driver.hideKeyboard();
					Thread.sleep(3000);

				} else {
					driver.quit();
					return;

				}

				// Click on Next button
				clickonNextButton();
				Thread.sleep(20000);
				
				//Close pop up -Alert_Page-	alertpage
				alertpage.getcloseIcon().click();
				Thread.sleep(2000);

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










/*//Move slider
driver.swipe(122, 1422, 828, 1422, 1);
ATUReports.add("Moved the slider", LogAs.PASSED,
		new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
Thread.sleep(2000);*/
