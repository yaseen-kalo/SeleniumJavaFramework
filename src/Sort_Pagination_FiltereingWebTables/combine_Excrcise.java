package Sort_Pagination_FiltereingWebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class combine_Excrcise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origin=*");

		WebDriver driver = new ChromeDriver(ops);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		
		initialBrowser(driver);
		veritySorting(driver);
		
		initialBrowser(driver);
		getDisccountedPriceofSpecificProduct(driver);
		
		initialBrowser(driver);
		getVeggiePriceAfterSorting(driver);
		
		initialBrowser(driver);

		verifyItemBetweenListandTextBox(driver);
	}

	@Test
	public static void veritySorting(WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();

		List<WebElement> productList = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> originalList = productList.stream().map(n -> n.getText()).collect(Collectors.toList());

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(originalList.equals(sortedList));
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public static void getDisccountedPriceofSpecificProduct(WebDriver driver) throws InterruptedException {
		
		List<WebElement> productList = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> discountedPrice = productList.stream().filter(p -> p.getText().contains("Rice"))
				.map(m -> getPrice(m)).collect(Collectors.toList());
		discountedPrice.forEach(p -> System.out.println(p));

		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public static void getVeggiePriceAfterSorting(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//tr/td[1]")).click();
		
		List<WebElement> VeggieList;
		List<String> actualPrice;
		
		do {
			VeggieList = driver.findElements(By.xpath("//tr/td[1]"));
			
			actualPrice = VeggieList.stream().filter(s -> s.getText().contains("Pineapple"))
					.map(m -> getActualPrice(m)).collect(Collectors.toList());
			actualPrice.forEach(p -> System.out.println(p));
			
			if(!(actualPrice.size()>0))
			{
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while(!(actualPrice.size()>0));
		
		Thread.sleep(2000);	
		driver.quit();
	}
	
	@Test
	public static void verifyItemBetweenListandTextBox(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("search-field")).sendKeys("Beans");
		
		driver.findElement(By.xpath("//tr/th[@role='columnheader'][1]")).click();
		
		List<WebElement> productList = driver.findElements(By.xpath("//tr/td[1]"));
		
		
		List<WebElement> product = productList.stream().filter(s -> s.getText().contains(driver.findElement(By.id("search-field")).getText()))
				.collect(Collectors.toList());
		
		Assert.assertEquals(productList.size(),product.size());
		
		Thread.sleep(2000);
		driver.quit();
	}

	private static String getActualPrice(WebElement m) {
		// TODO Auto-generated method stub
		String aPrice = m.findElement(By.xpath("following-sibling::td[1]")).getText();
		return aPrice;
	}

	private static String getPrice(WebElement m) {
		// TODO Auto-generated method stub
		String price = m.findElement(By.xpath("following-sibling::td[2]")).getText();
		return price;
	}

	public static void initialBrowser(WebDriver driver) {
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.findElement(By.xpath("//div[@class='cart']/a[2]")).click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));

		System.out.println(driver.getTitle());
	}

}
