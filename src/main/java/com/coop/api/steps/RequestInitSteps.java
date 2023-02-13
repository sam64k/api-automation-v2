package com.coop.api.steps;

import io.cucumber.datatable.internal.difflib.StringUtills;
import io.cucumber.java.en.Given;

import java.util.Map;

public class RequestSetup {
    RequestData requestdata;

    public RequestSetup(RequestData requestdata){
        this.requestdata = requestdata;
    }
    @Given("endpoint is {string}")
    public void endpoint_is(String URL) {
        System.out.println("endpoint is {string}");
        requestdata.setUrl(URL);
    }
    @Given("set headers")
    public void set_headers(io.cucumber.datatable.DataTable headerParams) {
        System.out.println("SET HEADER");
        requestdata.initHeaderParams(headerParams.asMap());
    }
    @Given("set header {string} value {string}")
    public void set_header_value(String attribute, String key) {
        String attributeValue;
        if(key.startsWith("${")){
            key = key.substring(2,key.length()-1);
        }
        attributeValue = ScenarioContext.getInstance().getGlobalRefData(key);
        requestdata.addHeaderParam(attribute,attributeValue);
        System.out.println("key"+key);
        System.out.println("value"+attributeValue);
    }
    @Given("set payload")
    public void set_payload(io.cucumber.datatable.DataTable payloadParams) {
        System.out.println("SET PAYLOAD");
        requestdata.initPayloadParams(payloadParams.asMap());
    }
}
