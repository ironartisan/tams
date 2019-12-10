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
public class LoginService {

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 插入用户，分为创建用户和更新用户两种情况
     */

    public int verfity(Teacher teacher) {
        if (teacher.getTno() != null) {
            TeacherExample teacherExample = new TeacherExample();
            teacherExample.createCriteria().andTnoEqualTo(teacher.getTno());
            List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
            if (teacherList.size() != 0) {
                if (teacherList.get(0).getTpassword().equals(teacher.getTpassword())) {
                    // 用户存在且密码正确，登录成功
                    System.out.println("登录成功");
                    return 1;
                }
            }
        }
        return 0;
    }


}
