package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndtoEndAssignment1 {

	public static void main(String[] args) {
		// https://www.rahulshettyacademy.com/AutomationPractice/
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();

		// check the checkbox option 2
		WebElement checkbox = driver.findElement(By.id("checkBoxOption2"));
		String checkedOption = checkbox.getAttribute("value");
		checkbox.click();

		// select the checked value from the selected dropdown
		Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
		select.selectByValue(checkedOption);

		// Enter the value selected in the alert input box
		driver.findElement(By.id("name")).sendKeys(checkedOption);
		driver.findElement(By.id("alertbtn")).click();

		// verify if the alert box contains the option value in it or not
		String alertText = driver.switchTo().alert().getText();
		if (alertText.contains(checkedOption)) {
			driver.switchTo().alert().accept();
			System.out.println("Alert box contains the checkbox value: Test Passed!");
			Assert.assertTrue(true);
		} else {
			System.out.println("Chekbox value is not present in the alert box: Test Failed!");
			Assert.assertTrue(false);
		}

	}

}
