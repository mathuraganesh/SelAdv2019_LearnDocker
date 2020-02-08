package learnSeleniumDocker;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DriverObjects {

	public RemoteWebDriver driver;
	int i =1;

	@Parameters("browserName")
	@BeforeMethod
	public void usingDockerGrid(String browserName) throws MalformedURLException {
		
		ChromeOptions opt = new ChromeOptions();
		//opt.setBinary(path);
	
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browserName);
		dc.merge(opt);
		driver =new RemoteWebDriver(new URL("http://localhost:4985/wd/hub"), dc);
	}

	public void takeSnap() {
		String clsName = this.getClass().getSimpleName();
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), 
					new File(System. getProperty("user.dir")+"/snaps/"+clsName+i+".png"));
		} catch (Exception e) {

		}
		i++;

	}

}
