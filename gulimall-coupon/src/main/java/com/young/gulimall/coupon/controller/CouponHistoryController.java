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

import com.young.gulimall.coupon.entity.CouponHistoryEntity;
import com.young.gulimall.coupon.service.CouponHistoryService;
import com.young.common.utils.PageUtils;


/**
 * 优惠券领取历史记录
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 14:03:19
 */
@RestController
@RequestMapping("coupon/couponhistory")
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService couponHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = couponHistoryService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		CouponHistoryEntity couponHistory = couponHistoryService.getById(id);

        return ResponseResult.ok().put("couponHistory", couponHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody CouponHistoryEntity couponHistory){
		couponHistoryService.save(couponHistory);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody CouponHistoryEntity couponHistory){
		couponHistoryService.updateById(couponHistory);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		couponHistoryService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
