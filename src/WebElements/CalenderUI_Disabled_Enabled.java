package WebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CalenderUI_Disabled_Enabled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("(//input[@value='RoundTrip'])[1]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@value='RoundTrip'])[1]")).isSelected());
		
		driver.findElement(By.xpath("//input[@value='OneWay']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='OneWay']")).isSelected());
		
		//Encounter Unexpected Result
		//Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_txt_Todate")).isEnabled());
		
		//Now trying another procedure
		boolean Opacity = driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1");
		
		if(Opacity)
		{
			System.out.println("Enabled");
			Assert.assertTrue(false);
		}
		else
		{
			System.out.println("Disabled");
			Assert.assertTrue(true);
		}
		
		driver.close();

	}

}
