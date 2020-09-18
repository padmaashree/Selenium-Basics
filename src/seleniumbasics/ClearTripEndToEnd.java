package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTripEndToEnd {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://cleartrip.com");
		Select adults = new Select(driver.findElement(By.id("Adults")));
		adults.selectByVisibleText("2");
		Select children = new Select(driver.findElement(By.id("Childrens")));
		children.selectByVisibleText("1");
		Select infant = new Select(driver.findElement(By.id("Infants")));
		infant.selectByVisibleText("2");
		driver.findElement(By.id("DepartDate")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight ui-state-active')]"))
				.click();
		driver.findElement(By.xpath("//a[contains(@title,'More search options')]")).click();
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Spicejet");
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		driver.close();

	}

}
