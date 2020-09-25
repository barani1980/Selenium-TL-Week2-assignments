package Week2.Day2.assignments.Assignment1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Edit.html");
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id = 'email']").sendKeys("editpage@tl.com");
		Thread.sleep(2000);
		driver.findElementByXPath("//input[contains(@value,'Append')]").sendKeys(" Appending text and pressing TAB key");
		Thread.sleep(2000);
		driver.findElementByXPath("//input[contains(@value,'Append')]").sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElementByXPath("(//input[@name='username'])[1]").sendKeys("TestLeaf");
		Thread.sleep(2000);
		driver.findElementByXPath("(//input[@name='username'])[2]").clear();
		Thread.sleep(3000);
		
		boolean field = driver.findElementByXPath("//label[text()='Confirm that edit field is disabled']/following-sibling::input").isEnabled();
		if (field = true) {
			System.out.println("The field IS disabled");
		}	
			else {
				System.out.println("The field is NOT disabled");
			}
		
		driver.close();
	}
		
		
}
