package seleniumbasics;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CountOfLinksInAPage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://the-internet.herokuapp.com");
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//gets the number of links in the entire page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		//gets the number of links inside footer section
		WebElement footer = driver.findElement(By.className("gf-t"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//gets the number of links in the first section in the footer
		WebElement footerFirst = footer.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
		System.out.println(footerFirst.findElements(By.tagName("a")).size());
		
		//click each link in the column
		Actions a = new Actions(driver);
		List<WebElement> columnOneLinks = footerFirst.findElements(By.tagName("a"));
		a.clickAndHold().keyDown(Keys.CONTROL).build().perform();
		for(int i=1; i<columnOneLinks.size(); i++) {
			columnOneLinks.get(i).click();
		}
		a.release();
		Iterator<String> windows = driver.getWindowHandles().iterator();
		while(windows.hasNext()) {
			String id = windows.next();
			System.out.println(driver.switchTo().window(id).getTitle());
		}
		//traversing to 1 more level deeper to get the tag count
		/* 
		 * List<WebElement> tds = footer.findElements(By.tagName("td")); int aTagSize =
		 * 0; for (WebElement td : tds) { aTagSize =
		 * td.findElements(By.tagName("a")).size() + aTagSize; }
		 * System.out.println(aTagSize);
		 */
	}

}
