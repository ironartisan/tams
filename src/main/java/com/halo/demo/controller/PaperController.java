package com.halo.demo.controller;

import com.halo.demo.model.Paper;
import com.halo.demo.model.Project;
import com.halo.demo.service.PaperService;
import com.halo.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:28.
 */

@Controller
public class PaperController {

    @Autowired
    private PaperService paperService;

    /**
     * 查询所有的项目信息
     */
    @RequestMapping("/ManagePaper")
    public String teacherInfo(HttpServletRequest request, Model model) {
        List<Paper> papaers = paperService.getAllPaper();
        request.getSession().setAttribute("allPaper", papaers);
        model.addAttribute("allPaper", papaers);
        return "paper_info";
    }
}