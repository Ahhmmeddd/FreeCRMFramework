package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalendarPage;
import pages.CallPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class Call extends TestBase
{
    UserRegistrationPage registerObject;
    CallPage callObject;
    CalendarPage calendarObject;
    @Given("the call in the userRegistration page")
    public void theCallInTheUserRegistrationPage()
    {
        registerObject = new UserRegistrationPage(driver);
        Assert.assertTrue(registerObject.homeLink.getText().contains("Home"));
    }

    @When("I entered {string} ,{string}")
    public void iEntered(String username, String password)
    {
        registerObject.userCanLogIn(username,password);
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }

    @When("user Can Click On New Call Link")
    public void userCanClickOnNewCallLink()
    {
        driver.switchTo().frame("mainpanel");
        callObject = new CallPage(driver);
        callObject.userCanClickOnNewCallLink();
    }

    @When("user Can Entered Call Information")
    public void user_Can_Entered_Call_Information()
    {
        callObject.userCanEnteredCallInformation("for reminder date","Sleem","01254879652"
                ,"Elnawiyse","22","Okay","changing data","create a new call"
                ,"we need call to sleem and elnawiyse");
    }

    @When("user Can Click On Call Scripts Link")
    public void userCanClickOnCallScriptsLink()
    {
        callObject.userCanClickOnCallScriptsLink("changing data","click on call scripts page and fell data "
                ,"you can automated On this page ?","15");
    }

    @Then("user Can Click On Log Out")
    public void userCanClickOnLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
