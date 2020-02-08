package learnSeleniumDocker;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class ChromeWithDocker extends DriverObjects{
	
	@Test
	public void launchChrome() {
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		System.out.println(driver.getCapabilities().getBrowserName());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		System.out.println(driver.getTitle());
		takeSnap();
		driver.findElementByClassName("decorativeSubmit").click();
	}

}
