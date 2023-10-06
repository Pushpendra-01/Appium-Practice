package Practice.Appium;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
public class AppiumBasic extends BaseTest {

	@Test
	public void wifiSettingName() {
		
//		Appium locators-xpath, id, accessibilityId, className, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
//		Assert.assertEquals(alertTitle,"WiFi settings");
		
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Pushp_Wifi");
		driver.findElement(By.id("android:id/button1")).click();
		
		
	}

	}

