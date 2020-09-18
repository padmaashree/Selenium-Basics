package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDDTraditional {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();

		// implicit wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Locate the input field and enter the first three letters of a country
		driver.findElement(By.id("autocomplete")).sendKeys("UNI");

		// get the list of suggestive dropdown values and iterate through the list
		// Once the desired option is found click on it and end the loop
		// else continue finding the option
		List<WebElement> menuItems = driver.findElement(By.id("ui-id-1")).findElements(By.className("ui-menu-item"));
		int count = 0;
		for (WebElement item : menuItems) {
			String option = item.findElement(By.tagName("div")).getText();
			if (option.equalsIgnoreCase("united states (usa)")) {
				item.findElement(By.tagName("div")).click();
				count++;
				break;
			} else {
				continue;
			}
		}

		// initialize a variable to 0
		// increment the variable inside the if block
		// Out of for check if variable > 0
		// If greater than 0 print test passed else print test failed
		if (count > 0) {
			System.out.println("test passed");
		} else {
			System.out.println("No entry found for United states: test failed");
		}
	}

}
