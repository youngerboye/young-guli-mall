package com.young.gulimall.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.ware.entity.WmsWareOrderTaskDetailEntity;
import com.young.gulimall.ware.service.WmsWareOrderTaskDetailService;
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
@RequestMapping("ware/wmswareordertaskdetail")
public class WmsWareOrderTaskDetailController {
    @Autowired
    private WmsWareOrderTaskDetailService wmsWareOrderTaskDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = wmsWareOrderTaskDetailService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail = wmsWareOrderTaskDetailService.getById(id);

        return ResponseResult.ok().put("wmsWareOrderTaskDetail", wmsWareOrderTaskDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail){
		wmsWareOrderTaskDetailService.save(wmsWareOrderTaskDetail);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody WmsWareOrderTaskDetailEntity wmsWareOrderTaskDetail){
		wmsWareOrderTaskDetailService.updateById(wmsWareOrderTaskDetail);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		wmsWareOrderTaskDetailService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
