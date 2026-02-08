package stepdefinitions;

import com.pages.LoginPage;
import com.qa.factory.Driverfactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageSteps {
    private static String title;
    private LoginPage loginpage = new LoginPage(Driverfactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        Driverfactory.getDriver().get("https://demoqa.com/login");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        // Write code here that turns the phrase above into concrete actions
        title = loginpage.getLoginPageTitle();
        System.out.println("login page title is "+ title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String ExpectedTitle) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(title.contains(ExpectedTitle));
    }

    @Then("New User button should be displayed")
    public void forgot_password_link_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(loginpage.isNewUserButtonExists());
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        // Write code here that turns the phrase above into concrete actions
        loginpage.enterusername(username);
    }

    @And("user enters password {string}")
    public void user_enters_password(String password) {
        // Write code here that turns the phrase above into concrete actions
        loginpage.enterpassword(password);
    }

    @And("user clicks on login")
    public void user_clicks_on_login() {
        // Write code here that turns the phrase above into concrete actions
        loginpage.clickSignInButton();
    }

}