package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class IssuesPage {

    @FindBy(xpath = "//h2[.='Issues summary']")
    public SelenideElement issuesHeader;
    @FindBy(xpath = "//a[.='Add new issue']")
    public SelenideElement addNewIssueBtn;

    @FindBy(id = "issue_summary")
    public SelenideElement issueSummary;

    @FindBy(id = "issue_description")
    public SelenideElement issueDescription;

    @FindBy(id = "type-view")
    public SelenideElement IssueTypeSelector;

    @FindBy(xpath = "//label[.='Bug']")
    public SelenideElement IssueTypeBug;

    @FindBy(id = "issue_priority")
    public SelenideElement IssuePrioritySelector;

    @FindBy(xpath = "//label[.='High']")
    public SelenideElement IssuePriorityHigh;

    @FindBy(name = "commit")
    public SelenideElement issueSaveBtn;

    @FindBy(xpath = "//div[@class='card_message']")
    public SelenideElement cardName;


    @Step
    public void checkIssuesPage(){
        issuesHeader.shouldBe(Condition.visible);
        addNewIssueBtn.shouldBe(Condition.visible);
    }

    @Step
    public void clikcAddNewIssue(){
        addNewIssueBtn.click();
    }

    @Step
    public void setIssueTypeBug(){
        IssueTypeSelector.click();
        IssueTypeBug.click();
    }

    @Step
    public void setIssuePriorityHigh(){
        IssuePrioritySelector.click();
        IssuePriorityHigh.click();
    }

    @Step
    public void addNewIssue(String issueName, String issueDesc){
        issueSummary.click();
        issueSummary.sendKeys(issueName);

        issueDescription.click();
        issueDescription.sendKeys(issueDesc);
        setIssueTypeBug();
        setIssuePriorityHigh();
        issueSaveBtn.click();
    }

    @Step
    public void checkIssueAdded(String issueName){
        cardName.shouldBe(Condition.text(issueName));
    }
}
