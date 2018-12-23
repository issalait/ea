package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class DashboardPage {

    @FindBy(xpath = "//a[@href='/user/edit']")
    public SelenideElement profileLink;

    @FindBy(xpath = "//a[@href='/projects']")
    public SelenideElement myProjectsLink;

    public void checkUserAuthorized(){
        profileLink.shouldBe(Condition.visible);
    }

    public ProjectsPage openMyProjects(){
        myProjectsLink.click();
        return page(ProjectsPage.class);
    }
}
