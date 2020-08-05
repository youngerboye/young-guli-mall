package com.young.gulimall.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.ware.entity.WmsWareInfoEntity;
import com.young.gulimall.ware.service.WmsWareInfoService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 仓库信息
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 16:14:50
 */
@RestController
@RequestMapping("ware/wmswareinfo")
public class WmsWareInfoController {
    @Autowired
    private WmsWareInfoService wmsWareInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = wmsWareInfoService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		WmsWareInfoEntity wmsWareInfo = wmsWareInfoService.getById(id);

        return ResponseResult.ok().put("wmsWareInfo", wmsWareInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody WmsWareInfoEntity wmsWareInfo){
		wmsWareInfoService.save(wmsWareInfo);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody WmsWareInfoEntity wmsWareInfo){
		wmsWareInfoService.updateById(wmsWareInfo);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		wmsWareInfoService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
