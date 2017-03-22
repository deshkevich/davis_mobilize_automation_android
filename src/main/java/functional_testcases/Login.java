package functional_testcases;

import Pages.Alert_Page;
import Pages.HomePage;
import Pages.LoginPage;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import utility.ExcelUtils;
import utility.Log;
import utility.ReadDeviceConfiguration;
import utility.ReadUserData;

import java.net.MalformedURLException;

public class Login {

	private AndroidDriver driver ;
	public ExcelUtils eu = new ExcelUtils();
	private LoginPage loginpage ;
	private ReadUserData readUserData ;
	private Alert_Page	alertpage;
	private ReadDeviceConfiguration rdc ;
	@SuppressWarnings("deprecation")
	@Test
	public void login() throws MalformedURLException, InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		new HomePage(driver); 
		alertpage=new Alert_Page(driver);
		rdc =new ReadDeviceConfiguration();
		rdc.start();
		
		
	    ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
		Log.startTestCase("Login test Case start");
		System.out.println("*********** Login test Case start ********");
		
		//Verify App is installed or not
		if (driver.isAppInstalled(rdc.BundleId))
		{
			ATUReports.add(" Mobilize App is installed ",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}else {
			driver.installApp(rdc.Applicationpath);
			ATUReports.add(" Mobilize App is not installed ",LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		Thread.sleep(2000);
		try{
			Thread.sleep(2000);
		//verify the logo is present in the screen.
		if (loginpage.getlogo().isDisplayed()) {
			ATUReports.add(" Mobilize logo is displayed in the screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} else {
			ATUReports.add("The Logo is not displayed in the screen ",LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}


		// Verify the text under the logo
		String title = loginpage.getlogo_caption().getText();
		if(title.isEmpty()){
			ATUReports.add("Verify the Mobilize logo text", "Log in to access your weather world", title,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}else{
			if (title.equals("By Davis Instruments")) {
				ATUReports.add("Mobilize logo is displayed", "By Davis Instruments", title,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				ATUReports.add("Verify the Mobilize logo text", "By Davis Instruments", title,LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}

		//Verify the Sign up text and assert
		String Sign_up = loginpage.getsignUptext().getText();
		if(Sign_up.isEmpty()){
			ATUReports.add("Verify the SignUp text", "Sign up", Sign_up,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}else{
			if (Sign_up.equals("Sign up")) {
				ATUReports.add("Verify the SignUp text", "Sign up", Sign_up,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				ATUReports.add("Verify the SignUp text", "Sign up", Sign_up,LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}

		//Read the data from the Excel sheet.
		readUserData.start();

		//Verify the Login text and assert
		String Login = loginpage.getlogintext().getText();

		if(Login.isEmpty()){
			ATUReports.add("Verify the Login text", "Log in", Login,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		}else{
			if (Login.equals("Log in")) {
				 loginpage.getlogintext().click();
				 Thread.sleep(2000);
				ATUReports.add("Verify the Login text", "Log in", Login,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				ATUReports.add("Verify the Login text", "Log in", Login,LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}

		//Click on log in button
		loginpage.getlogintext().click();

		//Clear the text in the Username text box if any.
		if (loginpage.getUserNametxtbx().getText().isEmpty()) {

		} else {
			loginpage.getUserNametxtbx().clear();
		}

		//Verify the Next button
		String next = loginpage.getNextButton().getText();
		
		if(next.isEmpty()){
			ATUReports.add("Verify the next is displayed in the screen", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		}else{
			if (next.equals("Next")) {
				ATUReports.add("Verify the next is displayed in the screen", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				ATUReports.add("Verify the next is displayed in the screen", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE) );
			}
		}	


		loginpage.getUserNametxtbx().sendKeys(" ");
		Thread.sleep(3000);
		//Get the user name placeholder text and verify
		String username_placeholder = loginpage.getUserNametxtbx().getText();
		System.out.println(username_placeholder);
		
		if( loginpage.getUserNametxtbx().isEnabled()){
			ATUReports.add("Enter space in user name etxt box","Enter space",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		}else{
			ATUReports.add("Space is not displayed in the user name screen",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE) );

		}

		
		loginpage.getNextButton().click();
		ATUReports.add("Tap on Next button",true);
		

		
		if (alertpage.getsignUpAlert()!=null) {
			if (alertpage.getsignUpAlert().isDisplayed()) {			
					String errortext = alertpage.getsignUpAlert().getText();									
							ATUReports.add("Invalid Username", "Invalid Username", errortext,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}else{
							ATUReports.add("Invalid Username alert is not displayed", "Invalid Username",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
			
			
			    if(alertpage.getyesButton()!=null){
				alertpage.getyesButton().click();
				Thread.sleep(2000);
				}else{
					ATUReports.add("alert is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
					
				
		} else {
			ATUReports.add("Alert message is not displayed", LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		
		
		       //Verify help icon 
		    if(loginpage.gethelpIcon()!=null){
			if(loginpage.gethelpIcon().isDisplayed()){
				ATUReports.add("Verify help icon in Login screen", "Help icon is displayed",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
				ATUReports.add("Clicked on Help icon in login screen",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				loginpage.gethelpIcon().click();
				Thread.sleep(4000);
				if(loginpage.getforgotUsernameHeading().isDisplayed()){
				
					ATUReports.add(loginpage.getforgotUsernameHeading().getText()+"Email verifcation screen"+loginpage.getforgotUsernameCaption().getText()+" is displayed",LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            System.out.println(loginpage.getforgotUsernameHeading().getText()+"Email verifcation screen"+loginpage.getforgotUsernameCaption().getText()+" is displayed");
				
              loginpage.getcrossIconHelpButton().click();
              ATUReports.add("Clicked on cross mark in email verification screen",LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
              Thread.sleep(1000);
				}else{
					ATUReports.add("Email verification screen is not displayed ",LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}else{
				ATUReports.add("Help icon is not displayed in Login screen",LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}else{
			ATUReports.add("Help icon is not displayed in Login screen",LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		
		    
		
		        //Verify the user name entered.
				String username_given = loginpage.getUserNametxtbx().getText();
			    System.out.println("Username entered"+username_given);

				if(username_given.isEmpty()){
					ATUReports.add("Verify the UserName is displayed in the screen", "xcube", username_given,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					if (username_given.equals(readUserData.sUserName)) {
						ATUReports.add("Verify the UserName is displayed in the screen", username_given,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}else{
						ATUReports.add("Verify the UserName is displayed in the screen", username_given,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE) );
					}
				}

		   //enter user name in the username text box
		   loginpage.getUserNametxtbx().sendKeys(readUserData.sUserName);
		   driver.hideKeyboard();
		   //ATUReports.add("Username entered in the text box","xcube", username_placeholder,LogAs.INFO,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


		
		
		//Verify the username entered.
		//String username_given = loginpage.getUserNametxtbx().getText();
	    System.out.println("Username entered"+username_given);

		if(username_given.isEmpty()){
			ATUReports.add("Verify the UserName is displayed in the screen", "xcube", username_given,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		}else{
			if (username_given.equals(readUserData.sUserName)) {
				ATUReports.add("Verify the UserName is displayed in the screen", "xcube", username_given,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				ATUReports.add("Verify the UserName is not displayed in the screen", username_given,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE) );
			}
		}
		//Log.info(username_given+"  : is displayed in the screen and the same is asserted");

		//Click on Next button
		Thread.sleep(6000);
		if (loginpage.getNextButton()!=null) {
			loginpage.getNextButton().click();
			ATUReports.add("Tap on Next button",true);

		} else {
			ATUReports.add("Next button element is not available ",true);

		}

		//Get the user name placeholder text and verify
		String password_placeholder = loginpage.getpasswordtxtbx().getText();
		

		if(password_placeholder.isEmpty()){
			ATUReports.add("Verify the Passowrd placeholder text is displayed in the screen", "Enter your password", password_placeholder,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		}else{
			if (password_placeholder.equals("Enter your password")) {
				ATUReports.add("Verify the Passowrd placeholder text is displayed in the screen", "Enter your password", password_placeholder,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				ATUReports.add("Verify the Passowrd placeholder text is displayed in the screen", password_placeholder,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE) );
			}
		}
		Log.info(username_placeholder+"  : is displayed in the screen and the same is asserted");

		//Verify the Next button in the password screen
		if(next.isEmpty()){
			ATUReports.add("Verify the next is displayed in the screen", "Next", next,LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		}else{
			if (next.equals("Next")) {
				ATUReports.add("Verify the next is displayed in the screen", "Next", next,LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}else{
				ATUReports.add("Verify the next is displayed in the screen", next,LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}

		//Log.info(next+"  : is displayed in the screen and the same is asserted");

		// enter password in the Password in the  text box
		loginpage.getpasswordtxtbx().sendKeys(readUserData.sPassword);
		ATUReports.add("password entered in the text box",true);
		driver.hideKeyboard();
		
		//Click on Next button
		loginpage.getNextButton().click();
		ATUReports.add("Tap on Next button",true);
		
		//Close pop up Alert_Page	alertpage
		alertpage.getcloseIcon().click();
		Thread.sleep(2000);
		
		}catch(Exception e){
			
		}
	}


}


















		/*// Using Touch Action Classes
		TouchAction tAction=new io.appium.java_client.TouchAction(driver)
		int startx = driver.findElement(By.name("Email")).getLocation().getX();
		int starty = driver.findElement(By.name("Email")).getLocation().getY();
		int endx = driver.findElement(By.name("Dev Settings")).getLocation().getX();
		int endy = driver.findElement(By.name("Dev Settings")).getLocation().getY();
		System.out.println(startx + " ::::::: " + starty + " ::::::: " + endx +  " ::::::: " +	endy);

		//First tap on the screen and swipe it right using moveTo function
		tAction.press(startx+20,starty+20).moveTo(endx+20,endy+20).release().perform(); 
		Thread.sleep(1000);

		//Second tap on the screen and swipe it left using moveTo function
		tAction.press(endx+20,endy+20).moveTo(startx+20,starty+20).release().perform();
		Thread.sleep(1000);*/







		//Get the size of the Table 
		//List<WebElement> elements = (List<WebElement>) driver.findElementByIosUIAutomation("UIAApplication()[1].UIAWindow()[1].tableViews()[1].cells()");
		//AppiumDriver driver1 = (AppiumDriver)driver;
		//List elements1 = (List) driver1.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell"));
		//System.out.println("The size of the table is :"+elements.size());


		//Log.endTestCase("Login test Case start");
		//System.out.println();







