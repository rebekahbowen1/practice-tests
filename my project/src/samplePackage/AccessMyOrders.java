package samplePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;
import org.openqa.selenium.support.ui.Select;

public class AccessMyOrders {

	FirefoxDriver wd = new FirefoxDriver ();
	String baseURL="http://www.public.integration.qa.noths.com/session/new#login";
	WebDriverWait wait = new WebDriverWait(wd,5);
	
			
	@Test
	public void test () throws InterruptedException {
	//visiting the sign in page
	wd.get(baseURL);
	
	//signing in
	wd.findElementById("email").sendKeys("admin@notonthehighstreet.com");
	wd.findElementById("password").sendKeys("logmein1");
	wd.findElementById("button_existing_customer").click();
	
	//locate the my account menu
	new Actions(wd).moveToElement(wd.findElement(By.xpath("//*[@id='account_hat_links']/span/a"))).perform();
	Thread.sleep(2000);
	
	// click on the account menu item 
	wd.findElement(By.xpath("//*[@id='account_hat_links']/div/div/ul/li[2]/a")).click();
	
	//contact the customer 
	wd.findElementByXPath(".//*[@id='order_17']/div/div[2]/div[1]/a[3]").click();
	
	// enter a message and submit the form
	wd.findElementByXPath(".//*[@id='message_body']").sendKeys("hello this is a test message to the Partner");
	wd.findElementByXPath(".//*[@id='submit']").click();
	
	
	wd.close();	
		}


		}