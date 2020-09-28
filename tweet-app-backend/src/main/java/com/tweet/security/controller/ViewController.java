package com.tweet.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * View controller
 */
@Controller
public class ViewController {

    /**
     * @return the page name.
     */
    @RequestMapping("/signup")
    public String signup() {
        return "/index.html";
    }
}
