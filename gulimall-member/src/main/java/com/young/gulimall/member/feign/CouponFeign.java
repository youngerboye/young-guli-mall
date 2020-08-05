package com.young.gulimall.member.feign;

import com.young.common.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: young
 * @Date: 2020/08/05
 * @Description:
 */
@FeignClient("gulimall-coupon")
@Component
public interface CouponFeign {

    @RequestMapping("/coupon/coupon/test")
    ResponseResult test();
}
