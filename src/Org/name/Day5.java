package Org.name;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day5 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","/home/pace/Downloads/geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(.//*[contains(text(),'Account')])[1]")).click();
		driver.findElement(By.xpath(".//*[@class='links']/ul/li[5]")).click();
		
		//Register Page 
		
		driver.findElement(By.cssSelector("[id='firstname']")).sendKeys("Hemanth");
		driver.findElement(By.cssSelector("[id='lastname']")).sendKeys("S");
		driver.findElement(By.cssSelector("[id='email_address']")).sendKeys("hemanth@admin.in");
		driver.findElement(By.cssSelector("[id='password']")).sendKeys("test123");
		driver.findElement(By.cssSelector("[id='confirmation']")).sendKeys("test123");
		driver.findElement(By.xpath("(.//*[@title='Register'])[2]")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(driver.getCurrentUrl());
		String success="Thank you for registering with Main Website Store.";
		String actualsuccess= driver.findElement(By.xpath(".//*[@class='success-msg']/ul/li/span")).getText();
		if(actualsuccess.equalsIgnoreCase(success))
		{
			System.out.println("Test Passed");
		}
		else{
			System.out.println("Test Failed");
		}
		
		driver.findElement(By.xpath(".//*[contains(text(),'TV')]")).click();
		driver.findElement(By.xpath("(.//*[@class='link-wishlist'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='wishlist-view-form']/div/div/button[1]")).click();
		
		driver.findElement(By.cssSelector("[id='email_address']")).sendKeys("hemanth.s@pacewisdom.com");
		driver.findElement(By.cssSelector("#message")).sendKeys("Hello Good Afternoon");
		driver.findElement(By.xpath("(.//*[@type='submit'])[2]")).click();
		
		String shared="Your Wishlist has been shared.";
		String actual_share= driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
		
		if(actual_share.equalsIgnoreCase(shared))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		System.out.println("Test Sceanrio completed Successfully");
	}

}
