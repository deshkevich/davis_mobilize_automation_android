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

public class IrrigationPage {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public IrrigationPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		System.out.println("From Constructor " + driver);
	}

	private static MobileElement element = null;
	By satutarionTitle = By.id("com.davis.mobilize:id/saturation_threshold");
	By saturationCaption = By.id("com.davis.mobilize:id/saturation_threshold_desc");
	By thresholdText = By.id("com.davis.mobilize:id/saturation");
	By saturationTextBox = By.id("com.davis.mobilize:id/et_saturation_threshold");
	By wiltingTitle = By.id("com.davis.mobilize:id/wilting_threshold");
	By highSalinityThresholdTxtBx = By.id("com.davis.mobilize:id/et_high_salinity_threshold");
	By soilSensorCaption = By.id("com.davis.mobilize:id/soil_moisture_sensor_desc");
	By soilSensorTitle = By.id("com.davis.mobilize:id/soil_moisture_sensor");
	By cancelbtn = By.id("com.davis.mobilize:id/back_icon");
	By skipbtn = By.id("com.davis.mobilize:id/nextButton");
	By editirrigationtxt = By.id("com.davis.mobilize:id/title");
	By optionaltxt = By.name("optional");
	By bodytxt = By.id("com.davis.mobilize:id/sensor_input_text");
	By titletxt = By.id("com.davis.mobilize:id/sensor_input");
	By togglebtnOptional= By.id("com.davis.mobilize:id/tb_soil_moisture_sensor");
	By devicestxt = By.id("com.davis.mobilize:id/device_soil");
	By sensortxt = By.id("com.davis.mobilize:id/sensor_soil");
	By pageindicator = By.className("android.widget.LinearLayout");
	By deviceDropDown =  By.name("xCube Gateway 1E");// By.name("Davis GroWeather, FARS"); 
	By sensorDropDown = By.id("com.davis.mobilize:id/tv_sensor_name");
	By wiltingCaption = By.id("com.davis.mobilize:id/wilting_threshold_desc");
	By wiltingTextBox = By.id("com.davis.mobilize:id/et_wilting_threshold");
	By wiltingThresholdText = By.id("com.davis.mobilize:id/wilting");
	By earlyWarngTitle = By.id("com.davis.mobilize:id/early_warning");
	By earlyWarngCaption = By.id("com.davis.mobilize:id/early_warning_desc");
	By earlyWarngTextBox = By.id("com.davis.mobilize:id/et_early_warning_threshold");
	By earlyWarnfThresholdText = By.id("com.davis.mobilize:id/near_wilting");
	By lowSanityTitle = By.id("com.davis.mobilize:id/low_salinity_heading");
	By lowSanityCaption = By.id("com.davis.mobilize:id/low_salinity_heading_desc");
	By lowSanityTextbox = By.id("com.davis.mobilize:id/et_low_salinity_threshold");
	By lowSanityThresholdText = By.id("com.davis.mobilize:id/low_salinity_text");
	By presureSensorTitle = By.id("com.davis.mobilize:id/pressure_sensor");
	By presureSensorCaption = By.id("com.davis.mobilize:id/pressure_sensor_desc");
	By presureSensoraDeviceDropdown = By.id("com.davis.mobilize:id/device_pressure");
	By presureSensorSensorDropdown = By.id("com.davis.mobilize:id/sensor_pressure");
	By highSanityTitle = By.id("com.davis.mobilize:id/high_salinity_heading");
	By highSalinityCaption = By.id("com.davis.mobilize:id/high_salinity_heading_desc");
	By flowMeterDeviceDropdown = By.id("com.davis.mobilize:id/device_flow");
	By flowMeterSensordropdown = By.id("com.davis.mobilize:id/sensor_flow");
	By flowBodyText = By.id("com.davis.mobilize:id/flow_meter_desc");
	By flowTitle = By.id("com.davis.mobilize:id/flow_meter");
	By etReadingTitle = By.id("com.davis.mobilize:id/et_reading");
	By etReadingCaption = By.id("com.davis.mobilize:id/et_reading_desc");
	By etDeviceDropDown = By.id("com.davis.mobilize:id/device_et");
	By etSensorDropDown = By.id("com.davis.mobilize:id/sensor_et");
	By cancelButton = By.id("com.davis.mobilize:id/back_icon");
	By popUpText=By.id("android:id/alertTitle");
	By PopUpBody=By.id("android:id/message");
	By popUpContinue=By.id("android:id/button1");
	By goBack=By.id("android:id/button2");
	By viewTextField=By.id("com.davis.mobilize:id/title");
	By saturationOptional=By.id("com.davis.mobilize:id/tb_saturation_threshold");
	By wiltingOptional=By.id("com.davis.mobilize:id/tb_wilting_threshold");
	By wiltingThresholdSlider=By.id("com.davis.mobilize:id/sb_wilting_threshold");
	By earlyFrostWraningOptional=By.id("com.davis.mobilize:id/early_warning_threshold");
	By earlyFrostSlider=By.id("com.davis.mobilize:id/sb_early_warning_threshold");
	By lowSalinityOptional=By.id("com.davis.mobilize:id/low_salinity");
	By highSalinityOptional=By.id("com.davis.mobilize:id/high_salinity");
	By presureSensorOptional=By.id("com.davis.mobilize:id/tb_pressure_sensor");
	By flowMeterOptional=By.id("com.davis.mobilize:id/tb_flow_meter");
	By etOptional=By.id("com.davis.mobilize:id/tb_et_reading");
	
	
	
	
	public MobileElement getetOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(etOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("etOptional element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : etOptional element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	

	public MobileElement getflowMeterOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(flowMeterOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("flowMeterOptional element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : flowMeterOptional element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getpresureSensorOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(presureSensorOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("presureSensorOptional element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : presureSensorOptional element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement gethighSalinityOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highSalinityOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highSalinityOptional element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highSalinityOptional element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getlowSalinityOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lowSalinityOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("lowSalinityOptional element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : lowSalinityOptional element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getearlyFrostSlider() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(earlyFrostSlider)));
		} catch (NoSuchElementException e) {
			ATUReports.add("earlyFrostSlider element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : earlyFrostSlider element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getearlyFrostWraningOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(earlyFrostWraningOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("earlyFrostWraning element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : earlyFrostWraning element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getwiltingThresholdSlider() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(wiltingThresholdSlider)));
		} catch (NoSuchElementException e) {
			ATUReports.add("wiltingThresholdSlider element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : wiltingThresholdSlider element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getwiltingOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(wiltingOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("wiltingOptional element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : wiltingOptional element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getsaturationOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(saturationOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("saturationOptional element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : saturationOptional element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getPopUpBody() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(PopUpBody)));
		} catch (NoSuchElementException e) {
			ATUReports.add("PopUpBody element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : PopUpBody element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getviewTextField() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(viewTextField)));
		} catch (NoSuchElementException e) {
			ATUReports.add("viewTextField element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : viewTextField element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getgoBack() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(goBack)));
		} catch (NoSuchElementException e) {
			ATUReports.add("goBack element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : goBack element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getpopUpContinue() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(popUpContinue)));
		} catch (NoSuchElementException e) {
			ATUReports.add("popUpContinue element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : popUpContinue element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getpopUpText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(popUpText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("popUpText element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : popUpText element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	

	public MobileElement gethighSalinityThresholdTxtBx() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highSalinityThresholdTxtBx)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highSalinityThresholdTxtBx element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highSalinityThresholdTxtBx element is not found in the screen", LogAs.FAILED,
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
			ATUReports.add("cancelButton element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : cancelButton element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getetSensorDropDown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(etSensorDropDown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("etSensorDropDown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : etSensorDropDown element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getetDeviceDropDown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(etDeviceDropDown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("etDeviceDropDown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : etDeviceDropDown element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getetReadingCaption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(etReadingCaption)));
		} catch (NoSuchElementException e) {
			ATUReports.add("etReadingCaption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : etReadingCaption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getetReadingTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(etReadingTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("etReadingTitle element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : etReadingTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getflowTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(flowTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("flowTitle element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : flowTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getflowBodyText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(flowBodyText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("flowBodyText element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : flowBodyText element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getflowMeterSensordropdown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(flowMeterSensordropdown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("flowMeterSensordropdown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : flowMeterSensordropdown element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getflowMeterDeviceDropdown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(flowMeterDeviceDropdown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("flowMeterDeviceDropdown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : flowMeterDeviceDropdown element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement gethighSalinityCaption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highSalinityCaption)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highSalinityCaption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highSalinityCaption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement gethighSanityTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highSanityTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highSanityTitle element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highSanityTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getpresureSensorSensorDropdown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(presureSensorSensorDropdown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("presureSensorSensorDropdown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : presureSensorSensorDropdown element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getpresureSensoraDeviceDropdown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(presureSensoraDeviceDropdown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("presureSensoraDeviceDropdown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : presureSensoraDeviceDropdown element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getpresureSensorCaption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(presureSensorCaption)));
		} catch (NoSuchElementException e) {
			ATUReports.add("presureSensorCaption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : presureSensorCaption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getpresureSensorTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(presureSensorTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("presureSensorTitle element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : presureSensorTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getlowSanityThresholdText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lowSanityThresholdText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("lowSanityThresholdText element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : lowSanityThresholdText element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getlowSanityTextbox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lowSanityTextbox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("lowSanityTextbox element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : lowSanityTextbox element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getlowSanityCaption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lowSanityCaption)));
		} catch (NoSuchElementException e) {
			ATUReports.add("lowSanityCaption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : lowSanityCaption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getlowSanityTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lowSanityTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("lowSanityTitle element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : lowSanityTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getearlyWarngCaption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(earlyWarngCaption)));
		} catch (NoSuchElementException e) {
			ATUReports.add("earlyWarngCaption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : earlyWarngCaption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement gearlyWarnfThresholdText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(earlyWarnfThresholdText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("earlyWarnfThresholdText element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : earlyWarnfThresholdText element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getearlyWarngTextBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(earlyWarngTextBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("erayWarngCaption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : erayWarngCaption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getearlyWarngTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(earlyWarngTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("earlyWarngTitle element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : earlyWarngTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getwiltingThresholdText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(wiltingThresholdText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("wiltingThresholdText element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : wiltingThresholdText element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getwiltingTextBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(wiltingTextBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("wiltingTextBox element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : wiltingTextBox element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getwiltingCaption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(wiltingCaption)));
		} catch (NoSuchElementException e) {
			ATUReports.add("wiltingCaption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : wiltingCaption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getwiltingTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(wiltingTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("wiltingTitle element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : wiltingTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getsaturationTextBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(saturationTextBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("saturationTextBox element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : saturationTextBox element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getthresholdText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(thresholdText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("thresholdText element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : thresholdText element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getsaturationCaption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(saturationCaption)));
		} catch (NoSuchElementException e) {
			ATUReports.add("saturationCaption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : saturationCaption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getsatutarionTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(satutarionTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("satutarionTitle element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : ssatutarionTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getsoilSensorCaption() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(soilSensorCaption)));
		} catch (NoSuchElementException e) {
			ATUReports.add("soilSensorCaption element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : soilSensorCaption element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getsoilSensorTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(soilSensorTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("soilSensorTitle element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : soilSensorTitle element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getdeviceDropDown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(deviceDropDown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Device DropDown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : DeviceDropDown element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getsensorDropDown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(sensorDropDown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Sensor DropDown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Sensor DropDown element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getskipbtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(skipbtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Skip element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Skip element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getEditirrigationtxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(editirrigationtxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Irrigation Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Irrigation Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getOptionaltxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(optionaltxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Optional Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Optional Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getBodytxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(bodytxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Body Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Body Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getTitletxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(titletxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Title Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Title Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement gettogglebtnOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(togglebtnOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("togglebtnOptional button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : togglebtnOptional button  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getDevicestxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(devicestxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Device  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Device element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSensortxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(sensortxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Sensor  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Sensor element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getPageindicator() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(pageindicator)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Pageindicator  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Pageindicator element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

}
