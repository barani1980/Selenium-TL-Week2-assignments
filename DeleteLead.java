package Week2.Day2.assignments;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click(); 
		Thread.sleep(2000);
		driver.findElementByLinkText("CRM/SFA").click();
		Thread.sleep(2000);
		driver.findElementByLinkText("Leads").click();
		Thread.sleep(2000);
		driver.findElementByLinkText("Find Leads").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='Phone']/ancestor::a").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("96");
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		String matchedId = driver.findElementByXPath("//table[@class='x-grid3-row-table']//a").getText();
		System.out.println("The first resulting Lead having phone number 99 is: " + matchedId);
		
		driver.findElementByXPath("//table[@class='x-grid3-row-table']//a").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();
		
		driver.findElementByLinkText("Find Leads").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//input[@class=' x-form-text x-form-field'and @name='id']").sendKeys(matchedId);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		
		String result = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
		boolean verifyDelete = result.contains("No records to display");
		if (verifyDelete) {
			System.out.println("The lead was successfully deleted");
		}
		else {
			System.out.println("The lead was NOT successfully deleted");
		}
		driver.close();
		
		
	}

}
