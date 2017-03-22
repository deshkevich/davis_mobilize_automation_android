package functional_testcases;

import Pages.LoginPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.Log;
import utility.ReadUserData;
import utility.Read_Change_Password;

import java.net.MalformedURLException;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

public class InvalidSignIn implements ITestListener {

	private AndroidDriver driver ;
	private LoginPage loginPage ;
	private ReadUserData readUserData;
	private Read_Change_Password readchangepassword;
	@Test
	public void inValidSignin() throws MalformedURLException {
		
		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		loginPage = new LoginPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		readchangepassword = new Read_Change_Password();
		readchangepassword.start();
		//Log.startTestCase("Invalid Login test Case start");
		

		//verify the logo is present in the screen.
		try {
			loginPage.getlogo().isDisplayed();

			ATUReports.add("Verify the Mobilize logo is displayed in the screen",LogAs.PASSED, null);


			// Verify the text under the logo
			String title = loginPage.getlogo_caption().getText();
			//System.out.println(title);
			Assert.assertEquals("By Davis Instruments", title);
			ATUReports.add("Verify the Mobilize logo text", "Log in to access your weather world", title,LogAs.PASSED, null);

			//Verify the Sign up text and assert
			String Sign_up = loginPage.getsignUptext().getText();
			//System.out.println(Sign_up);
			if(Sign_up.isEmpty()){
				ATUReports.add("Verify the SignUp text", "Sign up", Sign_up,LogAs.WARNING, null);

			}else{
				if (Sign_up.equals("Sign up")) {
					ATUReports.add("Verify the SignUp text", "Sign up", Sign_up,LogAs.PASSED, null);
				}else{
					ATUReports.add("Verify the SignUp text", "Sign up", Sign_up,LogAs.FAILED, null);
				}
			}

			//Verify the Login text and assert
			String Login = loginPage.getlogintext().getText();
			//System.out.println(Login);
			if(Login.isEmpty()){
				ATUReports.add("Verify the Login text", "Log in", Login,LogAs.WARNING, null);

			}else{
				if (Login.equals("Log in")) {
					ATUReports.add("Verify the Login text", "Log in", Login,LogAs.PASSED, null);
				}else{
					ATUReports.add("Verify the Login text", "Log in", Login,LogAs.FAILED, null);
				}
			}

			//Click on log in button
			//loginPage.getlogintext().click();

			//Clear the text in the Username text box if any.
			if (loginPage.getUserNametxtbx().getText().isEmpty()) {

			} else {
				loginPage.getUserNametxtbx().clear();
			}

			//Verify the Next button
			String next = loginPage.getNextButton().getText();
			//System.out.println(next);
			if(next.isEmpty()){
				ATUReports.add("Verify the next is displayed in the screen", "Next", next,LogAs.WARNING, null);

			}else{
				if (next.equals("Next")) {
					ATUReports.add("Verify the next is displayed in the screen", "Next", next,LogAs.PASSED,null);
				}else{
					ATUReports.add("Verify the next is displayed in the screen", next,LogAs.FAILED,new CaptureScreen(loginPage.getlogintext()) );
				}
			}	

			Log.info(next+"  : is displayed in the screen and the same is asserted");

			//Get the user name placeholder text and verify
			String username_placeholder = loginPage.getUserNametxtbx().getText();
			//System.out.println(username_placeholder);

			if(username_placeholder.isEmpty()){
				ATUReports.add("Verify the placeholder text is displayed in the screen", "Enter your username", username_placeholder,LogAs.WARNING, null);

			}else{
				if (next.equals("Next")) {
					ATUReports.add("Verify the placeholder text is displayed in the screen", "Enter your username", username_placeholder,LogAs.PASSED,null);
				}else{
					ATUReports.add("Verify the placeholder text is displayed in the screen", username_placeholder,LogAs.FAILED,new CaptureScreen(loginPage.getlogintext()) );
				}
			}		

			Log.info(username_placeholder+"  : is displayed in the screen and the same is asserted");

			// enter name in the username text box
			loginPage.getUserNametxtbx().sendKeys(readUserData.sUserName);
			//username.sendKeys(readUserData.sUserName);
			ATUReports.add("Username entered in the text box","xcube", username_placeholder,LogAs.INFO,null);

			//Click on Next button
			loginPage.getNextButton().click();
			ATUReports.add("Tap on Next button",true);


			//Get the user name placeholder text and verify
			String password_placeholder = loginPage.getpasswordtxtbx().getText();
			//System.out.println("Password placeholder text: "+password_placeholder);

			if(password_placeholder.isEmpty()){
				ATUReports.add("Verify the Passowrd placeholder text is displayed in the screen", "Enter your password",LogAs.WARNING, null);

			}else{
				if (password_placeholder.equals("Enter your password")) {
					ATUReports.add("Verify the Passowrd placeholder text is displayed in the screen", "Enter your password",LogAs.PASSED,null);
				}else{
					ATUReports.add("Verify the Passowrd placeholder text is displayed in the screen",LogAs.FAILED,new CaptureScreen(loginPage.getlogintext()) );
				}
			}
			Log.info(username_placeholder+"  : is displayed in the screen and the same is asserted");

			//Verify the Next button in the password screen
			//System.out.println(next);
			if(next.isEmpty()){
				ATUReports.add("Verify the next is displayed in the screen", "Next", next,LogAs.WARNING, null);

			}else{
				if (next.equals("Next")) {
					ATUReports.add("Verify the next is displayed in the screen", "Next", next,LogAs.PASSED,null);
				}else{
					ATUReports.add("Verify the next is displayed in the screen", next,LogAs.FAILED,new CaptureScreen(loginPage.getlogintext()) );
				}
			}	

			Log.info(next+"  : is displayed in the screen and the same is asserted");

			// enter password in the Password in the  text box
			loginPage.getpasswordtxtbx().sendKeys(readchangepassword.wrongnewpassword);//sendKeys("4ct65zp");readchangepassword
			ATUReports.add("password entered in the text box",true);

			//Click on Next button
			loginPage.getNextButton().click();
			//TestAppiumDriver.getAppiumDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			ATUReports.add("Tap on Next button",true);
			//TestAppiumDriver.getAppiumDriver().clear();
			
			String errorTitle = TestAppiumDriver.getAppiumDriver().findElement(By.name("Error")).getText();
			
			TestAppiumDriver.getAppiumDriver().findElement(By.name("OK")).click();
			//TestAppiumDriver.getAppiumDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


					} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
}







// For future reference

/*

//verifying the alert message.
if(TestAppiumDriver.getAppiumDriver().getPageSource().contains(errorTitle))
{
	//System.out.println("Error Alert is Present in the screen");

	//Verify the Next button in the password screen
	String error_text = TestAppiumDriver.getAppiumDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]")).getText();
	ATUReports.add("Verify the next text", "Credentials are required to access this resource.", error_text,LogAs.PASSED,null);
	//Log.info(error_text+"  : is displayed in the screen and the same is asserted");

	String ok = driver.findElement(By.name("OK")).getText();
	ATUReports.add("Verify the next text", "OK", ok,LogAs.PASSED,null);

	


	System.out.println("Invalid Login is completed.");
}
else
{
	MobileElement screen  = (MobileElement) TestAppiumDriver.getAppiumDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]"));
	CaptureScreen captureScreen = new CaptureScreen(screen);
	ATUReports.add("Error Alert is not Present in the screen",LogAs.FAILED,captureScreen);
	//System.out.println("Error Alert is not Present in the screen");
}

*/