package com.coop.api.steps;

import com.coop.api.data.RequestDataMap;
import io.cucumber.java.en.Then;

public class HTTPRequest {
    RequestDataMap requestdatamap;
    public HTTPRequest(RequestDataMap requestdata){
        this.requestdatamap = requestdata;
    }
    @Then("perform HTTP {string} request")
    public void perform_http_request(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("perform HTTP {string} request");
        requestdatamap.print();
    }
}
