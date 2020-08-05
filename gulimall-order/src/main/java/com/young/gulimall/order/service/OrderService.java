package com.young.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.young.common.utils.PageUtils;
import com.young.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 15:40:14
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

