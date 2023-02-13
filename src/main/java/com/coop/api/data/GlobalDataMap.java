package com.coop.api.steps;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
public class ScenarioContext {
    private static ScenarioContext Scenariocontext = null;
    private Map<String,String> globalRefData;
    private Map<String,String> scenarioRefData;
    private ScenarioContext(){
        globalRefData = new HashMap<>();
    }
    public static ScenarioContext getInstance(){
        if(Scenariocontext == null){
            Scenariocontext = new ScenarioContext();
        }
        return Scenariocontext;
    }
    public void addToGlobalRefData(String attribute, String Value){
        globalRefData.put(attribute, Value);
    }
    public String getGlobalRefData(String key){
        return globalRefData.get(key);
    }
}
