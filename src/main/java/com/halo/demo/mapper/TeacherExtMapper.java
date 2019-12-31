package com.halo.demo.mapper;

import com.halo.demo.model.Teacher;
import com.halo.demo.model.TeacherExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TeacherExtMapper {
    List<Teacher> getTeachersByExample(Teacher teacher);
}