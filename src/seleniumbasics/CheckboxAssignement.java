package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssignement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkbox1 = driver.findElement(By.id("checkBoxOption1"));
		
		/*
		 * check before selecting check box
		 * verify if it is checked
		 * uncheck the check box and verify it is deselected
		 */		
		Assert.assertFalse(checkbox1.isSelected());
		checkbox1.click();
		Assert.assertTrue(checkbox1.isSelected());
		checkbox1.click();
		Assert.assertFalse(checkbox1.isSelected());
		
		//printing the number of checkboxes in the page
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		driver.close();
		

	}

}
