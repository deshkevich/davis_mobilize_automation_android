package functional_testcases;

import Pages.LoginPage;
import Pages.SignUpPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utility.ReadNewUserDetails;
import utility.ReadRegistration;

//import Pages.WelcomePage;

public class valid_signup_skip_firstname_lastname {

	private AndroidDriver driver ;
	private SignUpPage signuppage ; 
	private ReadNewUserDetails readnewuserdetails ;
	private LoginPage loginpage;
	@Test
	public void valid_Signup_Skip_Firstname_Lastname(){

		try {
			driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
			signuppage = new SignUpPage(driver);
			new ReadRegistration();
			readnewuserdetails = new ReadNewUserDetails();
			loginpage = new LoginPage(driver);
			
			
			
			//verify the Sign up button is present in the screen and click on sign up button
			if (signuppage.getSignUp().isDisplayed() || signuppage.getSignUp().isEnabled())
			{
				readnewuserdetails.start();
				Thread.sleep(2000);
				signuppage.getSignUp().click();
				Thread.sleep(2000);
				String emailid = signuppage.getGmailTextBox().getAttribute("name");	
					if (emailid.equals("Enter your email")) {
						ATUReports.add("Verify the emailid placeholder text is displayed in the screen", "Enter your Email", emailid,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Verify the emailid placeholder text is not displayed in the screen", emailid,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				
				
				String emaiID =readnewuserdetails.emaiID;
				//Enter the email in the text box
				signuppage.getGmailTextBox().sendKeys(emaiID);
				//Verify the next button is enabled
				if (signuppage.getNextButton().isEnabled() ) {
					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					//Click on the next button
					signuppage.getNextButton().click();
					Thread.sleep(2000);
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				
				//Click on Skip button in the firstname screen   
				if (signuppage.getSkipBtn().isDisplayed()|| signuppage.getSkipBtn().isEnabled()) {
					ATUReports.add("Skip î  button is displayed/enabled in the First Name screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getSkipBtn().click();
				} else {
					ATUReports.add("Skip button is not displayed/enabled in the First Name screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				

				//Verify the username placeholder text
				String username  = signuppage.getUr_text_box().getText();		
					if (username.contains("Enter your username")) {
						ATUReports.add("Placeholder text Enter Username is displayed in the screen ", "Enter username", username,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Placeholder text Enter Username is not displayed in the screen ", username,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
			

			
				//Enter text in the user name 
				signuppage.getUr_text_box().sendKeys(readnewuserdetails.username);
				Thread.sleep(3000);
				driver.hideKeyboard();

				//Verify the next button is enabled
				if (signuppage.getUr_Next_Btn().isEnabled() ) {

					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getUr_Next_Btn().click();
					Thread.sleep(2000);
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Verify the Password placeholder text
				String pasword  = signuppage.gePwd_Text_Box().getAttribute("name");
				System.out.println(pasword+"--pasword--");
				
				if (signuppage.gePwd_Text_Box().isDisplayed()) {
					ATUReports.add("Placeholder text Enter Username is displayed in the screen ", "Enter password", pasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Placeholder text Enter Username is not displayed in the screen ", pasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
		
				
				//Enter the Confirm password
				signuppage.gePwd_Text_Box().sendKeys(Keys.DELETE);
				signuppage.gePwd_Text_Box().sendKeys(Keys.INSERT);
				Thread.sleep(2000);
				signuppage.gePwd_Text_Box().sendKeys(readnewuserdetails.Strong_password);
				System.out.println(readnewuserdetails.Strong_password+"-----readnewuserdetails.Strong_password---");
				Thread.sleep(5000);
				driver.hideKeyboard();
					
				//Verify the Weak password  text
				String strongpwd = signuppage.getweekpwdText().getText();
				if(strongpwd.isEmpty()){
					ATUReports.add("Text STRONG PASSWORD is not displayed in the screen ", "STRONG PASSWORD", strongpwd,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (strongpwd.contains("STRONG PASSWORD")) {
						ATUReports.add("Text STRONG PASSWORD is displayed in the screen ", "STRONG PASSWORD", strongpwd,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Text STRONG PASSWORD is not displayed in the screen ", strongpwd,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}
				
		
				//Verify the next button is enabled
				if (signuppage.getPswd_Next_Button().isEnabled() ) {
					ATUReports.add("Next button is displayed & enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
					//Click on the next button
					signuppage.getPswd_Next_Button().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				
				//Verify the Confirm password  text
				String confirmpasword  = signuppage.getConfrm_pwd_Text().getText();
				if(confirmpasword.isEmpty()){
					ATUReports.add("Text CONFIRM PASSWORD is not displayed in the screen ", "CONFIRM PASSWORD", confirmpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					if (confirmpasword.equals("CONFIRM PASSWORD")) {
						ATUReports.add("Text CONFIRM PASSWORD is displayed in the screen ", "CONFIRM PASSWORD", confirmpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Text CONFIRM PASSWORD is not displayed in the screen ", confirmpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				//Enter the Confirm password	
				signuppage.getConfrm_pwd_Text_Box().sendKeys(readnewuserdetails.Strong_password);
				System.out.println(readnewuserdetails.Strong_password+"-----readnewuserdetails.Strong_password---");
				Thread.sleep(3000);
				driver.hideKeyboard();
				

				//Verify the next button is enabled
				if (signuppage.getCn_Next_Button().isEnabled() ) {

					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getCn_Next_Button().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				
				
				

			}
			else{
				ATUReports.add("Sign up button is not displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			driver.closeApp();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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

}
























/*	//Enter password
signuppage.gePwd_Text_Box().sendKeys(readnewuserdetails.Invalid_password);
Thread.sleep(3000);
driver.hideKeyboard();




//Verify the Invalid Password text
String invalidpasword  = signuppage.getweekpwdText().getText();

if(invalidpasword.isEmpty()){
	ATUReports.add("Invalid Password is not displayed in the screen ", "INVALID PASSWORD", invalidpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

}else{
	if (invalidpasword.equals("INVALID PASSWORD")) {
		ATUReports.add("Invalid Password is displayed in the screen ", "INVALID PASSWORD", invalidpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		ATUReports.add("Invalid Password is not displayed in the screen ", invalidpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}
Thread.sleep(2000);
*/
