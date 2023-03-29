package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends PageBase{
    public ContactsPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }
    @FindBy(xpath = "//a[@title='Contacts']")
    WebElement contactsLink;
    @FindBy(xpath = "//a[@title='New Contact']")
    WebElement newContactLink;
    @FindBy(name = "title")
    WebElement title;
    @FindBy(id = "first_name")
    WebElement FNtxtBox;
    @FindBy(id = "middle_initial")
    WebElement MNtxtBox;
    @FindBy(id = "surname")
    WebElement LNtxtBox;
    @FindBy(name = "suffix")
    WebElement suffix;
    @FindBy(name = "nickname")
    WebElement nicknameTxtBox;
    @FindBy(name = "client_lookup")
    WebElement companyNametxtBox;
    @FindBy(id = "company_position")
    WebElement positiontxtBox;
    @FindBy(id = "department")
    WebElement departmentTxtBox;
    @FindBy(name = "contact_lookup_sup")
    WebElement supervisorTxtBox;
    @FindBy(name = "contact_lookup_ass")
    WebElement assistantTxtBox;
    @FindBy(name = "contact_lookup_ref")
    WebElement ReferredByTxtBox;
    @FindBy(name = "category")
    WebElement category;
    @FindBy(name = "status")
    WebElement status;
    @FindBy(id = "phone")
    WebElement PhoneNumbertxtBox;
    @FindBy(id = "mobile")
    WebElement mobileNumberTxtBox;
    @FindBy(id = "home_phone")
    WebElement homephonetxtBox;
    @FindBy(id = "fax")
    WebElement faxtxtBox;
    @FindBy(id = "email")
    WebElement emailtxtBox;
    @FindBy(id = "email_alt")
    WebElement emailaltTxtBox;
    @FindBy(xpath = "//input[@value='Y']")
    WebElement receiveEmailradiobtn;

    @FindBy(name = "receive_sms")
    WebElement ReceiveSMSradioBtn;
    @FindBy(name = "allows_call")
    WebElement allowscallRadiobtn;
    @FindBy(id = "im_id")
    WebElement messengerIdtxtBox;
    @FindBy(name = "im_netowrk")
    WebElement messengerNetwork;
    @FindBy(id = "skype_id")
    WebElement skypeidtxtBox;
    @FindBy(name = "source")
    WebElement source;
    @FindBy(name = "birthday")
    WebElement birthdayTxtBox;
    @FindBy(name = "identifier")
    WebElement identifierTxtBox;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement saveButton;



    public void userCanOpenNewContactPage()
    {
        action
                .moveToElement(contactsLink).click(newContactLink).build().perform();

    }
    public void userCanCreateNewContactInformation
            (String firstName,String MiddleName,String LastName,String nickName
                    , String companyName,String position,String depatement,String subervisor,String assistant
                    ,String referredBy,String phone,String mobile,String homePhone,String fax,String email
                    ,String emailAlt,String messengerId,String skypeid,String birthday,String identifier)
    {
        select = new Select(title);
        select.selectByValue("Dr.");
        setTextElementText(FNtxtBox,firstName);
        setTextElementText(MNtxtBox,MiddleName);
        setTextElementText(LNtxtBox,LastName);
        select = new Select(suffix);
        select.selectByValue("Sr.");
        setTextElementText(nicknameTxtBox,nickName);
        setTextElementText(companyNametxtBox,companyName);
        setTextElementText(positiontxtBox,position);
        setTextElementText(departmentTxtBox,depatement);
        setTextElementText(supervisorTxtBox,subervisor);
        setTextElementText(assistantTxtBox,assistant);
        setTextElementText(ReferredByTxtBox,referredBy);
        select = new Select(category);
        select.selectByValue("Partner");
        select = new Select(status);
        select.selectByValue("New");
        setTextElementText(PhoneNumbertxtBox,phone);
        setTextElementText(mobileNumberTxtBox,mobile);
        setTextElementText(homephonetxtBox,homePhone);
        setTextElementText(faxtxtBox,fax);
        setTextElementText(emailtxtBox,email);
        setTextElementText(emailaltTxtBox,emailAlt);
        clickButton(receiveEmailradiobtn);
        clickButton(ReceiveSMSradioBtn);
        clickButton(allowscallRadiobtn);
        setTextElementText(messengerIdtxtBox,messengerId);
        select = new Select(messengerNetwork);
        select.selectByValue("MSN Messenger");
        setTextElementText(skypeidtxtBox,skypeid);
        select = new Select(source);
        select.selectByValue("Internet");
        setTextElementText(birthdayTxtBox,birthday);
        setTextElementText(identifierTxtBox,identifier);
        clickButton(saveButton);


    }

}
