package WebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Durations;


public class static_CurrencyDropDown {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		
		WebElement sd = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		
		Select ddl = new Select(sd);
		ddl.selectByValue("AED");
		
		Thread.sleep(2000);
		
		//deselectbyIndex only works for multi select dropdown
		//ddl.deselectByIndex(2);
		
		Thread.sleep(2000);
		
		ddl.selectByVisibleText("USD");
		
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
