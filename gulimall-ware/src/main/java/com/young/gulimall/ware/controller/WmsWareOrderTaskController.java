package com.young.gulimall.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.ware.entity.WmsWareOrderTaskEntity;
import com.young.gulimall.ware.service.WmsWareOrderTaskService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 库存工作单
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 16:14:50
 */
@RestController
@RequestMapping("ware/wmswareordertask")
public class WmsWareOrderTaskController {
    @Autowired
    private WmsWareOrderTaskService wmsWareOrderTaskService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = wmsWareOrderTaskService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		WmsWareOrderTaskEntity wmsWareOrderTask = wmsWareOrderTaskService.getById(id);

        return ResponseResult.ok().put("wmsWareOrderTask", wmsWareOrderTask);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody WmsWareOrderTaskEntity wmsWareOrderTask){
		wmsWareOrderTaskService.save(wmsWareOrderTask);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody WmsWareOrderTaskEntity wmsWareOrderTask){
		wmsWareOrderTaskService.updateById(wmsWareOrderTask);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		wmsWareOrderTaskService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
