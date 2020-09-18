package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdowns {

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		
		//WebElement fromField = driver.findElement(By.id("fromCity"));
		driver.findElement(By.id("fromCity")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys("MUM");
		Thread.sleep(2000);;
		driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys(Keys.ENTER);
		//WebElement toField = driver.findElement(By.id("toCity"));
		/*
		 * driver.findElement(By.id("toCity")).click(); Thread.sleep(2000);
		 * driver.findElement(By.id("toCity")).sendKeys("che"); Thread.sleep(2000);
		 * driver.findElement(By.id("toCity")).sendKeys(Keys.ARROW_DOWN);
		 * driver.findElement(By.id("toCity")).sendKeys(Keys.ENTER);
		 */
		
		
	}
}
