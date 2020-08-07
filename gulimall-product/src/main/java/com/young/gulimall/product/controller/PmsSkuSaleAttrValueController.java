package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.PmsSkuSaleAttrValueEntity;
import com.young.gulimall.product.service.PmsSkuSaleAttrValueService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * sku销售属性&值
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:18
 */
@RestController
@RequestMapping("product/pmsskusaleattrvalue")
public class PmsSkuSaleAttrValueController {
    @Autowired
    private PmsSkuSaleAttrValueService pmsSkuSaleAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsSkuSaleAttrValueService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		PmsSkuSaleAttrValueEntity pmsSkuSaleAttrValue = pmsSkuSaleAttrValueService.getById(id);

        return ResponseResult.ok().put("pmsSkuSaleAttrValue", pmsSkuSaleAttrValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsSkuSaleAttrValueEntity pmsSkuSaleAttrValue){
		pmsSkuSaleAttrValueService.save(pmsSkuSaleAttrValue);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsSkuSaleAttrValueEntity pmsSkuSaleAttrValue){
		pmsSkuSaleAttrValueService.updateById(pmsSkuSaleAttrValue);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		pmsSkuSaleAttrValueService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
