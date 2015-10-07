package samplePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

public class WishListPurchase {

	FirefoxDriver wd = new FirefoxDriver ();
	String baseURL="http://www.public.integration.qa.noths.com/wish-list";
	WebDriverWait wait = new WebDriverWait(wd,5);
	
	
	@Test
	public void test () {
	//find a wish list
	wd.get(baseURL);
	wd.findElementByXPath(".//*[@id='term']").sendKeys("test@usertest.com");
	wd.findElementByXPath(".//*[@id='wish_list']/div[3]/div/form/fieldset[2]/input").click();
	
	
	 wd.findElementByXPath(("//input[starts-with(@id,'safe_place_for_courier')]")).sendKeys("home");  //use when there are dynamic elements on the page
	wd.findElementByXPath("//*[@id='add_to_cart']").click();

	WebElement checkoutmodal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shopping_buttons']/a[2]")));
	checkoutmodal.click();
	
	//proceed to checkout
	wd.findElementByXPath(".//*[@id='edit_cart']/section[2]/div/div[2]/span/button").click();
		
	//welcome page
	WebElement signinemail = wd.findElementByXPath("//*[@id='email']");
	if (signinemail.isEnabled() ) 
		signinemail.sendKeys("admin@notonthehighstreet.com");
	
	WebElement signinpassword = wd.findElementByXPath("//*[@id='password']");
	if (signinpassword.isEnabled() ) 
		signinpassword.sendKeys("logmein1");
	wd.findElementById("button_existing_customer").click();
	
	//Delivery 
	wd.findElementById("button_continue").click();
	
	//Payment flow choice (QA only)
	wd.findElementByXPath(".//*[@id='content']/form/input").click();
	
	//Payment page
	wd.findElementByXPath(".//*[@id='payment_medium_payment_form_credit_card']").click();
	
	//Payment form
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_credit_card_attributes_type")));
	new Select(wd.findElementById("checkout_credit_card_attributes_type")).selectByVisibleText("Visa Debit or Electron");
	

	wd.findElementById("checkout_credit_card_attributes_number").sendKeys("4263971921001307");
	wd.findElementById("checkout_credit_card_attributes_name").sendKeys("Hans Peter Luhn");
	new Select(wd.findElementById("checkout_credit_card_attributes_expiry_month")).selectByVisibleText("6");
	new Select(wd.findElementById("checkout_credit_card_attributes_expiry_year")).selectByVisibleText("2018");
	wd.findElementById("checkout_credit_card_attributes_verification_value").sendKeys("737");
	
	//Skip 3DS
	wd.findElementById("checkout_skip_3d_secure").click();
	
	wd.findElementByXPath("//*[@id='process_payment_button']").click();
	
	wd.close();	
	}


	}
		
	
	
	
	

	



	
	
