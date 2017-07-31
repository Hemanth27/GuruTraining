package Org.name;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Day1 {

	public static void main(String[] args) throws InterruptedException {
		String titleoriginal="This is demo site for   ";
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","/home/pace/Downloads/geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		String title=driver.getTitle();
		System.out.println(title);
		
		if(title.equalsIgnoreCase(titleoriginal))
		{
			System.out.println("Test Pass");
		}
		else{
			System.out.println("Test Fail");
		}
		
		WebElement mobileclick= driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		mobileclick.click();
		
		String mobilepage_title="Mobile";
		
		String actualMobile=driver.getTitle();
		
		if(actualMobile.equalsIgnoreCase(mobilepage_title))
		{
			System.out.println("Test passed");
		}
		else{
			System.out.println("Test Failed");
		}
		
		Select selectoption= new Select(driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
		selectoption.selectByVisibleText("Name");
		
		Thread.sleep(2000);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("/home/pace/Desktop.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		
	}
}
