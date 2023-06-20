import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class selIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-regions=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://rahulshettyacademy.com");
		//get title of website
		System.out.println(driver.getTitle());
		
		//get current url
		System.out.println(driver.getCurrentUrl());
		
		//get source of the last page loaded
		System.out.println(driver.getPageSource());
		
//		close current tab
		driver.close();
	}

}
