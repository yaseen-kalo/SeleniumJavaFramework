package RealTimeExcercise;

import org.testng.annotations.Parameters;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class testng_GoogleTitle {

	@Test
	@Parameters({"input"})
	public void verifyTextboxinput(String text) throws InterruptedException
	{
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to("https://www.google.com");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//div[@class='QS5gu sy4vM']")).click();
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		
		searchBox.sendKeys(text);
		String textboxtext = searchBox.getAttribute("value");
		Assert.assertEquals(textboxtext, text);
	}
}
