package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Domain {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		
		driver.get("https://lfcn.luminad.com/#/");
		Thread.sleep(2000);
		
		WebElement userid = driver.findElement(By.xpath("//input[@formcontrolname='emailid']"));
		userid.sendKeys("admin@yopmail.com");
		Thread.sleep(2000);
		
		WebElement pwd = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		pwd.sendKeys("1234");
		Thread.sleep(2000);
		
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign In']"));
		login.click();
		Thread.sleep(2000);
		
		WebElement master = driver.findElement(By.xpath("//a[text()=' Master ']"));
		master.click();
		Thread.sleep(2000);
		
		WebElement domain = driver.findElement(By.xpath("//a[text()=' Domain Master ']"));
		domain.click();
		Thread.sleep(2000);
		
		File file = new File("D:\\Desktop\\06 DOCC\\LFCN\\Domain2.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
				
		for(int i=1; i<=sh.getLastRowNum(); i++) {
			
		String DOMAINVALUE = sh.getRow(i).getCell(0).getStringCellValue();
		
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
		WebElement adddomain = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		adddomain.click();
		Thread.sleep(2000);
		
		WebElement domainvalue = driver.findElement(By.xpath("//input[@formcontrolname='domain']"));
		domainvalue.sendKeys(DOMAINVALUE);
		Thread.sleep(2000);
		
		WebElement domainadd = driver.findElement(By.xpath("//span[text()='Add']"));
		domainadd.click();
		Thread.sleep(20000);
		
		}
		
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();

	}

}
