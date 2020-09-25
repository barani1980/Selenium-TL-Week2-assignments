package Week2.Day2.assignments.Assignment1;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Dropdown.html");
		Thread.sleep(2000);
		
		driver.findElementByXPath("//select[@id='dropdown1']/option[2]").click();
		Thread.sleep(1000);
		
		driver.findElementByXPath("(//select[@name='dropdown2'])/option[text()='Appium']").click();
		Thread.sleep(1000);
		
		driver.findElementByXPath("(//select[@name='dropdown3'])/option[@value='3']").click();
		Thread.sleep(1000);
		
		WebElement dropdowns = driver.findElementByXPath("//select[@class='dropdown']");
		Select dd = new Select(dropdowns);
		List<WebElement> options = dd.getOptions();
		int count = options.size();
		System.out.println("Dropdown Options Count = " + (count-1));
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[@class='example'][5]/select").sendKeys("L" + Keys.TAB);
		Thread.sleep(3000);
		
		WebElement lastBox = driver.findElementByXPath("//div[@class='example'][6]/select");
		Select dd2 = new Select(lastBox);
		
		dd2.selectByValue("1");
		dd2.selectByValue("2");
		Thread.sleep(3000);
		
		driver.close();
	}

}
