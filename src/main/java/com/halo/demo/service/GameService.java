package com.halo.demo.service;

import com.halo.demo.mapper.GameMapper;
import com.halo.demo.mapper.PaperMapper;
import com.halo.demo.model.Game;
import com.halo.demo.model.GameExample;
import com.halo.demo.model.Paper;
import com.halo.demo.model.PaperExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:30.
 */

@Service
public class GameService {

    @Autowired
   private GameMapper gameMapper;

    public List<Game> getAllGame() {
        GameExample gameExample = new GameExample();
        List<Game> games = gameMapper.selectByExample(gameExample);
        return games;
    }
}
