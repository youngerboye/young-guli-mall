package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.young.gulimall.product.entity.PmsCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.young.gulimall.product.entity.PmsAttrEntity;
import com.young.gulimall.product.service.PmsAttrService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 商品属性
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:17
 */
@RestController
@RequestMapping("product/pmsattr")
public class PmsAttrController {
    @Autowired
    private PmsAttrService pmsAttrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsAttrService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public ResponseResult info(@PathVariable("attrId") Long attrId){
		PmsAttrEntity pmsAttr = pmsAttrService.getById(attrId);

        return ResponseResult.ok().put("pmsAttr", pmsAttr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsAttrEntity pmsAttr){
		pmsAttrService.save(pmsAttr);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsAttrEntity pmsAttr){
		pmsAttrService.updateById(pmsAttr);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] attrIds){
		pmsAttrService.removeByIds(Arrays.asList(attrIds));

        return ResponseResult.ok();
    }

}
