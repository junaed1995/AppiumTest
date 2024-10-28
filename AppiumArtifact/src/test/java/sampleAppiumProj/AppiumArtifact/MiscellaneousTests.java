package sampleAppiumProj.AppiumArtifact;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class MiscellaneousTests extends BaseTestClass{
     
	@Test
	public void MiscTests() throws MalformedURLException, URISyntaxException, InterruptedException
	{		
		//adb shell dumpsys window | find "mCurrentFocus"
		//mCurrentFocus=Window{a06147a u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
		
		//Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		((JavascriptExecutor)driver).executeScript("mobile: startActivity",
				ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		
		
		/*
		 * driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		 * driver.findElement(By.
		 * xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"
		 * )).click();
		 */
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();	
		DeviceRotation rotateScreen = new DeviceRotation(0,0,90);
		driver.rotate(rotateScreen);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();		
		driver.setClipboardText("Sample Wifi");
		String popupBox = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")).getText();
		Assert.assertTrue(popupBox.equals("WiFi settings"), "Popup header text verified");		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
		service.stop();
	}
	
}
