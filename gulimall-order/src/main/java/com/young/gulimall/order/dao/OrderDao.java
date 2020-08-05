package com.young.gulimall.order.dao;

import com.young.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 15:40:14
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
