import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Menu_RM {
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
	public void Add_Menu() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Nigiri Sushi - 29 Aug,2019')]")).click();
		driver.findElement(By.linkText("2. Menu")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='addmore_class jQAddServiceFn']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='class_name']")).sendKeys("Breakfast");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='class_name']")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='start_time']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[contains(text(),'12:30 am')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='end_time']")).sendKeys("02:00 am");
//		Thread.sleep(1000);
 //    	driver.findElement(By.xpath("//li[contains(text(),'02:00 am')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='add']")).click();
	}
	@Test(priority=2)
	public void Edit_Menu() {
		driver.findElement(By.xpath("//div[@id='menulist_225']//a[1]//img[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='class_name']")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='class_name']")).sendKeys("BreakFast");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='add']")).click();
	}
}
