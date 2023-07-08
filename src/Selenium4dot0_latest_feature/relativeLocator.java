package Selenium4dot0_latest_feature;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class relativeLocator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origin=*");
		
		WebDriver driver = new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameTextBox = driver.findElement(By.xpath("//input[@name='name'][1]"));
		
		//above absolute selector
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameTextBox)).getText());
		
		WebElement gender = driver.findElement(By.xpath("//label[@for='exampleFormControlSelect1']"));
		//below absolute selector
		WebElement genderOptions = driver.findElement(with(By.tagName("select")).below(gender));
		Select option = new Select(genderOptions);
		option.selectByVisibleText("Female");
		
		//toleftof absolute selector
		WebElement student = driver.findElement(By.xpath("//label[@for='inlineRadio1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(student)).click();
		
		//torightof absolute selector
		WebElement checkboxText = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxText)).click();
		
		Thread.sleep(2000);
		driver.close();
	}

}
