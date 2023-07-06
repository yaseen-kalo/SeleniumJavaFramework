package PracticalProblemandMethodstoHandlingthem;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WebTableAssignment {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)", " ");
		
		System.out.println(driver.findElements(By.xpath("//fieldset/table[@id='product']/tbody/tr")).size());
		
		System.out.println(driver.findElements(By.xpath("//fieldset/table[@id='product']/tbody/tr[1]/th")).size());
		Thread.sleep(3000);
		// -------------------------------------------------//
		WebElement table=driver.findElement(By.id("product"));
		
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));


		System.out.println(secondrow.get(0).getText());



		System.out.println(secondrow.get(1).getText());



		System.out.println(secondrow.get(2).getText());
		Thread.sleep(3000);
		driver.close();
	}

}
