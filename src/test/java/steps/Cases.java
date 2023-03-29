package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalendarPage;
import pages.CasesPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class Cases extends TestBase {

    UserRegistrationPage registerObject;
    CasesPage casesObject;
    CalendarPage calendarObject;
    @Given("the cases in the userRegistration page")
    public void the_cases_in_the_userRegistration_page()
    {
        registerObject = new UserRegistrationPage(driver);
        Assert.assertTrue(registerObject.homeLink.getText().contains("Home"));
    }

    @When("I Entered {string} ,{string}")
    public void iEntered(String username, String password)
    {
        registerObject.userCanLogIn(username,password);
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }

    @When("user Can Open New Case Page")
    public void userCanOpenNewCasePage()
    {
        driver.switchTo().frame("mainpanel");
        casesObject = new CasesPage(driver);
        casesObject.userCanClickOnNewCaseLink();


    }

    @When("user Can Entered Case Information")
    public void userCanEnteredCaseInformation()
    {
        casesObject.userCanEnterdCaseInformation("Add A new case","Mokhtar","#Ahmed,#mohamed,#selenium",
                "we need add a new cases and changing data","2514260","00A");
        Assert.assertTrue(casesObject.titleOfAnewCase.getText().contains("Add A new case"));
    }

    @When("user Can Open Full Search Form")
    public void userCanOpenFullSearchForm()
    {
        casesObject.userCanClickOnFullSearchFrom();
        casesObject.userCanEnteredSearchCase("Add A new case","#Doaa","we need searching in form"
                ,"bugReport","Mokhtar","QAcart","12546");
    }

    @Then("user can click on log out")
    public void userCanClickOnLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
