package com.halo.demo.service;

import com.halo.demo.mapper.ProjectMapper;
import com.halo.demo.model.Project;
import com.halo.demo.model.ProjectExample;
import com.halo.demo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:30.
 */

@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    public  void addProject(Project project) {
        if(project.getPno() != null) {
            ProjectExample projectExample = new ProjectExample();
            projectExample.createCriteria().andPnoEqualTo(project.getPno());
            List<Project> projects = projectMapper.selectByExample(projectExample);

            // 获取username相同的student,没有则插入用户信息
            if (projects.size() == 0) {
                projectMapper.insert(project);
            }
            //更新用户信息
            else{
                projectMapper.updateByExampleSelective(project, projectExample);

            }
        }
    }


    public List<Project> getAllProject() {
        ProjectExample projectExample = new ProjectExample();
        List<Project> projects = projectMapper.selectByExample(projectExample);
        return projects;
    }

    public Project getProjectByPno(int pno_int) {
            Project project = projectMapper.selectByPrimaryKey(pno_int);
            return  project;
        }
    }

