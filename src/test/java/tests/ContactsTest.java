package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.ContactsPage;
import pages.UserRegistrationPage;

public class ContactsTest extends TestBase
{
    ContactsPage contactObject;
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
    public void userCanClickOnNewContactsLink()
    {
        driver.switchTo().frame("mainpanel");
        contactObject = new ContactsPage(driver);
        contactObject.userCanOpenNewContactPage();
        contactObject.userCanCreateNewContactInformation("Ahmed","mokhtar","mohamed"
                ,"fathElbab","QAcart","tester","programming","sleem"
                ,"yehia","said","haram-street","giza","cairo"
                ,"egypt","we just be carfully","123566885","21545544"
                ,"215466685","2555520","Ahmed@mokhtar.com");
    }
    @Test(priority = 3)
    public void userCanClickOnLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
