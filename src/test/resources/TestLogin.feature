@SmokeTest
Feature: Cucumber run test

  Scenario Outline: Cucumber setup

    Given sample feature file is ready
    When I run the feature file "<uname>" "<pwd>"
    Then run should be successful
    Examples:
     |uname |pwd  |
    |test  |pwd  |
     |test1  |pwd22  |
     |Auranga  |ChandraKanth  |



