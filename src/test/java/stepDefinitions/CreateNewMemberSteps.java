package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.es.Dada;
import org.openqa.selenium.support.ui.Select;
import pageObjects.LoginPage;
import pageObjects.MembersPage;
import utils.Base;

import java.util.Date;

public class CreateNewMemberSteps extends Base {

    LoginPage lp;
    MembersPage mp;

    @Given("^the user is logged in$")
    public void the_user_is_logged_in() throws Throwable {
        driver = initilizeDriver();
        driver.get(prop.getProperty("url"));
        lp = new LoginPage(driver);
        lp.inputEmail().sendKeys(prop.getProperty("ValidTestUserEmail"));
        lp.inputPass().sendKeys(prop.getProperty("ValidTestUserPass"));
        lp.getLoginButton().click();
    }

    @When("^the user clicks on the create new member icon$")
    public void the_user_click_on_the_create_new_member_icon() {
        mp = new MembersPage(driver);
        mp.getCreateNewMember().click();
    }

    @And("^the user provides the name surname and email$")
    public void the_user_provides_the_name_surname_and_email() {
        mp = new MembersPage(driver);
        mp.getMemberNameField().sendKeys(createNewMemberName());
        mp.getMemberSurnameField().sendKeys(prop.getProperty("NewMemberSurname"));
        mp.getNewMemberEmailField().sendKeys(createUniqueEmail());
        mp.getNewMemberSaveInfoButton().click();
    }

    @And("^the user provides the membership details$")
    public void the_user_provides_the_membership_details() {
        mp = new MembersPage(driver);
//        Select s1 = new Select(mp.getClubDropdown());
//        s1.selectByValue("1");
        Select s2 = new Select(mp.getGroupDropdown());
        s2.selectByValue("performance");
        mp.getValidDateFrom().sendKeys(prop.getProperty("NewMembershipValidDateFrom"));
        mp.getValidDateTo().sendKeys(prop.getProperty("NewMembershipValidDateTo"));
        mp.getNumberOfSessions().sendKeys(prop.getProperty("NewMembershipNumberOfSessions"));
        mp.getSaveMembershipButton().click();
    }

    @Then("^the user should be presented with the member card$")
    public void the_user_should_be_presented_with_the_member_card() {
        mp = new MembersPage(driver);
        mp.getMembershipCard().isDisplayed();
    }

}
