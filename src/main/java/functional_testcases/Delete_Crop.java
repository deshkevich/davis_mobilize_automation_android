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
import utility.ReadUserData;

public class Delete_Crop {
	private AndroidDriver driver;
	private NewViewScreenPage newviewscreen;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private HomePage homepage;
	private Account_Page accountPage;
	private Alert_Page alertpage;


	@Test
	public void delete_crop() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		newviewscreen = new NewViewScreenPage(driver);
		new Alert_Page(driver);
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		new IrrigationPage(driver);
		//homepage = new HomePage(driver);
		accountPage=new Account_Page(driver);
		Thread.sleep(2000);
		alertpage =new Alert_Page(driver);
		Thread.sleep(2000);
		try {


			Thread.sleep(2000);
			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();


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
							Thread.sleep(3000);
							ATUReports.add(
									"verified the share icon in the : " + j
									+ " view displayed in the Home screen,Share icon is enabled in the screen ",
									LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							if (newviewscreen.getcropSettingsTitle() != null
									&& newviewscreen.getcropSettingsTitle().isDisplayed()) {
								if (newviewscreen.getcropSettingsTitle() != null
										&& newviewscreen.getcropSettingsIcon().isEnabled()) {
									ATUReports.add(
											newviewscreen.getcropSettingsTitle().getText()
											+ " Settings Title is is dispalyed",
											LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									break;							
								} else {
									ATUReports.add(
											newviewscreen.getcropSettingsTitle().getText()
											+ " Settings Title is not dispalyed",
											LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));					
								}	
							}else{
								
								driver.navigate().back();
								Thread.sleep(3000);
								ATUReports.add("Navigate back", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						
					
						
				
					} else {

						System.out.println("I am outside share ßicon else");

						// Click on home page back button
						driver.navigate().back();
						Thread.sleep(2000);
						ATUReports.add("Navigate back", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}

				}
							
					if (j ==4) {
						Thread.sleep(2000);
						  // scroll up the current page	 homeb page for all devices:		
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
			Thread.sleep(2000);


			String titleText = homepage.gettitleText().getText();
			MobileElement settings = newviewscreen.getcropSettingsIcon();
			if (settings.isEnabled()) {
				ATUReports.add("Crop Settings Icon is enabled Clicked on Settings Icon ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				settings.click();
				Thread.sleep(2000);
			} else {
				ATUReports.add("Crop Settings Icon  is Disabled", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			 // verify the Edit settings button. and Click on edit settings.
			MobileElement editsettings = newviewscreen.getfrostEditSettingsButton();
			if (editsettings != null) {
				if (editsettings.isDisplayed()) {
					ATUReports.add("Crop EditSettings Button is dispalyed and Clicked on edit settings.", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					editsettings.click();
					Thread.sleep(3000);
				} else {
					ATUReports.add("Crop EditSettings Button is not dispalyed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Verify user navigated to edit frost page.
			MobileElement cancelButton = homepage.getcancelButton();
			String editFrostTitle = homepage.gettitleText().getText();
			if (editFrostTitle != null) {
				if (editFrostTitle.contains("Edit Crop")) {
					ATUReports.add("User is navigated to 'Edit Crop' page. able to edit the Crop settings",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("User is not navigated to 'Edit Crop' page.", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Clicked on cancel button
			Thread.sleep(2000);
			cancelButton.click();
			Thread.sleep(2000);

			// Click on delete button
			MobileElement delete = homepage.getdeleteButton();
			if (delete != null) {
				if (delete.isDisplayed()) {
					ATUReports.add("Crop Delete Button is dispalyed and Clicked on delete button.", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					delete.click();
					Thread.sleep(7000);
				} else {
					ATUReports.add("Crop Delete Button is not dispalyed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// verify the alert message text
			String error = homepage.getfrostSettingsAlertMsg().getText();

			if (error.contains("Are you sure you want to delete crop from view " + titleText)) {
				ATUReports.add("The Alert messge is same as expected ", error,
						"Are you sure you want to delete crop from view " + titleText, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Alert is not displayed and the same is asserted ", error,
						"Are you sure you want to delete crop from view " + titleText, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// verify delete buttons	
			MobileElement deleteAlert = alertpage.getyesButton();
			String alertDeleteText = deleteAlert.getText();
			if (alertDeleteText.equals("Delete")) {
				ATUReports.add("Delete is displayed and Tab on " + alertDeleteText + " button", alertDeleteText,
						"Delete", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				deleteAlert.click();
				Thread.sleep(1000);
			} else {
				ATUReports.add("Delete button is not displayed and the same is asserted", alertDeleteText, "Delete",
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			// Verify view successfully deleted text on screen
			if(alertpage.getemailAlert().isDisplayed()){
				ATUReports.add("Alert is Displayed on Screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
				if(alertpage.getemailAlert().getText().contains("Crop deleted successfully")){
					ATUReports.add("Crop deleted successfully alert text is displayed on Screen", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Crop deleted successfully alert text is not displayed on Screen", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}else{
				ATUReports.add("Alert text is not displayed on Screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(1000);


			//click on ok 
			alertpage.getyesButton().click();
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


	//This method is used to navigate login page
	public void userLoginDetailsPage() throws InterruptedException{
		// enter name in the username text box
		MobileElement username = loginpage.getUserNametxtbx();
		if (username.isDisplayed()) {
			username.sendKeys(readUserData.sUserName);
			ATUReports.add("Enter user name in text box",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			driver.hideKeyboard();
		} else {
			driver.quit();
			return;
		}

		// Click on Next button
		clickonNextButton();
		ATUReports.add("Click on next buton in username page",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);

		// enter password in the Password in the text box
		MobileElement password = loginpage.getpasswordtxtbx();
		if (password.isDisplayed()) {
			loginpage.getpasswordtxtbx().click();
			Thread.sleep(200);
			password.sendKeys(readUserData.sPassword);
			ATUReports.add("Enter Password  in text box",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			driver.hideKeyboard();
			Thread.sleep(3000);

		} else {
			driver.quit();
			return;

		}

		// Click on Next button
		clickonNextButton();
		ATUReports.add("Click on next buton in password page",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(20000);

	}
}
