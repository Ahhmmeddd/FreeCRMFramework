Feature: Forms
  i want to check that the user can open Forms page our CRM website.
  Scenario Outline: Forms
    Given the forms in the userRegistration page
    When I entered this "<username>" ,"<password>"
    When User Can Open New Form Page
    Then user Can Click On LogOut link
    Examples:
      |username|password|
      |Ahmed_1 |123456789|