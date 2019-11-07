Feature: Edit member info

@EditMemberInfoTest
Scenario: A user atttempts to edit the members info
Given the user is logged in
When the user click on the edit option
And provides the new name and surname
And saves the edit
Then the user should be presented with the new member info