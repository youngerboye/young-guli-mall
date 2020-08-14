package com.young.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.young.common.utils.PageUtils;
import com.young.gulimall.product.entity.PmsCategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-06 17:52:17
 */
public interface PmsCategoryService extends IService<PmsCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<PmsCategoryEntity> listTree();

    void removeByTreeIds(List<Long> asList);
}

