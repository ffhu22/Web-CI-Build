package uitest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
			Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Sign Up"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "first_name", ""));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "last_name", ""));
			Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Sample Register Form"));
		}

		@Test
		public void registerSuccessfully() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			//Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Sign Up"));
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
		    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
			Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Sign Up"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).getAttribute("value").equals("Submit");
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_filled.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "first_name", "Amber"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "last_name", "Grace"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", "Faith"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", "123"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "address", "street1"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "contact", "987"));
			
			
			buttons.get(buttons.size()-1).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login_return_from_register.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
		    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
			Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Sign Up"));
		}

		@Test
		public void registerFailedEmptyFirstName() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
		    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
			Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Sign Up"));
			
			driver.findElements(By.tagName("a")).get(0).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "first_name", ""));
			
			//driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_firstname.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "first_name", ""));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "last_name", "Grace"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", "Faith"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", "123"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "address", "street1"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "contact", "987"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).getAttribute("value").equals("Submit");
			
			buttons.get(buttons.size()-1).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "first_name", ""));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "last_name", ""));
			Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Sample Register Form"));
		}	

		@Test
		public void registerFailedEmptyLastName() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
			driver.findElements(By.tagName("a")).get(0).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "last_name", ""));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			//driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_lastname.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "last_name", ""));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", "Faith"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "first_name", ""));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "last_name", ""));
			
		}	

		@Test
		public void registerFailedEmptyUserName() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
			driver.findElements(By.tagName("a")).get(0).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			//driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_username.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "address", "street1"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "address", ""));
		}	
		
		@Test
		public void registerFailedEmptyPassword() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
			driver.findElements(By.tagName("a")).get(0).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			//driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_password.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "first_name", "Amber"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "first_name", ""));
		}	

		@Test
		public void registerFailedUserNameDenver() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
			driver.findElements(By.tagName("a")).get(0).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Denver");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_username_denver.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", "Denver"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "first_name", "Amber"));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "first_name", ""));
		}	

		@Test
		public void registerSuccessfulEmptyAddress() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
			driver.findElements(By.tagName("a")).get(0).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			//driver.findElement(By.name("address")).sendKeys("street1");
			driver.findElement(By.name("contact")).sendKeys("987");
			
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_address.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", "123"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "address", ""));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login_return_from_register.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
		    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
			Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Sign Up"));
		}	

		@Test
		public void registerSuccessfulEmptyContact() throws IOException{
			//加载到指定url
			navigation.to(baseUrl);
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
			driver.findElements(By.tagName("a")).get(0).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register.png"));
			
			driver.findElement(By.name("first_name")).sendKeys("Amber");
			driver.findElement(By.name("last_name")).sendKeys("Grace");
			driver.findElement(By.name("username")).sendKeys("Faith");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.name("address")).sendKeys("street1");
			//driver.findElement(By.name("contact")).sendKeys("987");
			
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "register_info_empty_contact.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "address", "street1"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "contact", ""));
			
			List<WebElement> buttons = driver.findElements(By.tagName("input"));
			buttons.get(buttons.size()-1).click();
			//Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login_return_from_register.png"));
			Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
		    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
			Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Sign Up"));
		}	
}
