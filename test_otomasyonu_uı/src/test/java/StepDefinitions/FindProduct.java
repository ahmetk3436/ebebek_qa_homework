package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindProduct {
	
	WebDriver driver = null;
	String productName = "";
@Given("user is on website")
public void user_is_on_website() {
    System.out.println("Sitedeyiz");
    driver = new ChromeDriver();
	String projectPath = System.getProperty("user.dir");
	System.out.println("Project path is : "+ projectPath);
	
	System.getProperty("webdriver.chrome.driver",projectPath + "/ebebek/src/test/resources/drivers/chromedriver.exe");
	
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.navigate().to("https://www.e-bebek.com/");
}

@When("search bar write biberon")
public void search_bar_write_biberon() {
    System.out.println("Biberonu arattık");
    driver.findElement(By.id("txtSearchBox")).sendKeys("biberon");
}

@And("search bar click")
public void search_bar_click() {
    System.out.println("Arama butonuna tıklandı");
    driver.findElement(By.id("txtSearchBox")).sendKeys(Keys.ENTER);
}

@When("find and click first product")
public void find_and_click_first_product(){
	List<WebElement> products = driver.findElements(By.cssSelector("eb-product-list-item"));
	String[] productNameArray = products.get(0).getText().split(" - " );
	productName = productNameArray[1];
	System.out.println(productName);
	products.get(0).click();
	System.out.println("İlk ürün bulundu");
}

@When("click add basket button")
public void click_add_basket_button(){
	System.out.println("Sepete eklendi");
    driver.findElement(By.id("addToCartBtn")).submit();
    driver.switchTo().frame(0);
}

@When("click see basket button")
public void click_see_basket_button() throws InterruptedException{
	System.out.println("Sepete gidildi");
driver.switchTo().frame(0);
driver.switchTo().defaultContent();
Thread.sleep(300);
	driver.findElement(By.className("close-button")).click();
	driver.findElement(By.id("iconMiniCart")).click();
}

@And("check basket for add product")
public void check_basket_for_add_product() throws InterruptedException {
	Thread.sleep(1500);
if(productName.contains(driver.findElement(By.className("basket-content")).findElement(By.cssSelector("h2")).getText()))
   {
	   System.out.println("Sepet kontrolü başarılı ");
   }
}

@Then("complete the program")
public void complete_the_program() {
    System.out.println("Program başarıyla sonuçlandı !");
}
}
