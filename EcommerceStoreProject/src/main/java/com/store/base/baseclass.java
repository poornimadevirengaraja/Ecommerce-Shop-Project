package com.store.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.store.actions.actionsclass;
import com.store.utilities.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * End to End Selenium Framework | E-Commerce Project | Complete Selenium
 * Framework from Scratch| Author - PoornimaDevi
 * 
 **/
public class baseclass {
	public static Properties prop;
	public static WebDriver driver;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> Threadlocaldriver = new ThreadLocal<>();

	// loadConfig method is to load the configuration
	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Configuration.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return Threadlocaldriver.get();
	}

	public void initializebrowser(String browserName) {
		// String browserName = prop.getProperty("browser");
		String drivertype = prop.getProperty("runtype");
		// "Local Machine" and "Chrome" Browser
		if (browserName.equalsIgnoreCase("chrome") && drivertype.equalsIgnoreCase("local")) {
			System.out.println("local");
			WebDriverManager.chromedriver().setup();
			ChromeOptions Options = new ChromeOptions();
			// TO change the window size
			Options.addArguments("window-size=500,500");
			driver = new ChromeDriver(Options);
			Threadlocaldriver.set((RemoteWebDriver) driver);
		}

		// "Remotedriver" and "Chrome" Browser in Selenium grid
		if (browserName.equalsIgnoreCase("chrome") && drivertype.equalsIgnoreCase("remote")) {
			System.out.println("remote");
			WebDriverManager.chromedriver().setup();
			ChromeOptions Options = new ChromeOptions();
			// To setCapability
			Options.setCapability("browserName", "chrome");
			Options.setCapability("platformName", "Windows 11");
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), Options);
				Threadlocaldriver.set((RemoteWebDriver) driver);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		// "Local Machine" and "FireFox" Browser
		if (browserName.equalsIgnoreCase("firefox")&& drivertype.equalsIgnoreCase("local")) {
			System.out.println("local");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions Options = new FirefoxOptions();
			// TO change the window size
			Options.addArguments("window-size=200,300");
			driver = new FirefoxDriver(Options);
			Threadlocaldriver.set((RemoteWebDriver) driver);
		}

		// "Remotedriver" and "firefox" Browser in Selenium grid
		if (browserName.equalsIgnoreCase("firefox") && drivertype.equalsIgnoreCase("remote")) {
			System.out.println("remote");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions Options = new FirefoxOptions();
			// To setCapability
			Options.setCapability("browserName", "firefox");
			Options.setCapability("platformName", "Windows 11");
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), Options);
				Threadlocaldriver.set((RemoteWebDriver) driver);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		// "Local Machine" and "IE" Browser
		if (browserName.equalsIgnoreCase("ie")&& drivertype.equalsIgnoreCase("local")) {
			System.out.println("local");
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions Options = new InternetExplorerOptions();
			driver = new InternetExplorerDriver(Options);
			Threadlocaldriver.set((RemoteWebDriver) driver);
			// Set Browser to ThreadLocalMap
			// driver.set(new InternetExplorerDriver());
		}
		// "Local Machine" and "MicrosoftEdge" Browser
		if (browserName.equalsIgnoreCase("edge")&& drivertype.equalsIgnoreCase("local")) {
			System.out.println("local");
			WebDriverManager.edgedriver().setup();
			EdgeOptions Options = new EdgeOptions();
			// TO change the window size
			Options.addArguments("window-size=300,300");
			driver = new EdgeDriver(Options);
			Threadlocaldriver.set((RemoteWebDriver) driver);
			// Set Browser to ThreadLocalMap
			// driver.set(new EdgeDriver());
		}
		
		// "Remotedriver" and "firefox" Browser in Selenium grid
		if (browserName.equalsIgnoreCase("edge") && drivertype.equalsIgnoreCase("remote")) {
			System.out.println("remote");
			WebDriverManager.edgedriver().setup();
			EdgeOptions Options = new EdgeOptions();
			// To setCapability
			Options.setCapability("browserName", "MicrosoftEdge");
			Options.setCapability("platformName", "Windows 11");
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), Options);
				Threadlocaldriver.set((RemoteWebDriver) driver);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		actionsclass actions = new actionsclass();
		// Maximize the screen
		getDriver().manage().window().maximize();
		// Delete all the cookies
		getDriver().manage().deleteAllCookies();
		actions.implicitWait(getDriver(), Integer.parseInt(prop.getProperty("implicitWait")));
		actions.pageLoadTimeOut(getDriver(), Integer.parseInt(prop.getProperty("pageLoadTimeOut")));

		// Launching the URL
		getDriver().get(prop.getProperty("url"));
	}

	@AfterSuite(groups = { "Smoke", "Regression", "Sanity" })
	public void afterSuite() {
		com.store.utilities.ExtentManager.endReport();
		Threadlocaldriver.remove();
	}
}

/*************************************************************
 * Chrome Options - You can use to set Options in your browser
 *************************************************************/

//To run in incognito mode
// Options.addArguments("--incognito");

// for security purposes
// Options.addArguments("--no-sandbox");

// To run with maximized window mode
// Options.addArguments("start-maximized");

// To do headless browser mode
// Options.addArguments("--headless");
// Options.addArguments("--disable-gpu);

// To add new extensions in chrome
// Options.addExtensions(new File("/Path/to/extension.crx"));

// To add binary path if it throws any binary exception
// Options.setBinary(new File("/Path/to/Chrome"));

// To accept untrusted SSSL certificate
// Options.setAcceptInsecureCerts(true);

// To disable info-bar
// Options.addArguments("disabe-infobars");

// To block Block dialog windows
// Options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));

// To remove the Automation pop up
// Options.setExperimentalOption("excludeSwitches", new String[] {
// "enable-automation" });

// TO change the window size
// Options.addArguments("window-size=400,600");
