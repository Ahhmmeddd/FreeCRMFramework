package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CallPage extends PageBase{
    public CallPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }
    @FindBy(xpath = "//a[@title='Call']")
    WebElement CallLink;
    @FindBy(xpath = "//a[@title='New Call']")
    WebElement NewCallLink;
    @FindBy(name = "scheduled_call")
    WebElement scheduled_callRadioBTN;
    @FindBy(name = "schedule")
    WebElement scheduleDate;
    @FindBy(name = "script_id")
    WebElement callScript;
    @FindBy(name = "reminder_minutes")
    WebElement reminderList;
    @FindBy(name = "reminder_type")
    WebElement reminder_type;
    @FindBy(name = "reminder_note")
    WebElement reminder_noteTB;
    @FindBy(name = "contactentrytype")
    WebElement contactentrytypeList;
    @FindBy(name = "name")
    WebElement nameTxtBox;
    @FindBy(name = "phone_number")
    WebElement phone_numberTxtBox;
    @FindBy(name = "create_contact")
    WebElement create_contactRadioBTN;
    @FindBy(name = "conf_call")
    WebElement conf_callRadioBTn;
    @FindBy(name = "conf_contact_lookup")
    WebElement addContactTxtBox;
    @FindBy(name = "flag")
    WebElement flagList;
    @FindBy(name = "start_time")
    WebElement start_time;
    @FindBy(name = "end_time_hour")
    WebElement end_time_hourList;
    @FindBy(name = "end_time_minute")
    WebElement end_time_minuteTB;
    @FindBy(name = "closed")
    WebElement stateList;
    @FindBy(name = "prospect_lookup")
    WebElement dealTB;
    @FindBy(name = "task_lookup")
    WebElement taskTB;
    @FindBy(name = "case_lookup")
    WebElement caseTB;
    @FindBy(name = "notes")
    WebElement notesTB;
    @FindBy(name = "create_new")
    WebElement create_newRadioBTN;
    @FindBy(name = "saveandcall")
    WebElement saveandcallButton;
    @FindBy(xpath = "//a[@title='Call Scripts']")
    WebElement CallScriptsLink;
    @FindBy(name = "script_name")
    WebElement nameTB;
    @FindBy(name = "script_desc")
    WebElement descriptionTB;
    @FindBy(css = "input.button")
    WebElement saveBTN;
    @FindBy(name = "script_text")
    WebElement script_textTB;
    @FindBy(name = "data_type")
    WebElement data_typeList;
    @FindBy(name = "large_field")
    WebElement large_fieldRadioBTN;
    @FindBy(name = "max_length")
    WebElement max_lengthTB;
    @FindBy(css = "input.button")
    WebElement addBTN;


    public void userCanClickOnNewCallLink()
    {
        action.moveToElement(CallLink).click(NewCallLink).build().perform();
    }
    public void userCanEnteredCallInformation(String reminder_note,String name,String phone,String addContact
            ,String end_time_minute,String deal,String task,String caset,String notes)
    {
        clickButton(scheduled_callRadioBTN);
        jse.executeScript("arguments[0].setAttribute('value','" + "15-06-2023" + "')", scheduleDate);
        select = new Select(callScript);
        select.selectByValue("14637");
        select = new Select(reminderList);
        select.selectByValue("120");
        select=new Select(reminder_type);
        select.selectByValue("S");
        setTextElementText(reminder_noteTB,reminder_note);
        select = new Select(contactentrytypeList);
        select.selectByValue("NOTEXISTS");
        setTextElementText(nameTxtBox,name);
        setTextElementText(phone_numberTxtBox,phone);
        clickButton(create_contactRadioBTN);
        clickButton(conf_callRadioBTn);
        setTextElementText(addContactTxtBox,addContact);
        select = new Select(flagList);
        select.selectByValue("Left Message");
        jse.executeScript("arguments[0].setAttribute('value','" + "15-06-2023" + "')", start_time);
        select = new Select(end_time_hourList);
        select.selectByValue("8");
        setTextElementText(end_time_minuteTB,end_time_minute);
        select = new Select(stateList);
        select.selectByValue("Y");
        setTextElementText(dealTB,deal);
        setTextElementText(taskTB,task);
        setTextElementText(caseTB,caset);
        setTextElementText(notesTB,notes);
        clickButton(create_newRadioBTN);
        clickButton(saveandcallButton);

    }
    public void userCanClickOnCallScriptsLink(String name,String description,String script_text,String max_length)
    {
        action.moveToElement(CallLink).click(CallScriptsLink).build().perform();
        setTextElementText(nameTB,name);
        setTextElementText(descriptionTB,description);
        clickButton(saveBTN);
        setTextElementText(script_textTB,script_text);
        clickButton(large_fieldRadioBTN);
        setTextElementText(max_lengthTB,max_length);
        select = new Select(data_typeList);
        select.selectByValue("BOOL");
        clickButton(addBTN);

    }


}
