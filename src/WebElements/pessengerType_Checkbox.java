package WebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class pessengerType_Checkbox {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_StudentDiscount']")).isSelected());	
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_StudentDiscount']")).isSelected());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_StudentDiscount']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_StudentDiscount']")).isSelected());	
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_StudentDiscount']")).isSelected());
		Thread.sleep(2000);
		
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 6);
		driver.close();
	}

}
