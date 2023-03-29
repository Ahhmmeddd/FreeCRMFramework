Feature: Companies
  i want to check that the user can open companies page our CRM website.
  Scenario Outline: Companies
    Given the companies in the userRegistration page
    When IEntered "<username>" ,"<password>"
    When user Can Click On Company Link
    Then user Can Click On log Out
    Examples:
      |username|password|
      |Ahmed_1 |123456789|