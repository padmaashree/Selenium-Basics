package seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DemoIe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.ie.driver", "C:\\Users\\nsgirinambi\\IEDriverServer.exe");
		WebDriver ied = new InternetExplorerDriver();
		ied.get("http://google.com");
		System.out.println(ied.getTitle());
	}

}
