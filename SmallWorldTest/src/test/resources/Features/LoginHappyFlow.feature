Feature: Test login feature

  Scenario Outline: Check Login Happy Flow
    When Browser is open
    And user is on login page
    When user enters <username> and <password>
    And user clicks Login CTA
    Then user is navigated to homepage

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |
