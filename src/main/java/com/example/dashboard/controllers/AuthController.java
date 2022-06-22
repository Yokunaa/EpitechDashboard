package com.example.dashboard.controllers;

import com.example.dashboard.DashboardApplication;
import com.example.dashboard.model.MysqlCon;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@EnableAutoConfiguration
public class AuthController extends DashboardApplication {

    @PostMapping("/register")
    protected void createAccount (HttpServletResponse response, @RequestParam(value = "name", defaultValue = "") String name, @RequestParam(value = "email", defaultValue = "") String email, @RequestParam(value = "password", defaultValue = "") String password) throws IOException{
        MysqlCon bdd = new MysqlCon();
        if (bdd.loginBDD(email, password)){
            response.sendRedirect("/connexion");
        } else {
            bdd.createAccount(name, email, password);
            response.sendRedirect("/");
        }
    }

    @PostMapping("/connexion")
    protected void connect (HttpServletResponse response, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) throws IOException {
        MysqlCon bdd = new MysqlCon();
        if (bdd.loginBDD(email, password)){
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            response.sendRedirect("/welcome");
        } else {
            response.sendRedirect("/connexion");
        }
    }
}
