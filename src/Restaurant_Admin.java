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

public class Restaurant_Admin {
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
  public void add_restaurant() {
    //restaurant
	driver.findElement(By.xpath("//li[6]//a[1]")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//a[@class='addrecord btn btn-info']")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    driver.findElement(By.xpath("//input[@id='venue_name']")).sendKeys("Bigbasket Restaurant");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//textarea[@id='venue_description']")).sendKeys("Big basket Restaurant");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='venue_address_by_user']")).sendKeys("Judges Park,Chicago");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='zip_code']")).sendKeys("154868");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //scroll down
    JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(1000,1500)");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='tags']")).sendKeys("American,Italian,Indian,Chinese");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//label[1]//input[1]")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
   WebElement option1=driver.findElement(By.xpath("//input[@id='takout']"));
    if (option1.isSelected())
    {
    	System.out.println("Already checked On");
    }
    else
    {
    	option1.click();
    	System.out.println("toggled OFF & clicked");
    }
    
    driver.findElement(By.xpath("//select[@id='created_by']/option[3]")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='store_manager']")).sendKeys("Smith");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='store_manager_email']")).sendKeys("smith123@gmail.com");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='min_order_amount']")).sendKeys("100");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='sales_tax']")).sendKeys("2");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//select[@id='delivery_fee_type']/option[2]")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='delivery_fee']")).sendKeys("5");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //scrolldown
    JavascriptExecutor js1=(JavascriptExecutor)driver;
    js1.executeScript("window.scrollBy(1500,2000)");
    
    driver.findElement(By.xpath("//input[@id='commission']")).sendKeys("2");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='jqSubmitForm']")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//button[contains(@class,'btn btn-mini btn-danger')]")).click();
    
	}
  
@Test(priority=2)
public void edit_restaurant() {
	driver.findElement(By.xpath("//a[@id='jqEditRecord_237']//img[contains(@class,'table_iconset li_iconset')]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@id='venue_name']")).clear();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='venue_name']")).sendKeys("BigBasket Restaurant");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//textarea[@id='venue_description']")).clear();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//textarea[@id='venue_description']")).sendKeys("Big basket Restaurant test");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//scroll down
	JavascriptExecutor js11=(JavascriptExecutor)driver;
	js11.executeScript("window.scrollBy(1200,2000)");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	WebElement option2=driver.findElement(By.xpath("//input[@id='catering']"));		
	if(option2.isSelected())
	{
		System.out.println("Already checked ON");
	}
	else
	{
		option2.click();
		System.out.println("toggled OFF & clicked");
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//scroll down
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(2000, 2600)");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@id='jqSubmitForm']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test(priority=3)
 public void Search_Restaurant() throws InterruptedException  {
	driver.findElement(By.id("searchText")).sendKeys("Brew Point");
	Thread.sleep(1000);
	driver.findElement(By.id("section_search_button")).click();
}
  @Test(priority=4)
  public void delete_restaurant() {
	  
	  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[9]/a[3]/img[1]")).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.switchTo().alert().accept();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
}
