package com.tensquare.base.contorller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LableService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
