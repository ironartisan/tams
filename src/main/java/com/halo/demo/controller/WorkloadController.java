package com.halo.demo.controller;

import com.halo.demo.dto.ProjectDTO;
import com.halo.demo.dto.WorkloadDTO;
import com.halo.demo.model.Project;
import com.halo.demo.service.ProjectService;
import com.halo.demo.service.WorkLoadService;
import jxl.Workbook;
import jxl.write.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author halo.
 * @email ironerhalo@gmail.com.
 * @data 2019/12/1 19:28.
 */

@Controller
public class WorkLoadController {

    @Autowired
    private WorkLoadService workLoadService;

    /**
     * 查询所有的工作量
     */
    @RequestMapping("/ManageInfo")
    public String teacherInfo(HttpServletRequest request, Model model) {
        List<WorkloadDTO> workloads = workLoadService.getAllInfo();
        request.getSession().setAttribute("allWorkLoads", workloads);
        model.addAttribute("allWorkLoads", workloads);
        return "workload_info";
    }

    /**
     * 导出Excel
     */
    @RequestMapping("/ExportExcel")
    @ResponseBody
    public void exportExcel(HttpServletResponse response) throws Exception {
        // 1.文件下载响应头
        response.setHeader("Content-Disposition", "attachment;filename=workload.xls");
        // 2.响应到浏览器
        WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());
        // 创建工作簿sheet
        WritableSheet sheet = workbook.createSheet("工作量统计", 0);
        // 3.设置column名
        sheet.addCell(new Label(0, 0, "教师编号"));
        sheet.addCell(new Label(1, 0, "教师姓名"));
        sheet.addCell(new Label(2, 0, "工作量"));

        // 4.把核保的数据填充到工作簿中 getAllInfo()查询数据库
        List<WorkloadDTO> workloads = workLoadService.getAllInfo();
//        List<UnderwriteWait> list = service.selectExport();
//        System.out.println(list.toArray());
        try{
            for (int i = 0, j = 1; i < workloads.size(); i++, j++) {
                WorkloadDTO workloadDTO = workloads.get(i);
                //System.out.println(underwrite);
                //设置列宽
                sheet.setColumnView(i, 16);
                //设置行高
                sheet.setRowView(i, 350);
                //设置字体的attribute
                WritableFont font1=new WritableFont(WritableFont.createFont("楷体 _GB2312"), 12, WritableFont.NO_BOLD);
                WritableCellFormat format1=new WritableCellFormat(font1);
                sheet.addCell(new Label(0, j, workloadDTO.getTno().toString(),format1));
                sheet.addCell(new Label(1, j, workloadDTO.getTname(),format1));
                sheet.addCell(new Label(2, j, workloadDTO.getWorkload().toString(),format1));

            }}catch (Exception e){
            e.printStackTrace();
        }
        // 5.写入数据
        workbook.write();
        // 6.关闭资源
        workbook.close();
    }


}