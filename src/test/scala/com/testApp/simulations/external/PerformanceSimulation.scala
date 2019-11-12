package com.testApp.simulations.external

import com.testApp.config.Config
import com.testApp.scenarios._
import .pagesFeeder
import com.testApp.scenarios.external._
import io.gatling.core.Predef._
import io.gatling.http.Predef.http
import io.gatling.jdbc.Predef._
import io.gatling.core.controller.inject.open.AtOnceOpenInjection

import scala.concurrent.duration._

class PerformanceSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl(Config.appURL)
    .authorizationHeader(Config.apiToken)
    .acceptHeader("application/json")
    .inferHtmlResources()
    .disableFollowRedirect

  setUp(
    // performance scenarios: get 1000 and 10,000 records
    CombinationScenarios.getPerformancesScenario.inject(atOnceUsers(1))
  ).protocols(httpProtocol)
    .assertions(
      global.successfulRequests.percent.gt(95)
    )
}
