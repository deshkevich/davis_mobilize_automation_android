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

public class Cancel_View {
	private AndroidDriver driver;
	private LoginPage loginpage;
	private HomePage homepage;
	private NewViewScreenPage newviewscreen;
	private WebElement row;
	private ReadUserData readUserData;
	private Read_Delete_Viewname readdeleteviewame;
	private IrrigationPage irrigationPage;
	private Account_Page accountPage;
	@Test
	public void cancel_View() {
		try {

			driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
			loginpage = new LoginPage(driver);
			homepage = new HomePage(driver);
			newviewscreen = new NewViewScreenPage(driver);
			readUserData = new ReadUserData();
			readUserData.start();
			new WeatherPage(driver);
			readdeleteviewame = new Read_Delete_Viewname();
			readdeleteviewame.start();
			irrigationPage = new IrrigationPage(driver);
			Thread.sleep(2000);
			accountPage=new Account_Page(driver);
			Thread.sleep(2000);
			
			
			
			 // Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();
			
			// Verifying tutorial icon
			Thread.sleep(2000);
			Precondition.tutorialDisalogBox();

			
			Thread.sleep(3000);
			// Verify to Click on particular view in list
			if (homepage.gettableview() != null) {
				int size = homepage.gettableview().findElementsByClassName("android.widget.RelativeLayout").size();//its mandatory to mention this path here
				System.out.println("The size" + size);
				for (int i = 0; i <= size; i++) {
					Thread.sleep(2000);
					ATUReports.add("Clicked on the : " + i + " :Row in the Table", LogAs.INFO,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					row = homepage.gettableview().findElementsByClassName("android.widget.RelativeLayout").get(i);//its mandatory to mention this path here
					row.click();
					Thread.sleep(3000);
					
					// Verifying tutorial icon
					Thread.sleep(2000);
					Precondition.tutorialDisalogBox();
					Thread.sleep(3000);
					
					if (newviewscreen.getshareIcon() != null) {
						if(newviewscreen.getshareIcon().isEnabled()){
						Thread.sleep(2000);
						ATUReports.add(
								"verified the share icon in the : " + i
										+ " view displayed in the Home screen,Share icon is enabled in the screen ",
								LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						break;
						}else{
							ATUReports.add(
									"verified the share icon in the Share icon is not enabled in the screen ",
									LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					} else {
						System.out.println("I am in else");
						// Click on home page back button
						irrigationPage.getcancelButton().click();
						Thread.sleep(1000);

					}
				}
			}

			System.out.print("I am out of For loop");
			if (newviewscreen.getshareIcon() != null) {

				// Scroll to Edit settings option
				Thread.sleep(6000);
				driver.scrollTo("Edit View");
				ATUReports.add("Scroll till the Edit View Button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(6000);

				// Click on edit settings.
				MobileElement editView = homepage.geteditButton();
				editView.click();
				Thread.sleep(5000);
				ATUReports.add("Clicked on Edit View Button", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Share icon element is not visible in the screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// Verify change view name text
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
				if (error.contains("Are you sure you want to delete view "+ alertViewName)) {
					ATUReports.add("Alert is displayed and the same is asserted", error,
							"Are you sure you want to delete view "+ alertViewName, LogAs.PASSED,
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

				// Verify the CHANGE VIEW NAME is displayed or not
				if (nameText.contains("CHANGE VIEW NAME")) {
					ATUReports.add("View Name screen is not deleted after Tab on cancel button -"+alertViewName,"User is in the same CHANGE VIEW NAME screen",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} else {
					ATUReports.add("User is not in the same CHANGE VIEW NAME screen,View Name screen is deleted ",
							LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				Thread.sleep(3000);

			} else {
				ATUReports.add("User is not navigated to CHANGE VIEW NAME screen ", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
			
			
/*
			//Click on Manage Account    				
			homepage.getAccountbtn().click();
			ATUReports.add("Clicked on account Tab",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(4000);
			
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
			ATUReports.add("Click ok button",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
			

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
