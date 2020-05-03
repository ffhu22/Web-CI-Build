package uitest;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/***
 * Note: make sure all benchmark images are copied from resources to resourcesraw from eclipse, do not rename 
 *
 */
public class SeleniumUtils {

	public static boolean verifyScreenshot(WebDriver driver, String name) throws IOException {
		File fileA=new File("selenium/resources/" + name);
		//if(!fileA.exists()) {
			File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, fileA);
		//}
		File fileB=new File("selenium/resourcesraw/" + name);
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
}
