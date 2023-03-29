package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.TasksPage;
import pages.UserRegistrationPage;

public class TasksTest extends TestBase
{
    TasksPage taskObject;
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
    public void userCanOpenNewTaskPage()
    {
        driver.switchTo().frame("mainpanel");
        taskObject = new TasksPage(driver);
        taskObject.userCanClickOnNewTaskLink();
            taskObject.userEntersTaskInformation("Automation App changing","80"
                ,"Enter Task information ","high quality for testing","#AhmedSleem,#YehiaElnawise,#AhmedAfifi"
                ,"We need just be carfully ","QAcart","5050","AHhmmed");
            Assert.assertTrue(taskObject.titleForAssertion.getText().contains("Automation App changing"));

    }
    @Test(priority = 3)
    public void userCanOpenFullSearchFromPage()
    {
        taskObject = new TasksPage(driver);
        taskObject.userCanClickonFullSearchFormLink();
        taskObject.usercanSearchtask("Automation App changing","i dont know","#Sleem,#Yehia,#shafiee"
        ,"Search For Task","Accepting","we finishing tasks","Automation Testing","90"
                ,"Mokhtar","QAcart","0215462");

    }
    @Test(priority = 4)
    public void userCanClickOnLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }

}
