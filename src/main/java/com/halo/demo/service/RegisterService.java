package com.halo.demo.service;

import com.halo.demo.mapper.TeacherMapper;
import com.halo.demo.model.Teacher;
import com.halo.demo.model.TeacherExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/10/26 22:37.
 */
@Service
public class RegisterService {

    @Autowired
    private TeacherMapper teacherMapper;
    /**
     * 插入用户，分为创建用户和更新用户两种情况
     */
    public int insert(Teacher teacher) {
        if(teacher.getTno() != null) {
            TeacherExample teacherExample = new TeacherExample();
            teacherExample.createCriteria().andTnoEqualTo(teacher.getTno());
            List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
            // 获取username相同的student
            if (teachers.size() == 0) {
                teacherMapper.insert(teacher);
                return 0;
            }else {
                //提示用户已存在
                System.out.println("用户已存在");
                return 1;
            }
        }
        return 0;
        }
    }
