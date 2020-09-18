package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class AutoSuggestiveDDKeydown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();

		// Locate the input field and enter the first three letters of a country
		WebElement inputField = driver.findElement(By.id("autocomplete"));
		inputField.sendKeys("UNI");
		Thread.sleep(2000);
		inputField.sendKeys(Keys.DOWN);

		// for incrementing
		int count = 0;

		// for validating count
		int listSize = driver.findElement(By.id("ui-id-1")).findElements(By.className("ui-menu-item")).size();

		// JSE API to get the option value from input field
		JavascriptExecutor je = (JavascriptExecutor) driver;
		String getInputText = "return document.getElementById(\"autocomplete\").value;";
		String inputText = (String) je.executeScript(getInputText);

		while (!inputText.equalsIgnoreCase("united states (usa)")) {
			inputField.sendKeys(Keys.DOWN);
			inputText = (String) je.executeScript(getInputText);
			count++;
			if (count > listSize - 1) {
				break;
			} else {
				continue;
			}
		}
		if (inputText.equalsIgnoreCase("united states (usa)")) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
			System.out.println("Element Found: Test Passed");
		} else {
			System.out.println("Element not found: Test failed");
		}

	}

}
