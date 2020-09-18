package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
		// switching into top frame
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		// switching into middle frame
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		// printing the text in the middle frame
		System.out.println(driver.findElement(By.id("content")).getText());
	}

}
