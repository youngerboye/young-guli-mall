package com.young.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.young.common.utils.ResponseResult;

import com.young.gulimall.coupon.entity.SeckillSkuNoticeEntity;
import com.young.gulimall.coupon.service.SeckillSkuNoticeService;
import com.young.common.utils.PageUtils;


/**
 * 秒杀商品通知订阅
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 14:03:18
 */
@RestController
@RequestMapping("coupon/seckillskunotice")
public class SeckillSkuNoticeController {
    @Autowired
    private SeckillSkuNoticeService seckillSkuNoticeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSkuNoticeService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		SeckillSkuNoticeEntity seckillSkuNotice = seckillSkuNoticeService.getById(id);

        return ResponseResult.ok().put("seckillSkuNotice", seckillSkuNotice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody SeckillSkuNoticeEntity seckillSkuNotice){
		seckillSkuNoticeService.save(seckillSkuNotice);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody SeckillSkuNoticeEntity seckillSkuNotice){
		seckillSkuNoticeService.updateById(seckillSkuNotice);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		seckillSkuNoticeService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
