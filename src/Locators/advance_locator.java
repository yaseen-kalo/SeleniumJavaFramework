package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class advance_locator {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-regions=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahulshettyacaemy");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("submit")).click();
		
		//capture the error message and print it in the console
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("RahulAcademy");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rahulacademy@rsa.in");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("+91123456700");
		
		driver.findElement(By.className("reset-pwd-btn")).click();
		
		String resetMsg = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		System.out.println(resetMsg);
		
		String resetMsgArr= resetMsg.split("'")[1].trim();
		System.out.println(resetMsgArr);
		
		driver.findElement(By.xpath("//form/div/button[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("inputUsername")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("inputPassword")).sendKeys(resetMsgArr);
		driver.findElement(By.xpath("//div[@class='checkbox-container']/span[1]")).click();
//		driver.findElement(By.xpath("//div[@class='checkbox-container']/span[2]")).click();
		driver.findElement(By.className("submit")).click();
		
		String sucessfullyLogin = driver.findElement(By.xpath("//div[@class='login-container']/p")).getText();
		
		Assert.assertEquals("You are successfully logged in.",sucessfullyLogin);
		
		System.out.println(sucessfullyLogin);
		driver.findElement(By.xpath("//*[text()= 'Log Out']"));
		Thread.sleep(2000);
		driver.close();
	}

}
