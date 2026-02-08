package stepdefinitions;

import com.pages.BookStorePage;
import com.pages.LoginPage;
import com.qa.factory.Driverfactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStorePageSteps {

    private WebDriver driver;

    private BookStorePage bookStorePage =  new BookStorePage(Driverfactory.getDriver());

    @Given("User is logged into the book store")
    public void user_is_logged_into_the_book_store() {
        // Write code here that turns the phrase above into concrete actions
        driver = Driverfactory.getDriver();
        driver.get("https://demoqa.com/login");
        driver.findElement(By.id("userName")).sendKeys("saisonu");
        driver.findElement(By.id("password")).sendKeys("Sonu@2000");
        driver.findElement(By.id("login")).click();
    }

    @Given("user is on book store page")
    public void user_is_on_book_store_page() {
        // Write code here that turns the phrase above into concrete actions
        bookStorePage.bookstorepagetitle();
    }
    @Given("user is on profile page")
    public void user_is_on_profile_page() {
        // Write code here that turns the phrase above into concrete actions
        bookStorePage.bookstorepagetitle();
    }

    @And("User clicks on bookstore")
    public void user_clicks_on_bookstore() {
        // Write code here that turns the phrase above into concrete actions
        bookStorePage.bookstoreicon();
    }

    @When("books count should be {int}")
    public void books_count_should_be(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        bookStorePage.getthebookscount();
    }

    @When("Search with {string}")
    public void search_with(String string) {
        // Write code here that turns the phrase above into concrete actions
        bookStorePage.enterbookname(string);
    }

    @Then("Author name should be {string}")
    public void author_name_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        bookStorePage.findbookauthor();
    }
}
