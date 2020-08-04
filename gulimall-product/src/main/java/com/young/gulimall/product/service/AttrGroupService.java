package com.young.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.young.gulimall.gulimallcommon.utils.PageUtils;
import com.young.gulimall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-04 15:00:06
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

