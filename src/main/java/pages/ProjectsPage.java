package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ProjectsPage {

    @FindBy(xpath = "//h1[.='My Projects']")
    public SelenideElement projectsHeader;

    @FindBy(xpath = "//a[@class='project-name']")
    public SelenideElement projectName;

    @Step
    public void checkProjectsPage(){
        projectsHeader.shouldBe(Condition.visible);
    }

    @Step
    public ProjectDashboardPage openProject(){
        projectName.click();
        return page(ProjectDashboardPage.class);
    }
}
