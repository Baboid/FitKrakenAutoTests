Feature: Search member

  @SearchMemberTest
  Scenario: A user attempts to search a member
    Given the user is logged in
    When the user inputs the members name in the searchbox
    Then the user should be presented with an updated memberslist
