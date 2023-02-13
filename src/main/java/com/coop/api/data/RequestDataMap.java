package com.coop.api.steps;

import com.coop.api.utility.StringUtility;

import java.util.HashMap;
import java.util.Map;

public class RequestDataSetup {
    String url;
    Map<String,String> headerParams = new HashMap<>();
    Map<String,String> payloadParams = new HashMap<>();
    String Auth;

    public void setUrl(String url){
        this.url = url;
    }
    public void initHeaderParams(Map<String,String> headerParams){
        headerParams.forEach(this::addHeaderParam);
    }
    public void addHeaderParam(String attribute,String attributeValue){
        this.headerParams.put(attribute, attributeValue);
    }
    String getHeaderParam(String key){
        return headerParams.get(key);
    }
    public void initPayloadParams(Map<String,String> payloadParams){
        payloadParams.forEach(this::addPayloadParam);
    }
    public void addPayloadParam(String attribute,String attributeValue){
        this.payloadParams.put(attribute, attributeValue);
    }
    String getPayloadParam(String key){
        return payloadParams.get(StringUtility.extractKey(key));
    }
    public void print(){
        System.out.println("URL:"+url);
        System.out.println("headerParams:"+headerParams);
        System.out.println("payloadParams:"+payloadParams);
    }
}
