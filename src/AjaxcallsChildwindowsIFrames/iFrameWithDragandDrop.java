package AjaxcallsChildwindowsIFrames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class iFrameWithDragandDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("==remote-allow-origins");
		
		WebDriver driver = new ChromeDriver(ops);
		
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://jqueryui.com/droppable/");
		
		//switch to iFrame
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		
		Actions a = new Actions(driver);
		a.dragAndDrop(source, destination).build().perform();
		
		String msg = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
		Assert.assertEquals(msg, "Dropped!");
		
		driver.close();
	}

}
