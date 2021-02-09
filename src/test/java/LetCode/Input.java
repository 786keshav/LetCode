package LetCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Input extends Base {
	@Test
	public void inputTest() {

		WebElement Inputbtn = driver.findElement(By.xpath("//*[@id=\"edit\"]"));
		clickOn(driver, Inputbtn, 10);

		WebElement fullName = driver.findElement(By.xpath(Loca.getProperty("fullName")));
		sendKeys("Keshav", 5, fullName, driver);

		WebElement append = driver.findElement(By.xpath(Loca.getProperty("KeyboardTab")));
		sendKeys("sdsdsdsd", 10, append, driver);
		sendKeys(Keys.chord(Keys.TAB), 5, append, driver);

		WebElement txt = driver.findElement(By.xpath(Loca.getProperty("txtBox")));
		String attribute = txt.getAttribute("type");
		System.out.println("Attribute type is:"+" "+attribute);
		
		WebElement clear = driver.findElement(By.xpath(Loca.getProperty("cleartxt")));
		clear.clear();
		
		WebElement isEnabled=driver.findElement(By.xpath(Loca.getProperty("Enabledbtn")));
		boolean btn=isEnabled.isEnabled();
		
		System.out.println(btn);
		
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
}