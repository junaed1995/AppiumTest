package sampleAppiumProj.AppiumArtifact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class AppiumBasics extends BaseTestClass{
     
	@Test
	public void WifiSettingsName() throws MalformedURLException, URISyntaxException
	{		
				
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String popupBox = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")).getText();
		Assert.assertTrue(popupBox.equals("WiFi settings"), "Popup header text verified");		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("Sample Wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
		service.stop();
	}
	
}
