package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalendarPage;
import pages.FormsPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class Forms extends TestBase
{
    UserRegistrationPage registerObject;
    FormsPage formsObject;
    CalendarPage calendarObject;
    @Given("the forms in the userRegistration page")
    public void  theFormsInTheUserRegistrationPage()
    {
        registerObject = new UserRegistrationPage(driver);
        Assert.assertTrue(registerObject.homeLink.getText().contains("Home"));
    }

    @When("I entered this {string} ,{string}")
    public void iEnteredThis(String username, String password)
    {
        registerObject.userCanLogIn(username,password);
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }

    @When("User Can Open New Form Page")
    public void userCanOpenNewFormPage()
    {
        driver.switchTo().frame("mainpanel");
        formsObject = new FormsPage(driver);
        formsObject.userCanClickOnNewFormLink("New Form","6","ahmedmokhtar@gmail.com"
                ,"this a new form created by me and fell report email and fell pages count"
                ,"Hello everyOne in My new Form","Hello everyOne in My new Form");
        Assert.assertTrue(formsObject.FormAssertion.getText().contains("New Form"));
    }

    @Then("user Can Click On LogOut link")
    public void userCanClickOnLogOutLink()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
