package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.PmsSpuImagesEntity;
import com.young.gulimall.product.service.PmsSpuImagesService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * spu图片
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:18
 */
@RestController
@RequestMapping("product/pmsspuimages")
public class PmsSpuImagesController {
    @Autowired
    private PmsSpuImagesService pmsSpuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsSpuImagesService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		PmsSpuImagesEntity pmsSpuImages = pmsSpuImagesService.getById(id);

        return ResponseResult.ok().put("pmsSpuImages", pmsSpuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsSpuImagesEntity pmsSpuImages){
		pmsSpuImagesService.save(pmsSpuImages);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsSpuImagesEntity pmsSpuImages){
		pmsSpuImagesService.updateById(pmsSpuImages);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		pmsSpuImagesService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
