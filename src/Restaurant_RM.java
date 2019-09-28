import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Restaurant_RM {
	WebDriver driver;
	@BeforeTest
	public void Open_Browser() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver.exe");
		driver= new ChromeDriver();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://www.demo.iscripts.com/netmenus/mrml/vendor");
		Thread.sleep(1000);
	//screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("D:\\Screenshots\\RM"));
		//title
		String actualtitle=driver.getTitle();
		System.out.println("The title of the page is:" +actualtitle);	
	}
	@Test(priority=0)
	public void Login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("restaurant@netmenus.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("restaurant");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='login_btn']")).click();
		Thread.sleep(5000);
	}
	@Test(priority=1)
	public void Add_Restaurant() {
		//driver.findElement(By.linkText("Manage Restaurant")).click();
		//driver.findElement(By.linkText("Restaurant")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='venue_name']")).sendKeys("Cafe1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='venue_alias']")).sendKeys("Cafe Villa");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='autocomplete_location']")).sendKeys("#Street 12,Judges Park,Chicago");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("154868");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("9870654321");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//scroll down
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1500,2000)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='store_manager']")).sendKeys("Manager.1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='store_manager_email']")).sendKeys("restaurant@netmenus.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='delivery_fee']")).sendKeys("10");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//textarea[@id='venue_description']")).sendKeys("House of World class Coffee");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//scroll down
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(2000,2200)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='min_order_amount']")).sendKeys("50");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='sales_tax']")).sendKeys("0");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='is_payment_direct0']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//check box
		WebElement option1=driver.findElement(By.xpath("//input[@id='takout']"));
		if(option1.isSelected())
		{
			System.out.println("Toggled On");
		}
		else
		{
			option1.click();
			System.out.println("Toggled Off & clicked");
		}
		//scroll down
		JavascriptExecutor js11=(JavascriptExecutor)driver;
		js11.executeScript("window.scrollBy(2000,2300)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	}
}
