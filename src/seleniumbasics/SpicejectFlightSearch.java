package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SpicejectFlightSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com");
			driver.manage().window().maximize();
			Thread.sleep(4000);
	//		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='DEL']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
			driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
			/*
			 * driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
			 * Thread.sleep(1000); driver.findElement(By.
			 * xpath("//div[@id='ui-datepicker-div']//div[@class='ui-datepicker-group ui-datepicker-group-first']//tr[3]//a[text()='11']"
			 * )).click();
			 */	driver.findElement(By.id("divpaxinfo")).click();
			Thread.sleep(500);
			Select adultDropdown = new Select(driver.findElement(By.xpath("//select[contains(@id,'mainContent_ddl_Adult')]")));
			adultDropdown.selectByVisibleText("2");
			Thread.sleep(500);
			Select childDropdown = new Select(driver.findElement(By.xpath("//select[contains(@id,'mainContent_ddl_Child')]")));
			childDropdown.selectByVisibleText("1");
			Thread.sleep(500);
			Select infantDropdown = new Select(driver.findElement(By.xpath("//select[contains(@id,'mainContent_ddl_Infant')]")));
			infantDropdown.selectByVisibleText("1");
			Select currency = new Select(driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency")));
			currency.selectByVisibleText("INR");
			Thread.sleep(500);
			WebElement familyCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
			Assert.assertFalse(familyCheckbox.isSelected());
			familyCheckbox.click();
			Assert.assertTrue(familyCheckbox.isSelected());
			Thread.sleep(500);
			driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
			driver.switchTo().alert().accept();
			driver.close();
		
		
		
		

	}

}
