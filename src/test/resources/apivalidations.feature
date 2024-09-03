@Regression
Feature: Cucumber API test


Scenario Outline: Run API multithreading

Given insert call for products
When enter details <productid> "<name>" "<description>"
Then record should be inserted
Examples:
|productid |name  |description|
|2  |Raghu  |Dubakoor         |
|3  |Bharani  |SuperStar      |
|4  |ChandraKanth  |Doggie    |
|5  |Arvind        |anbuen    |
|6  |Aaria         |Chellam   |
|7  |Prithivi      |wifeyy    |
|8  |Ramesh        |Neighbor  |
|9  |Manju         |Friend    |
|10 |Nuisance      |Naveen    |
|11 |Arvind        |anbuen    |
|12 |Aaria         |Chellam   |
|13 |Prithivi      |wifeyy    |
|14 |Ramesh        |Neighbor  |
|15 |Manju         |Friend    |
|16 |Nuisance      |Naveen    |
|17 |Nuisance      |Naveen    |
|18 |Arvind        |anbuen    |
|19 |Aaria         |Chellam   |
|20 |Prithivi      |wifeyy    |
|21 |Ramesh        |Neighbor  |
|22 |Manju         |Friend    |
|23 |Nuisance      |Naveen    |


  Scenario Outline: Get records with product ID

    Given records inserted
    When enter details details with <productid>
    Then record retrieved successfully
    Examples:
      |productid |
      |2  |


  Scenario Outline: Retrieve all products

    Given available records in Database
    When getproducts endpoint called
    Then record retrieved successfully
    Examples:
      |productid |
      |2  |