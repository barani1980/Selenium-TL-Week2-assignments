package Week2.Day2.assignments.Assignment1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");
		Thread.sleep(2000);
		
		
		driver.findElementByXPath("//div[@class='example'][1]//following::input[1]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//div[@class='example'][1]//following::input[3]").click();
		Thread.sleep(1000);
		
		boolean secondQuestion = driver.findElementByXPath("//div[@class='example'][2]//following::input[1]").isSelected();
		if (secondQuestion) {
			System.out.println("Confirm Selenium is checked optionbox is already selected");
		}
		else {
			System.out.println("Confirm Selenium is checked optionbox is NOT selected");
		}
		
		
		boolean thirdQuestion1 = driver.findElementByXPath("//div[@class='example'][3]//following::input[1]").isSelected();
		boolean thirdQuestion2 = driver.findElementByXPath("//div[@class='example'][3]//following::input[2]").isSelected();
		if (thirdQuestion1) {
			driver.findElementByXPath("//div[@class='example'][3]//following::input[1]").click();
		}
		if (thirdQuestion2) {
			driver.findElementByXPath("//div[@class='example'][3]//following::input[2]").click();
		}
		Thread.sleep(2000);
		
		
		driver.findElementByXPath("//div[@class='example'][4]//following::input[1]").sendKeys(Keys.SPACE);
		driver.findElementByXPath("//div[@class='example'][4]//following::input[2]").click();
		driver.findElementByXPath("//div[@class='example'][4]//following::input[3]").click();
		driver.findElementByXPath("//div[@class='example'][4]//following::input[4]").click();
		driver.findElementByXPath("//div[@class='example'][4]//following::input[5]").click();
		
				
		Thread.sleep(2000);
		driver.close();
	}

}
