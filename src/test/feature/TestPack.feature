Feature: build automation framework

  Scenario: TestCase 1
    Given endpoint is "TestCase 1: https://localhost:8080/api/access"
    And set headers
      | tc1header1 | tc1Hvalue1 |
    And set payload
      | tc1payload1 | tc1Pvalue1 |
    Then perform HTTP "post" request
    When response status code is "200"
    Then validate response "key" equals "${tc1payload1}"
    Then validate response "key2" equals "attributeValue2"
    Then store "access_token" from response as "accessToken"

  Scenario: TestCase 2
    Given endpoint is "TestCase 2:https://localhost:8080/api/access22"
    And set header "access_token" value "${accessToken}"
    And set headers
      | header2       | value2         |
      | access_token2 | ${accessToken} |
    Then perform HTTP "post" request

  Scenario: TestCase 2.1
    Then perform HTTP "post" request

  Scenario: TestCase 3
    Given endpoint is "https://localhost:8080/api/access33"
    And set headers
      | header3 | value3 |
    And set payload
      | payload3 | ${accessToken} |
    Then perform HTTP "post" request

  @payload
  Scenario:Test case4
    And set payload
      | header3  | my-header-value3 |
      | header4 | my-header-value4 |
      | value1   | my-value-1  |
      | value2   | my-value-2  |
      | token | ${accessToken} |
    And read payload file "Payload/PayloadTemplate"