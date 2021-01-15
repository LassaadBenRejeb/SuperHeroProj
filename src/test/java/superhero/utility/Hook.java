package superhero.utility;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindAll;


public class Hook {


	public static WebDriver driver;

	private final ConfigFileReader configFileReader = ConfigFileReader.get();
	private final String webSite = configFileReader.getPropertyValue("applicationUrl");
	private final String pathDriver = configFileReader.getPropertyValue("webdriver.chrome.path");






	public static WebDriver getDriver() {
		//driver=new ChromeDriver();
		return driver;
	}

	@Before
	public void setUp(cucumber.api.Scenario scenario) throws InterruptedException, AWTException {


		configFileReader.addConfig("config/config.properties");


		//if (driver == null ) {

			System.setProperty("webdriver.chrome.driver", pathDriver);

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setCapability("applicationCacheEnabled", false);
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			HashMap<String, Object> chromePerfs = new HashMap<>();
			chromePerfs.put("profile.default_content_settings.popups", 0);
			chromePerfs.put("intl.accept_languages", "fr");

			chromePerfs.put("download.prompt_for_download", false);

			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.setExperimentalOption("useAutomationExtension", false);
			//chromeOpt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			chromeOpt.setExperimentalOption("prefs", chromePerfs);
			
			chromeOpt.addArguments("--disable-extensions");


			
			//chromeOpt.addArguments("--incognito");

			driver = new ChromeDriver(chromeOpt);


			driver.manage().window().maximize();

			driver.get(webSite);
			driver.manage().deleteAllCookies();

			Thread.sleep(1000);

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


		//}
		driver.manage().deleteAllCookies();


		driver=getDriver();

	}




	@After
	public static void tearDown(cucumber.api.Scenario scenario) throws InterruptedException {




			 driver.close();
			 driver=null;




	}

}
