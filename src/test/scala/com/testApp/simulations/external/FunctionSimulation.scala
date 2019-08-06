package com.testApp.simulations.external

import com.testApp.config.Config
import com.testApp.scenarios.external.LeavesScenarios
import io.gatling.core.Predef._
import io.gatling.http.Predef.http
import io.gatling.jdbc.Predef._

import scala.concurrent.duration._

class FunctionSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl(Config.appURL)
    .authorizationHeader(Config.apiToken)
    .acceptHeader("application/json")

  setUp(
    // functional tests scenarios

  ).assertions(
      global.successfulRequests.percent.gt(95)
    )
}
