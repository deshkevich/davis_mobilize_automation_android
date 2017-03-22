package functional_testcases;

import Pages.Alert_Page;
import Pages.SignUpPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utility.ReadUserData;

public class ExistingEmailID {
	
	private AndroidDriver driver ;
	private SignUpPage signuppage ; 
	private Alert_Page alertpage ;
	private ReadUserData readUserData;
	@Test
	public void SignUp_with_Existing_EmailID(){

		try {
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		signuppage = new SignUpPage(driver);
		alertpage = new Alert_Page(driver);
		readUserData=new ReadUserData();
		readUserData.start();
		    Thread.sleep(1000);
		    
		    
		    
		           // re launch the app
		 			Thread.sleep(20000);
		 			driver.resetApp();
		 			Thread.sleep(10000);
		 			
		 			
			//verify the Signup button is present in the screen nd click on signup button
		 	if(signuppage.getSignUp()!=null){
			if (signuppage.getSignUp().isDisplayed() || signuppage.getSignUp().isEnabled())
			{
				signuppage.getSignUp().click();
				Thread.sleep(2000);
				ATUReports.add("Verify the Signup button is displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));						
			}else{
				ATUReports.add("Sign up button is not displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}	
		        Thread.sleep(2000);
				
		        
		        //Using keyboard automation to delete data	        
		        signuppage.getsighnUpMail().sendKeys(Keys.DELETE);
		        signuppage.getsighnUpMail().sendKeys(Keys.INSERT);
		        signuppage.getsighnUpMail().sendKeys(Keys.DELETE);
		        signuppage.getsighnUpMail().sendKeys(Keys.DELETE);
		        signuppage.getsighnUpMail().sendKeys(Keys.DELETE);
		        signuppage.getsighnUpMail().sendKeys(Keys.INSERT);
		        Thread.sleep(7000);
		        
				signuppage.getsighnUpMail().sendKeys(readUserData.existingEmail);
				System.out.println(readUserData.existingEmail+"---readUserData.existingEmail--");
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
				
			

				//Verify the Error message
				if (alertpage.getemailAlert().isDisplayed()) {
					String errortext = alertpage.getemailAlert().getText();
					if(errortext.isEmpty()){
						ATUReports.add("Error message is not displayed", " Email already exists", errortext,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}else{
						if (errortext.equals("Email already exists")) {
							ATUReports.add("Email already registered", " Email already exists", errortext,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Error message is not displayed", errortext,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					}
				} else {
					
					ATUReports.add("Alert message is not displayed", LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				
				
				alertpage.getyesButton().click();
				Thread.sleep(2000);
				
				
			}else{
				ATUReports.add("Sign up button is not displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

















/*//Click on Skip button in the firstname screen   
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
signuppage.getUr_text_box().sendKeys("testing45");

//Verify the next button is enabled
if (signuppage.getUr_Next_Btn().isEnabled() ) {

	next = signuppage.getNextButton().getText();
	
		if (next.equals("Next")) {
			ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}else{
			ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	

//Verify the Password placeholder text
String pasword  = signuppage.gePwd_Text_Box().getAttribute("nmae");
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
signuppage.gePwd_Text_Box().sendKeys("143143");
driver.hideKeyboard();


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

		if (next.equals("Next")) {
			ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}else{
			ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	//Click on the next button
	signuppage.getPswd_Next_Button().click();


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
signuppage.getConfrm_pwd_Text_Box().sendKeys("143143");
driver.hideKeyboard();

	
		if (next.equals("Next")) {
			ATUReports.add("Next button is displayed in the screen ", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}else{
			ATUReports.add("Next button is not displayed in the screen ", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	//Click on the next button
	signuppage.getNextButton().click();*/
