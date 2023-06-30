package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;

public class WindowsBrowser_AlertBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origion-*");

		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Write name in text box and click on Alert button then click OK if name is
		// present in text.
		String name = "Tariq";
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		String text = driver.switchTo().alert().getText();
		Assert.assertTrue(text.contains(name));
		driver.switchTo().alert().accept();

		// Now donot accept the alert box
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		
		driver.close();
	}

}
