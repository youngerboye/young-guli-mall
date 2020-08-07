package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.PmsSpuCommentEntity;
import com.young.gulimall.product.service.PmsSpuCommentService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 商品评价
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:18
 */
@RestController
@RequestMapping("product/pmsspucomment")
public class PmsSpuCommentController {
    @Autowired
    private PmsSpuCommentService pmsSpuCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsSpuCommentService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		PmsSpuCommentEntity pmsSpuComment = pmsSpuCommentService.getById(id);

        return ResponseResult.ok().put("pmsSpuComment", pmsSpuComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsSpuCommentEntity pmsSpuComment){
		pmsSpuCommentService.save(pmsSpuComment);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsSpuCommentEntity pmsSpuComment){
		pmsSpuCommentService.updateById(pmsSpuComment);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		pmsSpuCommentService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
