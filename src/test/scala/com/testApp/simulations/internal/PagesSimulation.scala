package com.testApp.simulations.internal

import com.testApp.config.Config
import com.testApp.scenarios._
import com.testApp.scenarios.internal.InternalScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef.http
import io.gatling.jdbc.Predef._


class PagesSimulation extends Simulation{

  val httpProtocol = http
    .baseUrl(Config.appURL)
    .inferHtmlResources()
    .disableCaching
//    .silentUri("https://testCompany.oktapreview.com/.*")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")

  setUp(
    (InternalScenstario.teScenario).inject(atOnceUsers(1))
  ).protocols(httpProtocol)
    .assertions(
      details("testApp request").responseTime.max.lte(10000)
    )
}
