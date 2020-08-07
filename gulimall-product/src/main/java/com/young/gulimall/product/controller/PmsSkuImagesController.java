package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.PmsSkuImagesEntity;
import com.young.gulimall.product.service.PmsSkuImagesService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * sku图片
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:17
 */
@RestController
@RequestMapping("product/pmsskuimages")
public class PmsSkuImagesController {
    @Autowired
    private PmsSkuImagesService pmsSkuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsSkuImagesService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		PmsSkuImagesEntity pmsSkuImages = pmsSkuImagesService.getById(id);

        return ResponseResult.ok().put("pmsSkuImages", pmsSkuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsSkuImagesEntity pmsSkuImages){
		pmsSkuImagesService.save(pmsSkuImages);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsSkuImagesEntity pmsSkuImages){
		pmsSkuImagesService.updateById(pmsSkuImages);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		pmsSkuImagesService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
