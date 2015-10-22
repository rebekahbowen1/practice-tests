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

public class AccessMyCalendar {

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
	wd.findElement(By.xpath("html/body/div[3]/header/div[2]/div/div[2]/div[1]/div/div/ul/li[3]/a")).click();
	
	// add an event
	wd.findElementByXPath("html/body/div[3]/div[3]/div/div[2]/div/div[2]/div[1]/a").click();
	
	//enter required text
	new Select(wd.findElementById("event_add_form_top_calendar_event_event_type")).selectByVisibleText("Birthday");
	wd.findElementById("event_add_form_top_calendar_event_name").sendKeys("Rebekah's Birthday");
	new Select(wd.findElementById("event_add_form_top_calendar_event_event_day")).selectByVisibleText("12");
	new Select(wd.findElementById("event_add_form_top_calendar_event_event_month")).selectByVisibleText("December");
	wd.findElementByXPath("html/body/div[3]/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/fieldset/ol/li[1]/input").click();
	
	wd.close();	
		}


		}