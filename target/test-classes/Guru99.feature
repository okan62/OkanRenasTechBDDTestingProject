Feature: Payment Gateway functional Test

  @TC1
  Scenario: Verify that the user can order a product
    Given The user wants to see payment gateway website
    When The user wants to verify message as "Mother Elephant With Babies Soft Toy"

    @TC2
    Scenario: Verify the toy price
      Given The user wants to see payment gateway website
      When The user wants to see toy price message as "Price: $20"

      @TC3
      Scenario: Verify url contain payment gateway
        Given The user wants to see payment gateway website
        When The user wants to see url contain as "payment-gateway"

      @TC4
      Scenario: Verify that the user can order a product
        Given The user wants to see payment gateway website
        When  The user wants to buy elephant toy as
          |Quantity|5|
        Then The user wants to enter payment information as
          |CNumber|6262929312009977|
          |EMonth |10              |
          |EYear  |2024            |
          |CVV    |073             |
        Then The user wants to pay now
        And The user wants to see verification message as "Payment successfull!"

        @TC5
        Scenario Outline: Verify that the user can order a product
          Given The user wants to see payment gateway website
          When The user wants to buy elephant toy as "<Quantity>"
          Then The user wants to enter payment information as
            |CNumber|6262929312009933|
            |EMonth |06              |
            |EYear  |2025            |
            |CVV    |673             |
          Then The user wants to pay now
          Then The user wants to see verification message as "Payment successfull!"
          Examples:
            |Quantity  |
            |5         |
            |8         |
            |2         |
            |9         |
            |4         |