package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.ReadUserData;
import utility.Read_Delete_Viewname;

public class Verify_ViewName_Changes {
	private AndroidDriver driver;
	private HomePage homepage;
	private  LoginPage loginpage ;
	private NewViewScreenPage newviewscreen;
	private WebElement row;
	private  Read_Delete_Viewname readdeleteviewame;
	private ReadUserData readUserData;
	private IrrigationPage irrigationPage;
	private Account_Page accountPage;
	private Alert_Page alertpage;

	@Test
	public void verify_ViewName_Changes(){

		try{
			driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
			new WeatherPage(driver);
			homepage = new HomePage(driver);
			loginpage = new LoginPage(driver);
			newviewscreen = new NewViewScreenPage(driver);
			readdeleteviewame = new Read_Delete_Viewname();
			readdeleteviewame.start();
			readUserData=new ReadUserData();
			readUserData.start();
			irrigationPage = new IrrigationPage(driver);
			accountPage=new Account_Page(driver);
			Thread.sleep(2000);
			alertpage =new Alert_Page(driver);
			Thread.sleep(5000);
			
			// Calling precondition
			Precondition addClass = new Precondition();
			addClass.precondition();
			
			if (homepage.gettableview()!=null) {
				int size = homepage.gettableview().findElementsByClassName("android.widget.RelativeLayout").size();//this is mandatory to give this path here becs this is not accepting in pages
				System.out.println("The size"+size);
				for (int i=0;i<=size;i++){
					Thread.sleep(2000);			
					ATUReports.add("Clicked on the : "+i+" :Row in the Table",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					row = homepage.gettableview().findElementsByClassName("android.widget.RelativeLayout").get(i);//this is mandatory to give this path here becs this is not accepting in pages
					row.click();
					Thread.sleep(3000);
					
					// Verifying tutorial icon
					Thread.sleep(2000);
					Precondition.tutorialDisalogBox();

					
					if (newviewscreen.getshareIcon()!=null &&newviewscreen.getshareIcon().isEnabled() ) { 
						ATUReports.add("verified the share icon in the : "+i+" view displayed in the Home screen",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						break;
					}else{
						System.out.println("I am in else");
						
						//Click on home page back button
						irrigationPage.getcancelButton().click();
						Thread.sleep(2000);
						
					ATUReports.add("Navigated back to the home screen",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
				}
			}
			
			
			System.out.print("I am out of For loop");
			if (newviewscreen.getshareIcon()!=null) {
				//Scroll to Edit settings option
				//System.out.println("Screen displayed");
			
				
				Thread.sleep(3000);
				driver.scrollTo("Edit View");
				ATUReports.add("Scroll till the Edit View Button",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(3000);
				
				
				//Click on edit settings.
				MobileElement editView=homepage.geteditButton();
				editView.click();
				Thread.sleep(2000);	
				ATUReports.add("Clicked on Edit View Button",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}else{
					ATUReports.add("Share icon element is nt visible in the screen",LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
							
			//Enter/update the name with the new view name	
			//Clear the existing name
			MobileElement changeValuetxtBox=homepage.getchangeValueNameTxtBox();
			String textBoxText=changeValuetxtBox.getText();
			changeValuetxtBox.clear();
			Thread.sleep(2000);
			ATUReports.add("Cleared the existing view name",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
			//Enter the name read from the excel sheet
			changeValuetxtBox.sendKeys(readUserData.changeViewName);
			Thread.sleep(2000);
			ATUReports.add("Entered new View name is "+readUserData.changeViewName,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			driver.hideKeyboard();
			
			//Tap on save button
			driver.tap(1, (homepage.getsaveNextButton()), 1);
			ATUReports.add("Tap on save button",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));			
			Thread.sleep(5000);
		
			// Verify view successfully deleted text on screen
			System.out.println((alertpage.getemailAlert().getText()+"---(alertpage.getemailAlert().getText()--"));
			if(alertpage.getemailAlert().isDisplayed()){
				ATUReports.add("Alert is Displayed on Screen", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
				if(alertpage.getemailAlert().getText().contains("View name updated successfully")){
					ATUReports.add("View name updated successfully alert text is displayed on Screen", LogAs.PASSED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}else{
					ATUReports.add("View name updated successfully alert text is not displayed on Screen", LogAs.FAILED,
							new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				
			}else{
				ATUReports.add("Alert text is not displayed on Screen", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(1000);
		
			
			//click on ok 
			alertpage.getyesButton().click();
			Thread.sleep(3000);
			
			
			//Verify view name is changed with other name		
			MobileElement viewNameActual=homepage.gettitleText();
			String titleText=viewNameActual.getText();
			if(titleText.contains(readUserData.changeViewName)){
				ATUReports.add("View name is changed , Displayed actual text is same as expected and navigated to view details screen",titleText,readUserData.changeViewName,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}else{
				ATUReports.add("View name is not changed ,page is not navigated to view details screen", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			Thread.sleep(3000);
			
			

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
		
			
			      
			

		}catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		
		catch(WebDriverException e)
		{
			e.printStackTrace();
		}
		
		

		
		
	catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void clickonNextButton() throws InterruptedException
	{
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		}else{
			driver.quit();
		}
	}
}


/*List l = driver.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIACollectionCell"));
int count = l.size();
System.out.println("Size of the table "+count);
Thread.sleep(10000);
//search for the element exists in the first row
if (driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).isDisplayed()) {
	System.out.println("Table row Elemet is present in the screen");
} else {
	System.out.println("Table row Elemet is present in the screen");
}*/

//.tableViews()[0].cells().firstWithPredicate("name beginswith 'Page Control'")

/*driver.findElementByIosUIAutomation("tableViews()[0].cells().firstWithPredicate(\"staticTexts[0].label == DAVIS INSTRUMENTS\")").click();
driver.findElementByIosUIAutomation("tableViews()[0].cells().firstWithPredicate(\"name == DAVIS INSTRUMENTS\")").click();*/
// Click on the Add view button
//driver.scrollTo("NEW");
//((IOSDriver)driver).scrollToExact("WINE YARD");
//js.executeScript(arg0, arg1)