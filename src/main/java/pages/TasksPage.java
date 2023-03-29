package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TasksPage extends PageBase {
    public TasksPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//a[@title='Tasks']")
    WebElement tasksLink;
    @FindBy(xpath = "//a[@title='New Task']")
    WebElement newTaskLink;
    @FindBy(name = "title")
    WebElement titleTxtBox;
    @FindBy(id = "fieldId_deadline")
    WebElement deadLine;
    @FindBy(name = "auto_extend")
    WebElement autoExtend;
    @FindBy(name = "status")
    WebElement status;
    @FindBy(name = "completion")
    WebElement completionTxtBox;
    @FindBy(name = "task_type")
    WebElement tasktype;
    @FindBy(name = "priority")
    WebElement priority;
    @FindBy(name = "prospect_lookup")
    WebElement dealTxtbox;
    @FindBy(name = "case_lookup")
    WebElement caseTxtBox;
    @FindBy(name = "tags")
    WebElement tagsTxtBox;
    @FindBy(name = "description")
    WebElement descriptionTxtBox;
    @FindBy(name = "email_notification")
    WebElement emailnotificationRadioBtn;
    @FindBy(name = "contact_lookup")
    WebElement keyContacttxtBox;
    @FindBy(name = "client_lookup")
    WebElement keyCompanyTxtBox;
    @FindBy(name = "identifier")
    WebElement identifiertxtBox;
    @FindBy(css = "input.button")
    WebElement saveButton;
    @FindBy(css = "td.tabs_header")
    public WebElement titleForAssertion;
    @FindBy(xpath = "//a[@href='https://classic.freecrm.com/system/index.cfm?action=task&sub=search']")
    WebElement FullSearchFormLink;
    @FindBy(name = "cs_keyword")
    WebElement TitleForSearchtask;
    @FindBy(name = "cs_priority")
    WebElement priorityForST;
    @FindBy(name = "cs_task_type")
    WebElement tybeForST;
    @FindBy(name = "cs_extended")
    WebElement ExtendedFields;
    @FindBy(name = "cs_created_at_from")
    WebElement Creationdate1;
    @FindBy(name = "cs_created_at_to")
    WebElement Creationdate2;
    @FindBy(name = "cs_last_modified_from")
    WebElement Modifieddate1;
    @FindBy(name = "cs_last_modified_to")
    WebElement Modifieddate2;
    @FindBy(name = "tag")
    WebElement tagsTXTBOX;
    @FindBy(name = "cs_case")
    WebElement caseTXTBOX;
    @FindBy(name = "cs_deal")
    WebElement dealTXTBOX;
    @FindBy(name = "cs_notes")
    WebElement notesAndDescription;
    @FindBy(name = "cs_search_extended")
    WebElement cs_search_extendedRadioBTN;
    @FindBy(name = "cs_save_search")
    WebElement saveSearch;
    @FindBy(name = "cs_search_title")
    WebElement searchTitle;
    @FindBy(name = "cs_completion")
    WebElement CompletionTxtBx;
    @FindBy(name = "cs_status")
    WebElement statusList;
    @FindBy(name = "cs_identifier")
    WebElement cs_identifier;
    @FindBy(name = "cs_company_name")
    WebElement cs_company_name;
    @FindBy(name = "cs_contact_name")
    WebElement cs_contact_name;
    @FindBy(name = "cs_deadline")
    WebElement cs_deadline;



    public void userCanClickOnNewTaskLink() {
        action.moveToElement(tasksLink).click(newTaskLink).build().perform();

    }

    public void userEntersTaskInformation(String title, String completion, String deal, String Case, String tags
            , String description, String keyContact, String keyCompany, String identifier) {
        setTextElementText(titleTxtBox, title);
        jse.executeScript("arguments[0].setAttribute('value','" + "15-06-2022" + "')", deadLine);
        select = new Select(autoExtend);
        select.selectByValue("7");
        select = new Select(status);
        select.selectByValue("Complete");
        setTextElementText(completionTxtBox, completion);
        select = new Select(tasktype);
        select.selectByValue("Meeting");
        select = new Select(priority);
        select.selectByValue("Normal");
        setTextElementText(dealTxtbox, deal);
        setTextElementText(caseTxtBox, Case);
        setTextElementText(tagsTxtBox, tags);
        setTextElementText(descriptionTxtBox, description);
        clickButton(emailnotificationRadioBtn);
        setTextElementText(keyContacttxtBox, keyContact);
        setTextElementText(keyCompanyTxtBox, keyCompany);
        setTextElementText(identifiertxtBox, identifier);
        clickButton(saveButton);
    }

    public void userCanClickonFullSearchFormLink()
    {
        action.moveToElement(tasksLink).click(FullSearchFormLink).build().perform();
    }
    public void usercanSearchtask(String TitleST,String ExtendedF,String tagsTB,String caseTB,String dealTB
            ,String notes,String search,String completion,String cs_identifierT,String company,String cs_contact)
    {
        setTextElementText(TitleForSearchtask,TitleST);
        select = new Select(priorityForST);
        select.selectByValue("High");
        select = new Select(tybeForST);
        select.selectByValue("Client Visit");
        setTextElementText(ExtendedFields,ExtendedF);
        jse.executeScript("arguments[0].setAttribute('value','" + "20-08-2022" + "')", Creationdate1);
        jse.executeScript("arguments[0].setAttribute('value','" + "10-06-2023" + "')", Creationdate2);
        jse.executeScript("arguments[0].setAttribute('value','" + "20-08-2023" + "')", Modifieddate1);
        jse.executeScript("arguments[0].setAttribute('value','" + "20-05-2023" + "')", Modifieddate2);
        setTextElementText(tagsTXTBOX,tagsTB);
        setTextElementText(caseTXTBOX,caseTB);
        setTextElementText(dealTXTBOX,dealTB);
        setTextElementText(notesAndDescription,notes);
        clickButton(cs_search_extendedRadioBTN);
        clickButton(saveSearch);
        setTextElementText(searchTitle,search);
        setTextElementText(CompletionTxtBx,completion);
        select = new Select(statusList);
        select.selectByValue("Complete");
        setTextElementText(cs_identifier,cs_identifierT);
        setTextElementText(cs_company_name,company);
        setTextElementText(cs_contact_name,cs_contact);
        jse.executeScript("arguments[0].setAttribute('value','" + "20-05-2023" + "')", cs_deadline);



    }
}
