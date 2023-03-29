package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.DealsPage;
import pages.UserRegistrationPage;

public class DealsTest extends TestBase
{
    DealsPage dealObject;
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
    public void userCanClickOnNewDealsLink()
    {
        driver.switchTo().frame("mainpanel");
        dealObject = new DealsPage(driver);
        dealObject.userCanOpenNewDealPage();
    }
    @Test(priority = 3)
    public void userCanCreateAnewDeal()
    {
        dealObject.userCreateDeal("createNewProject","QAcart","021145","5","80"
                ,"20","no","#InteligiIdea","Hello EveryOne","go to the productLink"
                ,"100","20-3-2022","10-8-2022","Ahmed","HI");
        Assert.assertTrue(dealObject.fieldSets.getText().contains("Field sets"));

    }
    @Test(priority = 4)
    public void userCanClickOnLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }


}
