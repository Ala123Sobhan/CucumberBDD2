Feature: DataTable & Scenario Outline examples

#
#  Scenario: Datatable information
#    Given I am on "www.gmail.com" website
#    And I use my credentials
#      | email                  | password  |
#      | ala123sobhan@gmail.com | Joker123! |


  Scenario Outline: Like testNG dataprovider
    Given I am on "www.gmail.com" website
    And I use my credentials <email> and <password>

    Examples:
      | email                  | password  |
      | ala123sobhan@gmail.com | Joker123! |
      | bob_sob@hotmail.com    | bob12     |

