package com.testApp.config

object Config {

  var oktaURL = "https://testCompany.oktapreview.com"
  var loginOktaAPIURL = "/api/v1/authn"
  var securityAPIURL = "/api/v1/authn/factors/ufsaf5jvppV3yggtx0h7/verify?rememberDevice=false"

  var appURL = sys.env("APP_URL");
  var apiToken = sys.env("API_TOKEN");

  // Public APIs paths definition
  var leaveURL = "/api/people"

  // Internal APIs paths definition
}
