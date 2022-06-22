package com.example.dashboard.controllers;

//AIzaSyBpcqFcV1HABnNEDvnqYjgxOZXttUrwhoU

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@RestController
public class YoutubeController {
    @RequestMapping("/yt/{channelid}")
    public JSONObject getGameInfo(@PathVariable("channelid") String channelid) throws ParseException {
            JSONObject json = jsonGetRequest("https://www.googleapis.com/youtube/v3/channels?part=statistics&id="+channelid+"&key=AIzaSyBpcqFcV1HABnNEDvnqYjgxOZXttUrwhoU");
        return json;
    }
    public static JSONObject jsonGetRequest(String urlQueryString) {
        try {
            URL url = new URL(urlQueryString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(new InputStreamReader(inStream, "UTF-8"));
            return jsonObject;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
