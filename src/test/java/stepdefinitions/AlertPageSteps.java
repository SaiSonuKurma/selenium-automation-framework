package stepdefinitions;

import com.pages.AlertPage;
import com.qa.factory.Driverfactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertPageSteps {
//    private AlertPage alertPage = new AlertPage(Driverfactory.getDriver());

    private AlertPage getAlertPage() {
        return new AlertPage(Driverfactory.getDriver());
    }

    @When("User clicks on Alert, Frame & Windows")
    public void user_clicks_on_alert_frame_windows() {
        // Write code here that turns the phrase above into concrete actions
        getAlertPage().clickAlertFrameWindow();
    }

    @Then("User clicks on Alerts")
    public void user_clicks_on_alerts() {
        // Write code here that turns the phrase above into concrete actions
        getAlertPage().clickAlert();
    }

    @Then("User clicks on prompt click me button")
    public void user_clicks_on_prompt_click_me_button() {
        // Write code here that turns the phrase above into concrete actions
        getAlertPage().clickclickmebutton();
    }

    @Then("user enters text {string}")
    public void user_enters_text(String string) {
        // Write code here that turns the phrase above into concrete actions
        getAlertPage().enterAlertText(string);
    }

    @Then("User clicks on OK button")
    public void user_clicks_on_ok_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        getAlertPage().acceptAlert();
    }
}
