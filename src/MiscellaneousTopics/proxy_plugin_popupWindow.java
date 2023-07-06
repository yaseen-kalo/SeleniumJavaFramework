package MiscellaneousTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.Proxy;

public class proxy_plugin_popupWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// USEFUL LINK https://chromedriver.chromium.org/capabilities (MUST VISIT)

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");

		// add extension
		ops.addExtensions(new File("/EXTENSION FILE PATH"));

		// Proxy
		WebDriver driver = new ChromeDriver(ops);
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress: 192.168.0.1");
		ops.setCapability("proxy", proxy);

		// pop up Window
		ops.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

	}
}
