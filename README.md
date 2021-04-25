# README #
Please follow instructions below to understand the framework, and to be able to execute tests in local machine


## Tools and Frameworks used ##
* Cucumber
* Java 1.8
* Junit
* Selenium Webdriver
* IDE of your choice, preferably IntelliJ

## Folder Structure ##

* features : contains feature file with the test scenarios defined
* src.test.java.stepDefinitions : contains all the necessary functions to run the user reuseablity
* src.test.java.testRunner : contains method to run the test scenerios by clicking 'run testRunner'

## Setup & Execution Instructions ##
#### Setup ####

Make sure you have java 1.8 or above installed on your machine.
`

After repo is cloned, installed the requirements by navigating to the cloned repo location and executing following command

`
mvn clean install -DskipTests=true
`
Select the project 'Calculator' > Right click 'Project Structure' > Select libraries under 'Project Structure' > Click + > Add junit to the project
Once all the dependencies are installed, your setup is ready and we are ready for execution

#### Execution ####

We can execute tests using following commands

`
mvn test -Dcucumber.options="<path-of-the-feature-file>"
`

`
example: mvn test -Dcucumber.options="C:\Calculator\Features\Calsi.feature"
`

## Reports ##

After completion of the tests execution, find the report in console stating as **View your Cucumber Report at:**

## Who do I talk to? ##

For any doubts or requests, please shoot a mail to jujitsaikia@gmail.com