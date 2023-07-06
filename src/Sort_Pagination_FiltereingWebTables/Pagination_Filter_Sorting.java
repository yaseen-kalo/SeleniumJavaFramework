package Sort_Pagination_FiltereingWebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Pagination_Filter_Sorting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origin=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[@role='columnheader'][1]")).click();
		
		//Just un-comment below wait if you want to failed this testcase.
//		Thread.sleep(2000);
		
		List<WebElement> deals = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		List<String> origialVeggies = deals.stream().map(v -> v.getText()).collect(Collectors.toList());
		
		List<String> sortedVeggies = origialVeggies.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(sortedVeggies.equals(origialVeggies));
		List<String> Price;
		do
		{
			List<WebElement> discounteddeals = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			
			Price = discounteddeals.stream().filter(i -> i.getText().contains("Rice")).map(m -> getVegieDiscountedPrice(m))
					.collect(Collectors.toList());
			Price.forEach(t -> System.out.println(t));
			if(!(Price.size()>0))
			{
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
				Thread.sleep(1000);
			}
		}while(!(Price.size()>0));
		
		
		Thread.sleep(2000);
		driver.close();

	}

	private static String getVegieDiscountedPrice(WebElement m) {
		// TODO Auto-generated method stub
		String discountedPrice = m.findElement(By.xpath("//tbody/tr/td[1]/following-sibling::td[2]")).getText();
		return discountedPrice;
	}

}
