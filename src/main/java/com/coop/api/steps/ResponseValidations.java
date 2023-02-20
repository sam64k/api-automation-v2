package com.coop.api.steps;

import com.coop.api.data.RequestDataMap;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResponseValidations {
    RequestDataMap RequestDataMap;
    public ResponseValidations(RequestDataMap RequestDataMap){
        this.RequestDataMap = RequestDataMap;
    }
    @When("response status code is {string}")
    public void response_status_code_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("response status code is 200");
    }

    @Then("validate response {string} equals {string}")
    public void validate_response_equals(String attribute, String keyOrValue) {
        // Write code here that turns the phrase above into concrete actions
        String expectedValue;
        if(keyOrValue.startsWith("${")){
            expectedValue = RequestDataMap.getPayloadParam(keyOrValue);
        }
        else{
            expectedValue = keyOrValue;
        }
        //Pending implementaions -- Code to get actual value from response
        System.out.println("Expected : "+expectedValue);
    }
}
