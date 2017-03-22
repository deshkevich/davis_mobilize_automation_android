package functional_testcases;

import Pages.Account_Page;
import Pages.HomePage;
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

public class Weak_Password {


	private AndroidDriver driver ;
	private SignUpPage signuppage ; 
	private ReadNewUserDetails readnewuserdetails ;
	private HomePage homepage;
	private Account_Page accountPage;

	@Test
	public void valid_Signup_Skip_Firstname_Lastname(){

		try {
			driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
			signuppage = new SignUpPage(driver);
			new ReadRegistration();
			//new WelcomePage(driver);
			readnewuserdetails = new ReadNewUserDetails();
			homepage = new HomePage(driver);
			accountPage=new Account_Page(driver);
			Thread.sleep(2000);

			//verify the Sign up button is present in the screen and click on sign up button
			/*if (signuppage.getSignUp().isDisplayed() || signuppage.getSignUp().isEnabled())
			{
				readnewuserdetails.start();
				signuppage.getSignUp().click();

				String emailid = signuppage.getGmailTextBox().getAttribute("name");	
					if (emailid.equals("Enter your email")) {
						ATUReports.add("Verify the emailid placeholder text is displayed in the screen", "Enter your Email", emailid,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Verify the emailid placeholder text is not displayed in the screen", emailid,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}*/
			
				/*String emaiID =readnewuserdetails.emaiID;
				//Enter the email in the text box
				signuppage.getGmailTextBox().sendKeys(emaiID);
*/
			
			 signuppage.getsighnUpMail().sendKeys(Keys.DELETE);
		     signuppage.getsighnUpMail().sendKeys(Keys.INSERT);
		     signuppage.getsighnUpMail().sendKeys(Keys.INSERT);
		     signuppage.getsighnUpMail().sendKeys(Keys.BACK_SPACE);
		     Thread.sleep(2000);
			String emaiID =readnewuserdetails.emaiID;
			//Enter the email in the text box
			signuppage.getsighnUpMail().sendKeys(emaiID);
			
			
				//Verify the next button is enabled
				if (signuppage.getNextButton().isEnabled() ) {

					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getNextButton().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Click on Skip button in the first name screen  
				driver.hideKeyboard();

				if (signuppage.getSkipBtn().isDisplayed()|| signuppage.getSkipBtn().isEnabled()) {
					ATUReports.add("Skip î  button is displayed/enabled in the First Name screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getSkipBtn().click();
				} else {
					ATUReports.add("Skip button is not displayed/enabled in the First Name screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Click on Skip button in the last name screen
				driver.hideKeyboard();

				

				//Verify the username placeholder text
				String username  = signuppage.getUr_text_box().getText();
				if(username.isEmpty()){
					ATUReports.add("Placeholder text Enter Username is not displayed in the screen ", "Enter username", username,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (username.equals("Enter your username")) {
						ATUReports.add("Placeholder text Enter Username is displayed in the screen ", "Enter username", username,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Placeholder text Enter Username is not displayed in the screen ", username,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				//Enter text in the username 
				String usernamevalue =readnewuserdetails.username;
				signuppage.getUr_text_box().sendKeys(usernamevalue);
				Thread.sleep(3000);
				//Verify the next button is enabled
				if (signuppage.getUr_Next_Btn().isEnabled() ) {

					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getUr_Next_Btn().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}


				//Verify the Password placeholder text
				String pasword  = signuppage.gePwd_Text_Box().getAttribute("name");
				System.out.println(pasword+"--pasword--");
				if(pasword.isEmpty()){
					ATUReports.add("Placeholder text Enter Password is not displayed in the screen ", "Enter password", pasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (pasword.contains("Enter your password")) {
						ATUReports.add("Placeholder text Enter Username is displayed in the screen ", "Enter password", pasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Placeholder text Enter Username is not displayed in the screen ", pasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				//Enter password
				String weakpasswordvalue =readnewuserdetails.weak_password;
				signuppage.gePwd_Text_Box().sendKeys(weakpasswordvalue);
				Thread.sleep(3000);


				//Verify the Weak password  text
				String weakpasword  = signuppage.getweekpwdText().getText();
				if(weakpasword.isEmpty()){
					ATUReports.add("Text WEAK PASSWORD is not displayed in the screen ", "WEAK PASSWORD", weakpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (weakpasword.equals("WEAK PASSWORD")) {
						ATUReports.add("Text WEAK PASSWORD is displayed in the screen ", "WEAK PASSWORD", weakpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Text WEAK PASSWORD is not displayed in the screen ", weakpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}

				//Verify the next button is enabled
				if (signuppage.getPswd_Next_Button().isEnabled() ) {

					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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
				signuppage.getConfrm_pwd_Text_Box().sendKeys(weakpasswordvalue);
				Thread.sleep(3000);

				//Verify the next button is enabled
				if (signuppage.getCn_Next_Button().isEnabled() ) {

					ATUReports.add("Next button is enabled in the screen ", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					//Click on the next button
					signuppage.getCn_Next_Button().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				///Verify the add photo text field
				MobileElement searchplaceholder = signuppage.getaddPhoto();
				if (searchplaceholder.isDisplayed()) {

					ATUReports.add("Add photo field is displayed", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("Add photo field is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				
				signuppage.getSkipBtn().click();
				Thread.sleep(2000);
				
				
				//Click on Manage Account    				
				homepage.getAccountbtn().click();
				ATUReports.add("Clicked on account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
				
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
			/*}
			else{
				ATUReports.add("Sign up button is not displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}*/

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}






















/*//Verify the caption text
String caption  = signuppage.getcaption().getText();
if(caption.isEmpty()){
	ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", "Please retype password to confirm", caption,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

}else{
	if (caption.equals("Please retype password to confirm")) {
		ATUReports.add("Text caption -Please retype password to confirm is displayed in the screen ", "Please retype password to confirm", caption,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", caption,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}*/
