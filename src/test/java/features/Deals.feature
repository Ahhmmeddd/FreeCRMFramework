Feature: Deals
  i want to check that the user can open deals page our CRM website.
  Scenario Outline: Deals
    Given the deals in the userRegistration page
    When IEntered this "<username>" ,"<password>"
    When user Can Click On New Deals Link
    When user Can Create A new Deal
    Then user Can ClickOn LogOut
    Examples:
      |username|password|
      |Ahmed_1 |123456789|