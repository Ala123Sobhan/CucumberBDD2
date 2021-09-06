# CucumberBDD2
   1.To run this cucumber framework use the following-
   mvn clean
   mvn compile
   mvn verify
   Or customize from command line using -
   mvn verify -Denv=qa -Dbrowser=ch -Dcucumber.filter.tag="regression"

2. We have 4 folders under src/test/java (base, features, pageobjects and stepdef) and a test runner to run the cucumber tests
   In base - we do the browser setup 
   In features - we have the different scenarios and gherkin syntax test cases
   In pageObjects - we have the webelements for particular pages
   In stepDef - we have the automated steps for test case steps
              - we also have hook in stepDef, it basically has two methods-
                openbrowser(), which is run before every scenario in features
                teardown(), which is run after every scenario in features
   In testrunner file - we run the cucumber tests. In cucumber options, we have path to our feature file, 
                        glue (package to load our glue code) - stepdef, Hook 
                        and we use plugin to generate cucumber jvm html report from json format
