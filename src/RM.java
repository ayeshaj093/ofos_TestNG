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

public class RM {
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
@Test
public void Login() {
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("restaurant@netmenus.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("restaurant");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@class='login_btn']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test
public void Add_Restaurant() {
	driver.findElement(By.xpath("//input[@id='venue_name']")).sendKeys("Cafe Villa");
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
	driver.findElement(By.xpath("//textarea[@id='venue_description']")).sendKeys("House of World class Coffee");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//scroll down
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("window.scrollBy(0,1500)");
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
@Test
public void Add_Menu() {
	driver.findElement(By.xpath("//a[@class='venue']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[@class='addmore_class jQAddServiceFn']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='class_name']")).sendKeys("Breakfast");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='start_time']/option[17]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='end_time']/option[23]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@name='add']")).click();
}
@Test
public void Edit_Menu() {
	driver.findElement(By.xpath("//div[@id='menulist_123']//img")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='class_name']")).clear();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='class_name']")).sendKeys("BreakFast");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@name='add']")).click();
}
@Test
public void Add_Food_items() {
	driver.findElement(By.xpath("//a[@class='schedules-active']")).click();
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
@Test
public void Edit_Food_item() {
	driver.findElement(By.xpath("//div[contains(@class,'addclass_wrapper vendor_staff_outer')]//div[2]//div[2]//a[1]//img[1]")).click();
	driver.findElement(By.xpath("//input[@id='activity_name']")).sendKeys("Fried Onion rings");
	//scroll down
	JavascriptExecutor js11=(JavascriptExecutor)driver;
	js11.executeScript("window.scrollBy(0,1200)");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@id='add_fooditem']")).click();
}
@Test
public void Delete_Food_item() {
	driver.findElement(By.xpath("//div[contains(@class,'places')]//div[1]//div[2]//a[2]//img[1]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.switchTo().alert().accept();
}
@Test
public void Add_Coupon_Code() {
	driver.findElement(By.xpath("//a[@class='active']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[contains(text(),'Coupon Code')]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[@class='addmore_class right']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='coupon_codename']")).sendKeys("AA40");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//select[@id='discountType']/option[03]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='discount']")).sendKeys("40");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='impressions_allowed']")).sendKeys("10");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//select[@id='venueId']/option[07]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//select[@id='startdate']/option[05]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//select[@id='startmonth']/option[10]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//select[@id='startyear']/option[02]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//select[@id='enddate']/option[31]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//select[@id='endmonth']/option[13]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//select[@id='endyear']/option[02]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='btnEditCoupon']")).click();
}
@Test
public void Edit_Coupon_code() {
	driver.findElement(By.xpath("//a[@class='editCoupon']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='discount']")).clear();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='discount']")).sendKeys("20");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='btnEditCoupon']")).click();
}
@Test
public void Delete_Coupon_code() {
	driver.findElement(By.xpath("//a[@class='btndeleteCoupon']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.switchTo().alert().accept();
}
}

