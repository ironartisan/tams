package com.halo.demo.controller;

import com.halo.demo.dto.TeacherDTO;
import com.halo.demo.model.Project;
import com.halo.demo.model.Teacher;
import com.halo.demo.service.ProjectService;
import com.halo.demo.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 查询所有的项目信息
     */
    @RequestMapping("/ManageProject")
    public String teacherInfo(HttpServletRequest request, Model model) {
        List<Project> projects = projectService.getAllProject();
        request.getSession().setAttribute("allProject", projects);
        model.addAttribute("allProject", projects);
        return "project_info";
    }
}