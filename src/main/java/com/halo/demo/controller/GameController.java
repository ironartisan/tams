package com.halo.demo.controller;

import com.halo.demo.model.Game;
import com.halo.demo.model.Paper;
import com.halo.demo.service.GameService;
import com.halo.demo.service.PaperService;
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
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * 查询所有的比赛信息
     */
    @RequestMapping("/ManageGame")
    public String gameInfo(HttpServletRequest request, Model model) {
        List<Game> games = gameService.getAllGame();
        request.getSession().setAttribute("allGame", games);
        model.addAttribute("allGame", games);
        return "game_info";
    }
}