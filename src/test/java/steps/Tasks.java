package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalendarPage;
import pages.TasksPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class Tasks extends TestBase
{
    UserRegistrationPage registerObject;
    TasksPage taskObject;
    CalendarPage calendarObject;

    @Given("the tasks in the userRegistration page")
    public void the_tasks_in_the_userRegistration_page()
    {
        registerObject = new UserRegistrationPage(driver);
        Assert.assertTrue(registerObject.homeLink.getText().contains("Home"));
    }

    @When("i entered data {string} ,{string}")
    public void iEnteredData(String username, String password)
    {
        registerObject.userCanLogIn(username,password);
        Assert.assertTrue(driver.getTitle().contains("CRMPRO"));

    }

    @When("i click on new task link")
    public void iClickOnNewTaskLink()
    {
        driver.switchTo().frame("mainpanel");
        taskObject = new TasksPage(driver);
        taskObject.userCanClickOnNewTaskLink();
        taskObject.userEntersTaskInformation("Automation App changing","80"
                ,"Enter Task information ","high quality for testing","#AhmedSleem,#YehiaElnawise,#AhmedAfifi"
                ,"We need just be carfully ","QAcart","5050","AHhmmed");
        Assert.assertTrue(taskObject.titleForAssertion.getText().contains("Automation App changing"));

    }

    @Then("user Can Open Full Search From Page")
    public void userCanOpenFullSearchFromPage()
    {
        taskObject.userCanClickonFullSearchFormLink();
        taskObject.usercanSearchtask("Automation App changing","i dont know","#Sleem,#Yehia,#shafiee"
                ,"Search For Task","Accepting","we finishing tasks","Automation Testing","90"
                ,"Mokhtar","QAcart","0215462");
    }

    @Then("user can log out")
    public void userCanLogOut()
    {
        calendarObject = new CalendarPage(driver);
        calendarObject.userCanLogOut();
    }
}
