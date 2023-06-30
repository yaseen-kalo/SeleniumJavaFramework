package FunctionalTesting;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComplexAutomation {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origions=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		String[] items = {"Cucumber", "Brinjal", "Potato"};
		int j = 0;
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//add cucumber in to the cart.
		
		List <WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));
		//convert items array into array list for easy search in if condition
		List veggies = Arrays.asList(items);
		
		for(int i = 0; i< productList.size(); i++)
		{
			//check wheather the name extracted is present or not in arrayList
			if(veggies.contains(productList.get(i).getText().split(" ")[0].trim()))
			{
				driver.findElements(By.xpath("//h4[@class='product-name']/parent::div /div[@class='product-action']/button")).get(i).click();
//				Thread.sleep(5000);
				j++;
				if(j==veggies.size())
					break;
			}
		}
		Thread.sleep(4000);
		
		driver.close();
	}

}
