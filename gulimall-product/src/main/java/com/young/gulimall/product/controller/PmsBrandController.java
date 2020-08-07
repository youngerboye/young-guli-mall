package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.PmsBrandEntity;
import com.young.gulimall.product.service.PmsBrandService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 品牌
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:18
 */
@RestController
@RequestMapping("product/pmsbrand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsBrandService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public ResponseResult info(@PathVariable("brandId") Long brandId){
		PmsBrandEntity pmsBrand = pmsBrandService.getById(brandId);

        return ResponseResult.ok().put("pmsBrand", pmsBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsBrandEntity pmsBrand){
		pmsBrandService.save(pmsBrand);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsBrandEntity pmsBrand){
		pmsBrandService.updateById(pmsBrand);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] brandIds){
		pmsBrandService.removeByIds(Arrays.asList(brandIds));

        return ResponseResult.ok();
    }

}
