package RealTimeExcercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calenderHandling {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.path2usa.com/travel-companion");
		
		driver.manage().window().maximize();
		
		// Scroll the Page

		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,1200)");

		// Click on the Date field

		Thread.sleep(3000);
		
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("form-field-travel_comp_date")));
		
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		
		WebElement month = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']"));
		
		while(!month.getText().contains("March"))
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			
			month = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']"));
			
		}
		
		List <WebElement> dates = driver.findElements(By.xpath("//*[@class='flatpickr-day ']"));
		
		for(int i = 0; i< dates.size(); i++)
		{
			if (dates.get(i).getText().contentEquals("22"))
			{
				dates.get(i).click();
				break;
			}
		}

		Thread.sleep(3000);
		driver.close();
	}

}
