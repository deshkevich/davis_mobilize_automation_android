
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

public class Account_Page {
	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public Account_Page(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		// System.out.println("From Constructor "+ driver);
	}

	private static MobileElement element = null;
    
	By logoutAlertOk=By.id("android:id/button1");
	By title =By.name("CHANGE PASSWORD");
	By settings = By.id("com.davis.mobilize:id/shareIcon");
	By change_passwordheader = By.id("com.davis.mobilize:id/design_menu_item_text");
	By current_passwordplaceholder = By.id("com.davis.mobilize:id/et_password");
	By New_Password = By.id("com.davis.mobilize:id/et_password");
	By Confirm_Password = By.id("com.davis.mobilize:id/et_confirm_password");
	By save = By.id("com.davis.mobilize:id/nextButton");
	By Cancel =By.id("com.davis.mobilize:id/back_icon");	
	By editIcon=By.id("com.davis.mobilize:id/editButton");

	By editFirstName=By.id("com.davis.mobilize:id/et_name_heading");//com.davis.mobilize:id/et_name_heading
	By editEmail=By.id("com.davis.mobilize:id/email");
	By profilePicture=By.id("com.davis.mobilize:id/profile_pic_empty");
	By chooseFromLibrary=By.id("com.davis.mobilize:id/first_button");
	By alertText=By.id("android:id/message");
	By titleText=By.id("com.davis.mobilize:id/title");
	By viewUsersList=By.id("com.davis.mobilize:id/recycler_view_common");
	By viewUsersLayout=By.id("com.davis.mobilize:id/relativeLayout");
    By preferecnes=By.name("PREFERENCES");
    By views=By.name("VIEWS");
    By sharing=By.name("Sharing");
    By following=By.name("Following");
    By settingsLogoutBtn=By.name("Logout");
    By takePhotoButton=By.name("Take Photo");
    By cancelButtonInChangePhoto=By.name("Cancel");
    By edtiview=By.id("com.davis.mobilize:id/editView");
    
    
    public MobileElement getedtiview() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 15))
    				.until(ExpectedConditions.presenceOfElementLocated(edtiview)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("edtiview element is not displayed", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException e) {
    		ATUReports.add("edtiview element is not displayed", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    
    public MobileElement gettcancelButtonInChangePhoto() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 15))
    				.until(ExpectedConditions.presenceOfElementLocated(cancelButtonInChangePhoto)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("cancelButtonInChangePhoto element is not displayed", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException e) {
    		ATUReports.add("cancelButtonInChangePhoto element is not displayed", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    public MobileElement gettakePhotoButton() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 15))
    				.until(ExpectedConditions.presenceOfElementLocated(takePhotoButton)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("takePhotoButton element is not displayed", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException e) {
    		ATUReports.add("takePhotoButton element is not displayed", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    
    
    public MobileElement getsettingsLogoutBtn() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 15))
    				.until(ExpectedConditions.presenceOfElementLocated(settingsLogoutBtn)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("settingsLogoutBtn element is not displayed", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException e) {
    		ATUReports.add("settingsLogoutBtn element is not displayed", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    
    
    
    public MobileElement getlogoutAlertOk() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 15))
    				.until(ExpectedConditions.presenceOfElementLocated(logoutAlertOk)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("logoutAlertOk element is not displayed", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException e) {
    		ATUReports.add("logoutAlertOk element is not displayed", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
   
    public MobileElement getfollowing() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 15))
    				.until(ExpectedConditions.presenceOfElementLocated(following)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("following element is not displayed", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException e) {
    		ATUReports.add("following element is not displayed", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    
    
    public MobileElement getsharing() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 15))
    				.until(ExpectedConditions.presenceOfElementLocated(sharing)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("sharing element is not displayed", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException e) {
    		ATUReports.add("sharing element is not displayed", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    


public MobileElement getpreferecnes() throws InterruptedException {
	try {
		element = (MobileElement) ((new WebDriverWait(driver, 15))
				.until(ExpectedConditions.presenceOfElementLocated(preferecnes)));
	} catch (NoSuchElementException e) {
		ATUReports.add("preferecnes element is not displayed", LogAs.WARNING,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	} catch (TimeoutException e) {
		ATUReports.add("preferecnes element is not displayed", LogAs.FAILED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	}
	return element;
}
	
	
	public MobileElement getviewUsersLayout() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(viewUsersLayout)));
		} catch (NoSuchElementException e) {
			ATUReports.add("viewUsersLayout element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("viewUsersLayout element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getviewUsersList() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(viewUsersList)));
		} catch (NoSuchElementException e) {
			ATUReports.add("viewUsersList element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("viewUsersList element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public MobileElement gettitleText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(titleText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("titleText element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("titleText element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getalertText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(alertText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("alertText element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("alertText element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getchooseFromLibrary() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(chooseFromLibrary)));
		} catch (NoSuchElementException e) {
			ATUReports.add("chooseFromLibrary element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("chooseFromLibrary element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getprofilePicture() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(profilePicture)));
		} catch (NoSuchElementException e) {
			ATUReports.add("profilePicture element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("profilePicture element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement geteditEmail() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(editEmail)));
		} catch (NoSuchElementException e) {
			ATUReports.add("editEmail element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("editEmail element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement geteditFirstName() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(editFirstName)));
		} catch (NoSuchElementException e) {
			ATUReports.add("editFirstName element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("editFirstName element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement geteditIcon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(editIcon)));
		} catch (NoSuchElementException e) {
			ATUReports.add("editIcon element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("editIcon element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	

	/*public MobileElement getfirstname_lastname() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(firstname_lastname)));
		} catch (NoSuchElementException e) {
			ATUReports.add("First Name element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("First Name element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/

	/*public MobileElement getemailid() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(emailid)));
		} catch (NoSuchElementException e) {
			ATUReports.add("EmailID element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("EmailID element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/

	public MobileElement getviews() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(views)));
		} catch (NoSuchElementException e) {
			ATUReports.add("View element is not displayed", LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("View element is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	/*public MobileElement getrepair() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(repair)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Repair element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Repair element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}*/

	public MobileElement gettitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 15))
					.until(ExpectedConditions.presenceOfElementLocated(title)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Title element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Title element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	/*public MobileElement getalertview() throws InterruptedException {
		try {
			element = (MobileElement) driver.findElement(alertview);

		} catch (NoSuchElementException e) {
			ATUReports.add("Alert View element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Alert View element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
*/
	public MobileElement getsettings() throws InterruptedException {
		try {
			element = (MobileElement) driver.findElement(settings);

		} catch (NoSuchElementException e) {
			ATUReports.add("Settings element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Settings element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getchange_passwordheader() throws InterruptedException {
		try {
			element = (MobileElement) driver.findElement(change_passwordheader);

		} catch (NoSuchElementException e) {
			ATUReports.add("ChangePassword Header element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("ChangePassword Header element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getcurrent_passwordplaceholder() throws InterruptedException {
		try {
			element = (MobileElement) driver.findElement(current_passwordplaceholder);

		} catch (NoSuchElementException e) {
			ATUReports.add("CurrentPassword placeHolder element is not displayed", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("CurrentPassword placeHolder element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getNew_Password() throws InterruptedException {
		try {
			element = (MobileElement) driver.findElement(New_Password);

		} catch (NoSuchElementException e) {
			ATUReports.add("NewPassword element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("NewPassword element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getConfirm_Password() throws InterruptedException {
		try {
			element = (MobileElement) driver.findElement(Confirm_Password);

		} catch (NoSuchElementException e) {
			ATUReports.add("ConfirmPassword element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("ConfirmPassword element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getsave() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.elementToBeClickable(save)));

		} catch (NoSuchElementException e) {
			ATUReports.add("Save element is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Save element is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getCancel() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 5))
					.until(ExpectedConditions.elementToBeClickable(Cancel)));

		} catch (NoSuchElementException e) {
			ATUReports.add("Cancel element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException e) {
			ATUReports.add("Cancel element is not displayed", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}
