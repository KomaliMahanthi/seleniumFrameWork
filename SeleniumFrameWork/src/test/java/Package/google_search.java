package Package;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class google_search {
	WebDriver driver;
	String url = "https://www.google.com";

	
	@Before
	public void setUp()throws Exception{

	System.setProperty("webdriver.chrome.driver","C:\\Users\\Mypc\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(2000);


	}

	@Test
	public void testSearchWebpage()throws Exception{

		driver.findElement(By.name("q")).sendKeys("automation tools"); //search keywords related to "automation tools"
		List<WebElement> webElement = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		for(int i=0;i<webElement.size();i++)
		{
			String value = webElement.get(i).getText();
			System.out.println(webElement.size());
			if(value.contains("automation tools for testing"))  //chooses "automation tools for testing"
			{
				//Thread.sleep(2000);
				webElement.get(i).click();
				break;
			}
		}
	}
}

