package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTechclistic {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String optionToSelect = "kamal hasan movie";
		driver.findElement(By.name("q")).sendKeys("kamal hasan");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.className("erkvQe"))));
		WebElement listOfAllSuggestions = driver.findElement(By.className("erkvQe"));
		List<WebElement> options = listOfAllSuggestions.findElements(By.tagName("li"));
		for (WebElement option : options) {
			System.out.println(option.getText());
			if(optionToSelect.matches(option.getText())) {
				option.click();
				break;
			}
			
		}
		String linkToClick = "Kamal Haasan Filmography | Movies List from 1959 to 2021 ...";
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.id("rso"))));
		WebElement searchResult = driver.findElement(By.id("rso"));
		List<WebElement> resultList = searchResult.findElements(By.className("g"));
		System.out.println(resultList.size());
		for (WebElement result : resultList) {
			String resultText = result.findElement(By.xpath("//div[@class='rc']/div[@class='r']/a/h3")).getText();
			System.out.println(resultText);
			if(linkToClick.matches(resultText)) {
				result.click();
				break;
			}
		}
		//techlistic selenium tutorials
	}
}
