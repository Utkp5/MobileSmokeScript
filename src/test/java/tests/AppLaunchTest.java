package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;

public class AppLaunchTest {

	@Test
	public void verifyLoginNavigation() throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:deviceName", "Redmi Note 10");
		caps.setCapability("appium:udid", "f0dae9a2");

		caps.setCapability("appium:appPackage", "com.staqu.jarvis.arc");
		caps.setCapability("appium:appActivity", "com.staqu.jarvis.arc.sme.MainActivity");

		caps.setCapability("appium:noReset", true);
		caps.setCapability("appium:ignoreHiddenApiPolicyError", true);

		AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), caps);

		try {

			System.out.println("Application launched successfully!");

			Thread.sleep(8000);
			
			// Locate Login Button
			By loginButton = AppiumBy.accessibilityId("Login with mobile number");
			
			//aleternate path
			//By loginButton = By.xpath("//*[@content-desc='Login with mobile number']");
			
			// Verify Login Button
			Assert.assertTrue(driver.findElement(loginButton).isDisplayed(), "Login button is not displayed!");

			System.out.println("Login button is displayed!");

			// Click Login Button
			driver.findElement(loginButton).click();

			System.out.println("Login button clicked successfully!");

			Thread.sleep(5000);

			// Capture next screen
			System.out.println(driver.getPageSource());

		} finally {

			driver.quit();

		}
	}
}