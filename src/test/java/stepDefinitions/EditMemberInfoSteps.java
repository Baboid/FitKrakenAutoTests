package stepDefinitions;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageObjects.MemberCardPage;
import pageObjects.MembersPage;
import utils.Base;

public class EditMemberInfoSteps extends Base {

    MembersPage mp = new MembersPage(driver);
    MemberCardPage mcp;

    String currentMemberName = mp.getFirstMember().getText();

    @When("^the user click on the edit option$")
    public void the_user_click_on_the_edit_option() {
        mp = new MembersPage(driver);
        mcp = new MemberCardPage(driver);
        mp.getFirstMember().click();
        mcp.getMemberCardMainOptions().click();
        mcp.getEditMemberInfo().click();
    }

    @And("^provides the new name and surname$")
    public void provides_the_new_name_and_surname() throws InterruptedException{
        mp = new MembersPage(driver);
        mp.getMemberNameField().clear();
        System.out.println(prop);
        mp.getMemberNameField().sendKeys(createNewMemberName());
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        WebElement elem1 = mp.getMemberNameField();
//        js.executeScript("arguments[0].value = ''", elem1);
//        Thread.sleep(4000);
//        mp.getMemberNameField().sendKeys(createNewMemberName());
//        WebElement elem2 = mp.getMemberSurnameField();
//        js.executeScript("arguments[0].value = ''", elem2);
//        Thread.sleep(4000);
        mp.getMemberSurnameField().sendKeys(prop.getProperty("UpdatedSurname"));
    }

    @And("^saves the edit$")
    public void saves_the_edit() {
        mp = new MembersPage(driver);
        mp.getNewMemberSaveInfoButton().click();
    }

    @Then("^the user should be presented with the new member info$")
    public void the_user_should_be_presented_with_the_new_member_info() {
        mcp = new MemberCardPage(driver);
        String updatedMembersName = mcp.getMembersName().getText();
        if (currentMemberName != updatedMembersName) {
            System.out.println("Name updated!");
        } else {
            System.out.println("Error!");
        }

    }

}