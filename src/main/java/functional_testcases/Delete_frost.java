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

public class Delete_frost {

	/**
	 * @throws InterruptedException
	 */
	private AndroidDriver driver;
	private NewViewScreenPage newviewscreen;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private HomePage homepage;
	@SuppressWarnings("unused")
	private Account_Page accountPage;
	@SuppressWarnings("unused")
	private Alert_Page alertpage;
	@Test
	public void delete_frost() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		homepage = new HomePage(driver);
		newviewscreen = new NewViewScreenPage(driver);
		new Alert_Page(driver);
		loginpage = new LoginPage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		new IrrigationPage(driver);
		accountPage=new Account_Page(driver);
		Thread.sleep(2000);
		alertpage =new Alert_Page(driver);
		try {

			
			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();
			Thread.sleep(2000);
			
			
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
					if (newviewscreen.getfrostSettingsTitle() != null
							&& newviewscreen.getfrostSettingsTitle().isDisplayed()) {
						if (newviewscreen.getfrostSettingsTitle() != null
								&& newviewscreen.getfrostSettingsIcon().isEnabled()) {
							ATUReports.add(
									newviewscreen.getfrostSettingsTitle().getText()
											+ " Settings Title is is dispalyed",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							break;
						} else {
							ATUReports.add(
									newviewscreen.getfrostSettingsTitle().getText()
											+ " Settings Title is not dispalyed",
									LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							//return;
						}
						

					} else {
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
					Thread.sleep(3000);
					ATUReports.add("Navigate back", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
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
			
			
			String titleText = homepage.gettitleText().getText();
			MobileElement settings = newviewscreen.getfrostSettingsIcon();
			if (settings.isEnabled()) {
				ATUReports.add("Frost Settings Icon is enabled Clicked on Settings Icon ", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				settings.click();
				Thread.sleep(4000);
			} else {
				ATUReports.add("Frost Settings Icon  is Disabled", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// // verify the Edit settings button. and Click on edit settings.
			MobileElement editsettings = newviewscreen.getfrostEditSettingsButton();
			if (editsettings != null) {
				if (editsettings.isDisplayed()) {
					ATUReports.add("Frost EditSettings Button is dispalyed and Clicked on edit settings.", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					editsettings.click();
					Thread.sleep(7000);
				} else {
					ATUReports.add("Frost EditSettings Button is not dispalyed", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}
		
			// Verify user navigated to edit frost page.
			MobileElement cancelButton = homepage.getcancelButton();
			String editFrostTitle = homepage.gettitleText().getText();
			System.out.println(editFrostTitle);
			if (editFrostTitle != null) {
				if (editFrostTitle.contains("Edit Frost")) {
					ATUReports.add("User is navigated to 'Edit Frost' page. able to edit the frost settings",
							LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				} else {
					ATUReports.add("User is not navigated to 'Edit Frost' page.", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}

			}

			            //Clicked on cancel button
						Thread.sleep(2000);
						cancelButton.click();
						Thread.sleep(4000);

						// Click on delete button
						MobileElement delete = homepage.getdeleteButton();
						if (delete != null) {
							if (delete.isDisplayed()) {
								ATUReports.add("Frost Delete Button is dispalyed and Clicked on delete button.", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								delete.click();
								Thread.sleep(7000);
							} else {
								ATUReports.add("Frost Delete Button is not dispalyed", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

						}

			// verify the alert message text
			String error = homepage.getfrostSettingsAlertMsg().getText();		
			if (error.contains("Are you sure you want to delete frost from view " + titleText)) {
				ATUReports.add("The Alert messge is same as expected", error,
						"Are you sure you want to delete frost from view " + titleText, LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Alert is not displayed and the same is asserted", error,
						"Are you sure you want to delete frost from view " + titleText, LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}

			         // verify delete buttons
						MobileElement deleteAlert = homepage.getalertDelete();
						String alertDeleteText = deleteAlert.getText();
						if (alertDeleteText.equals("Delete")) {
							ATUReports.add("Delete is displayed and Tab on " + alertDeleteText + " button", alertDeleteText,
									"Delete", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							deleteAlert.click();
							Thread.sleep(3000);
						} else {
							ATUReports.add("Delete button is not displayed and the same is asserted", alertDeleteText, "Delete",
									LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}

			// Verify view successfully deleted text on screen
			ATUReports.add("Report Successfully deleted. Text is Displayed on the Screen", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(3000);
			
			
			//click on ok 
			alertpage.getyesButton().click();
			Thread.sleep(3000);
			
			
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


/*

			/*
			//verify the views displayed
			MobileElement tableview = (MobileElement) driver.findElements(By.className("android.support.v7.widget.RecyclerView"));
			if (tableview!=null) {
			int size = tableview.findElementsByClassName("android.widget.RelativeLayout").size();
			System.out.println("The size"+size);
			if(size>=0){
				
				
				//android.widget.TextView[3]
			
			row = tableview.findElements(By.id("android.widget.TextView[3]")).get(size-2);
			row.click();
			ATUReports.add("Clicked the Row in the Table",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}*/
			
			
			//List<WebElement> table= driver.findElements(By.className("android.support.v7.widget.RecyclerView"));
	
			/*List <WebElement> viewList=driver.findElements(By.id("android.widget.TextView[3]"));
			System.out.println(viewList.size()+"----list size");
			for(int i=0;i<viewList.size();i++ ){
				String listText=viewList.get(i).getText();
				System.out.println(listText+"===list text ");

				if(listText.contains("Davis5")){

					System.out.println(listText+"list Davis5");
					break;

				}else{
					driver.swipe(345, 1025, 359, 180, 12000);
				}

			}
			Thread.sleep(12000);
*/
			
		/*	
			Thread.sleep(15000);
			WebElement tableview = (WebElement) driver.findElement(By.id("com.davis.mobilize:id/view_list1"));
			Thread.sleep(2000);
			WebElement elementsList1=(WebElement) tableview.findElement(By.id("com.davis.mobilize:id/homeScreen"));
			Thread.sleep(2000);
			WebElement elementList2=(WebElement)elementsList1.findElement(By.id("com.davis.mobilize:id/detailLayout"));
			Thread.sleep(2000);
			WebElement elementList3=(WebElement)elementList2.findElement(By.id("com.davis.mobilize:id/inside"));
			Thread.sleep(2000);
			
			List <WebElement> viewList1=elementList3.findElements(By.id(""
					+ ""
					+ "com.davis.mobilize:id/view_name"));
			System.out.println(viewList1.size()+"----ListSize---");
			for (int i=0; i<=viewList1.size();i++)
			{
				
			String listText=viewList1.get(i).getText();
			System.out.println(listText+"-----listText----");
			Thread.sleep(17000);
			if(listText.contains("Corn")){
				
				System.out.println(listText+"-----listText----");
				Thread.sleep(6000);
				viewList1.get(i).click();
				Thread.sleep(4000);
			}else{
		
			driver.swipe(345, 1025, 359, 180, 12000);
			
			Thread.sleep(25000);
			}
			}*/
			
			/*WebElement elementsList1=(WebElement) tableview.findElement(By.className("android.widget.RelativeLayout"));
			WebElement elementList2=(WebElement)elementsList1.findElement(By.className("android.widget.RelativeLayout"));
			WebElement elementList3=(WebElement)elementList2.findElement(By.className("android.widget.RelativeLayout"));*/
			
			
			//int size =  elementList3.findElements(By.className("android.widget.RelativeLayout")).size();
				/*String x = elementList3.findElement(By.xpath("//android.widget.TextView[@index='3']")).getText();
				System.out.println(x+"----x---");*/

				

				//WebElement e1=(WebElement) elementsList;
				
				//(driver, By.xpath("//android.widget.RelativeLayout[@index='8']"))
				/*if (e1.equals("")) {
					ATUReports.add();
					break;
				}
*/
			//System.out.println(webElement);





