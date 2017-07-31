package Org.name;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day2 {
	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","/home/pace/Downloads/geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//a[contains(text(),'Mobile')]")).click();
		
		String home=driver.findElement(By.xpath(".//ul[@class='products-grid products-grid--max-4-col first last odd']/li[2]/div/div[1]/span")).getText();
		System.out.println(home);
		
		driver.findElement(By.xpath(".//*[@title='Xperia']")).click();
		
		System.out.println(driver.getTitle());
		
		String detail= driver.findElement(By.xpath(".//*[@id='product-price-1']/span")).getText();
		System.out.println(detail);
		
		if(detail.equalsIgnoreCase(home))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		driver.close();
	}

}
