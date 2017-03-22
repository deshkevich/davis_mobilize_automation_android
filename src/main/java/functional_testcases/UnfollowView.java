package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.ReadUserData;
import utility.Read_Frost_Data;

import java.util.List;

public class UnfollowView {
	private AndroidDriver driver;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private HomePage homepage;
	private Account_Page accountPage;
	@SuppressWarnings("unused")
	private Dimension size;
	private IrrigationPage irrigation;
	private Alert_Page alertpage;

	@Test
	public void UnfollowView() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		new NewViewScreenPage(driver);
		irrigation = new IrrigationPage(driver);
		new Alert_Page(driver);
		loginpage = new LoginPage(driver);
		new NewViewScreenPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		new IrrigationPage(driver);
		homepage = new HomePage(driver);
		new FrostPage(driver);
		new Read_Frost_Data();
		new WeatherPage(driver);
		accountPage = new Account_Page(driver);
		alertpage =new Alert_Page(driver);
		Thread.sleep(2000);
		try {

			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();					
			Thread.sleep(9000);
			
			// Click on Account button
			if (homepage.getAccountbtn() != null) {
				ATUReports.add("Account button is found and clicking on Account button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				homepage.getAccountbtn().click();
				Thread.sleep(1000);
			} else {
				ATUReports.add("Account button element is not found unable to proceed further", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			// Verifying tutorial icon
			Thread.sleep(2000);
			Precondition.tutorialDisalogBox();

			// verify the settings icon and Click on settings
			if (accountPage.getsettings() != null) {
				ATUReports.add("Navigated to Settings screen, Settings icon is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Settings icon element is displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// verify the views is displayed
			if (accountPage.getviews() != null) {
				ATUReports.add("Views Tab is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				String views = accountPage.getviews().getText();
				//System.out.println(views + "---views---");
					ATUReports.add(views + " Tab is noticed in the screen and Clicked on-" + views + " Tab",
							"VIEWS", views,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					accountPage.getviews().click();
					Thread.sleep(1000);
					
				} else {
					ATUReports.add("Views Tab is not displayed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
	
			
			 // Click on Following
			// verify the following is displayed
			MobileElement following = accountPage.getfollowing();
			String subListText = following.getText();
			System.out.println(subListText + "---subListText---");
			if (subListText.contains("Following")) {
				ATUReports.add(subListText + " Text is displayed same as expected", "Following", subListText,
						LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				following.click();
				Thread.sleep(3000);
				System.out.println("Clicked on following ");
				Thread.sleep(1000);
			} else {
				ATUReports.add(subListText + " Text is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}		
			Thread.sleep(4000);   
			
			
			// Verify Swipe right/ Tap on view—Select unfollow icon.
			Thread.sleep(3000);
			MobileElement list = (MobileElement) driver.findElementById("com.davis.mobilize:id/recycler_view_common");//need to give path here
			if (list.isDisplayed()) {
				ATUReports.add("Users view list is displayed", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
                        //com.davis.mobilize:id/view_name_layout
				List<WebElement> tableview = driver.findElements(By.id("com.davis.mobilize:id/swipe"));//need to give path here
				System.out.println("Table view " + tableview.size());
				//com.davis.mobilize:id/view_name_layout

				//int counter = 1;
				for (int i = 0; i < tableview.size(); i++) {
					System.out.println("in loop");
					@SuppressWarnings("unchecked")
					List<WebElement> tableview1 = (List<WebElement>) tableview;
					System.out.println(tableview1.get(0).getText() + "  -----tableview1.get(0).getText()----");
					WebElement inner = tableview1.get(i).findElement(By.id("com.davis.mobilize:id/view_name"));//need to give path here

					String actualText = inner.getText();

					//System.out.println(actualText + "----text1---");
					System.out.println(inner.getText() + " is the drop downs users text");

					
					tableview1.get(i).click();
					Thread.sleep(2000);

					// Verifying tutorial icon
					Thread.sleep(2000);
					Precondition.tutorialDisalogBox();
					
					
					String titleText = accountPage.gettitleText().getText();
					Thread.sleep(2000);
					
		
					   driver.scrollTo("Unfollow View");
					   Thread.sleep(2000);
					   
					   MobileElement unfollowView= accountPage.getedtiview();
					   unfollowView.click();
					   Thread.sleep(2000);
						/// Verify to Observe Alert message
						
						String alertText = accountPage.getalertText().getText();
						System.out.println(alertText+"---alertText--");
						
                     
						if (alertText.contains("Are you sure you would like to unfollow this view?")) {
							ATUReports.add(alertText + "-is  displayed same as expected ", alertText, LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						} else {
							ATUReports.add(alertText + "-is not displayed same as expected ", alertText, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

						
						// Tab on delete
						MobileElement delete = irrigation.getpopUpContinue();
						String deleteText = delete.getText();
						if (deleteText.contains("Unfollow")) {
							ATUReports.add(
									deleteText + "- button is displayed same as expected  and Tab on -" + deleteText,
									deleteText, "Unfollow", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							delete.click();
							Thread.sleep(2000);

						} else {
							ATUReports.add(deleteText + "-is not displayed same as expected ", deleteText, LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
						
					
						
						//click on ok 
						alertpage.getyesButton().click();
						Thread.sleep(5000);
						

						// Verify sure view should be unfollowed from logged
						// in user.
						if (actualText.contains(titleText)) {
							ATUReports.add("view is unfollowed from logged in user.", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							break;

						} else {
							ATUReports.add("view is not unfollowed from logged in user.", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}

					

				}
				Thread.sleep(2000);

			} else {

				ATUReports.add("View list is not displayed", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				driver.swipe(221, 454, 221, 139, 3000);
			}
			Thread.sleep(2000);

			// Verify tab on delete button

		} catch (Exception e) {
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

























/*
 * //Get the size of screen. size = driver.manage().window().getSize();
 * System.out.println(size);
 * 
 * 
 * //Find swipe start and end point from screen's with and height. //Find startx
 * point which is at right side of screen. int startx = (int) (size.width *
 * 0.10); //Find endx point which is at left side of screen. int endx = (int)
 * (size.width * 0.70);
 * 
 * //Find vertical point where you wants to swipe. It is in middle of screen
 * height. int starty = size.height / 2; System.out.println("startx = " + startx
 * + " ,endx = " + endx + " , starty = " + starty);
 * 
 * //Swipe from Right to Left. driver.swipe(startx, starty, endx, starty, 3000);
 * Thread.sleep(2000);
 * 
 * //Swipe from Left to Right. driver.swipe(endx, starty, startx, starty, 3000);
 * Thread.sleep(2000); ATUReports.add("Swipe from Left to Right.", LogAs.PASSED,
 * new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 */
