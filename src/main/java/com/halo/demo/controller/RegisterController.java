package com.halo.demo.controller;

import com.halo.demo.model.Teacher;
import com.halo.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/10/25 14:53.
 */

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public String index(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam(value = "tno", required = false) Integer tno,
                           @RequestParam(value = "tname", required = false) String tname,
                           @RequestParam(value = "age", required = false) Integer age,
                           @RequestParam(value = "email", required = false) String email,
                           @RequestParam(value = "tpassword", required = false) String tpassword,
                           Model model) {

        Teacher teacher = new Teacher();
        teacher.setTno(tno);
        teacher.setTname(tname);
        teacher.setAge(age);
        teacher.setEmail(email);
        teacher.setTpassword(tpassword);
        int res = registerService.insert(teacher);
        if(res == 1){
            model.addAttribute("error", "用户已注册");
        }else {
            return "redirect:login";
        }
        return "register";
    }
}
