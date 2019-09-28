import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Food_Item_RM {
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
	public void Add_Food_items() {
		driver.findElement(By.xpath("//a[contains(text(),'Nigiri Sushi - 29 Aug,2019')]")).click();
		driver.findElement(By.xpath("//a[@class='schedules']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='addmore_class jQAddServiceFn']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='activity_name']")).sendKeys("Swirly cheese Fries");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//scroll down
		JavascriptExecutor js11=(JavascriptExecutor)driver;
		js11.executeScript("window.scrollBy(0,1300)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='activity_price']")).sendKeys("80");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='add_fooditem']")).click();
	}
	@Test(priority=2)
	public void Edit_Food_item() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Grand - 21 Aug,2018')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='schedules']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'places')]//div[1]//div[2]//a[1]//img[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='activity_name']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='activity_name']")).sendKeys("Fried Onion rings");
		//scroll down
		JavascriptExecutor js11=(JavascriptExecutor)driver;
		js11.executeScript("window.scrollBy(0,1200)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("add_fooditem")).click();
	}
	@Test(priority=3)
	public void Delete_Food_item() {
		driver.findElement(By.xpath("//div[3]//div[2]//a[2]//img[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
	}
}
