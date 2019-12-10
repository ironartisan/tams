package com.halo.demo.dto;

import lombok.Data;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 22:43.
 */
@Data
public class TeacherDTO {

    // 工号
    private Integer tno;
    // 姓名
    private String tname;
    //密码
    private String tpassword;
    //年龄
    private Integer age;
    //邮箱
    private String email;
    //职称
    private String rank;
    public TeacherDTO() {}

    public TeacherDTO(Integer tno,
                      String tname,
                      String tpassword,
                      Integer age,
                      String email,
                      String rank) {
        this.tno = tno;
        this.tname = tname;
        this.tpassword = tpassword;
        this.age = age;
        this.email = email;
        this.rank = rank;
    }
}
