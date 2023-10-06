package Practice.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{

	@Test
	public void longPressGesture() throws InterruptedException {
//		scrolling down to the screen.
		scrollIntoText("Views");
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
//		performing long press action.
		WebElement peopleNames=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(peopleNames);
		Thread.sleep(2000);
		String menuText=driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals("Sample menu",menuText);
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
	}
}
