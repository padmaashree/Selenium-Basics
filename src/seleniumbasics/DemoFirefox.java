package seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoFirefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\nsgirinambi\\geckodriver.exe");
		WebDriver fd = new FirefoxDriver();
		fd.get("http://google.com");
		System.out.println(fd.getTitle());
	}

}
