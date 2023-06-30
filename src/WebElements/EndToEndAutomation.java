package WebElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

public class EndToEndAutomation {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("Ja");
		
		List <WebElement> countriesList = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		for(int i = 0; i< countriesList.size(); i++)
		{
			String countryName = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a")).get(i).getText();
			if(countryName.equalsIgnoreCase("Japan"))
			{
				driver.findElements(By.xpath("//li[@class='ui-menu-item']/a")).get(i).click();
				//testng assertion
				Assert.assertEquals(countryName,"Japan");
				break;
			}
		}
		// 01 selecting departure airport
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//li/a[@text='Jaisalmer (JSA)']")).click();
		Thread.sleep(2000);
//		System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));
		Assert.assertEquals(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"), "Jaisalmer (JSA)");
		
		//02 selecting destination airport
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //li/a[@text='Goa (GOI)']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("value"), "Goa (GOI)");
		Thread.sleep(2000);
		
		//03 slecting current date as a depart date.
		driver.findElement(By.cssSelector("td.ui-datepicker-today")).click();
//		System.out.println(driver.findElement(By.id("view_fulldate_id_1")).getText());
		Assert.assertEquals(driver.findElement(By.id("view_fulldate_id_1")).getText(),"Sun, Jun 25 2023");
		
		//04 Checking return date calender UI is disabled or not?
		boolean disabled = driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5");
		
		if(disabled)
		{
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Its not disabled");
		}
		
		//05 Add paggengers adult 5, child 2 and infant 1
		
		driver.findElement(By.id("divpaxinfo")).click();
		int adult = 1;
		while(adult < 5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			adult ++;
		}
		
		int child = 0;
		while(child < 2)
		{
			driver.findElement(By.id("hrefIncChd")).click();
			child ++;
		}
		
		driver.findElement(By.id("hrefIncInf")).click();
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult, 2 Child, 1 Infant");
		
		//06 Change currency to USD
		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		WebElement currencyOptions = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select options = new Select(currencyOptions);
		options.selectByVisibleText("USD");
		
		//Firstly, store the first selected value of dropdown and use this in assertion
		String slectedOption = options.getFirstSelectedOption().getText();
		Assert.assertEquals(slectedOption, "USD");
		
		//07 Select any of two checkboxes and validate them
		driver.findElement(By.xpath("//label[@for='ctl00_mainContent_chk_StudentDiscount']")).click();
		driver.findElement(By.xpath("//label[@for='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[@for='ctl00_mainContent_chk_StudentDiscount']")).getText(), "Student");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@for='ctl00_mainContent_chk_friendsandfamily']")).getText(), "Family and Friends");
		
		//08 Now search the flights on behalf of given informations
		driver.findElement(By.xpath("//span //input[@type='submit']")).click();
		
		Thread.sleep(2000);
		driver.close();
	}
}
