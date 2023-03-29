Feature: Contacts
  i want to check that the user can open contacts page our CRM website.
  Scenario Outline: Contacts
    Given the contacts in the userRegistration page
    When I Entered the "<username>" ,"<password>"
    When user Can Click On New Contacts Link
    When user Can Create New Contact Information
    Then user Can ClickOn Log Out
    Examples:
      |username|password|
      |Ahmed_1 |123456789|