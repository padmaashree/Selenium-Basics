package seleniumbasics;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleAssignment {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		
		/*
		 * List<WebElement> links = driver.findElements(By.tagName("a"));
		 * System.out.println(links.size());
		 */
		// clicks on Mutiple Window Link and clicks on the click here link in it
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		// gets the window handles ids and iterates for parent and child window ids
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();

		// switches to child window and prints the text in it
		driver.switchTo().window(childWindow);
		System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());

		// switches to parent window and prints text in it
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening')]")).getText());

		driver.close();

	}
}
