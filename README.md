How to run script by command line:
mvn clean -DtestSuite=${test_suite_config} test
For example: mvn clean -DtestSuite=greenkart_suite_all test
View allure report: allure serve target/allure-results