package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class DashboardPage {

    @FindBy(xpath = "//a[@href='/user/edit']")
    public SelenideElement profileLink;

    @FindBy(xpath = "//a[@href='/projects']")
    public SelenideElement myProjectsLink;

    @Step
    public void checkUserAuthorized(){
        profileLink.shouldBe(Condition.visible);
    }

    @Step
    public ProjectsPage openMyProjects(){
        myProjectsLink.click();
        return page(ProjectsPage.class);
    }
}
