package PracticalProblemandMethodstoHandlingthem;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class scrollTableandWindowLevelandHandlingtableGrid {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)", "");
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=4000;", "");
		
		List <WebElement> amount = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		
		int sum = 0;
		for(int i = 0; i < amount.size(); i++)
		{
			sum = sum + Integer.parseInt(driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]")).get(i).getText());
		}
		System.out.println(sum);
		String totalAmount = driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
		int total = Integer.parseInt(totalAmount);
		System.out.println(total);
	
		
		Assert.assertEquals(total, sum);
		Thread.sleep(2000);
		driver.close();
	}

}
