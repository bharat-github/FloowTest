

							FloowDemo

##### Testing framework for application that analyses user driving habits and scores them on certain parameters.(read FAQs)

##### Objective 
---
To illustrate object oriented development of a test-framework from the grounds up and validating scenarios in given test application. 

##### Key Features
---
*All constants are in separate package
*All tests are contained in tests package
```
HelpTest - *pauseApp* contains the test to pause app by navigating to preferences in help tab
JourneyTest- *startJourney,stopJourney,modifyJourneyType,changeMapView* contains test related to journey tab
NegativeTest - *notRegisteredtest* contains user trying to gain access without registering
NewRegistrationTests - *registeredLoginAfterResgistering,registerNew* registers a new user and then logins into app
OldUserTests - * startJourney,stopJourney,sendFeedback,declareEmergency* - contains user action tests that a resgistered user can do on the home tab
ScoreTest - *changeScoreToMonthly,openScoreDetails* - tests implemented for score tab
SocialTest - *addFriendByEmail,changeProfileName* - tests implemented for social tab

```

##### Steps:
---

 a. *Android SDK Set up* - Download Android SDK, set up the path appropriately. 
 
 b. *Appium Set up* - download the latest appium installation from the official website based on the OS. Install and update the environment variables. Launch Appium and start the device. 

 c. *Clone the repository at https://github.com/bharat-github/FloowTest*
 
 d. *Open the project in IDE and resolve any dependency issues*
 
 e. *Update any constant values like device type (on which the test are to be run in CAppSetup)*
 
 f. *Run the various tests using testNG run configuration*
 
##### Logger
---
All java files log Info,Debug, Warn level information to console and logfile called 'applog.txt'. The configuration for logger is defined in log4j.properties.

##### C*.java
---
All files containing constants start with 'C' followed by the name of the tab/view in the app it is related to.For example, CMapView contains constants related to mapView of a journey.

##### I*.java
---
These interface includes member variables that are IDs for elements during various test scenarios and also declarations for methods including validLogin,registerNewAccount.

##### User.java 
---
This class contains details of users of the application and implements actions that include logging into the app, registering a new account.

	Registering a new user requires following parameters :
		1. Firstname
		2. Surname
		3. Date of Birth
		4. Email Address
		5. PostCode
		6. Company Name
		7. Password

##### Accounts.java
---
This class helps generate random values for 7 parameters listed above. Some of the values are hardcoded but can be refined at a later stage.

 



