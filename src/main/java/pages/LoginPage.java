package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;


public class LoginPage {

    @FindBy(id = "user_email")
    public SelenideElement login;
    @FindBy(id = "user_password")
    public SelenideElement password;
    @FindBy(name = "commit")
    public SelenideElement loginBtn;

    @Step
    public void enterLogin(String userLogin){
        login.click();
        login.clear();
        login.sendKeys(userLogin);
    }

    @Step
    public void enterPassword(String userPassword){
        password.click();
        password.clear();
        password.sendKeys(userPassword);
    }

    @Step
    public DashboardPage clickLoginBtn(){
        loginBtn.click();
        return page(DashboardPage.class);
    }
}
