package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalendarPage;
import pages.DocumentsPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class Documents extends TestBase
{
    UserRegistrationPage registerObject;
    DocumentsPage documentsObject;
    CalendarPage calendarObject;
    @Given("the documents in the userRegistration page")
    public void the_documents_in_the_userRegistration_page()
    {
        registerObject = new UserRegistrationPage(driver);
        Assert.assertTrue(registerObject.homeLink.getText().contains("Home"));
    }

    @When("I Entered this {string} ,{string}")
    public void iEnteredThis(String username, String password)
    {
        registerObject.userCanLogIn(username,password);
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }

    @When("user Can Click On New Document Link")
    public void userCanClickOnNewDocumentLink()
    {
        driver.switchTo().frame("mainpanel");
        documentsObject = new DocumentsPage(driver);
        documentsObject.userCanClickOnNewDocumentLink("Automated On document Page"
                ,"we can automated now and ubdating data"
                ,"2.6","251451","QAcart","in the rate of 80%","fell data on page"
                ,"adding","#Khaleel");
    }

    @When("user Can Clic On New Directory Link")
    public void userCanClicOnNewDirectoryLink()
    {
        documentsObject.userCanClicOnNewDirectoryLink("Mokhtar//Documents","this directory for documents page");
        Assert.assertTrue(documentsObject.directoryFolder.getText().contains("Mokhtar//Documents"));
    }

    @Then("user Can Click On Log Out link")
    public void userCanClickOnLogOutLink()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
