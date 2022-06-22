package com.example.dashboard.controllers;

import com.example.dashboard.model.About;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AboutController {
    @RequestMapping("/about.json")
    public About about(HttpServletRequest request) {
        return new About(request.getRemoteAddr());
    }
}
