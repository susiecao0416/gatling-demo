package com.testApp.scenarios.external

import java.text.SimpleDateFormat
import java.util.Calendar

import com.testApp.requests.external.LeavesRequests
import io.gatling.core.Predef._
import io.gatling.http.Predef.flushHttpCache
import io.gatling.jdbc.Predef._

object LeavesScenarios {

  //Scenario: get single page and all pages performance/functional
  var leavesFeeder = csv("user-files/data/leaves.csv")
  var pagesFeeder = csv("user-files/data/pages.csv")

  var getLeavesScenario = scenario("Get leaves")
    .group("Get 1000 records for Leaves without cache") {
      feed(pagesFeeder.random)
        .exec(flushHttpCache)
        .exec(LeavesRequests.getLeaves)
    }
    .group("Get 1000 records for Leaves with cache") {
      feed(pagesFeeder.random)
        .exec(LeavesRequests.getLeaves)
    }
    .group("Get 10,000 records for Leaves") {
      repeat(pagesFeeder.readRecords.length) {
        feed(pagesFeeder.circular)
          .exec(LeavesRequests.getLeaves)
      }
    }
}
