package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalendarPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class Calendar extends TestBase
{
    UserRegistrationPage registerObject;
    CalendarPage calendarObject;

    @Given("the calendar in the userRegistration page")
    public void theCalendarInTheUserRegistrationPage()
    {
        registerObject = new UserRegistrationPage(driver);
        Assert.assertTrue(registerObject.homeLink.getText().contains("Home"));
    }

    @When("i Entered {string} ,{string}")
    public void iEntered(String username, String password)
    {
        registerObject.userCanLogIn(username,password);
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }

    @When("user Click On Calendar Link")
    public void userClickOnCalendarLink()
    {
        driver.switchTo().frame("mainpanel");
        calendarObject = new CalendarPage(driver);
        calendarObject.userClickOnCalendarLink();
        Assert.assertTrue(calendarObject.user.getText().contains("Ahmed Mokhtar"));
    }

    @Then("user Can Click On LogOut")
    public void userCanClickOnLogOut()
    {
        calendarObject.userCanLogOut();
    }
}
