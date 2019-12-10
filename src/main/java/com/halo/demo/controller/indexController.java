package com.halo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/11/4 10:22.
 */
@Controller
public class indexController {

    @GetMapping("/index")
    public String get(){
        return "index";
    }


}
