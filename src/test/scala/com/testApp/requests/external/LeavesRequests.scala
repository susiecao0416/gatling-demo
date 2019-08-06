package com.testApp.requests.external

import com.testApp.config.Config
import io.gatling.core.Predef.{ElFileBody, exec, _}
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder
import io.gatling.jdbc.Predef._

object LeavesRequests {

   // Requests configurations
   var getLeaves = exec(http("Get the Leaves")
    .get(Config.leaveURL)
    .queryParam("page", "${page}")
     .check(status.in(200, 304))
  )

  var getLeavesByFilters = exec(http("Get the Leaves by Filters")
    .get(Config.leaveURL)
    .check(status.is(200))
    .check(responseTimeInMillis)
  )
    .pause(2)

  var postLeave = exec(http("Post Leave")
    .post(Config.leaveURL)
    .body(ElFileBody("user-files/data/leavesTemplate.json")).asJson
    .check(status.is(201))
    .check(responseTimeInMillis)
  )

  var putLeaveURL = Config.leaveURL + "/" + "";
  var putLeave = exec(http("Update Leave")
    .delete(putLeaveURL)
    .body(ElFileBody("user-files/data/leavesTemplate.json")).asJson
    .check(status.is(201))
    .check(responseTimeInMillis)
  )

  var deleteLeaveURL = Config.leaveURL + "/" + "";
  var deleteLeave = exec(http("Delete Leave")
    .delete(deleteLeaveURL)
    .body(ElFileBody("user-files/data/leavesTemplate.json")).asJson
    .check(status.is(201))
    .check(responseTimeInMillis)
  )
}
