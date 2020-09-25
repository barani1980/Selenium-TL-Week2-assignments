package Week2.Day2.assignments;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		
		driver.findElementByXPath("//span[text()='Email']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("babu@testleaf.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		String firstName = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a").getText();
		String lastName = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-lastName']/a").getText();
		
		
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@class='subMenuButton']").click();
		Thread.sleep(2000);
		
		String title = driver.findElementByXPath("//div[@id='sectionHeaderTitle_leads']").getText();
				
		if (title.equals("Duplicate Lead")) {
			System.out.println("We successfully navigated to Duplicate lead link");
		}
		else {
			System.out.println("We couldnot navigate to Duplicate lead link");
		}
		
		driver.findElementByXPath("//input[@value='Create Lead']").click();
		
		String dupFirst = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
		String dupLast = driver.findElementByXPath("//span[@id='viewLead_lastName_sp']").getText();
		
		System.out.println("Original lead name is " + firstName + " " + lastName);
		System.out.println("Duplicate lead name is " + dupFirst + " " + dupLast);
		
		if (firstName.equals(dupFirst) && lastName.equals(dupLast)) {
			System.out.println("Duplicate lead is successfully created");
			}
			else  {
			System.out.println("Duplicate lead NOT successfully created");
		}
		
		driver.close();
	}
	
}
