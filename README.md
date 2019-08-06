# Guides to start performance testing
There are two types of performance testing:
1. targeted on server/api using Gatling, and the tests located at: scr/test/scala and src/test/resources
* There are two types of server api testing, one is via browser, which is found in "PagesSimulation" class
* The other is via non-browser, which is found in "PublicAPIsSimulation"
2. targeted on client using sitespeed-io, and the tests located at: client-performance

## How to do performance testing using Gatling v3.0
The project is using Gatling + Maven

### How to setup the project using Gatling v3.0
#### 1 Prerequisites
1. Okta login is using the testing account and this testing account has been assigned to testApp dev and testApp staging.
2. How to assign the testApp Dev and staging to the testing account to make sure the testing account can access testApp?
* Login OktaPreview as Admin and find the testing account: xxxx@xxxx.com
* Assign testApp Dev and testApp staging to this testing account 
* Update the employee id: Please refer to "update in Okta Preview.png" in "readMe pictures" folder
 
#### 2 Installation 
1. Download the project from Gitlab
2. Install Maven
3. Make sure the dependencies in pom.xml are configured and finished automatically
4. Run below command to start the performance testing: 
export JIGSAW_URL="https://dev.testApp.testCompany.net"
export API_TOKEN="xxxxx"
mvn gatling:test 

or 
$mvn gatling:test -Dgatling.simulationClass=computerdatabase.BasicSimulation

#### 3 Recorder
$GATLING_HOME/bin/recorder.sh 

#### 4 How to integrate with Jenkins
1 Please refer to "Configuration" section in https://plugins.jenkins.io/gatling
2 Please follow below steps in Jenkins 
2.1 Please create a new Maven Project first:
'''
1 Jenkins -> New Items -> Select Maven project
2 Please follow from "1.png" to "5.png" to finish the configuration on the maven project
'''
2.2 Add one build step in the pipeline project where you want to run
Please follow "6.png" in the pipeline project configuration
Then you can run the performance scripts in Jenkins

3 View the results in Jenkins
Please follow from "7.png" to "8.png" to view the results

#### 5 How to run the scripts locally
5.1 Please run "env.sh" in "config" folder


## How to do performance testing using sitespeed.io v8.6
### SiteSpeedIO introduction



--------------------
## References:
* https://www.sitespeed.io/documentation/sitespeed.io/
* Sitespeed scripts: https://www.sitespeed.io/documentation/sitespeed.io/scripting/#commmands
* https://gatling.io/docs/current/
* https://www.testingexcellence.com/gatling-maven-performance-test-framework/
