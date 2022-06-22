package com.example.dashboard.controllers;

import com.example.dashboard.DashboardApplication;
import com.example.dashboard.model.MysqlCon;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@EnableAutoConfiguration
public class WidgetsController extends DashboardApplication {

    @GetMapping("/addWidgets/{widget}")
    protected void addWidget(HttpServletRequest request, HttpServletResponse response, @PathVariable("widget") String widget) throws IOException {
        MysqlCon bdd = new MysqlCon();
        bdd.addWidget(request, widget);
        response.sendRedirect("/welcome");
    }
    @GetMapping("/delWidgets/{widget}")
    protected void delwidgets(HttpServletRequest request, HttpServletResponse response, @PathVariable("widget") String widget) throws IOException {
        MysqlCon bdd = new MysqlCon();
        bdd.delWidget(request, widget);
        response.sendRedirect("/welcome");
    }

}

