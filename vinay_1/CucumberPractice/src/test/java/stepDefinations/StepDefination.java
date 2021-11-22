//install tidy gherkin plugin in chrome
//Run feature file- Ru as feature file
//configure convert to cucumber project
//cucumbr option and stepdefanition should have same parent


package stepDefinations;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import pageObjects.SigninPage;

public class StepDefination  {

	 public WebDriver driver;
	 
	@Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vinay Gudapati\\Desktop\\Main project\\chromedriver_win32\\chromedriver.exe" );
		driver=new ChromeDriver();
            }

	@And("^Navigate to  \"([^\"]*)\" site$")
    public void navigate_to_something_site(String url) throws Throwable {
		driver.get(url);  
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
		
		
    }
	@And("^Click on Login link in home page to land on Secure sign in Page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
        SigninPage l= new SigninPage(driver);
        l.getLoginbtn().click();
        
        
        
    }
	@When("I entered valid (.+) and valid (.+) logs in$")
    public void i_entered_valid_and_valid_logs_in(String username, String password) throws Throwable {
		SigninPage lp=new SigninPage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
        lp.getSignin().click();
    }
	
    
	@Then("^Click on signin button$")
    public void click_on_signin_button() throws Throwable {
        
}
	//adding a new post
	@When("^I click on the posts button$")
    public void i_click_on_the_posts_button() throws Throwable 
	{
        driver.findElement(By.xpath("//div[text()='Posts']")).click();
    }

    @And("^I click on the add New button in posts page$")
    public void i_click_on_the_add_new_button_in_posts_page() throws Throwable 
    {
        driver.findElement(By.xpath("//a[@class='page-title-action']")).click();
    }

    @And("^Enter the post name in the text box$")
    public void enter_the_post_name_in_the_text_box() throws Throwable 
    {
        driver.findElement(By.xpath("//input[@name='post_title']")).sendKeys("whitevillashouse");
    }

    @And("^click on publish button$")
    public void click_on_publish_button() throws Throwable
    {
      driver.findElement(By.xpath("//input[@name='publish']")).click();   
      driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }
    @Then("^Verify Weather new post is added or not$")
    public void verify_weather_new_post_is_added_or_not() throws Throwable 
    {
    	String post = driver.findElement(By.xpath("//h1[text()='Edit Post']")).getText();
    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa--------"+post);
        Assert.assertEquals("Edit Post",post);
    }
    @Then("^close broswer$")
    public void close_broswer() throws Throwable 
    {
        driver.close();
    }
    
    //checking weather drop down is working or not
    @When("^I click on all posts button$")
    public void i_click_on_all_posts_button() throws Throwable 
    {
    	driver.findElement(By.xpath("//a[text()='All Posts']")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^I click on Bulk Actions dropdown in all posts page$")
    public void i_click_on_bulk_actions_dropdown_in_all_posts_page() throws Throwable 
    {
    	driver.findElement(By.xpath("//select[@id='bulk-action-selector-top']")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^I click on All dates dropdown in all posts page$")
    public void i_click_on_all_dates_dropdown_in_all_posts_page() throws Throwable 
    {
    	driver.findElement(By.xpath("//select[@id='filter-by-date']")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^I click on All Categories dropdown in all posts page$")
    public void i_click_on_all_categories_dropdown_in_all_posts_page() throws Throwable 
    {
    	driver.findElement(By.xpath("//select[@id='cat']")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^I click on Screen Options dropdown in all posts page$")
    public void i_click_on_screen_options_dropdown_in_all_posts_page() throws Throwable 
    {
    	driver.findElement(By.xpath("//button[@id='show-settings-link']")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^I click on Help dropdown in all posts page$")
    public void i_click_on_help_dropdown_in_all_posts_page() throws Throwable 
    {
    	driver.findElement(By.xpath("//button[@id='contextual-help-link']")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }
    
    //adding categories
    @When("^I click on categories button$")
    public void i_click_on_categories_button() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[4]/a")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^Enter category name in name textbox$")
    public void enter_category_name_in_name_textbox() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"tag-name\"]")).sendKeys("whitevillas");
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }
    @And("^I select the option in parent category dropdown$")
    public void i_select_the_option_in_parent_category_dropdown() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"parent\"]")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }
    @And("^I click on the Add new category button$")
    public void i_click_on_the_add_new_category_button() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }
    @And("^Enter the category name in the search text box$")
    public void enter_the_category_name_in_the_search_text_box() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"tag-search-input\"]")).sendKeys("whitevillas");
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^click on Search Categories button$")
    public void click_on_search_categories_button() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }
    
    //adding tags
    @When("^I click on Tag button$")
    public void i_click_on_tag_button() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[5]/a")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^Enter Tag name in name textbox$")
    public void enter_tag_name_in_name_textbox() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"tag-name\"]")).sendKeys("white_villas_house");
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^Enter slug in slug textbox$")
    public void enter_slug_in_slug_textbox() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"tag-slug\"]")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^I enter the Description in description textbox$")
    public void i_enter_the_description_in_description_textbox() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"tag-description\"]")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^I click on the Add new Tag button$")
    public void i_click_on_the_add_new_tag_button() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }
    @And("^Enter the Tag name in the search text box$")
    public void enter_the_tag_name_in_the_search_text_box() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"tag-search-input\"]")).sendKeys("white_villas_house");
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @And("^click on Search Tags button$")
    public void click_on_search_tags_button() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }
    
    
    //checking search box
    @And("^Enter the post name in the search text box$")
    public void enter_the_post_name_in_the_search_text_box() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"post-search-input\"]")).sendKeys("whitevillashouse");
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }
    @And("^click on Search Posts button$")
    public void click_on_search_posts_button() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }
    @And("^click on Dashboard button$")
    public void click_on_dashboard_button() throws Throwable 
    {
    	driver.findElement(By.xpath("//*[@id=\"menu-dashboard\"]/a/div[3]")).click();
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }
    //posts
    @Given("^click on the all posts option$")
    public void click_on_the_all_posts_option() throws Throwable 
    {
        
    }

    @When("^user click on each option$")
    public void user_click_on_each_option() throws Throwable 
    {
        
    }

    @Then("^very option will display related content$")
    public void very_option_will_display_related_content() throws Throwable 
    {
    	for(int i=1;i<=6;i++) {
    		driver.findElement(By.xpath("//*[@id='wpbody-content']//div[3]//ul//li["+ i +"]//a")).click();
    		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);//wait
    		} 
    }

    @And("^user gets some options$")
    public void user_gets_some_options() throws Throwable 
    {
        
    }




}