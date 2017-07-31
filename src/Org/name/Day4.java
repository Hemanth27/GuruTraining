package Org.name;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day4 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","/home/pace/Downloads/geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//a[contains(text(),'Mobile')]")).click();
		System.out.println("Sony Comparaing");
		
		String mainsony=driver.findElement(By.xpath(".//a[@title='Sony Xperia']")).getText();
		String mainipone=driver.findElement(By.xpath("(.//a[@title='IPhone'])[2]")).getText();
		driver.findElement(By.xpath("(.//*[@class='link-compare'])[2]")).click();
		
		System.out.println("IPhone Comparaing");
		driver.findElement(By.xpath("(.//*[@class='link-compare'])[3]")).click();
		
		driver.findElement(By.xpath("(.//*[@class='button'])[1]")).click();
		Thread.sleep(2000);
		
		for(String handle : driver.getWindowHandles()){
			driver.switchTo().window(handle);
		}
		
		String header ="COMPARE PRODUCTS";
		String compheader=driver.findElement(By.xpath(".//*[@class='page-title title-buttons']/h1")).getText();
		
		String popsony=driver.findElement(By.xpath("(.//*[@title='Sony Xperia'])[2]")).getText();
		String popiphone=driver.findElement(By.xpath("(.//*[@title='IPhone'])[2]")).getText();
		
		try{
			assertEquals(compheader, header);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try{
			assertEquals(popsony, mainsony);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		try{
			assertEquals(popiphone, mainipone);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Thread.sleep(5000);
		
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath(".//*[@class='button']")).click();
		
		for(String handle : driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
		
		driver.close();
		
	}

}
