package facebook;

import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome {

	public static void main(String[] args) throws InterruptedException {
		Logger.getLogger("").setLevel(Level.OFF); 
		
		WebDriver driver;
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		String driverPath = "";
		
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "./resources/webdrivers/mac/chromedriver";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			driverPath = "./resources/webdrivers/pc/chromedriver.exe";
		else throw new IllegalArgumentException("Unknown OS");
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		System.out.println("Browser is: Chrome");
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		
		driver.findElement(By.id("email")).sendKeys("jtursunbaeva@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("attracti10");
		driver.findElement(By.id("u_0_2")).click();
		
		Thread.sleep(6000);
		//CLick on Timeline button
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div/a/span/span")).click();
		
		Thread.sleep(3000);
		
	String friends = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div/div[2]/div[2]/ul/li[3]/a/span[1]")).getText();
		System.out.println("You have: " + friends + " friends");
		Thread.sleep(5000);
		
		//Click on account settings
		driver.findElement(By.id("userNavigationLabel")).click();
		Thread.sleep(2000);
			
		//Click on Log out button
		driver.findElement(By.linkText("Log Out")).click();
		driver.quit();
	}
	
}