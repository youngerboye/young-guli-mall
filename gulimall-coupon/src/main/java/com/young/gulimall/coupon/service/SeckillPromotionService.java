package com.young.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.young.common.utils.PageUtils;
import com.young.gulimall.coupon.entity.SeckillPromotionEntity;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 14:03:18
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

