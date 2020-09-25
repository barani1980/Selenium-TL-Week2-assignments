package Week2.Day2.assignments.Assignment1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagePage {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Image.html");
		Thread.sleep(3000);
		
		driver.findElementByXPath("//img[@src='../images/home.png']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//a[@href='pages/Image.html']").click();
		Thread.sleep(3000);
		
		String broken = driver.findElementByXPath("//img[@src='../images/abcd.jpg']").getAttribute("src");
		driver.get(broken);
		String title = driver.getTitle();
		boolean error = title.contains("404");
		
		if (error) {
		System.out.println("The image IS broken");
		}
		else {
		System.out.println("The image is NOT broken");
		}
		Thread.sleep(4000);
		
		driver.get("http://leafground.com/pages/Image.html");
		Thread.sleep(4000);
		driver.findElementByXPath("//img[@src='../images/keyboard.png']").click();
		Thread.sleep(4000);
		driver.close();
		
	}

}
