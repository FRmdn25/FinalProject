Feature: Test Automation Rest Api

  @api
  Scenario: Test get list data normal
    Given prepare url for "GET_LIST_USERS"
    And hit api get list users
    Then validation status code is equal 200
    Then validation response body get list users

  @api
  Scenario: Test create new user normal
    Given prepare url for "CREATE_NEW_USERS"
    And hit api post create new users
    Then validation status code is equal 200
    Then validation response body post create new user

  @api
  Scenario: Test delete user normal
    Given prepare url for "CREATE_NEW_USERS"
    And hit api post create new users
    Then validation status code is equal 200
    Then validation response body post create new user
    Given prepare url for "DELETE_USERS"
    And hit api delete new
    Then validation status code is equal 200
