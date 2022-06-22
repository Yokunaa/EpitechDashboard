package com.example.dashboard.controllers;

import com.example.dashboard.model.MysqlCon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class WidgetSelector {
    @GetMapping("/isWidgetSelected/{widget}")
    protected String isWidgetSelected(HttpServletRequest request, @PathVariable("widget") String widget) throws IOException {
        MysqlCon bdd = new MysqlCon();
        return String.valueOf(bdd.isWidgetSelected(request, widget));
    }
}
