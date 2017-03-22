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
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.ReadUserData;
import utility.Read_Irrigation_Details;

import java.util.List;


public class Irrigation_Verify_navigation_skipping_optional {
	private FrostPage frostPage;
	private AndroidDriver driver;
	private LoginPage loginpage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreenpage;
	private IrrigationPage irrigationPage;
	private JavascriptExecutor js;
	private Read_Irrigation_Details read_irrigation;
	private ReadUserData readUserData;
	private Account_Page accountPage;
	
	
	@SuppressWarnings("unused")
	@Test
	public void irrigation_verify_navigation_by_skipping_optional() {

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
			readUserData=new ReadUserData();
			readUserData.start();
			Thread.sleep(6000);
			frostPage = new FrostPage(driver);
			Thread.sleep(2000);
			accountPage=new Account_Page(driver);
			Thread.sleep(5000);
			
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

			// verify the back button
			verify_Back_button();
			Thread.sleep(2000);
			
			// Verify Irrigation title text.
			String soil = irrigationPage.getsoilSensorTitle().getText();
			// System.out.println(title);
			if (soil.isEmpty()) {
				ATUReports.add("Soil Moisture Senso element is not available in the screen ", LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				if (soil.contains("Soil Moisture Sensor")) {
					ATUReports.add("SOIL MOISTURE SENSORS is noticed in the screen ", "Soil Moisture Sensor", soil,
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
				Thread.sleep(2000);
				ATUReports.add(
						"Next  button is enabled in the  SOIl MOISTURE SENSORS screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add(
						"Next  button is not  enabled in the  SOIl MOISTURE SENSORS screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			// Click on skip button
			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				Thread.sleep(2000);
				ATUReports.add("Next  button is enabled in the  PRESSURE SENSOR screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next  button is not enabled in the  PRESSURE SENSOR screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			Thread.sleep(2000);

			// Click on skip button
			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				ATUReports.add("Next  button is enabled in the   FLOW METER SENSOR screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("SKIP  button is not enabled in the  FLOW METER SENSOR screen and Clicked on Next button",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);

			// Click on skip button
			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				Thread.sleep(2000);
				ATUReports.add("Next  button is enabled in the ET READING screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Next  button is not enabled in the  ET READING screen",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			
			//Click on save button	
			if (irrigationPage.getskipbtn().isEnabled()) {
				irrigationPage.getskipbtn().click();
				Thread.sleep(10000);
				ATUReports.add("save button is enabled in the screen and Clicked on Next button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				ATUReports.add("Next  button is not enabled in the  screen",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify to Observe cancel adding irrigation dialog is displayed.		
			MobileElement popTextTitle =irrigationPage.getpopUpText();
			String popText= irrigationPage.getpopUpText().getText();
			System.out.println(popText+"---popText--");

			//String popText= irrigationPage.getpopUpText().getText();
			if (popText.contains("Cancel Adding Irrigation?")) {
				ATUReports.add(
						"Cancel Adding Irrigation? Dialog Text is Displaye","Cancel Adding Irrigation?", popText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Observe cancel adding irrigation dialog is not isplayed","Cancel Adding Irrigation?", popText,
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(5000);
				
		
			//Verify body
				MobileElement bodyText=irrigationPage.getPopUpBody();
				String popText2= bodyText.getText();
			if(popText2.contains("At least one sensor input is required to track irrigation, by skipping all sensors no Irrigation report will be added.")){
				
				ATUReports.add(
						"At least one sensor input is required to track irrigation, by skipping all sensors no Irrigation report will be added. Text is displayed",
						"At least one sensor input is required to track irrigation, by skipping all sensors no Irrigation report will be added.", popText2, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				ATUReports.add("Observe cancel adding irrigation dialog is not isplayed",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			
			
			//Verify go back button
			MobileElement goBackButton=irrigationPage.getgoBack();
			if(goBackButton.isDisplayed()){
				ATUReports.add("Go back  button is Displayed in the irrigation 'Cancel adding irrigation dialog box'",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				ATUReports.add("Go back  button is not Displayed in the irrigation 'Cancel adding irrigation dialog box'",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(2000);
			
			//Click on Continue button
			MobileElement continueButton=irrigationPage.getpopUpContinue();
			String Text=continueButton.getText();
			if(Text.contains("Continue")){
				
				ATUReports.add("Continue  button is Displayed in the irrigation 'Cancel adding irrigation dialog box' and clicked on continue button",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				continueButton.click();
				
			}else{
				ATUReports.add("Continue  button is not Displayed in the irrigation 'Cancel adding irrigation dialog box'",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			Thread.sleep(2000);
			
		
			//Verify user navigated to view details screen.
			
			MobileElement viewTextField=irrigationPage.getviewTextField();
			String textOne=viewTextField.getText();
			if(textOne.contains(readUserData.search)){
				ATUReports.add("User navigated to view details screen.",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				ATUReports.add("User is not navigated to view details screen.",
						LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			Thread.sleep(5000);
			
			

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

		} catch (Exception e) {

		}

	}

	private void verify_Back_button() {

		// Verify the Cancel button text
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
