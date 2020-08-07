package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.PmsSpuInfoEntity;
import com.young.gulimall.product.service.PmsSpuInfoService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * spu信息
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:17
 */
@RestController
@RequestMapping("product/pmsspuinfo")
public class PmsSpuInfoController {
    @Autowired
    private PmsSpuInfoService pmsSpuInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsSpuInfoService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		PmsSpuInfoEntity pmsSpuInfo = pmsSpuInfoService.getById(id);

        return ResponseResult.ok().put("pmsSpuInfo", pmsSpuInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsSpuInfoEntity pmsSpuInfo){
		pmsSpuInfoService.save(pmsSpuInfo);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsSpuInfoEntity pmsSpuInfo){
		pmsSpuInfoService.updateById(pmsSpuInfo);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		pmsSpuInfoService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
