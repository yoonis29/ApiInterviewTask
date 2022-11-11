$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/api/room.feature");
formatter.feature({
  "name": "Roomba Navigation System",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "verify roomba patches and final coordinates",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@roomba"
    }
  ]
});
formatter.step({
  "name": "Users sends POST request to \"roomba.endpoint\"",
  "keyword": "Given "
});
formatter.match({
  "location": "RoombaStepDefs.users_sends_POST_request_to(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "output should match expected",
  "keyword": "Then "
});
formatter.match({
  "location": "RoombaStepDefs.output_should_match_expected()"
});
formatter.result({
  "status": "passed"
});
});