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

public class LoginPage {
	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public LoginPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		// System.out.println("From Constructor "+ driver);
	}

	private static MobileElement element = null;

	By logo = By.id("com.davis.mobilize:id/imageView");
	By logo_caption = By.name("By Davis Instruments");
	By signUptext = By.id("com.davis.mobilize:id/signUp");
	By logintext = By.id("com.davis.mobilize:id/login");
	By userNametxtbx = By.id("com.davis.mobilize:id/et_username");
	By nextButton = By.id("com.davis.mobilize:id/next");
	By passwordtxtbx = By.id("com.davis.mobilize:id/et_password");
    By loginButton=By.name("LoginSignUpScreen_LoginButton");//No mthd
    By helpIcon=By.id("com.davis.mobilize:id/credential");
    By forgotUsernameHeading=By.id("com.davis.mobilize:id/heading");
    By forgotUsernameCaption=By.id("com.davis.mobilize:id/subHeading");
    By crossIconHelpButton=By.id("com.davis.mobilize:id/confirm_cross_icon");
    
    
    
    public MobileElement getcrossIconHelpButton() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(crossIconHelpButton)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("crossIconHelpButton element is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Timed out : crossIconHelpButton element is not found in the screen", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
    
    public MobileElement getforgotUsernameCaption() throws InterruptedException {
    	try {
    		element = (MobileElement) ((new WebDriverWait(driver, 10))
    				.until(ExpectedConditions.presenceOfElementLocated(forgotUsernameCaption)));
    	} catch (NoSuchElementException e) {
    		ATUReports.add("forgotUsernameCaption element is not found in the screen ", LogAs.WARNING,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	} catch (TimeoutException te) {
    		ATUReports.add("Timed out : forgotUsernameCaption element is not found in the screen", LogAs.FAILED,
    				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    		return null;
    	}
    	return element;
    }
    
public MobileElement getforgotUsernameHeading() throws InterruptedException {
	try {
		element = (MobileElement) ((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(forgotUsernameHeading)));
	} catch (NoSuchElementException e) {
		ATUReports.add("forgotUsernameHeading element is not found in the screen ", LogAs.WARNING,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	} catch (TimeoutException te) {
		ATUReports.add("Timed out : forgotUsernameHeading element is not found in the screen", LogAs.FAILED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		return null;
	}
	return element;
}

    
    public MobileElement getloginButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(loginButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("loginButton element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : loginButton element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
    
    
    
    public MobileElement gethelpIcon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(helpIcon)));
		} catch (NoSuchElementException e) {
			ATUReports.add("helpIcon element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : helpIcon element is not found in the screen", LogAs.FAILED,
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

	public MobileElement getlogo_caption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(logo_caption)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Login Caption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Login Caption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getsignUptext() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(signUptext)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Sign up element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Sign up element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getlogintext() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(logintext)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Login element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Login element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getUserNametxtbx() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(userNametxtbx)));
		} catch (NoSuchElementException e) {
			ATUReports.add("UserName Text box element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : UserName Text box element is not found in the screen", LogAs.FAILED,
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
			ATUReports.add("Next button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Next button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getpasswordtxtbx() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(passwordtxtbx)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Password element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Password element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}
