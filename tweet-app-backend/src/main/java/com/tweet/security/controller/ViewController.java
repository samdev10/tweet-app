package com.tweet.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/signup")
    public String signup() {
        return "/index.html";
    }
}
