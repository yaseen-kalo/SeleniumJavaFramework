package Selenium4dot0_latest_feature;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Invoking_multiple_windows_tabs {

	public static void main(String[] args) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		
		//Senario: 
		//Navigate to https://rahulshetty.com/angularpractice/
		//Fill the "Name" field with the first course name available at
		//https://rahulshettyacademy.com
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origin=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		
		//initial new tab
		driver.switchTo().newWindow(WindowType.TAB);
		
//		//initial new window
//		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.navigate().to("https://rahulshettyacademy.com");
		
		Set <String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		String parentTabID = it.next();
		String childTabID = it.next();
		
		driver.switchTo().window(childTabID);
		String courseName = driver.findElements(By.xpath("//h2/a")).get(1).getText();
		
		driver.switchTo().window(parentTabID);
		
		WebElement nameTextBox = driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']"));
		nameTextBox.sendKeys(courseName);
		
		//Capture screenshot of text field
		
		File screenshot = nameTextBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("images/ss.png"));
		
		//get Height and Width of Web Element
		System.out.println(nameTextBox.getRect().getHeight());
		System.out.println(nameTextBox.getRect().getWidth());
		
		Thread.sleep(2000);
		driver.quit();
	}

}
