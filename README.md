## Performance Testing using Gatling Demo

### 1 Performance Testing Types introduction in this demo

#### 1.1 Server APIs Testing

- Use Gatling + Maven: https://gatling.io/docs/current/

* There are two types of server api testing, one is internal apis testing, which is found in "PagesSimulation" class
* The other is via public api testing, which is found in "PublicAPIsSimulation"

#### 1.2 Client Testing

- Use SiteSpeedIO: https://www.sitespeed.io/documentation/sitespeed.io/

- the tests are located at: client-performance



### 2 How to do performance testing using Gatling v3.0

### 2.1 How to setup the project using Gatling v3.0
#### 2.1.1 Installation 

1. Download the project from Gitlab

2. Install Maven

3. Make sure the dependencies in pom.xml are configured and finished automatically

4. Run below command to start the performance testing: 

  ```
  export JIGSAW_URL="https://dev.testApp.testCompany.net"
  export API_TOKEN="xxxxx"
  mvn gatling:test 
  ```

or 

```mvn gatling:test -Dgatling.simulationClass=computerdatabase.BasicSimulation
mvn gatling:test -Dgatling.simulationClass=computerdatabase.BasicSimulation
```

#### 2.1.2 Recorder

$GATLING_HOME/bin/recorder.sh 

#### 2.1.3 How to integrate with Jenkins

1 Please refer to "Configuration" section in https://plugins.jenkins.io/gatling
2 Please follow below steps in Jenkins 
2.1 Please create a new Maven Project first:

- Jenkins -> New Items -> Select Maven project
- Please follow from "1.png" to "5.png" to finish the configuration on the maven project
- Add one build step in the pipeline project where you want to run, please follow "6.png" in the pipeline project configuration, then you can run the performance scripts in Jenkins

2.2 View the results in Jenkins
Please follow from "7.png" to "8.png" to view the results

#### 2.1.4 How to run the scripts locally

Please run "env.sh" in "config" folder



### 2.2 How to Design 

#### - Okta Login if needed

1. Okta login is using the testing account and this testing account has been assigned to testApp dev and testApp staging.



### 3 Client's performance testing using sitespeed.io

#### 3.1 SiteSpeedIO introduction