package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.PmsSpuInfoDescEntity;
import com.young.gulimall.product.service.PmsSpuInfoDescService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * spu信息介绍
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:17
 */
@RestController
@RequestMapping("product/pmsspuinfodesc")
public class PmsSpuInfoDescController {
    @Autowired
    private PmsSpuInfoDescService pmsSpuInfoDescService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsSpuInfoDescService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{spuId}")
    public ResponseResult info(@PathVariable("spuId") Long spuId){
		PmsSpuInfoDescEntity pmsSpuInfoDesc = pmsSpuInfoDescService.getById(spuId);

        return ResponseResult.ok().put("pmsSpuInfoDesc", pmsSpuInfoDesc);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsSpuInfoDescEntity pmsSpuInfoDesc){
		pmsSpuInfoDescService.save(pmsSpuInfoDesc);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsSpuInfoDescEntity pmsSpuInfoDesc){
		pmsSpuInfoDescService.updateById(pmsSpuInfoDesc);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] spuIds){
		pmsSpuInfoDescService.removeByIds(Arrays.asList(spuIds));

        return ResponseResult.ok();
    }

}
