package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		
		driver.get("https://pubcat-qa.wolterskluwerlr.com/");
		Thread.sleep(2000);
		
		WebElement username = driver.findElement(By.xpath("(//input[@formcontrolname='emailid'])[1]"));
		username.sendKeys("pradeep.sathyamoorthy@luminad.com");
		Thread.sleep(2000);
		
		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys("test");
		Thread.sleep(2000);
		
		WebElement login = driver.findElement(By.xpath("//button[text()='Login']"));
		login.click();
		Thread.sleep(2000);
		
		
		
		

	}

}
