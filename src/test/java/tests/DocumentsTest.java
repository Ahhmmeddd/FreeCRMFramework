package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.DocumentsPage;
import pages.UserRegistrationPage;

public class DocumentsTest extends TestBase
{
    DocumentsPage documentsObject;
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
    public void UserCanOpenNewDocumentPage()
    {
        driver.switchTo().frame("mainpanel");
        documentsObject = new DocumentsPage(driver);
        documentsObject.userCanClickOnNewDocumentLink("Automated On document Page"
                ,"we can automated now and ubdating data"
                ,"2.6","251451","QAcart","in the rate of 80%","fell data on page"
                ,"adding","#Khaleel");
        documentsObject.userCanClicOnNewDirectoryLink("Mokhtar//Documents","this directory for documents page");
        Assert.assertTrue(documentsObject.directoryFolder.getText().contains("Mokhtar//Documents"));
    }
    @Test(priority = 3)
    public void userCanClickOnLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }

}
