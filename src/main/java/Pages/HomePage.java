package Pages;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import functional_testcases.TestAppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public HomePage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		System.out.println("From Constructo " + driver);
	}

	private static MobileElement element = null;

	By searchtxtfield = By.id("com.davis.mobilize:id/ctv_search_cancel");
	// By locationiocn =
	// By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[1]");
	By homebutton = By.id("com.davis.mobilize:id/homeButton");
	By accountbtn = By.id("com.davis.mobilize:id/settingButton");
	By addbtn = By.id("com.davis.mobilize:id/newButton");
	By searchTextBox = By.id("com.davis.mobilize:id/search");
	By tableview =By.className("android.support.v7.widget.RecyclerView");
    By changeValueNameTxtBox=By.id("com.davis.mobilize:id/et_view_name");
    By saveNextButton=By.id("com.davis.mobilize:id/nextButton");
    By titleText=By.id("com.davis.mobilize:id/title");
    By editButton=By.id("com.davis.mobilize:id/editView");
   // By editButton=By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.Button[1]");
    By changeViewName=By.id("com.davis.mobilize:id/tv_change_view");
    By deleteButton=By.name("Delete");
    By deleteButtonAlertText=By.id("android:id/message");//android:id/message
    By alertcancel=By.id("android:id/button2");//android:id/button2
    By alertDelete=By.id("android:id/button1");//ndroid:id/button1
    By cancelButton=By.id("com.davis.mobilize:id/back_icon");
    By frsotSettingsAlertDelete=By.id("android:id/button2");
    By frostSettingsAlertMsg=By.id("android:id/message");
    //By viewSharingAlertText=By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.TextView[5]");
    By viewFrostSharingTitleHeading=By.id("com.davis.mobilize:id/tv_share_view_name");
    By viewFrostSharingSearchTxtBx=By.id("com.davis.mobilize:id/et_search");
    By viewsharingRadioButton=By.id("com.davis.mobilize:id/radio");
    By sharingViewText=By.id("com.davis.mobilize:id/tv_share_view_name");   
    By sharedUsersViewContainrList=By.id("com.davis.mobilize:id/recycler_share");
    By sharedViewUsersTableList=By.className("android.widget.RelativeLayout");
    By viewsList=By.id("com.davis.mobilize:id/view_list1");
    By  prefrencesFirstList=By.id("com.davis.mobilize:id/recycler_view_preferences");
	By tutorialCoseIcon=By.id("com.davis.mobilize:id/tv_close");   
	By tutorialNext1=By.id("com.davis.mobilize:id/tv_next");//com.davis.mobilize:id/tv_next
	By tutorialsOk=By.id("com.davis.mobilize:id/tv_next");
	By dialogBox=By.id("com.davis.mobilize:id/rl_dialog");
	By tutorialMessage=By.id("com.davis.mobilize:id/tv_message");
	
	
	
	public  MobileElement gettutorialMessage() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(tutorialMessage)));

		}catch(NoSuchElementException e){
			ATUReports.add("tutorialMessage  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("tutorialMessage  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public  MobileElement getdialogBox() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(dialogBox)));

		}catch(NoSuchElementException e){
			ATUReports.add("dialogBox  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("dialogBox  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public  MobileElement gettutorialsOk() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(tutorialsOk)));

		}catch(NoSuchElementException e){
			ATUReports.add("tutorialsOk  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("tutorialsOk  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public  MobileElement gettutorialNext1() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(tutorialNext1)));

		}catch(NoSuchElementException e){
			ATUReports.add("tutorialNext1  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("tutorialNext1  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	 public  MobileElement gettutorialCoseIcon() throws InterruptedException{
			try{
				element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(tutorialCoseIcon)));

			}catch(NoSuchElementException e){
				ATUReports.add("tutorialCoseIcon  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				return null;
			}catch(TimeoutException e){
				ATUReports.add("tutorialCoseIcon  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				return null;
			}
			return element;
		}
	 

   public  MobileElement getprefrencesFirstList() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(prefrencesFirstList)));

		}catch(NoSuchElementException e){
			ATUReports.add("prefrencesFirstList  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("prefrencesFirstList  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
    
    public  MobileElement getviewsList() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(viewsList)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("viewsList  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("viewsList  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    public  MobileElement getsharedViewUsersTableList() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(sharedViewUsersTableList)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("sharedViewUsersTableList  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("sharedViewUsersTableList  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    
    public  MobileElement getsharedUsersViewContainrList() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(sharedUsersViewContainrList)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("sharedUsersViewContainrList  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("sharedUsersViewContainrList element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
  
    
    
    
    public  MobileElement getsharingViewText() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(sharingViewText)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("sharingViewText  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("sharingViewText  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    public  MobileElement getviewsharingRadioButton() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(viewsharingRadioButton)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("viewsharingRadioButton  element is not displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("viewsharingRadioButton  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    
    public  MobileElement getviewFrostSharingSearchTxtBx() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(viewFrostSharingSearchTxtBx)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("viewFrostSharingSearchTxtBx  element is not displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("viewFrostSharingSearchTxtBx  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    
    public  MobileElement getviewFrostSharingTitleHeading() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(viewFrostSharingTitleHeading)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("viewFrostSharingTitleHeading  element is not displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("viewFrostSharingTitleHeading  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    
    
    /*public  MobileElement getviewSharingAlertText() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(viewSharingAlertText)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("viewSharingAlertText  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("viewSharingAlertText  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}*/
    
    
    
    public  MobileElement getfrostSettingsAlertMsg() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(frostSettingsAlertMsg)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("frostSettingsAlertMsg  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("frostSettingsAlertMsg  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    
    public  MobileElement getfrsotSettingsAlertDelete() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(frsotSettingsAlertDelete)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("frsotSettingsAlertDelete  element is not displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("frsotSettingsAlertDelete  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    
    public  MobileElement getcancelButton() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(cancelButton)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("cancelButton  element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("cancelButton  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    
    public  MobileElement getalertDelete() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(alertDelete)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("alertDelete  element is not displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("alertDelete  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    public  MobileElement getalertcancel() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(alertcancel)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("alertcancel  element is not displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("alertcancel  element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    public  MobileElement getdeleteButtonAlertText() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(deleteButtonAlertText)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("deleteButtonAlertText element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("deleteButtonAlertText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    public  MobileElement getdeleteButton() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(deleteButton)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("deleteButton element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("deleteButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    
    public  MobileElement getchangeViewName() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(changeViewName)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("ChangeViewName element is not displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("ChangeViewName element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    public  MobileElement geteditButton() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(editButton)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("editButton element is not displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("editButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    public  MobileElement gettitleText() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(titleText)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("titleText element is not  displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("titleText element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
    
    public  MobileElement getsaveNextButton() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(saveNextButton)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("saveNextButton element is not displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("saveNextButton element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
     
     public  MobileElement getchangeValueNameTxtBox() throws InterruptedException{
 		try{
 			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(changeValueNameTxtBox)));

 		}catch(NoSuchElementException e){
 			ATUReports.add("changeValueNameTxtBox element is not displayed", LogAs.WARNING,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}catch(TimeoutException e){
 			ATUReports.add("changeValueNameTxtBox element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
     
     
     public MobileElement gettableview() throws InterruptedException {
 		try {
 			element = (MobileElement) ((new WebDriverWait(driver, 10))
 					.until(ExpectedConditions.presenceOfElementLocated(tableview)));
 		} catch (NoSuchElementException e) {
 			ATUReports.add("tableview element is not found in the screen ", LogAs.WARNING,
 					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		} catch (TimeoutException te) {
 			ATUReports.add("Timed out :tableview element is not found in the screen", LogAs.FAILED,
 					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}

	/*public  MobileElement gettableview() throws InterruptedException{
		try{
			element  = (MobileElement) ((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(tableview)));

		}catch(NoSuchElementException e){
			ATUReports.add("TableView element is displayed", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}catch(TimeoutException e){
			ATUReports.add("TableView element is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/
	
	public MobileElement getSearchTextBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(searchTextBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Search Text box field element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Search Text box field element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSearchtxtfield() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(searchtxtfield)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Search Text field element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Search Text field element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getHomebutton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(homebutton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Home Button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Home Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getAccountbtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(accountbtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Account Button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Account Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getAddbtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(addbtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Add Button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Add Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}
