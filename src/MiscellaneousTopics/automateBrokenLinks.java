package MiscellaneousTopics;

import java.time.Duration;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class automateBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		SoftAssert sa = new SoftAssert();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		List <WebElement> links = driver.findElements(By.xpath("//table[@class='gf-t']/tbody/tr/td/ul/li/a"));
		
		for(int i = 0; i < links.size(); i++)
		{
			String url = links.get(i).getAttribute("href");
			
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int responseCode = con.getResponseCode();
			sa.assertTrue(responseCode<400, "Link is Broken and Status code is: " + responseCode + " " + links.get(i).getText());
		}
		sa.assertAll();
		
		driver.close();

	}

}
