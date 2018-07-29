Feature: Adding stock name in the portfolio

Background:
Given User access rediff.com website
And User clicks on Money link
And User clicks on Sign in link
And User enters valid username
And User clicks on email submit button
And User enters valid password
When User clicks on Enter button

@Live
Scenario: User should be able to login to the site with right credentials
Then Username should be displayed on the page   

@Staging
Scenario: Logging into account user should be able to add stockname

And User selects portfolio to add stock
And User clicks on add stock
And User enters stock name
And User selects stock purchase date from the calendar
And User enters quantity
And User enters purchase price
When User Clicks on add stock button
Then Stock name should be added to the list   
