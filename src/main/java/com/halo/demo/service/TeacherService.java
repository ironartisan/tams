package com.halo.demo.service;

import com.halo.demo.mapper.TeacherExtMapper;
import com.halo.demo.mapper.TeacherMapper;
import com.halo.demo.model.Teacher;
import com.halo.demo.model.TeacherExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:30.
 */

@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private TeacherExtMapper teacherExtMapper;

    public List<Teacher> getAllTeacher() {
        TeacherExample teacherExample = new TeacherExample();
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        return teachers;
    }

    public Teacher getTeacherByTno(Integer tno) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(tno);
        return  teacher;
    }

    public void addTeacher(Teacher teacher) {
        if(teacher.getTno() != null) {
            TeacherExample teacherExample = new TeacherExample();
            teacherExample.createCriteria().andTnoEqualTo(teacher.getTno());
            List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
            // 获取username相同的student,没有则插入用户信息
            if (teachers.size() == 0) {
                teacherMapper.insert(teacher);
            }
            //更新用户信息
            else{
                teacherMapper.updateByExampleSelective(teacher, teacherExample);

            }
        }
    }

    public void delTeacherByTno(int tno_int) {
        teacherMapper.deleteByPrimaryKey(tno_int);
    }

    public List<Teacher> getTeacherByExample(Teacher teacher) {

        return teacherExtMapper.getTeachersByExample(teacher);
    }
}
