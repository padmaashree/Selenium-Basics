package seleniumbasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		WebElement table = driver.findElement(By.id("product"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		int columnCount = table.findElement(By.tagName("tr")).findElements(By.tagName("th")).size();
		System.out.println(columnCount);
		List<WebElement> rowContent = table.findElement(By.cssSelector("tr:nth-child(3)"))
				.findElements(By.tagName("td"));
		for (WebElement column : rowContent) {
			System.out.println(column.getText());
		}

	}

}
