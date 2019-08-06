package com.testApp.requests.internal

import com.testApp.config.Config
import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.{http, status, _}
import io.gatling.jdbc.Predef._

object internalRequest {

   //Header configurations
   // Headers configurations
   val header_test = Map(
      "accept" -> "*/*",
      "accept-encoding" -> "gzip, deflate, br",
      "accept-language" -> "en-US,en;q=0.9",
      "cache-control" -> "no-cache",
      "pragma" -> "no-cache",
      "origin" -> Config.appURL,
      "user-agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36",
      "x-requested-with" -> "XMLHttpRequest")

   // Open home page within My work by default(China, US and India)
   var opentestPage = exec(http("Open testApp Plans")
     .get(Config.internal_test_url)
     .headers(header_test)
     .check(status.is(200)))
     .pause(5)
}
