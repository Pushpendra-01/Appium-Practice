package Practice.Appium;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
public class MiscelleniousAppiumActions extends BaseTest {

	@Test
	public void miscellenious() {
		//adb shell dumpsys window | grep -E 'mCurrentFocus'  - MAC
		// adb shell dumpsys window | find "mCurrentFocus"  - Windows
		Activity activity=new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		
//		Appium locators-xpath, id, accessibilityId, className, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landscape=new DeviceRotation(0, 0,90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(alertTitle);
//		Using Copy to clipboard and pasting copied value from clipboard.
		driver.setClipboardText("Pushp_wifi");
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(driver.getClipboardText());
//		Performing Key Android key Actions
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}

	}

