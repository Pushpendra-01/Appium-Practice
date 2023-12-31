package Practice.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragAndDropDemo extends BaseTest{

	@Test
	public void dragAndDrop() throws InterruptedException {

		scrollIntoText("Views");
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	    WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	    ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
	    	    "elementId", ((RemoteWebElement) source).getId(),
	    	    "endX", 472,
	    	    "endY", 426
	    	));
	    String message=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(message,"Dropped!")	;
        
 	}
	
}
