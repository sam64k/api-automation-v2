package com.coop.api.steps;

import io.cucumber.java.en.Then;

public class RefData {
    @Then("store {string} from response as {string}")
    public void store_from_response_as(String attribute, String key) {
        //value from response = get value from response
        String attributeValue = "TOKENvaluefromresponse";
        ScenarioContext.getInstance().addToGlobalRefData(key,attributeValue);
    }
}
