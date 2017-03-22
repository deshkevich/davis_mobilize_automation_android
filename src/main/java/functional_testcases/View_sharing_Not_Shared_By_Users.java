
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
import utility.Log;
import utility.ReadUserData;

public class View_sharing_Not_Shared_By_Users {

	/**
	 * @throws InterruptedException
	 */
	private AndroidDriver driver;
	private HomePage homepage;
	private NewViewScreenPage newviewscreen;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private IrrigationPage irrigationPage;
	private Account_Page accountPage;

	@Test
	public void verifyViewSharing() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		newviewscreen = new NewViewScreenPage(driver);
		new Alert_Page(driver);
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		irrigationPage = new IrrigationPage(driver);
		new NewViewScreenPage(driver);
		new Pages.Settings_page(driver);		
		accountPage=new Account_Page(driver);
		Thread.sleep(2000);
		try {


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
					Thread.sleep(2000);
					ATUReports.add(
							"verified the share icon in the : " + j
									+ " view displayed in the Home screen,Share icon is enabled in the screen ",
							LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
					ATUReports.add("Share icon element is  visible in the screen and Tab on share Icon", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					newviewscreen.getshareIcon().click();
					Thread.sleep(3000);
					
			
						//Verify Make sure edit should be disabled state when users are not available to delete from list.
						MobileElement editButtonDisabled=homepage.getsaveNextButton();
						String EditText=editButtonDisabled.getText();	
						System.out.println(editButtonDisabled.isEnabled());
						if(editButtonDisabled.isEnabled()){
							driver.navigate().back();
							Thread.sleep(3000);
							driver.navigate().back();
							Thread.sleep(2000);
							ATUReports.add(EditText+ " Button is  in enabled  mode ",LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
														
					} else {
						Thread.sleep(2000);
						System.out.println("I am share icon inside else");
						ATUReports.add(EditText+ " Button is in disabled mode when users are not available to delete from list.",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						break;
					}
					
					
				} else {
					System.out.println("I am in else");

					// Click on home page back button
					driver.navigate().back();
					Thread.sleep(3000);
					driver.navigate().back();
					ATUReports.add("Shared view is not displayed  clicked on back", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					System.out.println("Shared view is displayed clicked on back");
					Thread.sleep(2000);
					
					Thread.sleep(1000);

				}//main
			
					}
					if (j == 4) {
						Thread.sleep(2000);
						  // scroll up the current page	 homepage		for all devices:		
						WebElement listElement =homepage.getviewsList();
						int xInitialList = listElement.getLocation().getX() + listElement.getSize().getWidth()/2;
						int yInitialList = listElement.getLocation().getY() + listElement.getSize().getHeight()/2;
						
						System.out.println("=startx "+xInitialList+" "+ yInitialList+"=end y  scroll down to  up the page");
						Thread.sleep(2000);
									
						//Swiping list based on coordinates
						if(yInitialList<=750){
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
			}//for

			
	

			// Verify user navigated to share view page
			MobileElement shareViewpage = homepage.getviewFrostSharingTitleHeading();
			String titleText = shareViewpage.getText();
			if (titleText.contains("SHARE "+homepage.gettitleText().getText()+" VIEW:")) {
				ATUReports.add("App navigated to share view screen. -" + titleText, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("App is not navigated to share view screen.- " + titleText, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			Thread.sleep(2000);
				
			//Click on Manage Account    				
			homepage.getAccountbtn().click();
			ATUReports.add("Clicked on account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			
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

		
		} catch (NullPointerException e) {
			System.out.println("The row element is not displayed");
			// ATUReports.add("First Table Row is not displayed",
			// LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE) );
			Log.error("Table Row is not dispalyed");
			e.printStackTrace();
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















































//This code is for future referecne



/*//Delete users list 	
WebElement tableviewtotalBox=homepage.getsharedUsersViewContainrList();
List<WebElement> tableview= tableviewtotalBox.findElements(By.className("android.widget.RelativeLayout"));//this is mandatory to give this path here becs this is not accepting in pages
System.out.println("Table view delete--------"+tableview.size());
int counter =1;
for (int i = 0; i < 1; ) {
	@SuppressWarnings("unchecked")
	List<WebElement> tableview1 = (List<WebElement>) tableview;
	WebElement inner = tableview1.get(i).findElement(By.id("com.davis.mobilize:id/full_name"));//this is mandatory to give this path here becs this is not accepting in pages
	//System.out.println(inner.getText()+" is the drop downs users text");
	ATUReports.add("Shared view users List is -"+inner.getText(),LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	tableview1.get(i).click();
	Thread.sleep(2000);
	ATUReports.add("Clicked on shared view Radio button of uers list-"+inner.getText(),LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

	//Click on delete button
	MobileElement deleteButton=homepage.getdeleteButton();
	String textOne=deleteButton.getText();
	if(deleteButton.isDisplayed()){
		deleteButton.click();
		Thread.sleep(2000);
		ATUReports.add("Clicked on "+textOne+" button ",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}else{
		ATUReports.add(textOne+" button is not displayed ",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		//return;
	}

	//Clicked on delete on pop up 
	MobileElement deleteButton2=homepage.getalertDelete();
	ATUReports.add("Clicked on "+deleteButton2.getText()+" button ",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	deleteButton2.click();
	Thread.sleep(4000);
	if (counter==tableview.size()) {
		break;
	}else{
		i=0;
		counter = counter+1;
		System.out.println("In else if Counter: "+counter);

	}

}*/




//----------


/*Thread.sleep(2000);
MobileElement alert=homepage.getviewSharingAlertText();
String text=alert.getText();
if (text.contains("No users found.")) {
	ATUReports.add("Alert mesage  is displayed with text - ", "No users found.",
			text, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
} else {

	ATUReports.add("Alert message text is not displayed ", " No users found.",homepage.getviewSharingAlertText().getText(),
			LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	return;
}*/



/*//Verify view is shared by user or not

WebElement tableviewSharedUsersList=  driver.findElement(By.className("android.widget.RelativeLayout"));
if(tableviewSharedUsersList.isDisplayed()){
	
	ATUReports.add("View is shared by user ",
			 LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	
}else{
	ATUReports.add("View is not shared by user ",
			 LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}*/

/*//Verify sharing view with: Text
MobileElement  sharingViewTextHeading=homepage.getsharingViewText();
String sharingUesrsViewHeadingText=sharingViewTextHeading.getText();
if(sharingUesrsViewHeadingText.equals("Sharing View with:")){
	ATUReports.add("Sharing view heading text is dislayed - "+sharingUesrsViewHeadingText,"Sharing View with:",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
}else{
	ATUReports.add("Sharing view heading text is not dislayed",LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
*/
