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

public class SwipeDemo extends BaseTestClass{
	
	@Test
	public void SwipeAction() throws MalformedURLException, URISyntaxException, InterruptedException
	{		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		
		Assert.assertTrue(Boolean.parseBoolean(firstImage.getAttribute("focusable")),"First Image is focused");
		
		swipeAction(firstImage,"left", 0.2f);
		
		Assert.assertFalse(Boolean.parseBoolean(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable")),"First Image is not focused");
	}
	
	public void swipeAction(WebElement ele,String direction,float percent)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", percent
			));
	}
	
	

}
