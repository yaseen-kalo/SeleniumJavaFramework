package FunctionalTesting;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class e2e_GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-regions=*");

		WebDriver driver = new ChromeDriver(ops);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		// implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// list of vegitables to be ordered.
		String[] vegitableList = { "Carrot", "Beans", "Apple", "Pomegranate", "Nuts Mixture" };

		int j = 0;

		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));
		List orderedVeggies = Arrays.asList(vegitableList);
		for (int i = 0; i < productList.size(); i++) {
			String extractedName = driver.findElements(By.xpath("//h4[@class='product-name']")).get(i).getText()
					.split("-")[0].trim();
//			System.out.println(extractedName);
			if (orderedVeggies.contains(extractedName)) {
				j++;
				driver.findElements(
						By.xpath("//h4[@class='product-name']/parent::div /div[@class='product-action']/button")).get(i)
						.click();
				Assert.assertTrue(orderedVeggies.contains(extractedName));
				if (j == orderedVeggies.size())
					break;
			}
		}
		
		//click on cart icon
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Place Order']")));
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		WebElement countryDropDown = driver.findElement(By.tagName("select"));
		Select country = new Select(countryDropDown);
		country.selectByVisibleText("Japan");
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wrapperTwo']")).getText().contains("successfully"));
		
		Thread.sleep(2000);
		driver.close();
		
	}
}
