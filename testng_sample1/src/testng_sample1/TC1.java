package testng_sample1;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Assignment_backup_7thJune.Actions;
import Assignment_backup_7thJune.ChromeDriver;
import Assignment_backup_7thJune.WebElement;
import Org.testing.Assertions.AssertionsClass;

public class TC1 
{
	 ChromeDriver driver;		
		
		@BeforeMethod
		public void beforemethod()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sushma\\Desktop\\chrome_version_83_selenium_driver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.youtube.com/");
			System.out.println("before method successfully run TC1");
		}

		@Test
		public void test() throws InterruptedException
		{
			
			
			String expected_url="https://www.youtube.com/feed/trending";
			String expected_email_id="dhruvhome2805@gmail.com";
			
			WebElement signin=driver.findElement(By.xpath("//yt-formatted-string[text()='Sign in']"));
			signin.click();
		
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement gmail_signin=driver.findElement(By.id("identifierId"));
			gmail_signin.sendKeys("dhruvhome2805@gmail.com");
		
			WebElement gmail_next=driver.findElement(By.cssSelector("div#identifierNext"));
			gmail_next.click();
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		//problm 1-necessary bcoz script is running fast so it was not accepting password to write

	//**	WebElement gmail_password=driver.findElement(By.xpath("//input[@*='password']"));
			WebElement gmail_password=driver.findElement(By.name("password"));
			gmail_password.sendKeys("Dhruvhome");
		
			WebElement gmail_passwor_next=driver.findElement(By.cssSelector("div#passwordNext"));
			gmail_passwor_next.click();
		
		
			WebElement Trending=driver.findElement(By.xpath("//yt-formatted-string[text()='Trending']"));
			Trending.click();
			
			Assert.assertTrue(AssertionsClass.assertion(expected_url, driver.getCurrentUrl()));			//hard+soft assertion
			
			Thread.sleep(1000);	
			WebElement avatar_btn_signout=driver.findElement(By.id("avatar-btn"));
			avatar_btn_signout.click();
			Thread.sleep(1000);	
			WebElement actual_email=driver.findElement(By.xpath("//yt-formatted-string[@id='email']"));
			String Actual_email_id=actual_email.getText();
		System.out.println("actual email text is "+Actual_email_id);
			

			
			Assert.assertEquals(Actual_email_id, expected_email_id,"email doesn't matches");		//hard assertion
			
			
		
			Thread.sleep(1000);														//problm 1-necessary bcoz it was not able to click the signout using tab non modifier concept
			WebElement avatar_btn_signout1=driver.findElement(By.id("avatar-btn"));
			avatar_btn_signout.click();
			WebElement signout=driver.findElement(By.id("avatar-btn"));
			Actions ac=new Actions(driver);
			for(int i=0;i<=5;i++)
			{
				ac.sendKeys(Keys.TAB).perform();
			}
				ac.sendKeys(Keys.ENTER).perform();
				System.out.println("test method successfully run TC1");		
		}
		
		@AfterMethod
		public void aftermethod()
		{
			//driver.close();
			System.out.println("after method successfully run TC1");
		}
		
		

}
