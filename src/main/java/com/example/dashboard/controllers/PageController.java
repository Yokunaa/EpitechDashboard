package com.example.dashboard.controllers;

import com.example.dashboard.model.About;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class PageController {

    public static String getCookieValue(Cookie[] cookies, String cookieName, String defaultValue) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName()))
                    return (cookie.getValue());
            }
        }
        return defaultValue;
    }
    @GetMapping("/")
    public String home(HttpServletRequest request, Model model)
    {
        String email = getCookieValue(request.getCookies(), "email", "no");
        model.addAttribute("email", email );
        return "home";
    }

    @GetMapping("/connexion")
    public String connexion() { return "connexion"; }

    @GetMapping("/inscription")
    public String inscription() { return "inscription"; }

    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request) {
        if (!getCookieValue(request.getCookies(), "email", "").equals("")) {
            return "welcome";
        }
        return "connexion";
    }
    @GetMapping("/logoutmyapp")
    public void logout(HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("email", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect("/");
    }
    @GetMapping("/addWidgets")
    public String addWidgets() { return "addWidgets"; }
}
