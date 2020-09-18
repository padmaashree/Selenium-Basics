package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class TechlisticAssignment2 {

	public static WebDriver driver = null;

	public static void validateTitle(String expectedTitle) {
		String currentTitle = driver.getTitle();
		if (currentTitle.equals(expectedTitle)) {
			System.out.println("Title is matching: test case passed: " + currentTitle);
		} else {
			System.out.println("Title validation failed");
		}
	}

	public static Boolean validateCurrentUrl(String expectedUrl) {
		String currentUrl = driver.getCurrentUrl();

		if (currentUrl.contains(expectedUrl)) {
			return true;
		} else {
			return false;
		}

	}

	public static void clickValidateAndReturn(String link, Object title) {
		driver.findElement(By.linkText(link)).click();
		validateTitle(title.toString());
		WebElement home = driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'Home')]"));
		home.click();
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		driver = new ChromeDriver();
		
		String expectedTitle = "Techlistic";
		String expectedUrl = "techlistic.com";
		driver.get("https://techlistic.com");
		driver.manage().window().maximize();
		Boolean urlResult = validateCurrentUrl(expectedUrl);
		if(urlResult==true) {
			
			validateTitle(expectedTitle);
			String siteLink[] = {"Java Tutorial", "Selenium Tutorial", "TestNG Tutorial", "Blogs/Articles"};
			String siteTitle[] = {"Java Tutorials Series - Java For Selenium", "Selenium Tutorial - Learn Selenium from Comprehensive Series of 40 Coding Tutorials", "Selenium with TestNG Integration - Tutorial Series", "Top Selenium Blogs"};
			
			for (int i=0; i<siteLink.length; i++) {
				clickValidateAndReturn(siteLink[i], siteTitle[i]);
			}
			
		}else {
			System.out.println("url result failed for currenturl");
		}
		
		
		driver.close();
		

	}

}
