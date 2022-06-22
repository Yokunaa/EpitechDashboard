package com.example.dashboard.model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private long current_time;
    private ArrayList<String> services;

    public Server() {
        this.current_time = System.currentTimeMillis();
    }
    public long getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(long current_time) {
        this.current_time = current_time;
    }

//    public ArrayList<String> getServices(){
//        ArrayList services = new ArrayList<>();
//        services.add("{name : Weather");
//        services.add("ezarzerq");
//        return services;
//    }
//    public void setServices() {
//        json.put("name", "Weather");
//        json1.put("name", "Steam");
//        json2.put("name", "Exchange");
//        json3.put("name", "Youtube");
//        json4.put("name", "Weather");
//        json5.put("name", "Weather");
//        this.services.add(json);
//        this.services.add(json1);
//        this.services.add(json2);
//        this.services.add(json3);
//        this.services.add(json4);
//        this.services.add(json5);
//    }
}