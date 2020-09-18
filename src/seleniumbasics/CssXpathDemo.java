package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssXpathDemo {
	public static void main(String[] args) {
		//Create driver object for chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver cd = new ChromeDriver();
		
		//These are the basic three steps done before starting to automate
		
		cd.get("https://login.salesforce.com");
		cd.findElement(By.xpath("//input[@id='username']")).sendKeys("email address");
		cd.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		cd.findElement(By.xpath("//*[@id='Login']")).click();
		System.out.println(cd.findElement(By.cssSelector("#error")).getText());
		/*cd.findElement(By.name("q")).sendKeys("fb");
		cd.findElement(By.name("q")).submit();
		cd.findElement(By.linkText("Log In")).click();*/
	}
}
