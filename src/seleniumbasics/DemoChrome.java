package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoChrome {
	public static void main(String[] args) {
		//Create driver object for chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver cd = new ChromeDriver();
		
		//These are the basic three steps done before starting to automate
		cd.get("http://google.com");//hits the requested url and loads the page
		System.out.println(cd.getTitle());//validates the title of the page	
		System.out.println(cd.getCurrentUrl());//validates if the url of the landed page is same as the requested url
		//cd.get("http://facebook.com");
		//cd.findElement(By.id("email")).sendKeys("padmait16@yahoo.com");
		//cd.findElement(By.id("pass")).sendKeys("padma3095@facebook");
		//cd.findElement(By.id("u_0_2")).click();
		cd.findElement(By.name("q")).sendKeys("fb");
		cd.findElement(By.name("q")).submit();
		cd.findElement(By.linkText("Log In")).click();
	}
}
