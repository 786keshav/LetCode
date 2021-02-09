package LetCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import com.google.inject.spi.Element;

public class Base {
	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Properties Loca = new Properties();
	public static FileInputStream fis;

	@BeforeSuite
	public void setUP() throws IOException {
		if (driver == null) {
			fis = new FileInputStream(
					"C:\\Automation Scripts\\LetCode\\src\\test\\resources\\Properties\\Config.properties");
			Config.load(fis);

			fis = new FileInputStream(
					"C:\\Automation Scripts\\LetCode\\src\\test\\resources\\Properties\\Loca.properties");
			Loca.load(fis);

			if (Config.getProperty("Browser").equals("Firefox")) {

				System.setProperty("webdriver.gecko.driver",
						"C:\\Automation Scripts\\LetCode\\src\\test\\resources\\Executables\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (Config.getProperty("Browser").equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Automation Scripts\\LetCode\\src\\test\\resources\\Executables\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.get(Config.getProperty("SiteUrl"));
		}

	}
	
	public void tearDown() {
		
	}

	
	public static void sendKeys(String value, int timeout, WebElement Element, WebDriver driver) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(Element));
		Element.sendKeys(value);
	}
	
	public static void clickOn(WebDriver driver,WebElement Element, int timeout) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(Element));
		Element.click();
	}
}
