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

public class Food_Items_Admin {
	WebDriver driver;

	@BeforeTest
	public void Start_Browser() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(1000);
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://www.demo.iscripts.com/netmenus/mrml/admin");
		Thread.sleep(1000);
		//screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("D:\\Screenshots\\adminn"));
		Thread.sleep(1000);
		//title
		String actualtitle=driver.getTitle();
		System.out.println("The title of the page is:" +actualtitle);
		Thread.sleep(1000);
	}

	@Test(priority=0)
	public void Login() {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("admin");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//button[@name='submit']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     }
	@Test(priority=1)
	public void Add_Food_items() {
		//scroll down
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1500)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(),'Food Items')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='addrecord btn btn-info']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='activity_name']")).sendKeys("Shawarma");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='jqSubmitForm']")).click();
	}
	@Test(priority=2)
	public void Edit_Food_items() {
		driver.findElement(By.xpath("//a[@id='jqEditRecord_529']//img[@class='table_iconset li_iconset']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='activity_name']")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='activity_name']")).sendKeys("Rasmalai");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='jqSubmitForm']")).click();	
	}
	@Test(priority=3)
	public void Search_Food_Item() throws InterruptedException {
		driver.findElement(By.id("searchText")).sendKeys("Aaloo Samosa");
		Thread.sleep(1000);
		driver.findElement(By.id("section_search_button")).click();
	}
	@Test(priority=4)
	public void Delete_Food_item() {
		//scroll down
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0, 1500)");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//a[contains(text(),'Food Items')]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("//tr[@id='jqRecord_537']//a[contains(@class,'cms_list_operation action_delete')]//img[contains(@class,'li_iconset')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
	}
}
