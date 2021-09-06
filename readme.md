# CucumberBDD2
   1.To run this cucumber framework use the following-<br>
   mvn clean<br>
   mvn compile<br>
   mvn verify<br>
   Or customize from command line using -<br>
   mvn verify -Denv=qa -Dbrowser=ch -Dcucumber.filter.tag="regression"<br><br>

#CucumberFrameworkStructure <br>
   2. We have 4 folders under src/test/java (base, features, pageobjects and stepdef) and a test runner to run the cucumber tests.<br>
   In base - we do the browser setup,<br>
   In features - we have the different scenarios and gherkin syntax test cases,<br>
   In pageObjects - we have the webelements for particular pages,<br>
   In stepDef - we have the automated steps for test case steps,<br>
              - we also have hook in stepDef, it basically has two methods-<br>
                openbrowser(), which is run before every scenario in features,<br>
                teardown(), which is run after every scenario in features,<br>
   In testrunner file - we run the cucumber tests. In cucumber options, we have path to our feature file,<br>
                        glue (package to load our glue code) - stepdef, Hook <br>
                        and we use plugin to generate cucumber jvm html report from json format<br>
