Feature: Creating a new checking account

  Scenario: Create a standard individual account
    Given the user logged in as "elonmusk_@gmail.com" "Qwerty!1"
    When the user creates a new checking account with the following data
      | checkingAccountType | accountOwnership | accountName               | initialDepositAmount |
      | Standard Checking   | Individual       | Elon Musk Second Checking | 100000.0             |
    Then the user should see the green "Successfully created new Standard Checking account named Elon Musk Second Checking" message
    And the user should see newly added account card
      | accountName              | accountType       | ownership  | accountNumber | interestRate | balance   |
      | Elon Musk Second Checking | Standard Checking | Individual | 486131037     | 0.0%         | 100000.00 |
    And the user should see the following transactions
      | date             | category | description               | amount    | balance   |
      | 2023-09-26 18:44 | Income   | 845323311 (DPT) - Deposit | 100000.00 | 100000.00 |
