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

public class DragAndDrop extends BaseTestClass{
	
	@Test
	public void DragAndDropTest() throws MalformedURLException, URISyntaxException, InterruptedException
	{		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
		WebElement elementToBeDragged = driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]"));
		longPressAction(elementToBeDragged,1000);
		DragAndDropAction(elementToBeDragged,1025,915);
		Thread.sleep(3000);
	}
	
	public void DragAndDropAction(WebElement ele,int endX,int endY)
	{
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) ele).getId(),
		    "endX", endX,
		    "endY", endY
		));
	}
	
}
