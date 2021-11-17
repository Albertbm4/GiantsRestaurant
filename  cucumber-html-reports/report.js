$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/giants/training/restaurants/resources/RestaurantService.feature");
formatter.feature({
  "name": "Testing GET and POST. Users should be able to submit GET and POST requests to a web service,represented by WireMock",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Data Upload to a web service",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Create new restaurant service",
  "keyword": "Given "
});
formatter.match({
  "location": "RestaurantServiceStepdefs.createNewRestaurantService()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Users upload data on a project",
  "keyword": "When "
});
formatter.match({
  "location": "RestaurantServiceStepdefs.usersUploadDataOnAProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The server should handle it and return a success status",
  "keyword": "Then "
});
formatter.match({
  "location": "RestaurantServiceStepdefs.theServerShouldHandleItAndReturnASuccessStatus()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Data retrieval from a web service",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Create new restaurant service",
  "keyword": "Given "
});
formatter.match({
  "location": "RestaurantServiceStepdefs.createNewRestaurantService()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "users want to get information",
  "keyword": "When "
});
formatter.match({
  "location": "RestaurantServiceStepdefs.usersWantToGetInformation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the requested data is returned",
  "keyword": "Then "
});
formatter.match({
  "location": "RestaurantServiceStepdefs.theRequestedDataIsReturned()"
});
formatter.result({
  "status": "passed"
});
});