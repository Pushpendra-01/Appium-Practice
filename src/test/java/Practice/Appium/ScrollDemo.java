package Practice.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest{

	@Test
	public void scrollIntoText() throws InterruptedException {
//		scrolling down to the screen.
		scrollIntoText("Views");
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
//		when where to scroll is known prior / scrolling to specific element.
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
//		when scroll is not known. 
		scrollToEndAction();
	}
}
