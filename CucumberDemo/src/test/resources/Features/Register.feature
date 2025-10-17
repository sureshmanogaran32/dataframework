Feature: Register Functionality

  Scenario: Successful Register
    Given the user enters the URL
    When the user enters name and email (name="Suresh", email="sam1@yopmail.com")
    And submits the signup button
    Then the user is redirected to the signup registration page
    When the user enters password, firstname, lastname, and address (pswd="Ind1234",fname="mani",lname="subu",address="fffffffffffff")
    And enters country, state, city, zipcode, and mobile number
    When the user clicks the create account button
    Then user should redirect to successful page
