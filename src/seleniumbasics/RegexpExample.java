package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegexpExample {
	public static void main(String[] args) {
		//Create driver object for chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://rediff.com");
		driver.findElement(By.xpath("//a[@class='signin']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("testemail@xxx.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("testpassword");
		driver.findElement(By.cssSelector("[value='Sign in']")).click();
		System.out.println(driver.findElement(By.cssSelector("#div_login_error")).getText());
		
	}
}
