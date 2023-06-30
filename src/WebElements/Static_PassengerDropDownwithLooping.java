package WebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Static_PassengerDropDownwithLooping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origin=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		System.out.println(driver.findElement(By.xpath("//div[@class='paxinfo']")).getText());
		System.out.println("-----------------");
		driver.findElement(By.id("divpaxinfo")).click();
		
		int adult = 1;
		while(adult < 5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			adult++;
		}
		driver.findElement(By.xpath("//input[@value='Done']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='paxinfo']")).getText());
		
		driver.close();
	}

}
