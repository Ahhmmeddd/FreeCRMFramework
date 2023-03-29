Feature: Call
  i want to check that the user can call our CRM website.
  Scenario Outline: Call
    Given the call in the userRegistration page
    When I entered "<username>" ,"<password>"
    When user Can Click On New Call Link
    When user Can Entered Call Information
    When user Can Click On Call Scripts Link
    Then user Can Click On Log Out
    Examples:
      |username|password|
      |Ahmed_1 |123456789|


