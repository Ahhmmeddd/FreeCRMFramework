package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.CasesPage;
import pages.UserRegistrationPage;

public class CasesTest extends TestBase
{
    CasesPage casesObject;
    UserRegistrationPage registerObject;
    CalendarPage calendarObject;

    @Test(priority = 1)
    public void UserCanOpenLogInPage()
    {
        registerObject = new UserRegistrationPage(driver);
        registerObject.userCanLogIn("Ahmed_1","123456789");
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }
    @Test(priority = 2)
    public void userCanOpenNewCasePage()
    {
        driver.switchTo().frame("mainpanel");
        casesObject = new CasesPage(driver);
        casesObject.userCanClickOnNewCaseLink();
            casesObject.userCanEnterdCaseInformation("Add A new case","Mokhtar","#Ahmed,#mohamed,#selenium",
                "we need add a new cases and changing data","2514260","00A");
            Assert.assertTrue(casesObject.titleOfAnewCase.getText().contains("Add A new case"));
    }
    @Test(priority = 3)
    public void userCanOpenFullSearchForm()
    {
        casesObject.userCanClickOnFullSearchFrom();
        casesObject.userCanEnteredSearchCase("Add A new case","#Doaa","we need searching in form"
                ,"bugReport","Mokhtar","QAcart","12546");
    }
    @Test(priority = 4)
    public void userCanClickOnLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
