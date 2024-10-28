package sampleAppiumProj.AppiumArtifact;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTestClass{
	
	@Test
	public void AndroidScroll() throws MalformedURLException, URISyntaxException, InterruptedException
	{		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// Scroll to element based on text
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		scrolltoEnd();
		
	}
	
	public void scrolltoEnd()
	{
		boolean canScrollMore = true;
		do {
			// Scroll till end of page		
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down",
							"percent", 1.0));
		} while (canScrollMore);
	}

}
