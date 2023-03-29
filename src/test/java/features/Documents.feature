Feature: Documents
  i want to check that the user can open Documents page our CRM website.
  Scenario Outline: Documents
    Given the documents in the userRegistration page
    When I Entered this "<username>" ,"<password>"
    When user Can Click On New Document Link
    When user Can Clic On New Directory Link
    Then user Can Click On Log Out link
    Examples:
      |username|password|
      |Ahmed_1 |123456789|