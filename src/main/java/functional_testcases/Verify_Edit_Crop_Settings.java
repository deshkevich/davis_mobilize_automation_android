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
import utility.Read_Crop_Details;

public class Verify_Edit_Crop_Settings {
	private AndroidDriver driver;
	private NewViewScreenPage newviewscreen;
	private LoginPage loginpage;
	private NewViewScreenPage newscreenpage;
	private ReadUserData readUserData;
	private HomePage homepage;
	private CropPage cropPage;
	private FrostPage frostPage;
	private Read_Crop_Details readCropDetails;
	private Account_Page accountPage;
	private Alert_Page alertpage;

	@Test
	public void edit_Crop_Settings() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		newviewscreen = new NewViewScreenPage(driver);
		new Alert_Page(driver);
		loginpage = new LoginPage(driver);
		newscreenpage = new NewViewScreenPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		new IrrigationPage(driver);
		homepage = new HomePage(driver);
		cropPage = new CropPage(driver);
		frostPage = new FrostPage(driver);
		readCropDetails = new Read_Crop_Details();
		readCropDetails.start();
		accountPage = new Account_Page(driver);
		alertpage = new Alert_Page(driver);
		Thread.sleep(2000);
		try {

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
								Thread.sleep(3000);
								ATUReports.add(
										"verified the share icon in the : " + j
										+ " view displayed in the Home screen,Share icon is enabled in the screen ",
										LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								if (newviewscreen.getcropSettingsTitle() != null
										&& newviewscreen.getcropSettingsTitle().isDisplayed()) {
									if (newviewscreen.getcropSettingsTitle() != null
											&& newviewscreen.getcropSettingsIcon().isEnabled()) {
										ATUReports.add(
												newviewscreen.getcropSettingsTitle().getText()
												+ " Settings Title is is dispalyed",
												LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										break;							
									} else {
										ATUReports.add(
												newviewscreen.getcropSettingsTitle().getText()
												+ " Settings Title is not dispalyed",
												LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));					
									}	
								}else{
									
									driver.navigate().back();
									Thread.sleep(3000);
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
								
						if (j ==4) {
							Thread.sleep(2000);
							  // scroll up the current page	 homeb page for all devices:		
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
				Thread.sleep(2000);


			String titleText = homepage.gettitleText().getText();
			MobileElement settings = newscreenpage.getcropSettingsIcon();
			if (settings.isEnabled()) {
				ATUReports.add("Crop Settings Icon is enabled Clicked on Settings Icon ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				settings.click();
			} else {
				ATUReports.add("Crop Settings Icon  is Disabled", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// // verify the Edit settings button. and Click on edit settings.
			MobileElement editsettings = newscreenpage.getfrostEditSettingsButton();
			if (editsettings != null) {
				if (editsettings.isDisplayed()) {
					ATUReports.add("Crop EditSettings Button is dispalyed and Clicked on edit settings.", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					editsettings.click();
					Thread.sleep(4000);
				} else {
					ATUReports.add("Crop EditSettings Button is not dispalyed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}
			Thread.sleep(2000);
			// Verify user navigated to edit frost page.
			String editFrostTitle = homepage.gettitleText().getText();
			if (editFrostTitle != null) {
				if (editFrostTitle.contains("Edit Crop")) {
					ATUReports.add("User is navigated to 'Edit Crop' page. able to edit the Crop settings",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("User is not navigated to 'Edit Crop' page.", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Verify the title text
			String crop_sensor_title = cropPage.getTitletxt().getText();
			if (crop_sensor_title.isEmpty()) {
				ATUReports.add("Verify the Crop Sensor InputT text  in the screen ", "Crop Sensor Input",
						crop_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (crop_sensor_title.equals("Crop Sensor Input")) {
					ATUReports.add("Crop Sensor Input is noticed in the screen ", "Crop Sensor Input",
							crop_sensor_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("CROP SENSOR INPUT is not observed in the screen ", crop_sensor_title, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the crop sensor
			String cropbody = cropPage.getBodytxt().getText();
			if (cropbody.isEmpty()) {
				ATUReports.add("Verify the Crop Sensor Input caption text  in the screen ",
						"Select the appropriate device and temperature sensor input for monitoring crop data.",
						cropbody, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (cropbody.equals(
						"Select the appropriate device and temperature sensor input for monitoring crop data.")) {
					ATUReports.add("Crop Sensor Input caption text is dispalyed in the screen ",
							"Select the appropriate device and temperature sensor input for monitoring crop data.",
							cropbody, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Crop Sensor Input caption text is not dispalyed in the screen ", cropbody,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Select any option from device drop down -
			frostPage.getDevicestxt().click();
			frostPage.getDevicedropdown().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			frostPage.getSensortxt().click();
			// String sensor1 = frostpage.getSensortxt().getText();
			frostPage.getSensordropdown().click();
			ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Click on next button in the Crop Sensor Input
			if (cropPage.getNext_nxt_save_btn().isEnabled()) {
				cropPage.getNext_nxt_save_btn().click();
				ATUReports.add("Next button is enabled in the Crop Sensor Input and clicked on the Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next button is not enabled in the Crop Sensor Input", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verifying tutorial icon
						Thread.sleep(2000);
						Precondition.tutorialDisalogBox();
						
			// get the value of the optional and click on it
			Thread.sleep(4000);
			if (cropPage.getcropVerietyOptinal().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider in Variety", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement = cropPage.getcropVerietyOptinal();
				int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth() / 2;
				int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight() / 2;
				System.out.println("xInitialOptional " + xInitialOptional + "yInitialOptional" + yInitialOptional);
				//driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional + 80, yInitialOptional, 5000);
				
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

			// Verify Crop title text.
			String crop_sensor_title1 = cropPage.getcropandVariety().getText();
			System.out.println(crop_sensor_title1 + "CROP AND VARAIETY");
			if (crop_sensor_title1.isEmpty()) {
				ATUReports.add("Crop & Variety element is not available in the screen ", "CROP & VARIETY",
						crop_sensor_title1, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (crop_sensor_title1.contains("Crop & Variety")) {
					ATUReports.add("Crop & Variety is noticed in the screen ", "Crop & Variety", crop_sensor_title1,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Crop & Variety is not observed in the screen ", crop_sensor_title1, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			String crop_body = cropPage.getvarietyBody().getText();
			if (crop_body.isEmpty()) {
				ATUReports.add("Verify the Crop caption text  in the screen ",
						"Enter the crop type and variety to build a crop specific profile.", crop_body, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (crop_body.contains("Enter the crop type and variety to build a crop specific profile.")) {
					ATUReports.add("Crop caption text is dispalyed in the screen ",
							"Enter the crop type and variety to build a crop specific profile.", crop_body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Crop caption text is not dispalyed in the screen ", cropbody, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			if (cropPage.getCropText().isDisplayed()) {

				// Verify the body text in the crop
				String crop = cropPage.getCropText().getText();
				if (crop.isEmpty()) {
					ATUReports.add("Verify the Crop: caption text  in the screen ", "Crop:", crop, LogAs.WARNING,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (crop.contains("Crop:")) {
						ATUReports.add("Crop: caption text is dispalyed in the screen ", "Crop:", crop, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Crop: caption text is not dispalyed in the screen ", crop, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				// Enter Crop details
				cropPage.getCroptxtfld().click();
				Thread.sleep(2000);
				cropPage.getCroptxtfld().sendKeys(Keys.DELETE);
				cropPage.getCroptxtfld().sendKeys(Keys.INSERT);
				Thread.sleep(2000);
				cropPage.getCroptxtfld().sendKeys(readCropDetails.crop);
				driver.hideKeyboard();

				// Verify the body text in the crop
				String veriety = cropPage.getVarietyText().getText();
				if (veriety.isEmpty()) {
					ATUReports.add("Verify the Variety: caption text  in the screen ", "Variety:", veriety,
							LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					if (veriety.contains("Variety:")) {
						ATUReports.add("Variety: caption text is dispalyed in the screen ", "Variety:", veriety,
								LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Variety: caption text is not dispalyed in the screen ", veriety, LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				// Enter Variety details
				cropPage.getVarietytxtfld().click();
				Thread.sleep(1000);
				cropPage.getVarietytxtfld().sendKeys(Keys.DELETE);
				cropPage.getVarietytxtfld().sendKeys(Keys.INSERT);
				Thread.sleep(2000);
				cropPage.getVarietytxtfld().sendKeys(readCropDetails.variety);
				driver.hideKeyboard();
			}

			// Click on Skip button in the Edit Crop -Crop screen.
			if (cropPage.getNext_nxt_save_btn().isEnabled()) {
				cropPage.getNext_nxt_save_btn().click();
				ATUReports.add("Skip button is enabled in the Crop and clicked on the Next button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Skip button is not enabled in the Crop page", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// get the value of the optional and click on it
			Thread.sleep(4000);
			if (cropPage.getcropGddOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider in gdd ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
				WebElement optionalElement = cropPage.getcropGddOptional();
				int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth() / 2;
				int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight() / 2;
				System.out.println(
						"xInitialOptional gdd " + xInitialOptional + "yInitialOptional gdd" + yInitialOptional);
				//driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional + 80, yInitialOptional, 5000);
				
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
					ATUReports.add("Date (GDD) is not observed in the screen ", growing_degree_title, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify body text
			// Verify the body text in the crop
			String crop_bodyGDD = cropPage.getgddCaption().getText();
			if (crop_bodyGDD.isEmpty()) {
				ATUReports.add("Verify the Crop caption text  in the screen ",
						"Set the starting date to begin accumulating GDD.", crop_bodyGDD, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (crop_bodyGDD.contains("Set the starting date to begin accumulating GDD.")) {
					ATUReports.add("Crop GDD caption text is dispalyed in the screen ",
							"Set the starting date to begin accumulating GDD.", crop_bodyGDD, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Crop GDD caption text is not dispalyed in the screen ", cropbody, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
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
				ATUReports.add("Next button is not enabled in the Crop Sensor Input", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify Crop title text.
			String crop_target = cropPage.getTitletxt().getText();
			// System.out.println(title);
			if (crop_target.isEmpty()) {
				ATUReports.add("Crop Target element is not available in the screen ", "CROP TARGET", crop_target,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (crop_target.contains("GDD Target")) {
					ATUReports.add("GDD Target is noticed in the screen ", "GDD Target", crop_target, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("GDD Target is not observed in the screen ", crop_target, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the crop
			String crop_Target_body = cropPage.getBodytxt().getText();
			if (crop_Target_body.isEmpty()) {
				ATUReports.add("Verify the Crop Target caption text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (crop_Target_body.contains("Set the total number of GDD required to reach the desired stage.")) {
					ATUReports.add("Crop Target caption text is dispalyed in the screen ",
							"Set the total number of GDD required to reach the desired stage.", crop_Target_body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Crop Target caption text is not dispalyed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				if (crop_Target_body.contains("Set the total number of GDD required to reach the desired stage.")) {
					ATUReports.add("Crop Target caption text is dispalyed in the screen ",
							"Average wind date will show you an average for wind speeds, based on the units of measurement selected.",
							crop_Target_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Crop Target caption text is not dispalyed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Enter some text in the Crop target text box
			cropPage.gesetcroptarget().click();
			cropPage.gesetcroptarget().clear();
			cropPage.gesetcroptarget().sendKeys(readCropDetails.gddtarget);
			// cropPage.gesetcroptarget().sendKeys(readCropDetails);
			driver.hideKeyboard();

			// driver.hideKeyboard("tapOutside");
			if (cropPage.getNext_nxt_save_btn().isEnabled()) {
				cropPage.getNext_nxt_save_btn().click();
				ATUReports.add("Skip  button is enabled and Clicked on Skip button in the crop target screen ",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next button is not enabled in the Crop Sensor Input", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			/*****************************************************
			 * CROP CALCULATION TYPE SCREEN
			 ***********************************************************/

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

			// Verify the body text in the crop

			String crop_calculation_type_body = cropPage.getBodytxt().getText();
			if (crop_calculation_type_body.isEmpty()) {
				ATUReports.add("Verify the GDD Calculation Type caption text  in the screen ",

						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (crop_calculation_type_body
						.contains("Set the crop calculation format required for GDD calculation.")) {
					ATUReports.add("GDD Calculation Type caption text is dispalyed in the screen ",
							"Set the crop calculation format required for GDD calculation.", crop_calculation_type_body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("GDD Calculation Type caption text is not dispalyed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// click on Single Sine button
			Thread.sleep(200);

			// Verify singleaHelpButon
			MobileElement singleHelp = cropPage.getsingleSignHelp();
			if (singleHelp.isDisplayed()) {
				ATUReports.add("Single sign Help button is displayed clicked on Help icon", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				singleHelp.click();
				Thread.sleep(200);

				if (cropPage.getalertHelpTitle().getText().contains("Single Sine:")) {
					ATUReports.add(cropPage.getalertHelpTitle().getText() + " Text title is displayed", "Single Sine:",
							cropPage.getalertHelpTitle().getText(), LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					// Verify alert text
					String alertText1 = cropPage.getalertBody().getText();
					if (alertText1.contains(
							"Least accurate. Uses two points of data and a sine wave to estimate temperature variability for an entire day.")) {

						ATUReports.add("Single sign Help Text is displayed",
								"Least accurate. Uses two points of data and a sine wave to estimate temperature variability for an entire day.",
								alertText1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						MobileElement alertOk1 = cropPage.getalertHelpOk();
						alertOk1.click();
						Thread.sleep(2000);

					} else {

						ATUReports.add("Single sign Help Alert Text is  Not Present",
								"Least accurate. Uses two points of data and a sine wave to estimate temperature variability for an entire day."

								, alertText1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				} else {

					ATUReports.add(cropPage.getalertHelpTitle().getText() + " Text title is not displayed",
							cropPage.getalertHelpTitle().getText(), LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("Single sign Help button is not displayed clicked on Help icon", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// Verify integration alert

			MobileElement inegrationHelp = cropPage.getintegrationHelp();
			if (inegrationHelp.isDisplayed()) {
				ATUReports.add("Inegration Help button is displayed clicked on Help icon", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				inegrationHelp.click();
				Thread.sleep(200);

				if (cropPage.getalertHelpTitle().getText().contains("Integration:")) {
					ATUReports.add(cropPage.getalertHelpTitle().getText() + " Text is displayed", "Integration:",
							cropPage.getalertHelpTitle().getText(), LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify alert text
					String alertText2 = cropPage.getalertBody().getText();
					if (alertText2.contains(
							"Most Accurate. Integrates all time series temperature data provided by the sensor")) {

						ATUReports.add("Inegration Help Text is displayed",
								"Most Accurate. Integrates all time series temperature data provided by the sensor",
								alertText2, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						MobileElement alertOk1 = cropPage.getalertHelpOk();
						alertOk1.click();
						Thread.sleep(200);

					} else {

						ATUReports.add("Inegration Help Alert Text is  Not Present",
								"Most Accurate. Integrates all time series temperature data provided by the sensor"

								, alertText2, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				} else {

					ATUReports.add(cropPage.getalertHelpTitle().getText() + " Text is not displayed",
							cropPage.getalertHelpTitle().getText(), LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("Inegration Help button is not displayed clicked on Help icon", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			driver.findElement(By.id("com.davis.mobilize:id/secondTick")).click();
			Thread.sleep(2000);

			if (cropPage.getNext_nxt_save_btn().isEnabled()) {
				cropPage.getNext_nxt_save_btn().click();
				ATUReports.add("Skip  button is enabled and Clicked on Skip button in the crop target screen ",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Skip  button is not enabled in the crop target screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			/*****************************************************
			 * LOWER THRESHOLD SCREEN
			 ***********************************************************/
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

			// Verify the body text in the crop

			String lower_threshold_body = cropPage.getBodytxt().getText();
			System.out.println("lower_threshold_body:" + lower_threshold_body);
			if (lower_threshold_body.isEmpty()) {
				ATUReports.add("Verify the LOWER THRESHOLD caption text  in the screen ",

						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (lower_threshold_body.contains("GDD will be accumulated at and above the lower threshold.")) {
					ATUReports.add("LOWER THRESHOLD caption text is dispalyed in the screen ",
							"GDD will be accumulated at and above the lower threshold.", lower_threshold_body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("LOWER THRESHOLD caption text is not dispalyed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			cropPage.getthresholdtxtfld().click();
			// cropPage.getthresholdtxtfld().clear();
			Thread.sleep(2000);
			cropPage.getthresholdtxtfld().sendKeys(readCropDetails.lowerTempThreshold);
			driver.hideKeyboard();
			ATUReports.add("Entered Some value in the threshold field ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			Thread.sleep(2000);

			// Verify Drag the slider to change the temperatur
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

			if (cropPage.getNext_nxt_save_btn().isEnabled()) {
				cropPage.getNext_nxt_save_btn().click();
				ATUReports.add("Skip  button is enabled and Clicked on Skip button in the crop target screen ",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Skip  button is not enabled ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify Crop title text.
			String upperthreshold = cropPage.getTitletxt().getText();
			// System.out.println(title);
			if (upperthreshold.isEmpty()) {
				ATUReports.add("UPPER THRESHOLD element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (upperthreshold.contains("Upper Temperature Threshold")) {
					ATUReports.add("Upper Temperature Threshold is noticed in the screen ",
							"Upper Temperature Threshold", upperthreshold, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Upper Temperature Threshold is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the crop
			String upper_threshold_body = cropPage.getBodytxt().getText();
			if (upper_threshold_body.isEmpty()) {
				ATUReports.add("Verify the UPPER THRESHOLD caption text  in the screen ",

						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (upper_threshold_body.contains(
						"Growing degree days are accumulated above the upper threshold depending on the selected cutoff method.")) {
					ATUReports.add("UPPER THRESHOLD caption text is dispalyed in the screen ",
							"Growing degree days are accumulated above the upper threshold depending on the selected cutoff method.",
							upper_threshold_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("UPPER THRESHOLD caption text is not dispalyed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify optional
			Thread.sleep(4000);
			if (cropPage.getcropUpperOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement = cropPage.getcropUpperOptional();
				int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth() / 2;
				int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight() / 2;
				System.out.println("xInitial in upper optional" + xInitialOptional + "yInitial in upper optional"
						+ yInitialOptional);
				//driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional + 80, yInitialOptional, 5000);
				
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

			// entered value in text box
			cropPage.getupthreshold().click();
			cropPage.getupthreshold().sendKeys(readCropDetails.UpperTemp);
			driver.hideKeyboard();
			ATUReports.add("Entered Some value in the threshold field ", LogAs.PASSED,
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

			Thread.sleep(1000);
			if (cropPage.getNext_nxt_save_btn().isEnabled()) {
				cropPage.getNext_nxt_save_btn().click();
				ATUReports.add("Skip  button is enabled and Clicked on Skip button in the UPPER THRESHOLD screen ",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Skip  button is not enabled", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify CUT OFF METHOD page
			// Verify Crop title text.
			String cutoffmethod = cropPage.getTitletxt().getText();
			if (cutoffmethod.isEmpty()) {
				ATUReports.add("CUTOFF METHOD element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (cutoffmethod.contains("Cutoff Method")) {
					ATUReports.add("Cutoff Method is noticed in the screen ", "Cutoff Method", cutoffmethod,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Cutoff Method is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in the crop
			String cutoff_body = cropPage.getBodytxt().getText();
			if (cutoff_body.isEmpty()) {
				ATUReports.add("Verify the Cutoff Method caption text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (cutoff_body.contains(
						"Set the crop calculation format to resolve GDD accumulation if upper temperature threshold is met.")) {
					ATUReports.add("CUTOFF METHOD caption text is dispalyed in the screen ",
							"Set the crop calculation format to resolve GDD accumulation if upper temperature threshold is met.",
							cutoff_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("CUTOFF METHOD caption text is not dispalyed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// click on Vertical radio button
			Thread.sleep(200);

			// Verify vertical help
			MobileElement verticalHelp = cropPage.getverticalHelp();
			if (verticalHelp.isDisplayed()) {
				ATUReports.add("vertical sign Help button is displayed clicked on Help icon", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				verticalHelp.click();
				Thread.sleep(200);

				if (cropPage.getalertHelpTitle().getText().contains("Vertical")) {
					ATUReports.add(cropPage.getalertHelpTitle().getText() + " Text is displayed", "Vertical",
							cropPage.getalertHelpTitle().getText(), LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify alert text
					String alertText3 = cropPage.getalertBody().getText();

					if (alertText3.contains("Stops GDD accumulation above upper threshold.")) {
						ATUReports.add("vertical Help Text is displayed",
								"Stops GDD accumulation above upper threshold.", alertText3, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						MobileElement alertOk1 = cropPage.getalertHelpOk();
						alertOk1.click();
						Thread.sleep(200);

					} else {

						ATUReports.add("verticaln Help Alert Text is  Not Present",
								"Stops GDD accumulation above upper threshold."

								, alertText3, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				} else {

					ATUReports.add(cropPage.getalertHelpTitle().getText() + " Text is not displayed",
							cropPage.getalertHelpTitle().getText(), LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("vertical Help button is not displayed clicked on Help icon", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// Verify Horizontal help
			MobileElement Horizontalhelp = cropPage.gethozontalHelp();
			if (Horizontalhelp.isDisplayed()) {
				ATUReports.add("Horizontal sign Help button is displayed clicked on Help icon", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Horizontalhelp.click();
				Thread.sleep(200);

				if (cropPage.getalertHelpTitle().getText().contains("Horizontal")) {
					ATUReports.add(cropPage.getalertHelpTitle().getText() + " Text is displayed", " Horizontal",
							cropPage.getalertHelpTitle().getText(), LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					// Verify alert text
					String alertText4 = cropPage.getalertBody().getText();
					if (alertText4.contains("Continues accumulation above upper threshold")) {

						ATUReports.add("Horizontal Help Text is displayed",
								"Continues accumulation above upper threshold", alertText4, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						MobileElement alertOk1 = cropPage.getalertHelpOk();
						alertOk1.click();
						Thread.sleep(200);

					} else {

						ATUReports.add("Horizontal Help Alert Text is  Not Present",
								"Continues accumulation above upper threshold"

								, alertText4, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				} else {

					ATUReports.add(cropPage.getalertHelpTitle().getText() + " Text is not displayed",
							cropPage.getalertHelpTitle().getText(), LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("Horizontal Help button is not displayed clicked on Help icon", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			Thread.sleep(3000);

			// Verify intermediate
			MobileElement intermediatehelp = cropPage.getIntermediateHelp();
			if (intermediatehelp.isDisplayed()) {
				ATUReports.add("intermediate sign Help button is displayed clicked on Help icon", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				intermediatehelp.click();
				Thread.sleep(600);
				System.out.println(cropPage.getalertHelpTitle().getText()
						+ "---cropPage.getalertHelpTitle().getText()---Intermediate");
				if (cropPage.getalertHelpTitle().getText().contains("Intermediate")) {
					ATUReports.add(cropPage.getalertHelpTitle().getText() + " Text is displayed", "Intermediate",
							cropPage.getalertHelpTitle().getText(), LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					// Verify alert textVertical
					String alertText5 = cropPage.getalertBody().getText();
					if (alertText5.contains("GDD accumulation tapers off above upper threshold.")) {

						ATUReports.add("intermediate Help Text is displayed",
								"GDD accumulation tapers off above upper threshold.", alertText5, LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						MobileElement alertOk1 = cropPage.getalertHelpOk();
						alertOk1.click();
						Thread.sleep(200);
					} else {
						ATUReports.add("intermediate Help Alert Text is  Not Present",
								"GDD accumulation tapers off above upper threshold."

								, alertText5, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				} else {

					ATUReports.add(cropPage.getalertHelpTitle().getText() + " Text is not displayed",
							cropPage.getalertHelpTitle().getText(), LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("intermediate Help button is not displayed clicked on Help icon", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			Thread.sleep(2000);

			driver.findElement(By.id("com.davis.mobilize:id/thirdTick")).click();

			if (cropPage.getNext_nxt_save_btn().isEnabled()) {
				cropPage.getNext_nxt_save_btn().click();
				ATUReports.add("Skip  button is enabled and Clicked on Skip button in the CUT OFF screen ",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Skip  button is not enabled", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			/***************************************************************************************************************
			 * CHILL START DATE SCREEN *
			 ************************************************************************************************************/

			// Verify Crop title text.
			String chillstartdate = cropPage.getTitletxt().getText();
			// System.out.println(title);
			if (chillstartdate.isEmpty()) {
				ATUReports.add("Chill Start Date element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (chillstartdate.contains("Chill Start Date")) {
					ATUReports.add(" CHILL START DATE is noticed in the screen ", "Chill Start Date", chillstartdate,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				else {
					ATUReports.add("Chill Start Date is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// get the value of the optional and click on it
			Thread.sleep(4000);
			if (cropPage.getcropChillstartDateOptional().isDisplayed()) {
				ATUReports.add("Optional Slier is displayed and move the slider ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(4000);
				WebElement optionalElement = cropPage.getcropChillstartDateOptional();
				int xInitialOptionalStrDate = optionalElement.getLocation().getX()
						+ optionalElement.getSize().getWidth() / 2;
				int yInitialOptionalStrDate = optionalElement.getLocation().getY()
						+ optionalElement.getSize().getHeight() / 2;
				System.out.println("xInitialOptionalStrDate" + xInitialOptionalStrDate + "yInitial in upper optional"
						+ yInitialOptionalStrDate);
				driver.swipe(xInitialOptionalStrDate, yInitialOptionalStrDate, xInitialOptionalStrDate + 80,
						yInitialOptionalStrDate, 5000);
				Thread.sleep(2000);
			} else {
				ATUReports.add("optional Slier is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify the body text in the crop

			String chillstartdate_body = cropPage.getBodytxt().getText();
			if (chillstartdate_body.isEmpty()) {
				ATUReports.add("Verify the CHIILL START DATE caption text  in the screen ",

						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (chillstartdate_body.contains("Set the starting date to begin Chill accumulation.")) {
					ATUReports.add("CHIILL START DATE caption text is dispalyed in the screen ",
							"Set the starting date to begin Chill accumulation.", chillstartdate_body, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("CHIILL START DATE caption text is not dispalyed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// verify the optional text
			verify_Optionaltxt();

			// verify the date is enabled or not
			// and then Click on
			// the date tab
			cropPage.getdateTab().click();

			Thread.sleep(2000);
			// Click on done button
			cropPage.getNext_nxt_save_btn().click();

			if (cropPage.getNext_nxt_save_btn().isEnabled()) {
				cropPage.getNext_nxt_save_btn().click();
				ATUReports.add("Skip  button is enabled and Clicked on Skip button in the CHILL START DATE screen ",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Skip  button is not enabled ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			/***************************************************************************************************************
			 * CHILL CALCULATION SCREEN *
			 ************************************************************************************************************/

			// Verify Crop title text.
			// Chill Calculation
			// Method
			String chillcalculationtdate = cropPage.getTitletxt().getText();
			// System.out.println(title);
			if (chillcalculationtdate.isEmpty()) {
				ATUReports.add("CHILL CALCULATION TYPE element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (chillcalculationtdate.contains("Chill Calculation")) {
					ATUReports.add("Chill Calculation is noticed in the screen ", "Chill Calculation",
							chillcalculationtdate, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				else {
					ATUReports.add("Chill Calculation is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				if (chillcalculationtdate.contains("Method")) {
					ATUReports.add("Chill Calculation Method is noticed in the screen ", "Method",
							chillcalculationtdate, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Chill Calculation Method is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}
			Thread.sleep(2000);

			// Verify the body text in the
			// crop

			String chillcalculationtype_body = cropPage.getBodytxt().getText();
			if (chillcalculationtype_body.isEmpty()) {
				ATUReports.add("Verify the CHILL CALCULATION TYPE caption text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (chillcalculationtype_body
						.contains("Set the crop calculation format required for chill unit calculation.")) {
					ATUReports.add("Chill Calculation Method caption text is dispalyed in the screen ",
							"Set the crop calculation format required for chill unit calculation.",
							chillcalculationtype_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("CHILL CALCULATION TYPE caption text is not dispalyed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(2000);
			// Click on units.
			// cropPage.getSecondCheckBoxBtnText().click();

			// Verify dynamic help

			MobileElement dynamicHelp = cropPage.getdynamicHelp();
			if (dynamicHelp.isDisplayed()) {
				ATUReports.add("dynamic Help button is displayed clicked on Help icon", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				dynamicHelp.click();
				Thread.sleep(2000);

				// Verify alert text
				String alertText6 = cropPage.getalertBody().getText();
				if (alertText6.contains(
						"Hourly weather data is needed for the model. This model is based on the assumption that chill accumulates in a two-step process. In the first step, low temperatures lead to the formation of an intermediate product. This process is reversible, and the intermediate product can be destroyed by heat. Once a certain critical concentration of the intermediary is reached, in a second stage the intermediate product is transformed irreversibly into a product of a Chill Portion, and the concentration of the intermediate product fall to zero and the dynamic cure exhibits a periodic behavior. Chill Portions are accumulated, contributing to fulfillment of chilling requirements. It calculates chilling accumulation as ‘chill portions’ using a range of temperatures from ~35 - 55°F (~1.7 - 13°C) and accounts for chill cancellation due to fluctuating warm temperatures. The model works only during the stage between leaf drop in the fall and bud break in the spring.")) {

					ATUReports.add("dynamic Help Text is displayed",
							"Hourly weather data is needed for the model. This model is based on the assumption that chill accumulates in a two-step process. In the first step, low temperatures lead to the formation of an intermediate product. This process is reversible, and the intermediate product can be destroyed by heat. Once a certain critical concentration of the intermediary is reached, in a second stage the intermediate product is transformed irreversibly into a product of a Chill Portion, and the concentration of the intermediate product fall to zero and the dynamic cure exhibits a periodic behavior. Chill Portions are accumulated, contributing to fulfillment of chilling requirements. It calculates chilling accumulation as ‘chill portions’ using a range of temperatures from ~35 - 55°F (~1.7 - 13°C) and accounts for chill cancellation due to fluctuating warm temperatures. The model works only during the stage between leaf drop in the fall and bud break in the spring.",
							alertText6, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					MobileElement alertOk1 = cropPage.getalertHelpOk();
					alertOk1.click();
					Thread.sleep(2000);

				} else {

					ATUReports.add("dynamic Help Alert Text is  Not Present",
							"Hourly weather data is needed for the model. This model is based on the assumption that chill accumulates in a two-step process. In the first step, low temperatures lead to the formation of an intermediate product. This process is reversible, and the intermediate product can be destroyed by heat. Once a certain critical concentration of the intermediary is reached, in a second stage the intermediate product is transformed irreversibly into a product of a Chill Portion, and the concentration of the intermediate product fall to zero and the dynamic cure exhibits a periodic behavior. Chill Portions are accumulated, contributing to fulfillment of chilling requirements. It calculates chilling accumulation as ‘chill portions’ using a range of temperatures from ~35 - 55°F (~1.7 - 13°C) and accounts for chill cancellation due to fluctuating warm temperatures. The model works only during the stage between leaf drop in the fall and bud break in the spring."

							, alertText6, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("dynamic Help button is not displayed clicked on Help icon", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// verify chilling hours
			MobileElement chillingHelp = cropPage.getchillingHelp();
			if (chillingHelp.isDisplayed()) {
				ATUReports.add("chilling Help button is displayed clicked on Help icon", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				chillingHelp.click();
				Thread.sleep(2000);

				// Verify alert text
				String alertText6 = cropPage.getalertBody().getText();
				if (alertText6.contains(
						"The model considers all hours with temperatures between 32 and 45°F (0 and 7.22°C) as equally effective for winter chill accumulation. The start of chilling hours accumulation is the start date of the dormancy season, and the end is in the end of dormancy season. The model works only during the stage between leaf drop in the fall and bud break in the spring.")) {

					ATUReports.add("chilling Help Text is displayed",
							"The model considers all hours with temperatures between 32 and 45°F (0 and 7.22°C) as equally effective for winter chill accumulation. The start of chilling hours accumulation is the start date of the dormancy season, and the end is in the end of dormancy season. The model works only during the stage between leaf drop in the fall and bud break in the spring.",
							alertText6, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					MobileElement alertOk1 = cropPage.getalertHelpOk();
					alertOk1.click();
					Thread.sleep(2000);

				} else {

					ATUReports.add("chilling Help Alert Text is  Not Present",
							"The model considers all hours with temperatures between 32 and 45°F (0 and 7.22°C) as equally effective for winter chill accumulation. The start of chilling hours accumulation is the start date of the dormancy season, and the end is in the end of dormancy season. The model works only during the stage between leaf drop in the fall and bud break in the spring."

							, alertText6, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("chilling Help button is not displayed clicked on Help icon", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			Thread.sleep(2000);

			// Verify utah help
			MobileElement utaHelp = cropPage.getutahChillingHelp();
			if (utaHelp.isDisplayed()) {
				ATUReports.add("utah chilling Help button is displayed clicked on Help icon", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				utaHelp.click();
				Thread.sleep(2000);

				// Verify alert text
				String alertText8 = cropPage.getalertBody().getText();
				if (alertText8.contains(
						"The model contains a weight function assigning different chilling efficiencies to different temperature ranges. The model requires hourly temperature for calculation. Each hour of the day is given positive, negative, or no chilling units based on the temperature in that hour.")) {

					ATUReports.add("utah chilling Help Text is displayed",
							"The model contains a weight function assigning different chilling efficiencies to different temperature ranges. The model requires hourly temperature for calculation. Each hour of the day is given positive, negative, or no chilling units based on the temperature in that hour.",
							alertText8, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					MobileElement alertOk1 = cropPage.getalertHelpOk();
					alertOk1.click();
					Thread.sleep(2000);

				} else {

					ATUReports.add("utah chilling Help Alert Text is  Not Present",
							"The model contains a weight function assigning different chilling efficiencies to different temperature ranges. The model requires hourly temperature for calculation. Each hour of the day is given positive, negative, or no chilling units based on the temperature in that hour."

							, alertText8, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			} else {
				ATUReports.add("utah chilling Help button is not displayed clicked on Help icon", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			driver.findElement(By.id("com.davis.mobilize:id/thirdTick")).click();
			Thread.sleep(2000);

			if (cropPage.getNext_nxt_save_btn().isEnabled()) {
				cropPage.getNext_nxt_save_btn().click();
				ATUReports.add(
						"Skip  button is enabled and Clicked on Skip button in the CHILL CALCULATION TYPE screen ",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Skip  button is not enabled", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			/***************************************************************************************************************
			 * CHILLING TARGET SCREEN *
			 ************************************************************************************************************/

			// Verify Drag the slider to change the temperature
			// move the slider
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

			// Verify Crop title text.
			String chillingthreshold = cropPage.getTitletxt().getText();
			// System.out.println(title);
			if (chillingthreshold.isEmpty()) {
				ATUReports.add("CHILLING TARGET element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (chillingthreshold.contains("Chilling Target")) {
					ATUReports.add("Chilling Target is noticed in the screen ", "Chilling Target", chillingthreshold,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				else {
					ATUReports.add("CHILLING TARGET is not observed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text in
			// the crop

			String CHILLINGTHRESHOLD_body = cropPage.getBodytxt().getText();
			if (CHILLINGTHRESHOLD_body.isEmpty()) {
				ATUReports.add("Verify the CHILLING TARGET caption text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (CHILLINGTHRESHOLD_body
						.equals("Set the total number of Chill Units required to reach the desired stage.")) {
					ATUReports.add("CHILLING TARGET caption text is dispalyed in the screen ",
							"Set the total number of Chill Units required to reach the desired stage.",
							CHILLINGTHRESHOLD_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("CHILLING TARGET caption text is not dispalyed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			Thread.sleep(6000);

			if (cropPage.getNext_nxt_save_btn().isEnabled()) {
				cropPage.getNext_nxt_save_btn().click();
				ATUReports.add("Skip  button is enabled and Clicked on Skip button in the CHILLING THRESHOLD screen ",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Skip  button is not enabled", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			/***************************************************************************************************************
			 * COMPLETE CROP SETUP SCREEN *
			 ************************************************************************************************************/

			// Verify title

			String complete_crop_setup = cropPage.getTitletxt().getText();
			if (complete_crop_setup.isEmpty()) {
				ATUReports.add("Verify the Complete Crop Setup text  in the screen ", "Complete Crop Setup",
						complete_crop_setup, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (complete_crop_setup.contains("Complete Crop Setup")) {
					ATUReports.add(
							"Complete Crop Setup is noticed in the screen, sucessfully skipped rest of the screen in between the screens",
							"Complete Crop Setup", complete_crop_setup, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Complete Crop Setup is not observed in the screen ", complete_crop_setup,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(2000);

			// Verify body text

			String cropSetup = cropPage.getBodytxt().getText();
			if (cropSetup.isEmpty()) {
				ATUReports.add("Verify the Complete Crop Setup caption text  in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (cropSetup
						.contains("Save the setup to view the crop report. Go back to edit any crop setup setting.")) {
					ATUReports.add("Complete Crop Setup caption text is dispalyed in the screen ",
							"Save the setup to view the crop report. Go back to edit any crop setup setting.",
							cropSetup, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Complete Crop Setup caption text is not dispalyed in the screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Clicked on save
			// button
			cropPage.getNext_nxt_save_btn().click();
			ATUReports.add("Save button is enabled in the complete Crop setup and clicked on the Save button",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(4000);

			// verify the Add button
			if (homepage.getAddbtn().isDisplayed() || homepage.getAddbtn().isEnabled()) {
				ATUReports.add("Successfully created the crop setup ,User able Edit crop page settings from beginning",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Unable to create crop by skipping the optional data", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			Thread.sleep(2000);

			// Click on Manage Account
			homepage.getAccountbtn().click();
			ATUReports.add("Clicked on account Tab", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);

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

	

	private void verify_Optionaltxt() {
		// Verify the Optional button text
		String Optional;
		try {
			Optional = cropPage.getOptionaltxt().getText();

			if (Optional.isEmpty()) {
				ATUReports.add("optional element is not visible", null, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (Optional.equals("optional")) {
					ATUReports.add("optional text is noticed in the screen ", "optional", Optional, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("optional text is not observed in the screen ", Optional, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
