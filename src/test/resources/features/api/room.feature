Feature: Roomba Navigation System
  @roomba
  Scenario: verify roomba patches and final coordinates
    Given Users sends POST request to "roomba.endpoint"
    Then  output should match expected

