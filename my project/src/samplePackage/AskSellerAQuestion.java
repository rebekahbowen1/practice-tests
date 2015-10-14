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

public class AskSellerAQuestion {

	FirefoxDriver wd = new FirefoxDriver ();
	String baseURL="http://www.public.integration.qa.noths.com/planttheatre/product/cocktail-garden-kit-six-varieties-to-grow";
	WebDriverWait wait = new WebDriverWait(wd,5);
	
			
	@Test
	public void test () throws InterruptedException {
	
	//visiting the product page
	wd.get(baseURL);
	
	//clicking the ASAQ button
	wd.findElementById("ask_a_seller").click();
	Thread.sleep(2000);
	
	//enter name & email
	wd.findElementById("new_enquiry_name").sendKeys("my name");
	wd.findElementById("new_enquiry_email").sendKeys("testemail@testemail.com");
	
	//locate the text box and enter text
	wd.findElementById("new_enquiry_message").sendKeys("hello this is a test message to the partner");

	//submit the form
	wd.findElementByXPath("html/body/div[6]/div/div/div/div/form/fieldset[2]/input").click();
	

	if(wd.getTitle().contains("Grow Your Own Cocktail Garden by Plant Theatre"))
	    //Pass
	    System.out.println("Test has Passed");
	else
	    //Fail
	    System.out.println("Test has failed");
	
	
	wd.close();	
		}


	}


		