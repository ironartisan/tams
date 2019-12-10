package com.halo.demo.controller;

import com.halo.demo.model.Teacher;
import com.halo.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/11/4 10:22.
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/login")
    public String get(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "tno", required = false) Integer tno,
                           @RequestParam(value = "tpassword", required = false) String tpassword) {
        Teacher teacher = new Teacher();
        teacher.setTno(tno);
        teacher.setTpassword(tpassword);
        int res = loginService.verfity(teacher);
        if(res == 1){
            return "redirect:index";
        }
        return "login";
    }
}
