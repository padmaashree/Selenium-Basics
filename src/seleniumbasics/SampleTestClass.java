package seleniumbasics;

import org.openqa.selenium.*; //imports the web driver class
import org.openqa.selenium.chrome.ChromeDriver; //chrome driver class imported
//import org.openqa.selenium.firefox.FirefoxDriver; //firefox driver class imported
import org.openqa.selenium.support.ui.Select;

public class SampleTestClass {
	
	 public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseURL = "http://gmail.com/";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";
		String tagName = "";
		
		driver.get(baseURL);
		actualTitle = driver.getTitle();
		/*
		 * WebElement myElement = driver.findElement(By.name("userName"));
		 * myElement.sendKeys("userName");
		 */
		//tagName = driver.findElement(By.name("userName")).getTagName();
		WebElement we = driver.findElement(By.className("NlWrkb"));
		we.click();
		System.out.println("first one executed");
		WebElement we1 = driver.findElement(By.xpath("//div[contains(text(),'For myself')]"));
		we1.click();
		System.out.println("second executed");
		
		//System.out.println(tagName);
		//driver.findElement(By.name("submit")).click();
		/*
		 * if(actualTitle.contentEquals(expectedTitle)) {
		 * System.out.println("Test Passed!!"); }else {
		 * System.out.println("Test Failed"); }
		 */
		
		driver.close();
		System.exit(0);
	 }
}
