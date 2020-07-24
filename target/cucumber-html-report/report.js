$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("End2End_Test.feature");
formatter.feature({
  "line": 1,
  "name": "Automated End2End Tests",
  "description": "Description: The purpose of this feature is to test End 2 End integeration.",
  "id": "automated-end2end-tests",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user is on Home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "he search for \"\u003cproduct name\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "choose to buy two items",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "moves to checkout cart and enter personal details on checkout page and place the order",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "he can view the order and download the invoice",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;",
  "rows": [
    {
      "cells": [
        "product name"
      ],
      "line": 12,
      "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;;1"
    },
    {
      "cells": [
        "Apple MacBook Pro 13-inch"
      ],
      "line": 13,
      "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "id": "automated-end2end-tests;customer-place-an-order-by-purchasing-an-item-from-search;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user is on Home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "he search for \"Apple MacBook Pro 13-inch\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "choose to buy two items",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "moves to checkout cart and enter personal details on checkout page and place the order",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "he can view the order and download the invoice",
  "keyword": "Then "
});
formatter.match({
  "location": "E2ETests.user_is_on_Home_page()"
});
formatter.result({
  "duration": 572880300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Apple MacBook Pro 13-inch",
      "offset": 15
    }
  ],
  "location": "E2ETests.he_search_for(String)"
});
formatter.result({
  "duration": 5685419300,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.choose_to_buy_two_items()"
});
formatter.result({
  "duration": 7298307500,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order()"
});
formatter.result({
  "duration": 13442659300,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.he_can_view_the_order_and_download_the_invoice()"
});
formatter.result({
  "duration": 7212336700,
  "status": "passed"
});
formatter.uri("userRegistration.feature");
formatter.feature({
  "line": 1,
  "name": "User Registration",
  "description": "I want to check that the user can register in our e-commerce website.",
  "id": "user-registration",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "User Registration",
  "description": "",
  "id": "user-registration;user-registration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the user in the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on the regiter link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entererd \"\u003cfirstname\u003e\", \"\u003clastname\u003e\", \"\u003cemail\u003e\", \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The registration page displayed successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "user-registration;user-registration;",
  "rows": [
    {
      "cells": [
        "firstname",
        "lastname",
        "email",
        "password"
      ],
      "line": 11,
      "id": "user-registration;user-registration;;1"
    },
    {
      "cells": [
        "ahmed",
        "moahmed",
        "a.moh11931@test.com",
        "12345678"
      ],
      "line": 12,
      "id": "user-registration;user-registration;;2"
    },
    {
      "cells": [
        "ali",
        "ali",
        "ali22236@test.com",
        "87456321"
      ],
      "line": 13,
      "id": "user-registration;user-registration;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "User Registration",
  "description": "",
  "id": "user-registration;user-registration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the user in the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on the regiter link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entererd \"ahmed\", \"moahmed\", \"a.moh11931@test.com\", \"12345678\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The registration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegistration.the_user_in_the_home_page()"
});
formatter.result({
  "duration": 775857300,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.i_click_on_the_regiter_link()"
});
formatter.result({
  "duration": 2050970300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ahmed",
      "offset": 12
    },
    {
      "val": "moahmed",
      "offset": 21
    },
    {
      "val": "a.moh11931@test.com",
      "offset": 32
    },
    {
      "val": "12345678",
      "offset": 55
    }
  ],
  "location": "UserRegistration.i_entererd(String,String,String,String)"
});
formatter.result({
  "duration": 2894172400,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.the_registration_page_displayed_successfully()"
});
formatter.result({
  "duration": 3338079600,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "User Registration",
  "description": "",
  "id": "user-registration;user-registration;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the user in the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on the regiter link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entererd \"ali\", \"ali\", \"ali22236@test.com\", \"87456321\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The registration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserRegistration.the_user_in_the_home_page()"
});
formatter.result({
  "duration": 1587920300,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.i_click_on_the_regiter_link()"
});
formatter.result({
  "duration": 2027603900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ali",
      "offset": 12
    },
    {
      "val": "ali",
      "offset": 19
    },
    {
      "val": "ali22236@test.com",
      "offset": 26
    },
    {
      "val": "87456321",
      "offset": 47
    }
  ],
  "location": "UserRegistration.i_entererd(String,String,String,String)"
});
formatter.result({
  "duration": 3272725000,
  "status": "passed"
});
formatter.match({
  "location": "UserRegistration.the_registration_page_displayed_successfully()"
});
formatter.result({
  "duration": 2443095300,
  "status": "passed"
});
});