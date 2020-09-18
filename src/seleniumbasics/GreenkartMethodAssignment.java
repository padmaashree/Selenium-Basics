package seleniumbasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenkartMethodAssignment {

	

	public static void addItemsToCart(String[] productArray, WebDriver driver) {
		List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));

		// converting array as array list and process the same

		List<String> productNamesList = Arrays.asList(productArray);

		// By not giving the exact name of the vegetable how can we add to cart the item
		// present in the plp
		// clicking on add to cart without relying on the displayed text
		// since the add to cart of the first element after clicking on it changes to
		// added
		// and it takes 5 seconds to return back to add to cart the index gets changed
		// and the wrong products are being added to cart
		// to avoid this always. If the text is going to change we should never locate
		// that element by text.
		for (int k = 0; k < productNames.size(); k++) {
			String[] product = productNames.get(k).getText().split("-");
			String formattedProduct = product[0].trim();
			if (productNamesList.contains(formattedProduct)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(k).click();
			}
		}

	}
	

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		ArrayList<String> productList = new ArrayList<String>();
		productList.add("Cauliflower - 1 Kg");
		productList.add("Cucumber - 1 Kg");
		productList.add("Brinjal - 1 Kg");
		String[] productNameList = { "Cucumber", "Brocolli", "Brinjal" };
		driver.manage().window().maximize();
		addItemsToCart(productNameList, driver);
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Enter promo code')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		String promoInfo = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		if(promoInfo.matches( "Code applied ..!")) {
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		}
	}

}
