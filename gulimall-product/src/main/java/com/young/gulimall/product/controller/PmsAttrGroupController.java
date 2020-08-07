package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.PmsAttrGroupEntity;
import com.young.gulimall.product.service.PmsAttrGroupService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 属性分组
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:18
 */
@RestController
@RequestMapping("product/pmsattrgroup")
public class PmsAttrGroupController {
    @Autowired
    private PmsAttrGroupService pmsAttrGroupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsAttrGroupService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public ResponseResult info(@PathVariable("attrGroupId") Long attrGroupId){
		PmsAttrGroupEntity pmsAttrGroup = pmsAttrGroupService.getById(attrGroupId);

        return ResponseResult.ok().put("pmsAttrGroup", pmsAttrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsAttrGroupEntity pmsAttrGroup){
		pmsAttrGroupService.save(pmsAttrGroup);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsAttrGroupEntity pmsAttrGroup){
		pmsAttrGroupService.updateById(pmsAttrGroup);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] attrGroupIds){
		pmsAttrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return ResponseResult.ok();
    }

}
