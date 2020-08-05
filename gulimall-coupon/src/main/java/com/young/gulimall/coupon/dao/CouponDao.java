package com.young.gulimall.coupon.dao;

import com.young.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 14:03:19
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
