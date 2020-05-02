package uitest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserFlowLoginTest {
	private WebDriver driver;
	private Navigation navigation;
	private String baseUrl = "http://localhost:8080/Web_Application/logon.jsp";

	@Test
	public void openLoginPage() {
		//设置Chrome浏览器的位置
		System.setProperty("webdriver.chrome.driver", "/Users/fangfanghu/Documents/All/Tech/Selenium_Practice/chromedriver");
				
		//创建WebDriver对象
		driver = new ChromeDriver();
		navigation = driver.navigate();
				
		//加载到指定url
		navigation.to(baseUrl);
		
		//TODO: Verify login UI elements
		//assertEquals(driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(3) > td > a")).getText(), "Sign Up");
		//Click Login, open Homepage
	    driver.findElement(By.name("username")).sendKeys("a");
	    driver.findElement(By.name("password")).sendKeys("a");
	    driver.findElement(By.cssSelector("form")).click();
	    //TODO: Verify Homepage displays, and UI elements are correct
	    
	    //Click Exit to back to login page 
	    //driver.findElement(By.cssSelector("input:nth-child(2)")).click();
	    driver.findElement(By.cssSelector("input")).click();
	    //TODO: Verify login displays
		
		driver.close();
	}
}