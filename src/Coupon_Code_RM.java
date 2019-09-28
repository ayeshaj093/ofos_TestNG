
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Coupon_Code_RM {
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
	public void Add_Coupon_Code() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='dash_board_nav_bar']//a[contains(text(),'My Account')]")).click();
		Thread.sleep(1000);
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
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void Edit_Coupon_code() throws InterruptedException {
		driver.findElement(By.xpath("//tr[2]//td[8]//a[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='discount']")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='discount']")).sendKeys("20");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='btnEditCoupon']")).click();
		Thread.sleep(5000);
	}
	@Test(priority=3)
	public void Delete_Coupon_code() {
		driver.findElement(By.xpath("//tr[3]//td[8]//a[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
	}
}
