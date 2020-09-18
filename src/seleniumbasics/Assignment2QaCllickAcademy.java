package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2QaCllickAcademy {
	public static void main(String[] args) {
		//Create driver object for chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/interview.php");
		driver.findElement(By.cssSelector("#tablist1-tab1")).click();
		driver.findElement(By.xpath("//*[@id='tablist1-tab1']/following-sibling::li[1]")).click();
		driver.findElement(By.xpath("//*[@id='tablist1-tab1']/following-sibling::li[2]")).click();
		driver.findElement(By.xpath("//*[@id='tablist1-tab1']/following-sibling::li[3]")).click();
		
	}
}
