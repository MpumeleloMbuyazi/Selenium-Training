$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Login facebook scenario",
  "description": "",
  "id": "login;login-facebook-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User is on Facebook login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Application page tittle is Facebook",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User enters UserName and Password",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User clicks on Login button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User should access their account",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_application_home_page()"
});
formatter.result({
  "duration": 7909011401,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.application_page_tittle_is_Facebook()"
});
formatter.result({
  "duration": 11166401,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_enters_UserName_and_Password()"
});
formatter.result({
  "duration": 170202700,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_clicks_on_Login_button()"
});
formatter.result({
  "duration": 132271201,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_should_access_their_account()"
});
formatter.result({
  "duration": 4347557100,
  "status": "passed"
});
});