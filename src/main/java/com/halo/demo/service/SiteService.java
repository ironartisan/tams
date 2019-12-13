package com.halo.demo.service;

import com.halo.demo.mapper.GameMapper;
import com.halo.demo.mapper.SiteMapper;
import com.halo.demo.model.Game;
import com.halo.demo.model.GameExample;
import com.halo.demo.model.Site;
import com.halo.demo.model.SiteExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:30.
 */

@Service
public class SiteService {

    @Autowired
   private SiteMapper siteMapper;

    public List<Site> getAllSite() {
        SiteExample siteExample = new SiteExample();
        List<Site> sites = siteMapper.selectByExample(siteExample);
        return sites;
    }

    public Site getSiteByTno(int rankno_int) {
        SiteExample siteExample = new SiteExample();
        Site site = siteMapper.selectByPrimaryKey(rankno_int);
        return site;
    }


}
