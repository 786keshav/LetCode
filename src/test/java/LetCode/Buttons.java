package LetCode;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Buttons extends Base {

	@Test
	public void test2() {
		WebElement Button = driver.findElement(By.xpath(Loca.getProperty("Button")));
		clickOn(driver, Button, 10);

		WebElement gotoHome = driver.findElement(By.xpath(Loca.getProperty("gotoHome")));
		clickOn(driver, gotoHome, 10);

		driver.navigate().back();

		WebElement getLocation = driver.findElement(By.xpath(Loca.getProperty("getLocation")));
		int X = getLocation.getLocation().getX();
		System.out.println(X);
		int Y = getLocation.getLocation().getY();
		System.out.println(Y);

		WebElement color = driver.findElement(By.xpath(Loca.getProperty("color")));
		String Text = color.getCssValue("color");
		System.out.println(Text);

		WebElement btnSize = driver.findElement(By.xpath(Loca.getProperty("btnSize")));
		Dimension D = btnSize.getSize();
		int Height = D.height;
		System.out.println("butoon height is"+" "+Height);
		int Width = D.width;
		System.out.println("butoon height is"+" "+Width);
		
		WebElement isDisabled = driver.findElement(By.xpath(Loca.getProperty("btn")));
		boolean tt=isDisabled.isDisplayed();
		System.out.println(tt);
	}

}
