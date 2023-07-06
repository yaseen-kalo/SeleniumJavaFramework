package RealTimeExcercise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class linkCounts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://qaclickacademy.com/practice.php");
		
		//Give me links count present on whole page of website.
		int linkCount = driver.findElements(By.tagName("a")).size();
		System.out.println(linkCount);
		
		//Give me links count present in footer section of website.
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		int footerLinkCount = footerDriver.findElements(By.tagName("a")).size();
		System.out.println(footerLinkCount);
		
		//Give me links count present in first column of footer section of website.
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int firstColLinkCount = columnDriver.findElements(By.tagName("a")).size();
		System.out.println(firstColLinkCount);
		
		//Click on each link in the column and check if the pages are opening or not.
		for(int i=1; i<firstColLinkCount; i++)
		{
			Actions a = new Actions(driver);
			a.moveToElement(columnDriver.findElements(By.tagName("a")).get(i)).keyDown(Keys.COMMAND).click().build().perform();
		}
		
		Set <String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.close();
	}

}
