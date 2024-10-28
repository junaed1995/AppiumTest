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

public class LongPress extends BaseTestClass{
	
	@Test
	public void LongPressGesture() throws MalformedURLException, URISyntaxException, InterruptedException
	{		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
		
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		
		longPressAction(ele,2000);
		WebElement menuTitle = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title']"));
		Assert.assertEquals(menuTitle.getText(), "Sample menu");
		
		Assert.assertTrue(menuTitle.isDisplayed());
		
		Thread.sleep(2000);
	}

}
