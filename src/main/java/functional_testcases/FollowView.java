package functional_testcases;

import Pages.*;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.ReadUserData;
import utility.Read_Frost_Data;

import java.util.List;

public class FollowView{

	private AndroidDriver driver;
	private LoginPage loginpage;
	private ReadUserData readUserData;
	private HomePage homepage;
	private FrostPage frostPage;
	private Account_Page accountPage;
     private Alert_Page	alertpage;
     private NewViewScreenPage newviewscreen;
	@Test
	public void followUnfollow() throws InterruptedException {

		driver = (AndroidDriver) TestAppiumDriver.getAppiumDriver();
		//homepage = new HomePage(driver);
		new NewViewScreenPage(driver);
		new Alert_Page(driver);
		//loginpage = new LoginPage(driver);
		new NewViewScreenPage(driver);
		//readUserData = new ReadUserData();
		//readUserData.start();
		new IrrigationPage(driver);
		//homepage = new HomePage(driver);
		frostPage = new FrostPage(driver);
		new Read_Frost_Data();
		new WeatherPage(driver);
		accountPage = new Account_Page(driver);
		alertpage=new  Alert_Page(driver);
		newviewscreen = new NewViewScreenPage(driver);
		loginpage = new LoginPage(driver);
		new ReadUserData();
		homepage = new HomePage(driver);
		readUserData = new ReadUserData();
		readUserData.start();
		alertpage = new Alert_Page(driver);
		ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(), "1.0");
		try {

			
			            // re launch the app
						Thread.sleep(20000);
						driver.resetApp();
						//Thread.sleep(10000);

						// enter name in the username text box
						MobileElement username = loginpage.getUserNametxtbx();
						if (username.isDisplayed()) {
							ATUReports.add("Mobilize user name is entered into user name textbox", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							System.out.println(readUserData.davisRoofId+"---userid--");
							username.sendKeys(readUserData.davisRoofId);
							driver.hideKeyboard();
						} else {
							driver.quit();
							return;
						}

						// Click on Next button
						clickonNextButton2();
						Thread.sleep(2000);

						// enter password in the Password in the text box

						MobileElement password = loginpage.getpasswordtxtbx();
						if (password.isDisplayed()) {
							loginpage.getpasswordtxtbx().click();
							Thread.sleep(200);
							ATUReports.add("Mobilize user password is entered into user password textbox", LogAs.PASSED,
									new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							System.out.println(readUserData.davisroofPwd+"---userid--");
							password.sendKeys(readUserData.davisroofPwd);
							driver.hideKeyboard();
							Thread.sleep(3000);

						} else {
							driver.quit();
							return;

						}
						
						// Click on Next button
						clickonNextButton2();
						Thread.sleep(20000);

						// Close pop up Alert_Page alert page
						ATUReports.add("Mobilize create view tutorial is displayed", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						Thread.sleep(2000);
						alertpage.getcloseIcon().click();
						Thread.sleep(10000);
						
						
						// Verifying tutorial icon-1
						if(homepage.getdialogBox()!=null){
							if(homepage.getdialogBox().isDisplayed()){
								String tutorialText=homepage.gettutorialMessage().getText();
								String tutorialButton=homepage.gettutorialNext1().getText();
								ATUReports.add("Mobilize tutorial dialog box "+tutorialText+ "is displayed in home page with  "+tutorialButton+" button", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
								Thread.sleep(2000);
								homepage.gettutorialCoseIcon().click();
								Thread.sleep(2000);
							}else{
								ATUReports.add("Mobilize tutorial dialog box is not displayed", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
							
							}else{
								ATUReports.add("Mobilize Notification tutorial dialog box in home page is not displayed", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
						
						
						// Verifying tutorial icon-2
						if(homepage.getdialogBox()!=null){
							if(homepage.getdialogBox().isDisplayed()){
								String tutorialText=homepage.gettutorialMessage().getText();
								String tutorialButton=homepage.gettutorialNext1().getText();
								ATUReports.add("Mobilize tutorial dialog box "+tutorialText+ "is displayed in home page with  "+tutorialButton+" button", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
								Thread.sleep(2000);
								homepage.gettutorialCoseIcon().click();
								Thread.sleep(2000);
							}else{
								ATUReports.add("Mobilize tutorial dialog box is not displayed", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
							
							}else{
								ATUReports.add("Mobilize Notification tutorial dialog box in home page is not displayed", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
					
						
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
								Thread.sleep(1000);
								ATUReports.add("verified the share icon in the : " +j+ " view displayed in the Home screen,Share icon is enabled in the screen ",
										LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								ATUReports.add("Share icon element is  visible in the screen and clicked on share Icon", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								newviewscreen.getshareIcon().click();
								Thread.sleep(3000);
                              break;
								
									
								} else {
									Thread.sleep(2000);
									System.out.println("I am share icon inside else");
									
									// Click on home page back button
									driver.navigate().back();
									Thread.sleep(3000);
									driver.navigate().back();
									System.out.println("Share icon element is not visible in the screen and Navigate back");
									System.out.println("Share icon is not displayed clicked on back");
									Thread.sleep(2000);
								}
							
								}
								if (j == 4) {
									Thread.sleep(5000);
									  // scroll up the current page	 homepage		for all devices:		
									WebElement listElement =homepage.getviewsList();
									int xInitialList = listElement.getLocation().getX() + listElement.getSize().getWidth()/2;
									int yInitialList = listElement.getLocation().getY() + listElement.getSize().getHeight()/2;
									
									System.out.println("=startx "+xInitialList+" "+ yInitialList+"=end y  scroll down to  up the page");
									Thread.sleep(2000);
												
									//Swiping list based on coordinates
									if(yInitialList<=750){
										driver.swipe(xInitialList, yInitialList, xInitialList, yInitialList-430, 5000);
										ATUReports.add("Swiping view list from bottom to top for shared view", LogAs.PASSED,
												new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										System.out.println("in 1st loop");
									}else{				
											if(yInitialList>=900){
												driver.swipe(xInitialList, yInitialList, xInitialList, yInitialList-730, 5000);
												ATUReports.add("Swiping view list from bottom to top for shared view", LogAs.PASSED,
														new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												System.out.println("in 2nd loop");
											}
										
									}
									
									j =1;
									Thread.sleep(2000);
									ATUReports.add("Scroll up the view list", LogAs.PASSED,
											new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

						}

						//Verify user navigated to share view page
						MobileElement shareViewpage=homepage.getviewFrostSharingTitleHeading();
						String titleText = shareViewpage.getText();
						if (titleText.contains("SHARE "+homepage.gettitleText().getText()+" VIEW:")) {
							ATUReports.add("App navigated to share view screen. -"+titleText,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}else{
							ATUReports.add("App is not navigated to share view screen.- "+titleText,LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
							
							//Verify to 'Enter last/ first name and username to search users'.
							MobileElement searchTextBox=homepage.getviewFrostSharingSearchTxtBx();
							
							if(searchTextBox.isDisplayed()){
								Thread.sleep(2000);
								//homepage.getviewFrostSharingSearchTxtBx().sendKeys(readUserData.search);	
								homepage.getviewFrostSharingSearchTxtBx().sendKeys("xcube");
								Thread.sleep(4000);			
								ATUReports.add("Name is entered in to search  text box. -"+searchTextBox.getText(),LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								driver.hideKeyboard();
							}else{
								ATUReports.add("Search text box is not displayed.- "+titleText,LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}



						    //Clicked on users view list 
							WebElement tableviewtotalBox3=homepage.getsharedUsersViewContainrList();
							List<WebElement> tableview3= tableviewtotalBox3.findElements(By.className("android.widget.RelativeLayout"));//this is mandatory to give this path here becs this is not accepting in pages
						
							for (int i = 0; i < tableview3.size(); i++) {
								@SuppressWarnings("unchecked")
								List<WebElement> tableview1 = (List<WebElement>) tableview3;
								WebElement inner = tableview1.get(i).findElement(By.id("com.davis.mobilize:id/user_name"));//this is mandatory to give this path here becs this is not accepting in pages
								String usersListText=tableview1.get(i).getText();
								System.out.println(usersListText+"usersListText");
								String pageViewTitle=homepage.gettitleText().getText();
								System.out.println("pop up"+pageViewTitle);
								if(usersListText.contains("xcube")){
									ATUReports.add("Expected Users text is not dispalyed and clicked on users text",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								tableview1.get(i).click();
								Thread.sleep(3000);
								break;
								/*}else{
									i=0;
									ATUReports.add("Expected Users text is not dispalyed ",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
								}
								
							
								//Verify pop up
								MobileElement  alertText=homepage.getdeleteButtonAlertText();
								Thread.sleep(3000);
								String actualText=alertText.getText();
								
								System.out.println("Send testtest invitation to share the view "+pageViewTitle+"?"+"--expected---");
								
								if(actualText.contains("Send testtest invitation to share the view "+pageViewTitle+" ?")){		
									ATUReports.add("Pop up displayed with text- "+actualText,LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
									Thread.sleep(3000);	
									
								/*	//Clicked on share button
									MobileElement  alertShareButton=homepage.getalertDelete();
									String shareBtnTxt=alertShareButton.getText();
									System.out.println(shareBtnTxt+"shareBtnTxt");
									ATUReports.add("Clicked on- "+shareBtnTxt+" button",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									alertShareButton.click();
									Thread.sleep(3000);*/
							
			
									
									
								}else{

									ATUReports.add("Pop up is not displayed with text- "+actualText,LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
								}
								
							

							Thread.sleep(15000);
							
							}
							/*		// Calling precondition-xcube user
							Precondition addClass = new Precondition();
							addClass.precondition();
							
							Thread.sleep(9000);
							
							// Click on Account button
							if (homepage.getAccountbtn() != null) {
								ATUReports.add("Account button is found and clicking on Account button", LogAs.PASSED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								homepage.getAccountbtn().click();
								Thread.sleep(2000);
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
								Thread.sleep(2000);
							} else {
								ATUReports.add("Settings icon element is not displayed", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

							// verify the views is displayed
							if (accountPage.getviews() != null) {
								ATUReports.add("Views Button is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								String views = accountPage.getviews().getText();

								//System.out.println(views + "---views---");
									ATUReports.add(views + " Button is noticed in the screen and Clicked on-" + views + " button",
											"VIEWS", views, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									accountPage.getviews().click();
									Thread.sleep(2000);
									
									// Verifying tutorial icon
									Thread.sleep(2000);
									Precondition.tutorialDisalogBox();
									
								} else {
									ATUReports.add("Views Button is not displayed", LogAs.FAILED,
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
											System.out.println("Clicked on following");
											Thread.sleep(1000);
										} else {
											ATUReports.add(subListText + " Text is not displayed", LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										}
										
																
							// Tap on any view from list.
							Thread.sleep(3000);
							MobileElement list = (MobileElement) driver.findElementById("com.davis.mobilize:id/recycler_view_common");
							if (list.isDisplayed()) {
								ATUReports.add("Users Folowing view list is displayed",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								List<WebElement> tableview = driver.findElements(By.id("com.davis.mobilize:id/swipe"));				
								//com.davis.mobilize:id/view_name_layout
								System.out.println("Table view " + tableview.size());
								for (int i = 0; i < tableview.size(); i++) {
									System.out.println("in loop");
									@SuppressWarnings("unchecked")
									List<WebElement> tableview1 = (List<WebElement>) tableview;
									WebElement inner = tableview1.get(i).findElement(By.id("com.davis.mobilize:id/view_name"));
									String actualText = inner.getText();
									//System.out.println(actualText + "----text1---");
									//System.out.println(inner.getText() + " is the drop downs users text");
							
										tableview1.get(i).click();
										ATUReports.add("User Folowing view list text  is displayed  and clicked on required Folowing view from list ",
												actualText, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										// Verifying tutorial icon
										Thread.sleep(2000);
										Precondition.tutorialDisalogBox();
										
										// Verify title text
										String titleText1 = accountPage.gettitleText().getText();
										if (actualText.contains(titleText1)) {
											ATUReports.add("User navigated to Folowing view details screen.", titleText1, LogAs.PASSED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} else {
											ATUReports.add("User not navigated to Folowing view details screen.", titleText1, LogAs.FAILED,
													new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											
											
										}
										break;				
								}
								
							} else {
								ATUReports.add("Folowing View list is not displayed", LogAs.FAILED,
										new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								Thread.sleep(2000);
								driver.swipe(221, 454, 221, 139, 3000);
							}
							
							accountPage.getCancel().click();
							Thread.sleep(2000);
							*/
							

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void clickonNextButton2() throws InterruptedException {
		MobileElement next = loginpage.getNextButton();
		if (next.isDisplayed()) {
			next.click();
		} else {
			driver.quit();
		}

	}
}
