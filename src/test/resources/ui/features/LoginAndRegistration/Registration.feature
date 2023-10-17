@Registration
Feature: Digital Bank Registration Page

  Background:
    Given The user with "jack@test.com" is not in DB
    And User navigates to Digital Bank signup page

  @Test
  Scenario: Positive Case. As a user, I want to successfully create Digital Bank account
    When User creates account with following fields
      | title | firstName | lastName | gender | dob        | ssn         | email         | password  | address    | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  | termsCheckMark |
      | Mr.   | Jack      | Test     | M      | 12/12/1990 | 696-11-2233 | jack@test.com | Tester123 | 12 Main st | City     | CA     | 99921      | US      | 2146591088 | 2136591208  | 2126591208 | true           |
    Then User should be displayed with the message "Registration Successful. Please Login."
    Then the following user info should be saved in the db
      | title | firstName | lastName | gender | dob        | ssn         | email         | password  | address    | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  | accountNonExpired | accountNonLocked | credentialsNonExpired | enabled |
      | Mr.   | Jack      | Test     | M      | 12/12/1990 | 696-11-2233 | jack@test.com | Tester123 | 12 Main st | City     | CA     | 99921      | US      | 2146591088 | 2136591208  | 2126591208 | true              | true             | true                  | true    |

  @NegativeRegistrationCases
  Scenario Outline: Negative Test Case. As a Digital Bank Admin I want to make sure users can not register without providing all valid data
    When User creates account with following fields
      | title   | firstName   | lastName   | gender   | dob   | ssn   | email   | password   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   | termsCheckMark   |
      | <title> | <firstName> | <lastName> | <gender> | <dob> | <ssn> | <email> | <password> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> | <termsCheckMark> |
    Then the User should see the "<fieldWithError>" required field error message "<errorMessage>"

    Examples:
      | title | firstName | lastName | gender | dob        | ssn       | email | password | address | locality | region | postalCode | country | homePhone | mobilePhone | workPhone | termsCheckMark | fieldWithError | errorMessage                        |
      |       |           |          |        |            |           |       |          |         |          |        |            |         |           |             |           |                | title          | Please select an item in the list.  |
      | Mr.   |           |          |        |            |           |       |          |         |          |        |            |         |           |             |           |                | firstName      | Please fill out this field.         |
      | Mr.   | Elon      |          |        |            |           |       |          |         |          |        |            |         |           |             |           |                | lastName       | Please fill out this field.         |
      | Mr.   | Elon      | Musk     |        |            |           |       |          |         |          |        |            |         |           |             |           |                | gender         | Please select one of these options. |
      | Mr.   | Elon      | Musk     | M      |            |           |       |          |         |          |        |            |         |           |             |           |                | dob            | Please fill out this field.         |
      | Mr.   | Elon      | Musk     | M      | 11/11/198  |           |       |          |         |          |        |            |         |           |             |           |                | dob            | Please match the requested format.  |
      | Mr.   | Elon      | Musk     | M      | 11.11.1986 |           |       |          |         |          |        |            |         |           |             |           |                | dob            | Please match the requested format.  |
      | Mr.   | Elon      | Musk     | M      | 11/11/1986 |           |       |          |         |          |        |            |         |           |             |           |                | ssn            | Please fill out this field.         |
      | Mr.   | Elon      | Musk     | M      | 11/11/1986 | 111111111 |       |          |         |          |        |            |         |           |             |           |                | email          | Please fill out this field.         |

