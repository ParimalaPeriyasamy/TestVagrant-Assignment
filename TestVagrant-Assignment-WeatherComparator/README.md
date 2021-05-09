# TestVagrant Weather Comparator- Assignment

#### Project Description

This project is to compare Weather Information between Web and API with user defined variance range.

#### Project Setup
Clone the repository or download the project and place it into your local machine using the below command

```
git clone https://github.com/ParimalaPeriyasamy/TestVagrant-Assignment.git
```
#### Prerequisite

* [Maven](https://maven.apache.org/install.html)

#### Project Structure
```
- src/main/java
	- com.testvagrant.api
		 - APIHelper.java
	- com.testvagrant.comparator
		- IWeatherComparator.java
	- com.testvagrant.drivermanager
		- ChromeDriverManager.java
		- DriverFactory.java
		- FirefoxDriverManager.java
		- IDriver.java
	- com.testvagrant.model
		- VarianceModel.java
		- WeatherModel.java
	- com.testvagrant.pages
		- BasePage.java
		- NDTVHomePage.java
		- NDTVWeatherPage.java
	- com.testvagrant.utils
		- PropertyReader.java
		
- src/test/java
	- com.testvagrant.testcases
		- NDTVWeatherPageTest.java
		- OpenWeatherAPITest.java
		- WeatherComparator.java
		
- src/test/resources
	- comparator.properties
	- config.properties
```

#### To run the Tests
Either through Maven/testng.xml you can run the Tests
1. Open cmd
2. cd to project’s root folder in command line (ex: c:\Users\TestVagrant-WeatherComparator)
3. Execute any one below command and by default it will run in ChromeBrowser

```
mvn clean test 

```

To run the tests in Firefox browser, use the below command

```
mvn clean test -Dbrowser=firefox
```
To run the tests in headless mode, use the below command

```
mvn clean test -Dbrowser=chrome -Dheadless=true
```

#### Test Reports

After execution of the test suite navigate to project directory --> target/surefire-reports and open the index.html file to view report


