package com.tensquare.base.contorller;

import com.alibaba.excel.EasyExcel;
import com.google.common.collect.Lists;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LableService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lyj on 2019/1/19.
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LableService lableService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",lableService.findAll());
    }

    /**
     * 根据id查询
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId){
        return new Result(true,StatusCode.OK,"查询成功",lableService.findById(labelId));
    }

    /**
     * 添加
     * @param label
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        lableService.save(label);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /**
     * 根据id删除
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/{label}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("labelId") String labelId){
        lableService.deleteById(labelId);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 修改
     * @param label
     * @return
     */
    @RequestMapping(value = "/{label}",method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String labelId, @RequestBody Label label){
        label.setId(labelId);
        lableService.update(label);
        return new Result(true,StatusCode.OK,"更新成功");
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/excel")
    @ApiOperation(value = "导出", notes = "导出")
    public void excel(HttpServletResponse response) throws IOException {
        String fileName = "黑名单导入模板_" + sdf.format(new Date()) + ".xls";
        response.setHeader("Content-disposition",
                "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));// 设置文件头编码格式
        response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");// 设置类型
//        response.setHeader("Cache-Control", "no-cache");// 设置头
//        response.setDateHeader("Expires", 0);// 设置日期头
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        List<Label> labelList = lableService.findAll();
        EasyExcel.write(response.getOutputStream(), Label.class).sheet("模板").doWrite(labelList);
    }
}
