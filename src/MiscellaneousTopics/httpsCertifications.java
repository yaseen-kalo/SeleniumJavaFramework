package MiscellaneousTopics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class httpsCertifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		ops.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(ops);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
