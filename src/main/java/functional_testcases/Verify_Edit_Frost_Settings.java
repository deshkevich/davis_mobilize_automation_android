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
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.Log;
import utility.ReadUserData;
import utility.Read_Frost_Data;

public class Verify_Edit_Frost_Settings {
	private AndroidDriver driver;
	private NewViewScreenPage newviewscreen;
	private LoginPage loginpage;
	private NewViewScreenPage newscreenpage;
	private ReadUserData readUserData;
	private HomePage homepage;
	private FrostPage frostPage;
	private Read_Frost_Data readFrostData;
	private WeatherPage weatherPage;
	private Account_Page accountPage;
	private FrostPage frostpage ;
	@Test
	public void editFrostSettings() throws InterruptedException {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		frostpage = new FrostPage(driver);
		newviewscreen = new NewViewScreenPage(driver);
		new Alert_Page(driver);
		loginpage = new LoginPage(driver);
		newscreenpage = new NewViewScreenPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		new IrrigationPage(driver);
		homepage = new HomePage(driver);
		frostPage = new FrostPage(driver);
		readFrostData = new Read_Frost_Data();
		weatherPage = new WeatherPage(driver);
		accountPage=new Account_Page(driver);
		Thread.sleep(2000);
		
		
		Log.startTestCase("editFrostSettings test Case start");
		System.out.println("*********** editFrostSettings test Case start ********");
		try {

			

    		// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();
			Thread.sleep(2000);
			
			
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
					Thread.sleep(2000);
					ATUReports.add(
							"verified the share icon in the : " + j
									+ " view displayed in the Home screen,Share icon is enabled in the screen ",
							LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));					
					if (newviewscreen.getfrostSettingsTitle() != null
							&& newviewscreen.getfrostSettingsTitle().isDisplayed()) {
						if (newviewscreen.getfrostSettingsTitle() != null
								&& newviewscreen.getfrostSettingsIcon().isEnabled()) {
							ATUReports.add(
									newviewscreen.getfrostSettingsTitle().getText()
											+ " Settings Title is is dispalyed",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							break;
						} else {
							ATUReports.add(
									newviewscreen.getfrostSettingsTitle().getText()
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
					Thread.sleep(3000);
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

			MobileElement settings = newscreenpage.getfrostSettingsIcon();
			if (settings.isEnabled()) {
				ATUReports.add("Frost Settings Icon is enabled Clicked on Settings Icon ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				settings.click();
			} else {
				ATUReports.add("Frost Settings Icon  is Disabled", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// // verify the Edit settings button. and Click on edit settings.
			MobileElement editsettings = newscreenpage.getfrostEditSettingsButton();
			if (editsettings != null) {
				if (editsettings.isDisplayed()) {
					ATUReports.add("Frost EditSettings Button is dispalyed and Clicked on edit settings.", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					editsettings.click();
					Thread.sleep(4000);
				} else {
					ATUReports.add("Frost EditSettings Button is not dispalyed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Verify user navigated to edit frost page.
			//MobileElement cancelButton = homepage.getcancelButton();
			String editFrostTitle = homepage.gettitleText().getText();
			if (editFrostTitle != null) {
				if (editFrostTitle.contains("Edit Frost")) {
					ATUReports.add("User is navigated to 'Edit Frost' page. able to edit the frost settings",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("User is not navigated to 'Edit Frost' page.", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

					
			// Verify user should able to edit the frost settings from beginning
			// Verify Observe application navigated to Sensor Input screen and
			// Next is disabled.

			String frost_sensor_title = frostPage.getTitletxt().getText();
			if (frost_sensor_title.isEmpty()) {
				ATUReports.add("Verify the SENSOR INPUT text  in the screen ", "Frost Sensor Input", frost_sensor_title,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (frost_sensor_title.equals("Frost Sensor Input")) {
					ATUReports.add("SENSOR INPUT is noticed in the screen ", "Frost Sensor Input", frost_sensor_title,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("SENSOR INPUT is not observed in the screen ", frost_sensor_title, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text
			String body = frostPage.getBodytxt().getText();
			//System.out.println(body + "---body--");
			if (body.isEmpty()) {
				ATUReports.add("Verify the Sensor Input caption text  in the screen ",
						"Select the appropriate device or weather station and sensor inputs for monitoring weather data.",
						body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (body.equals("Select the appropriate device and sensor inputs for monitoring frost data.")) {
					ATUReports.add("Sensor Input caption text is dispalyed in the screen ",
							"Select the appropriate device and sensor inputs for monitoring frost data.", body,
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Sensor Input caption text is not dispalyed in the screen ", body, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify Now select Device and Sensors from dropdown list.
			// Select any option from device drop down -

			//frostPage.getDevicestxt().click();
			Thread.sleep(2000);
			frostPage.getDevicedropdown().click();
			ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Select any option from sensor drop down
			//frostPage.getSensortxt().click();
			Thread.sleep(2000);
			frostPage.getSensordropdown().click();
			ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			// Verify Observe Next button is Enabled.
			if (frostPage.getNext_nxt_save_btn().isEnabled()) {
				frostPage.getNext_nxt_save_btn().click();
				ATUReports.add("Next button is enabled in the frost Sensor Input and clicked on the Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next button is not enabled in the frost Sensor Input", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// Verify Threshold page heading text
			String frost_thresholdTitle = frostPage.getTitletxt().getText();
			if (frost_thresholdTitle.isEmpty()) {
				ATUReports.add("Verify the Frost threshold text  in the screen ", "Frost Threshold", frost_sensor_title,
						LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (frost_thresholdTitle.equals("Frost Threshold")) {
					ATUReports.add("Frost threshold is displayed in the screen ", "Frost Threshold",
							frost_thresholdTitle, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Frost threshold is not  displayed in the screen ", readFrostData.titleTextThree,
							frost_thresholdTitle, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text
			String FrostThreshold_body = frostPage.getBodytxt().getText();
			// System.out.println(body);
			if (FrostThreshold_body.isEmpty()) {
				ATUReports.add("Verify the Frost threshold caption text  in the screen ",
						"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.",
						FrostThreshold_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (FrostThreshold_body.contains(
						"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.")) {
					ATUReports.add("Frost threshold caption text is dispalyed in the screen ",
							"Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.",
							FrostThreshold_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Frost threshold caption text is not dispalyed in the screen ", FrostThreshold_body,
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

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
			
			
			// Verify frost warning page heading text
						String frost_Warning = frostPage.getTitletxt().getText();
						System.out.println(frost_Warning + "frost warning page body-----");
						if (frost_Warning.isEmpty()) {
							ATUReports.add("Verify the Frost warning text  in the screen ", "Early Frost Warning",
									frost_sensor_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} else {
							if (frost_Warning.equals("Early Frost Warning")) {
								ATUReports.add("Frost warning is displayed in the screen ", "Early Frost Warning",
										frost_Warning, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("Frost warning is not  displayed in the screen ", "Early Frost Warning",
										frost_Warning, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
						Thread.sleep(4000);

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
										Early_Frost_Warning_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							} else {
								ATUReports.add("EARLY FROST WARNING caption text is not dispalyed in the screen ",
										Early_Frost_Warning_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
			
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
			
			
			
			// Click on next button
			frostPage.getNext_nxt_save_btn().click();
			Thread.sleep(4000);

			// Verify the COMPLETE FROST SETUP
			String COMPLETE_FROST_SETUP_title = frostPage.getTitletxt().getText();
			if (COMPLETE_FROST_SETUP_title.isEmpty()) {
				ATUReports.add("Verify the COMPLETE FROST SETUP text  in the screen ", "Complete Frost Setup",
						COMPLETE_FROST_SETUP_title, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (COMPLETE_FROST_SETUP_title.equals("Complete Frost Setup")) {
					ATUReports.add("COMPLETE FROST SETUP is displayed in the screen ","Complete Frost Setup",
							COMPLETE_FROST_SETUP_title, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("COMPLETE FROST SETUP is not noticed in the screen", readFrostData.titleTextFive,
							COMPLETE_FROST_SETUP_title, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			// Verify the body text
			String complete_Frost_setup_body = frostPage.getBodytxt().getText();
			System.out.println(complete_Frost_setup_body + "--compete body--");
			if (complete_Frost_setup_body.isEmpty()) {
				ATUReports.add("Verify the COMPLETE FROST SETUP caption text  in the screen ",
						"Save the setup to view the frost report. Go back to edit any frost setup setting.",
						complete_Frost_setup_body, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (complete_Frost_setup_body
						.equals("Save the setup to view the frost report. Go back to edit any frost setup setting.")) {
					ATUReports.add("COMPLETE FROST SETUP caption text is dispalyed in the screen ",
							"Save the setup to view the frost report. Go back to edit any frost setup setting.",
							complete_Frost_setup_body, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("COMPLETE FROST SETUP caption text is not dispalyed in the screen ",
							complete_Frost_setup_body, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			Thread.sleep(4000);

			// Verify save button is displayed or not.		
			MobileElement saveButton = frostpage.getNext_nxt_save_btn();
			String saveText = saveButton.getText();
			if (weatherPage.getNext_nxt_save_btnn()!= null && saveButton.isDisplayed()) {
				if (saveText.equals("Save")) {

					ATUReports.add("Clicked on  " + saveText + " button in frost set up page, User able to edit the frost settings from beginning",
							"Save", saveText, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					saveButton.click();
					Thread.sleep(2000);

				} else {
					ATUReports.add("Mobilize " + saveText + " button is not displayed. ", readFrostData.ButtonTextThree,
							saveText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				driver.close();
				return;
			}
			
			
			
			Thread.sleep(5000);
			//Click on Manage Account    				
			homepage.getAccountbtn().click();
			ATUReports.add("Clicked on Account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
				
			// Verifying tutorial icon
			Thread.sleep(2000);
			Precondition.tutorialDisalogBox();
			
			 //Click on Settings button
			accountPage.getsettings().click();
			Thread.sleep(3000);
			System.out.println("Clicked on settings");
			ATUReports.add("Click SettingS button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
			
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
























//For future purpose

//Verify Drag the slider to change the temperature


			/*//move the slider
			Thread.sleep(4000);
			WebElement lastElement =weatherPage.getfrostThresholdSlider();
			Thread.sleep(1000);
			int xInitial = lastElement.getLocation().getX() + lastElement.getSize().getWidth()/2;
			int yInitial = lastElement.getLocation().getY() + lastElement.getSize().getHeight()/2;
			System.out.println("xInitial in  frost threshold temp"+xInitial+ "yInitial in frost threshold temp"+yInitial);
			driver.swipe(xInitial, yInitial, xInitial+350, yInitial, 5000);					
			ATUReports.add("Slider is displayed and moved the slider from left to right",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
			
			/*//move the slider
			Thread.sleep(4000);
			WebElement lastElementEarlyFrostSlider=weatherPage.getearlyFrostThresholdSlider();
			Thread.sleep(1000);
			int xInitialEarlyFrost= lastElementEarlyFrostSlider.getLocation().getX() + lastElementEarlyFrostSlider.getSize().getWidth()/2;
			int yInitialEarlyFrost = lastElementEarlyFrostSlider.getLocation().getY() + lastElementEarlyFrostSlider.getSize().getHeight()/2;
			System.out.println("xInitial in  frost threshold temp"+xInitialEarlyFrost+ "yInitialEarlyFrost in frost threshold temp"+yInitialEarlyFrost);
			driver.swipe(xInitialEarlyFrost, yInitialEarlyFrost, xInitialEarlyFrost+300, yInitialEarlyFrost, 5000);					
			ATUReports.add("Slider is displayed and moved the slider from left to right",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
