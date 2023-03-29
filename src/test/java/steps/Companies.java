package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalendarPage;
import pages.CompaniesPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class Companies extends TestBase
{
    UserRegistrationPage registerObject;
    CompaniesPage companiesObject;
    CalendarPage calendarObject;
    @Given("the companies in the userRegistration page")
    public void the_companies_in_the_userRegistration_page()
    {
        registerObject = new UserRegistrationPage(driver);
        Assert.assertTrue(registerObject.homeLink.getText().contains("Home"));
    }

    @When("IEntered {string} ,{string}")
    public void ientered(String username, String password)
    {
        registerObject.userCanLogIn(username,password);
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }

    @When("user Can Click On Company Link")
    public void userCanClickOnCompanyLink()
    {
        driver.switchTo().frame("mainpanel");
        companiesObject = new CompaniesPage(driver);
        companiesObject.userOpenCompany("QAcart","I don't know.","We just be Cerfully"
                ,"Fodic","#programming,#selenium","Maadi-Street 7");
    }

    @Then("user Can Click On log Out")
    public void userCanClickOnLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
