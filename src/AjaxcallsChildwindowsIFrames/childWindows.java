package AjaxcallsChildwindowsIFrames;

import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class childWindows {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins");
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		driver.manage().window().maximize();
		
		Set <String> Windows = driver.getWindowHandles();
		Iterator <String> i = Windows.iterator();
		String parentId = i.next();
		String childId = i.next();
		driver.switchTo().window(childId);
		String email = driver.findElement(By.xpath("//p[@class='im-para red']/strong/a")).getText();
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
