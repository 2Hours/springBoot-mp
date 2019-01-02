package com.shop.hzq.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visit/view")
public class ViewController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/services")
    public String services(){
        return "services";
    }

    @RequestMapping("/events")
    public String events(){
        return "events";
    }

    @RequestMapping("/products")
    public String products(){
        return "products";
    }

}
