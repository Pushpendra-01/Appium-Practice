package Practice.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public boolean canScrollMore;
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		 service=new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Sipl//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("10.10.10.129").usingPort(4723).build();
		service.start();
//	Appium code for starting the application
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Galaxy");
		options.setApp("C://Users//Sipl//eclipse-workspace//Appium//src//test//java//Resources//ApiDemos-debug.apk");
		driver=new AndroidDriver(new URL("http://10.10.10.129:4723/"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void longPressAction(WebElement webelement)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)webelement).getId(),
						"duration",2000));
	}
	public void scrollToEndAction() {
	do {
		 canScrollMore=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left",100, "top", 100, "width",200, "height", 500,
			    "direction", "down",
			    "percent", 3.0));
	}
	while(canScrollMore);
		
	}
	public void swipeAction(WebElement webelement, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
	    		"elementId",((RemoteWebElement)webelement).getId(),
	    	    "direction", direction,
	    	    "percent", 0.75
	    	));
	}
	public void scrollIntoText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
		service.stop();
		
	}
}
