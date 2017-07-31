package Org.name;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Day6 {
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
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@class='block-content']/ul/li[8]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@class='button btn-cart']")).click();
		
		driver.findElement(By.xpath("(.//*[@title='Proceed to Checkout'])[1]")).click();
		Thread.sleep(1000);
		
		System.out.println("Billing address");
		driver.findElement(By.xpath(".//*[@id='billing:street1']")).sendKeys("India");
		
		driver.findElement(By.xpath(".//*[@id='billing:city']")).sendKeys("Goa");
		
		Select select= new Select(driver.findElement(By.xpath(".//*[@id='billing:country_id']")));
		select.selectByVisibleText("India");
		
		driver.findElement(By.xpath(".//*[@id='billing:region']")).sendKeys("Panji");
		
		driver.findElement(By.xpath(".//*[@id='billing:postcode']")).sendKeys("123456");
		driver.findElement(By.xpath(".//*[@id='billing:telephone']")).sendKeys("1234567890");
		
		if(driver.findElement(By.xpath(".//*[@id='billing:use_for_shipping_yes']")).isSelected())
		{
			System.out.println("Selected");
		}
		else{
			System.out.println("Not Selected");
		}
		driver.findElement(By.xpath(".//*[@id='billing:use_for_shipping_yes']")).click();
		
		driver.findElement(By.xpath(".//*[@id='billing-buttons-container']/button")).click();
		
		
			driver.findElement(By.xpath(".//*[@id='shipping-method-buttons-container']/button")).click();

	
		
		driver.findElement(By.xpath(".//*[@id='p_method_checkmo']")).click();
		driver.findElement(By.xpath(".//*[@id='payment-buttons-container']/button")).click();
		
		driver.findElement(By.xpath(".//*[@id='review-buttons-container']/button")).click();
		
		System.out.println(driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/div[1]/h1")).getText());

		System.out.println(driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]")).getText());
		
		driver.close();
	}

}
//100004957