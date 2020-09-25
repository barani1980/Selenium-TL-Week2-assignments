package Week2.Day2.assignments.Assignment1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLink {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://leafground.com/pages/Link.html");
		Thread.sleep(3000);
		
		driver.findElementByXPath("(//div[@class='example'])[1]//a").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//h5)[3]/..").click();
		Thread.sleep(2000);
		
		WebElement whereItGoes = driver.findElementByXPath("//a[text()='Find where am supposed to go without clicking me?']");
		String link = whereItGoes.getAttribute("href");
		System.out.println("It goes here without clicking - " + link);
		
		driver.findElementByXPath("//a[@href='error.html']").click();
		String title = driver.getTitle();
		boolean error = title.contains("404");
					
		if (error) {
		System.out.println("The link IS broken");
		}
		else {
		System.out.println("The link is NOT broken");
		}
		Thread.sleep(4000);
		
		
		driver.navigate().to("http://leafground.com/pages/Link.html");
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='example'])[4]//a").click();
	
		driver.close();
	}

}
