package com.testApp.scenarios.internal

import com.testApp.requests.internal.{LoginOktaRequest, internalRequest}
import io.gatling.core.Predef.{exec, _}
import io.gatling.jdbc.Predef._

object InternalScenario {

  var teScenario = scenario("Load testApp Page scenario")
    .group("Login Okta/testApp")
       {
         exec(LoginOktaRequest.loginOkta)
       }
     .group("testApp Plan request")
     {
       exec(internalRequest.opentestPage)
     }
}
