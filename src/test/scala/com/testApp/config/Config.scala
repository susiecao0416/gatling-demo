package com.testApp.config

object Config {

   var oktaURL = "https://testCompany.oktapreview.com"
   var loginOktaAPIURL = "/api/v1/authn"
   var securityAPIURL = "/api/v1/authn/factors/ufsaf5jvppV3yggtx0h7/verify?rememberDevice=false"

   var appURL = sys.env("APP_URL");
   var apiToken=sys.env("API_TOKEN");

   // Public APIs paths definition
   var leaveURL = "/api/leave"
   var peopleURL = "/api/people"

   // Internal APIs paths definition
   var internal_test_url = "/testing_plans"

   // Other configurations
   var requestPauseTime = 2;

//  val users = Integer.getInteger("users", 10).toInt
//  val rampUp = Integer.getInteger("rampup", 1).toInt
//  val throughput = Integer.getInteger("throughput", 100).toInt
}
