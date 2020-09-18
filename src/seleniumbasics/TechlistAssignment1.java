package seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TechlistAssignment1 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsgirinambi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String expectedUrl = "https://www.techlistic.com";
		String expectedTitle = "Techlistic";
		
		driver.get("https://www.techlistic.com");
		String currentUrl = driver.getCurrentUrl();
		String currentTitle = driver.getTitle();
		String currentPageSource = driver.getPageSource();
		
		if(currentUrl.contains(expectedUrl)) {
			System.out.println("current url matches with the expected url: test case passed");
			System.out.println("actual Url: "+ currentUrl +" expected url: "+ expectedUrl);
		}else {
			System.out.println("current url is not matching the expected url: test case failed");
		}
		
		if(currentTitle.equals(expectedTitle)) {
			System.out.println("current title matches with the expected title: test case passed");
			System.out.println("actual title: "+ currentTitle +" expected title: "+ expectedTitle);
		}else {
			System.out.println("current title is not matching the expected title: test case failed");
		}
		
		if(currentPageSource.contains(expectedTitle)) {
			System.out.println("pagesource has the title in it: test case passed");
			System.out.println("expected title: "+ expectedTitle + " pagesource contained title: "+ currentPageSource.contains(expectedTitle));
		}else {
			System.out.println("page source is not having the title expected: test case failed");
		}
		
		driver.close();
	}

}
