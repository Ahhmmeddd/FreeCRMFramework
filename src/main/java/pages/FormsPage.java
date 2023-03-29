package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends PageBase{
    public FormsPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }
    @FindBy(xpath = "//a[@title='Forms']")
    WebElement FormsLink;
    @FindBy(xpath = "//a[@title='New Form']")
    WebElement NewFormLink;
    @FindBy(name = "title")
    WebElement titleTB;
    @FindBy(name = "pages")
    WebElement pagesTB;
    @FindBy(name = "report_email")
    WebElement report_emailTB;
    @FindBy(name = "description")
    WebElement descriptionTB;
    @FindBy(name = "welcome_message")
    WebElement welcome_messageTB;
    @FindBy(name = "confirmation_message")
    WebElement confirm_messageTB;
    @FindBy(css = "input.button")
    WebElement saveBTN;
    @FindBy(css = "td.datacardtitle")
    public WebElement FormAssertion;

    public void userCanClickOnNewFormLink(String title,String page,String report_email,String description
            ,String welcome_message,String confirm_message)
    {
        action.moveToElement(FormsLink).click(NewFormLink).build().perform();
        setTextElementText(titleTB,title);
        setTextElementText(pagesTB,page);
        setTextElementText(report_emailTB,report_email);
        setTextElementText(descriptionTB,description);
        setTextElementText(welcome_messageTB,welcome_message);
        setTextElementText(confirm_messageTB,confirm_message);
        clickButton(saveBTN);

    }
}
