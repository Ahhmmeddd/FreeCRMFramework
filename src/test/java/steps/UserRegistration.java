package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalendarPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase
{
    UserRegistrationPage registerObject;
    CalendarPage calendarObject;

    @Given("the user in the userRegistration page")
    public void the_user_in_the_userRegistration_page()
    {
        registerObject = new UserRegistrationPage(driver);
        Assert.assertTrue(registerObject.homeLink.getText().contains("Home"));

    }


    @When("i entered {string} ,{string}")
    public void iEntered(String username, String password)
    {
        registerObject.userCanLogIn(username,password);
    }

    @Then("the registration page displayed successfully")
    public void theRegistrationPageDisplayedSuccessfully()
    {
        driver.switchTo().frame("mainpanel");
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
