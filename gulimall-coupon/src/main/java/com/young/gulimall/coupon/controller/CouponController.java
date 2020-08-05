package com.young.gulimall.coupon.controller;

import java.math.BigDecimal;
import java.util.Date;

import java.util.Arrays;
import java.util.Map;

import com.young.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.young.common.utils.ResponseResult;

import com.young.gulimall.coupon.entity.CouponEntity;
import com.young.gulimall.coupon.service.CouponService;


/**
 * 优惠券信息
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 14:03:19
 */
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @RequestMapping("/test")
    public ResponseResult test() {
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("test");
        couponService.save(couponEntity);
        return ResponseResult.ok().put("county", "test");
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params) {
        PageUtils page = couponService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id) {
        CouponEntity coupon = couponService.getById(id);

        return ResponseResult.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody CouponEntity coupon) {
        couponService.save(coupon);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody CouponEntity coupon) {
        couponService.updateById(coupon);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids) {
        couponService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
