package com.young.gulimall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.young.gulimall.product.entity.BrandEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌
 * 
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-04 15:00:06
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {
	
}
