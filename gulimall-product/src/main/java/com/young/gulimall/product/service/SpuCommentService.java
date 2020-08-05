package com.young.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.young.common.utils.PageUtils;
import com.young.gulimall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 15:05:49
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

