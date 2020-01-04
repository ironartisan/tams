package com.halo.demo.dto;

import lombok.Data;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 22:43.
 */
@Data
public class ProjectDTO {

    // 项目编号
    private Integer pno;
    // 项目名称
    private String pname;
    //负责人
    private Integer manager;
    //等级编号
    private Integer rankno;
    //等级
    private String rank;
    public ProjectDTO() {}

    public ProjectDTO(Integer pno,
                      String pname,
                      Integer manager,
                      Integer rankno,
                      String rank) {
        this.pno = pno;
        this.pname = pname;
        this.manager = manager;
        this.rankno = rankno;
        this.rank = rank;
    }
}
