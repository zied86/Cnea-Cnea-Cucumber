package com.Cnea.autehtication.stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class authenticationStepDefinition {
	
	
	
	WebDriver driver;

	@Given("Je me connecte sur l'application CNE")
	public void Je_me_connectesur_lapplication_CNEA(){
		System.setProperty("webdriver.chrome.driver","C:\\ToolsQA\\Libs\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.shop.demoqa.com");
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String arg1)  {
		driver.navigate().to("https://shop.demoqa.com/?s=" + arg1 + "&post_type=product");
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		items.get(0).click();

		WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		addToCart.click();		
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart(){
		WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
		cart.click();

		WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
		continueToCheckout.click();		
	}

}
