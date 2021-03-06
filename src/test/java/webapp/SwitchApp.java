package webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class SwitchApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity",".SplashActivity" );
		cap.setCapability("noReset", true);//to use app without resetting it in automation script
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver =  new AndroidDriver(url,cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Pavan");
		
		//driver.removeApp(bundleId);
		
		//driver.findElementByXPath("//android.widget.EditText[@text='Let's Shop']").click();;
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();


		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(2000);
		//driver.findElementByXPath("//android.widget.TextView[@text='Visit to the website to complete purchase']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();

		Thread.sleep(4000);
		
		Set<String> apps = driver.getContextHandles();
		
		for(String app : apps) 
		{
			System.out.println(app);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");

		driver.findElementByXPath("//input[@name='q']").sendKeys("Selenium");

		driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		
		driver.context("NATIVE_APP");

		
	}

}
