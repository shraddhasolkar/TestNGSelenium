//1)TestNGListenersDemo1.java

package Listeners;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestNGListeners.class)
public class TestNGListenerDemo1 {
	
	@Test
	public void test1() {
		System.out.println("I'am inside test1");
	}
	
	@Test
	public void test2() {
		System.out.println("I'am inside test2");
	}
	
	@Test
	public void test3() {
		System.out.println("I'am inside test3");
		throw new SkipException("This test is skipped");
	}
}

//2)TestNGListnersDemo2.java

package Listeners;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestNGListeners.class)
public class TestNGListenerDemo2 {
	
	@Test
	public void test4() throws InterruptedException {
		System.out.println("I'am inside test4");
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.name("login-button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.className("product_sort_container")).click();
		Thread.sleep(2000);
		Select drpoptions = new Select(driver.findElement(By.className("product_sort_container")));
		drpoptions.selectByVisibleText("Name (Z to A)");
	
		driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("shopping_cart_badge")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);	
		driver.findElement(By.id("first-name")).sendKeys("Shraddha");
		Thread.sleep(2000);
		driver.findElement(By.id("last-name")).sendKeys("Solkar");
		Thread.sleep(2000);
		driver.findElement(By.id("postal-code")).sendKeys("411041");
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("finish")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
		Thread.sleep(2000);
		driver.close();
		
	}
	
	@Test
	public void test5() {
		System.out.println("I'am inside test5");
	}
	
	@Test
	public void test6() {
		System.out.println("I'am inside test6");
		throw new SkipException("This test is skipped");
	}
}

//3)TestNGListeners.java

package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("****Test started****"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("****Test is successful****"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("****Test failed****"+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("****Test skipped****"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("********Test completed "+context.getName());
	}

}

//1)testng1.xml

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">

<listeners>
<listener class-name="Listeners.TestNGListeners"></listener>
</listeners>

  <test thread-count="5" name="Test">
    <classes>
      <class name="Listeners.TestNGListenerDemo1"/>
      <class name="Listeners.TestNGListenerDemo2"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->

//2)testng2.xml

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">

<listeners>
<listener class-name="Listeners.TestNGListeners"></listener>
</listeners>

  <test thread-count="5" name="Test">
    <packages>
      <package name="Listeners"/>
    </packages>
  </test> <!-- Test -->
</suite> <!-- Suite -->

