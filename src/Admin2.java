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

public class Admin2 {
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

@Test
public void Login() {

	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("admin");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//button[@name='submit']")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }

@Test
public void Add_Food_items() {
	//scrolldown
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
@Test
public void Edit_Food_items() {
	driver.findElement(By.xpath("//a[@id='jqEditRecord_538']//img[@class='table_iconset li_iconset']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='activity_name']")).clear();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='activity_name']")).sendKeys("Rasmalai");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='jqSubmitForm']")).click();	
}
@Test
public void Delete_Food_item() {
	driver.findElement(By.xpath("//tr[@id='jqRecord_537']//a[contains(@class,'cms_list_operation action_delete')]//img[contains(@class,'li_iconset')]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.switchTo().alert().accept();
}
@Test
public void Add_Cuisine() {
	driver.findElement(By.xpath("//a[contains(text(),'Cuisines')]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[@class='addrecord btn btn-info']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='tag_name']")).sendKeys("Indian sweets");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//upload
	WebElement upload=driver.findElement(By.xpath("//input[@id='tag_image']"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	upload.sendKeys("C:\\Users\\Ayesha\\Downloads\\diwali-sweets-2832678_640 (1).jpg");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='jqSubmitForm']")).click();
}
@Test 
public void Edit_Cuisine() {
	driver.findElement(By.xpath("//a[@id='jqEditRecord_94']//img[@class='table_iconset li_iconset']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='tag_name']")).clear();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='tag_name']")).sendKeys("Chinese Food");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='jqSubmitForm']")).click();
}
@Test
public void Delete_Cuisine() {
	driver.findElement(By.xpath("//tr[@id='jqRecord_94']//a[contains(@class,'cms_list_operation action_delete')]//img[contains(@class,'li_iconset')]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.switchTo().alert().accept();
}

}
