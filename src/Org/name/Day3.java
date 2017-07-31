package Org.name;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day3 {
	public static void main(String[] args) {
		WebDriver driver;
		String error="* The maximum quantity allowed for purchase is 500.";
		System.setProperty("webdriver.gecko.driver","/home/pace/Downloads/geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//a[contains(text(),'Mobile')]")).click();
		driver.findElement(By.xpath("(.//*[@class='button btn-cart'])[2]")).click();
		
		System.out.println(driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/div/ul/li/ul/li/span")).getText());
		
		driver.findElement(By.xpath(".//*[@title='Qty']")).sendKeys("1000");
		driver.findElement(By.xpath(".//*[@title='Update']")).click();
		
		String errormsg=driver.findElement(By.xpath(".//p[@class='item-msg error']")).getText();
		System.out.println(errormsg);
		
		if(errormsg.equalsIgnoreCase(error))
		{
			System.out.println("Test Passsed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		driver.findElement(By.xpath(".//*[@id='empty_cart_button']")).click();
		
		System.out.println(driver.findElement(By.xpath(".//*[@class='page-title']/h1")).getText());
		System.out.println(driver.findElement(By.xpath(".//*[@class='cart-empty']/p[1]")).getText());
		
		driver.close();
		
	}
}
