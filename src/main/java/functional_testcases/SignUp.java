package functional_testcases;

import Pages.Alert_Page;
import Pages.LoginPage;
import Pages.SignUpPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;
import utility.Log;
import utility.ReadUserData;

import java.net.MalformedURLException;

public class SignUp {
	private Alert_Page alertpage ;
	public static AppiumDriver wd = null;
	private LoginPage loginpage;
	private AndroidDriver driver;
	private SignUpPage signupage;
	private ReadUserData readUserData;

	@SuppressWarnings("deprecation")
	@Test
	public void SignUp_scenario() throws MalformedURLException, InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		loginpage = new LoginPage(driver);
		signupage = new SignUpPage(driver);
		readUserData =new ReadUserData();
		readUserData.start();
		alertpage = new Alert_Page(driver);
		Log.startTestCase("SignUp test Case start");
		System.out.println("*********** SignUp test Case start ********");

		
		          // re launch the app
					Thread.sleep(20000);
					driver.resetApp();
					//Thread.sleep(10000);
		
		// Verify the Sign up text and assert
		
		MobileElement signup = loginpage.getsignUptext();
		if (signup != null) {
			String Sign_up_txt = signup.getText();
			if (Sign_up_txt.isEmpty()) {
				ATUReports.add("Verify the SignUp text", "Sign up", Sign_up_txt, LogAs.WARNING,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				if (Sign_up_txt.equals("Sign up")) {
					CaptureScreen screen1 = new CaptureScreen(ScreenshotOf.BROWSER_PAGE);
					ATUReports.add("Verify the SignUp text", "Sign up", Sign_up_txt, LogAs.PASSED, screen1);
					signup.click();
					try {		
						try {							
						} catch (WebDriverException e) {					
							ATUReports.add("Keyboard was present", false);
						}

					} catch (WebDriverException e) {
						// e.printStackTrace();
						ATUReports.add("Keyboard is not even present", null, LogAs.PASSED, screen1);
					}

				} else {
					ATUReports.add("Verify the SignUp text", "Sign up", Sign_up_txt, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
					
								
									
				
					// Click on Enter email text box
					MobileElement emaitxtbox = signupage.getGmailTextBox();
					if (emaitxtbox != null) {
						if (emaitxtbox.isDisplayed()) {
							emaitxtbox.click();
							Thread.sleep(3000);
							// Enter valid email in text box			
							emaitxtbox.sendKeys(readUserData.emailid);
							// Tap on Next.
							MobileElement nextButton = signupage.getNextButton();
							if (nextButton != null) {
								String nextButtonText = nextButton.getText();
								if (nextButtonText.isEmpty()) {
									ATUReports.add("Mobilize next button is not Displayed", "Next", Sign_up_txt, LogAs.WARNING,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								} else {
									if (nextButtonText.equals("Next")) {
										ATUReports.add("Mobilize next button is displayed ", "Next",
												nextButtonText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										nextButton.click();
										Thread.sleep(3000);
									} else {
										ATUReports.add("Mobilize next button is not displayed ", "Next", nextButtonText, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}
							}
							
							
							
							
							if (alertpage.getemailAlert()!=null) {
								if (alertpage.getemailAlert().isDisplayed()) {			
										String errortext = alertpage.getemailAlert().getText();									
												ATUReports.add("Email already registered", " Email already exists", errortext,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}else{
												ATUReports.add("Email alert is not displayed", " Email already exists",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
								
								
								    if(alertpage.getyesButton()!=null){
									alertpage.getyesButton().click();
									Thread.sleep(2000);
									}else{
										ATUReports.add("alert is not displayed", Sign_up_txt, LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
										
									
							} else {
								ATUReports.add("Alert message is not displayed", LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							// Verify navigated to first name screen
							String gmailText = signupage.getFirstNameText().getText();
							if (gmailText.isEmpty()) {
								ATUReports.add("Mobilize  gmail text box is not displayed", " ENTER FIRST NAME",
										gmailText, LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							} else {
								if (gmailText.equals("ENTER FIRST NAME")) {
									ATUReports.add("Mobilize gmail text box  is displayed", "ENTER FIRST NAME",
											gmailText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
								} else {
									ATUReports.add("Mobilize gmail text box is not displayed", "ENTER FIRST NAME",
											gmailText, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}
							// Back is displayed at top left corner.and Now tap on Back.
							MobileElement backButton = signupage.getBackBtn();
							if (backButton != null&& backButton.isDisplayed()) {
										ATUReports.add("Mobilize back button is displayed at top left corner.", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										backButton.click();
										Thread.sleep(4000);
									} else {
										ATUReports.add("Mobilize back button is not displayed at top left corner.", LogAs.FAILED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
						}
					} else {
						ATUReports.add("Mobilize gmail text box is not displayed",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					driver.hideKeyboard();

			
					
					
					
					//Using keyboard automation to delete data	 
					signupage.getsignUpCrossIcon().click();
					ATUReports.add("Click on cross icon to enter space in text box ",LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					  Thread.sleep(5000);
					/*signupage.getsighnUpMail().sendKeys(Keys.DELETE);
					signupage.getsighnUpMail().sendKeys(Keys.INSERT);
					signupage.getsighnUpMail().sendKeys(Keys.DELETE);
					signupage.getsighnUpMail().sendKeys(Keys.DELETE);
					signupage.getsighnUpMail().sendKeys(Keys.DELETE);
					signupage.getsighnUpMail().sendKeys(Keys.INSERT);
			        Thread.sleep(7000);*/
			        
			        signupage.getsighnUpMail().sendKeys(readUserData.existingEmail);
					System.out.println(readUserData.existingEmail+"---readUserData.existingEmail--");
					String next = null;
					//Verify the next button is enabled
					if (signupage.getNextButton().isEnabled() ) {

						next = signupage.getNextButton().getText();
						if(next.isEmpty()){
							ATUReports.add("Next button is not displayed in the screen ", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}else{
							if (next.equals("Next")) {
								ATUReports.add("Next button is enabled and displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}else{
								ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						}
						//Click on the next button
						signupage.getNextButton().click();
					} else {
						ATUReports.add("Next button is not enabled in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
					
				
					

					if (alertpage.getemailAlert()!=null) {
						if (alertpage.getemailAlert().isDisplayed()) {			
								String errortext = alertpage.getemailAlert().getText();									
										ATUReports.add("Email already registered", " Email already exists", errortext,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}else{
										ATUReports.add("Email alert is not displayed", " Email already exists",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
						
						
						    if(alertpage.getyesButton()!=null){
							alertpage.getyesButton().click();
							Thread.sleep(2000);
							}else{
								ATUReports.add("alert is not displayed", Sign_up_txt, LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
								
							
					} else {
						ATUReports.add("Alert message is not displayed", LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

				
					
					} else {
						ATUReports.add("Mobilize gmail text box is not displayed",
								LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
			}
		} else {
			driver.close();
			return;

		}

		Log.startTestCase("SignUp test Case Ended");
		System.out.println("*********** SignUp test Case Ended ********");

	}
	
}
