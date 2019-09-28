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

public class Users_Admin {
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
	public void Add_users() {
		driver.findElement(By.xpath("//li[9]//a[1]")).click();
		//add
		driver.findElement(By.xpath("//a[@class='addrecord btn btn-info']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Ayesha");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Jabeen");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("er.ayeshaz93@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Minds123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='status']/option[1]")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='jqSubmitForm']")).click();
	}
	@Test(priority=2)
	public void Edit_User() {
		driver.findElement(By.xpath("//a[@id='jqEditRecord_228']//img[@class='table_iconset li_iconset']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='gender']/option[3]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("09/26/1993");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='status']/option[02]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='jqSubmitForm']")).click();
	}
	@Test(priority=3)
	public void Search_User() throws InterruptedException {
		driver.findElement(By.id("searchText")).sendKeys("Ayesha");
		Thread.sleep(1000);
		driver.findElement(By.id("section_search_button")).click();
	}
@Test(priority=4)
public void Delete_User() {
	driver.findElement(By.linkText("Users")).click();
	driver.findElement(By.xpath("//tr[@id='jqRecord_182']//a[contains(@class,'cms_list_operation action_delete')]//img[contains(@class,'li_iconset')]")).click();
	driver.switchTo().alert().accept();
}
}
