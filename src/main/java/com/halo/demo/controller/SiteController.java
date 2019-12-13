package com.halo.demo.controller;

import com.halo.demo.model.Game;
import com.halo.demo.model.Site;
import com.halo.demo.service.GameService;
import com.halo.demo.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:28.
 */

@Controller
public class SiteController {

    @Autowired
    private SiteService siteService;

    /**
     * 查询所有的参数信息
     */
    @RequestMapping("/ManageSite")
    public String siteInfo(HttpServletRequest request, Model model) {
        List<Site> sites = siteService.getAllSite();
        request.getSession().setAttribute("allSite", sites);
        model.addAttribute("allSite", sites);
        return "site";
    }
    @RequestMapping("/UpdateSite")
    public String updateSite(Map<String, Object> paramMap, HttpServletRequest httpServletRequest) {
        String rankno = httpServletRequest.getParameter("rankno");
        int rankno_int = Integer.parseInt(rankno);
        Site site = siteService.getSiteByTno(rankno_int);
        paramMap.put("updateSite", site);
        return "site_alter";
    }
}