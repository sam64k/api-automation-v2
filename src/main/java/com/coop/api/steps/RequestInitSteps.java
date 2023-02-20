package com.coop.api.steps;

import com.coop.api.data.RequestDataMap;
import com.coop.api.data.GlobalDataMap;
import com.coop.api.utility.FileUtility;
import com.coop.api.utility.StringUtility;
import io.cucumber.java.en.Given;
import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringSubstitutor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RequestInitSteps {
    RequestDataMap RequestDataMap;

    public RequestInitSteps(RequestDataMap RequestDataMap){
        this.RequestDataMap = RequestDataMap;
    }
    @Given("endpoint is {string}")
    public void endpoint_is(String URL) {
        RequestDataMap.setUrl(URL);
    }
    @Given("set headers")
    public void set_headers(io.cucumber.datatable.DataTable headerParams) {
        RequestDataMap.initHeaderParams(headerParams.asMap());
    }
    @Given("set header {string} value {string}")
    public void set_header_value(String attribute, String keyOrValue) {
        String attributeValue;
        if(keyOrValue.startsWith("${")){
            keyOrValue = StringUtility.extractKey(keyOrValue);
            attributeValue = GlobalDataMap.getInstance().getGlobalRefData(keyOrValue);
        }
        else{
            attributeValue = keyOrValue;
        }
        RequestDataMap.addHeaderParam(attribute,attributeValue);
        System.out.println("value : "+attributeValue);
    }
    @Given("set payload")
    public void set_payload(io.cucumber.datatable.DataTable payloadParams) {
        RequestDataMap.initPayloadParams(payloadParams.asMap());
    }
    @Given("read payload file {string}")
    public void read_payload_file(String filename) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        RequestDataMap.setPayload(FileUtility.resolvedPayload(FileUtility.readFile(filename),RequestDataMap.getPayloadParam()));
        System.out.println("Payload 1:"+RequestDataMap.getPayload());

    }
}
