package com.halo.demo.service;

import com.halo.demo.dto.WorkloadDTO;
import com.halo.demo.mapper.*;
import com.halo.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:30.
 */

@Service
public class WorkLoadService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private SiteMapper siteMapper;

    public List<WorkloadDTO> getAllInfo() {
        TeacherExample teacherExample = new TeacherExample();
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        List<WorkloadDTO> workloadDTOList = new ArrayList<WorkloadDTO>();;
        for(Teacher teacher: teachers){
            Integer projectScore = 0;
            Integer paperScore = 0;
            Integer bookScore = 0;
            Integer gameScore = 0;

            Integer tno = teacher.getTno();
            String  tname = teacher.getTname();
            // 获取教改项目等级编号
            ProjectExample projectExample = new ProjectExample();
            projectExample.createCriteria().andManagerEqualTo(tno);
            List<Project> projects = projectMapper.selectByExample(projectExample);
            if (projects.size() != 0){
                for(Project project: projects){
                    Integer projectRankno = project.getRankno();
                    // 获取教改项目分数
                    SiteExample projectSiteExample = new SiteExample();
                    projectSiteExample.createCriteria().andRanknoEqualTo(projectRankno);
                    List<Site> projectSites = siteMapper.selectByExample(projectSiteExample);
                    projectScore += projectSites.get(0).getProportion()==null? 0 : projectSites.get(0).getProportion();

                }
            }

            // 获取专著等级编号
            PaperExample paperExample = new PaperExample();
            paperExample.createCriteria().andAuthorEqualTo(tno);
            List<Paper> papers = paperMapper.selectByExample(paperExample);
            if(papers.size() != 0){
                for(Paper paper: papers){
                    Integer paperRankno = paper.getRankno();
                    //获取教改论文分数
                    SiteExample paperSiteExample = new SiteExample();
                    paperSiteExample.createCriteria().andRanknoEqualTo(paperRankno);
                    List<Site>  paperSites = siteMapper.selectByExample(paperSiteExample);
                    paperScore += paperSites.get(0).getProportion()==null? 0 : paperSites.get(0).getProportion();
                }
            }

            // 获取出版专著编号
            BookExample bookExample= new BookExample();
            bookExample.createCriteria().andAuthorEqualTo(tno);
            List<Book> books = bookMapper.selectByExample(bookExample);
            if(books.size()!=0){
                for(Book book: books){
                    Integer bookRankno = book.getRankno();
                    //获取出版专著分数
                    SiteExample bookSiteExample = new SiteExample();
                    bookSiteExample.createCriteria().andRanknoEqualTo(bookRankno);
                    List<Site>  bookSites = siteMapper.selectByExample(bookSiteExample);
                    bookScore += bookSites.get(0).getProportion()==null? 0 : bookSites.get(0).getProportion();
                }
            }

            // 获取比赛等级编号
            GameExample gameExample= new GameExample();
            gameExample.createCriteria().andWinnerEqualTo(tno);
            List<Game> games = gameMapper.selectByExample(gameExample);
            if(games.size()!=0){
                for(Game game: games){
                    Integer gameRankno = game.getRankno();
                    //获取出版专著分数
                    SiteExample gameSiteExample = new SiteExample();
                    gameSiteExample.createCriteria().andRanknoEqualTo(gameRankno);
                    List<Site> gameSites = siteMapper.selectByExample(gameSiteExample);
                    gameScore += gameSites.get(0).getProportion() == null ? 0 : gameSites.get(0).getProportion();
                }

            }

            Integer score = projectScore + paperScore + bookScore + gameScore;
            WorkloadDTO workloadDTO = new WorkloadDTO();
            workloadDTO.setTno(tno);
            workloadDTO.setTname(tname);
            workloadDTO.setWorkload(score);
            workloadDTOList.add(workloadDTO);
        }
        return workloadDTOList;
    }


    }

