package AjaxcallsChildwindowsIFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ajax_MouseActions {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://www.amazon.de/-/en/ref=nav_logo");
		driver.findElement(By.id("sp-cc-accept")).click();
		Actions a = new Actions(driver);
		WebElement options = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		//single action.
		a.moveToElement(options).build().perform();
		Thread.sleep(5000);
		
		//multiple action.
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("cricket bat").build().perform();
		a.moveToElement(driver.findElement(By.id("nav-search-submit-text"))).keyUp(Keys.SHIFT).click().build().perform();
		
		Thread.sleep(5000);
		
		driver.close();
	}

}
