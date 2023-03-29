package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.CompaniesPage;
import pages.UserRegistrationPage;

public class CompaniesTest extends TestBase
{
    CompaniesPage companyObject;
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
    public void userCanClickOnCompanyLink()
    {
        driver.switchTo().frame("mainpanel");
        companyObject=new CompaniesPage(driver);
        companyObject.userOpenCompany
                ("QAcart","I don't know.","We just be Cerfully","Fodic"
                        ,"#programming,#selenium","Maadi-Street 7");
    }
    @Test(priority = 3)
    public void userCanClickOnLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
