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

public class NewViewScreenPage {
	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public NewViewScreenPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		// System.out.println("From Constructor "+ driver);
	}

	private static MobileElement element = null;

	
	By loacationMap = By.id("com.davis.mobilize:id/over_map");
	By editButton = By.id("com.davis.mobilize:id/editView");
	By dataDetails = By.id("com.davis.mobilize:id/footertext");
	By reportSubText = By.id("com.davis.mobilize:id/textView3");
	By reportText = By.id("com.davis.mobilize:id/reportText");
	By createButton = By.id("com.davis.mobilize:id/create_button");
	By shareIcon = By.id("com.davis.mobilize:id/shareIcon");
	By viewNameTitle = By.id("com.davis.mobilize:id/title");
	By cancelButton= By.id("com.davis.mobilize:id/back_icon");
	By viewlogo = By.id("com.davis.mobilize:id/home");
	By viewname = By.id("com.davis.mobilize:id/viewName");
	By view_txt_blw = By.id("com.davis.mobilize:id/viewDetails");
	By view_txtfld = By.id("com.davis.mobilize:id/et_view_name");
	By addbtn = By.id("com.davis.mobilize:id/nextButton");
	By map = By.id("com.davis.mobilize:id/mapClick");
	By frostSettingsTitle = By.id("com.davis.mobilize:id/frost_title");
	By frostSettingsIcon = By.id("com.davis.mobilize:id/frostHeadingNotes");
	By frostEditSettingsButton = By.id("com.davis.mobilize:id/editSettings");
	By cropSettingsTitle = By.id("com.davis.mobilize:id/cropHeading");
	By cropSettingsIcon = By.id("com.davis.mobilize:id/cropHeadingSettings");
	By weatherSettingsTitle = By.id("com.davis.mobilize:id/weatherHeading");
	By weatherSettingsIcon = By.id("com.davis.mobilize:id/weatherHeadingNote");
	By irrigtainSettingsTitle = By.id("com.davis.mobilize:id/irrigationHeading");
	By irrigationSettingsIcon = By.id("com.davis.mobilize:id/irrigationHeadingSettings");
	By gpsText=By.id("com.davis.mobilize:id/tv_add_gps_text");
	By allowPopBtn=By.id("com.android.packageinstaller:id/permission_allow_button");
	
	
	
	//mandatory xpaths 
	By iirigationSubTitle = By.xpath(
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[4]");
	By forstAddButton = By.xpath(
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
	By weatherAddButton = By.xpath(
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
	By cropAddButton = By.xpath(
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
	By irrigationTitle = By.xpath(
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");

	By cropSubTitle = By.xpath(
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[3]");
	By cropTitle = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
   By cropTitleElement=By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
	
   By weatherSubTitle = By.xpath(
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[4]");
	By weatherTitle = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
		
	By frostTitle = By.xpath(
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");

	By frostSubTitle = By.name("Keep alert of frost conditions");
	
    //frostSubTitle=By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[4]");
	
	By weatherElement=By.xpath("/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
	
	
	By frostElement=By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
		
	By cropElementView=By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
	//By weatherElement=By.xpath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[2]");
	
	
	
	public MobileElement getallowPopBtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(allowPopBtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("allowPopBtn element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: allowPopBtn element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getcropElementView() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropElementView)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropElementView element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: cropElementView element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getgpsText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(gpsText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("gpsText element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: gpsText element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public MobileElement getfrostElement() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostElement)));
		} catch (NoSuchElementException e) {
			ATUReports.add("frostElement element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: frostElement element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getweatherElement() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(weatherElement)));
		} catch (NoSuchElementException e) {
			ATUReports.add("weatherElement element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: weatherElement element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	

	public MobileElement getcropTitleElement() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropTitleElement)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropTitleElement element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: cropTitleElement element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getirrigationSettingsIcon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(irrigationSettingsIcon)));
		} catch (NoSuchElementException e) {
			ATUReports.add("irrigationSettingsIcon element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: irrigationSettingsIcon element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getirrigtainSettingsTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(irrigtainSettingsTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("irrigtainSettingsTitle element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: irrigtainSettingsTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getweatherSettingsIcon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(weatherSettingsIcon)));
		} catch (NoSuchElementException e) {
			ATUReports.add("weatherSettingsIcon element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: weatherSettingsIcon element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getweatherSettingsTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(weatherSettingsTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("weatherSettingsTitle element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: weatherSettingsTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getcropSettingsIcon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropSettingsIcon)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropSettingsIcon element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: cropSettingsIcon element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getcropSettingsTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropSettingsTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("cropSettingsTitle element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: cropSettingsTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getfrostEditSettingsButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostEditSettingsButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("frostEditSettingsButton element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: frostEditSettingsButton element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getfrostSettingsIcon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostSettingsIcon)));
		} catch (NoSuchElementException e) {
			ATUReports.add("frostSettingsIcon element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: frostSettingsIcon element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getfrostSettingsTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostSettingsTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("frostSettingsTitle element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: frostSettingsTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getirrigationTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(irrigationTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Irrigation Title element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: irrigation Title element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getiirigationSubTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(iirigationSubTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Irrigation Sub Title element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Irrigation Sub Title element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getcropAddButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropAddButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Crop Add Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Crop Add Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getweatherAddButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(weatherAddButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Weather Add Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Weather Add Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getforstAddButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(forstAddButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Forst Add Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Forst Add Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getcropTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Crop title element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Crop title element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getcropSubTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cropSubTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Crops sub title element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Crop sub title element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getweatherSubTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(weatherSubTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Weather sub title element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Weather sub title element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getweatherTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(weatherTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Weather Title element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Weather Title element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getfrostTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Frost  Title element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Frost Title element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getfrosSubtTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostSubTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Frost Sub Title element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Frost Sub Title element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getloactinMap() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(loacationMap)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Loacation Map element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Loacation Map element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement geteditButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(editButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Edit deatils button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Edit deatils button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getdataDetails() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(dataDetails)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Data deatils text element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Data deatils text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getreportSubText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(reportSubText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("View name report heading sub text element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: View name report heading sub text element is not found in the screen",
					LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getreportText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(reportText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("View name report heading Text element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: View name report heading Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getcreateButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(createButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Create Button(+) element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Create Button(+) element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getshareIcon() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(shareIcon)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Share icon element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out: Share icon element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getViewNameTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(viewNameTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("View Name Title element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out View Name Title element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getMap() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(map)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Add GPS information element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Add GPS information element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getcancelButton() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cancelButton)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Cancel Button element  is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Cancel Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getViewname() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(viewname)));
		} catch (NoSuchElementException e) {
			ATUReports.add("View name element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :View name element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getViewlogo() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(viewlogo)));
		} catch (NoSuchElementException e) {
			ATUReports.add("View logo element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :View logo element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getView_txt_blw() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(view_txt_blw)));
		} catch (NoSuchElementException e) {
			ATUReports.add("View text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :View text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getView_txtfld() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(view_txtfld)));
		} catch (NoSuchElementException e) {
			ATUReports.add("View text field element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :View text field element is not found in the screen", LogAs.FAILED,
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
			ATUReports.add("Add button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Add button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
}
