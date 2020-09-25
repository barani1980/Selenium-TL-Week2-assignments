package Week2.Day2.assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		
		driver.findElementByXPath("//div[@id='findLeads']//input[@name='firstName']").sendKeys("Barani");
		driver.findElementByXPath("//div[@id='findLeads']//button").click();
		Thread.sleep(4000);
		
		driver.findElementByXPath("(//table[@class='x-grid3-row-table'])[1]//a").click();
		String title = driver.getTitle();
		System.out.println("The title of the page is: " + title);
		
		driver.findElementByXPath("(//div[@class='frameSectionExtra'])[2]/a[text()='Edit']").click();
		driver.findElementById("updateLeadForm_companyName").clear();
		String newCompanyName = "DXC";
		driver.findElementById("updateLeadForm_companyName").sendKeys(newCompanyName);
		driver.findElementByXPath("//form[@id='updateLeadForm']//input[@type='submit']").click();
		Thread.sleep(2000);
		
		String compName = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		boolean contains = compName.contains(newCompanyName);
		if (contains) {
			System.out.println("The company name is rightly updated");
		}
		else {
			System.out.println("The company name is NOT updated");
		}
		
		
		Thread.sleep(2000);
		driver.close();
	}

}
