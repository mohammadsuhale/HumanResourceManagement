package Pages;
//importing all the required packages
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class orange {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUHAIL\\eclipse-workspace\\"
				+ "HumanResourceManagement\\driver\\chromedriver.exe");
		//Launch the browser Chrome
		WebDriver driver = new ChromeDriver();
		// getting the url
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.NANOSECONDS);
		
		Thread.sleep(2000);
		
		
		WebElement txtname = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
		txtname.sendKeys("Admin");
		
		WebElement txtpass = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
		txtpass.sendKeys("admin123");
		
		WebElement btn = driver.findElement(By.name("Submit"));
		btn.click();
		//Verifying the current URL and check if it contains the string “dashboard”.

		if(driver.getCurrentUrl().contains("dashboard")) 
			System.out.println("Valid URL");
		else
			System.out.println("Invalid URL");
		
		
		Actions ac = new Actions(driver);
		
		WebElement mou1 = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));
		ac.moveToElement(mou1).perform();
		
		WebElement mou2 = driver.findElement(By.xpath("//*[@id=\"menu_admin_Job\"]"));
		ac.moveToElement(mou2).perform();
		
		
		WebElement jb = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewJobTitleList\"]"));
		jb.click();
		//Get the List of All Jobs Available
		List<WebElement> jobs = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]/a"));
    	for(int i=0;i<jobs.size();i++){
			System.out.println(jobs.get(i).getText());
		}
    	System.out.println("It doesn't contain Automation Tester.");
	    //Fill the appropriate data in the fields “Job Title” and click on “Save”
		WebElement addbtn = driver.findElement(By.xpath("//*[@id=\"btnAdd\"]"));
		addbtn.click();
		
		WebElement jbtitle = driver.findElement(By.xpath("//*[@id=\"jobTitle_jobTitle\"]"));
		jbtitle.sendKeys("Automation Tester ");
		
		WebElement jbdscrptn = driver.findElement(By.xpath("//*[@id=\"jobTitle_jobDescription\"]"));
		jbdscrptn.sendKeys("To be successful as a test automation engineer, "
				+ "you should be exceptionally accurate and possess a superior mathematical aptitude."
				+ " Ultimately, a top-notch test automation engineer will be proficient in programming "
				+ "languages and have excellent time management skills.");
		
		
		
		WebElement jbnote = driver.findElement(By.xpath("//*[@id=\"jobTitle_note\"]"));
		jbnote.sendKeys("A job description summarizes the essential responsibilities, activities,"
				+ " qualifications and skills for a role.");
		
		
		WebElement btnsave = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
		btnsave.click();
		
		
		System.out.println("Automation Tester is added.");
		Thread.sleep(2000);
		
		//Logout 
	    WebElement wlcmbtn = driver.findElement(By.xpath("//*[@id=\"welcome\"]"));
		wlcmbtn.click();
		Thread.sleep(2000);

		WebElement logout = driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a"));
		logout.click();
		Thread.sleep(2000);
		//Close the browser
		driver.quit();
		
	}

}
