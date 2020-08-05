package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.AttrEntity;
import com.young.gulimall.product.service.AttrService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 商品属性
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 15:05:49
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public ResponseResult info(@PathVariable("attrId") Long attrId){
		AttrEntity attr = attrService.getById(attrId);

        return ResponseResult.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody AttrEntity attr){
		attrService.save(attr);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody AttrEntity attr){
		attrService.updateById(attr);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return ResponseResult.ok();
    }

}
