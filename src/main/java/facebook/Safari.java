package facebook;

import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;

public class Safari {

	public static void main(String[] args) throws InterruptedException {
		Logger.getLogger("").setLevel(Level.OFF); 
		
		WebDriver driver;
		driver = new SafariDriver();
		driver.manage().window().maximize();
		
		System.out.println("Browser is: Safari");
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		
		driver.findElement(By.id("email")).sendKeys("jtursunbaeva@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("attracti10");
		driver.findElement(By.id("u_0_2")).click();
		
		Thread.sleep(3000);
		//CLick on Timeline button
		driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).click();
		
		Thread.sleep(3000);
		
	String friends = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div/div[2]/div[2]/ul/li[3]/a/span[1]")).getText(); ////*[@id="u_fetchstream_5_9"]/li[3]/a/span[1]
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
