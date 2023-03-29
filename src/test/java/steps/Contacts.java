package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalendarPage;
import pages.ContactsPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class Contacts extends TestBase
{
    UserRegistrationPage registerObject;
    ContactsPage contactsObject;
    CalendarPage calendarObject;
    @Given("the contacts in the userRegistration page")
    public void the_contacts_in_the_userRegistration_page()
    {
        registerObject = new UserRegistrationPage(driver);
        Assert.assertTrue(registerObject.homeLink.getText().contains("Home"));
    }

    @When("I Entered the {string} ,{string}")
    public void iEnteredThe(String username, String password)
    {
        registerObject.userCanLogIn(username,password);
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }

    @When("user Can Click On New Contacts Link")
    public void userCanClickOnNewContactsLink()
    {
        driver.switchTo().frame("mainpanel");
        contactsObject = new ContactsPage(driver);
        contactsObject.userCanOpenNewContactPage();
    }

    @When("user Can Create New Contact Information")
    public void userCanCreateNewContactInformation()
    {
        contactsObject.userCanCreateNewContactInformation("Ahmed","mokhtar","mohamed"
                ,"fathElbab","QAcart","tester","programming","sleem"
                ,"yehia","said","haram-street","giza","cairo"
                ,"egypt","we just be carfully","123566885","21545544"
                ,"215466685","2555520","Ahmed@mokhtar.com");
    }

    @Then("user Can ClickOn Log Out")
    public void userCanClickOnLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
