# FWIENDS - the social network

This is a new social network built in Groovy to cover the following user stories:

**User creating**: a new user called *Spike* can be created  

**Posting**: *Spike* can publish messages to a personal timeline  

**Reading**: *Spike* can view *Nikesh’s* timeline  

**Following**: *Leo* can subscribe to *Spike* and *Nikesh's* timelines, and view an aggregated list of all subscriptions

to Use;

- Clone this repo
- brew install groovy
- brew install gradle
- run gradle clean build

## Notes/Improvements:

- The moments have a dateStamp that is currently created by manually passing a String
  this would be acheived using a date or calendar object in a real world implementation. As this was outside the scope of the original user stories this was included just as a way of making the presentation strings for the timeline seem more realistic.

- The current solution is 'Chicago Style' although I found ways to build mocks of  specific instances of classes I couldn't find a way to mock the whole class so that the new method creates another double. This is where I would spend my time, attempting to change my tests to concern themselves with messages sent and not the changes in state and therefore improving the.

- It feels as though the controller is doing two main actions at the moment; allowing the user to post Moments, follow fwiends and viewTimelines as well as formatting the strings. I therefore think that a presenter class should be implemented to extract this requirement on the controller.  
