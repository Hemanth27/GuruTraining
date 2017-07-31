package Org.name;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day7_8 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","/home/pace/Downloads/geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(.//*[contains(text(),'Account')])[1]")).click();
		driver.findElement(By.xpath(".//*[@class='links']/ul/li[1]")).click();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("test@admin.com");
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("test123");
		driver.findElement(By.xpath(".//*[@id='send2']")).click();
		
		String orginal="100004957";
		String order_number=driver.findElement(By.xpath(".//*[@id='my-orders-table']/tbody/tr/td[1]")).getText();
		
		if(order_number.equals(orginal))
		{
		   System.out.println("Order Found");
		   driver.findElement(By.xpath(".//*[@id='my-orders-table']/tbody/tr/td[6]/span/a[1]")).click();
		}
		else
		{
			System.out.println("Order not found");
		}
		
		String grandtotal_original=driver.findElement(By.xpath(".//*[@id='my-orders-table']/tfoot/tr[3]/td[2]/strong/span")).getText();
		System.out.println("Before Changes Grand Total :" +grandtotal_original);
		driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div[1]/a[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr[1]/td[4]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr[1]/td[4]/input")).sendKeys("1");
		driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr[1]/td[4]/button")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr[2]/td[4]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr[2]/td[4]/input")).sendKeys("1");
		driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr[2]/td[4]/button")).click();
		
		System.out.println(driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText());
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr[1]/td[6]/a")).click();
		
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText());
		
		
	}

}
