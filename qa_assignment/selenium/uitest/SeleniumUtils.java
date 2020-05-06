package uitest;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/***
 * Note: make sure all benchmark images are copied from resources to resourcesraw from eclipse, do not rename 
 *
 */
public class SeleniumUtils {
	private static String systemPath = "/Users/fangfanghu/Documents/All/Careers/202002job-hunting/Companies/skycope/QA_assignment/qa_assignment/";

	public static boolean verifyScreenshot(WebDriver driver, String name) throws IOException {
		File fileA=new File(systemPath + "selenium/resources/" + name);
		//if(!fileA.exists()) {
			File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, fileA);
		//}
		File fileB=new File(systemPath + "selenium/resourcesraw/" + name);
		BufferedImage dataInput=ImageIO.read(fileA);
		DataBuffer bufferFileA=dataInput.getData().getDataBuffer();
		int FileA=bufferFileA.getSize();
		BufferedImage dataOutPut=ImageIO.read(fileB);
		DataBuffer bufferFileB=dataOutPut.getData().getDataBuffer();
		int FileB=bufferFileB.getSize();
		Boolean matchimg=false;
		if (FileA==FileB) {
			matchimg=true;
			for (int i = 0; i < FileA; i++) {
				if (bufferFileA.getElem(i)!=bufferFileB.getElem(i)) {
					matchimg=false;
					break;
				}
			}
		}else {
			matchimg=false;
		}

		return matchimg;
	}
	
	public static boolean isContentAppeared(WebDriver driver,String content) {  
	    boolean status = false;  
	    try {  
	        driver.findElement(By.xpath("//*[contains(.,'" + content + "')]"));  
	        System.out.println(content + " is appeard!");  
	        status = true;  
	    } catch (NoSuchElementException e) {  
	        status = false;  
	        System.out.println("'" + content + "' doesn't exist!");  
	    }  
	    return status;  
	}  
	
	public static boolean isTextInInput(WebDriver driver,String inputName, String inputText) {  
	    boolean status = false;  
	    try {  
	    	status = driver.findElement(By.name(inputName)).getText().equals(inputText);
	        System.out.println(driver.findElement(By.name(inputName)).getAttribute("Value") + " is appeard!");  
	        status = true;  
	    } catch (NoSuchElementException e) {  
	        status = false;  
	        System.out.println("'" + inputText + "' doesn't exist!");  
	    }  
	    return status;  
	}  

}
