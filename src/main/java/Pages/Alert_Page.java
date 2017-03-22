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

public class Alert_Page {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public Alert_Page(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		// System.out.println("From Constructor "+ driver);
	}

	private static MobileElement element = null;

	By addSymbol = By.id("com.davis.mobilize:id/newButton");
	By viewNameTextBox = By.id("com.davis.mobilize:id/enterViewNam");
	By addButton = By.id("com.davis.mobilize:id/nextButton");
    By emailAlert=By.id("android:id/message");     
    By loginpageInvalidPwdAlert=By.name("Error");
    By acceptAlert=By.id("android:id/button2");
    By locationPopUp=By.id("com.google.android.gms:id/message");
    
    By yesButton=By.id("android:id/button1");
    By closeIcon=By.id("com.davis.mobilize:id/close_icon"); 
 By withoutLocation=By.id("com.google.android.gms:id/message");
 By withLocationAllowBtn=By.id("com.android.packageinstaller:id/permission_allow_button");
   By withLocationUseLocationAlert=By.id("com.android.packageinstaller:id/desc_container");
  By withLctnAltMesge=By.id("com.android.packageinstaller:id/permission_message");
   By signUpAlert=By.id("android:id/alertTitle");
   
   
   
   public MobileElement getsignUpAlert(){
		  try {
		  	element = (MobileElement) ((new WebDriverWait(driver, 10))
		  			.until(ExpectedConditions.elementToBeClickable(signUpAlert)));

		  } catch (NoSuchElementException e) {
		  	ATUReports.add("signUpAlert element is not displayed", LogAs.FAILED,
		  			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  	return null;
		  } catch (TimeoutException e) {
		  	ATUReports.add("signUpAlert element is not displayed", LogAs.FAILED,
		  			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		  	return null;
		  }
		  return element;
		  }
	  
  
  public MobileElement getwithLctnAltMesge(){
	  try {
	  	element = (MobileElement) ((new WebDriverWait(driver, 10))
	  			.until(ExpectedConditions.elementToBeClickable(withLctnAltMesge)));

	  } catch (NoSuchElementException e) {
	  	ATUReports.add("withLctnAltMesge element is not displayed", LogAs.FAILED,
	  			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	  	return null;
	  } catch (TimeoutException e) {
	  	ATUReports.add("withLctnAltMesge element is not displayed", LogAs.FAILED,
	  			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	  	return null;
	  }
	  return element;
	  }
  
  
   public MobileElement getwithLocationUseLocationAlert(){
try {
	element = (MobileElement) ((new WebDriverWait(driver, 10))
			.until(ExpectedConditions.elementToBeClickable(withLocationUseLocationAlert)));

} catch (NoSuchElementException e) {
	ATUReports.add("withLocationUseLocationAlert element is not displayed", LogAs.FAILED,
			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	return null;
} catch (TimeoutException e) {
	ATUReports.add("withLocationUseLocationAlert element is not displayed", LogAs.FAILED,
			new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	return null;
}
return element;
}
    
		   
		   public MobileElement getwithLocationAllowBtn(){
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(withLocationAllowBtn)));

		} catch (NoSuchElementException e) {
			ATUReports.add("withLocationAllowBtn element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("withLocationAllowBtn element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
   
 public MobileElement getwithoutLocation(){
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(withoutLocation)));

		} catch (NoSuchElementException e) {
			ATUReports.add("withoutLocation element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("withoutLocation element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
 
    public MobileElement getcloseIcon(){
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(closeIcon)));

		} catch (NoSuchElementException e) {
			ATUReports.add("closeIcon element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("closeIconn element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
     public MobileElement getyesButton(){
    		try {
    			element = (MobileElement) ((new WebDriverWait(driver, 10))
    					.until(ExpectedConditions.elementToBeClickable(yesButton)));

    		} catch (NoSuchElementException e) {
    			ATUReports.add("yesButton element is not displayed", LogAs.FAILED,
    					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    			return null;
    		} catch (TimeoutException e) {
    			ATUReports.add("yesButton element is not displayed", LogAs.FAILED,
    					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    			return null;
    		}
    		return element;
    	}
     
    
    public MobileElement getlocationPopUp(){
   		try {
   			element = (MobileElement) ((new WebDriverWait(driver, 10))
   					.until(ExpectedConditions.elementToBeClickable(locationPopUp)));

   		} catch (NoSuchElementException e) {
   			ATUReports.add("locationPopUp element is not displayed", LogAs.FAILED,
   					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
   			return null;
   		} catch (TimeoutException e) {
   			ATUReports.add("locationPopUp element is not displayed", LogAs.FAILED,
   					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
   			return null;
   		}
   		return element;
   	}
    
     public MobileElement getacceptAlertt(){
   		try {
   			element = (MobileElement) ((new WebDriverWait(driver, 10))
   					.until(ExpectedConditions.elementToBeClickable(acceptAlert)));

   		} catch (NoSuchElementException e) {
   			ATUReports.add("acceptAlert element is not displayed", LogAs.FAILED,
   					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
   			return null;
   		} catch (TimeoutException e) {
   			ATUReports.add("acceptAlert element is not displayed", LogAs.FAILED,
   					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
   			return null;
   		}
   		return element;
   	}
     
  	public MobileElement getloginpageInvalidPwdAlert(){
  		try {
  			element = (MobileElement) ((new WebDriverWait(driver, 10))
  					.until(ExpectedConditions.elementToBeClickable(loginpageInvalidPwdAlert)));

  		} catch (NoSuchElementException e) {
  			ATUReports.add("loginpageInvalidPwdAlert element is not displayed", LogAs.FAILED,
  					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		} catch (TimeoutException e) {
  			ATUReports.add("loginpageInvalidPwdAlert element is not displayed", LogAs.FAILED,
  					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  			return null;
  		}
  		return element;
  	}
  	
     
     
     
 	public MobileElement getemailAlert(){
 		try {
 			element = (MobileElement) ((new WebDriverWait(driver, 10))
 					.until(ExpectedConditions.elementToBeClickable(emailAlert)));

 		} catch (NoSuchElementException e) {
 			ATUReports.add("emailAlert element is not displayed", LogAs.FAILED,
 					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		} catch (TimeoutException e) {
 			ATUReports.add("emailAlert element is not displayed", LogAs.FAILED,
 					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
 			return null;
 		}
 		return element;
 	}
 	
     
	public MobileElement getAddSymbol(){
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(addSymbol)));

		} catch (NoSuchElementException e) {
			ATUReports.add("Add symbol element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Add symbol element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getViewNameTextBox() {//throws InterruptedException {

		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(viewNameTextBox)));

		} catch (NoSuchElementException e) {
			ATUReports.add("view name text box element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("view name text box element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getAddButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(addButton)));

		} catch (NoSuchElementException e) {
			ATUReports.add("Add Button is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Add Button is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

}
