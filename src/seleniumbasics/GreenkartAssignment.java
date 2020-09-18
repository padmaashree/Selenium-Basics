package seleniumbasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenkartAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		ArrayList<String> productList = new ArrayList<String>();
		productList.add("Cauliflower - 1 Kg");
		productList.add("Cucumber - 1 Kg");
		productList.add("Brinjal - 1 Kg");
		String[] productNameList = { "Cucumber", "Brocolli", "Brinjal" };
		driver.manage().window().maximize();
		List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
		// adding items to cart using for and string array
		/*
		 * for (String name : productNameList) { for (int i = 0; i <
		 * productNames.size(); i++) {
		 * System.out.println(productNames.get(i).getText()); if
		 * (productNames.get(i).getText().contains(name)) {
		 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(
		 * ); break; } } }
		 */
		// Adding items to cart using for and array list
		/*
		 * for (int k = 0; k < productNames.size(); k++) { String product =
		 * productNames.get(k).getText(); Thread.sleep(500); if
		 * (productList.contains(product)) {
		 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(k).click(
		 * ); Thread.sleep(2000); } }
		 */
		
		//converting array as array list and process the same
		
		List productNamesList = Arrays.asList(productNameList);
		/*
		 * for (int k = 0; k < productNames.size(); k++) { String product =
		 * productNames.get(k).getText(); Thread.sleep(500); if
		 * (productNamesList.contains(product)) {
		 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(k).click(
		 * ); Thread.sleep(2000); } }
		 */
		
		//By not giving the exact name of the vegetable how can we add to cart the item present in the plp
		//clicking on add to cart without relying on the displayed text
		//since the add to cart of the first element after clicking on it changes to added 
		//and it takes 5 seconds to return back to add to cart the index gets changed and the wrong products are being added to cart
		//to avoid this always. If the text is going to change we should never locate that element by text.
		for (int k = 0; k < productNames.size(); k++) {
			String[] product = productNames.get(k).getText().split("-");
			String formattedProduct = product[0].trim();
			if (productNamesList.contains(formattedProduct)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(k).click();
			}
		}

	}

}
