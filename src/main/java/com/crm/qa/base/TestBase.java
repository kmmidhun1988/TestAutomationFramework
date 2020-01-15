package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.EventListener;
import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver ef_driver;
	public static EventListener eventListner;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip2 = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");

			;
			prop.load(ip2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Eclipse_Workspace\\chromedriver_v79.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Eclipse_Workspace\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "E:\\Eclipse_Workspace\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser type");
		}

		ef_driver = new EventFiringWebDriver(driver);
		eventListner = new EventListener();
		ef_driver.register(eventListner);
		driver = ef_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
