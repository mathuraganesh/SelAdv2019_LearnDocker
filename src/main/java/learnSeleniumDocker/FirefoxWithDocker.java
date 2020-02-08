package learnSeleniumDocker;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FirefoxWithDocker extends DriverObjects{
	
	@Test
	public void launchFirefox() throws InterruptedException {
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getCapabilities().getBrowserName());
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElementByXPath("//ol[@id='selectable']/li[1]");
		WebElement item2 = driver.findElementByXPath("//ol[@id='selectable']/li[5]");
		
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(item1).click(item2).keyUp(Keys.CONTROL).build();
		Thread.sleep(2500);
		takeSnap();
		System.out.println(driver.getTitle());
		driver.switchTo().defaultContent();		
	}
}
