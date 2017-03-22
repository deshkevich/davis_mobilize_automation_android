package functional_testcases;

import Pages.Alert_Page;
import Pages.SignUpPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import utility.ReadNewUserDetails;

public class Existing_UserID {
	
	private AndroidDriver driver ;
	private SignUpPage signuppage ; 
	private Alert_Page alertpage ;
	private ReadNewUserDetails readnewuserdetails ;
@Test
	public void SIgnUP_with_Existing_UserID(){
		try {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		signuppage = new SignUpPage(driver);
		alertpage = new Alert_Page(driver);
		readnewuserdetails = new ReadNewUserDetails();
		readnewuserdetails.start();
		
		
		
		 // re launch the app
		Thread.sleep(20000);
		driver.resetApp();
		//Thread.sleep(10000);
		
		
			//verify the Signup button is present in the screen nd click on signup button
			if (signuppage.getSignUp().isDisplayed() || signuppage.getSignUp().isEnabled())
			{
				signuppage.getSignUp().click();

				ATUReports.add("Verify the Signup button is displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				// verify the Email id Placeholder text
				String emailid = signuppage.getGmailTextBox().getText();
			
						ATUReports.add("Verify the emailid placeholder text is displayed in the screen", "Enter your Email", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Verify the emailid placeholder text is displayed in the screen",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
			

				//Enter the email in the text box
			String emaiID =readnewuserdetails.emaiID;
			signuppage.getGmailTextBox().sendKeys(emaiID);
				String next = null;
				//Verify the next button is enabled
				if (signuppage.getNextButton().isEnabled() ) {

					next = signuppage.getNextButton().getText();
					if(next.isEmpty()){
						ATUReports.add("Next button is not displayed in the screen ", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (next.equals("Next")) {
							ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					//Click on the next button
					signuppage.getNextButton().click();
				} else {
					ATUReports.add("Next button is not enabled in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				//Click on Skip button in the firstname screen   
				String skip = null; 
				if (signuppage.getSkipBtn().isDisplayed()|| signuppage.getSkipBtn().isEnabled()) {

					skip = signuppage.getSkipBtn().getText();
					System.out.println("Skip button"+skip);
					if(skip.trim().isEmpty()){
						ATUReports.add("Skip button is not displayed in the First Name screen ", "Skip", skip,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (skip.trim().equalsIgnoreCase("Skip")) {
							ATUReports.add("Skip button is displayed in the First Name screen ", "Skip", skip,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Skip button is not displayed in the First Name screen ", skip,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
					//Click on the next button
					signuppage.getSkipBtn().click();
				} else {
					ATUReports.add("Skip button is not displayed/enabled in the First Name screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			
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
				driver.hideKeyboard();

				//Verify the next button is enabled
				
						if (next.equals("Next")) {
							ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							//Click on the next button
							signuppage.getUr_Next_Btn().click();
							Thread.sleep(2000);
						}else{
							ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					
			
			
				//Verify the Error message
				MobileElement errorMsg=signuppage.getusernameAlert();
				String alerttext =errorMsg.getText();
				if (errorMsg.isDisplayed()) {
					
					if(alerttext.isEmpty()){
						ATUReports.add("Error message is not displayed", "Username is already in use", alerttext,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (alerttext.equals("Username is already in use")) {
							ATUReports.add("Username is already in use alert is displayed", "Username is already in use", alerttext,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Username is already in use alert  is not displayed", alerttext,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
				} else {

					ATUReports.add("Username is already in use is not displayed", LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}




















/*//Verify the Password placeholder text
String pasword  = signuppage.getpwd_Text_Box().getText();
if(pasword.isEmpty()){
	ATUReports.add("Placeholder text Enter Password is not displayed in the screen ", "Enter password", pasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

}else{
	if (pasword.equals("Enter password")) {
		ATUReports.add("Placeholder text Enter Username is displayed in the screen ", "Enter password", pasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		ATUReports.add("Placeholder text Enter Username is not displayed in the screen ", pasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

//Enter password 
signuppage.getpwd_Text_Box().sendKeys("123456");
Thread.sleep(2000);


//Verify the Weak password  text
String weakpasword  = signuppage.getweekpwdText().getText();
if(weakpasword.isEmpty()){
	ATUReports.add("Text WEAK PASSWORD is not displayed in the screen ", "WEAK PASSWORD", weakpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

}else{
	if (weakpasword.contains("WEAK PASSWORD")) {
		ATUReports.add("Text WEAK PASSWORD is displayed in the screen ", "WEAK PASSWORD", weakpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		ATUReports.add("Text WEAK PASSWORD is not displayed in the screen ", weakpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

//Verify the next button is enabled
if (signuppage.getNextButton().isEnabled() ) {

	next = signuppage.getNextButton().getText();
	if(next.isEmpty()){
		ATUReports.add("Next button is not displayed in the screen ", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

	}else{
		if (next.equals("Next")) {
			ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}else{
			ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	//Click on the next button
	signuppage.getNextButton().click();
} else {
	ATUReports.add("Next button is not enabled in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

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


//Verify the caption text
String caption  = signuppage.getcaption().getText();
if(caption.isEmpty()){
	ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", "Please retype password to confirm", caption,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

}else{
	if (caption.equals("Please retype password to confirm")) {
		ATUReports.add("Text caption -Please retype password to confirm is displayed in the screen ", "Please retype password to confirm", caption,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", caption,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

//Enter the Confirm password
signuppage.getConfrm_pwd_Text_Box().sendKeys("123456");
Thread.sleep(2000);

//Verify the caption text
String caption  = signuppage.getcaption().getText();
if(confirmpasword.isEmpty()){
	ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", "Password match", confirmpasword,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

}else{
	if (confirmpasword.equals("Password match")) {
		ATUReports.add("Text caption -Please retype password to confirm is displayed in the screen ", "Password match", confirmpasword,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		ATUReports.add("Text caption -Please retype password to confirm is not displayed in the screen ", confirmpasword,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

//Verify the next button is enabled
if (signuppage.getNextButton().isEnabled() ) {

	next = signuppage.getNextButton().getText();
	if(next.isEmpty()){
		ATUReports.add("Next button is not displayed in the screen ", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

	}else{
		if (next.equals("Next")) {
			ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}else{
			ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	//Click on the next button
	signuppage.getNextButton().click();
} else {
	ATUReports.add("Next button is not enabled in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

}
*/
