package MiscellaneousTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class screenShots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		driver.navigate().to("https://www.facebook.com/");
		TakesScreenshot s = ((TakesScreenshot)driver);
		File SrcFile = s.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("/Users/yaseenkalo/Desktop/ss.png"));
	}

}
