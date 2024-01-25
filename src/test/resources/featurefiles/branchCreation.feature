Feature: To validate Branch function

  Scenario: Branch creation
    Given I want to launch my application with "http://primusbank.qedgetech.com/" url
    When I enter valid "Admin" and "Admin"
    And I click on login button
    And user click on branchbth
    And user created the branch with valid data
      | branchname | address1  | address2        | address3 | area | zipcode | country | state          | city      |
      | srnager    | bapunager | nearmetrostaion | amerpet  | hyd  |   50038 | INDIA   | Andhra Pradesh | Hyderabad |
      | Kukatpally | bapunager | nearmetrostaion | amerpet  | hyd  |   50038 | INDIA   | Andhra Pradesh | Hyderabad |
      | ameerpet   | bapunager | nearmetrostaion | amerpet  | hyd  |   50038 | INDIA   | Andhra Pradesh | Hyderabad |
    And close the browser
