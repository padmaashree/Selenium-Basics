package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveOption {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ksrtc.in/oprs-web/guest/home.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("fromPlaceName")).sendKeys("BEN");
		List<WebElement> listOfSuggestions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		for(int i=0; i<listOfSuggestions.size(); i++) {
			if(listOfSuggestions.get(i).findElement(By.tagName("a")).getText().contains("BENGALURU INTERNATION AIRPORT")) {
				listOfSuggestions.get(i).findElement(By.tagName("a")).click();
				break;
			}
		}
	}
}
