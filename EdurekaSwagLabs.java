//1)AnnotationExample.java

package Co.Edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationExample {
	
	public String baseUrl = "http://www.edureka.co/";
	String driverPath = "/usr/bin/chromedriver";
	public WebDriver driver;
	
	@BeforeTest
	public void LaunchBrowser() {
		System.out.println("Launching Chrome browser");
		System.setProperty("WebDriver.hrome.driver", "driverPath");
		driver = new ChromeDriver();
		driver.get(baseUrl);	
	}
	
	@Test
	public void VerifyHomePageTitle() {
		String expectedTitle = "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		
	}
	
	@AfterTest
	public void TerminateBrowser() {
		driver.close();
		
	}
	
	
}

//2)DataProvider.java

package Co.Edureka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {

	@Test(dataProvider="testdata")
	public void TestDP(String username, String Password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.name("login-button")).click();
		Thread.sleep(2000);
		driver.close();
		
	}
	
	@DataProvider(name="testdata")
	public Object [][] TestDataFeed(){
		Object [][] swaglabs= new Object [2][2];
		
		swaglabs[0][0]="standard_user1";
		swaglabs[0][1]="password1";
		
		swaglabs[1][0]="standard_user2";
		swaglabs[1][1]="password2";
		
		return swaglabs;
	}
}

//3)Edureka.java

package Co.Edureka.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Edureka{
	
	public String baseUrl = "http://www.edureka.co/";
	String driverPath = "/usr/bin/chromedriver";
	public WebDriver driver;
	
	@Test
	public void VerifyHomePageTitle() {
		System.out.println("Launching Chrome browser");
		System.setProperty("WebDriver.hrome.driver", "driverPath");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		String expectedTitle = "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		driver.close();
		
	}	
	
	
	
}

//4)SwagLabs.java

package Co.Edureka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Swaglabs {

	WebDriver driver;
	
	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void TestParameters() throws InterruptedException {
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
		
		String at = driver.getTitle();
		String et = "Swag Labs";
		driver.close();
		if(at.equalsIgnoreCase(et))
		{
			System.out.println("Test Successful");
		}
		else
		{
			System.out.println("Test Failure");
		}
	}
}

//5)TestNGAnnotations.java

package Co.Edureka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Swaglabs {

	WebDriver driver;
	
	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void TestParameters() throws InterruptedException {
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
		
		String at = driver.getTitle();
		String et = "Swag Labs";
		driver.close();
		if(at.equalsIgnoreCase(et))
		{
			System.out.println("Test Successful");
		}
		else
		{
			System.out.println("Test Failure");
		}
	}
}

//6)pom.xml

<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>SeleniumTestng</groupId>
	<artifactId>SeleniumTestNg</artifactId>
	<version>0.0.1-SNAPSHOT</version>

	<dependencies>
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>6.11.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13.2</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>6.11.0</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.0.0</version>
		</dependency>
		
		



	</dependencies>
</project>
