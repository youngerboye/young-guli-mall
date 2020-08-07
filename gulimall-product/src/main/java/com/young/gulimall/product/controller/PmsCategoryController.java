package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.young.gulimall.product.entity.PmsCategoryEntity;
import com.young.gulimall.product.service.PmsCategoryService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;


/**
 * 商品三级分类
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:17
 */
@RestController
@RequestMapping("product/pmscategory")
public class PmsCategoryController {
    @Autowired
    private PmsCategoryService pmsCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params) {
        PageUtils page = pmsCategoryService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }

    @GetMapping("/list/tree")
    public ResponseResult listTree() {

        List<PmsCategoryEntity> entitiesTree = pmsCategoryService.listTree();
        return ResponseResult.ok().put("tree", entitiesTree);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public ResponseResult info(@PathVariable("catId") Long catId) {
        PmsCategoryEntity pmsCategory = pmsCategoryService.getById(catId);

        return ResponseResult.ok().put("pmsCategory", pmsCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsCategoryEntity pmsCategory) {
        pmsCategoryService.save(pmsCategory);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsCategoryEntity pmsCategory) {
        pmsCategoryService.updateById(pmsCategory);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] catIds) {
        pmsCategoryService.removeByIds(Arrays.asList(catIds));

        return ResponseResult.ok();
    }

}
