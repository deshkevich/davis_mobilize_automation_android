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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	WebDriver driver = TestAppiumDriver.getAppiumDriver();

	public SignUpPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	private static MobileElement element = null;

	By logo = By.id("com.davis.mobilize:id/imageView3");
	By logo_Caption = By.id("com.davis.mobilize:id/loginAccess");
	By signUp = By.id("com.davis.mobilize:id/signUp");
	By gmailTextBox = By.name("Enter your email");
	By nextButton = By.id("com.davis.mobilize:id/next");
	By signUpIcon = By.id("com.davis.mobilize:id/ctv_signup_icon");
	By backBtn = By.id("com.davis.mobilize:id/ctv_back_first_name");
	By skipBtn = By.id("com.davis.mobilize:id/tv_signup_skip");
	By nameTextBox = By.id("com.davis.mobilize:id/et_first_name");
	By nameNextButton = By.id("com.davis.mobilize:id/tv_first_name_next_button");
	By firstNameText = By.name("ENTER FIRST NAME");
	By lastNameText = By.name("ENTER LAST NAME");
	By lastNameTextBox = By.id("com.davis.mobilize:id/et_last_name");
	By ln_Next_btn = By.id("com.davis.mobilize:id/tv_last_name_next_button");
	By username_icon = By.id("com.davis.mobilize:id/ctv_signup_username_icon");
	By ur_text_box = By.id("com.davis.mobilize:id/et_user_name");
	By ur_Next_Btn = By.id("com.davis.mobilize:id/tv_user_name_next_button");
	By pwd_icon = By.id("com.davis.mobilize:id/ctv_signup_password_icon");
	By pwd_Text_Box = By.id("com.davis.mobilize:id/et_password");
	By pwd_Next_Button = By.id("com.davis.mobilize:id/tv_password_next_button");
	By confrm_pwd_icon = By.id("com.davis.mobilize:id/ctv_signup_confirm_password_icon");
	By confrm_pwd_Text = By.id("com.davis.mobilize:id/tv_confirm_password");
	By confrm_pwd_Text_Box = By.id("com.davis.mobilize:id/et_confirm_password");
	By cn_Next_Button = By.id("com.davis.mobilize:id/tv_confirm_password_next_button");
    By addPhoto=By.name("ADD PHOTO");
    By weekpwdText=By.id("com.davis.mobilize:id/tv_password");
    By usernameAlert=By.id("com.davis.mobilize:id/tv_alert_message_username");
    By pwdNtMatchingText=By.id("com.davis.mobilize:id/tv_confirm_password_alert");    
    By sighnUpMail=By.id("com.davis.mobilize:id/et_sign_up_email");
    By signUpCrossIcon=By.id("com.davis.mobilize:id/cross_icon");
    
    
    public MobileElement getsignUpCrossIcon() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(signUpCrossIcon)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("signUpCrossIcon element is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Timed out : signUpCrossIcon element is not found in the screen", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    public MobileElement getsighnUpMail() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(sighnUpMail)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("sighnUpMail element is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Timed out : sighnUpMail element is not found in the screen", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
      
      public MobileElement getpwdNtMatchingText() throws InterruptedException {
        	try {
        		element = (MobileElement) ((new WebDriverWait(driver, 10))
        				.until(ExpectedConditions.presenceOfElementLocated(pwdNtMatchingText)));
        	} catch (NoSuchElementException e) {
        		ATUReports.add("pwdNtMatchingText element is not found in the screen ", LogAs.WARNING,
        				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
        		return null;
        	} catch (TimeoutException te) {
        		ATUReports.add("Timed out : pwdNtMatchingText element is not found in the screen", LogAs.FAILED,
        				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
        		return null;
        	}
        	return element;
        }
      
      
      public MobileElement getusernameAlert() throws InterruptedException {
      	try {
      		element = (MobileElement) ((new WebDriverWait(driver, 10))
      				.until(ExpectedConditions.presenceOfElementLocated(usernameAlert)));
      	} catch (NoSuchElementException e) {
      		ATUReports.add("usernameAlert element is not found in the screen ", LogAs.WARNING,
      				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
      		return null;
      	} catch (TimeoutException te) {
      		ATUReports.add("Timed out : usernameAlert element is not found in the screen", LogAs.FAILED,
      				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
      		return null;
      	}
      	return element;
      }
    
    public MobileElement getweekpwdText() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(weekpwdText)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("weekpwdText element is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Timed out : weekpwdText element is not found in the screen", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    
   public MobileElement getaddPhoto() throws InterruptedException {
	try {
		element = (MobileElement) ((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(addPhoto)));
	} catch (NoSuchElementException e) {
		ATUReports.add("addPhoto element is not found in the screen ", LogAs.WARNING,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	} catch (TimeoutException te) {
		ATUReports.add("Timed out : addPhoto element is not found in the screen", LogAs.FAILED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	}
	return element;
}



	
	public MobileElement getpwd_Text_Box() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(pwd_Text_Box)));
		} catch (NoSuchElementException e) {
			ATUReports.add("pwd_Text_Box element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : pwd_Text_Box element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getlogo() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(logo)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Logo element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Logo element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getlogo_Caption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(logo_Caption)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Logo caption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Logo caption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSignUp() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(signUp)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Sign Up element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Sign Up element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getGmailTextBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(gmailTextBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Gmail text box element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Gmail text box element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getNextButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(nextButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Next button  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Next button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSignUpIcon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(signUpIcon)));
		} catch (NoSuchElementException e) {
			ATUReports.add("SignUp Icon element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : SignUp Icon element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getBackBtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(backBtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Back button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Back button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSkipBtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(skipBtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Skip button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Skip button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getNameTextBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(nameTextBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Name Text box element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Name Text box element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getNameNextButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(nameNextButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Name next Button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Name next Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getFirstNameText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(firstNameText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("First Name Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : First Name Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getLastNameText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lastNameText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Last name Text is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Last name Text is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getLastNameTextBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lastNameTextBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Last name Text box element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Last name Text box  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getLn_Next_btn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(ln_Next_btn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Last name next button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Last name next button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getUsername_icon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(username_icon)));
		} catch (NoSuchElementException e) {
			ATUReports.add("User name icon element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :User name icon element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getUr_text_box() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(ur_text_box)));
		} catch (NoSuchElementException e) {
			ATUReports.add("User text box  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :User text box element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getUr_Next_Btn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(ur_Next_Btn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("User Next button  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :User Next button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getPwd_icon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(pwd_icon)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Password icon  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Password icon element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement gePwd_Text_Box() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(pwd_Text_Box)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Password text box element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Password text box element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getPswd_Next_Button() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(pwd_Next_Button)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Password next button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Password next button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getConfrm_pwd_icon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(confrm_pwd_icon)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Conform password icon element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Conform password icon element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getConfrm_pwd_Text() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(confrm_pwd_Text)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Conform password text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Conform password text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getConfrm_pwd_Text_Box() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(confrm_pwd_Text_Box)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Conform password text box element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Conform password text box element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getCn_Next_Button() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cn_Next_Button)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Conform password next button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Conform password next button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

}
