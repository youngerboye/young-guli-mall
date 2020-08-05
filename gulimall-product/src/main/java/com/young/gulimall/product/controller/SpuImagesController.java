package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.young.gulimall.product.entity.SpuImagesEntity;
import com.young.gulimall.product.service.SpuImagesService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * spu图片
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 15:05:50
 */
@RestController
@RequestMapping("product/spuimages")
public class SpuImagesController {
    @Autowired
    private SpuImagesService spuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = spuImagesService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		SpuImagesEntity spuImages = spuImagesService.getById(id);

        return ResponseResult.ok().put("spuImages", spuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody SpuImagesEntity spuImages){
		spuImagesService.save(spuImages);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody SpuImagesEntity spuImages){
		spuImagesService.updateById(spuImages);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		spuImagesService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
