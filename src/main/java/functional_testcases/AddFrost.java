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
import utility.Read_Frost_Data;
import utility.Read_Frost_Details;

import java.util.List;


public class AddFrost {

	private AndroidDriver driver ;
	private FrostPage frostpage ;
	private HomePage homepage ;
	private NewViewScreenPage newviewscreenpage;
	private Read_Frost_Details read_frost_details;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private Account_Page accountPage;
	private WeatherPage weatherPage;
	private Read_Frost_Data readFrostData;
	//This method includes the back button and Next button functionality
	@Test
	public void create_frost(){		
		try{
			 
			driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
			frostpage = new FrostPage(driver);
			homepage = new HomePage(driver);
			newviewscreenpage = new NewViewScreenPage(driver);
			read_frost_details = new Read_Frost_Details();
			read_frost_details.start();
			loginpage = new LoginPage(driver);
			readUserData=new ReadUserData();
			readUserData.start();
			accountPage=new Account_Page(driver);
			Thread.sleep(2000);
			weatherPage = new WeatherPage(driver);
			readFrostData = new Read_Frost_Data();
			readFrostData.start();
			
			 // Calling precondition
			 Precondition addClass = new Precondition();
			 addClass.precondition();
			     
		
			 								
			//Click on the Add view button
			homepage.getAddbtn().click();
			Thread.sleep(2000);
			ATUReports.add("Clicked on Add button in the Home screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			//Enter The verified text in the view name text field
			newviewscreenpage.getView_txtfld().sendKeys(read_frost_details.uniquefrostname);
			ATUReports.add("Enter view name in text box",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			//Click on Add button
			newviewscreenpage.getAddbtn().click();
			ATUReports.add("Click on add button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(4000);
			
			   //Verifying tutorial icon
			  Precondition.tutorialDisalogBox();
			
			        // Verify tap on crop title-we are using generic code for titles bcs titles paths are changing from one to another.
						Thread.sleep(1000);
						List <WebElement> weatherTitle=driver.findElements(By.id("com.davis.mobilize:id/report_text"));		
						//System.out.println(weatherTitle.size()+"----size----");	
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

						
			//Verify the Edit Frost text
			String editfrost = frostpage.getEditfrost().getText();
			//System.out.println(editfrost);
			if(editfrost.isEmpty()){
				ATUReports.add("Verify the Edit Frost in the screen ", "Edit Frost", editfrost,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				if (editfrost.equals("Edit Frost")) {
					ATUReports.add("Edit Frost is noticed in the screen ", "Edit Frost", editfrost,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Verify the title text
					String title = frostpage.getTitletxt().getText();
					//System.out.println(title);
					if(title.isEmpty()){
						ATUReports.add("Verify the Sensor Input text  in the screen ", "Frost Sensor Input", title,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (title.equals("Frost Sensor Input")) {
							ATUReports.add("Frost Sensor Input text is noticed in the screen ", "Frost Sensor Input", title,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Sensor Input text is not observed in the screen ", title,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

				}
			}
					//Verify the body text
					String body = frostpage.getBodytxt().getText();
					//System.out.println(body);
					if(body.isEmpty()){
						ATUReports.add("Verify the Sensor Input caption text  in the screen ", "Select the appropriate device and sensor inputs for monitoring frost data.", body,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						if (body.equals("Select the appropriate device and sensor inputs for monitoring frost data.")) {
							ATUReports.add("Sensor Input caption text is dispalyed in the screen ", "Select the appropriate device and sensor inputs for monitoring frost data.", body,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Sensor Input caption text is not dispalyed in the screen ", body,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					//Select any option from device drop down - 
					//frostpage.getDevicestxt().click();
					frostpage.getDevicedropdown().click();
					ATUReports.add("Clicked on the device drop down and selected the xcube Gatewaay 1E",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Select any option from sensor drop down
					//frostpage.getSensortxt().click();
					frostpage.getSensordropdown().click();
					ATUReports.add("Clicked on the Sensor drop down and selected the Davis Groweather , FARS",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	
					//Click on next button in the Sensor Input
					if (frostpage.getNext_nxt_save_btn().isEnabled()) {
						frostpage.getNext_nxt_save_btn().click();
						ATUReports.add("Next button is enabled in the Sensor Input and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled Sensor Input",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
			       // Thread.sleep(2000);
					//Verify the title text in the Frost Threshold
					String FrostThreshold_title = frostpage.getTitletxt().getText();
					//System.out.println(title);
					if(FrostThreshold_title.isEmpty()){
						ATUReports.add("Verify the FROST THRESHOLD text  in the screen ", "Frost Threshold", FrostThreshold_title,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						if (FrostThreshold_title.equals("Frost Threshold")) {
							ATUReports.add("Frost Threshold text is noticed in the screen ", "Frost Threshold", FrostThreshold_title,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Frost Threshold text is not observed in the screen ", FrostThreshold_title,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					//Verify the body text
					String FrostThreshold_body = frostpage.getBodytxt().getText();
					//System.out.println(body);
					if(FrostThreshold_body.isEmpty()){
						ATUReports.add("Verify the Frost threshold caption text  in the screen ", "Use the slider or type in temperature values to alert you of frost forecasts.", FrostThreshold_body,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (FrostThreshold_body.equals("Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.")) {
							ATUReports.add("Frost threshold caption text is dispalyed in the screen ", " Alerts triggered if frost threshold is met, either by current temperature or due to a forecast.", FrostThreshold_body,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Frost threshold caption text is not dispalyed in the screen ", FrostThreshold_body,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					
									
					//Enter some value in the Temperature
					frostpage.getfrostTempTextbox().sendKeys(Keys.DELETE);
					frostpage.getfrostTempTextbox().sendKeys(Keys.INSERT);
					Thread.sleep(2000);
					frostpage.getfrostTempTextbox().sendKeys(read_frost_details.frost_threshold_temp);
					Thread.sleep(4000);
					ATUReports.add("Temperature value given in the text box",read_frost_details.frost_threshold_temp,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
					//move the slider
					thresholdSlider();
					//Thread.sleep(4000);
					
					//Verifying plus button 
					plusIconButton();
					ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased"+frostpage.getfrostTempTextbox().getText(),LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					Thread.sleep(2000);
					
					//Verifying minus icon
					minusIconButton();
					ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased"+frostpage.getfrostTempTextbox().getText(),LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
					
					//Click on the next button in the Frost Threshold screen.
					if (frostpage.getNext_nxt_save_btn().isEnabled()) {
						frostpage.getNext_nxt_save_btn().click();
						//frostpage.getNext_nxt_save_btn().click();
						ATUReports.add("Next button is enabled in the Frost Threshold and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled Frost Threshold",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					
					
					//Verifying tutorial icon
					Precondition.tutorialDisalogBox();			
					
					//get the value of the optional and click on it
					Thread.sleep(4000);
					if(frostpage.getoptionalSliderl().isDisplayed()){			
						ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));				
						Thread.sleep(4000);
								WebElement optionalElement =frostpage.getoptionalSliderSwipe();
						int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
						int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
						System.out.println("xInitialOptional--- "+xInitialOptional+ "yInitialOptional--"+yInitialOptional);
						
					     //Swiping list based on coordinates
						if(xInitialOptional<1200){   //80//for all devices//nexus-//Moto E2-456//note 3-  //Galaxy S5-914
							driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+80, yInitialOptional, 5000);
							System.out.println("in 1st loop optional");
						}else{				
								if(xInitialOptional>1200){///only for s6- 1218//
								driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional+120, yInitialOptional, 5000);
									System.out.println("in 2nd loop optional");
								}
							
						}  
						
						
					
					Thread.sleep(2000);
					}else{
						ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
					// Verify the Early Frost Warning screen
					String Early_Frost_Warning_title = frostpage.getTitletxt().getText();
					if(Early_Frost_Warning_title.isEmpty()){
						ATUReports.add("Verify the Early Frost Warning text  in the screen ", "Early Frost Warning", Early_Frost_Warning_title,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (Early_Frost_Warning_title.equals("Early Frost Warning")) {
							ATUReports.add("Early Frost Warning is displayed", "Early Frost Warning", Early_Frost_Warning_title,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Early Frost Warning", Early_Frost_Warning_title,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					//Verify the body text
					String Early_Frost_Warning_body = frostpage.getBodytxt().getText();
					if(Early_Frost_Warning_body.isEmpty()){
						ATUReports.add("Verify the Early Frost Warning caption text  in the screen ", "An early warning for frost will give you advanced notice if you are nearing your Frost forecast.", Early_Frost_Warning_body,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (Early_Frost_Warning_body.equals("Early warning threshold is set to alert for cases where frost may soon follow.")) {
							ATUReports.add("Early Frost Warning caption text is dispalyed in the screen ", "Early warning threshold is set to alert for cases where frost may soon follow.", Early_Frost_Warning_body,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Early Frost Warning caption text is not dispalyed in the screen ", Early_Frost_Warning_body,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					Thread.sleep(4000);
					
					
					
					//move the slider
					thresholdSlider();
					Thread.sleep(4000);
					
					//Verifying plus icon
					plusIconButton();
					ATUReports.add("Plus icon is displayed and clicked on Plus icon then Temperature value increased"+frostpage.getearlyFrostTemptxtbx().getText(),LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					Thread.sleep(2000);
					
					//Verifying minus icon
					minusIconButton();
					ATUReports.add("Minus icon is displayed and clicked on Minus icon then Temperature value decreased"+frostpage.getearlyFrostTemptxtbx().getText(),LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
					

					//Enter some value in the Temperature
					frostpage.getearlyFrostTemptxtbx().sendKeys(Keys.DELETE);
					frostpage.getearlyFrostTemptxtbx().sendKeys(Keys.INSERT);
					frostpage.getearlyFrostTemptxtbx().sendKeys(read_frost_details.early_frost_warning);
					ATUReports.add("Temperature value given in the text box",read_frost_details.early_frost_warning,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button in the Frost Threshold screen.
					if (frostpage.getNext_nxt_save_btn().isEnabled()) {
						frostpage.getNext_nxt_save_btn().click();
						//frostpage.getNext_nxt_save_btn().click();

						ATUReports.add("Next button is enabled in the EARLY FROST WARNING and clicked on the Next button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Next button is not enabled EARLY FROST WARNING",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}


					//Verify the COMPLETE FROST SETUP 
					if (driver.getPageSource().contains("Complete Frost Setup")) {
						ATUReports.add("Complete Frost Setup is dispalyed in the screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Navigated to a wrong screen",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					String COMPLETE_FROST_SETUP_title = frostpage. getTitletxt().getText();
					if(COMPLETE_FROST_SETUP_title.isEmpty()){
						ATUReports.add("Verify the Complete Frost Setup text  in the screen ", "COMPLETE FROST SETUP", COMPLETE_FROST_SETUP_title,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						if (COMPLETE_FROST_SETUP_title.equals("Complete Frost Setup")) {
							ATUReports.add("COMPLETE FROST SETUP is displayed in the screen ", "Complete Frost Setup", COMPLETE_FROST_SETUP_title,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Complete Frost Setup is not noticed in the screen", COMPLETE_FROST_SETUP_title,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}

					//Verify the body text
					String complete_Frost_setup_body = frostpage.getBodytxt().getText();
					//System.out.println(body);
					if(complete_Frost_setup_body.isEmpty()){
						ATUReports.add("Verify the COMPLETE FROST SETUP caption text  in the screen ", "Save the setup to view the frost report. Go back to edit any frost setup setting.", complete_Frost_setup_body,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (complete_Frost_setup_body.equals("Save the setup to view the frost report. Go back to edit any frost setup setting.")) {
							ATUReports.add("COMPLETE FROST SETUP caption text is dispalyed in the screen ", "Save the setup to view the frost report. Go back to edit any frost setup setting.", complete_Frost_setup_body,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("COMPLETE FROST SETUP caption text is not dispalyed in the screen ", complete_Frost_setup_body,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}


					//Click on back button and verify the screen name
					frostpage.getCancelbtn().click();
					Thread.sleep(3000);
					if (driver.getPageSource().contains("Early Frost Warning")) {
						ATUReports.add("Early Frost Warning is dispalyed in the screen upon navigated back to the screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Navigated to a wrong screen",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}


					//Click on back button and verify the screen name
					frostpage.getCancelbtn().click();
					Thread.sleep(3000);
					if (driver.getPageSource().contains("Frost Threshold")) {
						ATUReports.add("FROST THRESHOLD is dispalyed in the screen upon navigated back to the screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Navigated to a wrong screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				

					//Click on back button and verify the screen name
					frostpage.getCancelbtn().click();
					Thread.sleep(3000);
					if (driver.getPageSource().contains("Frost Sensor Input")) {
						ATUReports.add("SENSOR INPUT is dispalyed in the screen upon navigated back to the screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} else {
						ATUReports.add("Navigated to a wrong screen",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				

					//Click on next button in the Sensor input screen
					frostpage.getNext_nxt_save_btn().click();
					Thread.sleep(2000);
					
					//Click on next button in the FROST THRESHOLD SCREEN
					frostpage.getNext_nxt_save_btn().click();
					Thread.sleep(2000);
					
					//Click on skip button in the EARLY FROST WARNING
					frostpage.getNext_nxt_save_btn().click();
					Thread.sleep(2000);
					
					//Click on save button in the Complete Frost Setup
					frostpage.getNext_nxt_save_btn().click();
					ATUReports.add("Clciked on save button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(4000);
					
					//click on tutorial icon in report page
					if(homepage.getdialogBox()!=null){
						if(homepage.getdialogBox().isDisplayed()){
							String tutorialText=homepage.gettutorialMessage().getText();
							String tutorialButton=homepage.gettutorialNext1().getText();
							ATUReports.add("Mobilize tutorial dialog box "+tutorialText+ "is displayed with  in home page "+tutorialButton+" button", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							Thread.sleep(2000);
							homepage.gettutorialCoseIcon().click();
							Thread.sleep(2000);
						}else{
							ATUReports.add("Mobilize tutorial dialog box is not displayed", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						}
				 }else{
					 ATUReports.add("Mobilize tutorial dialog box is not displayed with notification flag alert in home page", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				 }
					
					Thread.sleep(5000);
					
					//Verify arrow buttons in report page
					/*
					if(frostpage.getfrostDownArrowButton()!=null){
						ATUReports.add("Arrow button is displayed",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						if(frostpage.getfrostDownArrowButton().isDisplayed()){
							ATUReports.add("Clicked on Down arrow button in view report",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
							frostpage.getfrostDownArrowButton().click();
							Thread.sleep(4000);
							if(frostpage.getviewDetaisInfromationInReport().isDisplayed()){
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
					*/
					
					//Click on Manage Account    				
					homepage.getAccountbtn().click();
					ATUReports.add("Clicked on account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
					
					
					//Verifying tutorial icon
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
				


		}catch(InterruptedException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}

	public void clickonNextButton() throws InterruptedException
	{
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		}else{
			driver.quit();
		}
	}
	
	
	
	public void thresholdSlider() throws InterruptedException{
		
		//move the slider
		Thread.sleep(4000);
		WebElement lastElement =frostpage.getTempSlier();
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
			WebElement lastElement =frostpage.getplusIcon();
			
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
		WebElement lastElement =frostpage.getminusIcon();
		if(lastElement.isDisplayed()){
			lastElement.click();
			ATUReports.add("Minus icon is displayed",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		
		ATUReports.add("Minus icon is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		driver.close();
	}
		
		
}
}











































//This code for scroll down the curent list element.
/*Thread.sleep(4000);
if(driver.findElement(By.id("com.honeywell.pmt.hps.MasterLink:id/list_menu_expandable")).isDisplayed()){	
ATUReports.add("Optional Slier is displayed and move the slider ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
Thread.sleep(4000);
WebElement optionalElement =driver.findElement(By.id("com.honeywell.pmt.hps.MasterLink:id/list_menu_expandable"));
int xInitialOptional = optionalElement.getLocation().getX() + optionalElement.getSize().getWidth()/2;
int yInitialOptional = optionalElement.getLocation().getY() + optionalElement.getSize().getHeight()/2;
System.out.println("xInitialOptional "+xInitialOptional+ "yInitialOptional"+yInitialOptional);
driver.swipe(xInitialOptional, yInitialOptional, xInitialOptional, yInitialOptional+800, 9000);
ATUReports.add("optional Slier is  displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

Thread.sleep(2000);
}else{
ATUReports.add("optional Slier is not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
*/





//For future reference 


//Verify the persistence of the device value in the screen
//System.out.println(frostpage.getDevicestxt().getAttribute("value"));
//System.out.println("read_frost_details.device"+read_frost_details.device);
/*if (frostpage.getDevicestxt().getText().equalsIgnoreCase(read_frost_details.device)) {
	ATUReports.add("Device is dispalyed in the screen upon navigated back to the screen",frostpage.getDevicestxt().getText(), read_frost_details.device,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

} else {
	ATUReports.add("Device  is not dispalyed in the screen upon navigated back to the screen",frostpage.getDevicestxt().getText(), read_frost_details.device,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

}

System.out.println(frostpage.getSensortxt().getText());
System.out.println("read_frost_details.device"+read_frost_details.sensor);
//Verify the persistnace of the Sensor value in the screen
if (frostpage.getSensortxt().getText().equalsIgnoreCase(read_frost_details.sensor)) {
	ATUReports.add("SENSOR is dispalyed in the screen upon navigated back to the screen",frostpage.getSensortxt().getText(), read_frost_details.sensor,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

} else {
	ATUReports.add("SENSOR is not dispalyed in the screen upon navigated back to the screen", frostpage.getSensortxt().getText(),read_frost_details.sensor,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

}*/
