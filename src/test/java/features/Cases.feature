Feature: Cases
  i want to check that the user can open cases page our CRM website.
  Scenario Outline: Cases
    Given the cases in the userRegistration page
    When I Entered "<username>" ,"<password>"
    When user Can Open New Case Page
    When user Can Entered Case Information
    When user Can Open Full Search Form
    Then user can click on log out
    Examples:
      |username|password|
      |Ahmed_1 |123456789|
