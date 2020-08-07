package com.young.gulimall.product.dao;

import com.young.gulimall.product.entity.PmsCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:17
 */
@Mapper
public interface PmsCategoryDao extends BaseMapper<PmsCategoryEntity> {
	
}
