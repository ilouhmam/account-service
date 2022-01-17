# Service Accounts

### Environment setup
Minimal requirements: Please make sure following software is installed on your PC.
* [JAVA 8](https://www.java.com/fr/download/) or later
* [Gradle 7](https://gradle.org/install/) or later
* [Postman x](https://www.postman.com/downloads/)

### Compile and Build
* run **gradle clean build** =>
  compile, build and test integration 
* check with browser ../affectation-service/build/surefire-reports/karate-summary.html

### Run and Test
* run **gradle bootRun**
* import the Postman collection under project resources directory ../account-service/src/main/resources/collection/Account.postman_collection.json
* run tests manually
