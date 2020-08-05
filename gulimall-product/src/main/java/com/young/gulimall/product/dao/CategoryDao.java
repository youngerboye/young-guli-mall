package com.young.gulimall.product.dao;

import com.young.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 15:05:49
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
