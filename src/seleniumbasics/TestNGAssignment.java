package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssignment {
	
	public static final WebDriver driver = new ChromeDriver();
	//public static String driverPath = "C:\\Users\\nsgirinambi\\chromedriver.exe";
	public static String getUrl = "http://www.demo.guru99.com/V4/";
	public static String launchTitle = "Guru99 Bank Home Page";
	public static String launchPageHeading = "//h2[text()='Guru99 Bank']";
	public static String userNameValue = "mngr266726";
	public static String passwordValue = "mugUgej";
	public static String usernameField = "uid";
	public static String passwordField = "password";
	public static String submitButton = "btnLogin";
	public static String managerIdElement = "//td[text()='Manger Id : mngr266762']";
	public TestNGAssignment() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\nsgirinambi\\\\chromedriver.exe");
	}
	@Test
	public void initializeBrowserLaunch() {
		//System.setProperty("webdriver.chrome.driver", driverPath);
		driver.get(getUrl);
		driver.manage().window().maximize();
	}
	
	@Test(dependsOnMethods = {"initializeBrowserLaunch"})
	public void verifyLoginTitle() {
		String currentTitle = driver.getTitle();
		Assert.assertTrue(currentTitle.matches(launchTitle), "Title is not matching with the launch title");	
		System.out.println("Title matches with the launch title");
	}
	
	@Test(dependsOnMethods = {"verifyLoginTitle"})
	public void verifyLoginHeading() {
		Assert.assertTrue(driver.findElement(By.xpath(launchPageHeading)).isDisplayed(), "Heading is not displayed");
		System.out.println("Heading is displayed");
	}
	
	@Test(dependsOnMethods = {"verifyLoginHeading"})
	public void loginToApplication() {
		driver.findElement(By.name(usernameField)).sendKeys(userNameValue);
		driver.findElement(By.name(passwordField)).sendKeys(passwordValue);
		driver.findElement(By.name(submitButton)).click();
	}
	
	@Test
	public void verifyManagerIdInDashboard() {
		Assert.assertTrue(driver.findElement(By.xpath(managerIdElement)).isDisplayed(), "Manager Id is not displayed in the manager dashboard after login");
		System.out.println("Manager id is displayed");
	}
	
	
}
