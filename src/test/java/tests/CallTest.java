package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.CallPage;
import pages.UserRegistrationPage;

public class CallTest extends TestBase
{
    CallPage callObject;
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
    public void UserCanOpenNewCallPage()
    {
        driver.switchTo().frame("mainpanel");
        callObject = new CallPage(driver);
        callObject.userCanClickOnNewCallLink();
        callObject.userCanEnteredCallInformation("for reminder date","Sleem","01254879652"
                ,"Elnawiyse","22","Okay","changing data","create a new call"
                ,"we need call to sleem and elnawiyse");

    }
    @Test(priority = 3)
    public void UserCanOpenCallScriptsPage()
    {
        callObject.userCanClickOnCallScriptsLink("changing data","click on call scripts page and fell data "
                ,"you can automated On this page ?","15");
    }
    @Test(priority = 4)
    public void userCanClickOnLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
