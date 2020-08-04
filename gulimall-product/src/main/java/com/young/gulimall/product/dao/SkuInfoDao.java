package com.young.gulimall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.young.gulimall.product.entity.SkuInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku信息
 * 
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-04 15:00:06
 */
@Mapper
public interface SkuInfoDao extends BaseMapper<SkuInfoEntity> {
	
}
