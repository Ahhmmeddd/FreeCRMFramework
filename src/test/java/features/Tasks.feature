Feature: Tasks
  i want to check the user can click on tasks and changing data.
  Scenario Outline: Tasks
    Given the tasks in the userRegistration page
    When i entered data "<username>" ,"<password>"
    When i click on new task link
    Then user Can Open Full Search From Page
    Then user can log out
    Examples:
    |username|password|
    |Ahmed_1 |123456789|


