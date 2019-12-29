package com.halo.demo.dto;

import lombok.Data;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 22:43.
 */
@Data
public class WorkloadDTO {

    // 工号
    private Integer tno;
    // 姓名
    private String tname;
    // 工作量
    private Integer workload;
    public WorkloadDTO() {}

    public WorkloadDTO(Integer tno,
                       String tname,
                       Integer workload) {
        this.tno = tno;
        this.tname = tname;
        this.workload = workload;
    }
}
