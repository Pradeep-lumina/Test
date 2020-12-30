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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserManagement {

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
		
		WebElement user = driver.findElement(By.xpath("//a[text()=' User Management ']"));
		user.click();
		Thread.sleep(2000);		
		
		File file = new File("D:\\Desktop\\06 DOCC\\LFCN\\usermgmt1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
				
		for(int i=1; i<=sh.getLastRowNum(); i++) {
			
			String FN = sh.getRow(i).getCell(0).getStringCellValue();
			String LN = sh.getRow(i).getCell(1).getStringCellValue();
			String EMAIL = sh.getRow(i).getCell(2).getStringCellValue();
			String PWD = sh.getRow(i).getCell(3).getStringCellValue();
			
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
			WebElement adduser = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
			adduser.click();
			Thread.sleep(5000);
			
			WebElement firstname = driver.findElement(By.xpath("//input[@formcontrolname='firstname']"));
			firstname.sendKeys(FN);
			Thread.sleep(2000);
			
			WebElement lastname = driver.findElement(By.xpath("//input[@formcontrolname='lastname']"));
			lastname.sendKeys(LN);
			Thread.sleep(2000);
			
			WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='emailid']"));
			email.sendKeys(EMAIL);
			Thread.sleep(2000);
			
			WebElement passcode = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
			passcode.sendKeys(PWD);
			Thread.sleep(2000);
			
			Select slt = new Select(driver.findElement(By.xpath("//select[@formcontrolname='roleid']")));
			slt.selectByIndex(1);
			Thread.sleep(2000);
			
			WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));
			submit.click();
			Thread.sleep(5000);
			
			
			
		}
		
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
		

	}

}
