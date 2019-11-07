package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MemberCardPage;
import pageObjects.MembersPage;
import utils.Base;

public class EditMembershipSteps extends Base {

    MembersPage mp;
    MemberCardPage mcp;

    @And("^the user provides the membership details without the sessions$")
    public void the_user_provides_the_membership_details_without_the_sessions(){
        mp = new MembersPage(driver);
        Select s3 = new Select(mp.getGroupDropdown());
        s3.selectByValue("performance");
        mp.getValidDateFrom().sendKeys(prop.getProperty("NewMembershipValidDateFrom"));
        mp.getValidDateTo().sendKeys(prop.getProperty("NewMembershipValidDateTo"));
        mp.getSaveMembershipButton().click();

    }

    @When("^the user clicks on the edit membership$")
    public void the_user_clicks_on_the_edit_membership() {
        mcp = new MemberCardPage(driver);
        mcp.getMemberCardMembershipOptions().click();
        mcp.getEditMembership().click();
    }

    @And("^provides the number of sessions$")
    public void provides_the_number_of_sessions() {
        mp = new MembersPage(driver);
        String s1 = prop.getProperty("NewMembershipNumberOfSessions");
        mp.getNumberOfSessions().sendKeys(s1);
        mp.getSaveMembershipButton().click();
    }

    @Then("^the user should be presented with the membership containing the correct number of sessions$")
    public void the_user_should_be_presented_with_the_membership_containing_the_correct_number_of_sessions() throws InterruptedException{
        mcp = new MemberCardPage(driver);
        Thread.sleep(3000);
        Assert.assertEquals(mcp.getLastSession().getText(), "10");
    }
}
