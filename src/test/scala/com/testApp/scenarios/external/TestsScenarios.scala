package com.testApp.scenarios.external

import .pagesFeeder
import io.gatling.core.Predef._
import io.gatling.jdbc.Predef._

object TestsScenarios {

  //Scenario: get single page and all pages performance/functional
  var getPerformancesScenario = scenario("Get Performance tests").repeat(2) {
    exec(StaffingRequestsScenarios.getStaffingRequestsScenario)
      .exec(AssignmentsScenarios.getAssignmentsScenario)
      .exec(LeavesScenarios.getLeavesScenario)
      .exec(ConsultantsScenarios.getConsultantScenario)
      .exec(ConsultantsScenarios.getConsultantbyStaffingOfficesScenario)
      .exec(ConsultantsScenarios.getConsultantbyWorkingOfficesScenario)
  }
}
