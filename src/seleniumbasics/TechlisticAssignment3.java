package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TechlisticAssignment3 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.manage().window().maximize();
		driver.findElement(By.name("firstname")).sendKeys("padmashree");
		driver.findElement(By.name("lastname")).sendKeys("Giridharan");
		driver.findElement(By.id("sex-1")).click();
		driver.findElement(By.id("exp-2")).click();
		driver.findElement(By.id("datepicker")).sendKeys("15/05/2020");
		driver.findElement(By.id("profession-1")).click();
		driver.findElement(By.id("tool-2")).click();
		Select continent = new Select(driver.findElement(By.id("continents")));
		continent.selectByVisibleText("Asia");
		Select commands = new Select(driver.findElement(By.id("selenium_commands")));
		commands.selectByVisibleText("WebElement Commands");

		driver.findElement(By.id("submit")).click();
		
	}
}
