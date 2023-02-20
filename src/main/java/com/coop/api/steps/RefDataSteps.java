package com.coop.api.steps;

import com.coop.api.data.GlobalDataMap;
import io.cucumber.java.en.Then;

public class RefDataSteps {
    @Then("store {string} from response as {string}")
    public void store_from_response_as(String attribute, String key) {
        //value from response = get value from response
        String attributeValue = "TOKENvaluefromresponse";
        GlobalDataMap.getInstance().addToGlobalRefData(key,attributeValue);
    }
}
