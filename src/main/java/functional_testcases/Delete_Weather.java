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

public class Delete_Weather {
	private AndroidDriver driver;
	private NewViewScreenPage newviewscreen;
	private LoginPage loginpage;
	//private NewViewScreenPage newscreenpage;
	private ReadUserData readUserData;
	private HomePage homepage;
	private Alert_Page alertpage;
	@Test
	public void delete_weather() throws InterruptedException {

		try {
			

			driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
			homepage = new HomePage(driver);
			newviewscreen = new NewViewScreenPage(driver);
			new Alert_Page(driver);
			loginpage = new LoginPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			new IrrigationPage(driver);
			alertpage =new Alert_Page(driver);
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
				
				//close tutorial screen in report views list page
				Thread.sleep(6000);			
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
					if (newviewscreen.getweatherSettingsTitle()!= null
							&& newviewscreen.getweatherSettingsTitle().isDisplayed()) {
						if (newviewscreen.getweatherSettingsTitle()!= null
								&& newviewscreen.getweatherSettingsIcon().isEnabled()) {
							ATUReports.add(
									newviewscreen.getweatherSettingsTitle().getText() + " Settings Title is is dispalyed",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							break;
						} else {
							ATUReports.add(
									newviewscreen.getweatherSettingsTitle().getText()
											+ " Settings Title is not dispalyed",
									LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							return;
						}

					} else {
						Thread.sleep(2000);
						System.out.println("I am share icon inside else");
						// Click on home page back button
						driver.navigate().back();
						Thread.sleep(2000);
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
			Thread.sleep(3000);		
			
			
			String titleText = homepage.gettitleText().getText();
			MobileElement settings = newviewscreen.getweatherSettingsIcon();
			if (settings.isEnabled()) {
				ATUReports.add("Weather Settings Icon is enabled Clicked on Settings Icon ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				settings.click();
				Thread.sleep(3000);
			} else {
				ATUReports.add("Weather Settings Icon  is Disabled", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			
			// verify the Edit settings button. and Click on edit settings.
			MobileElement editsettings = newviewscreen.getfrostEditSettingsButton();
			if (editsettings != null) {
				if (editsettings.isDisplayed()) {
					ATUReports.add("Weather EditSettings Button is dispalyed and Clicked on edit settings.", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					editsettings.click();
					Thread.sleep(3000);
				} else {
					ATUReports.add("Weather EditSettings Button is not dispalyed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// Verify user navigated to edit frost page.
			MobileElement cancelButton = homepage.getcancelButton();
			String editWeatherTitle = homepage.gettitleText().getText();
			System.out.println(editWeatherTitle+"--editFrostTitle--");
			if (editWeatherTitle != null) {
				if (editWeatherTitle.contains("Edit Weather")) {
					ATUReports.add("User is navigated to 'Edit Frost' page. able to Edit Weather settings",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("User is not navigated to 'Edit Weather' page.", LogAs.FAILED,
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
					ATUReports.add("Weather Delete Button is dispalyed and Clicked on delete button.", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					delete.click();
					Thread.sleep(7000);
				} else {
					ATUReports.add("Weather Delete Button is not dispalyed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			// verify the alert message text
			String error = homepage.getfrostSettingsAlertMsg().getText();		
			if (error.contains("Are you sure you want to delete weather from view " + titleText)) {
				ATUReports.add("The Alert messge is same as expected", error,
						"Are you sure you want to delete weather from view " + titleText, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {          //Are you sure you want to delete crop from view 
				ATUReports.add("Alert is not displayed and the same is asserted", error,
						"Are you sure you want to delete weather from view " + titleText, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// verify delete buttons
			MobileElement deleteAlert = homepage.getdeleteButton();
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
				if(alertpage.getemailAlert().getText().contains("Weather deleted successfully")){
					ATUReports.add("Weather deleted successfully alert text is displayed on Screen", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("Weather deleted successfully alert text is not displayed on Screen", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}			
			}else{
				ATUReports.add("Alert text is not displayed on Screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(3000);
			
			
			//click on ok 
			alertpage.getyesButton().click();
			Thread.sleep(5000);
			// Verify view successfully deleted text on screen

			ATUReports.add("Report Successfully deleted. Text is Displayed on the Screen", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(3000);

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
	
	
	
	  
}
