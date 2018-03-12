package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BrokenLinkTest {
	
	static WebDriver driver;
	
	public void brokenLinkTest() throws IOException{
		//1. Get the list of all the links and images.
		
				List<WebElement> linkList = driver.findElements(By.tagName("a"));
				linkList.addAll(driver.findElements(By.tagName("img")));
				System.out.println("No. available of link--->"+linkList.size());
				System.out.println(linkList);
				
				List<WebElement> activeList = new ArrayList<WebElement>();
				
				//2. Iterate all the linkList and Exclude all the links and img doesn't have href Attribute /*&& (linkList.get(i).getAttribute("href").contains("javascript"))*/
				
				for(int i=0; i<linkList.size(); i++){
					System.out.println(linkList.get(i).getAttribute("href"));
					if(linkList.get(i).getAttribute("href") != null && (!linkList.get(i).getAttribute("href").contains("javascript")) ){
					 activeList.add(linkList.get(i));
					 
					}
				}
				
				//3. Get the size of Active linkList
				System.out.println("size of active link and img---->"+activeList.size());
				//System.out.println("total links---"+ activeList);
				
				//4. check the href url with httpConnection api
				
				for(int j=0; j<activeList.size(); j++){
					HttpURLConnection connection = (HttpURLConnection) new URL(activeList.get(j).getAttribute("href")).openConnection();
					connection.connect();
					String response = connection.getResponseMessage();
					connection.disconnect();
					
					System.out.println(activeList.get(j).getAttribute("href")+"-----"+response);
				}
				
	}
	

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		
		ChromeOptions co = new ChromeOptions();
		//here "--start-maximized" argument is responsible to maximize chrome browser
		co.addArguments("--start-maximized");
		
		System.setProperty("WebDriver.chrome.driver", "D:\\InstalledSoftwares\\LatestSelenium\\chromedriver");
		
		driver = new ChromeDriver(co);
		
		//driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/");
		
		
		driver.findElement(By.name("username")).sendKeys("colbyhike");
		driver.findElement(By.name("password")).sendKeys("123456");
		
		boolean b1 = driver.findElement(By.xpath("//*[@class='input-group-btn']//input[@type= 'submit']")).isDisplayed();
		System.out.println(b1);
		String submitBtn = "//*[@class='input-group-btn']//input[@type= 'submit']";
		WebElement element = driver.findElement(By.xpath(submitBtn));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		element.click();
		//driver.findElement(By.xpath("//*[@class='input-group-btn']//input[@type= 'submit']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("mainpanel");
		
		//links --- a
		//images -- href
		
		//1. Get the list of all the links and images.
		
		
		BrokenLinkTest blt = new BrokenLinkTest();
		blt.brokenLinkTest();
		
	   
  }
}
