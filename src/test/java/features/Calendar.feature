Feature: Calendar
  i want to check the user can click on calendar and changing data.
  Scenario Outline: Calendar
    Given the calendar in the userRegistration page
    When i Entered "<username>" ,"<password>"
    When user Click On Calendar Link
    Then user Can Click On LogOut
    Examples:
      |username|password|
      |Ahmed_1 |123456789|