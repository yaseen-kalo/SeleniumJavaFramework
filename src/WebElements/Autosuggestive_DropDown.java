package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
public class Autosuggestive_DropDown {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("Ja");
		
		Thread.sleep(2000);
		
		List <WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		for(int i =0; i< options.size(); i++)
		{
			String countryName = options.get(i).getText();
			
			if(countryName.equalsIgnoreCase("Japan"))
			{
				driver.findElements(By.xpath("//li[@class='ui-menu-item']/a")).get(i).click();
				System.out.println(countryName);
				break;
				
			}
		}
		
		//posted question, waiting for reply why it is not printed autosuggestion text
		System.out.println(driver.findElement(By.xpath("//input[@id='autosuggest']")).getText());
		Thread.sleep(2000);
		
		driver.close();
	}

}
