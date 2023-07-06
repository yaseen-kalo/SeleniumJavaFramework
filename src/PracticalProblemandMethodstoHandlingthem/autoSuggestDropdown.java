package PracticalProblemandMethodstoHandlingthem;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class autoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins");
		
		WebDriver driver = new ChromeDriver(ops);
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("Uni");
		List <WebElement> suggestedCountries = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		
		for(int i = 0; i < suggestedCountries.size(); i++)
		{
			if(suggestedCountries.get(i).getText().contains("United Kingdom (UK)"))
				{
					Actions a = new Actions(driver);
					a.moveToElement(driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']")).get(i)).click().build().perform();
					break;
				}
		}
		Thread.sleep(3000);
		driver.close();
	}

}
