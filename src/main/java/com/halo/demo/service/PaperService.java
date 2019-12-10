package com.halo.demo.service;

import com.halo.demo.mapper.PaperMapper;
import com.halo.demo.mapper.ProjectMapper;
import com.halo.demo.model.Paper;
import com.halo.demo.model.PaperExample;
import com.halo.demo.model.Project;
import com.halo.demo.model.ProjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:30.
 */

@Service
public class PaperService {

    @Autowired
    PaperMapper paperMapper;

    public List<Paper> getAllPaper() {
        PaperExample paperExample = new PaperExample();
        List<Paper> papers = paperMapper.selectByExample(paperExample);
        return papers;
    }
}
