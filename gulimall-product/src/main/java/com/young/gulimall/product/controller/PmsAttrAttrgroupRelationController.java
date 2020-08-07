package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.PmsAttrAttrgroupRelationEntity;
import com.young.gulimall.product.service.PmsAttrAttrgroupRelationService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 属性&属性分组关联
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:17
 */
@RestController
@RequestMapping("product/pmsattrattrgrouprelation")
public class PmsAttrAttrgroupRelationController {
    @Autowired
    private PmsAttrAttrgroupRelationService pmsAttrAttrgroupRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsAttrAttrgroupRelationService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		PmsAttrAttrgroupRelationEntity pmsAttrAttrgroupRelation = pmsAttrAttrgroupRelationService.getById(id);

        return ResponseResult.ok().put("pmsAttrAttrgroupRelation", pmsAttrAttrgroupRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsAttrAttrgroupRelationEntity pmsAttrAttrgroupRelation){
		pmsAttrAttrgroupRelationService.save(pmsAttrAttrgroupRelation);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsAttrAttrgroupRelationEntity pmsAttrAttrgroupRelation){
		pmsAttrAttrgroupRelationService.updateById(pmsAttrAttrgroupRelation);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		pmsAttrAttrgroupRelationService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
