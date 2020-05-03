package uitest;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserFlowRegisterTest {
		private WebDriver driver;
		private Navigation navigation;
		private String baseUrl = "http://localhost:8080/Web_Application/logon.jsp";
		//http://68d56a5d.ngrok.io/Web_Application/

		@Before
		public void setUp() {
			//设置Chrome浏览器的位置
			System.setProperty("webdriver.chrome.driver", "/Users/fangfanghu/Documents/All/Tech/Selenium_Practice/chromedriver");
					
			//创建WebDriver对象
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1280,800));
			navigation = driver.navigate();
		}

		@After
		public void tearDown() {
			if(driver!=null) {
				driver.close();
			}
		}	
		
		@Test
		public void openRegisterPage() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
		}

		@Test
		public void registerSuccessfully() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_filled.png"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login_return_from_register.png"));
		}

		@Test
		public void registerFailedEmptyFirstName() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			//driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_firstname.png"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
		}	

		@Test
		public void registerFailedEmptyLastName() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			//driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_lastname.png"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
		}	

		@Test
		public void registerFailedEmptyUserName() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			//driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_username.png"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
		}	
		
		@Test
		public void registerFailedEmptyPassword() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			//driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_password.png"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
		}	

		@Test
		public void registerFailedUserNameDenver() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Denver");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_username_denver.png"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
		}	

		@Test
		public void registerSuccessfulEmptyAddress() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			//driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_address.png"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login_return_from_register.png"));
		}	

		@Test
		public void registerSuccessfulEmptyContact() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			//driver.findElement(By.name("contact")).sendKeys("987");
			
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_contact.png"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login_return_from_register.png"));
		}	
}
