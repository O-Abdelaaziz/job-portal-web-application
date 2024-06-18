package com.job.portal.web.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Created 18/6/2024 - 5:59 PM on (Tuesday)
 * @Package com.job.portal.web.application.controller
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
