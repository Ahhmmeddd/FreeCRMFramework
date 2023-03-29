package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.UserRegistrationPage;

public class CalendarTest extends TestBase
{
    CalendarPage calendarObject;
    UserRegistrationPage registerObject;

    @Test(priority = 1)
    public void UserCanOpenLogInPage()
    {
        registerObject = new UserRegistrationPage(driver);
        registerObject.userCanLogIn("Ahmed_1","123456789");
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }
    @Test(priority = 2)
    public void userCanOpenNewEventPage()
    {
        driver.switchTo().frame("mainpanel");
        calendarObject = new CalendarPage(driver);
        calendarObject.userClickOnCalendarLink();
        Assert.assertTrue(calendarObject.user.getText().contains("Ahmed Mokhtar"));
    }
    @Test(priority = 3)
    public void userCanClickOnLogOut()
    {
        calendarObject.userCanLogOut();
    }
}
