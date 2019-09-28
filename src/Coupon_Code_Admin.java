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

public class Coupon_Code_Admin {
	WebDriver driver;
	@BeforeTest
	public void startbrowser() throws InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver.exe");
	driver= new ChromeDriver();
	
	driver.manage().window().maximize();
	Thread.sleep(1000);
	
	driver.get("https://www.demo.iscripts.com/netmenus/mrml/admin");
	Thread.sleep(1000);

	//screenshot
	TakesScreenshot ts=(TakesScreenshot)driver;
	File file=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file,new File("D:\\Screenshots\\admin"));	
	//title
	String actualtitle=driver.getTitle();
	System.out.println("The title of the page is:" +actualtitle);
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
	public void Add_Coupon_Code() {
		driver.findElement(By.xpath("//a[contains(text(),'Coupon Codes')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//scroll down
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class='addrecord btn btn-info']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='ccCode']")).sendKeys("BB10");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//textarea[@id='ccDescription']")).sendKeys("10%off on min.order of 100");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='ccDiscount']")).sendKeys("10");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='ccNumberOfImpression']")).sendKeys("12");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='jqSubmitForm']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	@Test(priority=2)
	public void Edit_Coupon_Code() {
		driver.findElement(By.xpath("//a[@id='jqEditRecord_25']//img[contains(@class,'table_iconset li_iconset')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='ccStartDate']")).sendKeys("09/03/2019");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='ccEndDate']")).sendKeys("10/31/2019");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='ccThreshouldAmount']")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='ccThreshouldAmount']")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='jqSubmitForm']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=3)
	public void Search_Coupon_code() throws InterruptedException {
		driver.findElement(By.cssSelector("#searchText")).sendKeys("BB10");
		Thread.sleep(1000);
		driver.findElement(By.id("section_search_button")).click();
	}
	@Test(priority=4)
	public void Delete_Coupon_Code() {
		driver.findElement(By.xpath("//a[contains(text(),'Coupon Codes')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//tr[@id='jqRecord_13']//a[contains(@class,'cms_list_operation action_delete')]//img[contains(@class,'li_iconset')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.switchTo().alert().accept();
		}
	
}
