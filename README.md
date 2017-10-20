

							FloowDemo

##### Testing framework for application that analyses user driving habits and scores them on certain parameters.(read FAQs)

##### Objective 
---
To illustrate object oriented development of a test-framework from the grounds up and validating scenarios in given test application. 

##### Class
---
This would precisely explain how to get started with Android App testing, write the first test and then the test suite management.

This java project has been created using Eclipse Community Edition. POM File manages the dependency of Selenium. Project is using TestNG annotation. I have also bundled the respective mobile applications under the apps folder for ease.

##### Steps:
---
 a. *Appium Set up* - Before running the project you need to download and install Appium. Once this this done, do the android SDK set up as mentioned below.

 b. *Android SDK Set up* - Download Android SDK, set up the path appropriately. Launch Appium and start the device.

 c. *Clone this repository*
 
 d. *Open the project in IDE*
 
 e. *Change the application location destination in AndroidSetup.java and the device name you want to run on.*
 
 f. *Rebuild*
 
 g. *Run the AppiumTest test using testNG run configuration*
##### Logger
---
All java files log Info,Debug, Warn level information to console and logfile called 'applog.txt'. The configuration for logger is defined in log4j.properties.

##### C*.java
---
All files containing constants start with 'C' followed by the name of the tab/view in the app it is related to.For example, CMapView contains constants related to mapView of a journey.

##### ILogin.java
---
This interface includes member variables that are IDs for elements during login process and also declarations for methods including validLogin,registerNewAccount.

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

 

 
 <a href="http://www.youtube.com/watch?feature=player_embedded&v=YOUTUBE_VIDEO_ID_HERE
" target="_blank"><img src="http://img.youtube.com/vi/YOUTUBE_VIDEO_ID_HERE/0.jpg" 
alt="IMAGE ALT TEXT HERE" width="240" height="180" border="10" /></a>


