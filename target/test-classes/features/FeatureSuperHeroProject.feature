# language: en
@tag
Feature: SuperHero


  Scenario Outline::  SuperHero

    Given the home page is opened
    And I select the checkbox "I agree to the Superhero"
    And I click on "Generate New Wallet" button
    And I click on "Skip" button
    And I click on "Generate Wallet" button
    And the extension chrome is "<installed_Or_No>"
    And I select the checkbox "I understand that this is a cryptocurrency wallet and I am responsible for backing up my account recovery seed phrase."

    And I click on "Proceed to your Wallet" button




    When I click on " My Profile " in the left menu
    Then the page "user-profil" is opened
    When I click on the button of "Change Cover Photo"
    And I upload the photo "ITTest.png"
    Then the photo is uploaded
    #And I click on "Confirm" button
    When I click on the button of "Edit Profile"
    And I enter "Test" in "Edit Biography"
    And I click on the button of "Save"

    Then the value of profile description is "Test"
    When I enter "  a knock-out punch to those asshole bosses whose cluelessness continues to harm both their employees and the overall organisation. " in "Search Superhero"
    Then the video finded is "#OldGold #Must #goodread a knock-out punch to those asshole bosses whose cluelessness continues to harm both their employees and the overall organisation."
    When I click on button of comment
    And I enter "comment test" in "Add reply"
    And I click on the button of "Reply"
    Then the comment is added
    When I add a reply to a comment
    Then the replay is added
    When I disallow cookies from 3rd party providers
   # And I click superhero logo
    And I refresh the page
    When I enter "youtube" in "Search Superhero"
    Then all post finded are from youtube

    When I click on play button of first video
    #When I click on "button-plain play play-button" button of first video
    And I click on Allow YouTube button
    And I click on play button of first video
    And I click on play button youtube of first video
    #And I click on "button-plain play play-button" button of first video

    #And I click on "ytp-large-play-button ytp-button" button of first video

    Then the video is played

   # Then The account is removed

    Examples:
      | installed_Or_No  |
      | not installed    |
      | installed        |

