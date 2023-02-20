package com.coop.api.data;

import com.coop.api.utility.StringUtility;

import java.util.HashMap;
import java.util.Map;
public class GlobalDataMap {
    private static GlobalDataMap GlobalDataMap = null;
    private Map<String,String> refData;
    private Map<String,String> scenarioRefData;
    private GlobalDataMap(){
        refData = new HashMap<>();
    }
    public static GlobalDataMap getInstance(){
        if(GlobalDataMap == null){
            GlobalDataMap = new GlobalDataMap();
        }
        return GlobalDataMap;
    }
    public void addToGlobalRefData(String attribute, String Value){
        refData.put(attribute, Value);
    }
    public String getGlobalRefData(String key){
        key = StringUtility.extractKey(key);
        return refData.get(key);
    }
}
