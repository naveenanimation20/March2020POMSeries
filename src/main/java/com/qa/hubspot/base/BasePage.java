package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utils.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author NaveenKhunteta
 *
 */
public class BasePage {

	WebDriver driver;
	public Properties prop;
	public ElementUtil elementUtil;

	/**
	 * this method is used to initialize the WebDriver on the basis of browser
	 * 
	 * @param browserName
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			ChromeOptions options = new ChromeOptions();
//	        options.addArguments("window-size=800,600");
//			DesiredCapabilities cap = DesiredCapabilities.chrome();
//	        cap.setCapability(ChromeOptions.CAPABILITY, options);
//			try {
//				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			}

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
//			DesiredCapabilities cap = DesiredCapabilities.firefox();
//			try {
//				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			}

		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}

		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

		return driver;

	}

	/**
	 * this method is used to initialize the properties from config.proeprties
	 * file
	 * 
	 * @return prop
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

}
