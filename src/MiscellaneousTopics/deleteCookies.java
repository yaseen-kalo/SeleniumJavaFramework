package MiscellaneousTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class deleteCookies {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.manage().window().maximize();
		
		//deleting all cookies.
		driver.manage().deleteAllCookies();
		
		//deleting specific cookie.
//		driver.manage().deleteCookieNamed("asdf");
		
		driver.navigate().to("https://www.google.com");
		
		Thread.sleep(2000);
		driver.close();
	}

}
