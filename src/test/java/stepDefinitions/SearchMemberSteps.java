package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.MembersPage;
import utils.Base;

public class SearchMemberSteps extends Base {

    MembersPage mp;

    @When("^the user inputs the members name in the searchbox$")
    public void the_user_inputs_the_members_name_in_the_searchbox() throws InterruptedException{
        mp = new MembersPage(driver);
        mp.getMembersSearchBox().sendKeys(prop.getProperty("SearchUser"));
        Thread.sleep(3000);
    }

    @Then("^the user should be presented with an updated memberslist$")
    public void the_user_should_be_presented_with_an_updated_memberslist() {
        mp = new MembersPage(driver);
        String found = mp.getFirstMemberSpan().getText();
        System.out.println(found);
        //Assert.assertTrue(found == prop.getProperty("SearchUser"));
    }

}
