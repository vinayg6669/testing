Feature: Login

Background: Verify login with valid credentials
Given Initialize the browser with chrome
And Navigate to  "http://realty-real-estatem1.upskills.in/my-profile/" site
And Click on Login link in home page to land on Secure sign in Page
When I entered valid mohankrishna176@gmail.com and valid Secret@123&& logs in
Then Click on signin button
And I click on the posts button
 

@addpost
Scenario: Verify Weather add post is working or not 
When I click on the posts button
And I click on the add New button in posts page
And Enter the post name in the text box
And click on publish button
Then close broswer


@allpost
Scenario: Verify all posts page
When I click on the posts button
When I click on all posts button
And I click on Bulk Actions dropdown in all posts page
And I click on All dates dropdown in all posts page
And I click on All Categories dropdown in all posts page
And I click on Screen Options dropdown in all posts page
And I click on Screen Options dropdown in all posts page
And I click on Help dropdown in all posts page
And I click on Help dropdown in all posts page
Then close broswer


@categories
Scenario: Verify add new Category functionality
When I click on the posts button
When I click on categories button
And Enter category name in name textbox
And Enter slug in slug textbox
And I select the option in parent category dropdown
And I enter the Description in description textbox
And I click on the Add new category button
And Enter the category name in the search text box
And click on Search Categories button
Then close broswer


@tags
Scenario: Verify add new Tag functionality
When I click on the posts button
When I click on Tag button
And Enter Tag name in name textbox
And Enter slug in slug textbox
And I enter the Description in description textbox
And I click on the Add new Tag button
And Enter the Tag name in the search text box
And click on Search Tags button
Then close broswer


@searchbox
Scenario: Verify the working functionality of serch box
When I click on the posts button
And Enter the post name in the search text box
And click on Search Posts button
And click on Dashboard button


@functionsS
Scenario: Verify Weather all functions is working or not
Given click on the all posts option
And user gets some options 
When user click on each option 
Then very option will display related content

