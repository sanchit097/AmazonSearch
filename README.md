#amazon-search

This is a test automation project, where the system search for the product by the given keyword in the amazon website.

#Prerequisites:

1. Maven
2. Jdk 1.6 and above

#Getting started:

1. git clone https://github.com/sanchit097/amazon-search.git

2. inside project go to amazon-search/resources/configuration/config.property

3.Provide the absolute driverPath example:'c:/drivers/chromeDriver.exe'(by default it will take the chrome driver path from project). 

4.Provide the browser type in config.property file (chrome,firefox,internetexplorer).Default chrome is are selected.

#Running the tests:

1. cd amazon-search
2. mvn clean test

#Test Result:

Cucumber test results can be seen in target/cucumber/index.html file.


Author

Sanchit Singh Negi
