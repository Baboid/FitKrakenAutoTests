Feature: Edit membership

  @EditMembershipSessions
  Scenario: A user attempts to edit the number of sessions
    Given the user is logged in
    When the user clicks on the create new member icon
    And the user provides the name surname and email
    And the user provides the membership details without the sessions
    Then the user should be presented with the member card
    When the user clicks on the edit membership
    And provides the number of sessions
    Then the user should be presented with the membership containing the correct number of sessions
