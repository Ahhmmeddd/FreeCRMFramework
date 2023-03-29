package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase
{
    UserRegistrationPage registerObject;

    @Test(priority = 1)
    public void UserCanOpenLogInPage()
    {
        registerObject = new UserRegistrationPage(driver);
        registerObject.userCanLogIn("Ahmed_1","123456789");
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
    }
}
