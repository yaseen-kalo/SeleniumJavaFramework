package Sort_Pagination_FiltereingWebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo_Sorting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(ops);

		// implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
		Thread.sleep(2000);

		List<WebElement> deals = driver.findElements(By.xpath("//tbody/tr/td[1]"));

		List<String> originalList = deals.stream().map(n -> n.getText()).collect(Collectors.toList());

		List<String> sorteddeals = originalList.stream().sorted().collect(Collectors.toList());

		Thread.sleep(2000);

		Assert.assertTrue(originalList.equals(sorteddeals));

		List<String> price = deals.stream().filter(s -> s.getText().contains("Beans")).map(s -> getVeggiePrice(s))
				.collect(Collectors.toList());
		price.forEach(a -> System.out.println(a));
		Thread.sleep(2000);
		driver.close();
	}

	private static String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method stub
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
