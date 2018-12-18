package co.selenium.webdriver.basic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchCourse {
	WebDriver driver;
	JavascriptExecutor jse;
	public void invokeBrowser(){
		try {
			System.setProperty("webdriver.chrome.driver","C:\\selenium4Java & drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://www.edureka.co");
			searchAnyCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchAnyCourse() {
		
		try {
			driver.findElement(By.id("homeSearchBar")).sendKeys("java");
			Thread.sleep(3000);
			driver.findElement(By.id("homeSearchBarIcon")).click();
			jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0,1000)");
			driver.findElement(By.xpath("//*[@id=\'add-training-courses\']/a[6]/div[1]/div[2]/div[1]/h3")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchCourse myObj = new SearchCourse();
		myObj.invokeBrowser();
		
	}

}
