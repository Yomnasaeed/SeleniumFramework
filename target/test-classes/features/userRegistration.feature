Feature: User Registration
 I want to check that the user can register in our e-commerce website.
 
 Scenario Outline: User Registration
 Given the user in the home page
 When I click on the regiter link
 And I entererd "<firstname>", "<lastname>", "<email>", "<password>"
 Then The registration page displayed successfully
 
 Examples:
 | firstname | lastname | email | password |
 | ahmed | moahmed | a.moh11@test.com | 12345678 |
 | ali | ali | ali22@test.com | 87456321 |