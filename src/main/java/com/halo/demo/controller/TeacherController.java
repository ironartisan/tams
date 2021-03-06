package com.halo.demo.controller;

import com.halo.demo.dto.TeacherDTO;
import com.halo.demo.model.Teacher;
import com.halo.demo.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:28.
 */

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    /**
     * 查询所有的教师信息
     */
    @RequestMapping("/TeachersInfo")
    public String teacherInfo(HttpServletRequest request, Model model) {
        List<Teacher> teachers = teacherService.getAllTeacher();
        request.getSession().setAttribute("allTeacher", teachers);
        model.addAttribute("allTeacher", teachers);
        return "teachers_info";
    }

    @RequestMapping("/TeachersAddAction")
    public String teachersAdd(HttpServletRequest httpServletRequest) {
        httpServletRequest.setAttribute("UpdateTeacher", null);
        return "teachers_add";
    }

    @RequestMapping("/DoTeachersAdd")
    public String doTeachersAdd(@RequestParam("tno") Integer tno,
                                @RequestParam("tname") String tname,
                                @RequestParam("tpassword") String tpassword,
                                @RequestParam("age") Integer age,
                                @RequestParam("email") String email,
                                @RequestParam("rank") String rank,HttpServletRequest request) {
        TeacherDTO teacherDTO = new TeacherDTO(tno, tname, tpassword, age, email, rank);
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDTO, teacher);
        if(teacher.getTno()!= null) {
            teacherService.addTeacher(teacher);
        }
        return "redirect:/TeachersInfo";
    }

    @RequestMapping("/UpdateTeacher")
    public String updateTeacher(Map<String, Object> paramMap, HttpServletRequest httpServletRequest) {
        String tno = httpServletRequest.getParameter("tno");
        int tno_int = Integer.parseInt(tno);
        Teacher teacher = teacherService.getTeacherByTno(tno_int);
        paramMap.put("updateTeacher", teacher);
        return "teachers_alter";
    }

    @PostMapping("/SearchTeachers")
    public String SearchTeachers(HttpServletRequest httpServletRequest) {

        Teacher teacher = new Teacher();
        Integer tno = (httpServletRequest.getParameter("tno").equals("")) ? null : Integer.parseInt(httpServletRequest.getParameter("tno"));
        String tname = (httpServletRequest.getParameter("tname").equals("")) ? null : httpServletRequest.getParameter("tname");
        String email = (httpServletRequest.getParameter("email").equals("")) ? null : httpServletRequest.getParameter("email");
        String rank = (httpServletRequest.getParameter("rank").equals("")) ? null : httpServletRequest.getParameter("rank");
        teacher.setTno(tno);
        teacher.setTname(tname);
        teacher.setRank(email);
        teacher.setRank(rank);
        List<Teacher> teachersByExample = teacherService.getTeacherByExample(teacher);
        System.out.println(teachersByExample);
        httpServletRequest.getSession().setAttribute("allTeacher", teachersByExample);
        return "forward:/TeachersPage";
    }

    @RequestMapping("/TeachersPage")
    public String teachersPage(HttpServletRequest httpServletRequest) {
        Object allTeacher = httpServletRequest.getSession().getAttribute("allTeacher");
        System.out.println(allTeacher);
        httpServletRequest.setAttribute("allTeacher", allTeacher);
        return "teachers_info";
    }
    @RequestMapping("/DeleteTeacher")
    public String DeleteTeacher(HttpServletRequest httpServletRequest) {
        String tno = httpServletRequest.getParameter("tno");
        int tno_int = Integer.parseInt(tno);
        teacherService.delTeacherByTno(tno_int);
        return "redirect:/TeachersInfo";
    }
}