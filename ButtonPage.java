package Week2.Day2.assignments.Assignment1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Button.html");
		
		driver.findElementByXPath("//button[@id='home']").click();
		driver.findElementByXPath("//a[@href='pages/Button.html']").click();
		
		Point location = driver.findElementByXPath("//label[text()='Find position of button (x,y)']/following-sibling::button").getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("X axis location is " + x + " and Y axis location is " + y);
		
		String buttonColor = driver.findElementByXPath("//button[@id='color']").getCssValue("color");
		System.out.println("Button color is: " + buttonColor);
		
		Dimension size = driver.findElementByXPath("//button[@id='size']").getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println("Height is " + height + " Width is " + width);
		
				
		driver.close();
		
	}

}
