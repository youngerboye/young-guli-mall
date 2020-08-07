package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.PmsSkuInfoEntity;
import com.young.gulimall.product.service.PmsSkuInfoService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * sku信息
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:17
 */
@RestController
@RequestMapping("product/pmsskuinfo")
public class PmsSkuInfoController {
    @Autowired
    private PmsSkuInfoService pmsSkuInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsSkuInfoService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{skuId}")
    public ResponseResult info(@PathVariable("skuId") Long skuId){
		PmsSkuInfoEntity pmsSkuInfo = pmsSkuInfoService.getById(skuId);

        return ResponseResult.ok().put("pmsSkuInfo", pmsSkuInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsSkuInfoEntity pmsSkuInfo){
		pmsSkuInfoService.save(pmsSkuInfo);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsSkuInfoEntity pmsSkuInfo){
		pmsSkuInfoService.updateById(pmsSkuInfo);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] skuIds){
		pmsSkuInfoService.removeByIds(Arrays.asList(skuIds));

        return ResponseResult.ok();
    }

}
