package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.ReadUserData;
import utility.Read_Delete_Viewname;

public class Delete_View {
	private AndroidDriver driver;
	private Alert_Page alertpage;
	private LoginPage loginpage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreen;
	private WebElement row;
	private ReadUserData readUserData;
	private Read_Delete_Viewname readdeleteviewame;
	private IrrigationPage irrigationPage;
	private Account_Page accountPage;
	@Test
	public void delete_view() {

		try {
			driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
			loginpage = new LoginPage(driver);
			alertpage =new Alert_Page(driver);
			homepage = new HomePage(driver);
			newviewscreen = new NewViewScreenPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			new WeatherPage(driver);
			readdeleteviewame = new Read_Delete_Viewname();
			readdeleteviewame.start();
			irrigationPage = new IrrigationPage(driver);
			accountPage=new Account_Page(driver);
			Thread.sleep(2000);
					
			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();
					
			Thread.sleep(3000);
			// Verify to Click on particular view in list
			if (homepage.gettableview() != null) {
				int size = homepage.gettableview().findElementsByClassName("android.widget.RelativeLayout").size();
				System.out.println("The size" + size);
				for (int i = 0; i <= size; i++) {
					Thread.sleep(2000);
					ATUReports.add("Clicked on the : " + i + " :Row in the Table", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					row = homepage.gettableview().findElementsByClassName("android.widget.RelativeLayout").get(i);
					row.click();
					Thread.sleep(3000);
					
					if(homepage.getdialogBox()!=null){
						if(homepage.getdialogBox().isDisplayed()){
							String tutorialText=homepage.gettutorialMessage().getText();
							String tutorialButton=homepage.gettutorialNext1().getText();
							ATUReports.add("Mobilize tutorial dialog box "+tutorialText+ "is displayed with  "+tutorialButton+" button", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							Thread.sleep(2000);
							homepage.gettutorialCoseIcon().click();
							Thread.sleep(2000);
							
							if (newviewscreen.getshareIcon() != null && newviewscreen.getshareIcon().isEnabled()) {
								Thread.sleep(1000);
								ATUReports.add(
										"verified the share icon in the : " + i
												+ " view displayed in the Home screen,Share icon is enabled in the screen ",
										LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								break;
							} else {
								System.out.println("I am in else");
								// Click on home page back button
								irrigationPage.getcancelButton().click();
								Thread.sleep(1000);

							}
						}else{
							ATUReports.add("Mobilize tutorial dialog box is not displayed", LogAs.FAILED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						}
						}else{
							
							
							
					if (newviewscreen.getshareIcon() != null && newviewscreen.getshareIcon().isEnabled()) {
						Thread.sleep(1000);
						ATUReports.add(
								"verified the share icon in the : " + i
										+ " view displayed in the Home screen,Share icon is enabled in the screen ",
								LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						break;
					} else {
						System.out.println("I am in else");
						// Click on home page back button
						irrigationPage.getcancelButton().click();
						Thread.sleep(1000);

					}
						}//
				}
			}

			System.out.print("I am out of For loop");
			if (newviewscreen.getshareIcon() != null) {
				// Scroll to Edit settings option
				Thread.sleep(3000);
				driver.scrollTo("Edit View");
				ATUReports.add("Scroll till the Edit View Button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);

				// Click on edit settings.
				MobileElement editView = homepage.geteditButton();
				editView.click();
				Thread.sleep(2000);
				ATUReports.add("Clicked on Edit View Button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Share icon element is not visible in the screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify change view name text	
			Thread.sleep(2000);
			MobileElement changeViewNameText = homepage.getchangeViewName();
			String nameText = changeViewNameText.getText();

			if (nameText.contains("CHANGE VIEW NAME:")) {
				ATUReports.add("User is anvigated to CHANGE VIEW NAME screen ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				String alertViewName = homepage.getchangeValueNameTxtBox().getText();
				System.out.println(alertViewName + "alertViewName--");
				Thread.sleep(3000);

				// Tap on delete
				MobileElement delete = homepage.getdeleteButton();
				String deleteText = delete.getText();
				if (deleteText.contains("Delete")) {

					ATUReports.add("Tab on " + deleteText + " button", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					delete.click();
					Thread.sleep(3000);
				} else {
					ATUReports.add("Delete button is not dispayed in the screen", deleteText, "Delete", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				// verify the alert message text
				String error = homepage.getdeleteButtonAlertText().getText();

				if (error.contains("Are you sure you want to delete view " + alertViewName)) {
					ATUReports.add("Alert is displayed and the same is asserted", error,
							"Are you sure you want to delete view " + alertViewName, LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Alert is not displayed and the same is asserted", error,
							"Are you sure you want to delete view " + alertViewName, LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				// verify cancel buttons
				String cancel = homepage.getalertcancel().getText();
				if (cancel.equals("Cancel")) {
					ATUReports.add("Cancel is displayed and the same is asserted", cancel, "Cancel", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("Cancel is not displayed and the same is asserted", cancel, "Cancel", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}

				// verify delete buttons
				String alertDeleteText = homepage.getalertDelete().getText();
				if (alertDeleteText.equals("Delete")) {
					ATUReports.add("Delete is displayed and the same is asserted", alertDeleteText, "Delete",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Delete is not displayed and the same is asserted", alertDeleteText, "Delete",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				// Click on Cancel button
				MobileElement cancelButton = homepage.getalertcancel();
				if (cancel.contains("Cancel")) {
					ATUReports.add("Tab on " + cancel + " button", cancel, "Cancel", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					cancelButton.click();
					Thread.sleep(3000);
				} else {
					ATUReports.add(cancel + "Button is not displayed", cancel, "Cancel", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

				// Verify the WINE YARD is in Home screen or not
				if (nameText.contains("CHANGE VIEW NAME:")) {
					ATUReports.add("User is in the same CHANGE VIEW NAME screen ", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("User is not in the same CHANGE VIEW NAME screen ", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				Thread.sleep(3000);

				// Tap on Delete
				ATUReports.add("Tab on " + deleteText + " button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				delete.click();
				Thread.sleep(3000);

				// Tap on delete button
				MobileElement deleteAlert = homepage.getalertDelete();
				String alertDeleteButton = deleteAlert.getText();
				ATUReports.add("Tab on " + alertDeleteButton + " button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				deleteAlert.click();
				Thread.sleep(8000);

				// Verify view successfully deleted text on screen
				ATUReports.add("View Successfully deleted. Text is Displayed on Screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(1000);
				
				//click on ok 
				alertpage.getyesButton().click();
				Thread.sleep(3000);

				// Verify search icon in current home screen page
				MobileElement searchIcon = homepage.getSearchtxtfield();
				if (searchIcon.isDisplayed()) {
					Thread.sleep(4000);
					ATUReports.add("Search Icon is Displayed in Home Screen and View Successfully deleted.",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Search Icon is not Displayed in Home screen page", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				// verify the Add button
				if (homepage.getAddbtn().isDisplayed() || homepage.getAddbtn().isEnabled()) {
					ATUReports.add("Successfully created the screen setup and user navigated to home screen",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("Unable to create screen setup,user is not  navigated to home screen", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			} else {
				ATUReports.add("User is not navigated to CHANGE VIEW NAME screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			
		
			//Click on Manage Account    				
			homepage.getAccountbtn().click();
			ATUReports.add("Clicked on account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(4000);
			
			
			//Verifying tutorial icon
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

// future purpose

/*
 * Thread.sleep(15000); WebElement tableview = (WebElement)
 * driver.findElement(By.className("android.support.v7.widget.RecyclerView"));
 * Thread.sleep(2000); WebElement elementsList1=(WebElement)
 * tableview.findElement(By.className("android.widget.RelativeLayout"));
 * Thread.sleep(2000); WebElement
 * elementList2=(WebElement)elementsList1.findElement(By.className(
 * "android.widget.RelativeLayout")); Thread.sleep(2000); WebElement
 * elementList3=(WebElement)elementList2.findElement(By.className(
 * "android.widget.RelativeLayout")); Thread.sleep(2000);
 * 
 * List <WebElement>
 * viewList1=elementList3.findElements(By.className("android.widget.TextView[3]"
 * ));
 */

/*
 * List<WebElement> viewList1 = driver.findElements(By.xpath(
 * "//android.widget.LinearLayout[@resource-id='android:id/content']/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView[@index=‘3’]"
 * )); System.out.println(viewList1.size()+"----ListSize---"); for (int i=0;
 * i<=viewList1.size();i++) {
 * 
 * String listText=viewList1.get(i).getText();
 * System.out.println(viewList1+"-----listText----"); Thread.sleep(10000);
 * if(listText.contains("Todays")){
 * 
 * System.out.println(viewList1+"-----listText----"); Thread.sleep(6000);
 * viewList1.get(i).click(); Thread.sleep(4000); }else{
 * 
 * driver.swipe(345, 1025, 359, 180, 12000);
 * 
 * Thread.sleep(25000); } }
 */

/*
 * WebElement elementsList1=(WebElement)
 * tableview.findElement(By.className("android.widget.RelativeLayout"));
 * WebElement elementList2=(WebElement)elementsList1.findElement(By.className(
 * "android.widget.RelativeLayout")); WebElement
 * elementList3=(WebElement)elementList2.findElement(By.className(
 * "android.widget.RelativeLayout"));
 */
