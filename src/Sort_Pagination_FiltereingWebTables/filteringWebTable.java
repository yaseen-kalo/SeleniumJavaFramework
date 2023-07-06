package Sort_Pagination_FiltereingWebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class filteringWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origin=*");
		
		WebDriver driver = new ChromeDriver(ops);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		driver.findElement(By.xpath("//tr/th[@role='columnheader'][1]")).click();
		
		List<WebElement> deals = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		List <WebElement> filterrow = deals.stream().filter(i -> i.getText().contains(driver.findElement(By.id("search-field")).getText()))
		.collect(Collectors.toList());
		
		Assert.assertEquals(deals.size(), filterrow.size());
		
		driver.close();
	}

}
