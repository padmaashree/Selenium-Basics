package seleniumbasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalanderAssignment {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.phptravels.net/home");
		driver.findElement(By.id("checkin")).click();
		driver.findElement(By.cssSelector("[class='datepicker--nav-title']"));
		while(!driver.findElement(By.cssSelector("[class='datepicker--nav'] [class='datepicker--nav-title']")).getText().contains("April")) {
			driver.findElement(By.cssSelector("[class='datepicker--nav-action'][data-action='next'] svg")).click();
		}
		List<WebElement> dates = driver.findElements(By.className("datepicker--cell-day"));
		for(int i=0; i<dates.size(); i++) {
			if(dates.get(i).getText().equalsIgnoreCase("15")) {
				dates.get(i).click();
				break;
			}
		}
	}
}
