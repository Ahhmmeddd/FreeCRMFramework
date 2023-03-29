package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends PageBase{
    public CalendarPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//a[@href='https://classic.freecrm.com/system/index.cfm?action=calendar&sub=default']")
    WebElement calendarLink;
    @FindBy(css = "td.calendarcell")
    WebElement calendarDay;
    @FindBy(id = "load_calendar_for_user_id")
    public WebElement user;
    @FindBy(xpath = "//a[@href='https://classic.freecrm.com/index.cfm?logout=1']")
    WebElement logOut;


    public void userClickOnCalendarLink()
    {
       clickButton(calendarLink);
       clickButton(calendarDay);

    }
    public void userCanLogOut()
    {
        clickButton(logOut);
    }
}
