package com.coop.api.data;

import com.coop.api.utility.StringUtility;

import java.util.HashMap;
import java.util.Map;

public class RequestDataMap {
    String url;
    private String payload;
    private Map<String,String> headerParams = new HashMap<>();
    private HashMap<String,String> payloadParams = new HashMap<>();
    String Auth;

    public void setUrl(String url){
        this.url = url;
    }
    public void initHeaderParams(Map<String,String> headerParams){
        headerParams.forEach((key,value)->{
            if(value.startsWith("${")){
                value = GlobalDataMap.getInstance().getGlobalRefData(value);
            }
            this.headerParams.put(key,value);
        });
    }
    public void addHeaderParam(String attribute,String attributeValue){
        this.headerParams.put(attribute, attributeValue);
    }
    String getHeaderParam(String key){
        return headerParams.get(key);
    }
    public void initPayloadParams(Map<String,String> payloadParams){
        //payloadParams.forEach(this::addPayloadParam);
        payloadParams.forEach((key,value)->{
            if(value.startsWith("${")){
                value = GlobalDataMap.getInstance().getGlobalRefData(value);
            }
            this.payloadParams.put(key,value);
        });
    }
    public void addPayloadParam(String attribute,String attributeValue){
        this.payloadParams.put(attribute, attributeValue);
    }
    public String getPayloadParam(String key){
        return payloadParams.get(StringUtility.extractKey(key));
    }

    public HashMap<String,String> getPayloadParam(){return payloadParams;}

    public void setPayload(String payload){
        this.payload = payload;
    }
    public String getPayload(){
        return this.payload;
    }

    public void print(){
        System.out.println("URL:"+url);
        System.out.println("headerParams:"+headerParams);
        System.out.println("payloadParams:"+payloadParams);
    }
}
