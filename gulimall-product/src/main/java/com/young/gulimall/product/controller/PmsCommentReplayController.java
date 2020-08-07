package com.young.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.product.entity.PmsCommentReplayEntity;
import com.young.gulimall.product.service.PmsCommentReplayService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 商品评价回复关系
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:17
 */
@RestController
@RequestMapping("product/pmscommentreplay")
public class PmsCommentReplayController {
    @Autowired
    private PmsCommentReplayService pmsCommentReplayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsCommentReplayService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		PmsCommentReplayEntity pmsCommentReplay = pmsCommentReplayService.getById(id);

        return ResponseResult.ok().put("pmsCommentReplay", pmsCommentReplay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody PmsCommentReplayEntity pmsCommentReplay){
		pmsCommentReplayService.save(pmsCommentReplay);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody PmsCommentReplayEntity pmsCommentReplay){
		pmsCommentReplayService.updateById(pmsCommentReplay);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		pmsCommentReplayService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
