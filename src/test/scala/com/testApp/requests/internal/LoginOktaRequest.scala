package com.testApp.requests.internal

import com.testApp.config.Config
import io.gatling.core.Predef.{ElFileBody, RawFileBody, exec, jsonPath, _}
import io.gatling.http.Predef.{http, status, _}
import io.gatling.jdbc.Predef._

object LoginOktaRequest {

   // Headers configurations
   val okta_home_header = Map(
      "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
      "accept-encoding" -> "gzip, deflate, br",
      "accept-language" -> "en-US,en;q=0.9",
      "cache-control" -> "no-cache",
      "pragma" -> "no-cache",
      "upgrade-insecure-requests" -> "1")

   val okta_authentication = Map(
      "accept" -> "application/json",
      "accept-encoding" -> "gzip, deflate, br",
      "accept-language" -> "en",
      "content-type" -> "application/json",
      "origin" -> Config.oktaURL,
      "x-okta-xsrftoken" -> "",
      "x-requested-with" -> "XMLHttpRequest")

   // Login Okta page
   var loginOkta = exec(http("Open Okta home page")
     .get("/")
     .headers(okta_home_header)
     .check(status.is(200))
      )
     .pause(10)

     .exec(http("Login with username/password")
       .post(Config.oktaURL + Config.loginOktaAPIURL)
       .headers(okta_authentication)
       .body(RawFileBody("bodies/login_username_password.txt"))
       .check(status.is(200))
       .check(jsonPath("$.stateToken").find.saveAs("testToken")))
     .pause(5)

     .exec(http("Login with answer")
       .post(Config.oktaURL + Config.securityAPIURL)
       .headers(okta_authentication)
       .body(ElFileBody("bodies/login_securityquestion.txt"))
       .check(status.is(200)))
     .pause(5)
}
