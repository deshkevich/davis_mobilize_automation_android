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

public class WeatherPage {

	AppiumDriver driver = TestAppiumDriver.getAppiumDriver();

	public WeatherPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		System.out.println("From Constructo " + driver);
	}
	
	
	private static MobileElement element = null;
	By temperatureBox=By.id("com.davis.mobilize:id/et_temp");
	By cancelbtn = By.id("com.davis.mobilize:id/back_icon");
	By next_nxt_save_btn = By.id("com.davis.mobilize:id/nextButton");
	By editWeather = By.id("com.davis.mobilize:id/title");
	By OptionalText=By.name("optional");
	By requiretxt = By.id("com.davis.mobilize:id/requiredText");
	By bodytxt = By.id("com.davis.mobilize:id/sensor_input_text");
	By titletxt = By.id("com.davis.mobilize:id/sensor_input");
	By togglebtn = By.id("com.davis.mobilize:id/sensorToggle");
	By stationtxt = By.id("com.davis.mobilize:id/device");
	By sensortxt = By.id("com.davis.mobilize:id/sensor");
	By pageindicator = By.className("android.widget.LinearLayout");
	By stationdropdown = By.id("com.davis.mobilize:id/name");
	By sensordropdown = By.id("com.davis.mobilize:id/tv_sensor_name");
	By mph = By.id("com.davis.mobilize:id/tv_avg_units");//com.davis.mobilize:id/tv_avg_units
	By knot=By.id("com.davis.mobilize:id/tv_high_wind_units");
	By thresoldswipe = By.id("com.davis.mobilize:id/sb_avg_threshold");
	By Average_wind_speed = By.id("com.davis.mobilize:id/averagewindtext");
	By AverageWindSpeedThreshold=By.id("com.davis.mobilize:id/wind_speed_threshold");
    By minuteTitle=By.id("com.davis.mobilize:id/ten_min_avg");
    By miniteAvgBody=By.id("com.davis.mobilize:id/ten_min_avg_desc");
    By wingAlertTitle=By.id("com.davis.mobilize:id/high_wind_alert");
    By windAlertBody=By.id("com.davis.mobilize:id/high_wind_alert_desc");
	By thresholdtxtfld = By.id("com.davis.mobilize:id/et_avg_threshold");
	By Wind_speed_threshold = By.id("com.davis.mobilize:id/wind_speed_threshold");
	By Daily_rain_threshold = By.id("com.davis.mobilize:id/daily_rain_threshold");
	By inches = By.id("com.davis.mobilize:id/tv_daily_rain_units");
	By Daiymm=By.id("com.davis.mobilize:id/tv_daily_rain_units");
	By Highmm=By.id("com.davis.mobilize:id/tv_high_rain_units");
	By High_rain_rate_threshold = By.id("com.davis.mobilize:id/high_rain_rate");
	By High_temperature = By.id("com.davis.mobilize:id/averagewindtext");
	By highThresholdText=By.id("com.davis.mobilize:id/high_temp");
	By dailyRainAlertTextBox=By.id("com.davis.mobilize:id/et_daily_rain_threshold");							
	By Low_temperature = By.id("com.davis.mobilize:id/low_temperature");
	By savebtntxt = By.id("com.davis.mobilize:id/saveButton");
	By dailyRainTitle=By.id("com.davis.mobilize:id/daily_rain");
	By dailyRainBody=By.id("com.davis.mobilize:id/daily_rain_desc");
	By highRainTitle=By.id("com.davis.mobilize:id/high_rain");
	By highRainBody=By.id("com.davis.mobilize:id/high_rain_desc");
	By highTempTilte=By.id("com.davis.mobilize:id/high_temp_alert");
	By highTempBody=By.id("com.davis.mobilize:id/high_temp_alert_desc");
	By lowTempTitle=By.id("com.davis.mobilize:id/low_temp");
	By lowTempBody=By.id("com.davis.mobilize:id/low_temp_desc");
	By highWindAlertTextBox=By.id("com.davis.mobilize:id/et_high_wind_alert");
	By highRainTextBox=By.id("com.davis.mobilize:id/et_high_rain_threshold");
	By highTempFUnits=By.id("com.davis.mobilize:id/tv_high_temp_units");
	By lowTempFUnits=By.id("com.davis.mobilize:id/tv_low_temp_units");	
	By lowTempTxtBox=By.id("com.davis.mobilize:id/et_low_temp");
	By highTemptxBox=By.id("com.davis.mobilize:id/et_high_temp");
	By frostThresholdSlider=By.id("com.davis.mobilize:id/sb_temp");
	By earlyFrostThresholdSlider=By.id("com.davis.mobilize:id/sb_early_temp");
	By avrgeOptional=By.id("com.davis.mobilize:id/tb_avg_alert");
	By highwndAlertOptional=By.id("com.davis.mobilize:id/tb_high_wind");
	By dailyRainAlrtOptional=By.id("com.davis.mobilize:id/tb_daily_rain_alert");
	By highRainRateArtOptional=By.id("com.davis.mobilize:id/tb_high_rain_alert");
	By highTemAlrtOptional=By.id("com.davis.mobilize:id/tb_high_temp_alert");
	By lowTemArtOptional=By.id("com.davis.mobilize:id/tb_low_temp_alert");
			
	
	
	public MobileElement getlowTemArtOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lowTemArtOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("lowTemArtOptional Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :lowTemArtOptional  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
			
		public MobileElement gethighTemAlrtOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highTemAlrtOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highTemAlrtOptional Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :highTemAlrtOptional  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement gethighRainRateArtOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highRainRateArtOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highRainRateArtOptional Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :highRainRateArtOptional  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getdailyRainAlrtOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(dailyRainAlrtOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("dailyRainAlrtOptional Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :dailyRainAlrtOptional  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement gethighwndAlertOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highwndAlertOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highwndAlertOptional Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :highwndAlertOptional  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getavrgeOptional() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(avrgeOptional)));
		} catch (NoSuchElementException e) {
			ATUReports.add("avrgeOptional Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :avrgeOptional  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getearlyFrostThresholdSlider() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(earlyFrostThresholdSlider)));
		} catch (NoSuchElementException e) {
			ATUReports.add("earlyFrostThresholdSlider Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :earlyFrostThresholdSlider  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getfrostThresholdSlider() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(frostThresholdSlider)));
		} catch (NoSuchElementException e) {
			ATUReports.add("frostThresholdSlider Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :frostThresholdSlider  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getlowTempTxtBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lowTempTxtBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("lowTempTxtBox Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : lowTempTxtBox  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement gethighTemptxBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highTemptxBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highTemptxBox Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highTemptxBox  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getlowTempFUnits() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lowTempFUnits)));
		} catch (NoSuchElementException e) {
			ATUReports.add("lowTempFUnits Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : lowTempFUnits  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement gethighTempFUnits() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highTempFUnits)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highTempFUnits Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highTempFUnits  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement gethighRainTextBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highRainTextBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highRainTextBox Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highRainTextBox  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getdailyRainAlertTextBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(dailyRainAlertTextBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("dailyRainAlertTextBox Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : dailyRainAlertTextBox  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement gethighWindAlertTextBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highWindAlertTextBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highWindAlertTextBox Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highWindAlertTextBox  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement gethighThresholdText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highThresholdText)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highThresholdText Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highThresholdText  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	
	public MobileElement getlowTempTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lowTempTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("lowTempTitle Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : lowTempTitle  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getlowTempBody() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(lowTempBody)));
		} catch (NoSuchElementException e) {
			ATUReports.add("lowTempBody Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : lowTempBody  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	public MobileElement gethighTempTilte() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highTempTilte)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highTempTilte Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highTempTilte  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement gethighTempBody() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highTempBody)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highTempBody Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highTempBody  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement gethighRainTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highRainTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highRainTitle Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highRainTitle  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement gethighRainBody() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(highRainBody)));
		} catch (NoSuchElementException e) {
			ATUReports.add("highRainBody Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : highRainBody  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	public MobileElement getdailyRainBody() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(dailyRainBody)));
		} catch (NoSuchElementException e) {
			ATUReports.add("dailyRainBody Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : dailyRainBody  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getdailyRainTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(dailyRainTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("dailyRainTitle Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : dailyRainTitle  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getwindAlertBody() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(windAlertBody)));
		} catch (NoSuchElementException e) {
			ATUReports.add("windAlertBody Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : windAlertBody  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getwingAlertTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(wingAlertTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("wingAlertTitle Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : wingAlertTitle  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	
	public MobileElement getminiteAvgBody() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(miniteAvgBody)));
		} catch (NoSuchElementException e) {
			ATUReports.add("miniteAvgBody Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : miniteAvgBody  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getminuteTitle() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(minuteTitle)));
		} catch (NoSuchElementException e) {
			ATUReports.add("minuteTitle Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : minuteTitle  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getDaiymm() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(Daiymm)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Daily rain units 'mm' Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Daily rain units 'mm Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	public MobileElement getHighmm() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(Highmm)));
		} catch (NoSuchElementException e) {
			ATUReports.add("High rain units 'mm' Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : High rain units 'mm Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getAverageWindSpeedThreshold() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(AverageWindSpeedThreshold)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Average Wind Speed Threshold Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Average Wind Speed Threshold Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getknot() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(knot)));
		} catch (NoSuchElementException e) {
			ATUReports.add("knot Units Text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : knot Units Text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	public MobileElement getOptionalText() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(OptionalText)));
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
	
	
	
	public MobileElement getTemperatureBox() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(temperatureBox)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Temperature Box element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Temperature Box element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	
	
	
	public MobileElement getCancelbtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(cancelbtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Cancel Button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Cancel Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}
	

	public MobileElement getNext_nxt_save_btnn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(next_nxt_save_btn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Next Button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out : Next Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getEditWeather() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(editWeather)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Edit Weather element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Edit Weather element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getRequiretxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(requiretxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("require text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :require text element is not found in the screen", LogAs.FAILED,
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
			ATUReports.add("Body text is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Body text is not found in the screen", LogAs.FAILED,
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
			ATUReports.add("Title text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Title text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getTogglebtn() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(togglebtn)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Toggle Button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Toggle Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getStationtxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(stationtxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("station element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :station element is not found in the screen", LogAs.FAILED,
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
			ATUReports.add("Sensor element is not found in the screen ", LogAs.WARNING,
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
			ATUReports.add("Pageindicator element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Pageindicator element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getStationdropdown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(stationdropdown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Station dropdown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Station dropdown  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSensordropdown() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(sensordropdown)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Sensor dropdown element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Sensor dropdown  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	

	public MobileElement getMph() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(mph)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Mph text element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Mph text  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getThresoldswipe() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(thresoldswipe)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Thresoldswipe element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Thresoldswipe  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getAverage_wind_speed() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(Average_wind_speed)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Average wind speed text  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Average wind speed text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getThresholdtxtfld() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(thresholdtxtfld)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Threshold text  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Threshold text element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getWind_speed_threshold() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(Wind_speed_threshold)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Wind speed threshold field  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Wind speed threshold field element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getDaily_rain_threshold() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(Daily_rain_threshold)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Daily rain threshold field  element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Daily rain threshold field element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getInches() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(inches)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Inches element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Inches  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getHigh_rain_rate_threshold() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(High_rain_rate_threshold)));
		} catch (NoSuchElementException e) {
			ATUReports.add("High rain rate threshold element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :High rain rate threshold  element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getHigh_temperature() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(High_temperature)));
		} catch (NoSuchElementException e) {
			ATUReports.add("High temperature element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :High temperature element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getLow_temperature() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(Low_temperature)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Low temperature element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Low temperature element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

	public MobileElement getSavebtntxt() throws InterruptedException {
		try {
			element = (MobileElement) ((new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(savebtntxt)));
		} catch (NoSuchElementException e) {
			ATUReports.add("Save Button element is not found in the screen ", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		} catch (TimeoutException te) {
			ATUReports.add("Timed out :Save Button element is not found in the screen", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return null;
		}
		return element;
	}

}
