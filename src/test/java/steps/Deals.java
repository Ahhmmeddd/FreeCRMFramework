package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalendarPage;
import pages.DealsPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class Deals extends TestBase
{
    UserRegistrationPage registerObject;
    DealsPage dealsObject;
    CalendarPage calendarObject;
    @Given("the deals in the userRegistration page")
    public void the_deals_in_the_userRegistration_page()
    {
        registerObject = new UserRegistrationPage(driver);
        Assert.assertTrue(registerObject.homeLink.getText().contains("Home"));
    }

    @When("IEntered this {string} ,{string}")
    public void ienteredThis(String username, String password)
    {
        registerObject.userCanLogIn(username,password);
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }

    @When("user Can Click On New Deals Link")
    public void userCanClickOnNewDealsLink()
    {
        driver.switchTo().frame("mainpanel");
        dealsObject = new DealsPage(driver);
        dealsObject.userCanOpenNewDealPage();
    }

    @When("user Can Create A new Deal")
    public void userCanCreateANewDeal()
    {
        dealsObject.userCreateDeal("createNewProject","QAcart","021145","5","80"
                ,"20","no","#InteligiIdea","Hello EveryOne","go to the productLink"
                ,"100","20-3-2022","10-8-2022","Ahmed","HI");
        Assert.assertTrue(dealsObject.fieldSets.getText().contains("Field sets"));
    }

    @Then("user Can ClickOn LogOut")
    public void userCanClickOnLogOut()
    {
        calendarObject=new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
