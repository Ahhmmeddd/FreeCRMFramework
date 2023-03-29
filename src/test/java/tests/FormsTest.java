package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.UserRegistrationPage;

public class FormsTest extends TestBase
{
    UserRegistrationPage registerObject;
    FormsPage formsObject;

    @Test(priority = 1)
    public void UserCanOpenLogInPage()
    {
        registerObject = new UserRegistrationPage(driver);
        registerObject.userCanLogIn("Ahmed_1","123456789");
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }
    @Test(priority = 2)
    public void UserCanOpenNewFormPage()
    {
        driver.switchTo().frame("mainpanel");
        formsObject = new FormsPage(driver);
        formsObject.userCanClickOnNewFormLink("New Form","6","ahmedmokhtar@gmail.com"
                ,"this a new form created by me and fell report email and fell pages count"
                ,"Hello everyOne in My new Form","Hello everyOne in My new Form");
        Assert.assertTrue(formsObject.FormAssertion.getText().contains("New Form"));

    }
}
