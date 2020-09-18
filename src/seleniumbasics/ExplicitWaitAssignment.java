package seleniumbasics;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Wait using webdriverwait class
		
		  WebDriverWait wait = new WebDriverWait(driver, 3);
		  driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		  driver.manage().window().maximize();
		  driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")
		  ).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
		  System.out.println(driver.findElement(By.id("results")).getText());
		  driver.close();
	}

}
