package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{
    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "username")
    WebElement untextBox;
    @FindBy(name = "password")
    WebElement passwordTextBox;
    @FindBy(css = "input.btn.btn-small")
    WebElement logInButton;
    @FindBy(linkText = "Home")
    public WebElement homeLink;

    public void userCanLogIn(String userName , String password)
    {
        setTextElementText(untextBox,userName);
        setTextElementText(passwordTextBox,password);
        clickButton(logInButton);


    }
}
